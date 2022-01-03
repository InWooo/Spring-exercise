package org.conan.persistence;

import java.util.List;

import org.conan.domain.Criteria;
import org.conan.domain.ReplyVO;
import org.conan.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Data
@Log4j
public class ReplyServiceImpl implements ReplyService {
	@Setter(onMethod_= @Autowired)
	private ReplyMapper remapper;

	@Override
	public int register(ReplyVO vo) {
		// TODO Auto-generated method stub
		log.info("insert : "+vo);
		return remapper.insert(vo);
	}

	@Override
	public ReplyVO get(Long rno) {
		// TODO Auto-generated method stub
		log.info("get : "+rno);
		return remapper.read(rno);
	}

	@Override
	public int remove(Long rno) {
		// TODO Auto-generated method stub
		log.info("remove : "+rno);
		return remapper.delete(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		// TODO Auto-generated method stub
		log.info("modify : "+vo);
		return remapper.update(vo);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {
		// TODO Auto-generated method stub
		log.info("getList : "+bno);
		return remapper.getListWithPaging(cri,bno);
	}

}
