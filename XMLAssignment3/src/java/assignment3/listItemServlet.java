/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Nam NV
 */
public class listItemServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        
    }

    public ArrayList<item> getListFromURL(String iUrl){
        ArrayList<item> item = new ArrayList<item>();
        try {
            // Read the feed...
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            Document doc = factory.newDocumentBuilder().parse(iUrl);
            Element root = doc.getDocumentElement();

            NodeList nodeList = doc.getElementsByTagName("item");
            String imgSource = "";
            String title = "";
            String date = "";
            String link = "";
            String detail = "";
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element e = (Element) nodeList.item(i);
                NodeList nDes = e.getElementsByTagName("description");
                String cdata = nDes.item(0).getTextContent();
                String[] desList = cdata.split("<br />");
                detail = desList[1];
                Pattern p = Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");
                Matcher matcher = p.matcher(cdata);
                if (matcher.find()) {
                    imgSource = matcher.group(1);
                }

                NodeList nTitle = e.getElementsByTagName("title");
                title = nTitle.item(0).getTextContent();
                NodeList npubDate = e.getElementsByTagName("pubDate");
                date = npubDate.item(0).getTextContent();
                NodeList nlink = e.getElementsByTagName("link");
                link = nlink.item(0).getTextContent();
                item.add(new item(imgSource, title, detail, date, link));
            }

        } catch (IOException | ParserConfigurationException | SAXException exp) {
            exp.printStackTrace();
        }
        return item;
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//            processRequest(request, response);
        
        
        ArrayList<item> aItemNews;
        ArrayList<item> aItemMakeup ;
        ArrayList<item> aItemFashion;
        ArrayList<item> aItemHealth ;
        aItemNews = getListFromURL("http://www.24h.com.vn/upload/rss/tintuctrongngay.rss");
        aItemMakeup = getListFromURL("http://www.24h.com.vn/upload/rss/lamdep.rss");
        aItemFashion = getListFromURL("http://www.24h.com.vn/upload/rss/thoitrang.rss");
        aItemHealth = getListFromURL("http://www.24h.com.vn/upload/rss/suckhoedoisong.rss");
        request.setAttribute("listNews", aItemNews);
        request.setAttribute("listMakeup", aItemMakeup);
        request.setAttribute("listFashion", aItemFashion);
        request.setAttribute("listHealth", aItemHealth);
        request.getRequestDispatcher("list.jsp").forward(request, response);
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//            processRequest(request, response);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
