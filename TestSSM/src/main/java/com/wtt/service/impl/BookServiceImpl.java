package com.wtt.service.impl;

import com.wtt.controller.BookController;
import com.wtt.mapper.BookMapper;
import com.wtt.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;
    @Override
    public List findAll() {
        return bookMapper.selectAll();
    }





}
