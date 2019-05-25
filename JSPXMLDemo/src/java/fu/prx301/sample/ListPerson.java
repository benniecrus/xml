/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fu.prx301.sample;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nam NV
 */
@XmlRootElement(name = "listperson")
public class ListPerson {
    private List<Person> list;

    public ListPerson() {
    }

    public ListPerson(List<Person> list) {
        this.list = list;
    }

    public List<Person> getList() {
        return list;
    }
    
    @XmlElement(name="person")
    public void setList(List<Person> list) {
        this.list = list;
    }

    
    
}
