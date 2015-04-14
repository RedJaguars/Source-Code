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
		
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 292, 721);
		getContentPane().add(panel);
		
		panel.setLayout(null);
		
		
		btnOrder = new JButton("Orders");
		btnOrder.setBounds(28, 209, 200, 50);
		btnOrder.addActionListener(new doActionListener());
		panel.add(btnOrder);
		
		btnItems = new JButton("Items");
		btnItems.setBounds(28, 280, 200, 50);
		btnItems.addActionListener(new doActionListener());
		panel.add(btnItems);
		
		btnSales = new JButton("Sales");
		btnSales.setBounds(28, 352, 200, 50);
		btnSales.addActionListener(new doActionListener());
		panel.add(btnSales);
		
		btnChangePassword = new JButton("Change Password");
		btnChangePassword.setBounds(28, 424, 200, 50);
		btnChangePassword.addActionListener(new doActionListener());
		panel.add(btnChangePassword);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new doActionListener());
		btnExit.setBounds(28, 612, 200, 50);
		panel.add(btnExit);
		
		panel_1 = new JPanel();
		panel_1.setBounds(293, 0, 969, 721);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		btnAddNewItem = new JButton("Add New Item");
		btnAddNewItem.addActionListener(new doActionListener());
		btnAddNewItem.setBounds(739, 40, 200, 50);
		panel_1.add(btnAddNewItem);
		
		JLabel lblNewLabel = new JLabel("List of Items");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(53, 57, 115, 16);
		panel_1.add(lblNewLabel);
		
		txtAreaItemDetails = new JTextArea();
		txtAreaItemDetails.setBounds(53, 500, 460, 183);
		panel_1.add(txtAreaItemDetails);
		txtAreaItemDetails.setColumns(10);
		txtAreaItemDetails.setEditable(false);
		
		JLabel lblOrderDetails = new JLabel("Item Details");
		lblOrderDetails.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblOrderDetails.setBounds(53, 458, 115, 16);
		panel_1.add(lblOrderDetails);
		
		btnReduceQuantity = new JButton("Decrease");
		btnReduceQuantity.addActionListener(new doActionListener());
			
		btnReduceQuantity.setBounds(851, 546, 110, 34);
		panel_1.add(btnReduceQuantity);
		
		panel_2 = new JPanel();
		panel_2.setBounds(57, 126, 847, 302);
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
		btnIncreaseStock.setBounds(851, 619, 110, 34);
		panel_1.add(btnIncreaseStock);
		
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
		
		JButton btnModifyItem = new JButton("Modify Item");
		btnModifyItem.setBounds(284, 457, 200, 34);
		panel_1.add(btnModifyItem);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		Insets scnMax = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
		int taskBarSize = scnMax.bottom;
		
		this.setSize(screenWidth, screenHeight - taskBarSize);
		this.setResizable(false);
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
					System.out.println("ROWS: " + selectedRows[i]);
				}
				try {
					inventoryController.decreaseStock(selectedRows, (double)decreaseSpinner.getValue());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				//((AbstractTableModel)tableInventory.getModel()).fireTableDataChanged();
				try {
					tableInventory = createTable(inventoryController.retrieveInventoryList());
					tableInventory.setModel(createTable(inventoryController.retrieveInventoryList()).getModel());
					tableInventory.setColumnModel(createTable(inventoryController.retrieveInventoryList()).getColumnModel());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				panel_2.revalidate();
				panel_2.repaint();
				tableInventory.repaint();
				tableInventory.revalidate();
				
				
				//				new ItemFrame();
//				dispose();
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
