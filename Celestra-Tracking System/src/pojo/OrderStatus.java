package pojo;
public enum OrderStatus {
	PENDING, FULFILLED, CANCELLED;
	
	public static OrderStatus getStatus(String type) {
		switch(type) {
		case "PENDING": 	return OrderStatus.PENDING;
		case "FULFILLED": 	return OrderStatus.FULFILLED;
		default: 			return OrderStatus.CANCELLED;
	}
	}
}
