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
    @RequestMapping("/findBooks")
    @ResponseBody
    public String findBooks(){
        List list = bookService.findAllBooks();
        String s = "";
        for (int i = 0; i < list.size(); i++) {
            Book book = (Book) list.get(i);
            s += book.getId()+"---"+book.getName()+"---"+book.getAuthor()+"---"+book.getPrice()+"<br>";

        }

        return s;
    }
}
