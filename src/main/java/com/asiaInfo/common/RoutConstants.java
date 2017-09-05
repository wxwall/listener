package com.asiaInfo.common;

/**
 *
 * 路由标识
 * Created by wxwall on 2017/9/1.
 *
 */
public enum  RoutConstants {

    guangdong("832000","广东"),
    jiangshu("834000","江苏");



    private String code;

    private String desc;

    private RoutConstants(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String toString() {
        return String.valueOf(code);
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
