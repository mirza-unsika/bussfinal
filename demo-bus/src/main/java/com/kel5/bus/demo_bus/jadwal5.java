package com.kel5.bus.demo_bus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class jadwal5 {
    private JFrame frmBusSystemBy;
    private ImageIcon imageIcon;

    public void showFrame() {
        frmBusSystemBy.setVisible(true);
    }

    public jadwal5() {
        initialize();
    }

    public JFrame getFrame() {
        return frmBusSystemBy;
    }

    protected void initialize() {
        frmBusSystemBy = new JFrame();
        frmBusSystemBy.setTitle("Bus System By Kelompok 5");
        frmBusSystemBy.setBounds(100, 100, 777, 463);
        frmBusSystemBy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String imagePath = "D:\\Download\\black-abstract-background-with-various-corner-layers-vector.jpg";
        imageIcon = new ImageIcon(imagePath);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setBackground(new Color(0, 0, 0));
        frmBusSystemBy.getContentPane().add(panel, BorderLayout.CENTER);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(122, 37, 525, 333);
        panel_1.setBackground(new Color(255, 255, 255, 2));

        JTextArea txtrHariSenin = new JTextArea();
        txtrHariSenin.setFont(new Font("Monospaced", Font.BOLD, 16));
        txtrHariSenin.setForeground(new Color(255, 255, 255));
        txtrHariSenin.setEditable(false);
        txtrHariSenin.setBackground(new Color(255, 255, 255, 2));
        txtrHariSenin.setBounds(180, 73, 189, 224);
        txtrHariSenin.setText("  Hari Senin\r\n- 09.00-10.30\r\n- 14.30-16.00\r\n  Hari Selasa\r\n- 10.00-11.30\r\n- 15.00-16.30\r\n  Hari Rabu\r\n- 10.30-12.00\r\n- 15.30-17.00\r\n\r\nBekasi-Jakarta\r\n- 20.00-21.00\r\nBekasi-Jakarta");
        panel.setLayout(null);
        panel_1.setLayout(null);
        panel_1.add(txtrHariSenin);
        panel.add(panel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Bus Transjakarta");
        lblNewLabel_1_1.setForeground(new Color(128, 128, 0));
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_1_1.setBounds(180, 0, 257, 50);
        panel_1.add(lblNewLabel_1_1);

        JLabel lblNewLabel = new JLabel("==========================================================\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(57, 50, 423, 13);
        panel_1.add(lblNewLabel);

        JLabel lblNewLabel_2 = new JLabel("==========================================================\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
        lblNewLabel_2.setForeground(Color.WHITE);
        lblNewLabel_2.setBounds(57, 284, 423, 13);
        panel_1.add(lblNewLabel_2);

        JLabel lblNewLabel_1 = new JLabel("Rute Bekasi-Tangerang");
        lblNewLabel_1.setBounds(272, 10, 257, 50);
        panel.add(lblNewLabel_1);
        lblNewLabel_1.setForeground(new Color(128, 128, 0));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frmBusSystemBy.setVisible(false);
                jadwal4 jadwal4 = new jadwal4();
                jadwal4.showFrame();;
            }
        });
        btnBack.setBounds(10, 375, 74, 41);
        panel.add(btnBack);
        
        JButton btnBack_1 = new JButton("Main Menu");
        btnBack_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		MainMenu mainMenu = new MainMenu();
                mainMenu.getFrame().setVisible(true);
                frmBusSystemBy.dispose();
        	}
        });
        btnBack_1.setBounds(655, 375, 98, 41);
        panel.add(btnBack_1);
    }

    
}
