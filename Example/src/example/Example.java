/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Nam NV
 */
public class Example {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s = "2000-11-17";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try
        {
            Date date = simpleDateFormat.parse(s);
            
            SimpleDateFormat df = new SimpleDateFormat("yyyy");
            
            String year = df.format(date);
            
            System.out.println("date : "+year);
        }
        catch (ParseException ex)
        {
            System.out.println("Exception "+ex);
        }
    }
    
}
