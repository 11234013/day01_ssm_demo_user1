package com.zhetian.www.dao;

import com.zhetian.www.common.QueryProductObj;
import com.zhetian.www.model.LoginUser;
import com.zhetian.www.model.Product;

import javax.management.Query;
import java.util.List;

/**
 * @Copyright (C)遮天网络有限公司
 * @Author: YUAN HUAI XING
 * @Date 2020/3/20 14:41
 * @Descripthion:
 **/

public interface IProductDao {

    /**
     * //根据ID查询数据
     * @param id
     * @return
     */
    Product ProductById(Integer id);

    /**
     * //修改数据
     * @param product
     * @return
     */
    void updateProduct(Product product);

    List<Product> query(QueryProductObj queryProductObj);

    Integer count(QueryProductObj queryProductObj);
}
