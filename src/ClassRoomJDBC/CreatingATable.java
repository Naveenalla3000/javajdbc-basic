package ClassRoomJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CreatingATable {
    public static void main(String[] args) {
        try{
            String sqlQuery = "create table products(pid int not null,pname varchar(100) not null,rating int not null)";
            String url = "jdbc:postgresql://localhost:5432/javajdbc";
            String user = "postgres";
            String password = "mypasswd";

            Connection connDB = DriverManager.getConnection(url,user,password);

            Statement st = connDB.createStatement();

            st.execute(sqlQuery);

            System.out.println("Table Products created successfully");

            connDB.close();
        }
        catch (Exception e){
            System.out.println("Exception is "+e.getMessage());
        }
    }
}
