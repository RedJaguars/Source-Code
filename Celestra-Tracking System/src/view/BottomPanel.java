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
public class BottomPanel {
    public JPanel bottomPanel;
    
    private JTextField txtLength;
    private JTextField txtBottom;
    private JTextField txtCrotch;
    private JTextField txtThigh;
    private JTextField txtWaist;
    private JTextField txtHips;
    private JTextField txtKnee;
    
    public BottomPanel() {
        bottomPanel = new JPanel();
        
        JLabel lblMeasurements = new JLabel("Measurements");
        lblMeasurements.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblMeasurements.setBounds(60, 20, 150, 20);
        
        JLabel lblLength = new JLabel("Length:");
        lblLength.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblLength.setBounds(60, 45, 125, 20);
        
        txtLength = new JTextField();
        txtLength.setBounds(150, 45, 35, 20);
        txtLength.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        JLabel lblBottom = new JLabel("Bottom:");
        lblBottom.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblBottom.setBounds(60, 70, 125, 20);
        
        txtBottom = new JTextField();
        txtBottom.setBounds(150, 70, 35, 20);
        txtBottom.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        JLabel lblCrotch = new JLabel("Crotch:");
        lblCrotch.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblCrotch.setBounds(60, 95, 125, 20);
        
        txtCrotch = new JTextField();
        txtCrotch.setBounds(150, 95, 35, 20);
        txtCrotch.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        JLabel lblThigh = new JLabel("Thigh:");
        lblThigh.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblThigh.setBounds(60, 120, 125, 20);
        
        txtThigh = new JTextField();
        txtThigh.setBounds(150, 120, 35, 20);
        txtThigh.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        JLabel lblWaist = new JLabel("Waist:");
        lblWaist.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblWaist.setBounds(240, 45, 125, 20);
        
        txtWaist= new JTextField();
        txtWaist.setBounds(330, 45, 35, 20);
        txtWaist.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        JLabel lblHips = new JLabel("Hips:");
        lblHips.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblHips.setBounds(240, 70, 125, 20);
        
        txtHips = new JTextField();
        txtHips.setBounds(330, 70, 35, 20);
        txtHips.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        JLabel lblKnee = new JLabel("Knee:");
        lblKnee.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblKnee.setBounds(240, 95, 125, 20);
        
        txtKnee = new JTextField();
        txtKnee.setBounds(330, 95, 35, 20);
        txtKnee.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        bottomPanel.add(lblMeasurements);
        bottomPanel.add(lblLength);
        bottomPanel.add(txtLength);
        bottomPanel.add(lblBottom);
        bottomPanel.add(txtBottom);
        bottomPanel.add(lblCrotch);
        bottomPanel.add(txtCrotch);
        bottomPanel.add(lblThigh);
        bottomPanel.add(txtThigh);
        bottomPanel.add(lblWaist);
        bottomPanel.add(txtWaist);
        bottomPanel.add(lblHips);
        bottomPanel.add(txtHips);
        bottomPanel.add(lblKnee);
        bottomPanel.add(txtKnee);
        
        bottomPanel.setVisible(true);
        bottomPanel.setLayout(null);
        bottomPanel.setBounds(0, 0, 600, 280);
    }
    
    public JPanel getPanel() {
        return bottomPanel;
    }
}
