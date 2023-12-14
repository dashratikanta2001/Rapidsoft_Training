package com.blog.services.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.blog.exception.ImageFormatNotSupportException;
import com.blog.services.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException{
		// TODO Auto-generated method stub
		
		if(CheckImage(file.getContentType()))
		{
		
		//File name
		String name = file.getOriginalFilename();
		
		//Random name generator
		String randomId  = UUID.randomUUID().toString();
		
		String fileName1 = randomId.concat(name.substring(name.lastIndexOf(".")));
		
		
		//Full path
		String filePath = path+File.separator+fileName1;
		
		
		//create folder if not created
		
		File f = new File(path);
		
		if(!f.exists())
		{
			f.mkdir();
		}
		
		//file copy
		
		Files.copy(file.getInputStream(), Paths.get(filePath));
		
		
		return name;
		}
		else {
			throw new ImageFormatNotSupportException(file.getContentType().substring(file.getContentType().lastIndexOf("/")).replaceFirst("/", "."));

		}	
	}
	
	
	
	
	
	private boolean CheckImage(String contentType)
	{
		boolean isImage = contentType !=null &&(
				contentType.startsWith("image/jpeg") ||
				contentType.startsWith("image/jpg") ||
				contentType.startsWith("image/png") ||
				contentType.startsWith("image/gif") ||
				contentType.startsWith("image/bmp") ||
				contentType.startsWith("image/tiff") ||
				contentType.startsWith("image/webp") ||
				contentType.startsWith("image/sgv+xml")
				);
		
		return isImage;
	}

}
