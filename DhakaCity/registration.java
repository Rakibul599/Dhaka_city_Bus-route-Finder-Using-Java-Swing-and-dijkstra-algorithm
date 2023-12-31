package DhakaCity;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.naming.ldap.PagedResultsControl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;


public class registration extends JFrame implements ActionListener {
    private Container c;
    private JPanel p;
    private Font f;
    private JRadioButton r,r1,r2;
    private JLabel FirstName,secondName,uname,email,phone,gender,dateb,lgl,pass;
    private JTextField fnamet,snamet,unamet,emailt,phonet;
    private JPasswordField passf;
    private JButton submit,login,clr,cancel;
    UtilDateModel model ;
    Properties properties ;
    JDatePanelImpl datePanel;
    JDatePickerImpl datePicker ;
    ButtonGroup bg;
    private Cursor cr;
    registration(){
        regfrom();
    }
    void regfrom()
    {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(400,40,600,690);
        c=getContentPane();
        c.setLayout(null);
        cr=new Cursor(Cursor.HAND_CURSOR);

        Color wh=new Color(238,230,230);
        f=new Font("Arial",Font.BOLD,16);
        p=new JPanel();
        p.setBounds(10,10,565,635);
        p.setBackground(wh);
        p.setLayout(null);
        c.add(p);

        FirstName =new JLabel("First-Name:");
        FirstName.setBounds(20,50,100,50);
        FirstName.setFont(f);
        p.add(FirstName);

        fnamet=new JTextField();
        fnamet.setBounds(120,62,370,30);
        p.add(fnamet);

        secondName =new JLabel("Last-Name:");
        secondName.setBounds(20,100,100,50);
        secondName.setFont(f);
        p.add(secondName);

        snamet=new JTextField();
        snamet.setBounds(120,113,370,30);
        p.add(snamet);

        uname =new JLabel("User-Name:");
        uname.setBounds(20,150,100,50);
        uname.setFont(f);
        p.add(uname);

        unamet=new JTextField();
        unamet.setBounds(120,160,370,30);
        p.add(unamet);

        email =new JLabel("Email:");
        email.setBounds(20,200,100,50);
        email.setFont(f);
        p.add(email);

        emailt=new JTextField();
        emailt.setBounds(120,210,370,30);
        p.add(emailt);

        phone =new JLabel("Phone:");
        phone.setBounds(20,250,100,50);
        phone.setFont(f);
        p.add(phone);

        phonet=new JTextField();
        phonet.setBounds(120,260,370,30);
        p.add(phonet);

        pass=new JLabel("Password:");
        pass.setBounds(20,300,100,50);
        pass.setFont(f);
        p.add(pass);

        passf=new JPasswordField();
        passf.setBounds(120,310,370,30);
        passf.setEchoChar('*');
        p.add(passf);



        dateb =new JLabel("DateOfBirth:");
        dateb.setBounds(20,350,100,50);
        dateb.setFont(f);
        p.add(dateb);

         model = new UtilDateModel();
         properties = new Properties();
         datePanel = new JDatePanelImpl(model, properties);
         datePicker = new JDatePickerImpl(datePanel,new DateComponentFormatter());
        datePicker.setBounds(120,364,370,30);
        p.add(datePicker);


        gender =new JLabel("Gender:");
        gender.setBounds(20,400,100,50);
        gender.setFont(f);
        p.add(gender);

        r=new JRadioButton("Male");
        r1=new JRadioButton("Female");
        r2=new JRadioButton("Custom");
        bg=new ButtonGroup();
        r.setBounds(120,400,100,50);
        r1.setBounds(250,400,100,50);
        r2.setBounds(380,400,100,50);
        r.setFont(f);
        r1.setFont(f);
        r2.setFont(f);
        r.setCursor(cr);
        r1.setCursor(cr);
        r2.setCursor(cr);
        bg.add(r);
        bg.add(r1);
        bg.add(r2);
        p.add(r);
        p.add(r1);
        p.add(r2);



        submit=new JButton("Submit");
        submit.setBounds(90,480,100,30);
        submit.setCursor(cr);
        p.add(submit);

        clr=new JButton("Clear");
        clr.setBounds(220,480,100,30);
        clr.setCursor(cr);
        p.add(clr);

        cancel=new JButton("Cancel");
        cancel.setBounds(350,480,100,30);
        cancel.setCursor(cr);
        p.add(cancel);

        lgl=new JLabel("Already have an account?");
        lgl.setBounds(20,540,200,50);
        p.add(lgl);

        login=new JButton("Login");
        login.setBounds(180,550,100,20);
        login.setCursor(cr);
        p.add(login);

        cancel.addActionListener(this);
        clr.addActionListener(this);
        submit.addActionListener(this);
        login.addActionListener(this);

    }

    public static void main(String[] args) {
        registration frame=new registration();
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==cancel)
        {
            dispose();
            DhakaCityBusRoute dc=new DhakaCityBusRoute();
            dc.setVisible(true);
            dc.setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
        if(e.getSource()==clr)
        {
            fnamet.setText("");
            snamet.setText("");
            unamet.setText("");
            emailt.setText("");
            phonet.setText("");
            passf.setText("");
        }
        if(e.getSource()==submit)
        {
            if(fnamet.getText().isEmpty() || snamet.getText().isEmpty() || uname.getText().isEmpty() ||email.getText().isEmpty() || phonet.getText().isEmpty()||passf.getText().isEmpty())
            {

                JOptionPane.showMessageDialog(null,"Your Text field is Empty");
            }
            else
            {
                String firstn=fnamet.getText();
                String lastn=snamet.getText();
                String usern=unamet.getText();
                String em=emailt.getText();
                int ph= Integer.parseInt(phonet.getText());
                String passw=passf.getText();
                Date selectedDate = (Date) model.getValue();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String dob=dateFormat.format(selectedDate);
                String gend = "";
                if (r.isSelected())
                    gend=r.getText();
                else if (r1.isSelected())
                    gend=r1.getText();
                else if (r2.isSelected())
                    gend=r2.getText();

                DataBase db=new DataBase();
                db.connection();
                try {
//                    PreparedStatement ps=db.con.prepareStatement("insert into reginf values (FIRST_Name=?,Last_Name=?,user_name=?,email=?,phone=?,pass_word=?,Date_of_Birth=?,Gender=?");
                    PreparedStatement ps = db.con.prepareStatement("INSERT INTO reginf (FIRST_Name, Last_Name, user_name, email, phone, pass_word, Date_of_Birth, Gender) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
                    PreparedStatement ps1=db.con.prepareStatement("insert into userinf(user_name,email,pass_word) values(?,?,?) ");
                    ps.setString(1, firstn);
                    ps.setString(2, lastn);
                    ps.setString(3, usern);
                    ps.setString(4, em);
                    ps.setInt(5, ph);
                    ps.setString(6, passw);
                    ps.setString(7, dob);
                    ps.setString(8, gend);
                    ps1.setString(1,usern);
                    ps1.setString(2,em);
                    ps1.setString(3,passw);
                    int rowsAffected = ps.executeUpdate();
                    int rowsAffected1=ps1.executeUpdate();

                    if (rowsAffected > 0 && rowsAffected1>0) {
                        JOptionPane.showMessageDialog(null, "Registration Successful");
                    } else {
                        JOptionPane.showMessageDialog(null, "Registration failed");
                    }

                } catch (SQLException ex) {

                    throw new RuntimeException(ex);
                }

            }

        }
        if (e.getSource()==login)
        {
            dispose();
            Login frame=new Login("G");
            frame.setVisible(true);
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
    }
}
