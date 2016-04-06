import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import model.ToDoList;
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
		List<ToDoList> lists=pl.getList(1);
		for(ToDoList list:lists){
			System.out.println(list.getId());
		}
	      assertEquals(lists.size(),2) ;
	   }
	
	
}
