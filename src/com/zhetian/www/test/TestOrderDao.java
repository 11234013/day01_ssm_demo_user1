package com.zhetian.www.test;


import com.zhetian.www.common.QueryPersonalCenterObj;
import com.zhetian.www.dao.IOrderDao;
import com.zhetian.www.model.Order;
import com.zhetian.www.model.PersonalCenter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class TestOrderDao {

    @Autowired
    private IOrderDao orderDao;

    @Test
    public void TestsaveOrde(){
        Order order = new Order();
        order.setProductId(2);
        order.setUserId(2);
        order.setBuyNum(30);
        orderDao.saveOrder(order);
    }

    /**
     * 测试高级查询数据
     */

    @Test
    public void Testquery(){
        QueryPersonalCenterObj queryPersonalCenterObj = new QueryPersonalCenterObj();
        queryPersonalCenterObj.setUserId(2);
        List<PersonalCenter> query = orderDao.query(queryPersonalCenterObj);
        System.out.printf("query="+query);
    }

    @Test
    public void Testcount(){
        QueryPersonalCenterObj queryPersonalCenterObj = new QueryPersonalCenterObj();
        Integer count = orderDao.count(queryPersonalCenterObj);
        System.out.printf("count="+count);
    }



}
