package org.donghyun.time;

import org.donghyun.common.config.CommonConfig;
import org.donghyun.time.config.TimeConfig;
import org.donghyun.time.mapper.TimeMapper;
import org.donghyun.time.service.TimeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CommonConfig.class , TimeConfig.class})
@Log4j
public class TimeTests {

	@Autowired
	private TimeMapper timeMapper;
	@Autowired
	private TimeService service;
	
	@Test
	public void testExist() {
		log.info(timeMapper);
		log.info(timeMapper.getNow());
	}
	
	@Test
	public void testService() {
		log.info(service.getTime());
	}
	
	
}
