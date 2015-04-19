package objects;

public enum Unit {
	ROLL, INCH, CENTIMETER, FOOT, YARD;
	
	public static Unit getUnit(String unit) {
		switch(unit) {
			case "ROLL": return ROLL;
			case "INCH": return INCH;
			case "CENTIMETER": return CENTIMETER;
			case "YARD" : return YARD;
			default : return FOOT;
		}
	}
}
