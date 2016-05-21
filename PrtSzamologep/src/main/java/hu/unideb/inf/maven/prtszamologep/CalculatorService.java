
package hu.unideb.inf.maven.prtszamologep;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 * Class for the Calculator Services.
 * 
 * 
 */
public class CalculatorService {
    
    private static EntityManager em;

    public CalculatorService(EntityManager em) {
        this.em = em;
    }
    
    /**
     * Creates a new Calculator object in the given table.
     * 
     * @param expression the expression of a Calculator object.
     * @param result the result of a Calculator object.
     * @param method the method of a Calculator object
     * @param date the date of a Calculator object
     */
    public static void createCalculator(String expression, String result, String method, String date) {
        em.getTransaction().begin();
        Calculator calc = new Calculator(expression, result, method, date);        
        em.persist(calc);
        em.getTransaction().commit();
        
    }            
    
    /**
     * Returns the list of the Calculator objects in the table.
     * 
     * @return the list of the Calculator objects in the table.
     */
    public static List<Calculator> findAllCalculator() {
        TypedQuery<Calculator> query = em.createQuery("SELECT e FROM hu.unideb.inf.maven.prtszamologep.Calculator e", Calculator.class);
      // TypedQuery<Calculator> query = em.createQuery("SELECT * FROM Calculator", Calculator.class);
        return query.getResultList();
    }
}
