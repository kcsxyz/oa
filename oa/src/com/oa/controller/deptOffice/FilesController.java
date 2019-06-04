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
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.oa.bean.Files;
import com.oa.bean.Project;
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
	    		HttpServletRequest request) throws IOException{  
	    	if(!file.isEmpty()) {
	        String path = request.getSession().getServletContext().getRealPath("upload");  
	        String fileName = file.getOriginalFilename(); 
	        File dir = new File(path,fileName);          
	        if(!dir.exists()){  
	            dir.mkdirs();  
	        }  
	        System.out.println(path+fileName);
	        file.transferTo(dir);  
            files.setFileName(fileName);
            files.setCreateTime(new Date());
            String size = String.valueOf(fileName.length());
            files.setFileSize(size);
            filesService.insertSelective(files);
	        return "success";
	        } 
			return "false";
	    }  
	    /**
	         * 文件下载功能
	     * @param request
	     * @param response
	     * @throws Exception
	     */
	    @RequestMapping("/download")
	    public void down(HttpServletRequest request,HttpServletResponse response,String fileName) throws Exception{
	        //模拟文件，myfile.txt为需要下载的文件
	        String path = request.getSession().getServletContext().getRealPath("upload")+"\\"+fileName;
	        File file = new File(path);
	        if (!file.exists()) {
	        	response.setContentType("text/html; charset=UTF-8");//注意text/html，和application/html
	        	response.getWriter().print("<html><body><script type='text/javascript'>alert('您要下载的资源已被删除！');</script></body></html>");
	        	response.getWriter().close(); 
	            System.out.println("您要下载的资源已被删除！！");  
	            return;  
			}
	        //转码，免得文件名中文乱码  
	        fileName = URLEncoder.encode(fileName,"UTF-8");  
	        //设置文件下载头  
	        response.addHeader("Content-Disposition", "attachment;filename=" + fileName);    
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

	    public String findAll(String Info,String startTime,String finalTime) throws ParseException {
	    	Map<String, String> map = new HashMap<String, String>();
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//yyyy-mm-dd, 会出现时间不对, 因为小写的mm是代表: 秒
	    	if(startTime != null&&!startTime.equals("") && finalTime != null&& !finalTime.equals("")) {
			    Date beforeTime = sdf.parse(startTime);
			    Date finallyTime  = sdf.parse(finalTime);
			    Calendar rightNow = Calendar.getInstance();
					rightNow.setTime(finallyTime);
					rightNow.add(Calendar.HOUR,23);
					rightNow.add(Calendar.MINUTE,59);
					rightNow.add(Calendar.SECOND,59);
				Date endTime = rightNow.getTime();
				}
	    	
	    	return null;
	    	
	    }
}
