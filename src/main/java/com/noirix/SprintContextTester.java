package com.noirix;

import com.noirix.domain.User;
import com.noirix.repository.UserRepository;
import com.noirix.util.StringUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SprintContextTester {
    public static void main(String[] args) {


//        ClassPathXmlApplicationContext xmlContext = new ClassPathXmlApplicationContext("classpath:application-context.xml");
//
//        User user1 = xmlContext.getBean("user1", User.class);
//        User user2 = (User) xmlContext.getBean("user2");
//        System.out.println(user1);
//        System.out.println(user2);

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext("com.noirix");

        //UserRepository userRepository = annotationConfigApplicationContext.getBean(UserRepository.class);

        System.out.println(annotationConfigApplicationContext.getBean("getStringUtils", StringUtils.class).concat("First", "second"));

        UserRepository userRepository = annotationConfigApplicationContext.getBean("userRepositoryImpl", UserRepository.class);

        for (User user : userRepository.findAll()) {
            System.out.println(user);
        }
    }
}
