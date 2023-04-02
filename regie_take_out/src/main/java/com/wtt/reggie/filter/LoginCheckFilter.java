package com.wtt.reggie.filter;

import com.alibaba.fastjson.JSON;
import com.wtt.reggie.common.BaseContext;
import com.wtt.reggie.common.R;
import com.wtt.reggie.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FilenameFilter;
import java.io.IOException;

@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {

    //路径匹配器，支持通配符
    public static final AntPathMatcher ANT_PATH_MATCHER = new AntPathMatcher();
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

//        过滤器具体的处理逻辑如下:
//        1、获取本次请求的URI
//        2、判断本次请求是否需要处理
//        3、如果不需要处理，则直接放行
//        4、判断登录状态，如果已登录，则直接放行
//        5、如果未登录则返回未登录结果

        //        1、获取本次请求的URI
        String requestURI = request.getRequestURI();
        log.info("拦截到请求{}",requestURI);
        String[] urls = new String[]{
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**"

        };

//        2、判断本次请求是否需要处理
        boolean check = check(urls,requestURI);

//        3、如果不需要处理，则直接放行
        if(check){
            log.info("本次请求{}不需要处理",requestURI);
            filterChain.doFilter(request,response);
            return;
        }



//        4、判断登录状态，如果已登录，则直接放行
        if(request.getSession().getAttribute("employee")!=null){
            log.info("用户{}已登录",request.getSession().getAttribute("employee"));

//            //查看线程id
//            long id = Thread.currentThread().getId();
//            log.info("线程id为：{}",id);
            Long empId = (Long)request.getSession().getAttribute("employee");
            BaseContext.setCurrentId(empId);

            filterChain.doFilter(request,response);
            return;
        }



//        5、如果未登录则返回未登录结果,通过输出流方式向客户页面返回数据
        log.info("用户未登录！");
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
        return;

    }

    /**
     *路径匹配检查本次请求是否需要放行
     * @param urls
     * @param requestURI
     * @return
     */
    public boolean check(String[] urls,String requestURI ){
        for(String url: urls){
            boolean match = ANT_PATH_MATCHER.match(url, requestURI);
            if(match){
                return true;
            }
        }
        return false;
    }




}
