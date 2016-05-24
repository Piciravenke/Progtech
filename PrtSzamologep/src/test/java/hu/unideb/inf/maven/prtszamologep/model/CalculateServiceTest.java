
package hu.unideb.inf.maven.prtszamologep.model;

import java.time.LocalDateTime;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Assert;
import org.junit.Test;


public class CalculateServiceTest {
    @Test
    
    public void createCalculatorTest () {
      
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("db");
        EntityManager em = emf.createEntityManager();
        CalculatorService service = new CalculatorService(em);
        int i = service.findAllCalculator().size();
        
        service.createCalculator( "1+1", "2", "teszt", LocalDateTime.now().toString());
        Assert.assertEquals(i+1,service.findAllCalculator().size());
        em.getTransaction().rollback();
    
    }
}
