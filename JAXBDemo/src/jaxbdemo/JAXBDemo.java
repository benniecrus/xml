/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxbdemo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Nam NV
 */
public class JAXBDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

       //Write
//        try {
//            
//        Person p = new Person("P005","Bui Van Thang",32,"Ha Noi");
//        JAXBContext context;
//            context = JAXBContext.newInstance(Person.class);
//        Marshaller marshaller = context.createMarshaller();
//        marshaller.marshal(p,new File("new_person.xml"));
//        } catch (JAXBException ex) {
//            Logger.getLogger(JAXBDemo.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        
       // Read
        try {
            // TODO code application logic here

            JAXBContext context = JAXBContext.newInstance(Persons.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Persons persons = (Persons)unmarshaller.unmarshal(new File("person.xml"));
            System.out.println(persons.getList());
        } catch (JAXBException ex) {
            Logger.getLogger(JAXBDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
