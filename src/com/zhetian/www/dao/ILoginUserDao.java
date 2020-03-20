package com.zhetian.www.dao;

import com.zhetian.www.model.LoginUser;

/**
 * @Copyright (C)遮天网络有限公司
 * @Author: YUAN HUAI XING
 * @Date 2020/3/20 14:41
 * @Descripthion:
 **/

public interface ILoginUserDao {

    /***
     * 根据用户名查询数据
     */
    LoginUser loginUserByuserName(String userName);

    /**
     * 新增一个用户
     */
    void saveLoginUser(LoginUser loginUser);
}
