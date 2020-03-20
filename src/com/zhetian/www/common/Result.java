package com.zhetian.www.common;

/**
 * @Copyright (C)遮天网络有限公司
 * @Author: YUAN HUAI XING
 * @Date 2020/3/20 14:57
 * @Descripthion:
 **/

public class Result<L> {
    private String code="0000";
    private String msg="";
    private Boolean success=true;
    private L data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public L getData() {
        return data;
    }

    public void setData(L data) {
        this.data = data;
    }
}
