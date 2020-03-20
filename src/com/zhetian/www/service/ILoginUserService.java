package com.zhetian.www.service;

import com.zhetian.www.common.Result;
import com.zhetian.www.model.LoginUser;

/**
 * @Copyright (C)遮天网络有限公司
 * @Author: YUAN HUAI XING
 * @Date 2020/3/20 14:58
 * @Descripthion:
 **/

public interface ILoginUserService {

    /**
     * 获取登陆时输入的用户名跟密码并与数据库进行对比是否一致
     * @param loginUser
     * @return
     */
    Result checklogin(LoginUser loginUser);

    /***
     * 执行注册功能
     */
    Result checkRegister(LoginUser loginUser);

    /***
     * 根据用户名查询全部数据
     */
    LoginUser UserByuserName(String userName);
}
