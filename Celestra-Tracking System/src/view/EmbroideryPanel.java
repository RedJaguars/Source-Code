/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

/**
 *
 * @author Camille
 */
public class EmbroideryPanel implements ActionListener {
    private JTextField txtDesign;
    
    private JButton btnAddFile;
    
    private JPanel embroideryPanel;
    
    public EmbroideryPanel() {
        embroideryPanel = new JPanel();
        
        JRadioButton logo = new JRadioButton("Logo");
        logo.setMnemonic(KeyEvent.VK_L);
        logo.setBounds(170, 60, 150, 20);
        
        JRadioButton patch = new JRadioButton ("Patch");
        patch.setMnemonic(KeyEvent.VK_P);
        patch.setBounds(340, 60, 150, 20);
        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(logo);
        genderGroup.add(patch);
        
        JLabel lblDesign = new JLabel("Design:");
        lblDesign.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblDesign.setBounds(60, 80, 119, 20);
        
        txtDesign = new JTextField();
        txtDesign.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtDesign.setBounds(170, 80, 380, 20);
        
        btnAddFile = new JButton("Add File");
        btnAddFile.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnAddFile.setBounds(450, 100, 100, 20);
        
        btnAddFile.addActionListener(this);
        
        embroideryPanel.add(logo);
        embroideryPanel.add(patch);
        embroideryPanel.add(lblDesign);
        embroideryPanel.add(txtDesign);
        embroideryPanel.add(btnAddFile);
        
        embroideryPanel.setBounds(0, 0, 600, 300);
        embroideryPanel.setVisible(true);
        embroideryPanel.setLayout(null);
    }
    
    public void actionPerformed(ActionEvent arg0) {
        if(arg0.getSource() == this.btnAddFile){
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                txtDesign.setText(selectedFile.getName());
            }
        } 
    }
    
    public JPanel getPanel() {
        return embroideryPanel;
    }
}
