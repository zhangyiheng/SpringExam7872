package com.hand.log;

public class Logging {
	 public void beforeAdvice(){
	      System.out.println("Before Insert Film Data.");
	   }

	   public void afterAdvice(){
	      System.out.println("After Insert Film Data.");
	   }

	   public void afterReturningAdvice(Object retVal){
	      System.out.println("Returning:" + retVal.toString() );
	   }

	   public void AfterThrowingAdvice(IllegalArgumentException ex){
	      System.out.println("There has been an exception: " + ex.toString());   
	   } 
}
