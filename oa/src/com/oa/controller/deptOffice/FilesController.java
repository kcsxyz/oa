package com.oa.controller.deptOffice;

import java.io.*;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oa.bean.Files;
import com.oa.bean.Project;
import com.oa.bean.ResponseResult;
import com.oa.bean.User;
import com.oa.service.deptOffice.FilesService;
@Controller
@RequestMapping("files")
public class FilesController {
	   @Resource
	   private FilesService filesService;
	   
	   /**
	       * 上传文件
	    * @param model
	    * @return
	    */
	    @RequestMapping("/showUpload")
	    public String showUpload(Model model) {
	    	model.addAttribute(new Files());
			return "testFile";
	    	
	    }
	    @RequestMapping(value="/upload",method=RequestMethod.POST)  
	    public String upload(MultipartFile file,
	    		Files files,
	    		Integer project,
	    		String descr,
	    		HttpServletRequest request) throws IOException{  
	    	ResponseResult rr = new ResponseResult();
	    	if(!file.isEmpty()) {
	        String path = request.getSession().getServletContext().getRealPath("upload");  
	        String fileName = file.getOriginalFilename(); 
	        String filesName = fileName.substring(0,fileName.lastIndexOf("."));
	        File dir = new File(path,fileName);          
	        if(!dir.exists()){  
	            dir.mkdirs();  
	        }  
	        //System.out.println(path+fileName);
	        String[] strArray = fileName.split("\\.");
	        int suffixIndex = strArray.length -1;
	        String type = strArray[suffixIndex];
	        System.out.println(strArray[suffixIndex]);
	        User user = (User) request.getSession().getAttribute("user");
	        String uploadUser = user.getUid();
	        String size = String.valueOf(fileName.length());
	        file.transferTo(dir);  
	        files.setUploadUser(uploadUser);
            files.setFileName(filesName);
            files.setCreateTime(new Date());
            files.setFileSize(size);
            files.setFileType(type);
            filesService.insertSelective(files);
           
    		return  "redirect:/files/findAll";
	        } 
			return  "false";
	    }  
	    /**
	         * 文件下载功能
	     * @param request
	     * @param response
	     * @throws Exception
	     */
	    @RequestMapping("/download")
	    public void down(HttpServletRequest request,HttpServletResponse response, String filesName) throws Exception{
	        //模拟文件，myfile.txt为需要下载的文件
	        String path = request.getSession().getServletContext().getRealPath("upload")+"\\"+filesName;
	        File file = new File(path);
	        if (!file.exists()) {
	        	response.setContentType("text/html; charset=UTF-8");//注意text/html，和application/html
	        	response.getWriter().print("<html><body><script type='text/javascript'>alert('您要下载的资源已被删除！');</script></body></html>");
	        	response.getWriter().close(); 
	            System.out.println("您要下载的资源已被删除！！");  
	            return;  
			}
	        //转码，免得文件名中文乱码  
	        filesName = URLEncoder.encode(filesName,"UTF-8");  
	        //设置文件下载头  
	        response.addHeader("Content-Disposition", "attachment;filename=" + filesName);    
	        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型    
	        response.setContentType("multipart/form-data"); 
	        // 读取要下载的文件，保存到文件输入流
	        FileInputStream in = new FileInputStream(path);
	        // 创建输出流
	        OutputStream out = response.getOutputStream();
	        // 创建缓冲区
	        byte buffer[] = new byte[1024]; // 缓冲区的大小设置是个迷  我也没搞明白
	        int len = 0;
	        //循环将输入流中的内容读取到缓冲区当中
	        while((len = in.read(buffer)) > 0){
	        	out.write(buffer, 0, len);
	        }
	        //关闭文件输入流
	        in.close();
	        // 关闭输出流
	        out.close();
	    }
	    /**
	         * 查询文件
	     * @param model
	     * @param Info
	     * @param dateStart
	     * @param finalTime
	     * @return
	     * @throws ParseException
	     */
      @RequestMapping("/findAll")  
	    public String findAll(
	    		Model model,
	    		String Info,
	    		String dateStart,
	    		String finalTime,
	    		@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
				@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize
	    		) throws ParseException {
	    	Map<String, String> map = new HashMap<String, String>();
	    	  if(dateStart != null&&!dateStart.equals("") && finalTime != null&& !finalTime.equals("")) {
					 String startTime= dateStart+" "+"00:00:00";
					 String endTime = finalTime+" "+"23:59:59";
					 map.put("startTime", startTime);
				     map.put("endTime", endTime);
				 }
                map.put("Info", Info);
                PageHelper.startPage(pageNo, pageSize);
                List<Files> files = filesService.selectByParams(map);
                for (Files files2 : files) {
					System.out.println(files2);
				}
                PageInfo<Files> page = new PageInfo<Files>(files, 3);
    			model.addAttribute("pageInfo", page);
	    	return "fileManagement";
	    	
	    }
      
      /**
             * 文件删除
       */     
    @RequestMapping("/deleteFile/{fileId}")
  	public String deleteDept(@PathVariable String fileId) {
    	ResponseResult rr = new ResponseResult();
  		// 批量刪除
  		if (fileId.contains("-")) {
  			List<String> listId = new ArrayList<>();
  			String[] split_ids = fileId.split("-");
  			for (String string : split_ids) {
  				listId.add(string);
  				filesService.deleteDeptBatch(listId);
  			}
  		// 单个删除
  		} else {
  			filesService.deleteByPrimaryKey(fileId);
  				}
  		return "redirect:/files/findAll";
  	}
    
    /**
     * 根据id查询
     */
    @RequestMapping("/findById/{id}")
    public String findById(@PathVariable("id") String fileId,
    		Model model) {
    	Files file = filesService.selectByPrimaryKey(fileId);
		model.addAttribute("findByfileId", file);
	     return "test2";
    	
    }
    
    @RequestMapping("/projectList")
    @ResponseBody
    public ResponseResult projectList(
    		Model model) {
    	ResponseResult rr = new ResponseResult();
       List<Project> projects = filesService.selectByExample(null);
	   rr.add("projects", projects);
	     return rr;
    	
    }
    /**
         * 修改信息并更新
     */
    @RequestMapping("/updateFile")
    public  ResponseResult  update(Files files,Model model) {
    	ResponseResult rr = new ResponseResult();
		int i =filesService.updateByPrimaryKeySelective(files);
		if(i!=0) {
			rr.setStateCode(1);;
		}else {
			rr.setStateCode(0);
		}
		Files file = filesService.selectByPrimaryKey(files.getFileId());
		model.addAttribute("findByfileId", file); //修改完回显
		return rr;
    	
    }
    
    /**验证名称是否存在
	 * @param fileId
	 * @return
	 */
	@RequestMapping("/checkfileId")
	@ResponseBody
	public ResponseResult checkFileId(String fileId) {
		ResponseResult rr = new ResponseResult();
		int i= filesService.checkFileById(fileId);
		if(i!=0) {
			rr.setMessage("名称已存在");
			rr.setStateCode(0);
		}else {
			rr.setMessage("名称可用");
			rr.setStateCode(1);
			
		}
		return rr;
	}
    
}
