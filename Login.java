package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, signUp, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;


    Login() {
        setTitle("AUTOMATED TELLER MACHINE");

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBackground(Color.WHITE);
        label.setBounds(170,0,100,100);//setting location of icon
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.ITALIC,38));
        text.setForeground(Color.red);
        add(text);
        text.setBounds(270,30,400,40);//Setting the text location

        JLabel cardNo = new JLabel("Card No");
        cardNo.setFont(new Font("Raleway", Font.BOLD,20));
        //cardNo.setForeground(Color.red);
        cardNo.setBounds(135,115,106,30);//Setting the text location
        add(cardNo);

        JLabel pin = new JLabel("Pin ");
        pin.setFont(new Font("Raleway", Font.BOLD,20));
        //pin.setForeground(Color.red);
        pin.setBounds(135,160,106,30);//Setting the text location
        add(pin);

        cardTextField = new JTextField(); //Text field for entering card number
        cardTextField.setBounds(250,115,250,30);
        //cardTextField.setText("---Enter Card Number---");
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);

        pinTextField = new JPasswordField(); //Password field for entering pin
        pinTextField.setBounds(250,160,250,30);
        //pinTextField.setText("---Enter Password---");
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);

        login = new JButton("Sign In");
        login.setBounds(250,200,100,30);
        login.addActionListener(this);
        add(login);

        clear = new JButton("Clear");
        clear.setBounds(400,200,100,30);
        clear.addActionListener(this);
        add(clear);

        signUp = new JButton("Sign Up");
        signUp.setBounds(250,250,250,30);
        signUp.addActionListener(this);
        add(signUp);

        getContentPane().setBackground(Color.WHITE);//Background color.
        setSize(800,480); //Setting the dimension of frame
        setLocation(280,130);//Location when window will open
        setVisible(true); //Making Frame Visible
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");

        } else if (ae.getSource() == login){
            Conn conn = new Conn();
            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();
            String query = "select * from login where cardNumber = '"+cardNumber+"' and pin =  '"+pinNumber+"'";
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                }
            }catch (Exception e){
                System.out.println(e);
            }

        } else if (ae.getSource() == signUp){
            setVisible(false); //Setting visible to disappear Login window.
            new SignUpOne().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}
