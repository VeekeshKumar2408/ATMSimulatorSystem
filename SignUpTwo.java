package bank.management.system;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpTwo extends JFrame implements ActionListener{
    long random;
    JTextField panTextField, aadharTextField;
    JButton next;
    JRadioButton yes, no, syes, sno;
    JComboBox incomeCombo, categoryCombo, occupationCombo,religionCombo,educationCombo;
    String formNo;

    SignUpTwo(String formNo) {

        this.formNo = formNo;
        setLayout(null);

        setTitle("New Account Application Form - Page 2");

        //Heading : Additional Details
        JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setForeground(Color.DARK_GRAY);
        additionalDetails.setBounds(275,85,400,28);
        add(additionalDetails);

        //Label : Name
        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway",Font.BOLD,18));
        religion.setForeground(Color.DARK_GRAY);
        religion.setBounds(50,138,150,30);
        add(religion);

        //Dropdown : Religion
        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religionCombo = new JComboBox(valReligion);
        religionCombo.setFont(new Font("Raleway",Font.BOLD,14));
        religionCombo.setBounds(220,138,400,30);
        add(religionCombo);

        //Label : Income
        JLabel Income = new JLabel("Income:");
        Income.setFont(new Font("Raleway",Font.BOLD,18));
        Income.setForeground(Color.DARK_GRAY);
        Income.setBounds(50,188,150,30);
        add(Income);

        //Dropbox : Income
        String income[] = {"Null","<1,50,00","<2,50,000","<5,00,000","10,00,000"};
        incomeCombo = new JComboBox(income);
        incomeCombo.setFont(new Font("Raleway",Font.BOLD,14));
        incomeCombo.setBounds(220,188,400,30);
        add(incomeCombo);


        //Label : Category
        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway",Font.BOLD,18));
        category.setForeground(Color.DARK_GRAY);
        category.setBounds(50,238,150,30);
        add(category);

        //Dropbox : Category
        String valCategory[] = {"General","OBC","SC","ST"};
        categoryCombo = new JComboBox(valCategory);
        categoryCombo.setBounds(220,238,400,30);
        categoryCombo.setForeground(new Color(105,105,105));
        add(categoryCombo);

        //Label : education
        JLabel education = new JLabel("Educational:");
        education.setFont(new Font("Raleway",Font.BOLD,18));
        education.setForeground(Color.DARK_GRAY);
        education.setBounds(50,288,150,30);
        add(education);

        //Label : Qualification
        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Raleway",Font.BOLD,18));
        email.setForeground(Color.DARK_GRAY);
        email.setBounds(50,338,150,30);
        add(email);

        //Dropbox : Qualification
        String educationValue [] = {"Non-Graduation","Graduation","Post Graduation","Doctorate"};
        educationCombo = new JComboBox(educationValue);
        educationCombo.setFont(new Font("Raleway",Font.BOLD,14));
        educationCombo.setBounds(220,338,400,30);
        add(educationCombo);

        //Label : occupation
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway",Font.BOLD,18));
        occupation.setForeground(Color.DARK_GRAY);
        occupation.setBounds(50,388,150,30);
        add(occupation);

        //Dropbox : Occupation
        String occupationValue [] = {"Salaried","Self-Employer","Business","Student","Un-Employed"};
        occupationCombo = new JComboBox(occupationValue);
        occupationCombo.setFont(new Font("Raleway",Font.BOLD,14));
        occupationCombo.setBounds(220,388,400,30);
        add(occupationCombo);

        //Label : Pan
        JLabel pan = new JLabel("PAN no.:");
        pan.setFont(new Font("Raleway",Font.BOLD,18));
        pan.setForeground(Color.DARK_GRAY);
        pan.setBounds(50,438,200,30);
        add(pan);

        //TextField : Pan
        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panTextField.setBounds(220,438,400,30);
        add(panTextField);

        //Label : Aadhar
        JLabel aadhar = new JLabel("Aadhar:");
        aadhar.setFont(new Font("Raleway",Font.BOLD,18));
        aadhar.setForeground(Color.DARK_GRAY);
        aadhar.setBounds(50,488,150,30);
        add(aadhar);

        //TextField : Aadhar
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway",Font.BOLD,14));
        aadharTextField.setBounds(220,488,400,30);
        add(aadharTextField);


        //Label : Senior Citizen
        JLabel seniorCitizen = new JLabel("Senior Citizen:");
        seniorCitizen.setFont(new Font("Raleway",Font.BOLD,18));
        seniorCitizen.setForeground(Color.DARK_GRAY);
        seniorCitizen.setBounds(50,538,150,30);
        add(seniorCitizen);

        //RadioButton: Senior Citizen
        syes = new JRadioButton("Yes");
        syes.setBackground(Color.LIGHT_GRAY);
        syes.setForeground(Color.DARK_GRAY);
        syes.setFont(new Font("Raleway",Font.BOLD,15));
        syes.setBounds(220,538,100,30);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBackground(Color.LIGHT_GRAY);
        sno.setForeground(Color.DARK_GRAY);
        sno.setFont(new Font("Raleway",Font.BOLD,15));
        sno.setBounds(320,538,120,30);
        add(sno);

        ButtonGroup status = new ButtonGroup();
        status.add(syes);
        status.add(sno);

        //stateTextField.setBounds(220,538,400,30);

        //Label : Existing Account
        JLabel existingAcct = new JLabel("Existing Acct:");
        existingAcct.setFont(new Font("Raleway",Font.BOLD,18));
        existingAcct.setForeground(Color.DARK_GRAY);
        existingAcct.setBounds(50,588,150,30);
        add(existingAcct);

        //RadioButton: Existing Account
        yes = new JRadioButton("Yes");
        yes.setBackground(Color.LIGHT_GRAY);
        yes.setForeground(Color.DARK_GRAY);
        yes.setFont(new Font("Raleway",Font.BOLD,15));
        yes.setBounds(220,588,100,30);
        add(yes);

        no = new JRadioButton("No");
        no.setBackground(Color.LIGHT_GRAY);
        no.setForeground(Color.DARK_GRAY);
        no.setFont(new Font("Raleway",Font.BOLD,15));
        no.setBounds(320,588,120,30);
        add(no);

        ButtonGroup statusAcc = new ButtonGroup();
        statusAcc.add(yes);
        statusAcc.add(no);

        //pincodeTextField.setBounds(220,588,400,30);


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
        String formno = formNo ;


        //getText() to get values from text field
        String religion = (String) religionCombo.getSelectedItem();
        String category = (String) categoryCombo.getSelectedItem();
        String income = (String) incomeCombo.getSelectedItem();
        String qualification = (String) educationCombo.getSelectedItem();
        String occupation = (String) occupationCombo.getSelectedItem();

        String seniorCitizen = null;
        if (syes.isSelected()){
            seniorCitizen = "Yes";
        } else if (sno.isSelected()){
            seniorCitizen = "No";
        }

        String existingAcc = null;
        if (yes.isSelected()){
            existingAcc = "Yes";
        } else if (no.isSelected()){
            existingAcc = "No";
        }

        String pan = panTextField.getText();
        String aadhar = aadharTextField.getText();


        //Passing query to Database
        try{

                Conn c = new Conn();

                //Generating query
                String query = "insert into signuptwo values('"+formno+"', '"+religion+"','"+category+"','"
                        +income+"','"+qualification+"','"+occupation+"','"+pan+"','"+aadhar+"','"
                        +existingAcc+"','"+seniorCitizen+"')";

                //Executing query
                c.s.executeUpdate(query);
                setVisible(false);
                new SignUpThree(formno).setVisible(true);

        } catch (Exception e){
            System.out.println(e);
        }


    }
    public static void main(String[] args) {
        new SignUpTwo("");
    }
}
