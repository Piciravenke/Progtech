
package hu.unideb.inf.maven.prtszamologep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class CalculateTest {
  
    @Test
    public void calculateTest (){
      Assert.assertEquals("388.0", Calculate.calculate(Calculate.chopping("30+60*4+36/6+7*80/5")));
        
    }
            
    @Test
    public void convertingTest () {
      Assert.assertEquals("1010110110011", Calculate.converting(2, false, "5555"));
        Assert.assertEquals("12663", Calculate.converting(8, false, "5555"));
        Assert.assertEquals("15b3", Calculate.converting(16, false, "5555"));
        Assert.assertEquals("22761", Calculate.converting(2, true, "101100011101001"));
        Assert.assertEquals("136015", Calculate.converting(8, true, "411517"));
        Assert.assertEquals("182399514", Calculate.converting(16, true, "adf321a"));
        Assert.assertEquals("Hiba: karakter nem található az adott számrendszerben!", Calculate.converting(2, true, "5555"));
       
    }
    
    @Test   
    public void choppingTest () {
        List<String> test = Arrays.asList("30","+","60","*","4","+","36","/","6","+","7","*","80","/","5");
        Assert.assertEquals(test, Calculate.chopping("30+60*4+36/6+7*80/5"));
        
    }
    
    @Test
    public void operationTest () {
       Assert.assertEquals("155.0", Calculate.add(99, 56));
        Assert.assertEquals("62.0", Calculate.sub(99, 37));
        Assert.assertEquals("9.0", Calculate.div(54, 6));
        Assert.assertEquals("108.0", Calculate.multi(12, 9));
        
    }
}
