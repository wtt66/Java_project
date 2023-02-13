package com.wtt.mapper;

import java.util.List;

public interface BookMapper {
    public abstract List selectAll();
    public abstract void insertIdBook(int id, String name, String author,double price);
}
