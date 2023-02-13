package com.wtt;

import com.wtt.pojo.Book;
import com.wtt.pojo.Boy;
import com.wtt.pojo.Girl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    public static void main(String[] args) {
//        Boy b = new Boy();
//        b.setAge(18);
//        b.setName("小刚");
//        Girl g = new Girl();
//        g.setAge(18);
//        g.setName("小雨");
//        g.setBoyfriend(b);
//        //业务打印
//        System.out.println(g.getName()+"正在和"+g.getBoyfriend().getName()+"谈恋爱");
//      创建Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //创建Book对象
        Girl g = (Girl) context.getBean("girl");
        System.out.println(g.getName()+"正在和"+g.getBoyfriend().getName()+"谈恋爱");

    }
}
