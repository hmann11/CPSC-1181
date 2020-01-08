/*
 * Using private or public with a method so that what it can do or see with the object passed is restricted. Also called information hiding.
 * Encapsulation gives access to some details, their is flexibility (data hidding involves completely hiding the data). 
 */
public class encapsulation {
       private double balance=5.0;
       
       public void withdraw(double amt) {
    	   if(this.isValid(amt)) {
    		   this.balance-=amt;
    	   }
       }
	public static void main(String[] args) {
		

	}

}
