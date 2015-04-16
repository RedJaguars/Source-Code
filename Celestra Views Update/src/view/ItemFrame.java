package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import controller.InventoryController;
import objects.Material;
import view.OrderFrame.doActionListener;

public class ItemFrame extends JFrame{
	private JTextArea txtAreaItemDetails;
	private JTextField textField_1;
	private JTextField textField_3;
	
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	
	
	private JSpinner increaseSpinner;
	private JSpinner decreaseSpinner;
	
	private JButton btnReduceQuantity;
	private JButton btnOrder;
	private JButton btnItems;
	private JButton btnSales;
	private JButton btnChangePassword;
	private JButton btnAddNewItem;
	private JButton btnExit;
	
	private SpinnerNumberModel numberSpinnerBounds;
	
	private JTable tableInventory;
	private JScrollPane inventoryPane;
	
	private InventoryController inventoryController;
	private TableModel model;
	
	public ItemFrame() {
		inventoryController = new InventoryController();
		
		numberSpinnerBounds = new SpinnerNumberModel(1, 1, Double.MAX_VALUE, 1 );
		
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.decode("#D3D27C"));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#677B42"));
		panel.setBounds(0, 0, 292, 721);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		UIManager.put("Button.select", Color.decode("#C1BF7D"));
		
		btnOrder = new JButton("Orders");
		btnOrder.setBounds(28, 209, 200, 50);
		btnOrder.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnOrder.setBackground(Color.decode("#A8A76D"));
		btnOrder.setFocusPainted(false);
		btnOrder.setBorderPainted(false);
		btnOrder.addActionListener(new doActionListener());
		panel.add(btnOrder);
		
		btnItems = new JButton("Items");
		btnItems.setBounds(28, 280, 200, 50);
		btnItems.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnItems.setBackground(Color.decode("#F4F2AB"));
		btnItems.setFocusPainted(false);
		btnItems.setBorderPainted(false);
		btnItems.addActionListener(new doActionListener());
		panel.add(btnItems);
		
		btnSales = new JButton("Sales");
		btnSales.setBounds(28, 352, 200, 50);
		btnSales.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSales.setBackground(Color.decode("#A8A76D"));
		btnSales.setFocusPainted(false);
		btnSales.setBorderPainted(false);
		btnSales.addActionListener(new doActionListener());
		panel.add(btnSales);
		
