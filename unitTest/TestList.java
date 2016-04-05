import static org.junit.Assert.assertEquals;

import org.junit.Test;
import processor.ProcessList;






public class TestList {
	//	Calendar cal = Calendar.getInstance();
	// cal.setTimeInMillis(0);
	//	cal.set(2016, 04, 1);;
	//	Date d = cal.getTime();
	    
	@Test
	   public void test_get() {
		ProcessList pl=new ProcessList();
		System.out.println("Test if list is available") ;
	     // Subscription S = new Subscription(200,2) ;
	      assertEquals(pl.getList(2).size(),1) ;
	   }
	
}
