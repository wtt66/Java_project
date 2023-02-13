package com.wtt.controller;

import com.wtt.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class TestController {//控制器类
    @RequestMapping("/Test01")
    public String Test01(){
        //响应给浏览器index.jsp页面
        return "index.jsp";
    }
    @RequestMapping("/TestParam")
    public String TestParam(String name,int age){
        System.out.println(name+"---"+age);
        return "index.jsp";
    }

    @RequestMapping("/TestParam02")
    public String TextParam02(Person p){
        System.out.println(p.getName()+"---"+p.getAge()+"---"+p.getScore());
        return "index.jsp";
    }
}
