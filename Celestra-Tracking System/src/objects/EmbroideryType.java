package objects;

public enum EmbroideryType {
	PATCH, BUILTIN;
	
	public static EmbroideryType getEmbroideryType(String type) {
		switch(type) {
		case "PATCH": 	return EmbroideryType.PATCH;
		default:		return EmbroideryType.BUILTIN;
		}
	}
}
