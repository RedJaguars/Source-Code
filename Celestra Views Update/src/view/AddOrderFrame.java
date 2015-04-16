package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import view.OrderFrame.doActionListener;

public class AddOrderFrame extends JFrame{
	private JButton btnBack, btnAdd, btnCheckOut, btnOpenFile;
	private JLabel lblClientName, lblGender, lblContact, lblEmail, lblDate, lblQuantity, lblGarment, lblMaterials, lblSpecialInstructions;
	private JTextField txtClientName, txtGender, txtContact, txtEmail, txtDate, txtQuantity, txtFilePath, txtLength, txtShoulder,txtChest, txtArmlength;
	private JTextField txtArmhole, txtBackfigure, txtNeckdeep, txtWristcircum, txtWaist, txtHips, txtFrontfigure, txtBustpoint, txtBustdistance;
	private JTextField txtBottom, txtCrotch, txtThigh, txtKnee, txtMaterials, txtSpecialInstructions;
	private ButtonGroup bgType;
	private JRadioButton rbAlteration, rbMadeToOrder, rbEmbroidery;
	private JComboBox cbGarment;
	private JPanel panel_1, alterationPanel, madetoorderPanel, embroideryPanel, mtotopPanel, mtobottomPanel;
	private JList addOrderList;
	
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
		
		addOrderList = new JList();
		addOrderList.setBackground(Color.decode("#C8CF9B"));
		addOrderList.setFont(new Font("Tahoma",Font.PLAIN, 13));
		addOrderList.setBounds(780, 20, 330, 670);
		panel_1.add(addOrderList);
		
		
		JPanel topPanel = new JPanel();
		topPanel.setBounds(0,0,800,220);
		topPanel.setBackground(Color.decode("#E5EDB8"));
		topPanel.setLayout(null);
		panel_1.add(topPanel);
		
