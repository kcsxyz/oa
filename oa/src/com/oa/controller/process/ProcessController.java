package com.oa.controller.process;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("process")
public class ProcessController {
	
	/**跳转到请假页面
	 * @return
	 */
	@RequestMapping("/leavePage")
	public String leavePage() {
		
		return "process/leave";
	}
	
}
