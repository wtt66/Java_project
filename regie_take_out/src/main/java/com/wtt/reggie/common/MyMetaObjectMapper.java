package com.wtt.reggie.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.lang.invoke.MethodHandleInfo;
import java.time.LocalDateTime;


@Component
@Slf4j
public class MyMetaObjectMapper implements MetaObjectHandler {
    /**
     * 插入操作自动填充
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
      log.info("公共字段自动填充。。。");
      log.info(metaObject.toString());
      metaObject.setValue("creatTime", LocalDateTime.now());
      metaObject.setValue("updateTime", LocalDateTime.now());
      metaObject.setValue("createUser", BaseContext.getCurrentId());
      metaObject.setValue("updateUser", BaseContext.getCurrentId());

    }

    /**
     * 修改操作自动填充
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("公共字段自动填充。。。");
        log.info(metaObject.toString());
        metaObject.setValue("updateTime", LocalDateTime.now());
        metaObject.setValue("updateUser", BaseContext.getCurrentId());
        long id = Thread.currentThread().getId();
        log.info("线程id为：{}",id);
    }
}
