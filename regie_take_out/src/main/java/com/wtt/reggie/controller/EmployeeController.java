package com.wtt.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wtt.reggie.common.R;
import com.wtt.reggie.entity.Employee;
import com.wtt.reggie.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    /*
    * 员工登录
    * @param request
    * @param employee
    * @return */
    @PostMapping("/login")
    public R<Employee> login(HttpServletRequest request,@RequestBody Employee employee){
        /**

         1、将页面提交的密码password进行md5加密处理
         2、根据页面提交的用户名username查询数据库
         3、如果没有查询到则返回登录失败结果
         4、密码比对，如果不一致则返回登录失败结果
         5、查看员工状态，如果为已禁用状态，则返回员工已禁用结果
         6、登录成功，将员工id存入Session并返回登录成功结果

         */
//        1、将页面提交的密码password进行md5加密处理
        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());

//        2、根据页面提交的用户名username查询数据库
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Employee::getUsername, employee.getUsername());
        Employee emp = employeeService.getOne(queryWrapper);

//        3、如果没有查询到则返回登录失败结果
        if(emp == null){
            return R.error("登陆失败");
        }

//        4、密码比对，如果不一致则返回登录失败结果
        if(!emp.getPassword().equals(password)){
            return R.error("登陆失败");
        }

//        5、查看员工状态，如果为已禁用状态，则返回员工已禁用结果
        if(emp.getStatus()==0){
            return R.error("登陆失败");
        }

//        6、登录成功，将员工id存入Session并返回登录成功结果
        request.getSession().setAttribute("employee",emp.getId());
        return R.success(emp);

    }
    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request){
    //清理Session中当前所保存的id
        request.getSession().removeAttribute("employee");
        return R.success("退出成功");
    }

    @PostMapping
    public R<String> save(HttpServletRequest request,@RequestBody Employee employee){
        log.info("添加成功");

        //设置初始密码123456，进行MD5加密
        employee.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        employee.setCreateTime(LocalDateTime.now());
        employee.setUpdateTime(LocalDateTime.now());

        //获取当前用户的id
        long empId = (long) request.getSession().getAttribute("employee");

        employee.setCreateUser(empId);
        employee.setUpdateUser(empId);

        employeeService.save(employee);

        return R.success("添加员工成功");
    }
}
