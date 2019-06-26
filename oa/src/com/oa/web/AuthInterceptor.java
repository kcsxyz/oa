package com.oa.web;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.oa.bean.Permission;
import com.oa.service.system.PermissionService;

@SuppressWarnings("unchecked")
public class AuthInterceptor extends HandlerInterceptorAdapter {
	
	@Resource
	private PermissionService permissionService;
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 获取用户的请求地址
		String uri = request.getRequestURI();
		System.out.println(uri);
		String path = request.getSession().getServletContext().getContextPath();

		// 判断当前路径是否需要进行权限验证。
		// 查询所有需要验证的路径集合
		List<Permission> permissions = permissionService.getParentPermissionList();
		Set<String> uriSet = new HashSet<String>();
		for (Permission permission : permissions) {
			//System.out.println(permission.getUrl());
			if (permission.getUrl() != null && !"".equals(permission.getUrl())) {
				uriSet.add(permission.getUrl());
			}
		}

		if (uriSet.contains(uri)) {
			// 权限验证
			// 判断当前用户是否拥有对应的权限
			Set<String> authUriSet = (Set<String>) request.getSession().getAttribute("authUriSet");
			if (authUriSet.contains(uri)) {
				return true;
			} else {
				//无权限
				response.sendRedirect(path + "/user/auth");
				return false;
			}
		} else {
			return true;
		}
	}
	

}
