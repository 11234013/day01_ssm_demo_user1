package com.zhetian.www.common;

public class QueryPersonalCenterObj {

    private String type;
    private String productName;
    private String minBuyNum;
    private String maxBuyNum;

    private Integer currentPage=1;
    private Integer pageSize=3;
    private Integer startIndex=0;

    private Integer userId;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }




    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getMinBuyNum() {
        return minBuyNum;
    }

    public void setMinBuyNum(String minBuyNum) {
        this.minBuyNum = minBuyNum;
    }

    public String getMaxBuyNum() {
        return maxBuyNum;
    }

    public void setMaxBuyNum(String maxBuyNum) {
        this.maxBuyNum = maxBuyNum;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
