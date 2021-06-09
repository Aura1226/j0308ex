package org.donghyun.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.donghyun.board.domain.Board;
import org.donghyun.board.dto.BoardDTO;

public interface BoardMapper {

	public List<Board> getList(@Param("skip") int skip , @Param("count") int count);
	
	public int getTotalCount();
	
	public Board read(int bno);
	
	void insert (Board board);
	
	boolean delete(int bno);
	
	boolean update(BoardDTO boardDTO);
	
	
}
