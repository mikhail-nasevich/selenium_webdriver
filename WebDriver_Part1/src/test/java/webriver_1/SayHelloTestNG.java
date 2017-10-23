package webriver_1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SayHelloTestNG {
	
	Object test = new Object();
 
  @Test
  public void foxy() {
	  		System.out.println("I am Mikhail:" + test.toString());
	  		Assert.assertTrue(true, "Error occured! Test failed as expected");
  }
  
}