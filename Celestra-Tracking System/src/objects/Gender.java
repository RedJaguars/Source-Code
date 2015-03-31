package objects;

public enum Gender {
	MALE, FEMALE;
	
	public static Gender getGender(String type) {
		switch(type) {
		case "MALE": 	return Gender.MALE;
		default:		return Gender.FEMALE;
	}
	}
}
