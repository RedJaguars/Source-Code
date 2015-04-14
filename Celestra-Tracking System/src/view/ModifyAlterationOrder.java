package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.LineBorder;

import controller.OrderController;
import objects.Alteration;
import objects.Garment;
import objects.OrderItem;

public class ModifyAlterationOrder extends JPanel {
	private JTextArea txtAreaSpecialInstruction;
	
	private JButton btnCancel;
	private JButton btnModifyOrder;
	
	private OrderController orderController;
	private Alteration alterationOrder;
	
	public ModifyAlterationOrder(Alteration orderItem) {
		orderController = new OrderController();
		alterationOrder = orderItem;
		
		setLayout(null);
		
		JLabel lblSpecialInstruction = new JLabel("Special Instruction:");
		lblSpecialInstruction.setBounds(20, 20, 200, 100);
		add(lblSpecialInstruction);
		
		txtAreaSpecialInstruction = new JTextArea();
		txtAreaSpecialInstruction.setLineWrap(true);
		txtAreaSpecialInstruction.setText(orderItem.getInstruction());
		
		JScrollPane pane = new JScrollPane(txtAreaSpecialInstruction);
		pane.setBounds(150, 20, 500, 300);
		add(pane);
		
		btnModifyOrder = new JButton("Modify");
		btnModifyOrder.setBounds(20, 400, 100, 30);
		btnModifyOrder.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnModifyOrder.addActionListener(new doActionListener());
		add(btnModifyOrder);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(125, 400, 100, 30);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.addActionListener(new doActionListener());
		add(btnCancel);
		
		setSize(1300, 460);
		setVisible(true);
	}
	
	public class doActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == btnCancel) {
					javax.swing.SwingUtilities.getWindowAncestor(ModifyAlterationOrder.this).dispose();
			} else if (e.getSource() == btnModifyOrder) {
				try {
					int qty = alterationOrder.getQuantity();
					double price = alterationOrder.getPrice();
					Garment garment = alterationOrder.getGarment();
					String instruction = txtAreaSpecialInstruction.getText();
					int id = alterationOrder.getItemID();
					
					OrderItem modifiedOrder = new Alteration.AlterationBuilder(qty, price, garment, instruction)
					.itemID(id)
					.build();
					orderController.modifyOrderItem(alterationOrder, "ALTERATION", (Alteration) modifiedOrder);
					javax.swing.SwingUtilities.getWindowAncestor(ModifyAlterationOrder.this).dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
	}
}
