
import app.controller.IntervalProcessor;
import com.sun.media.jfxmedia.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestIntervals {
    
    IntervalProcessor intervalProcessor;
    
    @Before
    public void initialize(){
        intervalProcessor = new IntervalProcessor();
    }
    
    @Test
    public void testIntervalProcessor(){
        
     /*intervalProcessor.addNewInterval(4, 6);
       intervalProcessor.addNewInterval(8, 10);
       intervalProcessor.addNewInterval(11, 16);
       intervalProcessor.addNewInterval(5, 9);
       
       intervalProcessor.addNewInterval(1, 3); 
       intervalProcessor.addNewInterval(3, 5);    

      */
     
     intervalProcessor.addNewInterval(3, 5);   
     intervalProcessor.addNewInterval(2, 4);   
     
     intervalProcessor.addNewInterval(1, 8);   
     
      
    }
     
    @After
    public void checkResults(){
      
        System.out.println(intervalProcessor.toString());
       // Assert.assertEquals(intervalProcessor.toString(), "Ilość przedziałow: 2 <1, 10> <11, 16>"); 
    }
    
}
