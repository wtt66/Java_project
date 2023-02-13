package com.wtt.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Girl {
    @Value("18")
    private int age;
    @Value("丽丽")
    private String name;
    @Autowired()
    private Boy boyfriend;

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

    public Boy getBoyfriend() {
        return boyfriend;
    }

    public void setBoyfriend(Boy boyfriend) {
        this.boyfriend = boyfriend;
    }

    public Girl() {
    }

    public Girl(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Girl(int age, String name, Boy boyfriend) {
        this.age = age;
        this.name = name;
        this.boyfriend = boyfriend;
    }
}
