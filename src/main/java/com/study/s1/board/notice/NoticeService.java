package com.study.s1.board.notice;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.study.s1.board.BoardDTO;
import com.study.s1.board.BoardService;
import com.study.s1.util.FileManager;
import com.study.s1.util.Pager;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private FileManager fileManager;
	
	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		pager.makeRow();
		pager.makenNum(noticeDAO.total(pager));
		return noticeDAO.list(pager);
	}
	
	public NoticeFileDTO detailFile(NoticeFileDTO noticeFileDTO) throws Exception{
		return noticeDAO.detailFile(noticeFileDTO);
	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.detail(boardDTO);
	}
	public int add(BoardDTO boardDTO,MultipartFile [] files) throws Exception {
		// long num = noticeDAO.seqNum();
		// boardDTO.setNum(num);
		int result = noticeDAO.add(boardDTO);
		for(int i=0;i<files.length;i++) {
			if(files[i].isEmpty()) {
				continue;
			}
			String fileName = fileManager.save(files[i], "resources/upload/notice/");
			NoticeFileDTO noticeFileDTO = new NoticeFileDTO();
			noticeFileDTO.setNum(boardDTO.getNum());
			noticeFileDTO.setFileName(fileName);
			noticeFileDTO.setOriName(files[i].getOriginalFilename());
			result = noticeDAO.addFile(noticeFileDTO);
		}
		return result; 
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.update(boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		List<NoticeFileDTO> ar = noticeDAO.listFile(boardDTO);
		int result = noticeDAO.delete(boardDTO);
		if (result>0) {
//			for(int i=0;i<ar.size();i++){
//				ar.get(i);
//			}
			//for(collection에서 꺼낼타빙명 변수명 : collection의 변수명){}
			for(NoticeFileDTO dto:ar) {
				
				fileManager.remove("resources/upload/notice/", dto.getFileName());
			}
		}
		return result;
	}



	



	
}
