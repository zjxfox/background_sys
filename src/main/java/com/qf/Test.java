package com.qf;

import com.qf.pojo.UserInfo;
import com.qf.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by DELL on 2019/3/27.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml","spring-service.xml","spring-entity.xml");
        UserService userService = context.getBean(UserService.class);
        UserInfo userInfo = context.getBean("hs",UserInfo.class);

        if(userService.addUserInfo(userInfo)){
            System.out.println("add success");
        }else {
            System.out.println("add failure");
        }
    }
}
