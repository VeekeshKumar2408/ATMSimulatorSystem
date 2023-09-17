package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    JPasswordField pinTextField, rePinTextField;
    JButton change , back;
    String pinNumber;

    PinChange(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        ImageIcon  i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,850,700);
        add(image);

        JLabel text = new JLabel("Change Your Pin");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(250,250,400,25);
        image.add(text);

        JLabel pinText = new JLabel("New Pin");
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("System",Font.BOLD,14));
        pinText.setBounds(200,300,90,25);
        image.add(pinText);

        pinTextField = new JPasswordField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pinTextField.setBounds(270,300,100,25);
        pinTextField.setForeground(Color.YELLOW);
        pinTextField.setBackground(Color.BLACK);
        image.add(pinTextField);

        JLabel RePinText = new JLabel("Re-Enter Pin");
        RePinText.setForeground(Color.WHITE);
        RePinText.setFont(new Font("System",Font.BOLD,14));
        RePinText.setBounds(170,330,400,25);
        image.add(RePinText);

        rePinTextField = new JPasswordField();
        rePinTextField.setFont(new Font("Raleway",Font.BOLD,14));
        rePinTextField.setBounds(270,330,100,25);
        rePinTextField.setForeground(Color.YELLOW);
        rePinTextField.setBackground(Color.BLACK);
        image.add(rePinTextField);

        change = new JButton("Change Pin");
        change.setBounds(345,374,140,20);
        change.setForeground(Color.YELLOW);
        change.setBackground(Color.BLACK);
        change.setBorderPainted(false);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(370,405,110,20);
        back.setForeground(Color.YELLOW);
        back.setBackground(Color.BLACK);
        back.setBorderPainted(false);
        back.addActionListener(this);
        image.add(back);

        setSize(850,700);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== change){
            try {
            String newPin = pinTextField.getText();
            String rePin = rePinTextField.getText();

            if (!newPin.equals(rePin)){
                JOptionPane.showMessageDialog(null,"Entered Pin Does Not Match");
                return;
            }
            if (newPin.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter PIN");
                return;
            }
                if (rePin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Re-Enter New PIN");
                    return;
                }

                Conn conn = new Conn();
                String query1 = "update bank set pin = '"+rePin+"' where pin ='"+pinNumber+"'";
                String query2 = "update login set pin = '"+rePin+"' where pin ='"+pinNumber+"'";
                String query3 = "update signupthree set pin = '"+rePin+"' where pin ='"+pinNumber+"'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"PIN Changed Successfully");
                setVisible(false);
                new Transaction(rePin).setVisible(true);

            } catch (Exception e){
            System.out.println(e);
        }}
        else {
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new PinChange(" ");
    }
}
