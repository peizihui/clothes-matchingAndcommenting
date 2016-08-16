package cn.clothes.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.clothes.dto.UploadResultBean;
import cn.clothes.entity.User;
import cn.clothes.service.ClothService;
import cn.clothes.util.Constants;
/**
 * 服装api
 * @author clq
 *
 */
@Controller
@RequestMapping("/cloth")
public class ClothController {
	
	@Autowired
	private ClothService service;
	
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
}
