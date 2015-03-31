package model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Iterator;

import javax.sql.rowset.serial.SerialBlob;

import objects.Alteration;
import objects.BottomMeasurement;
import objects.Client;
import objects.Embroidery;
import objects.EmbroideryType;
import objects.Garment;
import objects.GarmentOrder;
import objects.Gender;
import objects.Measurement;
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
		String statement = "INSERT INTO order_list(orderDate, dueDate, totalPrice, balance, pickupLocation, clientID, status, receiptNo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = con.getConnection().prepareStatement(statement);
		
		ps.setDate(1, order.getOrderDate());
		ps.setDate(2, order.getDueDate());
		ps.setDouble(3, order.getTotalPrice());
		ps.setDouble(4, order.getBalance());
		ps.setString(5, order.getPickupLocation());
		ps.setInt(6, order.getClient().getClientID());
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
				statement = "INSERT INTO measurements VALUES()";
				ps = con.getConnection().prepareStatement(statement);
				ps.setInt(1, itemID);
				ps.executeUpdate();
				
				/*Getting ID of newly added measurements*/
				statement = "SELECT measurementsID FROM measurements";
				ResultSet measurements = con.getConnection().prepareStatement(statement).executeQuery();
				measurements.last();
				int measureID = measurements.getInt("measurementsID");
				
				/*Adding OrderItem to garment_order*/
				statement = "INSERT INTO garment_order VALUES(orderID, garmentType, gender, material, special_instruction, measurementID) VALUES (?, ? ,?, ?, ?, ?)";
				ps = con.getConnection().prepareStatement(statement);
				ps.setInt(1, orderID);
				ps.setString(2, ((GarmentOrder) item).getGarment().toString());
				ps.setString(3, ((GarmentOrder) item).getGender().toString());
				ps.setString(4, ((GarmentOrder) item).getMaterial());
				ps.setString(5, ((GarmentOrder) item).getSpecialInstruction());
				ps.setInt(6, measureID);
				ps.executeUpdate();
				
				/*Adding to TopMeasurement if there is topMeasurement*/
				if(((GarmentOrder) item).hasTopMeasurement()) {
					TopMeasurement topMeasure = ((GarmentOrder) item).getTopMeasurement();
					statement = "INSERT INTO top_measure(measurementID, upperLength, shoulder, armLength, wrist, armHole, frontChest, backChest, waist, hips, neckDeep) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
				statement = "INSERT INTO embroidery_order(orderID, logo, size, numOfColors, embroidery)";
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
	
	public void cancelOrder(OrderList order) {
		
	}
	
	public void modifyOrder(OrderList original, OrderList modified) throws SQLException {
		
	}
	
	public Iterator<?> getModelList() throws SQLException{
		modelList.removeAll(modelList);
		
		String statement = "SELECT * FROM order_list OL, clients C WHERE OL.clientID = C.clientID";
		PreparedStatement ps = con.getConnection().prepareStatement(statement);
		ResultSet orderListSet = ps.executeQuery();
		
		/*Traversing the whole list of orderList*/
		while(orderListSet.next()) {
			int clientID = orderListSet.getInt("C.clientID");
			String lastName = orderListSet.getString("C.lastName");
			String firstName = orderListSet.getString("C.firstName");
			String gender = orderListSet.getString("C.gender");
			String contactNo = orderListSet.getString("C.contactNo");
			String email = orderListSet.getString("C.email");
			Client orderClient = new Client.ClientBuilder(lastName, firstName, gender, contactNo)
										.clientID(clientID)
										.email(email)
										.build();
			
			int listID = orderListSet.getInt("OL.orderListID");
			int receiptNo = orderListSet.getInt("OL.receiptNo");
			Date dueDate = orderListSet.getDate("OL.dueDate");
			Date orderDate = orderListSet.getDate("OL.orderDate");
			double balance = orderListSet.getDouble("OL.balance");
			String pickupLocation = orderListSet.getString("OL.pickupLocation");
			OrderStatus status = OrderStatus.getStatus(orderListSet.getString("OL.status"));
			
			
			OrderList orderList = new OrderList.OrderListBuilder(receiptNo, dueDate, orderDate, balance, pickupLocation, orderClient, status)
									.listID(listID)
									.build();
			
			/*Getting the OrderItems of the OrderList*/
			
			/*Getting GarmentOrders*/
			statement = "SELECT * FROM order_item OI, garment_order GO WHERE OI.orderListID = ? AND OI.orderID = GO.orderID";
			ps = con.getConnection().prepareStatement(statement);
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
				ps = con.getConnection().prepareStatement(statement);
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
				ps = con.getConnection().prepareStatement(statement);
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
						statement = "SELECT * FROM women_top_measure WHERE measurementID = ?";
						ps = con.getConnection().prepareStatement(statement);
						ps.setInt(1, measurementID);
						measurementSet = ps.executeQuery();
							
						while(measurementSet.next()) {
							double frontFigure = measurementSet.getDouble("TM.frontFigure");
							double bustPoint = measurementSet.getDouble("TM.bustPoint");
							double bustDistance = measurementSet.getDouble("TM.bustDistance");
							double backFigure = measurementSet.getDouble("TM.backFigure");
							
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
			ps = con.getConnection().prepareStatement(statement);
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
			ps = con.getConnection().prepareStatement(statement);
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
			modelList.add(orderList);
		}
		
		return modelList.iterator();
	}
}
