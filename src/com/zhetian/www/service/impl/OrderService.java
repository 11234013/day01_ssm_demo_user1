package com.zhetian.www.service.impl;

import com.zhetian.www.common.PageList;
import com.zhetian.www.common.QueryPersonalCenterObj;
import com.zhetian.www.dao.IOrderDao;
import com.zhetian.www.model.PersonalCenter;
import com.zhetian.www.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderDao orderDao;

    /**
     * //获取分页对象的当前页 每页显示条数 共多少条 共多少页
     * @param queryPersonalCenterObj
     * @return
     */

    @Override
    public PageList<PersonalCenter> queryPageList(QueryPersonalCenterObj queryPersonalCenterObj) {
        PageList<PersonalCenter> pageList = new PageList<>();

        List<PersonalCenter> query = orderDao.query(queryPersonalCenterObj);
        pageList.setList(query);

        Integer currentPage = queryPersonalCenterObj.getCurrentPage();
        pageList.setCurrentPage(currentPage);

        Integer pageSize = queryPersonalCenterObj.getPageSize();
        pageList.setPageSize(pageSize);

        Integer count = orderDao.count(queryPersonalCenterObj);
        pageList.setTotalNum(count);

        Integer totalPage=(count+pageSize-1)/pageSize;
        pageList.setTotalPage(totalPage);

        return pageList;

    }
}
