package model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.util.Iterator;

import javax.sql.rowset.serial.SerialBlob;

import database.DatabaseConnection;
import objects.Alteration;
import objects.BottomMeasurement;
import objects.Client;
import objects.Embroidery;
import objects.EmbroideryType;
import objects.Garment;
import objects.GarmentOrder;
import objects.Gender;
import objects.Measurement;
import objects.OrderDetail;
import objects.OrderItem;
import objects.OrderList;
import objects.OrderStatus;
import objects.TopMeasurement;
import objects.WomensTopMeasure;

public class OrderModel extends Model{
	public OrderModel() {
		super();
		try {
			getModelList();
		}catch(SQLException err) {
			err.printStackTrace();
		}
	}
	
	/* Adds a new order to the database*/
	@SuppressWarnings("resource")
	public void addNewOrder(OrderList order) throws SQLException {
		ClientModel clientModel = new ClientModel();
		Client client = clientModel.addClient(order.getClient());
		String statement = "INSERT INTO order_list(orderDate, dueDate, totalPrice, balance, pickupLocation, clientID, status, receiptNo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = con.getConnection().prepareStatement(statement);
		
		ps.setDate(1, order.getOrderDate());
		ps.setDate(2, order.getDueDate());
		ps.setDouble(3, order.getTotalPrice());
		ps.setDouble(4, order.getBalance());
		ps.setString(5, order.getPickupLocation());
		ps.setInt(6, client.getClientID());
		ps.setString(7, order.getStatus().toString());
		ps.setInt(8, order.getReceiptNo());
		ps.executeUpdate();
		
		/*Getting the ID of the newly added orderList*/
		statement = "SELECT orderListID FROM order_list";
		ResultSet orderList = con.getConnection().prepareStatement(statement).executeQuery();
		orderList.last();
		int orderID = orderList.getInt("orderListID");
		
		Iterator<OrderItem> items = order.getItemList();
		
		/* Adding OrderItems to order_item table*/
		
		do {
			OrderItem item = items.next();
			
			statement = "INSERT INTO order_item(quantity, orderListID, itemPrice) VALUES (?, ?, ?)";
			ps = con.getConnection().prepareStatement(statement);
			ps.setInt(1, item.getQuantity());
			ps.setInt(2, orderID);
			ps.setDouble(3, item.getPrice());
			ps.executeUpdate();
			
			/*Getting the ID of the newly added orderItem*/
			statement = "SELECT orderID FROM order_item";
			ResultSet itemList = con.getConnection().prepareStatement(statement).executeQuery();
			itemList.last();
			int itemID = itemList.getInt("orderID");
			
			/*Adding OrderItem according to OrderType*/
			if(item instanceof GarmentOrder) {
				/*Adding FK to measurements*/
				statement = "INSERT INTO measurements(measurementsID) VALUES(?)";
				ps = con.getConnection().prepareStatement(statement);
				ps.setInt(1, itemID);
				ps.executeUpdate();
				
				/*Getting ID of newly added measurements*/
				statement = "SELECT measurementsID FROM measurements";
				ResultSet measurements = con.getConnection().prepareStatement(statement).executeQuery();
				measurements.last();
				int measureID = measurements.getInt("measurementsID");
				
				/*Adding OrderItem to garment_order*/
				statement = "INSERT INTO garment_order(orderID, garmentType, gender, material, special_instruction, measurementID) VALUES (?, ? ,?, ?, ?, ?)";
				ps = con.getConnection().prepareStatement(statement);
				ps.setInt(1, itemID);
				ps.setString(2, ((GarmentOrder) item).getGarment().toString());
				ps.setString(3, ((GarmentOrder) item).getGender().toString());
				ps.setString(4, ((GarmentOrder) item).getMaterial());
				ps.setString(5, ((GarmentOrder) item).getSpecialInstruction());
				ps.setInt(6, measureID);
				ps.executeUpdate();
				
				/*Adding to TopMeasurement if there is topMeasurement*/
				if(((GarmentOrder) item).hasTopMeasurement()) {
					TopMeasurement topMeasure = ((GarmentOrder) item).getTopMeasurement();
					statement = "INSERT INTO top_measure(measurementID, upperLength, shoulder, armLength, wrist, armHole, frontChest, backChest, waist, hips, neckDeep) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					ps = con.getConnection().prepareStatement(statement);
					ps.setInt(1, measureID);
					ps.setDouble(2, topMeasure.getUpperLength());
					ps.setDouble(3, topMeasure.getShoulder());
					ps.setDouble(4, topMeasure.getArmLength());
					ps.setDouble(5, topMeasure.getWrist());
					ps.setDouble(6, topMeasure.getArmHole());
					ps.setDouble(7, topMeasure.getFrontChest());
					ps.setDouble(8, topMeasure.getBackChest());
					ps.setDouble(9, topMeasure.getWaist());
					ps.setDouble(10, topMeasure.getHips());
					ps.setDouble(11, topMeasure.getNeckDeep());
					ps.executeUpdate();
					
					if(topMeasure instanceof WomensTopMeasure) {
						statement = "INSERT INTO women_top_measure(measurementID, frontFigure, bustPoint, bustDistance, backFigure) VALUES(?, ?, ?, ?, ?)";
						ps = con.getConnection().prepareStatement(statement);
						ps.setInt(1, measureID);
						ps.setDouble(2, ((WomensTopMeasure) topMeasure).getFrontFigure());
						ps.setDouble(3, ((WomensTopMeasure) topMeasure).getBustPoint());
						ps.setDouble(4,  ((WomensTopMeasure) topMeasure).getBustDistance());
						ps.setDouble(5, ((WomensTopMeasure) topMeasure).getBackFigure());
						ps.executeUpdate();
					}
				}
				
				/*Adding bottomMeasurement if it exists*/
				if(((GarmentOrder) item).hasBottomMeasurement()) {
					BottomMeasurement bottomMeasure = ((GarmentOrder) item).getBottomMeasurement();
					statement = "INSERT INTO bottom_measure(measurementID, bottomLength, waist, hips, thigh, knee, buttom, crotch) VALUES(?, ?, ?, ?, ?, ?, ? ,?)";
					ps = con.getConnection().prepareStatement(statement);
					ps.setInt(1, measureID);
					ps.setDouble(2, bottomMeasure.getBottomLength());
					ps.setDouble(3, bottomMeasure.getWaist());
					ps.setDouble(4, bottomMeasure.getHips());
					ps.setDouble(5, bottomMeasure.getThigh());
					ps.setDouble(6, bottomMeasure.getKnee());
					ps.setDouble(7, bottomMeasure.getButtom());
					ps.setDouble(8, bottomMeasure.getCrotch());
					ps.executeUpdate();
				}
			} else if (item instanceof Embroidery) {
				/*Adding EmbroideryOrder to embroidery_order*/
				statement = "INSERT INTO embroidery_order(orderID, logo, size, numOfColors, embroideryType) VALUES (?, ?, ?, ?, ?)";
				ps = con.getConnection().prepareStatement(statement);
				ps.setInt(1, itemID);
				ps.setBlob(2, new SerialBlob(((Embroidery) item).getLogoBytes()));
				ps.setDouble(3, ((Embroidery) item).getSize());
				ps.setInt(4, ((Embroidery) item).getNumOfColors());
				ps.setString(5, ((Embroidery) item).getEmbroideryType().toString());
				ps.executeUpdate();
			} else if (item instanceof Alteration) {
				/*Adding Alteration to alteration_order*/
				statement = "INSERT INTO alteration_order(orderID, garmentType, specialInstruction) VALUES (?, ?, ?)";
				ps = con.getConnection().prepareStatement(statement);
				ps.setInt(1, itemID);
				ps.setString(2, ((Alteration) item).getGarment().toString());
				ps.setString(3, ((Alteration) item).getInstruction());
				ps.executeUpdate();
			}
		} while(items.hasNext());
		notifyObservers();
	}
	
