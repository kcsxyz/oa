package com.oa.service.deptOffice.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oa.dao.AttendMapper;

@Service
public class AttendCountServiceImpl {
    @Resource
    private AttendMapper attendMapper;
}
