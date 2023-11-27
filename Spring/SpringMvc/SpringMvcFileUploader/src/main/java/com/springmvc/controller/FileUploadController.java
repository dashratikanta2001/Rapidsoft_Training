package com.springmvc.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class FileUploadController {

	@RequestMapping("/fileform")
	public String showUploadForm() {
		return "fileform";
	}

	@RequestMapping(path = "/uploadimage", method = RequestMethod.POST)
	public String FileUpload(@RequestParam("profile") CommonsMultipartFile file, HttpSession s, Model m) {
		System.out.println("FIle upload handler");

		System.out.println(file.getSize());
		System.out.println(file.getContentType());
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getStorageDescription());
//		String fileType = filename.substring(filename.lastIndexOf(".") + 1);
		String fileType = file.getContentType().substring(file.getContentType().lastIndexOf(File.separator) + 1);

		System.out.println("File extension= " + fileType);

		// Get the byte data

		byte[] data = file.getBytes();

		// We have to save this file to server
		String path = s.getServletContext().getRealPath("/") + "WEB-INF" + File.separator + "resources" + File.separator
				+ "image" + File.separator + (int) (Math.random() * 10000000) + "." + fileType;
		System.out.println(path);

		try {
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(data);
			fos.close();
			System.out.println("File uploaded");

			m.addAttribute("msg", "Uploaded successfully");
			m.addAttribute("filename", path.substring(path.lastIndexOf(File.separator) + 1));

		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
			m.addAttribute("msg", "Uploading error");

			System.out.println("Uploading error");
		}

		return "filesuccess";
	}
}
