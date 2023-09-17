package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceInquiry extends JFrame implements ActionListener {
    JButton back;

    String pinNumber;
    BalanceInquiry(String pinNumber){
        this.pinNumber = pinNumber;

        setLayout(null);
        ImageIcon  i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,850,700);
        add(image);

        back = new JButton("Back");
        back.setBounds(370,374,110,20);
        back.setForeground(Color.YELLOW);
        back.setBackground(Color.BLACK);
        back.setBorderPainted(false);
        back.addActionListener(this);
        image.add(back);

        Conn c = new Conn();
        int balance = 0;
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinNumber + "'");

            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e){
            System.out.println(e);
        }

        JLabel text = new JLabel("Available Balance");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(250,250,400,25);
        image.add(text);

        JLabel amount = new JLabel("Rs. "+balance);
        amount.setForeground(Color.WHITE);
        amount.setFont(new Font("System",Font.BOLD,18));
        amount.setBounds(270,300,400,25);
        image.add(amount);


        setSize(850,700);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);

    }
    public static void main(String[] args) {
        new BalanceInquiry(" ");
    }
}
