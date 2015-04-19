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
		UIManager.put("Button.select", Color.decode("#C1BF7D"));
		this.setBackground(Color.decode("#E5EDB8"));
		
		JLabel lblSpecialInstruction = new JLabel("Special Instructions:");
		lblSpecialInstruction.setBounds(40, -30, 200, 100);
		lblSpecialInstruction.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(lblSpecialInstruction);
		
		txtAreaSpecialInstruction = new JTextArea();
		txtAreaSpecialInstruction.setLineWrap(true);
		txtAreaSpecialInstruction.setText(orderItem.getInstruction());
		
		JScrollPane pane = new JScrollPane(txtAreaSpecialInstruction);
		pane.setBounds(40, 35, 500, 200);
		pane.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(pane);
		
		btnModifyOrder = new JButton("Confirm");
		btnModifyOrder.setBounds(40, 300, 150, 40);
		btnModifyOrder.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnModifyOrder.setBackground(Color.decode("#A8A76D"));
		btnModifyOrder.setFocusPainted(false);
		btnModifyOrder.setBorderPainted(false);
		btnModifyOrder.addActionListener(new doActionListener());
		add(btnModifyOrder);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(255, 300, 150, 40);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBackground(Color.decode("#A8A76D"));
		btnCancel.setFocusPainted(false);
		btnCancel.setBorderPainted(false);
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
