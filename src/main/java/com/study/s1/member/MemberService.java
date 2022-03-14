package com.study.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.study.s1.util.FileManager;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private FileManager fileManager;
	
	public MemberFileDTO detailFile(MemberFileDTO memberFileDTO)throws Exception {
		return memberDAO.detailFile(memberFileDTO);
	}
	
	public int join(MemberDTO memberDTO,MultipartFile photo) throws Exception {
		int result = memberDAO.join(memberDTO);
		String fileName = fileManager.save(photo, "resources/upload/member/");
		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setId(memberDTO.getId());
		memberFileDTO.setFileName(fileName);
		memberFileDTO.setOriName(photo.getOriginalFilename());
		result = memberDAO.addFile(memberFileDTO);
		return result; // memberDAO.join(memberDTO);
	}
	
	
	public MemberDTO login(MemberDTO memberDTO) throws Exception {
		return memberDAO.login(memberDTO);
	}
	public MemberDTO mypage(MemberDTO memberDTO) throws Exception {
		return memberDAO.mypage(memberDTO);
	}
	public int update(MemberDTO memberDTO) throws Exception {
		return memberDAO.update(memberDTO);
	}
}