	public void cancelOrder(OrderList order) throws SQLException {
		OrderList modified = order;
		modified.cancelOrder();
		
		modifyOrder(order, modified);
	}
	
	public void modifyOrderItem(OrderItem originalOrder, String orderType, OrderItem modifiedOrder) throws SQLException {
		if(orderType.equals("ALTERATION")) {
			String statement = "UPDATE alteration_order SET specialInstruction = ? where orderID = ?";
			PreparedStatement ps = con.getConnection().prepareStatement(statement);
			ps.setString(1, ((Alteration) modifiedOrder).getInstruction());
			ps.setInt(2, originalOrder.getItemID());
			ps.executeUpdate();
			ps.close();
		} else if(orderType.equals("EMBROIDERY")) {
			String statement = "UPDATE embroider_order SET logo = ?, size = ?, numOfColors = ?, embroideryType = ? where orderID = ?";
			PreparedStatement ps = con.getConnection().prepareStatement(statement);
			ps.setBlob(1, new SerialBlob(((Embroidery) modifiedOrder).getLogoBytes()));
			ps.setDouble(2, ((Embroidery) modifiedOrder).getSize());
			ps.setInt(3, ((Embroidery) modifiedOrder).getNumOfColors());
			ps.setString(4, ((Embroidery) modifiedOrder).getEmbroideryType().toString());
			ps.setInt(5, originalOrder.getItemID());
			ps.executeUpdate();
			ps.close();
		}
		//made to order
	}
	
	public Iterator<?> retrieveOrderList() throws SQLException{
		modelList.removeAll(modelList);
	
		String statement = "SELECT * FROM order_list OL WHERE status = ?";
		PreparedStatement ps = con.getConnection().prepareStatement(statement);
		ps.setString(1, "PENDING");
		ResultSet orderListSet = ps.executeQuery();
		
		/*Traversing the whole list of orderList*/
		while(orderListSet.next()) {
			OrderList orderList = getOrderListByID(orderListSet.getInt("OL.orderListID"));
			modelList.add(orderList);
		}
		
		return modelList.iterator();
	}
	
