package com.zhetian.www.controller;

import com.zhetian.www.common.PageList;
import com.zhetian.www.common.QueryProductObj;
import com.zhetian.www.common.Result;
import com.zhetian.www.model.LoginUser;
import com.zhetian.www.model.Product;
import com.zhetian.www.service.ILoginUserService;
import com.zhetian.www.service.IProductService;
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
@RequestMapping("/tick")
public class ProductController {

    @Autowired
    private IProductService productService;


    /**
     * 产品界面
     * @return
     */
    @RequestMapping("/list")
    public String getlist(){
        return "/WEB-INF/views/productList.jsp";
    }

    /**
     * 登陆界面数据交互
     * @return
     */
    @RequestMapping("/listData")
    @ResponseBody
    public Result<PageList> listData(QueryProductObj queryProductObj) {
        Result<PageList> result = new Result<>();

        PageList<Product> pageList = productService.queryPageList(queryProductObj);
        result.setData(pageList);

        return result;
    }
}
