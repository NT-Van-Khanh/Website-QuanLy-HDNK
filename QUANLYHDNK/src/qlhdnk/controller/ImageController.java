package qlhdnk.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ImageController {
	
	private byte[] byteImage;
	
	public byte[] getByteImage() {
		return byteImage;
	}
	
	public void setByteImage(byte[] byteImage) {
		this.byteImage = byteImage;
	}
	
	@RequestMapping(value= "/image/{userAvatarBase64}",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<byte[]> getImage(){
		if(byteImage!=null) {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.IMAGE_PNG);
			return new ResponseEntity<>(byteImage, headers, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
}
