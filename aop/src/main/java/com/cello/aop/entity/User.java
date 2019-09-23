package com.cello.aop.entity;

/**
 * @author lizhuo
 * @Description: for param test
 * @date 2019-08-04 23:38
 */
public class User {

    private Long uid;
    private String name;

    public User() {
    }

    public User(Long uid, String name) {
        this.uid = uid;
        this.name = name;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
