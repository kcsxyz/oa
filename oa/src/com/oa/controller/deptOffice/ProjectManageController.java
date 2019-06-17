package com.oa.controller.deptOffice;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

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
import com.oa.bean.User;
import com.oa.dao.ProjectMapper;
import com.oa.service.deptOffice.ProjectManageService;

@Controller
@RequestMapping("/project")
public class ProjectManageController {
  @Resource
  private ProjectManageService projectManageService;
  
  
 
   @RequestMapping(value="/pushProject", method=RequestMethod.GET)
   @ResponseBody
	public ResponseResult pushProject(
			HttpSession session,
			Model model,
			String projectName,
			Project project
			) {
	   ResponseResult rr = new ResponseResult();
	   User user = (User)session.getAttribute("user");
	   String createName = user.getUid();
	   project.setProjectName(projectName);
	   project.setCreateName(createName);
	   project.setCreateTime(new Date());
	   int i = projectManageService.insertSelective(project);
	   if(i!=0) {
		   rr.setStateCode(1);
		   rr.setMessage("创建成功");
	   }else {
		   rr.setStateCode(0);
			rr.setMessage("创建失败");
	   }
		return rr;
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
		  User user = (User)session.getAttribute("user");
		  String createName = user.getUid();
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
	
	/**
	 * 验证用户名是否存在
	 * @param username
	 * @return
	 */
    @RequestMapping(value = "/checkProjectName")
	// 使用这个是不走视图解析器
	@ResponseBody
	public ResponseResult checkUserByUserName(@PathParam("projectName")String projectName) {// 保持这里的参数前面参数的一致就可以传递过来
		ResponseResult rr = new ResponseResult();
		int b = projectManageService.checkProjectByname(projectName);
		if (b == 1) {
			rr.setStateCode(0);
			rr.setMessage("项目名已存在");
		} else {
			rr.setStateCode(1);
			rr.setMessage("项目名可用");
		}
		return rr;
	}
	
}
