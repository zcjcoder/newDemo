package com.zcj.mapper;

import com.zcj.entity.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeMapper {
    Employee queryById(String id);
    @Insert("insert into employee (lastName,email,gender,d_id) values(#{employee.lastName},#{employee.email},#{employee.gender},#{employee.dId})")
    void insert(@Param("employee") Employee employee);

    @Insert("update  employee set lastName=#{e.lastName} where id=#{e.id}")
    void update(@Param("e") Employee employee);
    @Delete("delete employee where id=#{id}")
    void delete(Integer id);
}
