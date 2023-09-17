package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.*;

public class SignUpOne extends JFrame implements ActionListener{
    long random;

    JTextField nameTextField, fnameTextField,
            emailTextField , addressTextField,
            cityTextField, stateTextField,
            pincodeTextField;

    JDateChooser dateChooser;
    JButton next;
    JRadioButton male, female, other, married, unmarried, divorced;
    SignUpOne() {

        setLayout(null);

        // Initiating random class object.
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        //Generating the form no. for new applicant
        JLabel formNo = new JLabel("Application Form No." + random);
        formNo.setFont(new Font("Raleway",Font.BOLD,35));
        formNo.setBounds(185,20,600,40);
        formNo.setForeground(new Color(0, 128, 128));
        add(formNo);

        //Heading : Personal Details
        JLabel personalDetails = new JLabel("Page 1 : Personal Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personalDetails.setForeground(Color.DARK_GRAY);
        personalDetails.setBounds(275,85,400,28);
        add(personalDetails);

        //Label : Name
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,18));
        name.setForeground(Color.DARK_GRAY);
        name.setBounds(50,138,150,30);
        add(name);

        //TextField : Name
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(220,138,400,30);
        add(nameTextField);

        //Label : Father's Name
        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,18));
        fname.setForeground(Color.DARK_GRAY);
        fname.setBounds(50,188,150,30);
        add(fname);

        //TextField : Father's Name
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(220,188,400,30);
        add(fnameTextField);


        //Label : Date of birth
        JLabel dob = new JLabel("Date Of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,18));
        dob.setForeground(Color.DARK_GRAY);
        dob.setBounds(50,238,150,30);
        add(dob);

        //Calender : Date
        dateChooser = new JDateChooser();
        dateChooser.setBounds(220,238,400,30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);

        //Label : Gender
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,18));
        gender.setForeground(Color.DARK_GRAY);
        gender.setBounds(50,288,150,30);
        add(gender);

        //Radio button : Gender
        male = new JRadioButton("Male");
        male.setBackground(Color.LIGHT_GRAY);
        male.setForeground(Color.DARK_GRAY);
        male.setFont(new Font("Raleway",Font.BOLD,15));
        male.setBounds(220,288,80,30);
        add(male);

        female = new JRadioButton("Female");
        female.setBackground(Color.LIGHT_GRAY);
        female.setForeground(Color.DARK_GRAY);
        female.setFont(new Font("Raleway",Font.BOLD,15));
        female.setBounds(320,288,100,30);
        add(female);

        other = new JRadioButton("Other");
        other.setBackground(Color.LIGHT_GRAY);
        other.setForeground(Color.DARK_GRAY);
        other.setFont(new Font("Raleway",Font.BOLD,15));
        other.setBounds(440,288,80,30);
        add(other);

        //Condition to select only one gender
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);

        //Label : email
        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway",Font.BOLD,18));
        email.setForeground(Color.DARK_GRAY);
        email.setBounds(50,338,150,30);
        add(email);

        //TextField : email
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(220,338,400,30);
        add(emailTextField);

        //Label : Marital Status
        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway",Font.BOLD,18));
        marital.setForeground(Color.DARK_GRAY);
        marital.setBounds(50,388,150,30);
        add(marital);

        //Radio Buttons : Martial Status
        married = new JRadioButton("Married");
        married.setBackground(Color.LIGHT_GRAY);
        married.setForeground(Color.DARK_GRAY);
        married.setFont(new Font("Raleway",Font.BOLD,15));
        married.setBounds(220,388,100,30);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBackground(Color.LIGHT_GRAY);
        unmarried.setForeground(Color.DARK_GRAY);
        unmarried.setFont(new Font("Raleway",Font.BOLD,15));
        unmarried.setBounds(320,388,120,30);
        add(unmarried);

        divorced = new JRadioButton("Divorced");
        divorced.setBackground(Color.LIGHT_GRAY);
        divorced.setForeground(Color.DARK_GRAY);
        divorced.setFont(new Font("Raleway",Font.BOLD,15));
        divorced.setBounds(440,388,200,30);
        add(divorced);

        //Condition to select only one Martial Status
        ButtonGroup status = new ButtonGroup();
        status.add(married);
        status.add(unmarried);
        status.add(divorced);

        //Label : Address
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,18));
        address.setForeground(Color.DARK_GRAY);
        address.setBounds(50,438,200,30);
        add(address);

        //TextField : Address
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(220,438,400,30);
        add(addressTextField);

        //Label : city
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,18));
        city.setForeground(Color.DARK_GRAY);
        city.setBounds(50,488,150,30);
        add(city);

        //TextField : city
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(220,488,400,30);
        add(cityTextField);


        //Label : State
        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,18));
        state.setForeground(Color.DARK_GRAY);
        state.setBounds(50,538,150,30);
        add(state);

        //TextField : State
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(220,538,400,30);
        add(stateTextField);

        //Label : Pincode
        JLabel pincode = new JLabel("Pincode:");
        pincode.setFont(new Font("Raleway",Font.BOLD,18));
        pincode.setForeground(Color.DARK_GRAY);
        pincode.setBounds(50,588,150,30);
        add(pincode);

        //TextField : Pincode
        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pincodeTextField.setBounds(220,588,400,30);
        add(pincodeTextField);

        //Button : next
        next = new JButton("Next");
        next.setForeground(new Color(0,128,128));
        next.setFont(new Font("Raleway",Font.BOLD,15));
        next.setBounds(520,630,100,30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.LIGHT_GRAY);//Adding Background

        setSize(850,700); // Setting signUp frame size
        setLocation(350,0); //
        setVisible(true);


    }
    public void actionPerformed(ActionEvent ae){
        //Converting random to String
        String formno = ""+random;

        //getText() to get values from text field
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();

        String gender = null;
        if (male.isSelected()){
            gender = "Male";
        } else if (female.isSelected()){
            gender = "Female";
        } else if (other.isSelected()){
            gender = "Other";
        }

        String email = emailTextField.getText();

        String martialStatus = null;
        if (married.isSelected()){
            martialStatus = "Married";
        } else if (unmarried.isSelected()){
            martialStatus = "Unmarried";
        } else if (divorced.isSelected()){
            martialStatus = "Divorced";
        }

        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pincodeTextField.getText();

        //Passing query to Database
        try{
            if (name.equals("")){
                JOptionPane.showMessageDialog(null,"*Name Is Required");
            } else {
                Conn c = new Conn();

                //Generating query
                String query = "insert into signupone values('"+formno+"', '"+name+"','"+fname+"','"
                        +dob+"','"+gender+"','"+email+"','"+martialStatus+"','"+address+"','"
                        +city+"','"+state+"','"+pin+"')";

                //Executing query
                c.s.executeUpdate(query);
                setVisible(false);
                new SignUpTwo(formno).setVisible(true);
            }
        } catch (Exception e){
            System.out.println(e);
        }


    }
    public static void main(String[] args) {
        new SignUpOne();
    }
}
