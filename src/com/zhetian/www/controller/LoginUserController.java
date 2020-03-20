package com.zhetian.www.controller;

import com.zhetian.www.common.Result;
import com.zhetian.www.model.LoginUser;
import com.zhetian.www.service.ILoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Copyright (C)遮天网络有限公司
 * @Author: YUAN HUAI XING
 * @Date 2020/3/20 14:52
 * @Descripthion:
 **/
@Controller
@RequestMapping("/login")
public class LoginUserController {

    @Autowired
    private ILoginUserService loginUserService;


    /**
     * 登陆界面
     * @return
     */
    @RequestMapping("/page")
    public String getpage(){
        return "/WEB-INF/views/loginUserList.jsp";
    }

    /**
     * 登陆界面数据交互
     * @return
     */
    @RequestMapping("/pageData")
    @ResponseBody
    public Result pageData(HttpServletRequest request, LoginUser loginUser){
        Result<LoginUser> result = loginUserService.checklogin(loginUser);
        LoginUser data = result.getData();
        HttpSession session = request.getSession();
        session.setAttribute("data",data);

        return result;
    }

    /**
     * 注销登陆
     * @return
     */
    @RequestMapping("/loginOut")
    public String loginOut(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("data");

        return "/WEB-INF/views/loginUserList.jsp";
    }

    /**
     * 跳转注册页面
     * @return
     */
    @RequestMapping("/register")
    public String register(){
        return "/WEB-INF/views/registerList.jsp";
    }

    /**
     * 执行注册功能
     * @return
     */
    @RequestMapping("/registerData")
    @ResponseBody
    public Result registerData(LoginUser loginUser){
        Result result = loginUserService.checkRegister(loginUser);

        return result;
    }
}
