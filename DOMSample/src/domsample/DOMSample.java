/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domsample;

import com.sun.org.apache.bcel.internal.generic.F2D;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author datdh
 */
public class DOMSample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("students.xml"));
            
//            TransformerFactory transformerFactory = TransformerFactory.newInstance();
//            Transformer transformer = transformerFactory.newTransformer();
//            DOMSource source = new DOMSource(doc);
//            Result result = new StreamResult(new File("student.xml"));
//            transformer.transform(source, result);
            
            Element root = doc.getDocumentElement();
            NodeList students = root.getChildNodes();
            for (int i = 0; i < students.getLength(); i++) {
                Node student = students.item(i);
                if (student.getNodeType() == Node.ELEMENT_NODE) {
                    NamedNodeMap studentAttributes = student.getAttributes();
                    Node roll = studentAttributes.getNamedItem("roll");
                    System.out.println("\nRoll: " + roll.getNodeValue());
                    
                    NodeList childsOfStudent = student.getChildNodes();
                    
                    for (int j = 0; j < childsOfStudent.getLength(); j++) {
                        Node child = childsOfStudent.item(j);
                        if (child.getNodeType() == Node.ELEMENT_NODE) {
                            if (child.getNodeName().equals("name")) {
                                System.out.println("Name: " + child.getTextContent());
                            }
                            if (child.getNodeName().equals("age")) {
                                System.out.println("Age: " + child.getTextContent());
                            }
                            if (child.getNodeName().equals("address")) {
                                System.out.println("Address: " + child.getTextContent());
                            }
                        }
                    }
                }
            }
            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(DOMSample.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
