package com.zhetian.www.common;

import java.util.List;

/**
 * @Copyright (C)遮天网络有限公司
 * @Author: YUAN HUAI XING
 * @Date 2020/3/20 15:15
 * @Descripthion:
 **/

public class PageList<L> {
    private List<L> list;

    private Integer currentPage;
    private Integer pageSize;
    private Integer totalNum;
    private Integer totalPage;


    public List<L> getList() {
        return list;
    }

    public void setList(List<L> list) {
        this.list = list;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
}
