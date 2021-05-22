package spring_cache.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zcj.entity.Employee;
import com.zcj.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@SpringBootTest
@Slf4j

class SpringCacheApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    EmployeeService employeeService;
     @Test
    void Test(){
         log.info("{}",employeeService.queryById("2"));
    }

    @Test
    void insert1(){
        Employee employee=new Employee();
        employee.setEmail("2555");
        employee.setLastName("myname");
        employee.setEmail("xx.com");
        employee.setdId(1);
        employee.setGender(2);
        employeeService.insert(employee);
        log.info("{}");
    }

    @Test
    void update(){
        Employee employee=new Employee();
       employee.setId(1);
        employee.setEmail("yyy");
        employee.setLastName("bbb");
        employee.setEmail("xx.cccc");
        employee.setGender(2);
        log.info("{}",employeeService.update(employee));
    }

    @Test
    void delete(){
        Employee employee=new Employee();
        employee.setId(1);
        employee.setEmail("yyy");
        employee.setLastName("bbb");
        employee.setEmail("xx.cccc");
        employee.setGender(2);
        log.info("{}",employeeService.update(employee));
    }


    public static void main(String[] args) throws JsonProcessingException {
        Map<String,Employee> map=new LinkedHashMap<>();
        for (int i = 0; i < 20; i++) {
            Employee employee=new Employee();
            employee.setId(i);
            employee.setdId(i);
            employee.setGender(i);
            employee.setEmail("xx");
            employee.setLastName("xxxx");
            map.put(i+"",employee);
        }
        ObjectMapper objectMapper=new ObjectMapper();
        String s = objectMapper.writeValueAsString(map);
        System.out.println(s);

    }

}
