/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.konstantin.spring.restclient.communication;

import com.konstantin.spring.restclient.entity.Employee;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author JavaDev
 */
@Component
public class Communication {

    @Autowired
    RestTemplate restTemplate;
    private static final String URL = "http://localhost:8080/api/employees";

    public List<Employee> showAllEmployees() {
        ResponseEntity<List<Employee>> exchange = restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>() {
        });
        List<Employee> body = exchange.getBody();
        return body;
    }

    public void saveOrUpdate(Employee employee) {
        if (employee.getId() == 0) {
            ResponseEntity<Employee> postForEntity = restTemplate.postForEntity(URL, employee, Employee.class);
            Employee body = postForEntity.getBody();

        } else {
            restTemplate.put(URL, employee);
        }
    }

//    public void addEmployee() {
//restTemplate.exchange(URL, HttpMethod.POST, HttpEntity.EMPTY, type, map);
//    }
    public void deleteEmployee(Employee employee) {
        int id = employee.getId();
        restTemplate.delete(URL + "/" + id);
    }

    public Employee getEmployee(int id) {
        Employee forObject = null;
        try {
            forObject = restTemplate.getForObject(URL + "/" + id, Employee.class);
        } catch (Exception e) {
            System.out.println("no such employee");
            return null;
        }
        return forObject;
    }

    public List getList() {
        List forObject = null;
        try {
            forObject = restTemplate.getForObject(URL, List.class);
        } catch (Exception e) {
            System.out.println("no such employee");
            return null;
        }
        return forObject;
    }
}
