/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.maven.prtszamologep;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author miki
 */
public class Calculate {
   
    
    public static String converting(int numb,boolean vissza,String s){
        BigInteger input;
        String a;
        if(vissza){ 
            try{           
                input = new BigInteger(s,numb);
                a=input.toString();
               }catch(NumberFormatException e){
                a ="Hiba: Nem megfelelő karakter(ek)";
               }
            }
        
        else{                              
            input = new BigInteger(s);   
            a = input.toString(numb);
        }  
        return a;
    }
    
    public static List<String> calculate(List<String> list) {
        
        if(list.size() > 1){
        
            while (list.indexOf("*") >= 0){
                list.set(list.indexOf("*")-1, 
                        multi(Double.parseDouble(list.get(list.indexOf("*")-1)), 
                                Double.parseDouble(list.get(list.indexOf("*")+1))));
                list.remove(list.indexOf("*")+1);
                list.remove(list.indexOf("*"));               
            }
             while (list.indexOf("/") >= 0){
                list.set(list.indexOf("/")-1, 
                        div(Double.parseDouble(list.get(list.indexOf("/")-1)), 
                                Double.parseDouble(list.get(list.indexOf("/")+1))));
                list.remove(list.indexOf("/")+1);
                list.remove(list.indexOf("/"));                
            }
             while (list.indexOf("-") >= 0){
                list.set(list.indexOf("-")-1, 
                        sub(Double.parseDouble(list.get(list.indexOf("-")-1)), 
                                Double.parseDouble(list.get(list.indexOf("-")+1))));
                list.remove(list.indexOf("-")+1);
                list.remove(list.indexOf("-"));                
            }         
              while (list.indexOf("+") >= 0){
                list.set(list.indexOf("+")-1, 
                        add(Double.parseDouble(list.get(list.indexOf("+")-1)), 
                                Double.parseDouble(list.get(list.indexOf("+")+1))));
                list.remove(list.indexOf("+")+1);
                list.remove(list.indexOf("+"));                
            }              
        }
        
        return list;
    }
    
    public static List<String> chopping(String s) {
        
        List<String> ret = new ArrayList<String>();		 
	List<String> nmb = new ArrayList<String>(Arrays.asList(s.split("[+-////*/]")));
	List<String> sign2 = new ArrayList<String>();
	List<String> sign = new ArrayList<String>(Arrays.asList(s.split("[0123456789]*")));
	for (String currSign : sign){
	    currSign = currSign.trim();
	    if (!currSign.equals("")){
	    	sign2.add(currSign);
            }
	    	
	 }
	for (String curr : sign2){
	    		ret.add(nmb.get(0));
	    		nmb.remove(0);
	    		ret.add(curr);
	    	}
	ret.add(nmb.get(nmb.size()-1));
	return ret;
        
    }
    public static String add(double a, double b) {
        return Double.toString(a+b);
    }
    public static String sub(double a, double b) {
        return Double.toString(a-b);
    }
    public static String multi(double a, double b) {
        return Double.toString(a*b);
    }
    public static String div(double a, double b) {
        return Double.toString(a/b);
    }
}
