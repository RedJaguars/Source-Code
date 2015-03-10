
public class Client {
	private int clientID;
	private String lastName;
	private String firstName;
	private char gender;
	private String contactNo;
	private String email;
	
	public Client(){}
	
	public Client(int clientID, String lastName, String firstName, char gender, String contactNo, String email) {
		this.clientID = clientID;
		this.lastName = lastName;
		this.firstName = firstName;
		this.gender = gender;
		this.contactNo = contactNo;
		this.email = email;
	}


	public int getClientID() {
		return clientID;
	}


	public void setClientID(int clientID) {
		this.clientID = clientID;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public char getGender() {
		return gender;
	}


	public void setGender(char gender) {
		this.gender = gender;
	}


	public String getContactNo() {
		return contactNo;
	}


	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
