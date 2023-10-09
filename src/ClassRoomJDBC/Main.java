package ClassRoomJDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main{
    public static void main(String[] args) {
        try{
            String sqlQuery = "select sname from javacore where sid=4";

            String url = "jdbc:postgresql://localhost:5432/javajdbc";
            String user = "postgres";
            String password = "mypasswd";

            Connection connDB = DriverManager.getConnection(url,user,password);

            Statement st = connDB.createStatement();
            ResultSet rs = st.executeQuery(sqlQuery);

            rs.next();

            String result = rs.getString(1);

            System.out.println("Result is "+result);

        }
        catch (Exception e){
            System.out.println("Exception is "+e.getMessage());
        }

    }
}