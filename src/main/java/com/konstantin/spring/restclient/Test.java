/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.konstantin.spring.restclient;

import com.konstantin.spring.restclient.communication.Communication;
import com.konstantin.spring.restclient.configurationn.MyConfig;
import com.konstantin.spring.restclient.entity.Employee;
import java.util.List;
import java.util.Scanner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author JavaDev
 */
public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication bean = annotationConfigApplicationContext.getBean("communication", Communication.class);

        List<Employee> showAllEmployees = bean.showAllEmployees();
        for (Employee showAllEmployee : showAllEmployees) {
            System.out.println(showAllEmployee
            );
        }
        System.out.println("enter  the id");
        Scanner sc = new Scanner(System.in);
        int nextInt = sc.nextInt();
//        
//        Employee employee = bean.getEmployee(nextInt);
//        bean.deleteEmployee(employee);
        Employee employee = new Employee("vasia", "Kolia", "slanina", "IT", 200);
        employee.setId(37);
        bean.saveOrUpdate(employee);

        showAllEmployees = bean.showAllEmployees();
        for (Employee showAllEmployee : showAllEmployees) {
            System.out.println(showAllEmployee
            );
        }
    }
}
