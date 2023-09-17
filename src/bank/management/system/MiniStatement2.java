package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement2 extends JFrame {
    String pinNumber;
    MiniStatement2(String pinNumber){
        this.pinNumber = pinNumber;
        setTitle("Mini Statement");

        setLayout(null);

        JLabel mini = new JLabel();
        add(mini);

        JLabel bank = new JLabel("Bank Of India");
        bank.setFont(new Font("Raleway",Font.BOLD,18));
        bank.setForeground(Color.BLACK);
        bank.setBounds(130,20,150,20);
        add(bank);

        JLabel balance = new JLabel();
        balance.setFont(new Font("Raleway",Font.BOLD,12));
        balance.setForeground(Color.BLACK);
        balance.setBounds(20,400,300,20);
        add(balance);


//        JLabel mini = new JLabel();
//        mini.setBounds(20,80,300,20);
//        add(mini);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select* from login where pin ='"+pinNumber+"'");
            while (rs.next()){
                card.setText("Card Number: "+rs.getString("cardNumber").substring(0,4) + "XXXXXXXX"+ rs.getString("cardNumber").substring(12));

            }
        }catch (Exception e){
            System.out.println(e);
        }

        try {
          Conn conn = new Conn();
          int bal = 0;
          ResultSet rs = conn.s.executeQuery("select * from bank where pin ='"+pinNumber+"'");
          while(rs.next()){
              mini.setText(mini.getText()+ "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("type") +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount")+"<br><br></html>") ;
              if (rs.getString("type").equals("Deposit")){
                  bal += Integer.parseInt(rs.getString("amount"));
              } else {
                  bal -= Integer.parseInt(rs.getString("amount"));
              }
          }
          balance.setText("Your current account balance is Rs "+ bal);
        } catch (Exception e){
            System.out.println(e);
        }

        mini.setBounds(20,80,400,200);

        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement2("");
    }
}