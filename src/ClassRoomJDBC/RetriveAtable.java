package ClassRoomJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class RetriveAtable {
    public static void main(String[] args) {
        try{

            String sqlQuery = "Select * from javacore";
            String url = "jdbc:postgresql://localhost:5432/javajdbc";
            String user = "postgres";
            String password = "mypasswd";

            Connection connDB = DriverManager.getConnection(url, user, password);

            Statement st = connDB.createStatement();

            ResultSet rs = st.executeQuery(sqlQuery);

           while (rs.next()){
               int sid = rs.getInt("sid");
               String topic = rs.getString("sname");
               int grade = rs.getInt("grade");

               System.out.println("  sid  "+ sid+"    sname  "+topic+"      grade"+grade);
           }

        }
        catch (Exception e){
            System.out.println("Exception is "+e.getMessage());
        }
    }
}
