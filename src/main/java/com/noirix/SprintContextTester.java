package com.noirix;

import com.noirix.domain.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SprintContextTester {
    public static void main(String[] args) {


        ClassPathXmlApplicationContext xmlContext = new ClassPathXmlApplicationContext("classpath:application-context.xml");

        User user1 = xmlContext.getBean("user1", User.class);
        User user2 = (User) xmlContext.getBean("user2");
        System.out.println(user1);
        System.out.println(user2);
    }
}
