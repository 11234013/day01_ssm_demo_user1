package com.zhetian.www.common;

/**
 * @Copyright (C)遮天网络有限公司
 * @Author: YUAN HUAI XING
 * @Date 2020/3/20 15:17
 * @Descripthion:
 **/

public class QueryProductObj {

    private String type;
    private String productName;
    private Integer minSalPrice;
    private Integer maxSalPrice;

    private Integer currentPage=1;
    private Integer pageSize=5;

    private Integer startIndex=0;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public Integer getStartIndex() {
        if (currentPage!=null && pageSize!=null){
            this.startIndex=(currentPage-1)*pageSize;
        }
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getMinSalPrice() {
        return minSalPrice;
    }

    public void setMinSalPrice(Integer minSalPrice) {
        this.minSalPrice = minSalPrice;
    }

    public Integer getMaxSalPrice() {
        return maxSalPrice;
    }

    public void setMaxSalPrice(Integer maxSalPrice) {
        this.maxSalPrice = maxSalPrice;
    }
}
