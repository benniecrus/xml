/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staxiteratordemo;

/**
 *
 * @author Nam NV
 */
public class Student {
    private String roll;
    private String name;
    private int age;
    
    public Student(){}
    
    public Student(String roll, String name, int age)
    {
        this.roll = roll;
        this.name = name;
        this.age = age;
    }
    
    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" + "roll=" + roll + ", name=" + name + ", age=" + age + '}';
    }
    
    
    
}
