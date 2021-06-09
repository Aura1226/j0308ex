package org.donghyun.time.controller;

import org.donghyun.time.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/time")
@RequiredArgsConstructor
@Log4j
public class TimeController {

	private final TimeService service;
	
	@GetMapping("/now")
	public void getTime(Model model) {
		log.info("time.................");
		log.info(service.getTime());
		
		model.addAttribute("time", service.getTime());
	}
}
