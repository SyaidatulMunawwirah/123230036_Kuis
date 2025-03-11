/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package kuiswinda;
import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame implements ActionListener{
    private JLabel labelHal = new JLabel("LOGIN FRAME", SwingConstants.CENTER);
    private JLabel usnLabel = new JLabel("Username: ");
    private JLabel passLabel = new JLabel("Password: ");

    private JTextField usnTextField = new JTextField();
    private JTextField passTextField = new JTextField();
    
    private JButton buttonLogin = new JButton("Login");
    private JButton buttonReset = new JButton("Reset");
    
    LoginFrame(){
        setVisible(true);
        setTitle("Login Page");
        setSize(480, 400);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        //"LOGIN PAGE"
        labelHal.setBounds(0, 40, getWidth(), 32);
        add(labelHal);
        
        //usn
        usnLabel.setBounds(80, 110, 400, 12);
        add(usnLabel);
        
        usnTextField.setBounds(160, 102, 200, 32);
        add(usnTextField);
        
        //pass
        passLabel.setBounds(80, 160, 400, 12);
        add(passLabel);
        
        passTextField.setBounds(160, 152, 200, 32);
        add(passTextField);
        
        //button login
        buttonLogin.setBounds(70, 220, 150, 32);
        buttonLogin.addActionListener(this);
        add(buttonLogin);
        
        //button reset
        buttonReset.setBounds(240, 220, 150, 32);
        buttonReset.addActionListener(this);
        add(buttonReset);
                
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource() == buttonLogin){
                String usn = usnTextField.getText();
                String pass = passTextField.getText();
                
                //cek usn dan pass
                if(usn.equals("syaidatul") && pass.equals("036")){
                    JOptionPane.showMessageDialog(this, "Login Succes", "Success", JOptionPane.INFORMATION_MESSAGE);
                    
                    new Home(usn);
                    this.dispose(); 
                }else{
                    JOptionPane.showMessageDialog(this, "Login Failed. Username & password incorrect", "Failed", JOptionPane.INFORMATION_MESSAGE);
                    
                }
            }else if(e.getSource() == buttonReset){
                usnTextField.setText("");
                passTextField.setText("");
            }
        }catch(Exception error){
            JOptionPane.showMessageDialog(this, error.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
