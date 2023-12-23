package DhakaCity;

import java.sql.*;

public class DataBase {
    private ResultSet rsm,rsm1;
    Connection con;

    void connection()
    {
        String user="root";
        String password="";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             con= DriverManager.getConnection("jdbc:mysql://localhost/dhakacitybus",user,password);
            PreparedStatement pst=con.prepareStatement("select * FROM routedb");
            PreparedStatement pst1= con.prepareStatement("SELECT * from routedb1");
            rsm=pst.executeQuery();
            rsm1=pst1.executeQuery();

            System.out.println("Database connected");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        DataBase db=new DataBase();
        db.connection();
    }
}
