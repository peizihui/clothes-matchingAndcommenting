package cn.clothes.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.clothes.service.ClothService;
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
	public Object uploadImage(@RequestPart MultipartFile file, String content) {
		if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(file.getName() + "-uploaded")));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded " + file.getName() + " into " + file.getName() + "-uploaded !";
            } catch (Exception e) {
                return "You failed to upload " + file.getName() + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + file.getName() + " because the file was empty.";
        }
	}
	
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String index() {
		return "upload";
	}
}
