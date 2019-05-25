/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staxiteratordemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 *
 * @author Nam NV
 */
public class StaxIteratorDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StaxIteratorDemo iterator = new StaxIteratorDemo();
        Student student = new Student("A3", "Thuy", 13);
        List<Student> lstStudent = iterator.getStudent();
        System.out.println(lstStudent.size());
            
            for(int i = 0; i<lstStudent.size(); i++){
                System.out.println(lstStudent.get(i).toString());
            }
            
        iterator.writeStudent(lstStudent, student);
        
        
        
    }
    
    private List<Student> getStudent(){
        List<Student> lstStudent = new ArrayList<Student>();
        Student student = new Student();
        XMLInputFactory factoryReader = XMLInputFactory.newFactory();
        try {
            
            XMLEventReader reader = factoryReader.createXMLEventReader(new FileInputStream("student.xml"));
            
            while(reader.hasNext()){
                
                XMLEvent event = reader.nextEvent();
                
                if(event.isStartElement()){
                    StartElement sElement = event.asStartElement();
                    if(sElement.getName().toString().equals("student")){
                        student = new Student();
                        Attribute roll = sElement.getAttributeByName(new QName("roll"));
                        student.setRoll(roll.getValue());
                    }
                    if(sElement.getName().toString().equals("name")){
                        XMLEvent e = reader.nextEvent();
                        Characters name = e.asCharacters();
                        student.setName(name.getData());
                    } else
                    if(sElement.getName().toString().equals("age")){
                        XMLEvent e = reader.nextEvent();
                        Characters age = e.asCharacters();
                        student.setAge(Integer.parseInt(age.getData()));
                    }
                }
                if(event.isEndElement()){
                        EndElement endElement = event.asEndElement();
                        if(endElement.getName().toString().equals("student"))
                        lstStudent.add(student);
                    }

            }
            
        } catch (XMLStreamException ex) {
            Logger.getLogger(StaxIteratorDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StaxIteratorDemo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lstStudent;
    } 
    
    private void writeStudent(List<Student> lst, Student student)
    {
        XMLOutputFactory factory = XMLOutputFactory.newFactory();
        lst.add(student);
        
        try {
            XMLEventWriter writer = factory.createXMLEventWriter(new FileOutputStream("student.xml"));
            
            XMLEventFactory EFactor = XMLEventFactory.newFactory();
            
            writer.add(EFactor.createStartDocument("UTF-8","1.0"));
            writer.add(EFactor.createCharacters("\n"));
            writer.add(EFactor.createStartElement("", "", "student_list"));
            if(lst.size()>0){
            for(int i = 0; i< lst.size(); i++){
                
                Student s = lst.get(i);
                
                writer.add(EFactor.createStartElement("", "", "student"));
            
                writer.add(EFactor.createAttribute("roll", s.getRoll()));
                writer.add(EFactor.createCharacters("\n\t"));
            
                writer.add(EFactor.createStartElement("", "", "name"));
                writer.add(EFactor.createCharacters(s.getName()));
                writer.add(EFactor.createEndElement("", "", "name"));
                writer.add(EFactor.createCharacters("\n\t"));
            
                writer.add(EFactor.createStartElement("", "", "age"));
                writer.add(EFactor.createCharacters(""+s.getAge()));
                writer.add(EFactor.createEndElement("", "", "age"));
                writer.add(EFactor.createCharacters("\n"));
            
                writer.add(EFactor.createEndElement("", "", "student"));
            }
            
            writer.add(EFactor.createEndElement("", "", "student_list"));
            writer.add(EFactor.createEndDocument());
            }
            
        
        } catch (XMLStreamException ex) {
            Logger.getLogger(StaxIteratorDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StaxIteratorDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
