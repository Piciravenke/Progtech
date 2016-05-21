
package hu.unideb.inf.maven.prtszamologep;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


public class CalculatorService {
    
    private static EntityManager em;

    public CalculatorService(EntityManager em) {
        this.em = em;
    }
    
    public static void createCalculator(String expression, String result, String method, String date) {
        em.getTransaction().begin();
        Calculator calc = new Calculator(expression, result, method, date);        
        em.persist(calc);
        em.getTransaction().commit();
        
    }            
    
    public static List<Calculator> findAllCalculator() {
        TypedQuery<Calculator> query = em.createQuery("SELECT e FROM hu.unideb.inf.maven.prtszamologep.Calculator e", Calculator.class);
      // TypedQuery<Calculator> query = em.createQuery("SELECT * FROM Calculator", Calculator.class);
        return query.getResultList();
    }
}
