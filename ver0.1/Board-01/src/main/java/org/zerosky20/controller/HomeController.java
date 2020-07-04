package org.zerosky20.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerosky20.utils.CurrentInfo;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value = {"/"})
@Slf4j
public class HomeController {

	@GetMapping(value = {"", "home"})
	public String home() {
		log.info("KANG-20200618 >>>>> {}", CurrentInfo.get());
		return "home";
	}
}