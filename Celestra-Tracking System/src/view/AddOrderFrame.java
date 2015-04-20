
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.OrderController;
import objects.Alteration;
import objects.BottomMeasurement;
import objects.Client;
import objects.Embroidery;
import objects.Garment;
import objects.GarmentOrder;
import objects.GarmentOrder.GarmentOrderBuilder;
import objects.EmbroideryType;
import objects.GarmentType;
import objects.Gender;
import objects.Material;
import objects.Measurement;
import objects.OrderItem;
import objects.OrderList;
import objects.OrderStatus;
import objects.TopMeasurement;
import objects.Unit;
import objects.WomensTopMeasure;
import view.OrderFrame.doActionListener;

public class AddOrderFrame extends JFrame{
	private JButton btnBack, btnAdd, btnCheckOut, btnOpenFile;
	private JLabel lblClientName, lblGender, lblContact, lblEmail, lblDate, lblQuantity, lblGarment, lblMaterials, lblSpecialInstructions, lblAdress;
	private JLabel lblPrice, lblTotal, lblDownPayment, lblInputTotal, lblHeader, lblPreview, lblReceiptNo;
	private JTextField txtClientName, txtGender, txtContact, txtEmail, txtDate, txtQuantity, txtFilePath;
	private JTextField txtAdress, txtPrice, txtDownPayment, txtReceiptNo;
	private JTextArea txtMaterials, txtSpecialInstructions;
	private ButtonGroup bgType, bgGender, bgEmbroidery;
	private JRadioButton rbAlteration, rbMadeToOrder, rbEmbroidery, rbMale, rbFemale;
	private JComboBox cbGarment, cbDueYear, cbDueDay, cbDueMonth, cbGarmentType, cbTGarmentType, cbBGarmentType;
	private JPanel panel_1, alterationPanel, madetoorderPanel, embroideryPanel, mtotopPanel, mtobottomPanel, topPanel;
	private JList addOrderList;
	private String selectedType, selectedMadeToOrder, buttonSelected, embroideryTypeSelected, garmentTypeSelected;
	private byte[] fileChosenByte;
	private DefaultListModel listModel;
	private Double totalPrice = 0.0;
	
	private JTextField txtBHeader, txtBLength, txtBBottom, txtBCrotch, txtBThigh, txtBWaist, txtBHips, txtBKnee;
	private JTextArea txtBMaterials, txtBSpecialInstructions;
	
	private JTextField txtTHeader, txtTLength, txtTShoulder, txtTFrontChest, txtTArmlength, txtTArmhole, txtTBackfigure,
	 		txtTNeckdeep, txtTWristcircum, txtTWaist, txtTHips, txtTFrontfigure, txtTBustpoint, txtTBustdistance, txtTBackChest;
	private JTextArea txtTMaterials, txtTSpecialInstructions;
	
	private JTextField txtSize, txtColors;
	
	private OrderList orderList;
	
	private int receiptNo;
	private Date dueDate;
	private Date orderDate;
	private Double balance = 0.0;
	private String pickupLocation;
	private Client client;
	private OrderStatus status;
	
	private OrderController orderController;
	
	public AddOrderFrame() {
		orderList = new OrderList.OrderListBuilder(receiptNo, dueDate, orderDate, balance, pickupLocation, client, status)
		.build();
		
		orderController = new OrderController();
		
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.decode("#D3D27C"));
		
		UIManager.put("Button.select", Color.decode("#C1BF7D"));
		
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
		
		topPanel = new JPanel();
		topPanel.setBounds(0,0,780,220);
		topPanel.setBackground(Color.decode("#E5EDB8"));
		topPanel.setLayout(null);
		panel_1.add(topPanel);
		
