package com.wtt.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo1",loadOnStartup = 1)
public class ServletDemo1 implements Servlet {


    /*
    * 初始化方法
    * 1.调用时机：默认情况下，Servlet被第一次访问时，调用
    * 2.调用次数：1次
    * @param config
    * @throws ServletException
    * */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init...");

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }


    /*
     * 提供服务方法
     * 1.调用时机：默认情况下，每一次Servlet被访问时，调用
     * 2.调用次数：多次
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     * */
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("Hello Servlet");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    /*
     * 销毁方法
     * 1.调用时机：内存释放或者服务器关闭时，Servlet会被销毁
     * 2.调用次数：1次
     * */
    @Override
    public void destroy() {

    }
}
