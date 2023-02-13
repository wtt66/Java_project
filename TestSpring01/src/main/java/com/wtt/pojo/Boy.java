package com.wtt.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Boy {
    @Value("22")
    private int age;
    @Value("森森")
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boy() {
    }

    public Boy(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
