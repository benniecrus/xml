
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nam NV
 */
public class ProductHandler extends DefaultHandler{
    boolean check = false;
    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        super.fatalError(e); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        super.error(e); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        super.warning(e); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length); //To change body of generated methods, choose Tools | Templates.
        String s = new String(ch, start, length);
        if(s.trim().length() > 0 && check == true){
        System.out.println(s);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName); //To change body of generated methods, choose Tools | Templates.
//        System.out.println("\tThẻ đóng");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes); //To change body of generated methods, choose Tools | Templates.
//        System.out.println("\tThẻ mở");
        if(qName.equals("name")){
            check = true;
        }
        else check = false;
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument(); //To change body of generated methods, choose Tools | Templates.
//        System.out.println("kết thúc đọc tài liệu");
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument(); //To change body of generated methods, choose Tools | Templates.
//        System.out.println("Bắt đầu đọc tài liệu");
    }
    
}
