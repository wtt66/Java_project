package com.wtt.pojo;

public class Book {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        System.out.println("Id的setter方法");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("name的setter方法");
        this.name = name;
    }

    public Book(int id, String name) {
        System.out.println("Book的含多个参数构造方法");
        this.id = id;
        this.name = name;
    }

    public Book() {
        System.out.println("Book的无参构造方法");
    }
}
