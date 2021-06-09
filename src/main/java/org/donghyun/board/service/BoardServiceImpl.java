package org.donghyun.board.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.donghyun.board.domain.Board;
import org.donghyun.board.dto.BoardDTO;
import org.donghyun.board.dto.PageDTO;
import org.donghyun.board.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@RequiredArgsConstructor
@Log4j
public class BoardServiceImpl implements BoardService {

	private final BoardMapper mapper;
	

	@Override
	public int getTotalCount() {
		log.info(mapper.getTotalCount());
		
		return mapper.getTotalCount();
		
	}
	
	@Override
	public List<BoardDTO> getList(PageDTO pageDTO){
		
		return mapper.getList(pageDTO.getSkip(), pageDTO.getPerSheet()).stream().map(board -> {
			return toDTO(board);
		}).collect(Collectors.toList());
		
	}
	

	@Override
	public void insert(Board board) {
		
		mapper.insert(board);
		
	}

	@Override
	public Board read(int bno) {
		return mapper.read(bno);	
	}
	
	
	

	


	

}
