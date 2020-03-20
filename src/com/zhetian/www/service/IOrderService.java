package com.zhetian.www.service;

import com.zhetian.www.common.PageList;
import com.zhetian.www.common.QueryPersonalCenterObj;
import com.zhetian.www.model.PersonalCenter;

public interface IOrderService {


    /**
     * //分页查询
     * @param queryPersonalCenterObj
     * @return
     */
    PageList<PersonalCenter> queryPageList(QueryPersonalCenterObj queryPersonalCenterObj);

}
