package com.cello.aop.service;

import com.cello.aop.entity.User;

/**
 * @author lizhuo
 * @Description: user service for test
 * @date 2019-08-04 18:14
 */
public interface UserService {

    String save(Long uid, String name);

    String save(User user);

    void testAnnotationAop();

    void testIntroduction();

}
