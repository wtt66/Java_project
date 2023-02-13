package com.wtt.controller;

import com.wtt.pojo.Book;
import com.wtt.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    @RequestMapping(value = "/findAllBooks", produces = "text/html;charset = UTF-8")
    @ResponseBody
    public String findAll(){
        List list = bookService.findAll();
        System.out.println(list.size());
        //定义一个字符串接收响应的字符串
        String books = "";
        for (int i = 0; i < list.size(); i++) {
            Book book = (Book) list.get(i);
            books = books +book.getId()+"---"+book.getName()+"---"+book.getAuthor()+"<br>";

        }
        return books;

    }



}
