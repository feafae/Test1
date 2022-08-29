package net.softsociety.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

	/**
	 * 상품게시판 관련 콘트롤러
	 */
	@GetMapping({"","/"})
	public String home() {
		return "home";
	}
	
}
