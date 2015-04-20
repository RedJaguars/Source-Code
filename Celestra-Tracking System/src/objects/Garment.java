package objects;

public enum Garment {
	COAT(GarmentType.TOP),
	POLO(GarmentType.TOP),
	BARONG(GarmentType.TOP),
	LONGBLAZER(GarmentType.TOP),
	SHORTBLAZER(GarmentType.TOP),
	VEST(GarmentType.TOP),
	BLOUSE(GarmentType.TOP),
	SHIRT(GarmentType.TOP),
	JACKET(GarmentType.TOP),
	PANTS(GarmentType.BOTTOM),
	SKIRT(GarmentType.BOTTOM),
	SHORTS(GarmentType.BOTTOM),
	APRON(GarmentType.BOTTOM),
	OTHER(GarmentType.OTHER);
	
	private GarmentType garmentType;
	private Garment(GarmentType type) {
		this.garmentType = type;
	}
	
	public GarmentType getGarmentType() {
		return garmentType;
	}
	
	public static Garment getGarment(String garment) {
		switch(garment) {
			case "COAT": return COAT;
			case "POLO": return POLO;
			case "BARONG": return BARONG;
			case "LONGBLAZER": return LONGBLAZER;
			case "SHORTBLAZER": return SHORTBLAZER;
			case "VEST": return VEST;
			case "BLOUSE": return BLOUSE;
			case "SHIRT": return SHIRT;
			case "JACKET": return JACKET;
			case "PANTS": return PANTS;
			case "SKIRT": return SKIRT;
			case "SHORTS": return SHORTS;
			case "APRON": return APRON;
			default : return OTHER;
		}
	}
}
