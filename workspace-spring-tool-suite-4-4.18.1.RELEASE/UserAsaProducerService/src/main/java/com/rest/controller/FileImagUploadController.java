package com.rest.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
public class FileImagUploadController {
	@PostMapping("/upload-file")
	public String uploadImage(@RequestParam("file") MultipartFile file) throws Exception{
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getName());//type of the file
		System.out.println(file.getContentType());
		System.out.println(file.getSize());
		//now i need a path to store my data
		String pathdirectory="C:\\Users\\P1357960\\Documents\\workspace-spring-tool-suite-4-4.18.1.RELEASE\\UserAsaProducerService\\src\\main\\resources\\static\\image";
		//now i want to store the data in this path
//		String pathdirectory=new ClassPathResource("static/image/").getFile().getAbsolutePath();
		Files.copy(file.getInputStream(), Paths.get(pathdirectory+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
		
		return "successfully Image is uploaded";
	}
}
