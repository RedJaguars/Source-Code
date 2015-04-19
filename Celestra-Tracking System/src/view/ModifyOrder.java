package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

import controller.OrderController;
import objects.Alteration;
import objects.Embroidery;
import objects.OrderList;
import view.ChangeOrderStatus.doActionListener;

public class ModifyOrder extends JFrame {
	private JList<Integer> orderItemList;
	private JPanel panel_2;
	private OrderList selectedOrderList;
	private OrderController orderController;
	private JButton btnBack;
	private JPanel panel_1;
	private JLabel lblHeader;
	
	public ModifyOrder(OrderList orderList) {
		selectedOrderList = orderList;
		orderController = new OrderController();
		try {
			orderController.getOrderItemIDList(orderList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.decode("#D3D27C"));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#677B42"));
		panel.setBounds(0, 0, 200, 721);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		UIManager.put("Button.select", Color.decode("#C1BF7D"));
		ImageIcon icon;
		
		btnBack = new JButton("Go Back");
		btnBack.setBounds(70, 10, 150, 50);
		icon = new ImageIcon("src/images/back.png");
		btnBack.setIcon(icon);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBack.setBackground(Color.decode("#A8A76D"));
		btnBack.setForeground(Color.WHITE);
		btnBack.setFocusPainted(false);
		btnBack.setBorderPainted(false);
		btnBack.setContentAreaFilled(false);
		btnBack.addActionListener(new doActionListener());
		panel.add(btnBack);
		
		panel_1 = new JPanel();
		panel_1.setBounds(200, 0, 1200, 721);
		panel_1.setBackground(Color.decode("#E5EDB8"));
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		lblHeader = new JLabel("Modify Order");
		lblHeader.setBounds(40,10,250,40);
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1.add(lblHeader);
		
		//String[] data = {"one", "two", "three", "four"};
		//orderItemList = new JList<String>(data);
		ArrayList<Integer> temp;
		Integer[] list = null;
		try {
			temp = orderController.getOrderItemIDList(orderList);
			list = new Integer[temp.size()];
			list = temp.toArray(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		orderItemList = new JList<Integer>(list);
		orderItemList.addMouseListener(new clickActionListener());
		
		JLabel lblOrderItem = new JLabel("Select order item:");
		lblOrderItem.setBounds(40, 50, 150, 50);
		lblOrderItem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_1.add(lblOrderItem);
		
		JScrollPane orderScrollPane = new JScrollPane(orderItemList);
		orderScrollPane.setBounds(40, 90, 500, 180);
		panel_1.add(orderScrollPane);
		
		panel_2 = new JPanel();
		panel_2.setBounds(200, 280, 1300, 460);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBackground(Color.decode("#E5EDB8"));
		//panel_2.add(new ModifyEmbroideryOrder());
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		Insets scnMax = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
		int taskBarSize = scnMax.bottom;
		
		this.setSize(screenWidth, screenHeight - taskBarSize);
		this.setResizable(false);
		this.setVisible(true);
	}

	public void determinePanel(int selectedIndex) {
		panel_2.removeAll();
		String orderType = "";
		try {
			orderType = orderController.determinePanel(selectedOrderList, selectedIndex);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(orderType.equals("EMBROIDERY")) {
			try {
				panel_2.add(new ModifyEmbroideryOrder((Embroidery) orderController.getOrderItem(selectedOrderList, selectedIndex)));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			panel_2.revalidate();
			panel_2.repaint();
		} else if(orderType.equals("ALTERATION")) {
			try {
				panel_2.add(new ModifyAlterationOrder((Alteration) orderController.getOrderItem(selectedOrderList, selectedIndex)));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			panel_2.revalidate();
			panel_2.repaint();
		} else if(orderType.equals("MADETOORDER")) {
			//something
		}
	}
	
	public class clickActionListener implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount() == 1) {
				int index = orderItemList.locationToIndex(e.getPoint());
				determinePanel(index);
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	public class doActionListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent action) {
			if(action.getSource() == btnBack) {
				dispose();
			}
		}
	}
}
