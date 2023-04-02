package com.wtt.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wtt.reggie.common.CustomException;
import com.wtt.reggie.entity.Category;
import com.wtt.reggie.entity.Dish;
import com.wtt.reggie.entity.Setmeal;
import com.wtt.reggie.mapper.CategoryMapper;
import com.wtt.reggie.service.CategoryService;
import com.wtt.reggie.service.DishService;
import com.wtt.reggie.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper,Category> implements CategoryService {
    @Autowired
    private DishService dishService;

    @Autowired
    private SetmealService setmealService;

    /**
     * 根据id删除分类，删除前先查询
     * @param id
     */
    @Override
    public void remove(Long id) {

        //查询当前分类是否关联了菜品，如果关联则抛出异常
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        //添加查询条件，根据分类id进行查询
        dishLambdaQueryWrapper.eq(Dish::getCategoryId,id);
        int count1 = dishService.count(dishLambdaQueryWrapper);
        if(count1>0){
            //关联菜品，抛出异常

            throw new CustomException("当前分类下关联了菜品，不能删除");
        }

        //查询当前分类是否关联了菜品，如果关联则抛出异常
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper =new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId,id);
        int count2 = setmealService.count(setmealLambdaQueryWrapper);
        if(count2>0){
            //关联菜品，抛出异常
            throw new CustomException("当前分类下存在套餐，不能删除");
        }

        //正常删除分类
        super.removeById(id);
    }
}
