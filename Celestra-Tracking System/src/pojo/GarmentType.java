/*
	BOTTOM: Includes Pants, Skirts, and anything of the like;
	TOP:	Includes shirts, blouses, jackets, blazers, anything of the like;
	OUTFIT:	A combination of Top and bottom, this includes items like Dresses and Scrubs
*/
package pojo;
public enum GarmentType {
	BOTTOM, TOP, OUTFIT;
	
	public static GarmentType getGarmentType(String type) {
		switch(type) {
		case "TOP": 	return GarmentType.TOP;
		case "BOTTOM":	return  GarmentType.BOTTOM;
		default:		return GarmentType.OUTFIT; 
	}
	}
}
