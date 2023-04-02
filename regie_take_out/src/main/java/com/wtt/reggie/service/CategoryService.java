package com.wtt.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wtt.reggie.entity.Category;

public interface CategoryService extends IService<Category> {
    public void remove(Long id);
}
