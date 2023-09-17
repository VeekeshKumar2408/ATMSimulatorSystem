package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {

    JButton deposit, withdrawal, fastCash, miniStatement, pinChange, balanceInquiry, exit;
    String pinNumber;

    Transaction(String pinNumber) {

        this.pinNumber = pinNumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,850,700);
        add(image);

        JLabel text = new JLabel("Please select Transaction");
        text.setBounds(230,240,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,14));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(150,326,100,20);
        deposit.setForeground(Color.YELLOW);
        deposit.setBackground(Color.BLACK);
        deposit.setBorderPainted(false);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawal = new JButton("Cash Withdrawal");
        withdrawal.setBounds(345,326,135,20);
        withdrawal.setForeground(Color.YELLOW);
        withdrawal.setBackground(Color.BLACK);
        withdrawal.setBorderPainted(false);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(150,350,100,20);
        fastCash.setForeground(Color.YELLOW);
        fastCash.setBackground(Color.BLACK);
        fastCash.setBorderPainted(false);
        fastCash.addActionListener(this);
        image.add(fastCash);

        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(345,350,140,20);
        miniStatement.setForeground(Color.YELLOW);
        miniStatement.setBackground(Color.BLACK);
        miniStatement.setBorderPainted(false);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        pinChange = new JButton("Pin Change");
        pinChange.setBounds(150,374,110,20);
        pinChange.setForeground(Color.YELLOW);
        pinChange.setBackground(Color.BLACK);
        pinChange.setBorderPainted(false);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balanceInquiry = new JButton("Balance Inquiry");
        balanceInquiry.setBounds(345,374,140,20);
        balanceInquiry.setForeground(Color.YELLOW);
        balanceInquiry.setBackground(Color.BLACK);
        balanceInquiry.setBorderPainted(false);
        balanceInquiry.addActionListener(this);
        image.add(balanceInquiry);

        exit = new JButton("Exit");
        exit.setBounds(370,405,110,20);
        exit.setForeground(Color.YELLOW);
        exit.setBackground(Color.BLACK);
        exit.setBorderPainted(false);
        exit.addActionListener(this);
        image.add(exit);

        setSize(850,700);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
           if (ae.getSource()==exit){
               System.exit(0);
           } else if (ae.getSource() == deposit){
               setVisible(false);
               new Deposit(pinNumber).setVisible(true);
           } else if (ae.getSource() == withdrawal){
               setVisible(false);
               new Withdrawal(pinNumber).setVisible(true);
           }else if (ae.getSource() == fastCash){
               setVisible(false);
               new FastCash(pinNumber).setVisible(true);
           }else if (ae.getSource() == pinChange){
               setVisible(false);
               new PinChange(pinNumber).setVisible(true);
           }else if (ae.getSource() == balanceInquiry){
               setVisible(false);
               new BalanceInquiry(pinNumber).setVisible(true);
           }else if (ae.getSource() == miniStatement){
               new MiniStatement2(pinNumber).setVisible(true);
           }
    }
    public static void main(String[] args) {
        new Transaction("");
    }
}
