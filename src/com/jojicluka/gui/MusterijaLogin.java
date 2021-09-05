package com.jojicluka.gui;

import com.jojicluka.gui.MusterijaDashboard.MusterijaDashboard;
import com.jojicluka.taxisluzba.TaxiSluzba;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class MusterijaLogin extends JFrame {

    private JPanel mainPanel;
    private JLabel userLabel;
    private JTextField usernameText;
    private JLabel passLabel;
    private JPasswordField passwordText;
    private JButton button;
    private JLabel provera;

    public MusterijaLogin(TaxiSluzba taxiSluzba) {
        setTitle("Musterija login");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(250,250,450,200);
        mainPanel = new JPanel();
        mainPanel.setBorder(new EmptyBorder(3,3,3,3));
        setContentPane(mainPanel);
        mainPanel.setLayout(null);


        userLabel = new JLabel("User:");
        userLabel.setBounds(50, 20, 80, 30);
        mainPanel.add(userLabel);

        usernameText = new JTextField();
        usernameText.setBounds(140, 20, 150, 30);
        mainPanel.add(usernameText);

        passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 50, 80, 30);
        mainPanel.add(passLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(140, 50, 150, 30);
        mainPanel.add(passwordText);

        button = new JButton("Login");
        button.setBounds(50, 80, 90, 30);
        mainPanel.add(button);

        provera = new JLabel("");
        provera.setBounds(50, 120, 250, 30);
        mainPanel.add(provera);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userCheck = usernameText.getText();
                String passCheck = passwordText.getText();
                boolean verify = verifyLoginMusterija(userCheck, passCheck);
                if(verify == true){
                    provera.setText("Login uspesan!");
                    String username = userCheck;
                    MusterijaDashboard md = new MusterijaDashboard(taxiSluzba,username);
                    md.setVisible(true);
                } else {
                    provera.setText("Login neuspesan...");
                }
            }
        });
    }
    public static boolean verifyLoginMusterija(String userCheck, String passCheck){
        try{
            File file = new File("src/com/jojicluka/text/musterije.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split("\\|");
                if((userCheck.equals(split[1])) && (passCheck.equals(split[2]))){
                    return true;
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}



