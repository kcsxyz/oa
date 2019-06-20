package com.oa.service.deptOffice.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.oa.bean.AttendCount;
import com.oa.bean.User;
import com.oa.dao.AttendCountMapper;
import com.oa.dao.AttendMapper;
import com.oa.dao.LeaveMapper;
import com.oa.dao.UserMapper;
import com.oa.dao.WorkTimeMapper;
import com.oa.service.deptOffice.AttendCountService;
import com.oa.utils.MyAttendCountThread;

@Service
@Lazy(false)
public class AttendCountServiceImpl implements AttendCountService{
    @Resource
    private AttendMapper attendMapper;
    
    @Resource
    private AttendCountMapper attendCountMapper;
    
    @Resource
    private WorkTimeMapper workTimeMapper;
    
    @Resource
    private LeaveMapper leaveMapper;
    
    
    @Resource
    private UserMapper userMapper;
    
    @Autowired
    ThreadPoolExecutor threadPoolExecutor;

	@Override
	public List<AttendCount> selectAttendCountList(AttendCount attendCount) {
		
		return attendCountMapper.getAccountListWithUser();
	}

	@Override
	public void deleteByPrimaryKeys(Integer[] ids) {
		attendCountMapper.deleteByPrimaryKeys(ids);
		
	}

	@Override
	@Scheduled(cron="0 0 2 1 1-12 ?")
	public void insertSelective() {
		
		//每个线程处理30个用户
        final int count = 30;
        //所有用户
        List<User> users = userMapper.getUserList();
        List<List<User>> lists = getThreadCount(users, count);

        for (int i = 0; i < lists.size(); i++)
        {
            MyAttendCountThread myThread = new MyAttendCountThread(workTimeMapper, attendMapper, leaveMapper,
                                                                   attendCountMapper, lists.get(i));
            threadPoolExecutor.execute(myThread);
        }
		
	}
	

    /**
     * 计算需要开启几个线程
     *
     * @param list 总用户
     * @param count 每个线程处理几个
     */
    static List<List<User>> getThreadCount(List<User> list, int count)
    {
        List<List<User>> lists = new ArrayList<>();


        int p = (list.size() + (count - 1)) / count;

        //开启的线程个数；
        for (int i = 0; i < p; i++)
        {
            List<User> users = new ArrayList<>();

            for (int j = 0; j < list.size(); j++)
            {
                int index = ((j + 1) + (count - 1)) / count;

                if (index == (i + 1))
                {
                    users.add(list.get(j));
                }
                if ((j + 1) == ((j + 1) * count))
                {
                    break;
                }
            }

            lists.add(users);

        }
        System.out.println("开启的线程个数：" + lists.size());
        return lists;
    }
}
