package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity = 500;
	private String alternateEmail;
	private int defaultPasswordLength =  10;
	private String companySuffix = "company.com";
	
	// Constructor to receive the first name and last name 
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;

		
		// call a method asking for the department - return department 
		this.department = setDepartment();

		
		// call a method that return a random password 
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your Password is: "+this.password);
		
		// combine elements to generate email
		email = firstName.toLowerCase() + "."+lastName.toLowerCase() + "@" + department+"." + companySuffix;

	}
	
	// ask for the department 
	private String setDepartment() {
		System.out.println("New worker: "+ firstName +". Enter the department Code \n1 for sales\n2 for Developement\n3 for Accounting\n0 for none\nEnter department code: ");
		Scanner input = new Scanner(System.in); 
		int depchoice = input.nextInt();
		if(depchoice == 1) {
			return "sale";
		}
		else if(depchoice == 2) {
			return "dev" ;
		}
		else if(depchoice == 3) {
			return "account" ;
		}
		else {
			return "";
		}
		
	}
	
	// Generate a random password 
	
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKMLNOPQRSTUVWXYZ1234567890!@#$%";
		char [] password = new char[length];
		for(int i = 0 ;i<length ; i++) {
			int random = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(random);
		}
		return new String(password);
	}
	
	// set the mailbox capacity 
	
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	// Set the alternate email
	public void setAlternateEmail(String altemail) {
		this.alternateEmail = altemail ;
	}
	
	// Change the password 
	public void changePassword(String password) {
		this.password = password ;
	}
	
	public int setMailboxCapacity() {
		return mailboxCapacity ;
	}
	public String getAlternateEmail() {
		return alternateEmail;	
	}
	public String getPassword() {
		return password;
	}
	public String showInfo() {
		return "DISPLAY NAME: " + firstName + " "+ lastName + 
				"\nCOMPANY EMAIL: "+ email + " "+
				"\nMAILBOX CAPACITY: " + mailboxCapacity+"mb";
	}
}