	public Iterator<?> getModelList() throws SQLException{
		modelList.removeAll(modelList);
	
		String statement = "SELECT * FROM order_list OL";
		PreparedStatement ps = con.getConnection().prepareStatement(statement);
		ResultSet orderListSet = ps.executeQuery();
		
		/*Traversing the whole list of orderList*/
		while(orderListSet.next()) {
//			int clientID = orderListSet.getInt("OL.clientID");
////			String lastName = orderListSet.getString("C.lastName");
////			String firstName = orderListSet.getString("C.firstName");
////			String gender = orderListSet.getString("C.gender");
////			String contactNo = orderListSet.getString("C.contactNo");
////			String email = orderListSet.getString("C.email");
////			Client orderClient = new Client.ClientBuilder(lastName, firstName, gender, contactNo)
////										.clientID(clientID)
////										.email(email)
////										.build();
//			Client orderClient = ClientModel.getClientByID(clientID);
//			int listID = orderListSet.getInt("OL.orderListID");
//			int receiptNo = orderListSet.getInt("OL.receiptNo");
//			Date dueDate = orderListSet.getDate("OL.dueDate");
//			Date orderDate = orderListSet.getDate("OL.orderDate");
//			double balance = orderListSet.getDouble("OL.balance");
//			String pickupLocation = orderListSet.getString("OL.pickupLocation");
//			OrderStatus status = OrderStatus.getStatus(orderListSet.getString("OL.status"));
//			
//			
//			OrderList orderList = new OrderList.OrderListBuilder(receiptNo, dueDate, orderDate, balance, pickupLocation, orderClient, status)
//									.listID(listID)
//									.build();
//			
//			/*Getting the OrderItems of the OrderList*/
//			
//			/*Getting GarmentOrders*/
//			statement = "SELECT * FROM order_item OI, garment_order GO WHERE OI.orderListID = ? AND OI.orderID = GO.orderID";
//			ps = con.getConnection().prepareStatement(statement);
//			ps.setInt(1, listID);
//			ResultSet garmentItemSet = ps.executeQuery();
//			
//			int itemID;
//			int qty;
//			double price;
//			Garment garment;
//			String instruction;
//			
//			while(garmentItemSet.next()) {
//				itemID = garmentItemSet.getInt("OI.orderID");
//				qty = garmentItemSet.getInt("OI.quantity");
//				price = garmentItemSet.getDouble("OI.itemPrice");
//				String material = garmentItemSet.getString("GO.material");
//				instruction = garmentItemSet.getString("GO.special_instruction");
//				Gender garmentGender = Gender.getGender(garmentItemSet.getString("GO.gender"));
//				garment = Garment.getGarment(garmentItemSet.getString("GO.garmentType"));
//				int measurementID = garmentItemSet.getInt("GO.measurementID");
//				System.out.println(measurementID);
//				
//				/*Getting the measurements of the garment*/
//				ResultSet measurementSet;
//				ArrayList<Measurement> measurement = new ArrayList<>();
//				
//				/*Getting Bottom Measurement if it exists*/
//				statement = "SELECT * FROM bottom_measure BM WHERE measurementID = ?";
//				ps = con.getConnection().prepareStatement(statement);
//				ps.setInt(1, measurementID);
//				measurementSet = ps.executeQuery();
//					
//				while(measurementSet.next()) {
//					double bottomLength = measurementSet.getDouble("BM.bottomLength");
//					double waist = measurementSet.getDouble("BM.waist");
//					double hips = measurementSet.getDouble("BM.hips");
//					double thigh = measurementSet.getDouble("BM.thigh");
//					double knee = measurementSet.getDouble("knee"); 
//					double buttom = measurementSet.getDouble("BM.buttom");
//					double crotch = measurementSet.getDouble("BM.crotch");
//					BottomMeasurement bottomMeasure = (BottomMeasurement) new BottomMeasurement.BottomMeasurementBuilder(bottomLength, waist, hips, thigh, knee, buttom, crotch)
//															.measurementID(measurementID)
//															.build();
//					measurement.add(bottomMeasure);
//				}
//				
//				measurementSet.close();
//				
//				statement = "SELECT * FROM top_measure TM WHERE measurementID = ?";
//				ps = con.getConnection().prepareStatement(statement);
//				ps.setInt(1, measurementID);
//				measurementSet = ps.executeQuery();
//				
//				while(!measurementSet.isClosed() && measurementSet.next()) {
//					TopMeasurement topMeasure = null;
//					double upperLength = measurementSet.getDouble("TM.upperLength");
//					double shoulder = measurementSet.getDouble("TM.shoulder");
//					double armLength = measurementSet.getDouble("TM.armLength");
//					double wrist = measurementSet.getDouble("TM.wrist");
//					double armHole = measurementSet.getDouble("TM.armHole");
//					double frontChest = measurementSet.getDouble("TM.frontChest");
//					double backChest = measurementSet.getDouble("TM.backChest");
//					double waist = measurementSet.getDouble("TM.waist");
//					double hips = measurementSet.getDouble("TM.hips");
//					double neckDeep = measurementSet.getDouble("TM.neckDeep");
//					
//					if(garmentGender.toString().equals("FEMALE")) {
//						measurementSet.close();
//						statement = "SELECT * FROM women_top_measure WHERE measurementID = ?";
//						ps = con.getConnection().prepareStatement(statement);
//						ps.setInt(1, measurementID);
//						measurementSet = ps.executeQuery();
//							
//						while(measurementSet.next()) {
//							double frontFigure = measurementSet.getDouble("TM.frontFigure");
//							double bustPoint = measurementSet.getDouble("TM.bustPoint");
//							double bustDistance = measurementSet.getDouble("TM.bustDistance");
//							double backFigure = measurementSet.getDouble("TM.backFigure");
//							
//							topMeasure = (WomensTopMeasure) new WomensTopMeasure.WomensTopMeasureBuilder(upperLength, shoulder, armLength, wrist, armHole, frontChest, 
//																											backChest, waist, hips, neckDeep, frontFigure, bustPoint, bustDistance, backFigure)
//																		.measurementID(measurementID)
//																		.build();
//						}
//					} else {
//						topMeasure = (TopMeasurement) new TopMeasurement.TopMeasurementBuilder(upperLength, shoulder, armLength, wrist, armHole, frontChest, 
//																										backChest, waist, hips, neckDeep)
//																	.measurementID(measurementID)
//																	.build();
//					}
//					
//					measurement.add(topMeasure);
//						
//				} 
//				
//				GarmentOrder garmentOrder = (GarmentOrder)new GarmentOrder.GarmentOrderBuilder(qty, price, garment, garmentGender, measurement.iterator())
//																.material(material)
//																.instruction(instruction)
//																.itemID(itemID)
//																.build();
//				
//				orderList.addOrderItem(garmentOrder);
//			}
//			
//			statement = "SELECT * FROM order_item OI, embroidery_order E WHERE OI.orderListID = ? AND OI.orderID = E.orderID";
//			ps = con.getConnection().prepareStatement(statement);
//			ps.setInt(1, listID);
//			ResultSet embroiderySet = ps.executeQuery();
//			
//			while(embroiderySet.next()) {
//				itemID = embroiderySet.getInt("OI.orderID");
//				qty = embroiderySet.getInt("OI.quantity");
//				price = embroiderySet.getDouble("OI.itemPrice");
//				SerialBlob logoBlob = new SerialBlob(embroiderySet.getBlob("logo"));
//				byte[] logoBytes = logoBlob.getBytes(1, (int)logoBlob.length());
//				double size = embroiderySet.getDouble("E.size");
//				int colorNum = embroiderySet.getInt("E.numOfColors");
//				EmbroideryType embType = EmbroideryType.getEmbroideryType(embroiderySet.getString("E.embroideryType"));
//				
//				Embroidery embOrder = (Embroidery)new Embroidery.EmbroideryBuilder(qty, price, logoBytes, size, colorNum, embType)
//													.itemID(itemID)
//													.build();
//				orderList.addOrderItem(embOrder);
//			}
//			
//			statement = "SELECT * FROM order_item OI, alteration_order A WHERE OI.orderListID = ? AND OI.orderID = A.orderID";
//			ps = con.getConnection().prepareStatement(statement);
//			ps.setInt(1, listID);
//			ResultSet alterationSet = ps.executeQuery();
//			
//			while(alterationSet.next()) {
//				qty = alterationSet.getInt("OI.quantity");
//				price = alterationSet.getDouble("OI.itemPrice");
//				instruction = alterationSet.getString("A.specialInstruction");
//				garment = Garment.getGarment(alterationSet.getString("A.garmentType"));
//				
//				Alteration alterationOrder = (Alteration)new Alteration.AlterationBuilder(qty, price, garment, instruction)
//													.itemID(listID)
//													.build();	
//				orderList.addOrderItem(alterationOrder);
//			}
			OrderList orderList = getOrderListByID(orderListSet.getInt("OL.orderListID"));
			modelList.add(orderList);
		}
		
		return modelList.iterator();
	}
	
