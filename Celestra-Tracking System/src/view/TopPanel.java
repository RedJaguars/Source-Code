/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Camille
 */
public class TopPanel {
    private JPanel topPanel;
    
    private JTextField txtLength;
    private JTextField txtShoulder;
    private JTextField txtChest;
    private JTextField txtArm;
    private JTextField txtArmhole;
    private JTextField txtNeck;
    private JTextField txtWrist;
    private JTextField txtWaist;
    private JTextField txtHips;
    
    private JTextArea txtMaterials;
    private JTextArea txtSpecialInstructions;
    
    public TopPanel() {
        topPanel = new JPanel();
        
        JLabel lblMeasurements = new JLabel("Measurements");
        lblMeasurements.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblMeasurements.setBounds(60, 20, 150, 20);
        
        JLabel lblLength = new JLabel("Length:");
        lblLength.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblLength.setBounds(60, 45, 125, 20);
        
        txtLength = new JTextField();
        txtLength.setBounds(150, 45, 35, 20);
        txtLength.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        JLabel lblShoulder = new JLabel("Shoulder:");
        lblShoulder.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblShoulder.setBounds(60, 70, 125, 20);
        
        txtShoulder = new JTextField();
        txtShoulder.setBounds(150, 70, 35, 20);
        txtShoulder.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        JLabel lblChest = new JLabel("Chest/Bust:");
        lblChest.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblChest.setBounds(60, 95, 125, 20);
        
        txtChest = new JTextField();
        txtChest.setBounds(150, 95, 35, 20);
        txtChest.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        JLabel lblArm = new JLabel("Arm Length:");
        lblArm.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblArm.setBounds(60, 120, 125, 20);
        
        txtArm = new JTextField();
        txtArm.setBounds(150, 120, 35, 20);
        txtArm.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        JLabel lblArmhole = new JLabel("Armhole:");
        lblArmhole.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblArmhole.setBounds(60, 145, 125, 20);
        
        txtArmhole = new JTextField();
        txtArmhole.setBounds(150, 145, 35, 20);
        txtArmhole.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        JLabel lblNeck = new JLabel("Neck Deep:");
        lblNeck.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNeck.setBounds(240, 45, 125, 20);
        
        txtNeck = new JTextField();
        txtNeck.setBounds(330, 45, 35, 20);
        txtNeck.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        JLabel lblWrist = new JLabel("Wrist:");
        lblWrist.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblWrist.setBounds(240, 70, 125, 20);
        
        txtWrist = new JTextField();
        txtWrist.setBounds(330, 70, 35, 20);
        txtWrist.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        JLabel lblWaist = new JLabel("Waist:");
        lblWaist.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblWaist.setBounds(240, 95, 125, 20);
        
        txtWaist = new JTextField();
        txtWaist.setBounds(330, 95, 35, 20);
        txtWaist.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        JLabel lblHips = new JLabel("Hips:");
        lblHips.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblHips.setBounds(240, 120, 125, 20);
        
        txtHips = new JTextField();
        txtHips.setBounds(330, 120, 35, 20);
        txtHips.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        JLabel lblMaterials = new JLabel("Materials:");
        lblMaterials.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblMaterials.setBounds(60, 170, 150, 20);
        
        txtMaterials = new JTextArea();
        txtMaterials.setBounds(60, 190, 200, 70);
        txtMaterials.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        JLabel lblSpecialInstructions = new JLabel("Special Instructions:");
        lblSpecialInstructions.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblSpecialInstructions.setBounds(300, 170, 150, 20);
        
        txtSpecialInstructions = new JTextArea();
        txtSpecialInstructions.setBounds(300, 190, 200, 70);
        txtSpecialInstructions.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        topPanel.add(lblMeasurements);
        topPanel.add(lblLength);
        topPanel.add(txtLength);
        topPanel.add(lblShoulder);
        topPanel.add(txtShoulder);
        topPanel.add(lblChest);
        topPanel.add(txtChest);
        topPanel.add(lblArm);
        topPanel.add(txtArm);
        topPanel.add(lblArmhole);
        topPanel.add(txtArmhole);
        topPanel.add(lblNeck);
        topPanel.add(txtNeck);
        topPanel.add(lblWrist);
        topPanel.add(txtWrist);
        topPanel.add(lblWaist);
        topPanel.add(txtWaist);
        topPanel.add(lblHips);
        topPanel.add(txtHips);
        topPanel.add(lblMaterials);
        topPanel.add(txtMaterials);
        topPanel.add(lblSpecialInstructions);
        topPanel.add(txtSpecialInstructions);
        
        topPanel.setVisible(true);
        topPanel.setLayout(null);
        topPanel.setBounds(0, 0, 600, 280);
    }
    
    public JPanel getPanel() {
        return topPanel;
    }
}
