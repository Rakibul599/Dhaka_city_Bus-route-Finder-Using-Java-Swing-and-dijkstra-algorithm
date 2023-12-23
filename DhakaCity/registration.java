package DhakaCity;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class registration extends JFrame {
    private Container c;
    private JPanel p;
    private Font f;
    private JRadioButton r,r1,r2;
    private JLabel FirstName,secondName,uname,email,phone,gender,dateb,lgl;
    private JTextField fnamet,snamet,unamet,emailt,phonet;
    private JButton submit,login,clr,cancel;
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

        dateb =new JLabel("DateOfBirth:");
        dateb.setBounds(20,300,100,50);
        dateb.setFont(f);
        p.add(dateb);

        UtilDateModel model = new UtilDateModel();
        Properties properties = new Properties();







        JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel,new DateComponentFormatter());
        datePicker.setBounds(120,314,370,30);
        p.add(datePicker);

        gender =new JLabel("Gender:");
        gender.setBounds(20,350,100,50);
        gender.setFont(f);
        p.add(gender);

        r=new JRadioButton("Male");
        r1=new JRadioButton("Female");
        r2=new JRadioButton("Custom");
        ButtonGroup bg=new ButtonGroup();
        r.setBounds(120,350,100,50);
        r1.setBounds(250,350,100,50);
        r2.setBounds(380,350,100,50);
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
        submit.setBounds(90,430,100,30);
        submit.setCursor(cr);
        p.add(submit);

        clr=new JButton("Clear");
        clr.setBounds(220,430,100,30);
        clr.setCursor(cr);
        p.add(clr);

        cancel=new JButton("Cancel");
        cancel.setBounds(350,430,100,30);
        cancel.setCursor(cr);
        p.add(cancel);

        lgl=new JLabel("Already have an account?");
        lgl.setBounds(20,490,200,50);
        p.add(lgl);

        login=new JButton("Login");
        login.setBounds(180,505,100,20);
        login.setCursor(cr);
        p.add(login);




    }
    public static void main(String[] args) {
        registration frame=new registration();
        frame.setVisible(true);
    }

}
