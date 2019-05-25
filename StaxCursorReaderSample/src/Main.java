
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nam NV
 */
public class Main {

    public static boolean bName;
    public static boolean bAge;
    public static boolean bGender;
    public static boolean bRole;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String fileName = "employees.xml";
        List<Employee> empList = parseXML(fileName);
        for(Employee emp : empList){
            System.out.println(emp.toString());
        }
    }
    
    private static List<Employee> parseXML(String fileName){
        List<Employee> emplist = new ArrayList<>();
        Employee emp = null;
        XMLInputFactory xmlInputFactor = XMLInputFactory.newInstance();
        try {
            XMLStreamReader xmlStreamReader = xmlInputFactor.createXMLStreamReader(new FileInputStream(fileName));
            int event = xmlStreamReader.getEventType();
            while(true)
            {
                switch(event){
                    case XMLStreamConstants.START_ELEMENT:
                        if(xmlStreamReader.getLocalName().equals("Employee")){
                            emp = new Employee();
                            emp.setId(Integer.parseInt(xmlStreamReader.getAttributeValue(0)));
                        }else if(xmlStreamReader.getLocalName().equals("name")){
                            bName = true;
                        }else if(xmlStreamReader.getLocalName().equals("age")){
                            bAge = true;
                        }else if(xmlStreamReader.getLocalName().equals("gender")){
                            bGender = true;
                        }else if(xmlStreamReader.getLocalName().equals("role")){
                            bRole = true;
                        }
                    break;
                    case XMLStreamConstants.CHARACTERS:
                        if(bName){
                            emp.setName(xmlStreamReader.getText());
                            bName = false;
                        }else if(bAge){
                            emp.setAge(Integer.parseInt(xmlStreamReader.getText()));
                            bAge = false;
                        }else if(bGender){
                            emp.setGender(xmlStreamReader.getText());
                            bGender = false;
                        }else if(bRole){
                            emp.setRole(xmlStreamReader.getText());
                            bRole = false;
                        }
                    break;
                    case XMLStreamConstants.END_ELEMENT:
                        if(xmlStreamReader.getLocalName().equals("Employee")){
                            emplist.add(emp);
                        }
                    break;
                    
                }
                if(!xmlStreamReader.hasNext())
                    break;
                event = xmlStreamReader.next();
            }
        } catch (XMLStreamException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return emplist;
    }
    
}
