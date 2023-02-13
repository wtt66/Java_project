package com.wtt.service.impl;

import com.wtt.mapper.BookMapper;
import com.wtt.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;
    public List findAllBooks() {
        return bookMapper.selectAllBooks();
    }
}
