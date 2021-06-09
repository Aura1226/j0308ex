package org.donghyun.board.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "org.donghyun.board.mapper")
@ComponentScan(basePackages = "org.donghyun.board.service")
public class BoardConfig {

}
