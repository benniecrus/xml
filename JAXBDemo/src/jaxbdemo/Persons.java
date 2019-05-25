/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxbdemo;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Nam NV
 */
public class Persons {
    List<Person> list;

    public List<Person> getList() {
        return list;
    }
    
    @XmlElement(name = "person")
    public void setList(List<Person> list) {
        this.list = list;
    }

    public Persons(List<Person> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Persons{" + "list=" + list + '}';
    }
    public Persons(){
        
    }
}
