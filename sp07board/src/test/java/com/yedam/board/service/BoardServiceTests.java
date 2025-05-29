package com.yedam.board.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.yedam.board.service.BoardService;
import com.yedam.board.service.BoardVO;
import com.yedam.board.service.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@ExtendWith(SpringExtension.class) 
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
// Java Config
// @ContextConfiguration(classes = {org.zerock.config.RootConfig.class} )
@Log4j2
public class BoardServiceTests {

	@Setter(onMethod_ = { @Autowired })
	private BoardService service;

	@Test
	public void testExist() {

		log.info(service);
		assertNotNull(service);
	}

	@Test
	public void testRegister() {

		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");

		service.register(board);

		log.info("생성된 게시물의 번호: " + board.getBno());
	}

	@Test
	public void testGetList() {

		// service.getList().forEach(board -> log.info(board));
		service.getList(new Criteria(2, 10)).forEach(board -> log.info(board));
	}

	@Test
	public void testGet() {

		log.info(service.get(1L));
	}

	@Test
	public void testDelete() {

		// 게시물 번호의 존재 여부를 확인하고 테스트할 것
		log.info("REMOVE RESULT: " + service.remove(2L));

	}

	@Test
	public void testUpdate() {

		BoardVO board = service.get(1L);

		if (board == null) {
			return;
		}

		board.setTitle("제목 수정합니다.");
		log.info("MODIFY RESULT: " + service.modify(board));
	}

}
