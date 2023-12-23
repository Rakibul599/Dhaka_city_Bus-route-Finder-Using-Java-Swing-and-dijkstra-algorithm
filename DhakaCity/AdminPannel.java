package DhakaCity;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminPannel extends JFrame implements ActionListener {
    private Container c;
    private JPanel p1,p2;
    private JLabel wlcL,Node,Destination,nod1,nod2,weight;
    private JButton addb,updb,delb,cls,HomeB;
    private JTextField NodeF,DestinationF,nod1f,nod2F,weightF;
    private JTable table;

    private DefaultTableModel tablemodel;
    private JScrollPane sc;
    private Cursor cursor;
    String[] col={"Node","Destination_Name","Node1","Node2","Weight"};
    String[] row=new String[5];
    private Font f,f1;
    AdminPannel()
    {
        Color wh=new Color(238,230,230);
        Color btc=new Color(190,190,190);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(400,40,600,690);
        c=getContentPane();
        c.setBackground(wh);
        c.setLayout(null);
        cursor=new Cursor(Cursor.HAND_CURSOR);


        f=new Font("Arial",Font.BOLD,25);
        f1=new Font("Arial",Font.BOLD,20);

        p1=new JPanel();
        p1.setBounds(10,10,560,320);
        p1.setBackground(wh);
        p1.setLayout(null);
        c.add(p1);

        p2=new JPanel();
        p2.setBounds(10,340,560,290);
        p2.setBackground(Color.white);
        p2.setLayout(null);
        c.add(p2);


        wlcL=new JLabel("Admin pannel");
        wlcL.setBounds(200,0,300,30);
        wlcL.setFont(f);
        wlcL.setForeground(Color.BLACK);
        p1.add(wlcL);

        Node=new JLabel("Node :");
        Node.setFont(f1);
        Node.setBounds(20,60,100,40);
        p1.add(Node);

        NodeF=new JTextField();
        NodeF.setBounds(140,60,200,40);
        NodeF.setFont(f1);
        p1.add(NodeF);

        Destination=new JLabel("Destination_Name :");
        Destination.setFont(f1);
        Destination.setBounds(20,110,100,40);
        p1.add(Destination);

        DestinationF=new JTextField();
        DestinationF.setBounds(140,110,200,40);
        DestinationF.setFont(f1);
        p1.add(DestinationF);

        nod1=new JLabel("Node1 :");
        nod1.setFont(f1);
        nod1.setBounds(20,160,120,40);
        p1.add(nod1);

        nod1f=new JTextField();
        nod1f.setFont(f1);
        nod1f.setBounds(140,160,200,40);
        p1.add(nod1f);

        nod2=new JLabel("Node2 :");
        nod2.setFont(f1);
        nod2.setBounds(20,210,120,40);
        p1.add(nod2);

        nod2F=new JTextField();
        nod2F.setBounds(140,210,200,40);
        nod2F.setFont(f1);
        p1.add(nod2F);

        weight=new JLabel("Weight :");
        weight.setFont(f1);
        weight.setBounds(20,260,100,40);
        p1.add(weight);

        weightF=new JTextField();
        weightF.setFont(f1);
        weightF.setBounds(140,260,200,40);
        weightF.setCursor(cursor);
        p1.add(weightF);

        HomeB=new JButton("Logout");
        HomeB.setBounds(400,25,150,40);
        HomeB.setBackground(btc);
        HomeB.setCursor(cursor);
        HomeB.setFont(f1);
        p1.add(HomeB);

        addb =new JButton("ADD PLACE");
        addb.setBounds(400,70,150,55);
        addb.setFont(f1);
        addb.setBackground(btc);
        addb.setCursor(cursor);
        p1.add(addb);

        updb =new JButton("UPDATE");
        updb.setBounds(400,130,150,55);
        updb.setFont(f1);
        updb.setBackground(btc);
        updb.setCursor(cursor);
        p1.add(updb);

        delb=new JButton("DELETE");
        delb.setBounds(400,190,150,55);
        delb.setFont(f1);
        delb.setBackground(btc);
        delb.setCursor(cursor);
        p1.add(delb);

        cls=new JButton("CLEAR");
        cls.setBounds(400,250,150,55);
        cls.setFont(f1);
        cls.setBackground(btc);
        cls.setCursor(cursor);
        p1.add(cls);

        table=new JTable();

        tablemodel=new DefaultTableModel();
        tablemodel.setColumnIdentifiers(col);
        table.setModel(tablemodel);

        sc=new JScrollPane(table);
        sc.setBounds(0,0,560,290);
        p2.add(sc);

        HomeB.addActionListener(this);
        addb.addActionListener(this);
        updb.addActionListener(this);
        delb.addActionListener(this);
        cls.addActionListener(this);

        DataBase db=new DataBase();
        db.connection();
        loadDataFromDatabase();


        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int nub_row=table.getSelectedRow();
                String fr,to,bus,km,rent;
                fr=tablemodel.getValueAt(nub_row,0).toString();
                to=tablemodel.getValueAt(nub_row,1).toString();
                bus=tablemodel.getValueAt(nub_row,2).toString();
                km=tablemodel.getValueAt(nub_row,3).toString();
                rent=tablemodel.getValueAt(nub_row,4).toString();
                NodeF.setText(fr);
                DestinationF.setText(to);
                nod1f.setText(bus);
                nod2F.setText(km);
                weightF.setText(rent);

            }
        });

    }
    void data(String fr ,String to,String b,String km,String rent)
    {
        row[0]=fr;
        row[1]=to;
        row[2]=b;
        row[3]=km;
        row[4]=rent;
        tablemodel.addRow(row);

    }

    private void loadDataFromDatabase() {
            DataBase db=new DataBase();
            db.connection();
        try {
            PreparedStatement ps = db.con.prepareStatement("select * FROM routedb1");
            PreparedStatement ps1=db.con.prepareStatement("select *from routedb");
            ResultSet rs = ps.executeQuery();
            ResultSet rs1=ps1.executeQuery();
            while (rs.next() && rs1.next()) {
                String node1 = String.valueOf(rs.getInt("node1"));
                String node2 = String.valueOf(rs.getInt("node2"));
                String weight = String.valueOf(rs.getInt("weight"));
                String Node= String.valueOf(rs1.getInt("node"));
                String Des= rs1.getString("Destination_Name");
                System.out.println(node1);
                data(Node,Des,node1, node2, weight);
                System.out.println("success");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading data from the database");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==HomeB)
        {
            dispose();
            DhakaCityBusRoute fr=new DhakaCityBusRoute();
            fr.setVisible(true);
            fr.setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
        if(e.getSource()==addb)
        {
            if(NodeF.getText().equals("")&&DestinationF.getText().equals("")&&nod1f.getText().equals("")&&nod2F.getText().equals("")&&weightF.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Fill All Textfield");
            }
            else
            {

            row[0]=NodeF.getText();
            row[1]=DestinationF.getText();
            row[2]=nod1f.getText();
            row[3]=nod2F.getText();
            row[4]=weightF.getText();
            tablemodel.addRow(row);
            }

        }
        if(e.getSource()==updb)
        {
            int v=table.getSelectedRow();
            if(v>=0) {
                tablemodel.setValueAt(NodeF.getText(), v, 0);
                tablemodel.setValueAt(DestinationF.getText(), v, 1);
                tablemodel.setValueAt(nod1f.getText(), v, 2);
                tablemodel.setValueAt(nod2F.getText(), v, 3);
                tablemodel.setValueAt(weightF.getText(), v, 4);
                JOptionPane.showMessageDialog(null,"Update Successfully");
            }
            else JOptionPane.showMessageDialog(null,"Not Selected Row");
        }
        if(e.getSource()==delb)
        {
            int v=table.getSelectedRow();
            if(v>=0)
            {
                tablemodel.removeRow(v);
            }
            else JOptionPane.showMessageDialog(null,"Not Selected Row");
        }
        if(e.getSource()==cls)
        {
            NodeF.setText("");
            DestinationF.setText("");
            nod1f.setText("");
            nod2F.setText("");
            weightF.setText("");
        }

    }
    public static void main(String[] args) {

        AdminPannel frame=new AdminPannel();
        frame.setVisible(true);

    }

}