	public String getOrderListData(int row) throws SQLException {
		OrderList orderList1 = getSelectedOrderList(row);
        
        return "Receipt No.: " + orderList1.getReceiptNo() + '\n' +
               "Due Date: " + orderList1.getDueDate() + '\n' +
               "Order Date: " + orderList1.getOrderDate() + '\n' +
               "Balance: " + orderList1.getBalance() + '\n' +
               "Client: " + orderList1.getClient().getFirstName() + orderList1.getClient().getLastName() + '\n' +
               "Pickup Location: " + orderList1.getPickupLocation() + '\n' +
               "Status: " + orderList1.getStatus();
    } 
	
	public OrderList getSelectedOrderList(int row) throws SQLException {
		Iterator<?> orderList = getModelList();
		List<OrderList> list = new ArrayList<OrderList>();
		int size = 0;
		while(orderList.hasNext()) {
			list.add((OrderList) orderList.next());
			size++;
		}
        OrderList orderList1 = list.get(row);
        
        return orderList1;
	}
	
	
	public List<OrderDetail> retrieveOrderDetail(int orderListID) throws SQLException {
		List<OrderDetail> orderItemList = new ArrayList<OrderDetail>();
		
		String statement = "SELECT OI.quantity, AO.orderID, 'Alteration' type, CONCAT('Garment Type: ', garmentType, '\nSpecial Instruction: ', specialInstruction)"
				+ " FROM order_item OI, alteration_order AO WHERE orderListID = ? and OI.orderID = AO.orderID"
				+ " UNION SELECT OI.quantity, EO.orderID, 'Embroidery' type, CONCAT('Size: ', size, '\nNumber of Colors: ', numOfColors, '\nEmbroidery Type: ', embroideryType)"
				+ " FROM order_item OI, embroidery_order EO WHERE orderListID = ? and OI.orderID = EO.orderID"
				+ " UNION SELECT OI.quantity, GO.orderID, 'Garment' type, CONCAT('Garment Type: ', garmentType, '\nGender: ', gender, '\nMaterial: ', material, '\nSpecial Instruction: ', special_instruction)"
				+ " FROM order_item OI, garment_order GO WHERE orderListID = ? and OI.orderID = GO.orderID";
		PreparedStatement ps = con.getConnection().prepareStatement(statement);
		ps.setInt(1, orderListID);
		ps.setInt(2, orderListID);
		ps.setInt(3, orderListID);
		ResultSet rs = ps.executeQuery();
		try {
			while(rs.next()) {
				int qty = rs.getInt(1);
				orderItemList.add(new OrderDetail(qty, rs.getInt(2), rs.getString(3), rs.getString(4)));
			}
		} finally {
			rs.close();
		}
		
		return orderItemList;
	}
	
