/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxbdemo;

import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Nam NV
 */
@XmlType(propOrder = {"name","age","address"})
@XmlRootElement()
public class Person {
    private String code;
    private String name;
    private int age;
    private String address;

    public Person(String code, String name, int age, String address) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.address = address;
    }
    
    public Person(){}
    
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }
    @XmlAttribute
    public void setCode(String code) {
        this.code = code;
    }
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }
    @XmlElement
    public void setAge(int age) {
        this.age = age;
    }
    @XmlElement
    public void setAddress(String address) {
        this.address = address;
    }
    
}
