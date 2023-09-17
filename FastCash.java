package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton deposit, withdrawal, fastCash, miniStatement, pinChange, balanceInquiry, exit;
    String pinNumber;

    FastCash(String pinNumber) {

        this.pinNumber = pinNumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,850,700);
        add(image);

        JLabel text = new JLabel("Select Withdrawal Amount");
        text.setBounds(230,240,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,14));
        image.add(text);

        deposit = new JButton("Rs.100");
        deposit.setBounds(150,326,100,20);
        deposit.setForeground(Color.YELLOW);
        deposit.setBackground(Color.BLACK);
        deposit.setBorderPainted(false);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawal = new JButton("Rs.500");
        withdrawal.setBounds(345,326,135,20);
        withdrawal.setForeground(Color.YELLOW);
        withdrawal.setBackground(Color.BLACK);
        withdrawal.setBorderPainted(false);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        fastCash = new JButton("Rs.1000");
        fastCash.setBounds(150,350,100,20);
        fastCash.setForeground(Color.YELLOW);
        fastCash.setBackground(Color.BLACK);
        fastCash.setBorderPainted(false);
        fastCash.addActionListener(this);
        image.add(fastCash);

        miniStatement = new JButton("Rs.2000");
        miniStatement.setBounds(345,350,140,20);
        miniStatement.setForeground(Color.YELLOW);
        miniStatement.setBackground(Color.BLACK);
        miniStatement.setBorderPainted(false);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        pinChange = new JButton("Rs. 5000");
        pinChange.setBounds(150,374,110,20);
        pinChange.setForeground(Color.YELLOW);
        pinChange.setBackground(Color.BLACK);
        pinChange.setBorderPainted(false);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balanceInquiry = new JButton("Rs.10000");
        balanceInquiry.setBounds(345,374,140,20);
        balanceInquiry.setForeground(Color.YELLOW);
        balanceInquiry.setBackground(Color.BLACK);
        balanceInquiry.setBorderPainted(false);
        balanceInquiry.addActionListener(this);
        image.add(balanceInquiry);

        exit = new JButton("Back");
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
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
                int balance = 0;
                while (rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }

                    if (ae.getSource() != exit && balance < Integer.parseInt(amount) ){
                        JOptionPane.showMessageDialog(null,"Insufficient Balance");
                        return;
                    }

                    Date date = new Date();
                    String query = "insert into bank values('"+pinNumber+"','"+date+"','Withdrawal','"+amount+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs. "+ amount +" Withdrawn");

                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);
                }
            } catch (Exception e){
                System.out.println(e);
            }

        }
    }
    public static void main(String[] args) {
        new FastCash("");
    }
}
