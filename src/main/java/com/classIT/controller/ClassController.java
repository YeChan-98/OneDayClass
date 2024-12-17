package com.classIT.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequiredArgsConstructor
@RequestMapping("/")
public class ClassController {
	
	@GetMapping("/class")
	public void get(@RequestParam("product_no") Long product_no, Model model) {
		
		model.addAttribute("class", product_no);
	}
}
