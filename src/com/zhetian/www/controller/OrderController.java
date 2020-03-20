package com.zhetian.www.controller;


import com.zhetian.www.common.PageList;

import com.zhetian.www.common.QueryPersonalCenterObj;
import com.zhetian.www.common.Result;
import com.zhetian.www.dao.IOrderDao;
import com.zhetian.www.model.LoginUser;
import com.zhetian.www.model.Order;
import com.zhetian.www.model.PersonalCenter;
import com.zhetian.www.model.Product;
import com.zhetian.www.service.ILoginUserService;
import com.zhetian.www.service.IOrderService;
import com.zhetian.www.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IProductService productService;
    @Autowired
    private ILoginUserService loginUserService;
    @Autowired
    private IOrderService orderService;

    /**
     * 跳转到购买页面
     * @return
     */
    @RequestMapping("/BuyPage")
    public String BuyPage(HttpServletRequest request, Integer id){
        request.setAttribute("id",id);
        return "/WEB-INF/views/buyPageList.jsp";
    }

    /**
     * 获取订单ID把数据显示在前端
     * @return
     */
    @RequestMapping("/BuyPageData")
    @ResponseBody
    public Result BuyPageData(Integer id){
        Product product = productService.ProductById(id);
        Result result = new Result();
        result.setData(product);
        return result;
    }

    /**
     * 点击购买执行操作
     * @return
     */
    @RequestMapping("/listData")
    @ResponseBody
    public Result listData(HttpServletRequest request, Order order){
        HttpSession session = request.getSession();
        LoginUser data = (LoginUser) session.getAttribute("data");
        String userName = data.getUserName();
        LoginUser user = loginUserService.UserByuserName(userName);
        Integer id = user.getId();
        order.setUserId(id);
        productService.saveOrder(order);
        Result result = new Result();
        return result;
    }


    /**
     * 跳转到个人中心页面
     * @return
     */
    @RequestMapping("/personalCenter")
    public String personalCenter(HttpServletRequest request){


        return "/WEB-INF/views/personalCenterList.jsp";
    }

    /**
     * 加载个人中心已购买的数据信息
     * @param request
     * @param queryPersonalCenterObj
     * @return
     */
    @RequestMapping("/personalCenterData")
    @ResponseBody
    public Result  personalCenterData(HttpServletRequest request, QueryPersonalCenterObj queryPersonalCenterObj){
        Result result = new Result<>();
        //调用业务方法
        //假定一个用户id
        HttpSession session = request.getSession();
        LoginUser data =(LoginUser) session.getAttribute("data");
        String userName = data.getUserName();
        LoginUser user = loginUserService.UserByuserName(userName);
        Integer id = user.getId();
        queryPersonalCenterObj.setUserId(id);

        PageList<PersonalCenter> personalCenterPageList = orderService.queryPageList(queryPersonalCenterObj);
        result.setData(personalCenterPageList);
        return result;
    }





}