		JLabel lblHeader = new JLabel("Add Order");
		lblHeader.setBounds(40,10,150,40);
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 18));
		topPanel.add(lblHeader);
		
		lblClientName = new JLabel("Client's Name:");
		lblClientName.setBounds(40,50,100,40);
		lblClientName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtClientName = new JTextField("");
		txtClientName.setBounds(150,60,400,20);
		txtClientName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		topPanel.add(lblClientName);
		topPanel.add(txtClientName);
		
		lblGender = new JLabel("Gender:");
		lblGender.setBounds(40,80,100,40);
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtGender = new JTextField("");
		txtGender.setBounds(150,90,50,20);
		txtGender.setFont(new Font("Tahoma", Font.PLAIN, 12));
		topPanel.add(lblGender);
		topPanel.add(txtGender);
		
		lblContact = new JLabel("Contact Number:");
		lblContact.setBounds(40,110,100,40);
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtContact = new JTextField("");
		txtContact.setBounds(150,120,120,20);
		txtContact.setFont(new Font("Tahoma", Font.PLAIN, 12));
		topPanel.add(lblContact);
		topPanel.add(txtContact);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(40,140,100,40);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEmail = new JTextField("");
		txtEmail.setBounds(150,150,180,20);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		topPanel.add(lblEmail);
		topPanel.add(txtEmail);
		
		lblDate = new JLabel("Due Date:");
		lblDate.setBounds(40,650,100,40);
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDate = new JTextField("");
		txtDate.setBounds(130,662,170,20);
		txtDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(lblDate);
		panel_1.add(txtDate);
		
		lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(350,650,100,40);
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtQuantity = new JTextField("");
		txtQuantity.setBounds(435,662,170,20);
		txtQuantity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(lblQuantity);
		panel_1.add(txtQuantity);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(650,650,100,40);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAdd.setBackground(Color.decode("#A8A76D"));
		btnAdd.setFocusPainted(false);
		btnAdd.setBorderPainted(false);
		panel_1.add(btnAdd);
		
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
		ButtonGroup bgEmbroidery;
		
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
		
		JTextArea lblPreview = new JTextArea(""); //make this label
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
		
		txtMaterials = new JTextField();
		txtSpecialInstructions = new JTextField();
		txtMaterials.setBounds(40,40, 320, 350);
		txtSpecialInstructions.setBounds(430, 40, 320, 350);
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
		cbGarment.setBackground(Color.decode("#E5EDB8"));;
		
		madetoorderPanel.add(lblGarment);
		madetoorderPanel.add(cbGarment);
	}
	
	private void MTOtopPanel(){
		mtotopPanel = new JPanel();
		mtotopPanel.setBackground(Color.decode("#E5EDB8"));
		mtotopPanel.setBounds(0,230,800,400);
		mtotopPanel.setLayout(null);
		panel_1.add(mtotopPanel);
		
		JLabel lblHeader = new JLabel("Measurements:");
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
		
		lblHeader.setBounds(45,20,100,30);
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
		txtMaterials = new JTextField();
		txtMaterials.setBounds(100, 285, 200, 100);
		
		lblSpecialInstructions = new JLabel("Special Instructions:");
		lblSpecialInstructions.setBounds(450,260,150,30);
		lblSpecialInstructions.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSpecialInstructions = new JTextField();
		txtSpecialInstructions.setBounds(450, 285, 200, 100);
		
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
		
		JLabel lblHeader = new JLabel("Measurements:");
		JLabel lblLength = new JLabel("Length:");
		JLabel lblBottom = new JLabel("Bottom:");
		JLabel lblCrotch = new JLabel("Crotch:");
		JLabel lblThigh = new JLabel("Thigh:");
		JLabel lblWaist = new JLabel("Waist:");
		JLabel lblHips = new JLabel("Hips:");
		JLabel lblKnee = new JLabel("Knee:");
		
		lblHeader.setBounds(45,20,100,30);
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
		txtMaterials = new JTextField();
		txtMaterials.setBounds(100, 285, 200, 100);
		
		lblSpecialInstructions = new JLabel("Special Instructions:");
		lblSpecialInstructions.setBounds(450,260,150,30);
		lblSpecialInstructions.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSpecialInstructions = new JTextField();
		txtSpecialInstructions.setBounds(450, 285, 200, 100);
		
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
				dispose();
			} else if(action.getSource() instanceof JRadioButton){
				JRadioButton rb = (JRadioButton) action.getSource();
				if(rb.isSelected()){
					if(rb.getText().equalsIgnoreCase("Alteration")){
						alterationPanel.setVisible(true);
						embroideryPanel.setVisible(false);
						madetoorderPanel.setVisible(false);
						mtotopPanel.setVisible(false);
						mtobottomPanel.setVisible(false);
					}else if(rb.getText().equalsIgnoreCase("Made To Order")){
						alterationPanel.setVisible(false);
						embroideryPanel.setVisible(false);
						madetoorderPanel.setVisible(true);
						cbGarment.setSelectedIndex(0);
						mtotopPanel.setVisible(false);
						mtobottomPanel.setVisible(false);
					}else if(rb.getText().equalsIgnoreCase("Embroidery")){
						embroideryPanel.setVisible(true);
						alterationPanel.setVisible(false);
						madetoorderPanel.setVisible(false);
						mtotopPanel.setVisible(false);
						mtobottomPanel.setVisible(false);
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
				    //System.out.println("Selected file: " + selectedFile.getAbsolutePath());
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
						alterationPanel.setVisible(false);
						embroideryPanel.setVisible(false);
						madetoorderPanel.setVisible(true);
						mtotopPanel.setVisible(true);
						mtobottomPanel.setVisible(false);
				}else if(cb.getSelectedItem().toString().equalsIgnoreCase("Bottom")){
						embroideryPanel.setVisible(false);
						alterationPanel.setVisible(false);
						madetoorderPanel.setVisible(true);
						mtotopPanel.setVisible(false);
						mtobottomPanel.setVisible(true);
				}
				
			}
		}
	}
}
