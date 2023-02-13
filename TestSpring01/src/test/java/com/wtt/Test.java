package com.wtt;

import com.wtt.pojo.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        //创建Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //创建Book对象
        Book b = (Book) context.getBean("b");
        System.out.println(b.getId()+"---"+b.getName());

    }
}
