package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {

    JButton withdrawal, back;
    JTextField amountTextField;
    String pinNumber;

    Withdrawal(String pinNumber) {

        this.pinNumber = pinNumber;
        setLayout(null);

        ImageIcon  i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,850,700);
        add(image);

        JLabel text = new JLabel("Enter the amount to be withdrawn.");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(190,250,400,20);
        image.add(text);

        amountTextField = new JTextField();
        amountTextField.setFont(new Font("Raleway",Font.BOLD,22));
        amountTextField.setBounds(250,290,100,30);
        amountTextField.setForeground(Color.YELLOW);
        amountTextField.setBackground(Color.BLACK);
        image.add(amountTextField);

        withdrawal = new JButton("Withdraw");
        withdrawal.setBounds(400,374,90,20);
        withdrawal.setForeground(Color.YELLOW);
        withdrawal.setBackground(Color.BLACK);
        withdrawal.setBorderPainted(false);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        back = new JButton("Back");
        back.setBounds(400,405,80,20);
        back.setForeground(Color.YELLOW);
        back.setBackground(Color.BLACK);
        back.setBorderPainted(false);
        back.addActionListener(this);
        image.add(back);

        setSize(850,700);
        setLocation(300,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String withdrawAmount = amountTextField.getText();
        Date date = new Date();
        if (ae.getSource() == withdrawal){
            if (withdrawAmount.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to be withdrawn.");
            }
            else {
                Conn conn = new Conn();
                try {
                    ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
                    int balance = 0;
                    while(rs.next()){
                        if (rs.getString("type").equals("Deposit")){
                            balance += Integer.parseInt(rs.getString("amount"));
                        }else {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }

                        if (ae.getSource() != back && balance < Integer.parseInt(withdrawAmount) ){
                            JOptionPane.showMessageDialog(null,"Insufficient Balance ,Total Amount:"+balance);
                            return;
                        }

                        String query = "insert into bank values('"+pinNumber+"','"+date+"','Withdrawal','"+withdrawAmount+"')";
                        conn.s.executeUpdate(query);
                        //JOptionPane.showMessageDialog(null,"Rs. "+withdrawAmount+ " Withdrawn");
                        JOptionPane.showMessageDialog(null,"Rs. "+ withdrawAmount +" withdrawn successfully.");
                        setVisible(false);
                        new Transaction(pinNumber).setVisible(true);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }

            }
        }else if (ae.getSource() == back){
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Withdrawal("");
    }
}