	public Iterator<?> getOrderItemModelList(OrderList orderList) throws SQLException {
		modelList.removeAll(modelList);
		
		
		
		String statement = "SELECT * FROM order_list OL, order_item OI, alteration_order AO "
				+ "WHERE OL.orderListID = OI.orderListID"
				+ " and OI.orderID = AO.orderID"
				+ " and OL.orderListID = ?";
		PreparedStatement ps = con.getConnection().prepareStatement(statement);
		System.out.println(orderList);
		ps.setInt(1, orderList.getListID());
		ResultSet alterationOrderItemListSet = ps.executeQuery();
		System.out.println("ID" + orderList.getListID());
		
		while(alterationOrderItemListSet.next()) {
			int quantity = alterationOrderItemListSet.getInt("OI.quantity");
			double price = alterationOrderItemListSet.getDouble("OI.itemPrice");
			int itemID = alterationOrderItemListSet.getInt("OI.orderID");
			
			String garmentType = alterationOrderItemListSet.getString("AO.garmentType");
			Garment garment = Garment.getGarment(garmentType);
			String specialInstruction = alterationOrderItemListSet.getString("AO.specialInstruction");
			
			OrderItem alterationItem = new Alteration.AlterationBuilder(quantity, price, garment, specialInstruction)
			.itemID(itemID)
			.build();
			
			modelList.add(alterationItem);
		}
		
		statement = "SELECT * FROM order_list OL, order_item OI, embroidery_order EO "
				+ "WHERE OL.orderListID = OI.orderListID"
				+ " and OI.orderID = EO.orderID"
				+ " and OL.orderListID = ?";
		ps = con.getConnection().prepareStatement(statement);
		ps.setInt(1, orderList.getListID());
		ResultSet embroideryOrderItemListSet = ps.executeQuery();
		
		while(embroideryOrderItemListSet.next()) {
			int quantity = embroideryOrderItemListSet.getInt("OI.quantity");
			double price = embroideryOrderItemListSet.getDouble("OI.itemPrice");
			int itemID = embroideryOrderItemListSet.getInt("OI.orderID");
			
			byte[] logo = embroideryOrderItemListSet.getBytes("EO.logo");
			double size = embroideryOrderItemListSet.getDouble("EO.size");
			int numOfColors = embroideryOrderItemListSet.getInt("EO.numOfColors");
			String embroidery = embroideryOrderItemListSet.getString("EO.embroideryType");
			EmbroideryType embroideryType = EmbroideryType.getEmbroideryType(embroidery);
			
			OrderItem embroideryItem = new Embroidery.EmbroideryBuilder(quantity, price, logo, size, numOfColors, embroideryType)
			.itemID(itemID)
			.build();
			
			modelList.add(embroideryItem);
		}
		
		//Made to Order
		
		return modelList.iterator();
	}
	
	public ArrayList<OrderItem> getOrderItemList(OrderList orderList) throws SQLException {
		Iterator<?> orderItemList = getOrderItemModelList(orderList);
		ArrayList<OrderItem> list = new ArrayList<OrderItem>();
		while(orderItemList.hasNext()) {
			list.add((OrderItem) orderItemList.next());
		}
       
        return list;
	}
	
	public ArrayList<Integer> getOrderItemIDList(OrderList orderList) throws SQLException {
		ArrayList<OrderItem> orderItemList = getOrderItemList(orderList);
		ArrayList<Integer> orderItemIDList = new ArrayList<Integer>();
		int size = 0;
		for(OrderItem item : orderItemList) {
			orderItemIDList.add(item.getItemID());
			size++;
		}
		
		return orderItemIDList;
	}
	
	public String determinePanel(OrderList orderList, int selectedIndex) throws SQLException {
		String type = "";
		OrderItem orderItem = getOrderItem(orderList, selectedIndex);
		if(orderItem instanceof Embroidery) {
			type = "EMBOIDERY";
		} else if(orderItem instanceof Alteration) {
			type = "ALTERATION";
		} else if (orderItem instanceof GarmentOrder) {
			type = "GARMENT ORDER";
		}
		return type;	
	}
	
