package ClassRoomJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateATable {
    public static void main(String[] args) {
        try{
            String sqlQuery = "update javacore set sname='for and while loop' where sid=5";
            String url = "jdbc:postgresql://localhost:5432/javajdbc";
            String user = "postgres";
            String password = "mypasswd";

            Connection connDB = DriverManager.getConnection(url, user, password);

            Statement st = connDB.createStatement();

            st.execute(sqlQuery);

            System.out.println("Updated successfully");
        }
        catch (Exception e){
            System.out.println("Exception is "+e.getMessage());
        }
    }
}
