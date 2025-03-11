/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kuiss;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Permainan extends JFrame {
    private JTextField player1Field, player2Field;
    private JRadioButton batu1, kertas1, gunting1, batu2, kertas2, gunting2;
    private JButton playButton, resetButton, logoutButton;
    private JLabel resultLabel;

    public Permainan() {
        setTitle("Batu Kertas Gunting");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2));

        JLabel player1Label = new JLabel("Player 1:");
        player1Field = new JTextField();

        JLabel player2Label = new JLabel("Player 2:");
        player2Field = new JTextField();

        batu1 = new JRadioButton("Batu");
        kertas1 = new JRadioButton(" Kertas");
        gunting1 = new JRadioButton(" Gunting");

        batu2 = new JRadioButton(" Batu");
        kertas2 = new JRadioButton(" Kertas");
        gunting2 = new JRadioButton( Gunting");

        ButtonGroup group1 = new ButtonGroup();
        group1.add(batu1);
        group1.add(kertas1);
        group1.add(gunting1);

        ButtonGroup group2 = new ButtonGroup();
        group2.add(batu2);
        group2.add(kertas2);
        group2.add(gunting2);

        playButton = new JButton("Play");
        resetButton = new JButton("Reset");
        logoutButton = new JButton("Logout");
        resultLabel = new JLabel("Hasil pertandingan akan ditampilkan di sini");

        add(player1Label);
        add(player1Field);
        add(batu1);
        add(kertas1);
        add(gunting1);

        add(player2Label);
        add(player2Field);
        add(batu2);
        add(kertas2);
        add(gunting2);

        add(playButton);
        add(resetButton);
        add(logoutButton);
        add(resultLabel);

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String p1 = player1Field.getText();
                    String p2 = player2Field.getText();

                    if (p1.isEmpty() || p2.isEmpty()) {
                        throw new Exception("Nama kedua pemain harus diisi!");
                    }

                    String pilihan1 = getSelectedChoice(batu1, kertas1, gunting1);
                    String pilihan2 = getSelectedChoice(batu2, kertas2, gunting2);

                    if (pilihan1.isEmpty() || pilihan2.isEmpty()) {
                        throw new Exception("Kedua pemain harus memilih!");
                    }

                    String hasil = determineWinner(p1, pilihan1, p2, pilihan2);
                    resultLabel.setText(hasil);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player1Field.setText("");
                player2Field.setText("");
                group1.clearSelection();
                group2.clearSelection();
                resultLabel.setText("Hasil pertandingan akan ditampilkan di sini");
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginFrame().setVisible(true);
            }
        });
    }

    private String getSelectedChoice(JRadioButton batu, JRadioButton kertas, JRadioButton gunting) {
        if (batu.isSelected()) return "Batu";
        if (kertas.isSelected()) return "Kertas";
        if (gunting.isSelected()) return "Gunting";
        return "";
    }

    private String determineWinner(String p1, String pilihan1, String p2, String pilihan2) {
        if (pilihan1.equals(pilihan2)) {
            return "Hasil seri!";
        }

        if ((pilihan1.equals("Batu") && pilihan2.equals("Gunting")) ||
            (pilihan1.equals("Kertas") && pilihan2.equals("Batu")) ||
            (pilihan1.equals("Gunting") && pilihan2.equals("Kertas"))) {
            return p1 + " menang!";
        } else {
            return p2 + " menang!";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameFrame().setVisible(true));
        
    
    }
}
