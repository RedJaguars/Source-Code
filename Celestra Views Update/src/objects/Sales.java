package objects;

public class Sales {
	private Client client;
	private OrderList order;
	
	public Sales(Client client, OrderList order) {
		this.client = client;
		this.order = order;
	}
	
	public Client getClient() {
		return this.client;
	}
	
	public OrderList getOrderList() {
		return this.order;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public void setOrderList(OrderList order) {
		this.order = order;
	}

}
