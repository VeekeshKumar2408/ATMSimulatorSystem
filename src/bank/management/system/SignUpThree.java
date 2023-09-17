package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUpThree extends JFrame implements ActionListener {

    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit, cancel;
    String formNo;


    SignUpThree(String formNo){
        this.formNo = formNo;
        setLayout(null);

        //Heading of the page
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD,22));
        l1.setBounds(275,40,400,28);
        add(l1);

        //JLabel : Account Type
        JLabel type = new JLabel("Account Type: ");
        type.setFont(new Font("Raleway", Font.BOLD,18));
        type.setBounds(100,110,150,30);
        add(type);

        //Radio Button : Account Type
        r1 = new JRadioButton("Saving Account ");
        r1.setFont(new Font("Raleway", Font.PLAIN,14));
        //r1.setBackground(Color.WHITE);
        r1.setBounds(200,160,150,20);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit ");
        r2.setFont(new Font("Raleway", Font.PLAIN,14));
        //r1.setBackground(Color.WHITE);
        r2.setBounds(450,160,150,20);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.PLAIN,14));
        //r1.setBackground(Color.WHITE);
        r3.setBounds(200,190,150,20);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account ");
        r4.setFont(new Font("Raleway", Font.PLAIN,14));
        //r1.setBackground(Color.WHITE);
        r4.setBounds(450,190,250,20);
        add(r4);

        //Giving validation so that only ine radio button get selected
        ButtonGroup groupAccount = new ButtonGroup();
        groupAccount.add(r1);
        groupAccount.add(r2);
        groupAccount.add(r3);
        groupAccount.add(r4);

        //JLabel : Card
        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway", Font.BOLD,18));
        card.setBounds(100,220,150,30);
        add(card);

        //JLabel : Card Detail
        JLabel cardDetail = new JLabel("Your 16 Digit Card Number");
        cardDetail.setFont(new Font("Raleway", Font.PLAIN,12));
        cardDetail.setBounds(100,240,150,30);
        add(cardDetail);

        //JLabel : Card Number
        JLabel cardNumber = new JLabel("XXXX-XXXX-XXXX-2408");
        cardNumber.setFont(new Font("Raleway", Font.BOLD,14));
        cardNumber.setBounds(300,220,250,30);
        add(cardNumber);

        //JLabel : Pin
        JLabel pin = new JLabel("Pin:");
        pin.setFont(new Font("Raleway", Font.BOLD,18));
        pin.setBounds(100,280,150,30);
        add(pin);

        //JLabel : Pin Detail
        JLabel pinDetail = new JLabel("Your 4 Digit Password");
        pinDetail.setFont(new Font("Raleway", Font.PLAIN,12));
        pinDetail.setBounds(100,300,150,30);
        add(pinDetail);

        //JLabel : Pin Code
        JLabel pinNumber = new JLabel("XXXX");
        pinNumber.setFont(new Font("Raleway", Font.BOLD,14));
        pinNumber.setBounds(300,280,250,30);
        add(pinNumber);

        //JLabel : Services Required
        JLabel services  = new JLabel("Services Required: ");
        services.setFont(new Font("Raleway", Font.BOLD,18));
        services.setBounds(100,340,200,30);
        add(services);

        //CheckBoxes : Services
        c1 = new JCheckBox("ATM Card");
        c1.setFont(new Font("Raleway", Font.PLAIN,14));
        c1.setBounds(200,380,100,30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway", Font.PLAIN,14));
        c2.setBounds(450,380,150,30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway", Font.PLAIN,14));
        c3.setBounds(200,410,150,30);
        add(c3);

        c4 = new JCheckBox("E-Mail & SMS Alert");
        c4.setFont(new Font("Raleway", Font.PLAIN,14));
        c4.setBounds(450,410,150,30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway", Font.PLAIN,14));
        c5.setBounds(200,440,100,30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway", Font.PLAIN,14));
        c6.setBounds(450,440,150,30);
        add(c6);

        c7 = new JCheckBox("I Hereby declare that the above entered details are correct to the best of knowledge.");
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,500,1000,30);
        add(c7);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(300,550,100,30);
        cancel.addActionListener(this);
        add(cancel);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(420,550,100,30);
        submit.addActionListener(this);
        add(submit);



        setSize(850,700);
        setLocation(350,0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == submit){
            String accountType= null;
            if (r1.isSelected()){
                accountType = "Saving Account";
            } else if (r2.isSelected()){
                accountType = "Fixed Deposit";
            } else if (r3.isSelected()){
                accountType = "Current Account";
            } else if (r4.isSelected()){
                accountType = "Recurring Saving Account";
            }

            Random random = new Random();

            String cardNumber = "" + Math.abs((random.nextLong()% 90000000) + 5040936000000000l);

            String pinNumber = "" + Math.abs((random.nextLong() % 9000l) + 1000l);

            String facility = " ";
            if (c1.isSelected()) {
                facility = facility + " ATM Card";
            }else if (c2.isSelected()){
                facility = facility + " InternetBanking";
            }else if (c3.isSelected()){
                facility = facility + " MobileBanking";
            }else if (c4.isSelected()){
                facility = facility + " E-mail&SMSAlert";
            }else if (c5.isSelected()){
                facility = facility + " ChequeBook";
            }else if (c6.isSelected()){
                facility = facility + " E-mail&SMSAlert";
            }

            try{
                if (accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type Required");
                } else {
                    Conn conn = new Conn();
                    String query1 = "insert into signupthree values('"+formNo+"','"+accountType+"','"+cardNumber+"','"+pinNumber+"','"+facility+"')";
                    String query2 = "insert into login values('"+formNo+"','"+cardNumber+"','"+pinNumber+"')";

                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null,"Card Number: " + cardNumber +"\n Pin: " + pinNumber);
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }else if (ae.getSource() == cancel){

        }
    }

    public static void main(String[] args) {
        new SignUpThree("");
    }
}
