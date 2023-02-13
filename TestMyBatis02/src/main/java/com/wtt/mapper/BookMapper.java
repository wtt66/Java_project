package com.wtt.mapper;

import com.wtt.pojo.Book;

import java.util.List;

public interface BookMapper {
    public abstract List selectAllBooks();
    public abstract Book selectOneBook(String name, String author);
    public abstract Book selectOneBook2(Book book);
    public abstract int insertBook(Book book);
    public abstract int deleteBook(int id);



    public abstract int updateBook(Book book,int id);

}
