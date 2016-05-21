package hu.unideb.inf.maven.prtszamologep;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class for the calculating methods.
 * 
 */
public class Calculate {
   
    /**
     * Returns the converted value of the input expression.
     * 
     * @param numb the number of the scale, which we using to convert.
     * @param vissza the boolean which tells us to use the reverse convert.
     * @param s the input expression.
     * @return the result string.
     */
    public static String converting(int numb,boolean vissza,String s){
        BigInteger input;
        String a;
        if(vissza){ 
            try{           
                input = new BigInteger(s,numb);
                a=input.toString();
               }catch(NumberFormatException e){
                a ="Hiba: karakter nem található az adott számrendszerben!";
               }
            }
        
        else{                              
            input = new BigInteger(s);   
            a = input.toString(numb);
        }  
        return a;
    }
    
    /**
     * Returns the calculated value of the formatted input expression.
     *
     * @param list the formatted list of the input epxression.
     * @return the result string.
     */
    public static String calculate(List<String> list) {
        
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
        if(!list.get(0).equals("Infinity"))
            return list.get(0);
        else
            return "Hiba: 0-val nem osztunk!";
    }
    
    /**
     * Returns the formatted input expression.
     * 
     * @param s the inpust expression.
     * @return the formatted input expression.
     */
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
    
    /**
     * Returns the result of a + b.
     * 
     * @param a the first input double
     * @param b the second input double
     * @return a + b.
     */
    public static String add(double a, double b) {
        return Double.toString(a+b);
    }
    
    /**
     * Returns the result of a - b.
     * 
     * @param a the first input double
     * @param b the second input double
     * @return a - b.
     */
    public static String sub(double a, double b) {
        return Double.toString(a-b);
    }
    
    /**
     * Returns the result of a * b.
     * 
     * @param a the first input double
     * @param b the second input double
     * @return a * b.
     */
    public static String multi(double a, double b) {
        return Double.toString(a*b);
    }
    
    /**
     * Returns the result of a / b.
     * 
     * @param a the first input double
     * @param b the second input double
     * @return a / b.
     */
    public static String div(double a, double b) {
        return Double.toString(a/b);
    }
}
