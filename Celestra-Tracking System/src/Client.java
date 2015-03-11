
public class Client {
	private int clientID;
	private String lastName;
	private String firstName;
	private String gender;
	private String contactNo;
	private String email;
	
	public Client(){}
	
	private Client(ClientBuilder builder) {
		this.lastName = builder.lastName;
		this.firstName = builder.firstName;
		this.gender = builder.gender;
		this.contactNo = builder.contactNo;
		
		this.email = builder.email;
		this.clientID = builder.clientID;
	}
	
	public static class ClientBuilder {
		private final String lastName;
		private final String firstName;
		private final String gender;
		private final String contactNo;
		
		private String email = null;
		private int clientID = 0;
		
		public ClientBuilder(String lastName, String firstName, String gender, String contact) {
			this.lastName = lastName;
			this.firstName = firstName;
			this.gender = gender;
			this.contactNo = contact;
		}
		
		public ClientBuilder clientID(int id) {
			this.clientID = id;
			return this;
		}
		
		public ClientBuilder email(String email) {
			this.email = email;
			return this;
		}
		
		public Client build() {
			return new Client(this);
		}
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


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
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