		btnChangePassword = new JButton("Change Password");
		btnChangePassword.setBounds(28, 424, 200, 50);
		btnChangePassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnChangePassword.setBackground(Color.decode("#A8A76D"));
		btnChangePassword.setFocusPainted(false);
		btnChangePassword.setBorderPainted(false);
		btnChangePassword.addActionListener(new doActionListener());
		panel.add(btnChangePassword);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new doActionListener());
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnExit.setBounds(28, 612, 200, 50);
		btnExit.setBackground(Color.decode("#A8A76D"));
		btnExit.setFocusPainted(false);
		btnExit.setBorderPainted(false);
		panel.add(btnExit);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(292, 0, 1070, 721);
		panel_1.setBackground(Color.decode("#E5EDB8"));
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		ImageIcon icon;
		
		btnAddNewItem = new JButton("Add");
		btnAddNewItem.addActionListener(new doActionListener());
		btnAddNewItem.setBackground(Color.decode("#A8A76D"));
		icon = new ImageIcon("src/images/add.png");
		btnAddNewItem.setIcon(icon);
		btnAddNewItem.setVerticalTextPosition(SwingConstants.BOTTOM); 
		btnAddNewItem.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAddNewItem.setFont(new Font("Tahoma", Font.PLAIN, 11));
		//btnAddNewItem.setFocusPainted(false);
		btnAddNewItem.setBorderPainted(false);
		btnAddNewItem.setContentAreaFilled(false);
		btnAddNewItem.setBounds(900, 7, 75, 68);
		panel_1.add(btnAddNewItem);
		
		JButton btnModifyItem = new JButton("Modify");
		icon = new ImageIcon("src/images/modify.png");
		btnModifyItem.setIcon(icon);
		btnModifyItem.setVerticalTextPosition(SwingConstants.BOTTOM); 
		btnModifyItem.setHorizontalTextPosition(SwingConstants.CENTER);
		btnModifyItem.setFont(new Font("Tahoma", Font.PLAIN, 11));
		//btnModifyItem.setFocusPainted(false);
		btnModifyItem.setBorderPainted(false);
		btnModifyItem.setContentAreaFilled(false);
		btnModifyItem.setBounds(970, 7, 80, 68);
		//btnModifyItem.setEnabled(false);
		panel_1.add(btnModifyItem);
		
		JLabel lblNewLabel = new JLabel("List of Items");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(40, 33, 155, 21);
		panel_1.add(lblNewLabel);
		
		txtAreaItemDetails = new JTextArea();
		txtAreaItemDetails.setBounds(37, 500, 500, 183);
		panel_1.add(txtAreaItemDetails);
		txtAreaItemDetails.setColumns(10);
		txtAreaItemDetails.setEditable(false);
		
		JLabel lblOrderDetails = new JLabel("Item Details:");
		lblOrderDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblOrderDetails.setBounds(40, 472, 140, 16);
		panel_1.add(lblOrderDetails);
		
		panel_2 = new JPanel();
		panel_2.setBounds(37, 75, 1000, 380);
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		tableInventory = new JTable();
		tableInventory.setBounds(57, 126, 847, 302);
		if(inventoryPane != null) {
            panel_2.remove(inventoryPane);
        }
        try {
			tableInventory = createTable(inventoryController.retrieveInventoryList());
		} catch (SQLException e) {
			e.printStackTrace();
		}
        tableInventory.setBounds(15, 50, 555, 240);
        inventoryPane = new JScrollPane(tableInventory);
        panel_2.add(inventoryPane);
		
		JButton btnIncreaseStock = new JButton("Increase");
		btnIncreaseStock.setBounds(851, 546, 110, 34);
		btnIncreaseStock.setBackground(Color.decode("#A8A76D"));
		btnIncreaseStock.setFocusPainted(false);
		btnIncreaseStock.setBorderPainted(false);
		panel_1.add(btnIncreaseStock);
		
		btnReduceQuantity = new JButton("Decrease");
		btnReduceQuantity.setBackground(Color.decode("#A8A76D"));
		btnReduceQuantity.setFocusPainted(false);
		btnReduceQuantity.setBorderPainted(false);
		btnReduceQuantity.addActionListener(new doActionListener());	
		btnReduceQuantity.setBounds(851, 619, 110, 34);
		panel_1.add(btnReduceQuantity);
		
		//textField_1 = new JTextField();
		increaseSpinner = new JSpinner(numberSpinnerBounds);
		increaseSpinner.setBounds(721, 552, 106, 22);
		panel_1.add(increaseSpinner);
		//textField_1.setColumns(10);
		
		decreaseSpinner = new JSpinner(numberSpinnerBounds);
		//textField_3.setColumns(10);
	
		decreaseSpinner.setBounds(721, 625, 106, 22);
		panel_1.add(decreaseSpinner);
		
		
		JLabel lblAddQuantity = new JLabel("Add Quantity");
		lblAddQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAddQuantity.setBounds(566, 555, 115, 16);
		panel_1.add(lblAddQuantity);
		
		JLabel lblReduceQuantity = new JLabel("Reduce Quantity");
		lblReduceQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblReduceQuantity.setBounds(566, 628, 115, 16);
		panel_1.add(lblReduceQuantity);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		Insets scnMax = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
		int taskBarSize = scnMax.bottom;
		
		this.setSize(screenWidth, screenHeight - taskBarSize);
		this.setResizable(false);
		this.setTitle("Celestra Tailoring and Embroidery");
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public class doActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnOrder) {
				new OrderFrame();
				dispose();
			} else if(e.getSource() == btnItems) {
				//nothing happens. stays on this frame.
			} else if(e.getSource() == btnSales) {
				new SalesFrame();
				dispose();
			} else if(e.getSource() == btnChangePassword) {
				new ChangePassword();
			} else if(e.getSource() == btnAddNewItem) {
				new AddItemFrame();
			
			} else if(e.getSource() == btnExit) {
				new Login();
				dispose();
			}else if(e.getSource() == btnReduceQuantity){
				int[] selectedRows = tableInventory.getSelectedRows();
				for(int i=0;i<selectedRows.length;i++){
					selectedRows[i] = selectedRows[i]+1;
//					System.out.println("ROWS: " + selectedRows[i]);
				}
				try {
					inventoryController.decreaseStock(selectedRows, (double)decreaseSpinner.getValue());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				try {
					
					panel_2.remove(tableInventory);
					tableInventory = createTable(inventoryController.retrieveInventoryList());
					panel_2.add(tableInventory);
					tableInventory.setModel(createTable(inventoryController.retrieveInventoryList()).getModel());
					tableInventory.setColumnModel(createTable(inventoryController.retrieveInventoryList()).getColumnModel());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				panel_2.revalidate();
				panel_2.repaint();
				tableInventory.repaint();
				tableInventory.revalidate();
				System.out.println("DECREASE HIT");
				
			}
			
		}
	}
	
	public JTable createTable(Iterator<?> inventoryItemList) {
		List<Material> list = new ArrayList<Material>();
		int size = 0;
		while(inventoryItemList.hasNext()) {
			list.add((Material) inventoryItemList.next());
			size++;
		}
		
        JTable inventoryListTable = new UneditableJTable(size, 4);
        inventoryListTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 1) {
                    JTable target = (JTable)e.getSource();
                    int row = target.getSelectedRow();
                    try {
						txtAreaItemDetails.setText(inventoryController.getData(row));
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
                }
            }
        });
        TableColumnModel columnModel = inventoryListTable.getColumnModel();
        model = inventoryListTable.getModel();
        
        String header[] = {"Inventory Name", "Quantity In Stock", "Description", "Unit"};
        
        for(int i = 0; i < inventoryListTable.getColumnCount(); i++) {  
            TableColumn column1 = inventoryListTable.getTableHeader().getColumnModel().getColumn(i);  
            column1.setHeaderValue(header[i]);
            columnModel.getColumn(i).setWidth(111);
        }   
        
        Material inventoryItem = new Material();
        for(int i = 0; i < list.size(); i++) {
            inventoryItem = list.get(i);
            
            model.setValueAt(inventoryItem.getInventoryName(), i, 0);
            model.setValueAt(inventoryItem.getQuantityInStock(), i, 1);
            model.setValueAt(inventoryItem.getDescription(), i, 2);
            model.setValueAt(inventoryItem.getUnit(), i, 3);
        }
        return inventoryListTable;
    }
}
