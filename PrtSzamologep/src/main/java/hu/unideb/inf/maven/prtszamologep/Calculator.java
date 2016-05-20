/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.maven.prtszamologep;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Calculator")
public class Calculator {
    
    @Id
    @Column(name = "id")
    int id;
    @Column(name = "expression")
    private String expression;
    @Column(name = "result")
    private String result;
    @Column(name = "method")
    private String method;
    @Column(name = "date")
    private String date;

    public Calculator() {
    }

    public Calculator(int id,String expression, String result, String method, String date) {
        this.id = id;
        this.expression = expression;
        this.result = result;
        this.method = method;
        this.date = date;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
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
