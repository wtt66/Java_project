package com.wtt.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebServlet("/demo6")
public class ServletDemo6 extends MyHttpServlet {
    @Override
    protected void doGet(ServletRequest servletRequest, ServletResponse servletResponse) {
        System.out.println("get...");
    }

    @Override
    protected void doPost(ServletRequest servletRequest, ServletResponse servletResponse) {
        System.out.println("post...");
    }
}
