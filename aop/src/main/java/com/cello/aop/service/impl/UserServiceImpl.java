package com.cello.aop.service.impl;

import com.cello.aop.annotation.Log;
import com.cello.aop.entity.User;
import com.cello.aop.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author lizhuo
 * @Description: service
 * @date 2019-08-04 18:23
 */
@Service
public class UserServiceImpl implements UserService {

    @Log(value = "test log")
    @Override
    public String save(Long uid, String name) {
        System.out.println("save user");
        if ("a".equals(name)) {
            throw new RuntimeException();
        }
        return name + " save done";
    }

    @Log(value = "test user")
    @Override
    public String save(User user) {
        System.out.println("save user");
        return "uid: " + user.getUid() + ", name: " + user.getName();
    }

    @Override
    public void testAnnotationAop() {
        System.out.println("testAnnotationAop");
    }

    @Override
    public void testIntroduction() {
        System.out.println("testIntroduction");
    }

}
