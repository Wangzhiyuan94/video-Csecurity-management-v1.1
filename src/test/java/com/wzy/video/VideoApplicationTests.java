package com.wzy.video;

import com.wzy.video.bean.UserData;
import com.wzy.video.dao.UserDao;
import com.wzy.video.service.UserDetailsServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VideoApplicationTests {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Test
    public void contextLoads() {
        UserData userData = userDao.findByUsername("123");
        UserData userData1 = userDao.SelectOne("222");
        System.out.println("结果集:"+userData);
        System.out.println("结果集1:"+userData1);

        UserDetails userDetails = userDetailsService.loadUserByUsername("123");
        System.out.println("userDetails:"+userDetails);
    }

}
