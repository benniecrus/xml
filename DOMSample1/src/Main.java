
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


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
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("students.xml"));
            
            Element root = doc.getDocumentElement();
            NodeList students = root.getChildNodes();
            for(int i = 0; i<students.getLength(); i++)
            {
                Node student = students.item(i);
                if(student.getNodeType() == Node.ELEMENT_NODE)
                {
                    NamedNodeMap studentAttributes = student.getAttributes();
                    Node roll = studentAttributes.getNamedItem("roll");
                    System.out.println("\nRoll: "+roll.getNodeValue());
                    
                    NodeList childsOfStudent = student.getChildNodes();
                    
                    for(int j = 0; j < childsOfStudent.getLength(); j++)
                    {
                        Node child = childsOfStudent.item(j);
                        if(child.getNodeType() == Node.ELEMENT_NODE)
                        {
                            if(child.getNodeName().equals("name"))
                            {
                                System.out.println("Name: "+child.getTextContent());
                            }
                            if(child.getNodeName().equals("age"))
                            {
                                System.out.println("Age: "+child.getTextContent());
                            }
                            if(child.getNodeName().equals("class"))
                            {
                                System.out.println("Class: "+child.getTextContent());
                            }
                        }
                    }
                    
                }
            }
            
        }
        catch(Exception ex){}
    }
    
}
