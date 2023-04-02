package com.wtt.reggie.common;


/**
 * 1、编写BaseContext工具类，基于ThreadLocal封装的工具类,用户保存和获取当前用登录户id
 * 2、在LogincheckFilter的doFilter方法中调用BaseContext来设置当前登录用户的id
 * 3、在MyMetaObjectHandler的方法中调用BaseContext获取登录用户的id
 */
public class BaseContext {
    private static ThreadLocal<Long> threadLocal=new ThreadLocal<>();

    public static void setCurrentId(Long id){
        threadLocal.set(id);
    }

    public static Long getCurrentId(){
        return threadLocal.get();
    }
}
