package DhakaCity;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class General extends JFrame implements ActionListener {
    private Container c;

    private JPanel p,p1,p2;
    private JLabel imgl,wlc,FromL,ToL;
    private JTextField From,To;
    private JTextArea TR;
    private JButton Search,cls;
    private Cursor cursor;
    private ImageIcon img;
    private Font f,f1;
    int C=0;
    private  static int[][] arr = new int[100][100];

    General()
    {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(400,40,600,690);
        c=getContentPane();
        c.setBackground(Color.white);
        c.setLayout(null);
        f=new Font("Arial",Font.BOLD,20);
        f1=new Font("Arial",Font.BOLD,16);
        cursor =new Cursor(Cursor.HAND_CURSOR);


        p=new JPanel();
        p.setBounds(5,5,575,270);
        p.setBackground(Color.white);
        c.add(p);

        p1=new JPanel();
        p1.setBounds(5,275,575,200);
        p1.setBackground(Color.white);
        p1.setLayout(null);
        c.add(p1);

        p2=new JPanel();
        p2.setBounds(5,470,575,175);
        p2.setBackground(Color.white);
        p2.setLayout(null);
        c.add(p2);

        img =new ImageIcon(getClass().getResource("busmap.png"));
        Image imgn=img.getImage();
        Image imgnn=imgn.getScaledInstance(p.getWidth(),p.getHeight(),Image.SCALE_SMOOTH);
        img=new ImageIcon(imgnn);
        imgl=new JLabel(img);
        p.add(imgl);

        wlc=new JLabel("Dhaka City Bus Route Finder");
        wlc.setBounds(120,-5,400,40);
        wlc.setFont(f);
        wlc.setForeground(Color.black);
        p1.add(wlc);

        FromL=new JLabel("From :");
        FromL.setBounds(120,30,200,40);
        FromL.setFont(f1);
        p1.add(FromL);

        From=new JTextField();
        From.setBounds(180,30,190,40);
        From.setFont(f1);
        p1.add(From);

        ToL=new JLabel("To :");
        ToL.setBounds(120,80,200,40);
        ToL.setFont(f1);
        p1.add(ToL);

        To=new JTextField();
        To.setBounds(180,80,190,40);
        To.setFont(f1);
        p1.add(To);

        cls=new JButton("Logout");
        cls.setBounds(490,20,80,30);
        Color wh=new Color(238,230,230);
        cls.setBackground(wh);
        cls.setCursor(cursor);
        p1.add(cls);

        Search =new JButton("Search");
        Search.setBounds(200,130,150,40);
        Search.setFont(f1);
        Search.setBackground(Color.green);
        Search.setCursor(cursor);
        p1.add(Search);

        TR=new JTextArea();
        TR.setLineWrap(true);
        TR.setWrapStyleWord(true);
        TR.setBounds(5,5,565,175);
        Color wh1=new Color(250,241,241);
        TR.setBackground(wh1);
        TR.setFont(f1);
        p2.add(TR);


        Search.addActionListener(this);
        cls.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==cls)
        {
            dispose();
            DhakaCityBusRoute fr=new DhakaCityBusRoute();
            fr.setVisible(true);
            fr.setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
        if(e.getSource()==Search)
        {
            TR.setText("");
            if(From.getText().isEmpty()&&To.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Your Textfield is Emty");
            }
            else {
                int f = 0, a = 0;
                int node=12,edge=15;
                String p = From.getText();
                String p1 = To.getText();
                DataBase db=new DataBase();
                shortestpath srp=new shortestpath();
                db.connection();
                try {
                    PreparedStatement psc=db.con.prepareStatement("select node from routedb where Destination_Name=?");
                    PreparedStatement psd=db.con.prepareStatement("select node from routedb where Destination_Name=?");
                    psc.setString(1,p);
                    psd.setString(1,p1);
                    ResultSet rs=psc.executeQuery();
                    ResultSet rd=psd.executeQuery();
                    rs.next();
                    rd.next();
                    int src=rs.getInt("node");
                    int ds=rd.getInt("node");
//                    JOptionPane.showMessageDialog(null,"Rakib"+rs.getInt("node"));
                    PreparedStatement psrdb1=db.con.prepareStatement("select * from routedb1");
                    ResultSet rsdb1=psrdb1.executeQuery();
                    for (int i = 0; i < node; i++) {
                        for (int j = 0; j < node; j++) {
                            arr[i][j] = 0;
                        }
                    }
                    while (rsdb1.next()){
                        int u=rsdb1.getInt("node1");
                        int v=rsdb1.getInt("node2");
                        int w=rsdb1.getInt("weight");
                        arr[u][v]=arr[v][u]=w;
                        System.out.println(u+"--"+v+"--"+w);
                    }
                    for (int i = 0; i < node; i++) {
                        for (int j = 0; j < node; j++) {
                            System.out.print(arr[i][j] + " ");
                        }
                        System.out.println();
                    }
                    System.out.println("source:"+src+" "+ds);
                   int[] sort =srp.dijkstra(arr,src,ds,node,edge);
                    System.out.println("RR"+sort.length);
                    int l=sort.length;
                    int[] res1=new int[100];
                    int c=0;
                    for (int i=0;i<l;i++)
                    {
                       res1[c++]=sort[i];
                    }
                    PreparedStatement out=db.con.prepareStatement("select Destination_Name from routedb where node=?");
                    for (int i=c-1;i>=0;i--)
                    {
                        int t=res1[i];
                        out.setInt(1,t);
                        ResultSet rso=out.executeQuery();
                        rso.next();
                        String ss=rso.getString("Destination_Name");
                        System.out.println(res1[i]+" ");
                        System.out.println(ss+" ");
                        TR.append(ss+">>");

                    }
                    TR.append("\n");
                    int kmm=srp.GetKilomiter();
                    TR.append("Total Kilometers: " + kmm);
                    int ren=kmm*3;
                    TR.append("\n");
                    TR.append("Total Rent: "+ren);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        }

    }
    public static void main(String[] args) {
        General frame=new General();
        frame.setVisible(true);
    }

}
