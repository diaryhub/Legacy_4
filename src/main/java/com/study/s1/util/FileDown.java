package com.study.s1.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.study.s1.file.FileDTO;

@Component
public class FileDown extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("File Down 실행");
		FileDTO fileDTO = (FileDTO)model.get("file");
		System.out.println(fileDTO.getFileName());
		System.out.println(fileDTO.getOriName());
		String board = (String)model.get("board");
		String path = "/resources/upload/"+board+"/";
		//내장 객체는 다른 영역의 내장 객체를 불러올 수 있음
		//단, 좁은 영역에서 큰 영역으로 가능, 반대는 불가
		
		ServletContext sc = request.getSession().getServletContext();
		path = sc.getRealPath(path);
		File file = new File(path, fileDTO.getFileName());
		System.out.println(file.exists());
		System.out.println(file.isFile());
		// 인코딩 처리
		response.setCharacterEncoding("UTF-8");
		// 총 파일 크기
		response.setContentLength((int)file.length());
		// 다운로드 시 파일 이름 인코딩
		String fileName=URLEncoder.encode(fileDTO.getOriName(),"UTF-8");
		// header 설정
		response.setHeader("Content-Disposition", "attachment;fileName=\""+fileName);
		response.setHeader("Content-Transfer-Encording", "binary");
		//hdd에서 파일 읽어서 client로 전송 연결 준비
		FileInputStream f1 = new FileInputStream(file);
		OutputStream os = response.getOutputStream();
		//최종 전송
		FileCopyUtils.copy(f1, os);
		
	}
}
