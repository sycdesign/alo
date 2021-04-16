package com.jd.spring;

import lombok.val;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("tx.xml");

        val a = context.getBean("a");

        System.out.println(a);

    }
}
