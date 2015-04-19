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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

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
import objects.OrderStatus;
import objects.TopMeasurement;
import objects.Unit;
import objects.WomensTopMeasure;
import view.OrderFrame.doActionListener;

public class AddOrderFrame extends JFrame{
	private JButton btnBack, btnAdd, btnCheckOut, btnOpenFile;
	private JLabel lblClientName, lblGender, lblContact, lblEmail, lblDate, lblQuantity, lblGarment, lblMaterials, lblSpecialInstructions, lblAdress;
	private JLabel lblPrice, lblTotal, lblDownPayment, lblInputTotal, lblHeader, lblPreview;
	private JTextField txtClientName, txtGender, txtContact, txtEmail, txtDate, txtQuantity, txtFilePath, txtLength, txtShoulder,txtChest, txtArmlength;
	private JTextField txtArmhole, txtBackfigure, txtNeckdeep, txtWristcircum, txtWaist, txtHips, txtFrontfigure, txtBustpoint, txtBustdistance;
	private JTextField txtBottom, txtCrotch, txtThigh, txtKnee, txtAdress, txtPrice, txtDownPayment;
	private JTextArea txtMaterials, txtSpecialInstructions;
	private ButtonGroup bgType, bgGender, bgEmbroidery;
	private JRadioButton rbAlteration, rbMadeToOrder, rbEmbroidery, rbMale, rbFemale;
	private JComboBox cbGarment, cbDueYear, cbDueDay, cbDueMonth;
	private JPanel panel_1, alterationPanel, madetoorderPanel, embroideryPanel, mtotopPanel, mtobottomPanel, topPanel;
	private JList addOrderList;
	private String selectedType, selectedMadeToOrder, buttonSelected;
	private byte[] fileChosenByte;
	private DefaultListModel listModel;
	private Double totalPrice = 0.0;
	
