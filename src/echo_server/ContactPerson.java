package echo_server;

public class ContactPerson {
	private String EmailAddress;
	private String FirstName;
	private String LastName;
	private String PhoneNumber;
	public ContactPerson() {
		// TODO Auto-generated constructor stub
	}
	 public void setEmailAddress(String add){
		   System.out.println("setEmailAddress");
		   this.EmailAddress=add;
	   }
	   public void setFirstName(String add){
		   System.out.println("setFirstName");
		   this.FirstName=add;
	   }
	   public void setLastName(String add){
		   System.out.println("setLastName");
		  this.LastName=add;	  
	   }
	   public void setPhoneNumber(String add){
		  this.PhoneNumber=add;
	   }
	   public String getEmailAddress(){
		   return this.EmailAddress;
	   }
	   public String getFirstNam(){
		   return this.FirstName;
	   }
	   public String getLastName(){
		   return this.LastName;	  
	   }
	   public String getPhoneNumber(){
		   return this.PhoneNumber;
	   }
	   public void All(){
		   System.out.println(LastName+"-"+FirstName+"-"+EmailAddress);
	   }
}
