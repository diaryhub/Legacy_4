package com.study.s1.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	@Autowired
	private ServletContext servletContext;
	
	public boolean remove(String path,String fileName) throws Exception {
		//파일을 HDD에서 삭제
		//저장된 폴더명, 저장된 파일명
		path = servletContext.getRealPath(path);
		File file = new File(path,fileName);
		return file.delete();
		
	}
	
	public String save(MultipartFile multipartFile,String path) throws Exception{
		//파일저장은 tomcat이 아니라 OS에서 저장
		//path=/resources/upload/member
		String realPath=servletContext.getRealPath(path);
		System.out.println(realPath);
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		//1. 시간
		Calendar calendar = Calendar.getInstance();
		long l = calendar.getTimeInMillis();
		System.out.println("time : " + l);
		String oriName = multipartFile.getOriginalFilename();
		String fileName = l+"_"+oriName;
		System.out.println("fileName :"+fileName);
		
		//2. UUID
		fileName = UUID.randomUUID().toString();
		fileName = fileName +"_"+oriName;
		System.out.println("UUID: "+fileName);
		
//		file = new File(realPath, fileName);
//		multipartFile.transferTo(file);
		file = new File(file,fileName);
		FileCopyUtils.copy(multipartFile.getBytes(),file);
		
		
		
		return fileName;
	}
	
}
