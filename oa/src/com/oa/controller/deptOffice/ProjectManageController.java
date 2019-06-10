package com.oa.controller.deptOffice;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oa.dao.ProjectMapper;

@Controller
@RequestMapping("/project")
public class ProjectManageController {
  @Resource
  private ProjectMapper projectMapper;
}
