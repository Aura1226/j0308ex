package org.donghyun.time.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

	@Select("select now()")
	public String getNow();
}
