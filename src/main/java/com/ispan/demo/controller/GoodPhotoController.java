package com.ispan.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ispan.demo.model.GoodPhoto;
import com.ispan.demo.service.GoodPhotoService;

@Controller
public class GoodPhotoController {
	
	@Autowired
	private GoodPhotoService gService;
	
	@GetMapping("/newPhoto")
	public String newPhotoPage() {
		return "goodphoto/uploadPage";
	}
	
	@PostMapping("/fileUpload")
	public String postNewPhoto(@RequestParam("photoName") String name,
			                   @RequestParam("file") MultipartFile file ) {
		GoodPhoto goodphoto = new GoodPhoto();
		
		try {
			goodphoto.setPhotoName(name);
			goodphoto.setPhotoFile(file.getBytes());
			
			gService.insertGoodPhoto(goodphoto);
			
			return "goodphoto/uploadSuccessPage";
		} catch (IOException e) {
			
			e.printStackTrace();
			return "redirect:/";
		}
		
	}
	
	@GetMapping("/listGoodPhoto")
	public String listPhotoPage(Model model) {
		List<GoodPhoto> list = gService.listGoodPhoto();
		
		model.addAttribute("goodPhotoList", list);
		
		return "goodphoto/listPhoto";
	}
	
	@GetMapping("/downloadImage/{id}")
	public ResponseEntity<byte[]> downloadImg(@PathVariable("id") Integer id){
		GoodPhoto photo1 = gService.getPhotoById(id);
		
		byte[] photoFile = photo1.getPhotoFile();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		
		                               // 要回傳的物件, headers, httpstatus 回應
		return new ResponseEntity<byte[]>(photoFile,headers,HttpStatus.OK);
	}

}
