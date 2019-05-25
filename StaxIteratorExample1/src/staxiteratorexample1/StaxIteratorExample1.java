/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staxiteratorexample1;

import java.awt.Event;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class StaxIteratorExample1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StaxIteratorExample1 stax = new StaxIteratorExample1();
        
        List<Book> lst = stax.getBook();
        
        
        for(int i = 0; i<lst.size();i++)
        {
            Book book = lst.get(i);
            System.out.println(book.toString());
        }
        
        stax.writeBook(lst);
        
    }
    
    private List<Book> getBook(){
        List<Book> lstBook = new ArrayList<>();
        Book book = new Book();
        XMLInputFactory factory = XMLInputFactory.newFactory();
        
        try {
            
            XMLEventReader reader = factory.createXMLEventReader(new FileInputStream("book.xml"));
            
            while(reader.hasNext())
            {
                XMLEvent event = reader.nextEvent();
                
                if(event.isStartElement()){
                    StartElement sElement = event.asStartElement();
                    
                    if(sElement.getName().toString().equals("book"))
                    {
                        book = new Book();
                        Attribute id = sElement.getAttributeByName(new QName("id"));
                        book.setId(id.getValue());
                    }
                    if(sElement.getName().toString().equals("author"))
                    {
                        XMLEvent e = reader.nextEvent();
                        Characters author = e.asCharacters();
                        book.setAuthor(author.getData());
                    }
                    if(sElement.getName().toString().equals("title"))
                    {
                        XMLEvent e = reader.nextEvent();
                        Characters title = e.asCharacters();
                        book.setTitle(title.getData());
                    }
                    if(sElement.getName().toString().equals("genre"))
                    {
                        XMLEvent e = reader.nextEvent();
                        Characters genre = e.asCharacters();
                        book.setGenre(genre.getData());
                    }
                    if(sElement.getName().toString().equals("price"))
                    {
                        XMLEvent e = reader.nextEvent();
                        Characters price = e.asCharacters();
                        book.setPrice(Float.parseFloat(price.getData()));
                    }
                    if(sElement.getName().toString().equals("publish_date"))
                    {
                        XMLEvent e = reader.nextEvent();
                        Characters date = e.asCharacters();
                        book.setPublish_date(date.getData());
                    }
                    if(sElement.getName().toString().equals("description")){
                        XMLEvent e = reader.nextEvent();
                        Characters description = e.asCharacters();
                        book.setDescription(description.getData());
                    }
                }
                if(event.isEndElement())
                {
                    EndElement endElement = event.asEndElement();
                    if(endElement.getName().toString().equals("book") && Integer.parseInt(getYear(book.getPublish_date())) == 2000 ){
                        lstBook.add((book));
                    }
                }
                
            }
            
        } catch (XMLStreamException ex) {
            Logger.getLogger(StaxIteratorExample1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StaxIteratorExample1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lstBook;
    }
    
    private void writeBook(List<Book> lst)
    {
        XMLOutputFactory factory = XMLOutputFactory.newFactory();
        
        try {
            XMLEventWriter writer = factory.createXMLEventWriter(new FileOutputStream("book1.xml"));
            
            XMLEventFactory EFactor = XMLEventFactory.newFactory();
            
            writer.add(EFactor.createStartDocument("UTF-8","1.0"));
            writer.add(EFactor.createCharacters("\n"));
            writer.add(EFactor.createStartElement("", "", "catalog"));
            if(lst.size()>0){
            for(int i = 0; i< lst.size(); i++){
                
                Book b = lst.get(i);
                
                writer.add(EFactor.createStartElement("", "", "book"));
            
                writer.add(EFactor.createAttribute("id", b.getId()));
                writer.add(EFactor.createCharacters("\n\t"));
            
                writer.add(EFactor.createStartElement("", "", "author"));
                writer.add(EFactor.createCharacters(b.getAuthor()));
                writer.add(EFactor.createEndElement("", "", "author"));
                writer.add(EFactor.createCharacters("\n\t"));
            
                writer.add(EFactor.createStartElement("", "", "title"));
                writer.add(EFactor.createCharacters(""+b.getTitle()));
                writer.add(EFactor.createEndElement("", "", "title"));
                writer.add(EFactor.createCharacters("\n"));
            
                writer.add(EFactor.createStartElement("", "", "genre"));
                writer.add(EFactor.createCharacters(""+b.getGenre()));
                writer.add(EFactor.createEndElement("", "", "genre"));
                writer.add(EFactor.createCharacters("\n"));
                
                writer.add(EFactor.createStartElement("", "", "price"));
                writer.add(EFactor.createCharacters(""+b.getPrice()));
                writer.add(EFactor.createEndElement("", "", "price"));
                writer.add(EFactor.createCharacters("\n"));
                
                writer.add(EFactor.createStartElement("", "", "publish_date"));
                writer.add(EFactor.createCharacters(""+b.getPublish_date()));
                writer.add(EFactor.createEndElement("", "", "publish_date"));
                writer.add(EFactor.createCharacters("\n"));
                
                writer.add(EFactor.createStartElement("", "", "description"));
                writer.add(EFactor.createCharacters(""+b.getDescription()));
                writer.add(EFactor.createEndElement("", "", "description"));
                writer.add(EFactor.createCharacters("\n"));
                
                writer.add(EFactor.createEndElement("", "", "book"));
            }
            
            writer.add(EFactor.createEndElement("", "", "catalog"));
            writer.add(EFactor.createEndDocument());
            }
            
        
        } catch (XMLStreamException ex) {
            Logger.getLogger(StaxIteratorExample1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StaxIteratorExample1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String getYear(String s){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String year="";
        try
        {
            Date date = simpleDateFormat.parse(s);
            
            SimpleDateFormat df = new SimpleDateFormat("yyyy");
            
            year = df.format(date);
        }
        catch (ParseException ex)
        {
            System.out.println("Exception "+ex);
        }
        return year;
        
    }
    
}
