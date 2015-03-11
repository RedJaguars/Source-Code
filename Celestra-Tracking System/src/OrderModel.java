import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.sql.rowset.serial.SerialBlob;

public class OrderModel extends Model{
	public OrderModel() {
		super();
		modelList = new ArrayList<OrderList>();
	}
	
	/* Adds a new order to the database*/
	@SuppressWarnings("resource")
	public void addNewOrder(OrderList order) throws SQLException {
		String statement = "INSERT INTO order_list(orderDate, dueDate, totalPrice, balance, pickupLocation, clientID) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement ps = con.getConnection().prepareStatement(statement);
		
		ps.setDate(1, order.getOrderDate());
		ps.setDate(2, order.getDueDate());
		ps.setDouble(3, order.getTotalPrice());
		ps.setDouble(4, order.getBalance());
		ps.setString(5, order.getPickupLocation());
		ps.executeUpdate();
		
		/*Getting the ID of the newly added orderList*/
		statement = "SELECT orderListID FROM order_list";
		ResultSet orderList = con.getConnection().prepareStatement(statement).executeQuery();
		orderList.last();
		int orderID = orderList.getInt("orderListID");
		
		Iterator<OrderItem> items = order.getItemList();
		
		/* Adding OrderItems to order_item table*/
		for(OrderItem item = items.next(); items.hasNext(); item = items.next()) {
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
				/*Adding OrderItem to garment_order*/
				statement = "INSERT INTO garment_order VALUES(orderID, garmentType, gender, material, special_instruction) VALUES (?, ? ,?, ?, ?)";
				ps = con.getConnection().prepareStatement(statement);
				ps.setInt(1, orderID);
				ps.setString(2, ((GarmentOrder) item).getGarmentType());
				ps.setString(3, ((GarmentOrder) item).getGender());
				ps.setString(4, ((GarmentOrder) item).getMaterial());
				ps.setString(5, ((GarmentOrder) item).getSpecialInstruction());
				ps.executeUpdate();
				
				/*Adding FK to measurements*/
				statement = "INSERT INTO measurements(garmentOrderID) VALUES(?)";
				ps = con.getConnection().prepareStatement(statement);
				ps.setInt(1, itemID);
				ps.executeUpdate();
				
				/*Getting ID of newly added measurements*/
				statement = "SELECT measurementsID FROM measurements";
				ResultSet measurements = con.getConnection().prepareStatement(statement).executeQuery();
				measurements.last();
				int measureID = measurements.getInt("measurementsID");
				
				/*Adding to TopMeasurement if there is topMeasurement*/
				if(((GarmentOrder) item).getTopMeasurement() != null) {
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
				if(((GarmentOrder) item).getBottomMeasurement() != null) {
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
				ps.setString(5, ((Embroidery) item).getEmbroideryType());
				ps.executeUpdate();
			} else if (item instanceof Alteration) {
				/*Adding Alteration to alteration_order*/
				statement = "INSERT INTO alteration_order(orderID, garmentType, specialInstruction) VALUES (?, ?, ?)";
				ps = con.getConnection().prepareStatement(statement);
				ps.setInt(1, itemID);
				ps.setString(2, ((Alteration) item).getGarmentType());
				ps.setString(3, ((Alteration) item).getInstruction());
				ps.executeUpdate();
			}
		}	
	}
}
