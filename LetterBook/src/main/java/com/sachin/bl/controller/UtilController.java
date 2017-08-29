package com.sachin.bl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UtilController {

	@RequestMapping(value = "/help")
	public String help() {

		return "/user/help";
	}

	@RequestMapping(value = "/contact")
	public String contact() {

		return "/user/contact";
	}
}
