package org.donghyun.board.service;

import org.donghyun.board.config.BoardConfig;
import org.donghyun.board.domain.Board;
import org.donghyun.board.dto.PageDTO;
import org.donghyun.board.mapper.BoardMapper;
import org.donghyun.board.service.BoardService;
import org.donghyun.common.config.CommonConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CommonConfig.class , BoardConfig.class})
@Log4j
public class BoardServiceTests {

	@Autowired
	private BoardMapper mapper;
	@Autowired
	private BoardService service;
	
	@Test
	public void testList() {
//		mapper.getList(10,10).forEach(b -> log.info(b));
		
		PageDTO pageDTO = PageDTO.builder().page(4).perSheet(10).build();
		
		service.getList(pageDTO).forEach(b -> log.info(b));
		
		service.getTotalCount();
	}
	
	@Test
	public void testInsert() {
		
		Board vo = Board.builder().title("mapper �׽�Ʈ").content("content �׽�Ʈ").writer("writer �׽�Ʈ").build();
		
		service.insert(vo);
	}
	
	@Test
	public void testRead() {
		log.info(service.read(3));
	}
	
	@Test
	public void testUpdate() {
//		mapper.update();
	}
	
	@Test
	public void testDelete() {
//		mapper.delete();
	}
	
}
