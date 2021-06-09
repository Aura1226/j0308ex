package org.donghyun.board.controller;

import javax.validation.Valid;

import org.donghyun.board.domain.Board;
import org.donghyun.board.dto.BoardDTO;
import org.donghyun.board.dto.PageDTO;
import org.donghyun.board.service.BoardService;
import org.donghyun.common.dto.PageMaker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
@Log4j
public class BoardController {

	private final BoardService service;
	
	@GetMapping({"/list" , "/"})
	public String getList(@ModelAttribute("pageDTO") PageDTO pageDTO,Model model) {
		model.addAttribute("list" , service.getList(pageDTO));
										// �͸�Ŭ���� -> �� ������ϰ� �������
		model.addAttribute("pageMaker" , new PageMaker(pageDTO , service.getTotalCount()));
		
		return "/board/list";
	}
	
	@GetMapping("/register")
	public void register() {
		log.info("register....");
	}
	
	@PostMapping(value = "/register" , produces = {"text/plain"})
	@ResponseBody
	public ResponseEntity<String> registerPost( @Valid BoardDTO boardDTO , BindingResult result) {
			
		if(result.hasErrors()) {
			log.info(result.getAllErrors());
			
			return new ResponseEntity<String>("fail" , HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		log.info(boardDTO);
//		Board vo = service.toDomain(boardDTO);
//		log.info(vo);
//		service.insert(vo);
		

		return new ResponseEntity<String>("success" , HttpStatus.OK);
	}
	
	@GetMapping(value = "/read?")
	public void read() {
		
	}
}
