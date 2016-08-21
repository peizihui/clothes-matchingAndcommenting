package cn.clothes.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.clothes.dto.UploadResultBean;
import cn.clothes.entity.User;
import cn.clothes.page.Pagination;
import cn.clothes.service.ClothService;
import cn.clothes.util.Constants;
import cn.clothes.util.Log;
/**
 * 服装api
 * @author clq
 *
 */
@Controller
@RequestMapping("/cloth")
public class ClothController {
	Log log = Log.getLogger(ClothController.class);
	@Autowired
	private ClothService service;
	
	/**
	 * 上传服装信息
	 * @param file
	 * @param content
	 * @param session
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/upload", method = RequestMethod.POST
            ,produces = {"application/json; charset=UTF-8"})
    @ResponseBody
	public Object uploadImage(@RequestPart MultipartFile file, String content, HttpSession session, HttpServletRequest req) {
		Map<String,Object> map = new HashMap<>();
		User user = (User) req.getSession().getAttribute("user");
		UploadResultBean bean = new UploadResultBean();
		if (!file.isEmpty()) {
			try {
				req.getSession().getServletContext().getRealPath("/");
				service.addCloth(file, content, bean, user, req.getSession().getServletContext().getRealPath("/")+"temp/"+file.getName());
				bean.setIsSuccess(Constants.RESULT_IS_SUCCESS);
				map.put("data", bean);
			} catch (IOException e) {
				bean.setIsSuccess(Constants.RESULT_IS_FAIL);
				bean.setCause("服务内部异常");
				e.printStackTrace();
			}
			return map;
        } else {
        	bean.setIsSuccess(Constants.RESULT_IS_FAIL);
        	bean.setContent("缺少必要的参数");
        }
		return map;
	}
	
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String index() {
		return "/cloth/upload";
	}
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String list() {
		return "/cloth/list";
	}
	/**
	 * 达人推荐页面
	 * @param pageNumber
	 * @param pageSize
	 * @param serach
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/query")
	@ResponseBody
	public Object queryCloth(Integer pageNumber, Integer pageSize, String serach, HttpServletRequest req){
		Map<String,Object> map = new HashMap<>();
		if(pageNumber == null) {
			map.put("result", Constants.ABSENCE_NEED_PARAMETER);
			return map;
		}
		User user = (User) req.getSession().getAttribute("user");
		Pagination queryCloth = service.queryCloth(user, pageNumber, pageSize, serach);
		map.put("result", queryCloth);
		return map;
	}
	
	/**
	 * 点赞接口
	 * @param req
	 * @param clothId
	 * @return
	 */
	@RequestMapping(value="/like")
	@ResponseBody
	public Object like(HttpServletRequest req, Long clothId) {
		Map<String, Object> map = new HashMap<>();
		if(clothId == null) {
			map.put("result", Constants.ABSENCE_NEED_PARAMETER);
			return map;
		}
		User user = (User) req.getSession().getAttribute("user");
		try{
			this.service.like(user, clothId);
			map.put("result", "success");
		}catch(Exception e) {
			map.put("result", Constants.SERVER_INTERNAL_ERROR);
			log.error(e);
		}
		return map;
	}
	
	/**
	 * 添加收藏接口
	 * @param req
	 * @param clothId
	 * @return
	 */
	@RequestMapping(value="/collect")
	@ResponseBody
	public Object collect(HttpServletRequest req, Long clothId) {
		Map<String, Object> map = new HashMap<>();
		
		if(clothId == null) {
			map.put("result", Constants.ABSENCE_NEED_PARAMETER);
			return map;
		}
		
		User user = (User) req.getSession().getAttribute("user");
		
		map.put("result", this.service.collect(user, clothId));
		return map;
	}
	
	/**
	 * 详情页
	 * @param req
	 * @param clothId
	 * @return
	 */
	@RequestMapping(value="/detail")
	@ResponseBody
	public Object detail(HttpServletRequest req, Long clothId) {
		Map<String, Object> map = new HashMap<>();
		
		if(clothId == null) {
			map.put("result", Constants.ABSENCE_NEED_PARAMETER);
			return map;
		}
		
		User user = (User) req.getSession().getAttribute("user");
		try{
			map.put("result", this.service.detail(user, clothId));
		}catch(Exception e){
			map.put("result", Constants.SERVER_INTERNAL_ERROR);
			log.error(e);
		}
		return map;
	}
}
