package view;

import java.awt.Font;
import javax.swing.*;

public class FullBodyPanel {
    private JTextField txtLength;
    private JTextField txtShoulder;
    private JTextField txtChest;
    private JTextField txtArm;
    private JTextField txtArmhole;
    private JTextField txtBackFigure;
    private JTextField txtNeck;
    private JTextField txtWrist;
    private JTextField txtWaist;
    private JTextField txtHips;
    private JTextField txtFrontFigure;
    private JTextField txtBustPoint;
    private JTextField txtBustDistance;
    private JTextArea txtMaterials;
    private JTextArea txtSpecialInstructions;
    
    private JPanel fullBodyPanel;
    
    public FullBodyPanel () {
        fullBodyPanel = new JPanel();
        
        txtLength = new JTextField();
        txtShoulder = new JTextField();
        txtChest = new JTextField();
        txtArm = new JTextField();
        txtArmhole = new JTextField();
        txtBackFigure = new JTextField();
        txtNeck = new JTextField();
        txtWrist = new JTextField();
        txtWaist = new JTextField();
        txtHips = new JTextField();
        txtFrontFigure = new JTextField();
        txtBustPoint = new JTextField();
        txtBustDistance = new JTextField();
        txtMaterials = new JTextArea();
        txtSpecialInstructions = new JTextArea();
        
        JLabel lblMeasurements = new JLabel("Measurements");
        lblMeasurements.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblMeasurements.setBounds(60, 20, 150, 20);
        
        JLabel lblLength = new JLabel("Length:");
        lblLength.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblLength.setBounds(60, 45, 125, 20);
        
        txtLength.setBounds(150, 45, 35, 20);
        txtLength.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        JLabel lblShoulder = new JLabel("Shoulder:");
        lblShoulder.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblShoulder.setBounds(60, 70, 125, 20);
        
        txtShoulder.setBounds(150, 70, 35, 20);
        
        JLabel lblChest = new JLabel("Chest/Bust:");
        lblChest.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblChest.setBounds(60, 95, 125, 20);
        
        txtChest.setBounds(150, 95, 35, 20);
        txtChest.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        JLabel lblArm = new JLabel("Arm Length:");
        lblArm.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblArm.setBounds(60, 120, 125, 20);
        
        txtArm.setBounds(150, 120, 35, 20);
        txtArm.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        JLabel lblArmhole = new JLabel("Armhole:");
        lblArmhole.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblArmhole.setBounds(60, 145, 125, 20);
        
        txtArmhole.setBounds(150, 145, 35, 20);
        txtArmhole.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        JLabel lblBackFigure = new JLabel("Back Figure:");
        lblBackFigure.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblBackFigure.setBounds(60, 170, 125, 20);
        
        txtBackFigure.setBounds(150, 170, 35, 20);
        txtBackFigure.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        JLabel lblNeck = new JLabel("Neck Deep:");
        lblNeck.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNeck.setBounds(240, 45, 125, 20);
        
        txtNeck.setBounds(330, 45, 35, 20);
        txtNeck.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        JLabel lblWrist = new JLabel("Wrist:");
        lblWrist.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblWrist.setBounds(240, 70, 125, 20);
        
        txtWrist.setBounds(330, 70, 35, 20);
        txtWrist.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        JLabel lblWaist = new JLabel("Waist:");
        lblWaist.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblWaist.setBounds(240, 95, 125, 20);
        
        txtWaist.setBounds(330, 95, 35, 20);
        txtWaist.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        JLabel lblHips = new JLabel("Hips:");
        lblHips.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblHips.setBounds(240, 120, 125, 20);
        
        txtHips.setBounds(330, 120, 35, 20);
        txtHips.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        JLabel lblFrontFigure = new JLabel("Front Figure:");
        lblFrontFigure.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblFrontFigure.setBounds(240, 145, 125, 20);
        
        txtFrontFigure.setBounds(330, 145, 35, 20);
        txtFrontFigure.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        JLabel lblBustPoint = new JLabel("Bust Point:");
        lblBustPoint.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblBustPoint.setBounds(240, 170, 125, 20);
        
        txtBustPoint.setBounds(330, 170, 35, 20);
        txtBustPoint.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        JLabel lblBustDistance = new JLabel("Bust Distance:");
        lblBustDistance.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblBustDistance.setBounds(420, 45, 125, 20);
        
        txtBustDistance.setBounds(520, 45, 35, 20);
        txtBustDistance.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        JLabel lblMaterials = new JLabel("Materials:");
        lblMaterials.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblMaterials.setBounds(60, 200, 150, 20);
        
        txtMaterials.setBounds(60, 225, 200, 50);
        txtMaterials.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        JLabel lblSpecialInstructions = new JLabel("Special Instructions:");
        lblSpecialInstructions.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblSpecialInstructions.setBounds(300, 200, 150, 20);
        
        txtSpecialInstructions.setBounds(300, 225, 200, 50);
        txtSpecialInstructions.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        fullBodyPanel.add(lblMeasurements);
        fullBodyPanel.add(lblLength);
        fullBodyPanel.add(txtLength);
        fullBodyPanel.add(lblShoulder);
        fullBodyPanel.add(txtShoulder);
        fullBodyPanel.add(lblChest);
        fullBodyPanel.add(txtChest);
        fullBodyPanel.add(lblArm);
        fullBodyPanel.add(txtArm);
        fullBodyPanel.add(lblArmhole);
        fullBodyPanel.add(txtArmhole);
        fullBodyPanel.add(lblBackFigure);
        fullBodyPanel.add(txtBackFigure);
        fullBodyPanel.add(lblNeck);
        fullBodyPanel.add(txtNeck);
        fullBodyPanel.add(lblWrist);
        fullBodyPanel.add(txtWrist);
        fullBodyPanel.add(lblWaist);
        fullBodyPanel.add(txtWaist);
        fullBodyPanel.add(lblHips);
        fullBodyPanel.add(txtHips);
        fullBodyPanel.add(lblFrontFigure);
        fullBodyPanel.add(txtFrontFigure);
        fullBodyPanel.add(lblBustPoint);
        fullBodyPanel.add(txtBustPoint);
        fullBodyPanel.add(lblBustDistance);
        fullBodyPanel.add(txtBustDistance);
        fullBodyPanel.add(lblMaterials);
        fullBodyPanel.add(txtMaterials);
        fullBodyPanel.add(lblSpecialInstructions);
        fullBodyPanel.add(txtSpecialInstructions);
        
        fullBodyPanel.setVisible(true);
        fullBodyPanel.setLayout(null);
        fullBodyPanel.setBounds(0, 0, 600, 280);
    }
    
    public JPanel getPanel() {
        return fullBodyPanel;
    }
}
