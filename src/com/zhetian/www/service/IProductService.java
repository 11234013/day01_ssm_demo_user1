package com.zhetian.www.service;

import com.zhetian.www.common.PageList;
import com.zhetian.www.common.QueryProductObj;
import com.zhetian.www.model.Order;
import com.zhetian.www.model.Product;

import javax.management.Query;
import java.util.List;

/**
 * @Copyright (C)遮天网络有限公司
 * @Author: YUAN HUAI XING
 * @Date 2020/3/20 14:41
 * @Descripthion:
 **/

public interface IProductService {

    /**
     * 高级查询+分页
     * @param queryProductObj
     * @return
     */
  PageList<Product> queryPageList(QueryProductObj queryProductObj);


    /**
     * 根据ID查询数据
     * @param id
     * @return
     */
    Product ProductById(Integer id);

    /**
     * 进行购买产品
     * @param order
     * @return
     */
    void saveOrder(Order order);
}
