package labcodeinspection;

import java.util.Locale;

public class Email {

	private String m_firstName; //NOPMD Este campo será manipulado más tarde
	private String m_lastName; //NOPMD Este campo será manipulado más tarde
	private transient String password; 
	private transient String department;
	private transient final int defaultpasswordLength = 8;
	private transient String email;

	/**
	*
	*
	* @author Ricardo Salazar
	*/
	public Email(String firstName, String lastName) {
		this.m_firstName = firstName;
		this.m_lastName = lastName;
	}

	/**
	*
	*
	* @author Ricardo Salazar
	*/
	public void showInfo() {
		System.out.println("\nFIRST NAME= " + m_firstName + "\nLAST NAME= " + m_lastName);
		System.out.println("DEPARMENT= " + department + "\nEMAIL= " + email + "\nPASSWORD= " + password);
	}
	
	

	/**
	*
	*
	* @author Ricardo Salazar
	*/
	public void setDeparment(int depChoice) {
		switch (depChoice) {
		case 1:
			this.department = "sales";
			break;
		case 2:
			this.department = "dev";
			break;
		case 3:
			this.department = "acct";
			break;
		default:
			this.department = "sales";
            break;
		}
	}

	private String randomPassword(int length) {
		String set = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890#$&@*";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * set.length());
			password[i] = set.charAt(rand);
		}
		String pass = new String(password);//NOPMD La lógica pide que se realice de esta manera.
		return pass;
	}
	
	/**
	*
	*
	* @author Ricardo Salazar
	*/
	public void generateEmail() {
		this.password = this.randomPassword(this.defaultpasswordLength);
		String lowerCase_m_firstName = this.m_firstName.toLowerCase(Locale.getDefault());
		String lowerCase_m_lastName = this.m_lastName.toLowerCase(Locale.getDefault());
		this.email = lowerCase_m_firstName + lowerCase_m_lastName + "@" + this.department
				+ ".espol.edu.ec";
	}
}
