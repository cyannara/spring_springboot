package com.yedam.board.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.yedam.board.service.Criteria;
import com.yedam.board.service.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@ExtendWith(SpringExtension.class) 
@ContextConfiguration("file:src/main/resources/spring/*-context.xml")
public class ReplyMapperTests {

	// 테스트 전에 해당 번호의 게시물이 존재하는지 반드시 확인할 것
	private Long[] bnoArr = { 21L, 22L, 23L, 24L, 25L };

	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;

	@Test
	public void testCreate() {
		IntStream.rangeClosed(1, 10).forEach(i -> {

			ReplyVO vo = new ReplyVO();

			// 게시물의 번호
			vo.setBno(bnoArr[i % 5]);
			vo.setReply("댓글 테스트 " + i);
			vo.setReplyer("replyer" + i);

			mapper.insert(vo);
		});
	}

	@Test
	public void testCreate2() {
		ReplyVO vo = new ReplyVO();

		// 게시물의 번호
		vo.setBno(20L);
		vo.setReply("댓글 테스트 " );
		vo.setReplyer("replyer" );

		mapper.insert(vo);
	}

	@Test
	public void testRead() {
		Long targetRno = 5L;
		ReplyVO vo = mapper.read(targetRno);
		log.info(vo);
	}

	@Test
	public void testMapper() {
		log.info(mapper);
	}

	@Test
	public void testDelete() {
		Long targetRno = 1L;
		mapper.delete(targetRno);
	}

	@Test
	public void testUpdate() {
		Long targetRno = 10L;
		ReplyVO vo = mapper.read(targetRno);
		vo.setReply("Update Reply ");
		int count = mapper.update(vo);
		log.info("UPDATE COUNT: " + count);
	}

	@Test
	public void testList() {
		Criteria cri = new Criteria();
		// 10L
		List<ReplyVO> replies = mapper.getList(cri, bnoArr[0]);
		replies.forEach(reply -> log.info(reply));
	}
	
	@Test
	public void testList2() {
		Criteria cri = new Criteria(2, 10);
		// 10L
		List<ReplyVO> replies = mapper.getList(cri, 10L);
		replies.forEach(reply -> log.info(reply));
	}

}
