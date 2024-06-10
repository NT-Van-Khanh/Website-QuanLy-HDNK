package qlhdnk.controller;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadFileController {
	@Autowired
	ServletContext context;
	
	@RequestMapping("upload-file")
	public String apply( ModelMap model,  @RequestParam("photo") MultipartFile photo) {
		if(photo.isEmpty()) {
			model.addAttribute("message","Vui lòng chọn file!");
		}else {
			try {
				String photoPath = context.getRealPath("resoures/files/"+photo.getOriginalFilename());
				photo.transferTo(new File(photoPath));
								
				model.addAttribute("photo_name",photo.getOriginalFilename());
				model.addAttribute("photo_type",photo.getContentType());
				model.addAttribute("photo_size",photo.getSize());
				
				return "upload";
			}catch(Exception e) {
				model.addAttribute("message","Loi luu file!");
			}
		}
		return "upload";
	}
}
