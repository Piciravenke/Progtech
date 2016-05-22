
package hu.unideb.inf.maven.prtszamologep;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.slf4j.LoggerFactory;

/**
 * Class for the Calculator Services.
 * 
 * 
 */
public class CalculatorService {
    
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(Calculate.class);
    private static EntityManager em;
    
    /**
     * One paramtered constructor for class CalculatorService.
     * 
     * @param em  the entitymanager of this object
     */
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
        
         logger.info("New Calculator committed");
    }            
    
    /**
     * Returns the list of the Calculator objects in the table.
     * 
     * @return the list of the Calculator objects in the table.
     */
    public static List<Calculator> findAllCalculator() {
        TypedQuery<Calculator> query = em.createQuery("SELECT e FROM hu.unideb.inf.maven.prtszamologep.Calculator e", Calculator.class);
        logger.info("Calculators listed");
        return query.getResultList();
    }
}
