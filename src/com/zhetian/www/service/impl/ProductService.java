package com.zhetian.www.service.impl;

import com.zhetian.www.common.PageList;
import com.zhetian.www.common.QueryProductObj;
import com.zhetian.www.dao.IOrderDao;
import com.zhetian.www.dao.IProductDao;
import com.zhetian.www.model.Order;
import com.zhetian.www.model.Product;
import com.zhetian.www.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Copyright (C)遮天网络有限公司
 * @Author: YUAN HUAI XING
 * @Date 2020/3/20 14:41
 * @Descripthion:
 **/

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Autowired
    private IOrderDao orderDao;

    /**
     * 高级查询+分页
     * @param queryProductObj
     * @return
     */
    @Override
    public PageList<Product> queryPageList(QueryProductObj queryProductObj) {
        PageList<Product> pageList = new PageList<>();

        List<Product> query = productDao.query(queryProductObj);
        pageList.setList(query);

        Integer currentPage = queryProductObj.getCurrentPage();
        pageList.setCurrentPage(currentPage);

        Integer pageSize = queryProductObj.getPageSize();
        pageList.setPageSize(pageSize);

        Integer count = productDao.count(queryProductObj);
        pageList.setTotalNum(count);

        Integer totalPage=(count+pageSize-1)/pageSize;
        pageList.setTotalPage(totalPage);

        return pageList;
    }

    @Override
    public Product ProductById(Integer id) {
        Product product = productDao.ProductById(id);
        return product;
    }

    @Override
    public void saveOrder(Order order) {
        Integer productId = order.getProductId();
        Product product = productDao.ProductById(productId);
        Integer productNum = product.getProductNum();
        Integer buyNum = order.getBuyNum();
        if (productNum >= buyNum) {
            Integer stokNum=productNum-buyNum;
            product.setProductNum(stokNum);
            productDao.updateProduct(product);
            String orderNum="001";
            order.setOrderNum(orderNum);

            orderDao.saveOrder(order);
        }
    }


}
