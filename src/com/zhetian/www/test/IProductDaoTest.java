package com.zhetian.www.test;


import com.zhetian.www.common.QueryProductObj;
import com.zhetian.www.dao.IProductDao;
import com.zhetian.www.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class IProductDaoTest {

    @Autowired
    private IProductDao productDao;


    /**
     * 测试高级查询数据
     */

    @Test
    public void queryTest(){
        QueryProductObj queryProductObj = new QueryProductObj();
        List<Product> query = productDao.query(queryProductObj);
        System.out.printf("query="+query);
    }

    @Test
    public void countTest(){
        QueryProductObj queryProductObj = new QueryProductObj();
        Integer count = productDao.count(queryProductObj);
        System.out.printf("count="+count);
    }

}
