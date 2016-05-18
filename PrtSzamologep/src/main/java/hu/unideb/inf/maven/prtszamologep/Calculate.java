/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.maven.prtszamologep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author miki
 */
public class Calculate {
   
    
    public List<String> calculate(List<String> list) {
        
        while(list.size() > 1){
        
            if (list.indexOf("*") > 0){
                
            }
        }
        
        return null;
    }
    
    public List<String> chopping(String s) {
        
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
}
