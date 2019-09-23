package com.cello.aop;

import com.cello.aop.entity.User;
import com.cello.aop.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author lizhuo
 * @Description: Annotation Tests
 * @date 2019-08-04 18:38
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AnnotationTests {

    @Resource
    private UserService userService;

    @Test
    public void testAOP_save() {
        userService.save(100L,"lizhuo");
        Assert.assertTrue(true);
    }

    @Test
    public void testAop_saveUser() {
        User user = new User(100L, "lizhuo");
        userService.save(user);
        Assert.assertTrue(true);
    }

}
