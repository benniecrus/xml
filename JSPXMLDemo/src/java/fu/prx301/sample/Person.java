/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.prx301.sample;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Nam NV
 */
@XmlRootElement
@XmlType(propOrder = {"name", "age", "address"})
public class Person {
    private String code;
    private String name;
    private int age;
    private String address;

    public Person() {
    }

    public Person(String code, String name, int age, String address) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.address = address;
    }
    
    
    public String getCode() {
        return code;
    }
    
    @XmlAttribute
    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    
    @XmlElement
    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    @XmlElement
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" + "code=" + code + ", name=" + name + ", age=" + age + ", address=" + address + '}';
    }
    
}