	public OrderItem getOrderItem(OrderList orderList, int selectedIndex) throws SQLException {
		ArrayList<OrderItem> orderItemList = getOrderItemList(orderList);
		return orderItemList.get(selectedIndex);
	}
	
	public void modifyOrder(OrderList original, OrderList modified) throws SQLException {
		String query = "UPDATE order_list SET balance =  balance+?, status = ? WHERE orderListID = ?";
		PreparedStatement statement = con.getConnection().prepareStatement(query);
		statement.setDouble(1, modified.getBalance());
		statement.setString(2, modified.getStatus().toString());
		statement.setInt(3, original.getListID());
		statement.executeUpdate();
		getModelList();
	}
	
	public OrderList createModifiedOrderList(OrderList originalOrderList,
			String newStatus, double newBalance) {
		OrderStatus newOrderStatus = OrderStatus.getStatus(newStatus);
		originalOrderList.setStatus(newOrderStatus);
		originalOrderList.setBalance(newBalance);
		
		return originalOrderList;
	} 
	
	public static OrderList getOrderListByID(int id) throws SQLException {
		String statement = "SELECT * FROM order_list OL WHERE OL.orderListID = " + id;
		PreparedStatement ps = DatabaseConnection.getInstance().getConnection().prepareStatement(statement);
		ResultSet orderListSet = ps.executeQuery();
		OrderList orderList;
		
		/*Traversing the whole list of orderList*/
		orderListSet.first();
			int clientID = orderListSet.getInt("OL.clientID");
//			String lastName = orderListSet.getString("C.lastName");
//			String firstName = orderListSet.getString("C.firstName");
//			String gender = orderListSet.getString("C.gender");
//			String contactNo = orderListSet.getString("C.contactNo");
//			String email = orderListSet.getString("C.email");
//			Client orderClient = new Client.ClientBuilder(lastName, firstName, gender, contactNo)
//										.clientID(clientID)
//										.email(email)
//										.build();
			Client orderClient = ClientModel.getClientByID(clientID);
			int listID = orderListSet.getInt("OL.orderListID");
			int receiptNo = orderListSet.getInt("OL.receiptNo");
			Date dueDate = orderListSet.getDate("OL.dueDate");
			Date orderDate = orderListSet.getDate("OL.orderDate");
			double balance = orderListSet.getDouble("OL.balance");
			String pickupLocation = orderListSet.getString("OL.pickupLocation");
			OrderStatus status = OrderStatus.getStatus(orderListSet.getString("OL.status"));
			
			
			orderList = new OrderList.OrderListBuilder(receiptNo, dueDate, orderDate, balance, pickupLocation, orderClient, status)
									.listID(listID)
									.build();
			
			/*Getting the OrderItems of the OrderList*/
			
			/*Getting GarmentOrders*/
			statement = "SELECT * FROM order_item OI, garment_order GO WHERE OI.orderListID = ? AND OI.orderID = GO.orderID";
			ps = DatabaseConnection.getInstance().getConnection().prepareStatement(statement);
			ps.setInt(1, listID);
			ResultSet garmentItemSet = ps.executeQuery();
			
			int itemID;
			int qty;
			double price;
			Garment garment;
			String instruction;
			
			while(garmentItemSet.next()) {
				itemID = garmentItemSet.getInt("OI.orderID");
				qty = garmentItemSet.getInt("OI.quantity");
				price = garmentItemSet.getDouble("OI.itemPrice");
				String material = garmentItemSet.getString("GO.material");
				instruction = garmentItemSet.getString("GO.special_instruction");
				Gender garmentGender = Gender.getGender(garmentItemSet.getString("GO.gender"));
				garment = Garment.getGarment(garmentItemSet.getString("GO.garmentType"));
				int measurementID = garmentItemSet.getInt("GO.measurementID");
				System.out.println(measurementID);
				
				/*Getting the measurements of the garment*/
				ResultSet measurementSet;
				ArrayList<Measurement> measurement = new ArrayList<>();
				
				/*Getting Bottom Measurement if it exists*/
				statement = "SELECT * FROM bottom_measure BM WHERE measurementID = ?";
				ps = DatabaseConnection.getInstance().getConnection().prepareStatement(statement);
				ps.setInt(1, measurementID);
				measurementSet = ps.executeQuery();
					
				while(measurementSet.next()) {
					double bottomLength = measurementSet.getDouble("BM.bottomLength");
					double waist = measurementSet.getDouble("BM.waist");
					double hips = measurementSet.getDouble("BM.hips");
					double thigh = measurementSet.getDouble("BM.thigh");
					double knee = measurementSet.getDouble("knee"); 
					double buttom = measurementSet.getDouble("BM.buttom");
					double crotch = measurementSet.getDouble("BM.crotch");
					BottomMeasurement bottomMeasure = (BottomMeasurement) new BottomMeasurement.BottomMeasurementBuilder(bottomLength, waist, hips, thigh, knee, buttom, crotch)
															.measurementID(measurementID)
															.build();
					measurement.add(bottomMeasure);
				}
				
				measurementSet.close();
				
				statement = "SELECT * FROM top_measure TM WHERE measurementID = ?";
				ps = DatabaseConnection.getInstance().getConnection().prepareStatement(statement);
				ps.setInt(1, measurementID);
				measurementSet = ps.executeQuery();
				
				while(!measurementSet.isClosed() && measurementSet.next()) {
					TopMeasurement topMeasure = null;
					double upperLength = measurementSet.getDouble("TM.upperLength");
					double shoulder = measurementSet.getDouble("TM.shoulder");
					double armLength = measurementSet.getDouble("TM.armLength");
					double wrist = measurementSet.getDouble("TM.wrist");
					double armHole = measurementSet.getDouble("TM.armHole");
					double frontChest = measurementSet.getDouble("TM.frontChest");
					double backChest = measurementSet.getDouble("TM.backChest");
					double waist = measurementSet.getDouble("TM.waist");
					double hips = measurementSet.getDouble("TM.hips");
					double neckDeep = measurementSet.getDouble("TM.neckDeep");
					
					if(garmentGender.toString().equals("FEMALE")) {
						measurementSet.close();
						statement = "SELECT * FROM women_top_measure TM WHERE measurementID = ?";
						ps = DatabaseConnection.getInstance().getConnection().prepareStatement(statement);
						ps.setInt(1, measurementID);
						measurementSet = ps.executeQuery();
							
						while(measurementSet.next()) {
							double frontFigure = measurementSet.getDouble("frontFigure");
							double bustPoint = measurementSet.getDouble("bustPoint");
							double bustDistance = measurementSet.getDouble("bustDistance");
							double backFigure = measurementSet.getDouble("backFigure");
							
							topMeasure = (WomensTopMeasure) new WomensTopMeasure.WomensTopMeasureBuilder(upperLength, shoulder, armLength, wrist, armHole, frontChest, 
																											backChest, waist, hips, neckDeep, frontFigure, bustPoint, bustDistance, backFigure)
																		.measurementID(measurementID)
																		.build();
						}
					} else {
						topMeasure = (TopMeasurement) new TopMeasurement.TopMeasurementBuilder(upperLength, shoulder, armLength, wrist, armHole, frontChest, 
																										backChest, waist, hips, neckDeep)
																	.measurementID(measurementID)
																	.build();
					}
					
					measurement.add(topMeasure);
						
				} 
				
				GarmentOrder garmentOrder = (GarmentOrder)new GarmentOrder.GarmentOrderBuilder(qty, price, garment, garmentGender, measurement.iterator())
																.material(material)
																.instruction(instruction)
																.itemID(itemID)
																.build();
				
				orderList.addOrderItem(garmentOrder);
			}
			
			statement = "SELECT * FROM order_item OI, embroidery_order E WHERE OI.orderListID = ? AND OI.orderID = E.orderID";
			ps = DatabaseConnection.getInstance().getConnection().prepareStatement(statement);
			ps.setInt(1, listID);
			ResultSet embroiderySet = ps.executeQuery();
			
			while(embroiderySet.next()) {
				itemID = embroiderySet.getInt("OI.orderID");
				qty = embroiderySet.getInt("OI.quantity");
				price = embroiderySet.getDouble("OI.itemPrice");
				SerialBlob logoBlob = new SerialBlob(embroiderySet.getBlob("logo"));
				byte[] logoBytes = logoBlob.getBytes(1, (int)logoBlob.length());
				double size = embroiderySet.getDouble("E.size");
				int colorNum = embroiderySet.getInt("E.numOfColors");
				EmbroideryType embType = EmbroideryType.getEmbroideryType(embroiderySet.getString("E.embroideryType"));
				
				Embroidery embOrder = (Embroidery)new Embroidery.EmbroideryBuilder(qty, price, logoBytes, size, colorNum, embType)
													.itemID(itemID)
													.build();
				orderList.addOrderItem(embOrder);
			}
			
			statement = "SELECT * FROM order_item OI, alteration_order A WHERE OI.orderListID = ? AND OI.orderID = A.orderID";
			ps = DatabaseConnection.getInstance().getConnection().prepareStatement(statement);
			ps.setInt(1, listID);
			ResultSet alterationSet = ps.executeQuery();
			
			while(alterationSet.next()) {
				qty = alterationSet.getInt("OI.quantity");
				price = alterationSet.getDouble("OI.itemPrice");
				instruction = alterationSet.getString("A.specialInstruction");
				garment = Garment.getGarment(alterationSet.getString("A.garmentType"));
				
				Alteration alterationOrder = (Alteration)new Alteration.AlterationBuilder(qty, price, garment, instruction)
													.itemID(listID)
													.build();	
				orderList.addOrderItem(alterationOrder);
			}	
		
		return orderList;
	}
	
