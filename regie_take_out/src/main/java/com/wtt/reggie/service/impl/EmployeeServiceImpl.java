package com.wtt.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wtt.reggie.entity.Employee;
import com.wtt.reggie.mapper.EmployeeMapper;
import com.wtt.reggie.service.EmployeeService;
import org.springframework.stereotype.Service;

// mybatisplus相关操作
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}
