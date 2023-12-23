package DhakaCity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    private Container c;
    private JLabel UserNameLV,PasswordLV,acc;
    private JTextField UserName;
    private JPasswordField password;
    private JButton logb,cls,accb;
    private JPanel p;
    private Font f;
    private Cursor cursor;
    private String lgd;
    Login(String s)
    {
        Color wh=new Color(238,230,230);
        lgd=s;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(400,40,600,690);
        c=getContentPane();
        c.setBackground(wh);
        c.setLayout(null);
        cursor=new Cursor(Cursor.HAND_CURSOR);
        f=new Font("Arial",Font.BOLD,16);

        p=new JPanel();
        p.setBounds(100,130,380,420);
        p.setLayout(null);
        c.add(p);

        UserNameLV=new JLabel("UserName");
        UserNameLV.setBounds(40,40,100,50);
        UserNameLV.setFont(f);
        p.add(UserNameLV);

        UserName=new JTextField();
        UserName.setBounds(40,80,300,50);
        UserName.setFont(f);
        p.add(UserName);

        PasswordLV=new JLabel("Password");
        PasswordLV.setBounds(40,130,100,50);
        PasswordLV.setFont(f);
        p.add(PasswordLV);

        password=new JPasswordField();
        password.setBounds(40,170,300,50);
        password.setFont(f);
        password.setEchoChar('*');
        p.add(password);

        logb=new JButton("LOGIN");
        logb.setBounds(40,240,300,50);
        logb.setCursor(cursor);
        logb.setFont(f);
        logb.setBackground(Color.magenta);
        p.add(logb);

        cls=new JButton("Cancel");
        cls.setBounds(40,300,300,50);
        cls.setCursor(cursor);
        cls.setFont(f);
        cls.setBackground(Color.yellow);
        p.add(cls);

        acc=new JLabel("Not an Account?");
        acc.setBounds(40,350,100,40);
        p.add(acc);

        accb=new JButton("Create Account");
        accb.setBounds(140,360,200,20);
        accb.setCursor(cursor);
        p.add(accb);

        accb.addActionListener(this);
        logb.addActionListener(this);
        cls.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username=UserName.getText();
        String pass=password.getText();
        if(e.getSource()==logb && lgd.equals("A")) {
            if (username.equals("Rakibul") && pass.equals("123")) {
                JOptionPane.showMessageDialog(null, "Login Succesfully");
                dispose();
                AdminPannel frame = new AdminPannel();
                frame.setVisible(true);
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            }
            else
                JOptionPane.showMessageDialog(null,"Oops! UserName Or Password Wrong");
        }

            if (e.getSource()==logb && lgd.equals("G")) {
                if(username.equals("Rakibul") && pass.equals("123"))
                {
                    JOptionPane.showMessageDialog(null,"Login Successfully");
                    dispose();
                    General frame=new General();
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                }
            else
                JOptionPane.showMessageDialog(null,"Oops! UserName Or Password Wrong");

        }

        if(e.getSource()==accb)
        {
            dispose();
            registration rg=new registration();
            rg.setVisible(true);
            rg.setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
        if(e.getSource()==cls)
        {
            dispose();
            DhakaCityBusRoute fr=new DhakaCityBusRoute();
            fr.setVisible(true);
            fr.setDefaultCloseOperation(EXIT_ON_CLOSE);
        }

    }
    public static void main(String[] args) {
        Login frame=new Login("A");
        frame.setVisible(true);

    }

}
