import static org.junit.Assert.* ;

import org.junit.Test;


import processor.ProcessUser;

public class TestUser {
	
	@Test
	   public void test_importsingleproduct() {
		ProcessUser pp=new ProcessUser();
	      System.out.println("Test if table has been sucessfully imported") ;
	      int id=pp.UserLogin("user1", "pass1");
	     // Subscription S = new Subscription(200,2) ;
	      assertEquals(id,1) ;
	   }

}