	public AddOrderFrame() {
		
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
		txtContact = new JTextField("");
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
		txtQuantity = new JTextField("");
		txtQuantity.setBounds(430,662,60,20);
		txtQuantity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(lblQuantity);
		panel_1.add(txtQuantity);
		
		lblPrice = new JLabel("Price:");
		lblPrice.setBounds(500,650,100,40);
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPrice = new JTextField("");
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
		addOrderList.setBounds(785, 20, 325, 550);
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
		lblTotal.setBounds(785,570,100,40);
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInputTotal = new JLabel("/*TOTAL*/");
		lblInputTotal.setBackground(Color.WHITE);
		lblInputTotal.setBounds(885,570,100,40);
		lblInputTotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(lblTotal);
		panel_1.add(lblInputTotal);
		
		lblDownPayment = new JLabel("Down Payment:");
		lblDownPayment.setBounds(785,600,100,40);
		lblDownPayment.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDownPayment = new JTextField();
		txtDownPayment.setBackground(Color.WHITE);
		txtDownPayment.setBounds(885,610,100,20);
		txtDownPayment.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(lblDownPayment);
		panel_1.add(txtDownPayment);
		
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
		
		lblPreview = new JLabel(); //make this label
		JLabel lblPreviewHeader = new JLabel("Preview:");
		lblPreviewHeader.setBounds(170,75,150,30);
		lblPreview.setBackground(Color.white);
		lblPreviewHeader.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPreview.setBounds(230, 100, 300, 250);
		
		embroideryPanel.add(lblPreview);
		embroideryPanel.add(lblPreviewHeader);
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
		txtMaterials.setBounds(40,40, 320, 350);
		txtMaterials.setLineWrap(true);
		txtSpecialInstructions.setBounds(430, 40, 320, 350);
		txtSpecialInstructions.setLineWrap(true);
		alterationPanel.add(txtMaterials);
		alterationPanel.add(txtSpecialInstructions);
		
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
		
		JLabel lblHeader = new JLabel("Measurements (in inches):");
		JLabel lblLength = new JLabel("Length:");
		JLabel lblShoulder = new JLabel("Shoulder:");
		JLabel lblChest = new JLabel("Chest:");
		JLabel lblArmlength = new JLabel("Arm Length:");
		JLabel lblArmhole = new JLabel("Arm Hole:");
		JLabel lblBackfigure = new JLabel("Back Figure:");
		JLabel lblNeckdeep = new JLabel("Neck Deep:");
		JLabel lblWristcircum = new JLabel("Wrist Circumference:");
		JLabel lblWaist = new JLabel("Waist:");
		JLabel lblHips = new JLabel("Hips:");
		JLabel lblFrontfigure = new JLabel("Front Figure:");
		JLabel lblBustpoint = new JLabel("Bust Point:");
		JLabel lblBustdistance = new JLabel("Bust Distance:");
		
		lblHeader.setBounds(45,20,150,30);
		lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblLength.setBounds(100,50,100,30);
		lblLength.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtLength = new JTextField();
		txtLength.setBounds(180, 55, 120, 20);
		
		lblNeckdeep.setBounds(450,50,100,30);
		lblNeckdeep.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNeckdeep = new JTextField();
		txtNeckdeep.setBounds(530, 55, 120, 20);
		
		lblShoulder.setBounds(100,80,100,30);
		lblShoulder.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtShoulder = new JTextField();
		txtShoulder.setBounds(180, 85, 120, 20);
		
		lblWristcircum.setBounds(398,80,150,30);
		lblWristcircum.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtWristcircum = new JTextField();
		txtWristcircum.setBounds(530, 85, 120, 20);
		
		lblChest.setBounds(100,110,100,30);
		lblChest.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtChest = new JTextField();
		txtChest.setBounds(180, 115, 120, 20);
		
		lblWaist.setBounds(450,110,100,30);
		lblWaist.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtWaist = new JTextField();
		txtWaist.setBounds(530, 115, 120, 20);
		
		lblArmlength.setBounds(100,140,100,30);
		lblArmlength.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtArmlength = new JTextField();
		txtArmlength.setBounds(180, 145, 120, 20);
		
		lblHips.setBounds(450,140,100,30);
		lblHips.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtHips = new JTextField();
		txtHips.setBounds(530, 145, 120, 20);
		
		lblArmhole.setBounds(100,170,100,30);
		lblArmhole.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtArmhole = new JTextField();
		txtArmhole.setBounds(180, 175, 120, 20);
		
		lblFrontfigure.setBounds(450,170,100,30);
		lblFrontfigure.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtFrontfigure = new JTextField();
		txtFrontfigure.setBounds(530, 175, 120, 20);
		
		lblBackfigure.setBounds(100,200,100,30);
		lblBackfigure.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtBackfigure= new JTextField();
		txtBackfigure.setBounds(180, 205, 120, 20);
		
		lblBustpoint.setBounds(450,200,100,30);
		lblBustpoint.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtBustpoint = new JTextField();
		txtBustpoint.setBounds(530, 205, 120, 20);
		
		lblBustdistance.setBounds(450,230,100,30);
		lblBustdistance.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtBustdistance = new JTextField();
		txtBustdistance.setBounds(530, 235, 120, 20);
		
		lblMaterials = new JLabel("Materials:");
		lblMaterials.setBounds(100,260,100,30);
		lblMaterials.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMaterials = new JTextArea();
		txtMaterials.setBounds(100, 285, 200, 100);
		txtMaterials.setLineWrap(true);
		
		lblSpecialInstructions = new JLabel("Special Instructions:");
		lblSpecialInstructions.setBounds(450,260,150,30);
		lblSpecialInstructions.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSpecialInstructions = new JTextArea();
		txtSpecialInstructions.setBounds(450, 285, 200, 100);
		txtSpecialInstructions.setLineWrap(true);
		
		mtotopPanel.add(lblHeader);
		mtotopPanel.add(lblLength);
		mtotopPanel.add(txtLength);
		mtotopPanel.add(lblShoulder);
		mtotopPanel.add(txtShoulder);
		mtotopPanel.add(lblChest);
		mtotopPanel.add(txtChest);
		mtotopPanel.add(lblArmlength);
		mtotopPanel.add(txtArmlength);
		mtotopPanel.add(lblArmhole);
		mtotopPanel.add(txtArmhole);
		mtotopPanel.add(lblBackfigure);
		mtotopPanel.add(txtBackfigure);
		mtotopPanel.add(lblNeckdeep);
		mtotopPanel.add(txtNeckdeep);
		mtotopPanel.add(lblWristcircum);
		mtotopPanel.add(txtWristcircum);
		mtotopPanel.add(lblWaist);
		mtotopPanel.add(txtWaist);
		mtotopPanel.add(lblHips);
		mtotopPanel.add(txtHips);
		mtotopPanel.add(lblFrontfigure);
		mtotopPanel.add(txtFrontfigure);
		mtotopPanel.add(lblBustpoint);
		mtotopPanel.add(txtBustpoint);
		mtotopPanel.add(lblBustdistance);
		mtotopPanel.add(txtBustdistance);
		mtotopPanel.add(lblMaterials);
		mtotopPanel.add(txtMaterials);
		mtotopPanel.add(lblSpecialInstructions);
		mtotopPanel.add(txtSpecialInstructions);
	}
	
