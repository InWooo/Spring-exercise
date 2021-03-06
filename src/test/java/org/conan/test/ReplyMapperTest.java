package org.conan.test;

import java.util.List;
import java.util.stream.IntStream;

import org.conan.domain.Criteria;
import org.conan.domain.ReplyVO;
import org.conan.persistence.ReplyMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTest { 
   @Setter(onMethod_ = @__({ @Autowired }))
   private ReplyMapper remapper;
   
   @Test
   public void testMapper() {
	   log.info(remapper);
   }
   
   private Long[]bnoArr= {3L,4L,7L,8L,11L};
   @Test
   public void testCreate() {
      IntStream.rangeClosed(1, 10).forEach(i -> {
         ReplyVO vo = new ReplyVO();
         vo.setBno(bnoArr[i % 5]);
         vo.setReply("댓글 테스트 " + i);
         vo.setReplyer("replyer" + i);
         remapper.insert(vo);
      });
   }
   @Test
   public void testRead() {
	   Long TargetRno = 1L;
	   ReplyVO vo = remapper.read(TargetRno);
	   log.info(vo);
   }
   
   @Test
   public void testDelete() {
	   Long targetRno = 1L;
	   remapper.delete(targetRno);
   }
   
   @Test
   public void testUpdate() {
	   Long targetRno = 10L;
	   ReplyVO vo = remapper.read(targetRno);
	   vo.setReply("Update Reply");
	   int count = remapper.update(vo);
	   log.info("Update Count : " + count);
   }
   @Test
   public void testList() {
	   Criteria cri = new Criteria();
	   List<ReplyVO> replies = remapper.getListWithPaging(cri,bnoArr[0]);
	   replies.forEach(reply->log.info(reply));
   }
   
   @Test
   public void testList2() {
	   Criteria cri = new Criteria(2,5);
	   List<ReplyVO>replies = remapper.getListWithPaging(cri, 22L);
	   replies.forEach(reply->log.info(reply));
   }
   
}
