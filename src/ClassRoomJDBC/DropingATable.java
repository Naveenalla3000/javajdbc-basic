package ClassRoomJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DropingATable {
    public static void main(String[] args) {
        try {

            String sqlQuery = "drop table products";
            String url = "jdbc:postgresql://localhost:5432/javajdbc";
            String user = "postgres";
            String password = "mypasswd";

            Connection connDB = DriverManager.getConnection(url, user, password);

            Statement st = connDB.createStatement();

            st.execute(sqlQuery);

            System.out.println("Table Droped successfully");

        }
        catch (Exception e){
            System.out.println("Exception is "+e.getMessage());
        }
    }
}
