/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.konstantin.spring.restclient.entity;


/**
 *
 * @author JavaDev
 */
public class Employee {

    public Employee(String name, String surnname, String email, String department, int salary) {
        this.name = name;
        this.surnname = surnname;
        this.email = email;
        this.department = department;
        this.salary = salary  ;
    } 

    private int id;
    
    private String name;
    
    private String surnname;
    
    private String email;
    
    private String department;
    
    private int salary;
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSalary() {
        return salary;
    }
    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", surnname=" + surnname + ", email=" + email + ", department=" + department + ", salary=" + salary + '}';
    }

    

    public String getSurnname() {
        return surnname;
    }

    public void setSurnname(String surnname) {
        this.surnname = surnname;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
