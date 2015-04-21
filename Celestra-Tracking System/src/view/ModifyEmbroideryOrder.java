package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.OrderController;
import objects.Alteration;
import objects.Embroidery;
import objects.EmbroideryType;
import objects.Garment;
import objects.OrderItem;
import view.ModifyAlterationOrder.doActionListener;

public class ModifyEmbroideryOrder extends JPanel {
	private JButton btnModifyOrder;
	private JButton btnCancel;
	private JButton btnAddFile;
	
	private JLabel lblFile;
	
	private OrderController orderController;
	private Embroidery embroideryOrder; 
	private byte[] fileChosenByte;
	
	private JTextField txtFieldSize;
	private JTextField txtFieldNumOfColors;
	
	private OrderFrame mainFrame;
	
	public ModifyEmbroideryOrder(Embroidery orderItem, OrderFrame frame) {
		orderController = new OrderController();
		embroideryOrder = orderItem;
		mainFrame = frame;
		
		setLayout(null);
		
		JLabel lblLogo = new JLabel("Logo:");
		lblLogo.setBounds(20, 0, 80, 20);
		lblLogo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblLogo);
		
		lblFile = new JLabel("");
		lblFile.setBounds(200, 0, 300, 20);
		lblFile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblFile);
		
		btnAddFile = new JButton("Add File");
		btnAddFile.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnAddFile.setBounds(80, 0, 100, 20);
        btnAddFile.addActionListener(new doActionListener());
        add(btnAddFile);
		
		JLabel lblSize = new JLabel("Size:");
		lblSize.setBounds(20, 35, 80, 20);
		lblSize.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblSize);
		
		txtFieldSize = new JTextField();
		txtFieldSize.setBounds(80, 35, 200, 25);
		add(txtFieldSize);
		
		JLabel lblNumOfColors = new JLabel("Number of Colors:");
		lblNumOfColors.setBounds(20, 70, 130, 20);
		lblNumOfColors.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblNumOfColors);
		
		txtFieldNumOfColors = new JTextField();
		txtFieldNumOfColors.setBounds(150, 70, 80, 25);
		add(txtFieldNumOfColors);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setBounds(20, 105, 80, 20);
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblType);
		
		JRadioButton rbPatch = new JRadioButton("Patch");
		rbPatch.setMnemonic(KeyEvent.VK_P);
		rbPatch.setBounds(80, 105, 100, 20);
		add(rbPatch);
        
        JRadioButton rbBuiltIn = new JRadioButton ("Built-in");
        rbBuiltIn.setMnemonic(KeyEvent.VK_B);
        rbBuiltIn.setBounds(180, 105, 100, 20);
        add(rbBuiltIn);
        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(rbPatch);
        genderGroup.add(rbBuiltIn);
		
		btnModifyOrder = new JButton("Modify");
		btnModifyOrder.setBounds(20, 400, 100, 30);
		btnModifyOrder.setFont(new Font("Tahoma", Font.PLAIN, 15));
		//btnModifyOrder.addActionListener(new doActionListener());
		add(btnModifyOrder);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(125, 400, 100, 30);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		//btnCancel.addActionListener(new doActionListener());
		add(btnCancel);
		
		setSize(1300, 460);
		setVisible(true);
	}
	
	public class doActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == btnCancel) {
				mainFrame.updateTable();
				javax.swing.SwingUtilities.getWindowAncestor(ModifyEmbroideryOrder.this).dispose();
			} else if(e.getSource() == btnModifyOrder) {
				try {
					int qty = embroideryOrder.getQuantity();
					double price = embroideryOrder.getPrice();
					
					byte[] logo = fileChosenByte;
					double size = Double.parseDouble(txtFieldSize.getText());
					int numOfColors = Integer.parseInt(txtFieldNumOfColors.getText());
					EmbroideryType embroideryType = EmbroideryType.getEmbroideryType("PATCH");
					int id = embroideryOrder.getItemID();
					
					OrderItem modifiedOrder = new Embroidery.EmbroideryBuilder(qty, price, logo, size, numOfColors, embroideryType)
					.itemID(id)
					.build();
					orderController.modifyOrderItem(embroideryOrder, "EMBROIDERY", (Embroidery) modifiedOrder);
					javax.swing.SwingUtilities.getWindowAncestor(ModifyEmbroideryOrder.this).dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				mainFrame.updateTable();
			} else if(e.getSource() == btnAddFile) {
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg", "gif", "png");
			    fileChooser.setFileFilter(filter);
	            int returnValue = fileChooser.showOpenDialog(null);
	            if (returnValue == JFileChooser.APPROVE_OPTION) {
	                File selectedFile = fileChooser.getSelectedFile();
	                lblFile.setText(selectedFile.getName());
	            }
	            File fileChosen = fileChooser.getSelectedFile();
	            FileInputStream fileStream;
				try {
					fileStream = new FileInputStream(fileChosen);
					fileChosenByte = new byte[(int)fileChosen.length()];
		            fileStream.read(fileChosenByte, 0, fileChosenByte.length);
		            for(int x : fileChosenByte)
		            	System.out.println((char)x);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            
			}
		}
	}
}
