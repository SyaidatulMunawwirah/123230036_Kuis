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
}
