package com.oa.controller.system;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("system")
public class DeptController {
	
	
	@RequestMapping("/deptManange")
	public String deptManange() {

		return "/deptManange";
	}
}
