package com.study.s1.board.notice;

import com.study.s1.board.BoardDTO;

public class NoticeDTO extends BoardDTO{
	
	private NoticeFileDTO noticeFileDTO;

	public NoticeFileDTO getNoticeFileDTO() {
		return noticeFileDTO;
	}

	public void setNoticeFileDTO(NoticeFileDTO noticeFileDTO) {
		this.noticeFileDTO = noticeFileDTO;
	}
}
