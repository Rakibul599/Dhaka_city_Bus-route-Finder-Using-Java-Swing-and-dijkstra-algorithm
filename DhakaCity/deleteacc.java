package DhakaCity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class deleteacc extends JFrame implements ActionListener {
    private Container c;
    private JLabel lev,lev1;
    private JTextField t,t1;
    private  Font f;
    private JButton b1,b2;
    private JPanel p;
    deleteacc()
    {
        Cursor cursor=new Cursor(Cursor.HAND_CURSOR);
        Color wh=new Color(238,230,230);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(20,100,400,400);
        c=this.getContentPane();
        c.setLayout(null);

        p=new JPanel();
        p.setBounds(5,5,375,350);
        p.setLayout(null);
        p.setBackground(wh);
        c.add(p);
        f=new Font("arial",Font.BOLD,16);

        lev=new JLabel("Email:");
        lev.setBounds(20,80,100,50);
        lev.setFont(f);
        p.add(lev);

        t=new JTextField();
        t.setBounds(130,95,200,25);
        p.add(t);

        lev1=new JLabel("Password:");
        lev1.setBounds(20,160,100,50);
        lev1.setFont(f);
        p.add(lev1);

        t1=new JTextField();
        t1.setBounds(130,175,200,25);
        p.add(t1);

        b1=new JButton("Delete");
        b1.setBounds(50,230,100,35);
        b1.setCursor(cursor);
        p.add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(190,230,100,35);
        b2.setCursor(cursor);
        p.add(b2);

        b1.addActionListener(this);


    }
    public static void main(String[] args) {
        deleteacc frame=new deleteacc();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
        {
            DataBase db=new DataBase();
            db.connection();
            String em=t.getText();
            String pas=t1.getText();
            try {
                PreparedStatement ps = db.con.prepareStatement("DELETE FROM userinf WHERE email=?");
                ps.setString(1, em);
                int rowsAffected = ps.executeUpdate();

                PreparedStatement ps1 = db.con.prepareStatement("DELETE FROM reginf WHERE email=?");
                ps1.setString(1, em);
                int rowsAffected1 = ps1.executeUpdate();

                if (rowsAffected > 0 && rowsAffected1 > 0) {
                    JOptionPane.showMessageDialog(null, "Delete successfully ");
                } else {
                    JOptionPane.showMessageDialog(null, "Deletion failed");
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
