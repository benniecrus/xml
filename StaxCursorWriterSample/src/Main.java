
import com.sun.xml.internal.stream.StaxXMLInputSource;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String fileName = "employee.xml";
        String rootElement = "Employee";
        Main main = new Main();
        Map<String, String> elementsMap = new HashMap<String, String>();
        elementsMap.put("id", "1");
        elementsMap.put("name", "Nam");
        elementsMap.put("age", "23");
        elementsMap.put("gender", "Male");
        elementsMap.put("role", "Dev");
        main.writeXML(fileName, rootElement, elementsMap);
    }
    
    public void writeXML(String fileName, String rootElement, Map<String, String> elementsMap)
    {
        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
        try {
            XMLStreamWriter xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(new FileOutputStream(fileName), "UTF-8");
            //Start writing xml file
            xmlStreamWriter.writeStartDocument("UTF-8","1.0");
            xmlStreamWriter.writeCharacters("\n");
            xmlStreamWriter.writeStartElement(rootElement);
            
            //Write id as attribute
            xmlStreamWriter.writeAttribute("id", elementsMap.get("id"));
            
            //Write other elements
            xmlStreamWriter.writeCharacters("\n\t");
            xmlStreamWriter.writeStartElement("name");
            xmlStreamWriter.writeCharacters("\n\t\t"+elementsMap.get("name"));
            xmlStreamWriter.writeCharacters("\n\t");
            xmlStreamWriter.writeEndElement();
            
            xmlStreamWriter.writeCharacters("\n\t");
            xmlStreamWriter.writeStartElement("age");
            xmlStreamWriter.writeCharacters("\n\t\t"+elementsMap.get("age"));
            xmlStreamWriter.writeCharacters("\n\t");
            xmlStreamWriter.writeEndElement();
            
            xmlStreamWriter.writeCharacters("\n\t");
            xmlStreamWriter.writeStartElement("gender");
            xmlStreamWriter.writeCharacters("\n\t\t"+elementsMap.get("gender"));
            xmlStreamWriter.writeCharacters("\n\t");
            xmlStreamWriter.writeEndElement();
            
            xmlStreamWriter.writeCharacters("\n\t");
            xmlStreamWriter.writeStartElement("role");
            xmlStreamWriter.writeCharacters("\n\t\t"+elementsMap.get("role"));
            xmlStreamWriter.writeCharacters("\n\t");
            xmlStreamWriter.writeEndElement();
            
            //write end tag of Employee element
            xmlStreamWriter.writeCharacters("\n");
            
            //write end document
            xmlStreamWriter.writeEndDocument();
            
            //flush data to file and close writer
            xmlStreamWriter.flush();
            xmlStreamWriter.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XMLStreamException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
