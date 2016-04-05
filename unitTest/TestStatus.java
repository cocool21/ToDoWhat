import static org.junit.Assert.assertEquals;

import org.junit.Test;

import processor.ProcessStatus;

public class TestStatus {
	@Test
	   public void test_get() {
		ProcessStatus s=new ProcessStatus();
		System.out.println("Test if list is available") ;
	     // Subscription S = new Subscription(200,2) ;
	      assertEquals(s.GetStatus(1),"1") ;
	   }
	
}
