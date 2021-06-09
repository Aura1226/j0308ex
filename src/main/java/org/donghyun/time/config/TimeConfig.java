package org.donghyun.time.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import lombok.extern.log4j.Log4j;

@Configuration
@MapperScan(basePackages = {"org.dongho.time.mapper"})
@ComponentScan(basePackages = {"org.dongho.time.service"})
@Log4j
public class TimeConfig {

}
