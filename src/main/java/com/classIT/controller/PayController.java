package com.classIT.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.classIT.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequiredArgsConstructor
public class PayController {

	@PostMapping("/pay")
	public String pay(String msg, Model model) {
		
		return "/pay/success";

	}
	
}
