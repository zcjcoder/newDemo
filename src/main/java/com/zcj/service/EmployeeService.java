package com.zcj.service;

import com.zcj.entity.Employee;
import com.zcj.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "employee")
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    @Cacheable(key="#id")
     public Employee queryById(String id){
        System.out.println("我没有走缓存");
       return   employeeMapper.queryById(id);
    }

    public   void insert(Employee employee){
        employeeMapper.insert(employee);
    }
    @CachePut(key = "#employee.id")
    public   Employee update(Employee employee){
        employeeMapper.update(employee);
        return employee;
    }
    @CacheEvict(key = "#id")
    public   void delete(Integer id){
        employeeMapper.delete( id);
    }
}