	public String getOrderItemDetails(OrderList orderList, int index, int itemID) throws SQLException {
		String statement = "SELECT * FROM order_item OI WHERE OI.orderID = ?";
		PreparedStatement ps = con.getConnection().prepareStatement(statement);
		ps.setInt(1, itemID);
		ResultSet orderItemDetails = ps.executeQuery();
		
		String type = determinePanel(orderList, index);
		String str = "";
		if(type.equals("EMBROIDERY")) {
			statement = "SELECT * FROM embroidery_order EI WHERE EI.orderID = ?";
			PreparedStatement es = con.getConnection().prepareStatement(statement);
			es.setInt(1, itemID);
			ResultSet embroideryOrderItemDetails = es.executeQuery();
			
			while(embroideryOrderItemDetails.next()) {
				str = "Size: " + embroideryOrderItemDetails.getDouble("EI.size") + "\n" +
						"Number of Colors: " + embroideryOrderItemDetails.getInt("EI.numOfColors") + "\n" +
						"Embroidery Type: " + embroideryOrderItemDetails.getString("EI.embroideryType");
			}
		} else if(type.equals("ALTERATION")) {
			statement = "SELECT * FROM alteration_order AI WHERE AI.orderID = ?";
			PreparedStatement as = con.getConnection().prepareStatement(statement);
			as.setInt(1, itemID);
			ResultSet alterationOrderItemDetails = as.executeQuery();
			
			while(alterationOrderItemDetails.next()) {
				str = "Garment Type: " + alterationOrderItemDetails.getString("AI.garmentType") + "\n" +
					"Special Instruction: " + alterationOrderItemDetails.getString("AI.specialInstruction");
			}
		} else if(type.equals("GARMENT ORDER")) {
			statement = "SELECT * FROM garment_order GI WHERE GI.orderID = ?";
			PreparedStatement gs = con.getConnection().prepareStatement(statement);
			gs.setInt(1, itemID);
			ResultSet garmentOrderItemDetails = gs.executeQuery();
			
			while(garmentOrderItemDetails.next()) {
				str = "Garment Type: " + garmentOrderItemDetails.getString("GI.garmentType") + "\n" +
						"Gender: " + garmentOrderItemDetails.getString("GI.gender") + "\n" +
						"Material: " + garmentOrderItemDetails.getString("GI.material") + "\n" +
						"Special Instruction: " + garmentOrderItemDetails.getString("GI.specialInstruction");
			}
			
			int measurementID = garmentOrderItemDetails.getInt("GI.measurementID");
			
			//top measurement
			statement = "SELECT * FROM top_measure TM WHERE TM.measurementID = ?";
			PreparedStatement tmsp = con.getConnection().prepareStatement(statement);
			tmsp.setInt(1, measurementID);
			ResultSet tmsr = tmsp.executeQuery();
			
			while(tmsr.next()) {
				str += "\n" + 
						"Upper Length: " + tmsr.getDouble("TM.upperLength") + "\n" +
						"Shoulder: " + tmsr.getDouble("TM.shoulder") + "\n" +
						"Arm Length: " + tmsr.getDouble("TM.armLength") + "\n" +
						"Wrist: " + tmsr.getDouble("TM.wrist") + "\n" + 
						"Arm Hole: " + tmsr.getDouble("TM.armhole") + "\n" +
						"Front Chest: " + tmsr.getDouble("TM.frontChest") + "\n" +
						"Back Chest: " + tmsr.getDouble("TM.backChest") + "\n" +
						"Waist: " + tmsr.getDouble("TM.waist") + "\n" +
						"Hips: " + tmsr.getDouble("TM.hips") + "\n" + 
						"Neck Deep: " + tmsr.getDouble("TM.neckDeep");
			}
			
			//women top measurement
			statement = "SELECT * FROM women_top_measure WM WHERE WM.measurementID = ?";
			PreparedStatement wmsp = con.getConnection().prepareStatement(statement);
			wmsp.setInt(1, measurementID);
			ResultSet wmsr = tmsp.executeQuery();
			
			while(tmsr.next()) {
				str += "\n" + 
						"Front Figure: " + wmsr.getDouble("TM.frontFigure") + "\n" +
						"Bust Point: " + wmsr.getDouble("TM.bustPoint") + "\n" +
						"Bust Distance: " + wmsr.getDouble("TM.bustDistance") + "\n" +
						"BackFigure: " + wmsr.getDouble("TM.backFigure");
			}
			
			//bottom measurement
			statement = "SELECT * FROM bottom_measure BM WHERE BM.measurementID = ?";
			PreparedStatement bmsp = con.getConnection().prepareStatement(statement);
			bmsp.setInt(1, measurementID);
			ResultSet bmsr = tmsp.executeQuery();
			
			while(tmsr.next()) {
				str += "\n" + 
						"Bottom Length: " + bmsr.getDouble("BM.bottomLength") + "\n" +
						"Waist: " + bmsr.getDouble("BM.waist") + "\n" +
						"Hips: " + bmsr.getDouble("BM.hips") + "\n" +
						"Thigh: " + bmsr.getDouble("BM.thigh") + "\n" +
						"Knee: " + bmsr.getDouble("BM.knee") + "\n" +
						"Buttom: " + bmsr.getDouble("BM.buttom") + "\n" +
						"Crotch: " + bmsr.getDouble("BM.crotch");
			}
		}
		
		int quantity = 0;
		double price = 0;
		while(orderItemDetails.next()) {
			quantity = orderItemDetails.getInt("OI.quantity");
			price = orderItemDetails.getDouble("OI.itemPrice");
		}
		
		return "Quantity: " + quantity + "\n" +
				"Price: " + price + "\n" +
				str;
	}
}
