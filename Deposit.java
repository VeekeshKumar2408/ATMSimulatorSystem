package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    JButton deposit , back;
    JTextField amountTextField;
    String pinNumber;

    Deposit(String pinNumber) {

        this.pinNumber = pinNumber;
        setLayout(null);

        ImageIcon  i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,850,700);
        add(image);

        JLabel text = new JLabel("Enter the amount to be deposited.");
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

        deposit = new JButton("Deposit");
        deposit.setBounds(400,374,80,20);
        deposit.setForeground(Color.YELLOW);
        deposit.setBackground(Color.BLACK);
        deposit.setBorderPainted(false);
        deposit.addActionListener(this);
        image.add(deposit);

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
        if (ae.getSource() == deposit){
            String depositAmount = amountTextField.getText();
            Date date = new Date();
            if (depositAmount.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to withdrawal.");
            }
            else {
                Conn conn = new Conn();
                String query = "insert into bank values('"+pinNumber+"', '"+date+"', 'Deposit', '"+depositAmount+"')";
                try {
                    conn.s.executeUpdate(query);
                } catch (Exception e) {
                    System.out.println(e);
                }
                JOptionPane.showMessageDialog(null,"Rs. "+depositAmount+" deposited successfully.");
                setVisible(false);
                new Transaction(pinNumber).setVisible(true);
            }
        }else if (ae.getSource() == back){
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
