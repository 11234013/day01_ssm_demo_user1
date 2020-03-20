package com.zhetian.www.test;

import com.zhetian.www.dao.ILoginUserDao;
import com.zhetian.www.model.LoginUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Copyright (C)遮天网络有限公司
 * @Author: YUAN HUAI XING
 * @Date 2020/3/20 14:47
 * @Descripthion:
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class ILoginUserDaoTest {

    @Autowired
    private ILoginUserDao loginUserDao;

    @Test
    public void loginUserByuserName(){
        LoginUser loginUser = loginUserDao.loginUserByuserName("98734461");
        System.out.println(loginUser);

    }
}
