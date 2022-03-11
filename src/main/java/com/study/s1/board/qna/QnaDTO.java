package com.study.s1.board.qna;

import java.util.List;

import com.study.s1.board.BoardDTO;

public class QnaDTO extends BoardDTO{
	
	private Long ref;
	private Long step;
	private Long depth;
	private List<QnaFileDTO> FileDTOs;
	
	
	public List<QnaFileDTO> getFileDTOs() {
		return FileDTOs;
	}
	public void setFileDTOs(List<QnaFileDTO> fileDTOs) {
		FileDTOs = fileDTOs;
	}
	public Long getRef() {
		return ref;
	}
	public void setRef(Long ref) {
		this.ref = ref;
	}
	public Long getStep() {
		return step;
	}
	public void setStep(Long step) {
		this.step = step;
	}
	public Long getDepth() {
		return depth;
	}
	public void setDepth(Long depth) {
		this.depth = depth;
	}
	
}