	private void MTObottomPanel(){
		mtobottomPanel = new JPanel();
		mtobottomPanel.setBackground(Color.decode("#E5EDB8"));
		mtobottomPanel.setBounds(0,230,800,400);
		mtobottomPanel.setLayout(null);
		panel_1.add(mtobottomPanel);
		
		JLabel lblHeader = new JLabel("Measurements (in inches):");
		JLabel lblLength = new JLabel("Length:");
		JLabel lblBottom = new JLabel("Bottom:");
		JLabel lblCrotch = new JLabel("Crotch:");
		JLabel lblThigh = new JLabel("Thigh:");
		JLabel lblWaist = new JLabel("Waist:");
		JLabel lblHips = new JLabel("Hips:");
		JLabel lblKnee = new JLabel("Knee:");
		
		lblHeader.setBounds(45,20,150,30);
		lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblLength.setBounds(100,50,100,30);
		lblLength.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtLength = new JTextField();
		txtLength.setBounds(180, 55, 120, 20);
		
		lblWaist.setBounds(450,50,100,30);
		lblWaist.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtWaist = new JTextField();
		txtWaist.setBounds(530, 55, 120, 20);
		
		lblBottom.setBounds(100,80,100,30);
		lblBottom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtBottom = new JTextField();
		txtBottom.setBounds(180, 85, 120, 20);
		
		lblHips.setBounds(450,80,150,30);
		lblHips.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtHips= new JTextField();
		txtHips.setBounds(530, 85, 120, 20);
		
		lblCrotch.setBounds(100,110,100,30);
		lblCrotch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCrotch = new JTextField();
		txtCrotch.setBounds(180, 115, 120, 20);
		
		lblKnee.setBounds(450,110,100,30);
		lblKnee.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtKnee = new JTextField();
		txtKnee.setBounds(530, 115, 120, 20);
		
		lblThigh.setBounds(100,140,100,30);
		lblThigh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtThigh = new JTextField();
		txtThigh.setBounds(180, 145, 120, 20);
		
		lblMaterials = new JLabel("Materials:");
		lblMaterials.setBounds(100,260,100,30);
		lblMaterials.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMaterials = new JTextArea();
		txtMaterials.setBounds(100, 285, 200, 100);
		txtMaterials.setLineWrap(true);
		
		lblSpecialInstructions = new JLabel("Special Instructions:");
		lblSpecialInstructions.setBounds(450,260,150,30);
		lblSpecialInstructions.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSpecialInstructions = new JTextArea();
		txtSpecialInstructions.setBounds(450, 285, 200, 100);
		txtSpecialInstructions.setLineWrap(true);
		
		mtobottomPanel.add(lblHeader);
		mtobottomPanel.add(lblLength);
		mtobottomPanel.add(txtLength);
		mtobottomPanel.add(lblWaist);
		mtobottomPanel.add(txtWaist);
		mtobottomPanel.add(lblBottom);
		mtobottomPanel.add(txtBottom);
		mtobottomPanel.add(lblHips);
		mtobottomPanel.add(txtHips);
		mtobottomPanel.add(lblCrotch);
		mtobottomPanel.add(txtCrotch);
		mtobottomPanel.add(lblKnee);
		mtobottomPanel.add(txtKnee);
		mtobottomPanel.add(lblThigh);
		mtobottomPanel.add(txtThigh);
		mtobottomPanel.add(lblMaterials);
		mtobottomPanel.add(txtMaterials);
		mtobottomPanel.add(lblSpecialInstructions);
		mtobottomPanel.add(txtSpecialInstructions);
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
				    Image resizedImage = image.getScaledInstance(300, 250, java.awt.Image.SCALE_SMOOTH);
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
				}		
			}
		}
	}
	
	public class executeActionListener implements ActionListener {

		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent x) {
			if(x.getSource() == btnCheckOut) {
				/*String dueDateString = cbDueYear.getSelectedItem().toString() +	
										cbDueMonth.getSelectedItem().toString() +
										cbDueDay.getSelectedItem().toString();
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd");				
				try {
					java.util.Date date = format.parse(dueDateString);
					java.sql.Date sqlDate = new java.sql.Date(date.getTime());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				
				Double balance = Double.parseDouble(txtDownPayment.getText());
				String pickupLocation = txtAdress.getText();
				
				String clientName = txtClientName.getText();
				String[] splitStr = clientName.split("\\s"); 
				String lastName = splitStr[0];
				String firstName = splitStr[1];
				Client client = new Client.ClientBuilder(lastName, firstName, bgGender.getSelection().getActionCommand(), txtContact.getText())
				.email(txtEmail.getText())
				.build();
				
				OrderStatus status = OrderStatus.PENDING;
				
				totalPrice = 0.0;
				
				dispose();
			} else if (x.getSource() == btnAdd) {
				if(selectedType.equals("Alteration")) {
					System.out.println("Alteration");
					int quantity = Integer.parseInt(txtQuantity.getText());
					Double price = Double.parseDouble(txtPrice.getText());
					totalPrice += price;
					String garmentSelected = "COAT"; //change to option garmenttypes
					Garment garment = Garment.getGarment(garmentSelected);
					String instruction = txtSpecialInstructions.getText();
					
					OrderItem alterationOrder = new Alteration.AlterationBuilder(quantity, price, garment, instruction)
					.build();
					
					listModel.addElement("ALTERATION: " + quantity + " " + garmentSelected + " (" + price + ")");
					lblInputTotal.setText(totalPrice.toString());
				} else if (selectedType.equals("Made To Order")) {
					if(selectedMadeToOrder.equals("Top")) {
						int quantity = Integer.parseInt(txtQuantity.getText());
						Double price = Double.parseDouble(txtPrice.getText());
						totalPrice += price;
						String materials = txtMaterials.getText();
						String instruction = txtSpecialInstructions.getText();
						Gender garmentGender = Gender.getGender(buttonSelected);
						String garmentSelected = "COAT"; //option for garmenttypes
						Garment garment = Garment.getGarment(garmentSelected);
						
						Double upperLength = Double.parseDouble(txtLength.getText());
						Double shoulder = Double.parseDouble(txtShoulder.getText());
						Double armLength = Double.parseDouble(txtArmlength.getText());
						Double wrist = Double.parseDouble(txtWristcircum.getText());
						Double armHole = Double.parseDouble(txtArmhole.getText());
						Double frontChest = Double.parseDouble(txtChest.getText());
						Double backChest = Double.parseDouble(txtChest.getText()); //missing?
						Double waist = Double.parseDouble(txtWaist.getText());
						Double hips = Double.parseDouble(txtHips.getText());
						Double neckDeep = Double.parseDouble(txtNeckdeep.getText());
						Double frontFigure = Double.parseDouble(txtFrontfigure.getText());
						Double bustPoint = Double.parseDouble(txtBustpoint.getText());
						Double bustDistance = Double.parseDouble(txtBustdistance.getText());
						Double backFigure = Double.parseDouble(txtBackfigure.getText());
						
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
					} else if (selectedMadeToOrder.equals("Bottom")) {
						int quantity = Integer.parseInt(txtQuantity.getText());
						Double price = Double.parseDouble(txtPrice.getText());
						totalPrice += price;
						String materials = txtMaterials.getText();
						String instruction = txtSpecialInstructions.getText();
						Gender garmentGender = Gender.getGender(buttonSelected);
						String garmentSelected = "COAT"; //option for garmenttypes
						Garment garment = Garment.getGarment(garmentSelected);
						
						Double bottomLength = Double.parseDouble(txtLength.getText());
						Double bottom = Double.parseDouble(txtBottom.getText());
						Double crotch = Double.parseDouble(txtCrotch.getText());
						Double thigh = Double.parseDouble(txtThigh.getText());
						Double waist = Double.parseDouble(txtWaist.getText());
						Double hips = Double.parseDouble(txtHips.getText());
						Double knee = Double.parseDouble(txtKnee.getText());
						
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
					}
					
				} else if (selectedType.equals("Embroidery")) {
					System.out.println("EMBROIDERY");
					int quantity = Integer.parseInt(txtQuantity.getText());
					Double price = Double.parseDouble(txtPrice.getText());
					totalPrice += price;
					byte[] logo = fileChosenByte;
					double size = 4.0; //size textfield
					int numOfColors = 4; //number of colors textfield
					String typeEmbroidery = bgEmbroidery.getSelection().getActionCommand();
					EmbroideryType type = EmbroideryType.getEmbroideryType(typeEmbroidery);
					
					OrderItem embroideryOrder = new Embroidery.EmbroideryBuilder(quantity, price, logo, size, numOfColors, type)
					.build();
					
					listModel.addElement("EMBROIDERY: " + quantity + " " + size + " " + typeEmbroidery + " (" + price + ")");
					lblInputTotal.setText(totalPrice.toString());
				}
				
			}
			
		}
		
	}
}
