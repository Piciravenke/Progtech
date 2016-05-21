
package hu.unideb.inf.maven.prtszamologep;

import javax.persistence.*;

/**
 * Class for the Calculator Entity.
 *  
 */
@Entity
@Table(name = "Calculator")
public class Calculator {
    
    @Id
    @Column(name = "num")    
    @SequenceGenerator(name = "IdGenerator", sequenceName = "num_generator", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IdGenerator")
    private int id;
    @Column(name = "expr")
    private String expression;
    @Column(name = "res")
    private String result;
    @Column(name = "met")
    private String method;
    @Column(name = "dat")
    private String date;

    public Calculator() {
    }

    public Calculator(String expression, String result, String method, String date) {
        
        this.expression = expression;
        this.result = result;
        this.method = method;
        this.date = date;
    }
    
    /**
     * Returns the expression of this object.
     * 
     * @return the expression of this object.
     */
    public String getExpression() {
        return expression;
    }
    
    /**
     * Sets the expression of this object.
     * 
     * @param expression the expression of this object.
     */
    public void setExpression(String expression) {
        this.expression = expression;
    }
    
    /**
     * Returns the result of this object.
     * 
     * @return the result of this object.
     */
    public String getResult() {
        return result;
    }
    
    /**
     * Sets the result of this object.
     * 
     * @param result the result of this object.
     */
    public void setResult(String result) {
        this.result = result;
    }
    
    /**
     * Returns the method of this object.
     * 
     * @return the method of this object.
     */
    public String getMethod() {
        return method;
    }
    
    /**
     * Sets the method of this object.
     * 
     * @param method the method of this object.
     */
    public void setMethod(String method) {
        this.method = method;
    }    
    
    /**
     * Returns the date of this object.
     * 
     * @return the date of this object.
     */
    public String getDate() {
        return date;
    }
    
    /**
     * Sets the date of this object.
     * 
     * @param date the date of this object.
     */
    public void setDate(String date) {
        this.date = date;
    }
    
    /**
     * Returns the id of this object.
     * 
     * @return the id of this object.
     */
    public int getId() {
        return id;
    }
    
    /**
     * Sets the id of this object.
     * 
     * @param id the id of this object.
     */
    public void setId(int id) {
        this.id = id;
    }
    
    
}
