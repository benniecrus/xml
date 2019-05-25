/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxbemxample;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Nam NV
 */
@XmlRootElement(name = "Employee")
@XmlType(propOrder = {"name", "age", "role", "gender"})
public class Employee {
    private int id;
    private String gender;
    private int age;
    private String name;
    private String role;
    private String password;
    
    @XmlAttribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //@XmlElement(name="gen")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @XmlTransient
    public String getPassword() {
        return password;
    }
    
    
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", gender=" + gender + ", age=" + age + ", name=" + name + ", role=" + role + ", password=" + password + '}';
    }

    public Employee(int id, String gender, int age, String name, String role, String password) {
        this.id = id;
        this.gender = gender;
        this.age = age;
        this.name = name;
        this.role = role;
        this.password = password;
    }

    public Employee() {
    }
    
    
    
}
