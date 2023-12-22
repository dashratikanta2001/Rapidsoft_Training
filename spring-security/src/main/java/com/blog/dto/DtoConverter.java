package com.blog.dto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class DtoConverter{

	@Autowired
	private static ModelMapper modelMapper;
	
	public static Object entityDtoConverter(Object entity, Class<?> dto)
	{
		
		System.out.println("Entity = "+entity);
		
		System.out.println("dto = "+dto);
		
//		Object map = modelMapper.map(entity, dto.getClass());
		
		return null;
	}
	
}
