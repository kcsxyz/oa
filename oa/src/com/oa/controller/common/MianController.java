package com.oa.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("mian")
public class MianController {
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	

}
