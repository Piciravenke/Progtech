/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.maven.prtszamologep;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author miki
 */
public class Calculator {
    private List<String> expression;
    private String result;
    private String method;
    private String date;

    public Calculator() {
    }

    public Calculator(List<String> expression, String result, String method, String date) {
        this.expression = expression;
        this.result = result;
        this.method = method;
        this.date = date;
    }

    public List<String> getExpression() {
        return expression;
    }

    public void setExpression(List<String> expression) {
        this.expression = expression;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }    

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
}
