package com.blog.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.blog.payload.FileResponse;
import com.blog.services.FileService;

@RestController
@RequestMapping("/file")
public class FileController {

	@Autowired
	private FileService fileService;

	@Value("${project.image}")
	private String path;

	@PostMapping("/upload")
	public ResponseEntity<?> fileUpload(@RequestParam("image") MultipartFile image) throws IOException {
		String fileName;
		System.out.println("Image = " +image);
		
		if (image.getContentType() == null) {
			return new ResponseEntity<>(new FileResponse(null, "Choose any image."), HttpStatus.BAD_REQUEST);
		}

		fileName = this.fileService.uploadImage(path, image);
		return new ResponseEntity<>(new FileResponse(fileName, "Image is successfully uploaded"), HttpStatus.OK);
	}

}
