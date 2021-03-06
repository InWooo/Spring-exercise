package org.conan.service;

import org.apache.ibatis.annotations.Param;
import org.conan.domain.Criteria;
import org.conan.domain.ReplyPageDTO;
import org.conan.domain.ReplyVO;


public interface ReplyService {
	public int register(ReplyVO vo);
	public ReplyVO get(Long rno);
	public int remove (Long rno);
	public int modify(ReplyVO vo);
	public ReplyPageDTO getListPage(
			@Param("cri") Criteria cri,
			@Param("bno") Long bno);
}
