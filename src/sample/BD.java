package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BD {


    public static Connection connection;

    public static void c(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/pharmacie";
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost/pharmacie?useUnicode=true&characterEncoding=UTF-8&useSSL=false","root","0000");
            System.out.println("connect");
            Statement statement=con.createStatement();
            connection= con;
        } catch (Exception e){
            System.out.println(e.getMessage());
            connection=  null;
        }
    }

    public static Connection connect()  {
        return connection;
    }
}
