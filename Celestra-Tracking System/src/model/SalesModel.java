package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

import objects.Client;
import objects.OrderList;
import objects.Sales;

public class SalesModel extends Model {

	public SalesModel() {
		super();
	}

	@Override
	public Iterator<?> getModelList() throws SQLException {
		modelList.removeAll(modelList);
		ResultSet salesList = con.getConnection().prepareStatement("SELECT * FROM orderList").executeQuery();
		
		while(salesList.next()) {
			
			Client client = ClientModel.getClientByID(salesList.getInt("clientID"));
			OrderList orderlist = OrderModel.getOrderListByID(salesList.getInt("orderListID"));
			Sales sale = new Sales(client, orderlist);
			
			modelList.add(sale);
		}
		return modelList.iterator();
	}

}