		lblHeader = new JLabel("Add Order");
		lblHeader.setBounds(40,10,150,40);
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 18));
		topPanel.add(lblHeader);
		
		lblClientName = new JLabel("Client's Name:");
		lblClientName.setBounds(40,50,100,40);
		lblClientName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtClientName = new JTextField("");
		txtClientName.setBounds(150,60,430,20);
		txtClientName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		topPanel.add(lblClientName);
		topPanel.add(txtClientName);
		
		lblGender = new JLabel("Gender:");
		lblGender.setBounds(40,80,100,40);
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbMale = new JRadioButton("Male");
		rbMale.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbMale.setFocusPainted(false);
		rbMale.setContentAreaFilled(false);
		rbMale.setBounds(150, 90, 100, 20);
		rbMale.addActionListener(new doActionListener());
		rbFemale = new JRadioButton("Female");
		rbFemale.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbFemale.setFocusPainted(false);
		rbFemale.setContentAreaFilled(false);
		rbFemale.setBounds(250,90, 100, 20);
		rbFemale.addActionListener(new doActionListener());
		
		bgGender = new ButtonGroup();
		bgGender.add(rbMale);
		bgGender.add(rbFemale);
		topPanel.add(lblGender);
		topPanel.add(rbMale);
		topPanel.add(rbFemale);
		
		lblContact = new JLabel("Contact Number:");
		lblContact.setBounds(40,110,100,40);
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtContact = new NumberTextField();
		txtContact.setBounds(150,120,120,20);
		txtContact.setFont(new Font("Tahoma", Font.PLAIN, 12));
		topPanel.add(lblContact);
		topPanel.add(txtContact);
		
		lblEmail = new JLabel("Email Address:");
		lblEmail.setBounds(300,110,100,40);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEmail = new JTextField("");
		txtEmail.setBounds(390,120,190,20);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		topPanel.add(lblEmail);
		topPanel.add(txtEmail);
		
		lblAdress = new JLabel("Address:");
		lblAdress.setBounds(40,140,100,40);
		lblAdress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtAdress = new JTextField("");
		txtAdress.setBounds(150,150,430,20);
		txtAdress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		topPanel.add(lblAdress);
		topPanel.add(txtAdress);
		
		lblDate = new JLabel("Due Date:");
		lblDate.setBounds(40,650,100,40);
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		String[] months = {"01","02", "03","04","05","06","07","08","09","10","11","12"};
		String[] days = {"01","02", "03","04","05","06","07","08","09","10","11","12","13","14", "15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		String[] years = {"2015","2016","2017","2018","2019","2020","2021","2022","2023","2024","2025"};
		cbDueYear = new JComboBox(years);
		cbDueDay = new JComboBox(days);
		cbDueMonth = new JComboBox(months);
		cbDueMonth.setBounds(195,662,100,20);
		cbDueDay.setBounds(305,662,50,20);
		cbDueYear.setBounds(105,662,80,20);
		cbDueYear.setSelectedIndex(0);
		cbDueYear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbDueYear.setBackground(Color.decode("#E5EDB8"));
		cbDueDay.setSelectedIndex(0);
		cbDueDay.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbDueDay.setBackground(Color.decode("#E5EDB8"));
		cbDueMonth.setSelectedIndex(0);
		cbDueMonth.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbDueMonth.setBackground(Color.decode("#E5EDB8"));
		
		panel_1.add(lblDate);
		panel_1.add(cbDueYear);
		panel_1.add(cbDueMonth);
		panel_1.add(cbDueDay);
		
		lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(370,650,100,40);
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtQuantity = new NumberTextField();
		txtQuantity.setBounds(430,662,60,20);
		txtQuantity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(lblQuantity);
		panel_1.add(txtQuantity);
		
		lblPrice = new JLabel("Price:");
		lblPrice.setBounds(500,650,100,40);
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPrice = new NumberTextField();
		txtPrice.setBounds(540,662,100,20);
		txtPrice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(lblPrice);
		panel_1.add(txtPrice);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(650,650,100,40);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAdd.setBackground(Color.decode("#A8A76D"));
		btnAdd.setFocusPainted(false);
		btnAdd.setBorderPainted(false);
		btnAdd.addActionListener(new executeActionListener());
		panel_1.add(btnAdd);
		
		listModel = new DefaultListModel();
		addOrderList = new JList(listModel);
		addOrderList.setBackground(Color.WHITE);
		addOrderList.setFont(new Font("Tahoma",Font.PLAIN, 13));
		addOrderList.setBounds(785, 20, 325, 540);
		panel_1.add(addOrderList);
		
		btnCheckOut = new JButton("Checkout");
		btnCheckOut.setBounds(845,650,200,40);
		btnCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCheckOut.setBackground(Color.decode("#A8A76D"));
		btnCheckOut.setFocusPainted(false);
		btnCheckOut.setBorderPainted(false);
		btnCheckOut.addActionListener(new executeActionListener());
		panel_1.add(btnCheckOut);
		
		lblTotal = new JLabel("Total:");
		lblTotal.setBounds(785,550,100,40);
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInputTotal = new JLabel("/*TOTAL*/");
		lblInputTotal.setBackground(Color.WHITE);
		lblInputTotal.setBounds(885,550,100,40);
		lblInputTotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(lblTotal);
		panel_1.add(lblInputTotal);
		
		lblDownPayment = new JLabel("Down Payment:");
		lblDownPayment.setBounds(785,580,100,40);
		lblDownPayment.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDownPayment = new NumberTextField();
		txtDownPayment.setBackground(Color.WHITE);
		txtDownPayment.setBounds(885,590,100,20);
		txtDownPayment.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(lblDownPayment);
		panel_1.add(txtDownPayment);
		
		lblReceiptNo = new JLabel("Receipt No:");
		lblReceiptNo.setBounds(785,610,100,40);
		lblReceiptNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtReceiptNo = new JTextField();
		txtReceiptNo.setBackground(Color.WHITE);
		txtReceiptNo.setBounds(885,620,100,20);
		txtReceiptNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(lblReceiptNo);
		panel_1.add(txtReceiptNo);
		
		rbAlteration = new JRadioButton("Alteration");
		rbAlteration.setBounds(175, 180, 100, 20);
		rbAlteration.setFocusPainted(false);
		rbAlteration.setContentAreaFilled(false);
		rbAlteration.setActionCommand("alteration");
		rbAlteration.addActionListener(new doActionListener());
		rbAlteration.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbMadeToOrder = new JRadioButton("Made To Order");
		rbMadeToOrder.setBounds(350, 180, 130, 20);
		rbMadeToOrder.setFocusPainted(false);
		rbMadeToOrder.setContentAreaFilled(false);
		rbMadeToOrder.setActionCommand("madetoorder");
		rbMadeToOrder.addActionListener(new doActionListener());
		rbMadeToOrder.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbEmbroidery = new JRadioButton("Embroidery");
		rbEmbroidery.setBounds(545, 180, 100, 20);
		rbEmbroidery.setFocusPainted(false);
		rbEmbroidery.setContentAreaFilled(false);
		rbEmbroidery.setActionCommand("embroidery");
		rbEmbroidery.addActionListener(new doActionListener());
		rbEmbroidery.setFont(new Font("Tahoma", Font.PLAIN, 12));

		bgType = new ButtonGroup();
		bgType.add(rbAlteration);
		bgType.add(rbMadeToOrder);
		bgType.add(rbEmbroidery);
		topPanel.add(rbAlteration);
		topPanel.add(rbMadeToOrder);
		topPanel.add(rbEmbroidery);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		Insets scnMax = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
		int taskBarSize = scnMax.bottom;
		
		this.setSize(screenWidth, screenHeight - taskBarSize);
		this.setResizable(false);
		this.setTitle("Celestra Tailoring and Embroidery");
		this.setVisible(true);
		
		alterationPanel();
		alterationPanel.setVisible(false);
		embroideryPanel();
		embroideryPanel.setVisible(false);
		madetoOrderPanel();
		madetoorderPanel.setVisible(false);
		MTOtopPanel();
		mtotopPanel.setVisible(false);
		MTObottomPanel();
		mtobottomPanel.setVisible(false);
	} 
	
	public void embroideryPanel(){
		embroideryPanel = new JPanel();
		embroideryPanel.setBackground(Color.decode("#E5EDB8"));
		embroideryPanel.setBounds(0,230,800,410);
		embroideryPanel.setLayout(null);
		panel_1.add(embroideryPanel);
		
		JRadioButton rbLogo, rbPatch;
		JLabel lblDesign;
		JTextField txtDesign;
		
		rbLogo = new JRadioButton("Logo");
		rbPatch = new JRadioButton("Patch");
		rbLogo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbPatch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbLogo.setBounds(250, 10, 100, 40);	
		rbPatch.setBounds(450,10,100,40);
		rbLogo.setContentAreaFilled(false);
		rbPatch.setContentAreaFilled(false);
		rbLogo.setFocusPainted(false);
		rbPatch.setFocusPainted(false);
		rbLogo.addActionListener(new doActionListener());
		rbPatch.addActionListener(new doActionListener());
		
		bgEmbroidery = new ButtonGroup();
		bgEmbroidery.add(rbLogo);
		bgEmbroidery.add(rbPatch);
		
		lblDesign = new JLabel("Design:");
		lblDesign.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDesign.setBounds(170, 45, 50, 50);
		
		txtFilePath = new JTextField();
		txtFilePath.setBounds(230, 61,300,20);
		
		btnOpenFile = new JButton("Open");
		btnOpenFile.setBounds(550, 54, 80, 30);
		btnOpenFile.addActionListener(new doActionListener());
		
		lblPreview = new JLabel();
		JLabel lblPreviewHeader = new JLabel("Preview:");
		lblPreviewHeader.setBounds(170,75,150,30);
		lblPreview.setBackground(Color.white);
		lblPreviewHeader.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPreview.setBounds(230, 100, 300, 200);
		
		JLabel lblSize = new JLabel("Size:");
		lblSize.setBounds(170,320, 50, 30);
		lblSize.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSize = new JTextField();
		txtSize.setBounds(250, 323, 100, 20);
		
		JLabel lblColors = new JLabel("No. of Colors:");
		lblColors.setBounds(170,350, 150, 30);
		lblColors.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtColors = new JTextField();
		txtColors.setBounds(250, 353, 100, 20);
		
		embroideryPanel.add(lblPreview);
		embroideryPanel.add(lblPreviewHeader);
		embroideryPanel.add(lblSize);
		embroideryPanel.add(txtSize);
		embroideryPanel.add(lblColors);
		embroideryPanel.add(txtColors);
		embroideryPanel.add(rbLogo);
		embroideryPanel.add(rbPatch);
		embroideryPanel.add(lblDesign);
		embroideryPanel.add(txtFilePath);
		embroideryPanel.add(btnOpenFile);
	}
	
	public void alterationPanel(){
		alterationPanel = new JPanel();
		alterationPanel.setBackground(Color.decode("#E5EDB8"));
		alterationPanel.setBounds(0,230,800,410);
		alterationPanel.setLayout(null);
		panel_1.add(alterationPanel);
		
		txtMaterials = new JTextArea();
		txtSpecialInstructions = new JTextArea();
		txtMaterials.setBounds(40,40, 320, 300);
		txtMaterials.setLineWrap(true);
		txtSpecialInstructions.setBounds(430, 40, 320, 300);
		txtSpecialInstructions.setLineWrap(true);
		alterationPanel.add(txtMaterials);
		alterationPanel.add(txtSpecialInstructions);
		
		JLabel lblGarmentType = new JLabel("Garment Type:");
		lblGarmentType.setBounds(40,355,100,30);
		lblGarmentType.setFont(new Font("Tahoma", Font.PLAIN, 12));
		String[] GarmentType = {"----------","COAT","POLO","BARONG","LONGBLAZER","SHORTBLAZER","VEST","VEST","SHIRT","JACKET", "PANTS","SHORTS","SKIRT","APRON","OTHERS"};
		cbGarmentType= new JComboBox(GarmentType);
		cbGarmentType.setSelectedIndex(0);
		cbGarmentType.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbGarmentType.setBackground(Color.decode("#E5EDB8"));
		cbGarmentType.setBounds(150, 360, 120, 20);
		cbGarmentType.addActionListener(new doActionListener());
		alterationPanel.add(lblGarmentType);
		alterationPanel.add(cbGarmentType);
		
		lblMaterials = new JLabel("Materials:");
		lblSpecialInstructions = new JLabel("Special Instructions:");
		lblMaterials.setBounds(40,7, 150, 40);
		lblSpecialInstructions.setBounds(430, 7, 150, 40);
		lblMaterials.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSpecialInstructions.setFont(new Font("Tahoma", Font.PLAIN, 12));
		alterationPanel.add(lblMaterials);
		alterationPanel.add(lblSpecialInstructions);		
	}
	
	public void madetoOrderPanel(){
		madetoorderPanel = new JPanel();
		madetoorderPanel.setOpaque(false);
		madetoorderPanel.setBounds(0,220,800,50);
		madetoorderPanel.setLayout(null);
		panel_1.add(madetoorderPanel);
		
		lblGarment = new JLabel("Garment:");
		lblGarment.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGarment.setBounds(250, 10, 100, 30);
		
		String[] cbGarmentList = { "----------", "Top", "Bottom"};
		cbGarment = new JComboBox(cbGarmentList);
		cbGarment.setSelectedIndex(0);
		cbGarment.setBounds(325, 15, 150, 20);
		cbGarment.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbGarment.addActionListener(new doActionListener());
		cbGarment.setBackground(Color.decode("#E5EDB8"));
		
		madetoorderPanel.add(lblGarment);
		madetoorderPanel.add(cbGarment);
	}
	
	private void MTOtopPanel(){
		mtotopPanel = new JPanel();
		mtotopPanel.setBackground(Color.decode("#E5EDB8"));
		mtotopPanel.setBounds(0,230,800,400);
		mtotopPanel.setLayout(null);
		panel_1.add(mtotopPanel);
		
		JLabel lblTHeader = new JLabel("Measurements (in inches):");
		JLabel lblTLength = new JLabel("Length:");
		JLabel lblTShoulder = new JLabel("Shoulder:");
		JLabel lblTFrontChest = new JLabel("Front Chest:");
		JLabel lblTArmlength = new JLabel("Arm Length:");
		JLabel lblTArmhole = new JLabel("Arm Hole:");
		JLabel lblTBackfigure = new JLabel("Back Figure:");
		JLabel lblTNeckdeep = new JLabel("Neck Deep:");
		JLabel lblTWristcircum = new JLabel("Wrist Circumference:");
		JLabel lblTWaist = new JLabel("Waist:");
		JLabel lblTHips = new JLabel("Hips:");
		JLabel lblTFrontfigure = new JLabel("Front Figure:");
		JLabel lblTBustpoint = new JLabel("Bust Point:");
		JLabel lblTBustdistance = new JLabel("Bust Distance:");
		JLabel lblTBackChest = new JLabel("Back Chest");
		
		lblTHeader.setBounds(45,20,150,30);
		lblTHeader.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblTLength.setBounds(100,50,100,30);
		lblTLength.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTLength = new NumberTextField();
		txtTLength.setBounds(180, 55, 120, 20);
		
		lblTNeckdeep.setBounds(450,50,100,30);
		lblTNeckdeep.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTNeckdeep = new NumberTextField();
		txtTNeckdeep.setBounds(530, 55, 120, 20);
		
		lblTShoulder.setBounds(100,80,100,30);
		lblTShoulder.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTShoulder = new NumberTextField();
		txtTShoulder.setBounds(180, 85, 120, 20);
		
		lblTWristcircum.setBounds(398,80,150,30);
		lblTWristcircum.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTWristcircum = new NumberTextField();
		txtTWristcircum.setBounds(530, 85, 120, 20);
		
		lblTFrontChest.setBounds(100,110,100,30);
		lblTFrontChest.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTFrontChest = new NumberTextField();
		txtTFrontChest.setBounds(180, 115, 120, 20);
		
		lblTWaist.setBounds(450,110,100,30);
		lblTWaist.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTWaist = new NumberTextField();
		txtTWaist.setBounds(530, 115, 120, 20);
		
		lblTArmlength.setBounds(100,140,100,30);
		lblTArmlength.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTArmlength = new NumberTextField();
		txtTArmlength.setBounds(180, 145, 120, 20);
		
		lblTHips.setBounds(450,140,100,30);
		lblTHips.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTHips = new NumberTextField();
		txtTHips.setBounds(530, 145, 120, 20);
		
		lblTArmhole.setBounds(100,170,100,30);
		lblTArmhole.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTArmhole = new NumberTextField();
		txtTArmhole.setBounds(180, 175, 120, 20);
		
		lblTFrontfigure.setBounds(450,170,100,30);
		lblTFrontfigure.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTFrontfigure = new NumberTextField();
		txtTFrontfigure.setBounds(530, 175, 120, 20);
		
		lblTBackfigure.setBounds(100,200,100,30);
		lblTBackfigure.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTBackfigure= new NumberTextField();
		txtTBackfigure.setBounds(180, 205, 120, 20);
		
		lblTBustpoint.setBounds(450,200,100,30);
		lblTBustpoint.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTBustpoint = new NumberTextField();
		txtTBustpoint.setBounds(530, 205, 120, 20);
		
		lblTBustdistance.setBounds(450,230,100,30);
		lblTBustdistance.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTBustdistance = new NumberTextField();
		txtTBustdistance.setBounds(530, 235, 120, 20);
		
		lblTBackChest.setBounds(100, 235, 120, 20);
		lblTBackChest.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTBackChest = new NumberTextField();
		txtTBackChest.setBounds(180, 235, 120, 20);
		
		JLabel lblTGarmentType = new JLabel("Garment Type:");
		lblTGarmentType.setBounds(100,260,100,30);
		lblTGarmentType.setFont(new Font("Tahoma", Font.PLAIN, 12));
		String[] GarmentType = {"----------", "COAT","POLO","BARONG","LONGBLAZER","SHORTBLAZER","VEST","BLOUSE","SHIRT","JACKET","OTHERS"};
		cbTGarmentType= new JComboBox(GarmentType);
		cbTGarmentType.setSelectedIndex(0);
		cbTGarmentType.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbTGarmentType.setBackground(Color.decode("#E5EDB8"));
		cbTGarmentType.setBounds(190, 265, 120, 20);
		cbTGarmentType.addActionListener(new doActionListener());
		
		JLabel lblTMaterials = new JLabel("Materials:");
		lblTMaterials.setBounds(100,280,100,30);
		lblTMaterials.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTMaterials = new JTextArea();
		txtTMaterials.setBounds(100, 310, 200, 70);
		txtTMaterials.setLineWrap(true);
		
		JLabel lblTSpecialInstructions = new JLabel("Special Instructions:");
		lblTSpecialInstructions.setBounds(450,280,150,30);
		lblTSpecialInstructions.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTSpecialInstructions = new JTextArea();
		txtTSpecialInstructions.setBounds(450, 310, 200, 70);
		txtTSpecialInstructions.setLineWrap(true);
		
		mtotopPanel.add(lblTHeader);
		mtotopPanel.add(lblTLength);
		mtotopPanel.add(txtTLength);
		mtotopPanel.add(lblTShoulder);
		mtotopPanel.add(txtTShoulder);
		mtotopPanel.add(lblTFrontChest);
		mtotopPanel.add(txtTFrontChest);
		mtotopPanel.add(lblTArmlength);
		mtotopPanel.add(txtTArmlength);
		mtotopPanel.add(lblTArmhole);
		mtotopPanel.add(txtTArmhole);
		mtotopPanel.add(lblTBackfigure);
		mtotopPanel.add(txtTBackfigure);
		mtotopPanel.add(lblTNeckdeep);
		mtotopPanel.add(txtTNeckdeep);
		mtotopPanel.add(lblTWristcircum);
		mtotopPanel.add(txtTWristcircum);
		mtotopPanel.add(lblTWaist);
		mtotopPanel.add(txtTWaist);
		mtotopPanel.add(lblTHips);
		mtotopPanel.add(txtTHips);
		mtotopPanel.add(lblTFrontfigure);
		mtotopPanel.add(txtTFrontfigure);
		mtotopPanel.add(lblTBustpoint);
		mtotopPanel.add(txtTBustpoint);
		mtotopPanel.add(lblTBustdistance);
		mtotopPanel.add(txtTBustdistance);
		mtotopPanel.add(lblTBackChest);
		mtotopPanel.add(txtTBackChest);
		mtotopPanel.add(lblTMaterials);
		mtotopPanel.add(txtTMaterials);
		mtotopPanel.add(lblTGarmentType);
		mtotopPanel.add(cbTGarmentType);
		mtotopPanel.add(lblTSpecialInstructions);
		mtotopPanel.add(txtTSpecialInstructions);
	}
	
	private void MTObottomPanel(){
		mtobottomPanel = new JPanel();
		mtobottomPanel.setBackground(Color.decode("#E5EDB8"));
		mtobottomPanel.setBounds(0,230,800,400);
		mtobottomPanel.setLayout(null);
		panel_1.add(mtobottomPanel);
		
		JLabel lblBHeader = new JLabel("Measurements (in inches):");
		JLabel lblBLength = new JLabel("Length:");
		JLabel lblBBottom = new JLabel("Bottom:");
		JLabel lblBCrotch = new JLabel("Crotch:");
		JLabel lblBThigh = new JLabel("Thigh:");
		JLabel lblBWaist = new JLabel("Waist:");
		JLabel lblBHips = new JLabel("Hips:");
		JLabel lblBKnee = new JLabel("Knee:");
		
		lblBHeader.setBounds(45,20,150,30);
		lblBHeader.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblBLength.setBounds(100,50,100,30);
		lblBLength.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtBLength = new NumberTextField();
		txtBLength.setBounds(180, 55, 120, 20);
		
		lblBWaist.setBounds(450,50,100,30);
		lblBWaist.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtBWaist = new NumberTextField();
		txtBWaist.setBounds(530, 55, 120, 20);
		
		lblBBottom.setBounds(100,80,100,30);
		lblBBottom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtBBottom = new NumberTextField();
		txtBBottom.setBounds(180, 85, 120, 20);
		
		lblBHips.setBounds(450,80,150,30);
		lblBHips.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtBHips= new NumberTextField();
		txtBHips.setBounds(530, 85, 120, 20);
		
		lblBCrotch.setBounds(100,110,100,30);
		lblBCrotch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtBCrotch = new NumberTextField();
		txtBCrotch.setBounds(180, 115, 120, 20);
		
		lblBKnee.setBounds(450,110,100,30);
		lblBKnee.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtBKnee = new NumberTextField();
		txtBKnee.setBounds(530, 115, 120, 20);
		
		lblBThigh.setBounds(100,140,100,30);
		lblBThigh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtBThigh = new NumberTextField();
		txtBThigh.setBounds(180, 145, 120, 20);
		
		JLabel lblBGarmentType = new JLabel("Garment Type:");
		lblBGarmentType.setBounds(100,170,100,30);
		lblBGarmentType.setFont(new Font("Tahoma", Font.PLAIN, 12));
		String[] GarmentType = {"----------","PANTS","SHORTS","SKIRT","APRON","OTHERS"};
		cbBGarmentType= new JComboBox(GarmentType);
		cbBGarmentType.setSelectedIndex(0);
		cbBGarmentType.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbBGarmentType.setBackground(Color.decode("#E5EDB8"));
		cbBGarmentType.setBounds(190, 175, 120, 20);
		cbBGarmentType.addActionListener(new doActionListener());
		
		JLabel lblBMaterials = new JLabel("Materials:");
		lblBMaterials.setBounds(100,260,100,30);
		lblBMaterials.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtBMaterials = new JTextArea();
		txtBMaterials.setBounds(100, 285, 200, 100);
		txtBMaterials.setLineWrap(true);
		
		JLabel lblBSpecialInstructions = new JLabel("Special Instructions:");
		lblBSpecialInstructions.setBounds(450,260,150,30);
		lblBSpecialInstructions.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtBSpecialInstructions = new JTextArea();
		txtBSpecialInstructions.setBounds(450, 285, 200, 100);
		txtBSpecialInstructions.setLineWrap(true);
		
		mtobottomPanel.add(lblBHeader);
		mtobottomPanel.add(lblBLength);
		mtobottomPanel.add(txtBLength);
		mtobottomPanel.add(lblBWaist);
		mtobottomPanel.add(txtBWaist);
		mtobottomPanel.add(lblBBottom);
		mtobottomPanel.add(txtBBottom);
		mtobottomPanel.add(lblBHips);
		mtobottomPanel.add(txtBHips);
		mtobottomPanel.add(lblBCrotch);
		mtobottomPanel.add(txtBCrotch);
		mtobottomPanel.add(lblBKnee);
		mtobottomPanel.add(txtBKnee);
		mtobottomPanel.add(lblBThigh);
		mtobottomPanel.add(txtBThigh);
		mtobottomPanel.add(lblBGarmentType);
		mtobottomPanel.add(cbBGarmentType);
		mtobottomPanel.add(lblBMaterials);
		mtobottomPanel.add(txtBMaterials);
		mtobottomPanel.add(lblBSpecialInstructions);
		mtobottomPanel.add(txtBSpecialInstructions);
	}
	
	public class doActionListener implements ActionListener {
		//String action = bgType.getSelection().getActionCommand();
		
		@Override
		public void actionPerformed(ActionEvent action) {
			if(action.getSource() == btnBack) {
				totalPrice = 0.0;
				dispose();
			} else if(action.getSource() instanceof JRadioButton){
				JRadioButton rb = (JRadioButton) action.getSource();
				if(rb.isSelected()){
					if(rb.getText().equalsIgnoreCase("Alteration")){
						selectedType = "Alteration";
						alterationPanel.setVisible(true);
						embroideryPanel.setVisible(false);
						madetoorderPanel.setVisible(false);
						mtotopPanel.setVisible(false);
						mtobottomPanel.setVisible(false);
					}else if(rb.getText().equalsIgnoreCase("Made To Order")){
						selectedType = "Made To Order";
						alterationPanel.setVisible(false);
						embroideryPanel.setVisible(false);
						madetoorderPanel.setVisible(true);
						cbGarment.setSelectedIndex(0);
						mtotopPanel.setVisible(false);
						mtobottomPanel.setVisible(false);
					}else if(rb.getText().equalsIgnoreCase("Embroidery")){
						selectedType = "Embroidery";
						embroideryPanel.setVisible(true);
						alterationPanel.setVisible(false);
						madetoorderPanel.setVisible(false);
						mtotopPanel.setVisible(false);
						mtobottomPanel.setVisible(false);
					}else if(rb.getText().equals("Female")){
						buttonSelected = "FEMALE";
					}else if(rb.getText().equals("Male")){
						buttonSelected = "MALE";
					}else if(rb.getText().equals("Logo")) {
						embroideryTypeSelected = "LOGO";
					}else if(rb.getText().equals("Patch")) {
						embroideryTypeSelected = "PATCH";
					}
				}
			}else if(action.getSource() == btnOpenFile){
				JFileChooser fcDesignChooser = new JFileChooser("hallo");
				fcDesignChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
				        "JPG, GIF, PNG  Images", "jpg", "gif", "png");
				fcDesignChooser.setFileFilter(filter);
				
				int result = fcDesignChooser.showOpenDialog(AddOrderFrame.this);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fcDesignChooser.getSelectedFile();
				    txtFilePath.setText(selectedFile.toString());
				    String imagePath = selectedFile.getAbsolutePath();
				    ImageIcon imageIcon = new ImageIcon(imagePath);
				    Image image = imageIcon.getImage();
				    Image resizedImage = image.getScaledInstance(300, 200, java.awt.Image.SCALE_SMOOTH);
				    imageIcon = new ImageIcon(resizedImage);
				    lblPreview.setIcon(imageIcon);
				    
				    FileInputStream fileStream;
				    try {
						fileStream = new FileInputStream(selectedFile);
						fileChosenByte = new byte[(int)selectedFile.length()];
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
				fcDesignChooser.setBounds(340, 45, 300, 100);
			}else if(action.getSource() instanceof JComboBox){
				JComboBox cb = (JComboBox) action.getSource();
				
				if(cb.getSelectedItem().toString().equalsIgnoreCase("----------")){
						alterationPanel.setVisible(false);
						embroideryPanel.setVisible(false);
						madetoorderPanel.setVisible(true);
						mtotopPanel.setVisible(false);
						mtobottomPanel.setVisible(false);
				}else if(cb.getSelectedItem().toString().equalsIgnoreCase("Top")){
						selectedMadeToOrder = "Top";
						alterationPanel.setVisible(false);
						embroideryPanel.setVisible(false);
						madetoorderPanel.setVisible(true);
						mtotopPanel.setVisible(true);
						mtobottomPanel.setVisible(false);
				}else if(cb.getSelectedItem().toString().equalsIgnoreCase("Bottom")){
						selectedMadeToOrder = "Bottom";
						embroideryPanel.setVisible(false);
						alterationPanel.setVisible(false);
						madetoorderPanel.setVisible(true);
						mtotopPanel.setVisible(false);
						mtobottomPanel.setVisible(true);
				}else if(cb.getSelectedItem().toString().equalsIgnoreCase("COAT")) {
					garmentTypeSelected = "COAT";
				}else if(cb.getSelectedItem().toString().equalsIgnoreCase("POLO")) {
					garmentTypeSelected = "POLO";
				}else if(cb.getSelectedItem().toString().equalsIgnoreCase("BARONG")) {
					garmentTypeSelected = "BARONG";
				}else if(cb.getSelectedItem().toString().equalsIgnoreCase("LONGBLAZER")) {
					garmentTypeSelected = "LONGBLAZER";
				}else if(cb.getSelectedItem().toString().equalsIgnoreCase("SHORTBLAZER")) {
					garmentTypeSelected = "SHORTBLAZER";
				}else if(cb.getSelectedItem().toString().equalsIgnoreCase("VEST")) {
					garmentTypeSelected = "VEST";
				}else if(cb.getSelectedItem().toString().equalsIgnoreCase("BLOUSE")) {
					garmentTypeSelected = "BLOUSE";
				}else if(cb.getSelectedItem().toString().equalsIgnoreCase("SHIRT")) {
					garmentTypeSelected = "SHIRT";
				}else if(cb.getSelectedItem().toString().equalsIgnoreCase("JACKET")) {
					garmentTypeSelected = "JACKET";
				}else if(cb.getSelectedItem().toString().equalsIgnoreCase("PANTS")) {
					garmentTypeSelected = "PANTS";
				}else if(cb.getSelectedItem().toString().equalsIgnoreCase("SKIRT")) {
					garmentTypeSelected = "SKIRT";
				}else if(cb.getSelectedItem().toString().equalsIgnoreCase("SHORTS")) {
					garmentTypeSelected = "SHORTS";
				}else if(cb.getSelectedItem().toString().equalsIgnoreCase("APRON")) {
					garmentTypeSelected = "APRON";
				}else if(cb.getSelectedItem().toString().equalsIgnoreCase("OTHER")) {
					garmentTypeSelected = "OTHER";
				}
			}
		}
	}
	
	public class executeActionListener implements ActionListener {

		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent x) {
			if(x.getSource() == btnCheckOut) {
				//due date
				int day = Integer.parseInt(cbDueDay.getSelectedItem().toString());
				int month = Integer.parseInt(cbDueMonth.getSelectedItem().toString());
				int year = Integer.parseInt(cbDueYear.getSelectedItem().toString());
				
				//order date
				Calendar calendar = new GregorianCalendar();
				int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
				int currentMonth = calendar.get(Calendar.MONTH);
				int currentYear = calendar.get(Calendar.YEAR);
				
				Double bal = Double.parseDouble(txtDownPayment.getText());
				String location = txtAdress.getText();
				
				String clientName = txtClientName.getText();
				String[] splitStr = clientName.split("\\s"); 
				String lastName = splitStr[0];
				String firstName = splitStr[1];
				Client client1 = new Client.ClientBuilder(lastName, firstName, buttonSelected, txtContact.getText())
				.email(txtEmail.getText())
				.build();
				
				OrderStatus stat = OrderStatus.PENDING;
				int receiptNo = Integer.parseInt(txtReceiptNo.getText());
				totalPrice = 0.0;
				
				orderList.setClient(client1);
				orderList.setStatus(stat);
				orderList.setPickupLocation(location);
				orderList.setBalance(bal);
				orderList.setDueDate(getDate(day, month, year));
				orderList.setOrderDate(getDate(currentDay, currentMonth, currentYear));
				orderList.setReceiptNo(receiptNo);
				
				try {
					orderController.addNewOrder(orderList);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				dispose();
			} else if (x.getSource() == btnAdd) {
				if(selectedType.equals("Alteration")) {
					int quantity = Integer.parseInt(txtQuantity.getText());
					Double price = Double.parseDouble(txtPrice.getText());
					totalPrice += price;
					String garmentSelected = garmentTypeSelected;
					Garment garment = Garment.getGarment(garmentSelected);
					String instruction = txtSpecialInstructions.getText();
					
					OrderItem alterationOrder = new Alteration.AlterationBuilder(quantity, price, garment, instruction)
					.build();
					
					listModel.addElement("ALTERATION: " + quantity + " " + garmentSelected + " (" + price + ")");
					lblInputTotal.setText(totalPrice.toString());
					
					orderList.addOrderItem(alterationOrder);
				} else if (selectedType.equals("Made To Order")) {
					if(selectedMadeToOrder.equals("Top")) {
						int quantity = Integer.parseInt(txtQuantity.getText());
						Double price = Double.parseDouble(txtPrice.getText());
						totalPrice += price;
						String materials = txtMaterials.getText();
						String instruction = txtSpecialInstructions.getText();
						Gender garmentGender = Gender.getGender(buttonSelected);
						String garmentSelected = garmentTypeSelected;
						Garment garment = Garment.getGarment(garmentSelected);
				
						Double upperLength = Double.parseDouble(txtTLength.getText());
						Double shoulder = Double.parseDouble(txtTShoulder.getText());
						Double armLength = Double.parseDouble(txtTArmlength.getText());
						Double wrist = Double.parseDouble(txtTWristcircum.getText());
						Double armHole = Double.parseDouble(txtTArmhole.getText());
						Double frontChest = Double.parseDouble(txtTFrontChest.getText());
						Double backChest = Double.parseDouble(txtTBackChest.getText());
						Double waist = Double.parseDouble(txtTWaist.getText());
						Double hips = Double.parseDouble(txtTHips.getText());
						Double neckDeep = Double.parseDouble(txtTNeckdeep.getText());
						Double frontFigure = Double.parseDouble(txtTFrontfigure.getText());
						Double bustPoint = Double.parseDouble(txtTBustpoint.getText());
						Double bustDistance = Double.parseDouble(txtTBustdistance.getText());
						Double backFigure = Double.parseDouble(txtTBackfigure.getText());
						
						TopMeasurement measurement = new WomensTopMeasure.WomensTopMeasureBuilder(upperLength, shoulder, armLength, wrist, armHole, frontChest, backChest, waist, hips, neckDeep, frontFigure, bustPoint, bustDistance, backFigure)
						.build();
						
						ArrayList<Measurement> measurementSet = new ArrayList<>();
						measurementSet.add(measurement);
						
						OrderItem garmentOrder = new GarmentOrder.GarmentOrderBuilder(quantity, price, garment, garmentGender, measurementSet.iterator())
						.material(materials)
						.instruction(instruction)
						.build();
						//removed itemid
						
						listModel.addElement("MADE TO ORDER: " + quantity + " " + garmentSelected + " - " + garmentGender.toString() + " Top (" + price + ")");
						lblInputTotal.setText(totalPrice.toString());
						
						orderList.addOrderItem(garmentOrder);
					} else if (selectedMadeToOrder.equals("Bottom")) {
						int quantity = Integer.parseInt(txtQuantity.getText());
						Double price = Double.parseDouble(txtPrice.getText());
						totalPrice += price;
						String materials = txtMaterials.getText();
						String instruction = txtSpecialInstructions.getText();
						Gender garmentGender = Gender.getGender(buttonSelected);
						String garmentSelected = garmentTypeSelected;
						Garment garment = Garment.getGarment(garmentSelected);
						
						Double bottomLength = Double.parseDouble(txtBLength.getText());
						Double bottom = Double.parseDouble(txtBBottom.getText());
						Double crotch = Double.parseDouble(txtBCrotch.getText());
						Double thigh = Double.parseDouble(txtBThigh.getText());
						Double waist = Double.parseDouble(txtBWaist.getText());
						Double hips = Double.parseDouble(txtBHips.getText());
						Double knee = Double.parseDouble(txtBKnee.getText());
						
						BottomMeasurement measurement = new BottomMeasurement.BottomMeasurementBuilder(bottomLength, waist, hips, thigh, knee, bottom, crotch)
						.build();
						
						ArrayList<Measurement> measurementSet = new ArrayList<>();
						measurementSet.add(measurement);
						
						OrderItem garmentOrder = new GarmentOrder.GarmentOrderBuilder(quantity, price, garment, garmentGender, measurementSet.iterator())
						.material(materials)
						.instruction(instruction)
						.build();
						//removed itemid
						
						listModel.addElement("MADE TO ORDER: " + quantity + " " + garmentSelected + " - " + garmentGender.toString() + " Bottom (" + price + ")");
						lblInputTotal.setText(totalPrice.toString());
						
						orderList.addOrderItem(garmentOrder);
					}
					
				} /*else if (selectedType.equals("Embroidery")) {
					int quantity = Integer.parseInt(txtQuantity.getText());
					Double price = Double.parseDouble(txtPrice.getText());
					totalPrice += price;
					byte[] logo = fileChosenByte;
					double size = Double.parseDouble(txtSize.getText());
					int numOfColors = Integer.parseInt(txtColors.getText());
					String typeEmbroidery = embroideryTypeSelected;
					EmbroideryType type = EmbroideryType.getEmbroideryType(typeEmbroidery);
					
					OrderItem embroideryOrder = new Embroidery.EmbroideryBuilder(quantity, price, logo, size, numOfColors, type)
					.build();
					
					listModel.addElement("EMBROIDERY: " + quantity + " " + size + " " + typeEmbroidery + " (" + price + ")");
					lblInputTotal.setText(totalPrice.toString());
					
					orderList.addOrderItem(embroideryOrder);
				}*/
			}	
		}
	}
	
	private java.sql.Date getDate(int day, int month, int year) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, day);
		return new java.sql.Date(cal.getTimeInMillis());
	}
}

