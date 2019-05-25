/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxbemxample;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Nam NV
 */
public class JAXBEmxample {

    private static final String FILE_NAME = "jaxb-emp.xml";
    
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setId(1);
        emp.setAge(25);
        emp.setName("Pankaj");
        emp.setGender("Male");
        emp.setRole("Dev");
        emp.setPassword("sensitive");
        
        jaxbObjectToXML(emp);
        
        Employee empFromFile = jaxbXMLToObject();
        System.out.println(empFromFile.toString());
        
    }
    
    private static Employee jaxbXMLToObject(){
        try {
            JAXBContext context = JAXBContext.newInstance(Employee.class);
            Unmarshaller un = context.createUnmarshaller();
            Employee emp = (Employee)un.unmarshal(new File(FILE_NAME));
            return emp;
            
        } catch (JAXBException ex) {
            Logger.getLogger(JAXBEmxample.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private static void jaxbObjectToXML(Employee emp)
    {
        try {
            JAXBContext context = JAXBContext.newInstance(Employee.class);
            Marshaller m = context.createMarshaller();
            //for pretty-print XML in JAXB
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            
            //Write to System.out for debugging
            //m.marshal(emp, System.out);
            
            //Write file
            m.marshal(emp, new File(FILE_NAME));
            
        } catch (JAXBException ex) {
            Logger.getLogger(JAXBEmxample.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
