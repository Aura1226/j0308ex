package org.donghyun.board.mapper;

import org.donghyun.board.config.BoardConfig;
import org.donghyun.board.domain.Board;
import org.donghyun.board.mapper.BoardMapper;
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
public class BoardMapperTests {

	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void testInsert() {
		Board vo = Board.builder().title("mapper �׽�Ʈ").content("content �׽�Ʈ").writer("writer �׽�Ʈ").build();
		
		mapper.insert(vo);
	}
	
	@Test
	public void testRead() {
		log.info(mapper.read(3));
	}
	
}
