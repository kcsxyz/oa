package com.oa.controller.deptOffice;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oa.bean.Dept;
import com.oa.bean.Notice;
import com.oa.bean.Project;
import com.oa.bean.ResponseResult;
import com.oa.dao.ProjectMapper;
import com.oa.service.deptOffice.ProjectManageService;

@Controller
@RequestMapping("/project")
public class ProjectManageController {
  @Resource
  private ProjectManageService projectManageService;
  
  
 
   @RequestMapping(value="/pushProject", method=RequestMethod.GET)
	public String pushProject(
			HttpSession session,
			Model model,
			String projectName,
			Project project
			) {
	   String createName = (String) session.getAttribute("uid");
	   project.setProjectName(projectName);
	   project.setCreateName(createName);
	   project.setCreateTime(new Date());
	   projectManageService.insertSelective(project);
		return "redirect:/project/selectByParams";
	}
  
	/**根据id删除部门
	 * @param ids
	 * @return
	 */
	 @RequestMapping("/deleteProject/{ids}")
	public String deleteDept(@PathVariable("ids") String ids) {
		// 批量刪除
		if (ids.contains("-")) {
			List<Integer> listId = new ArrayList<>();
			String[] split_ids = ids.split("-");
			for (String string : split_ids) {
				listId.add(Integer.parseInt(string));
				projectManageService.deleteDeptBatch(listId);
			}
		// 单个删除
		} else {
			Integer id = Integer.parseInt(ids);
			projectManageService.deleteByPrimaryKey(id);
				}
		return "redirect:/project/selectByParams";	
	}
		
		/**
		 * 通过id查询
		 * @return
		 */
		@RequestMapping("/findByprojectId/{projectId}")
		@ResponseBody
		public String findBynoticeId(@PathVariable Integer projectId,Model model) {
			 Project project = projectManageService.selectByPrimaryKey(projectId);
			 model.addAttribute("projectFindById",project);
			return "SUCCESS";
		
		}
	 /**
	  * 修改
	  * @param session
	  * @param projectId
	  * @param projectName
	  * @param project
	  * @return
	  */
	 @RequestMapping("/updateProject")
	 public String updateProject(
			 HttpSession session,
			 Integer projectId,
			 String projectName,
			 Project project
			 ) {
		  String createName = (String) session.getAttribute("uid");
		   project.setProjectId(projectId);
		   project.setProjectName(projectName);
		   project.setCreateName(createName);
		   project.setCreateTime(new Date());
		   projectManageService.updateByPrimaryKeySelective(project);
		  return "redirect:/project/selectByParams";
		 
	 }
		/**
		 * 模糊查询
		 * @return
		 * @throws ParseException 
		 */
	@RequestMapping("/selectByParams")
	 public String findProject(
			 HttpSession session,
				String Info,
				String dateStart,
				String finalTime,
				@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
				@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
	            Model model
			 ) throws ParseException {
		 PageHelper.startPage(pageNo, pageSize);
		 List<Project> projects =  projectManageService.selectByExample(Info, dateStart, finalTime);
		 PageInfo<Project> page = new PageInfo<Project>(projects, 3);
			model.addAttribute("pageInfo", page);
		 return "projectManagement";
	 }
	
}
