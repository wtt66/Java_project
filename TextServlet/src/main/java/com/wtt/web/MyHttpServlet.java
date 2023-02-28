package com.wtt.web;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class MyHttpServlet implements Servlet {


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        //根据请求方式的不同，进行不同的处理

        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        1.获取请求方式
        String method = request.getMethod();
//        2.进行不同的处理
        if("GET".equals(method)){
            //get方式的处理逻辑
            doGet(servletRequest, servletResponse);
        }else if("POST".equals(method)){
            //post方式的处理逻辑
            doPost(servletRequest,servletResponse);
        }


    }

    protected void doPost(ServletRequest servletRequest, ServletResponse servletResponse) {
    }

    protected void doGet(ServletRequest servletRequest, ServletResponse servletResponse) {
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
