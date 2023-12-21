package com.kel5.bus.demo_bus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainMenu {
    JFrame frmBusSystemBy;
    private ImageIcon imageIcon;
    private JTextField textField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainMenu window = new MainMenu();
                    window.frmBusSystemBy.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MainMenu() {
        initialize();
    }

    public JFrame getFrame() {
        return frmBusSystemBy;
    }

    private void initialize() {
        frmBusSystemBy = new JFrame();
        frmBusSystemBy.setTitle("Bus System By Kelompok 5");
        frmBusSystemBy.setBounds(100, 100, 759, 468);
        frmBusSystemBy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String imagePath = "C:\\Users\\ASUS\\Downloads\\maxresdefault.jpg";
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
        panel_1.setBounds(0, 338, 788, 93);
        panel_1.setBackground(new Color(255, 255, 255, 50));
        panel.setLayout(null);
        panel.add(panel_1);

        JButton btnRuteDanJadwal = new JButton("Rute dan jadwal");
        btnRuteDanJadwal.setBounds(192, 21, 139, 51);
        btnRuteDanJadwal.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnRuteDanJadwal.setBackground(new Color(255, 255, 255, 255));
        btnRuteDanJadwal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openJadwalFrame();
                frmBusSystemBy.dispose();
            }
        });

        Dimension btnRuteDanJadwalSize = btnRuteDanJadwal.getPreferredSize();
        panel_1.setLayout(null);
        panel_1.add(btnRuteDanJadwal);

        JButton BeliTiket = new JButton("Beli Tiket");
        BeliTiket.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openBeliFrame();
                frmBusSystemBy.dispose();
            }
        });
        BeliTiket.setBackground(new Color(255, 255, 255, 255));
        BeliTiket.setBounds(379, 21, 139, 51);
        panel_1.add(BeliTiket);
        BeliTiket.setFont(new Font("Tahoma", Font.BOLD, 13));

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblNewLabel.setBounds(638, 70, 80, 13);
        panel_1.add(lblNewLabel);

        JPanel panel_2_1 = new JPanel();
        panel_2_1.setLayout(null);
        panel_2_1.setBackground(new Color(255, 255, 255, 50));
        panel_2_1.setBounds(0, 0, 745, 78);
        panel.add(panel_2_1);

        JLabel lblNewLabel_1 = new JLabel("Busman");
        lblNewLabel_1.setBounds(306, -11, 200, 56);
        panel_2_1.add(lblNewLabel_1);
        lblNewLabel_1.setForeground(new Color(192, 192, 192));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 27));

        JLabel lblNewLabel_1_1 = new JLabel("Professionalism and Quality of Service");
        lblNewLabel_1_1.setBounds(186, 10, 559, 81);
        panel_2_1.add(lblNewLabel_1_1);
        lblNewLabel_1_1.setForeground(new Color(192, 192, 192));
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 19));

        JButton btnNewButton = new JButton("Search");
        btnNewButton.setBackground(new Color(255, 255, 255, 255));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 9));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchButtonClicked();
            }
        });
        btnNewButton.setBounds(538, 191, 65, 21);
        panel.add(btnNewButton);

        textField = new JTextField();
        textField.setBounds(275, 192, 253, 19);
        panel.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Masukkan kode booking:");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setBounds(106, 186, 171, 29);
        panel.add(lblNewLabel_2);
    }

    private void openJadwalFrame() {
        Jadwal jadwalFrame = new Jadwal();
        jadwalFrame.showFrame();
    }

    private void openBeliFrame() {
        Beli beliFrame = new Beli();
        beliFrame.showFrame();
    }

    private void searchButtonClicked() {
        String bookingIdValue = textField.getText();  // Mendapatkan nilai booking_id dari textField

        try {
            int bookingId = Integer.parseInt(bookingIdValue);

            // Membuat koneksi ke database (gantilah parameter koneksi dengan yang sesuai)
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/busman", "root", "");

            // Menyiapkan pernyataan SQL untuk mengambil data berdasarkan booking_id
            String sql = "SELECT * FROM data_booking WHERE id_booking = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, bookingId);

                // Menjalankan query
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        // Menampilkan data yang ditemukan
                        displaySuccessMessage("Data ditemukan!\n" +
                        		 "Booking ID: " + resultSet.getInt("id_booking") +
                                 "\nNama: " + resultSet.getString("nama") +
                                 "\nNik: " + resultSet.getString("nik") +
                                 "\nPilih Bus: " + resultSet.getString("pilih_bus") +
                                 "\nJurusan: " + resultSet.getString("jurusan") +
                                 "\nHari: " + resultSet.getString("hari") +
                                 "\nJam: " + resultSet.getString("jam") +
                                 "\nTanggal: " + resultSet.getString("tanggal"));
                    } else {
                        displayError("Data tidak ditemukan!");
                    }
                }
            }

            // Menutup koneksi ke database
            connection.close();
        } catch (NumberFormatException e) {
            displayError("Masukkan kode booking yang valid!");
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }



    private void displaySuccessMessage(String message) {
        JButton printButton = new JButton("Cetak Tiket");

        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Tambahkan logika cetak tiket di sini
                // Misalnya, tampilkan pesan sukses cetak tiket
                JOptionPane.showMessageDialog(frmBusSystemBy, "Tiket berhasil dicetak!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }
        });


        Object[] options = {"OK", printButton};
        JOptionPane.showOptionDialog(frmBusSystemBy, message, "Informasi", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                new ImageIcon("check.png"), options, options[0]);
    }

    private void displayError(String errorMessage) {
        JOptionPane.showMessageDialog(frmBusSystemBy, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
