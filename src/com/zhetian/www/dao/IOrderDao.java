package com.zhetian.www.dao;

import com.zhetian.www.common.QueryPersonalCenterObj;
import com.zhetian.www.model.Order;
import com.zhetian.www.model.PersonalCenter;

import java.util.List;

public interface IOrderDao {

    /**
     * 新增一个订单
     */
    void saveOrder(Order order);

    /**
     * //高级查询
     * @param queryPersonalCenterObj
     * @return
     */
    List<PersonalCenter> query(QueryPersonalCenterObj queryPersonalCenterObj);


    /**
     * //条件下查询全部数据
     * @param queryPersonalCenterObj
     * @return
     */
    Integer count(QueryPersonalCenterObj queryPersonalCenterObj);

}
