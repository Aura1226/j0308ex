package org.donghyun.board.controller;



import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.donghyun.board.config.BoardConfig;
import org.donghyun.board.domain.Board;
import org.donghyun.board.dto.PageDTO;
import org.donghyun.common.config.CommonConfig;
import org.donghyun.common.config.ServletConfig;
import org.donghyun.time.config.TimeConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CommonConfig.class , BoardConfig.class , ServletConfig.class , TimeConfig.class})
@Log4j
@WebAppConfiguration
public class BoardControllerTests {
	
	@Autowired
	WebApplicationContext ctx;
	MockMvc mockMvc;


	//��¥ MVC �غ�
		@Before
		public void setup() {
			this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
			log.info("set up.......");
		}
		
		@Test
		public void testGetList()throws Exception {
			log.info(mockMvc);
			
			mockMvc.perform(MockMvcRequestBuilders.get("/board/list")
					.param("page" , "3")
					.param("perSheet", "10")).andDo(print());
		
		}
		
		@Test
		public void testPostRegister()throws Exception {
			Board board = Board.builder().title("test").content("test").writer("test").build();
			String title = board.getTitle();
			String content = board.getContent();
			String writer = board.getWriter();
			
			log.info("register..........");
			
			mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
					.param("title", title)
					.param("content", content)
					.param("writer", writer)).andDo(print());
		
		}
		
}
