package objects;

public enum Unit {
	ROLL, INCH, CENTIMETER, FOOT;
	
	public static Unit getUnit(String unit) {
		switch(unit) {
			case "ROLL": return ROLL;
			case "INCH": return INCH;
			case "CENTIMETER": return CENTIMETER;
			default : return FOOT;
		}
	}
}
