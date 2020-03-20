package com.zhetian.www.service.impl;

import com.zhetian.www.common.Result;
import com.zhetian.www.dao.ILoginUserDao;
import com.zhetian.www.model.LoginUser;
import com.zhetian.www.service.ILoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Copyright (C)遮天网络有限公司
 * @Author: YUAN HUAI XING
 * @Date 2020/3/20 14:58
 * @Descripthion:
 **/
@Service
public class LoginUserService implements ILoginUserService {

    @Autowired
    private ILoginUserDao loginUserDao;

    /**
     * 获取登陆时输入的用户名跟密码并与数据库进行对比是否一致
     * @param loginUser
     * @return
     */
    @Override
    public Result checklogin(LoginUser loginUser) {
        Result<LoginUser> result = new Result<>();

        String userName = loginUser.getUserName();
        LoginUser loginUser1 = loginUserDao.loginUserByuserName(userName);
        if (loginUser1!=null){
            String password = loginUser.getPassword();
            String password1 = loginUser1.getPassword();
            if (password!=null && password1!=null &&password1.equals(password)){
                result.setCode("0000");
                result.setData(loginUser);
                return  result;
            }else {
                result.setCode("0001");
                result.setMsg("用户名或密码错误！请检查后重新登陆！");
                result.setSuccess(false);
                return  result;
            }
        }else {
            result.setCode("0002");
            result.setMsg("用户名不存在！请检查用户名后重新登陆！");
            result.setSuccess(false);
            return  result;
        }
    }

    /**
     * 注册功能
     * @param loginUser
     * @return
     */
    @Override
    public Result checkRegister(LoginUser loginUser) {
        Result result = new Result();

        String userName = loginUser.getUserName();

        LoginUser user1 = loginUserDao.loginUserByuserName(userName);
        if (user1==null){
            loginUserDao.saveLoginUser(loginUser);
        }else {
            //该用户已经注册
            result.setCode("0002");
            result.setMsg("该用户已经注册，请直接登陆！");
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public LoginUser UserByuserName(String userName) {

        LoginUser user = loginUserDao.loginUserByuserName(userName);
        return user;
    }


}
