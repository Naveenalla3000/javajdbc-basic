package level_1_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class InsertARecord {
    public static void main(String[] args) {
        try{
            Scanner scr = new Scanner(System.in);

            System.out.print("Enter the sid : ");
            int sid = scr.nextInt();

            scr.nextLine();
            System.out.print("Enter the sname : ");
            String sname = scr.nextLine();

            System.out.print("Enter the grade (1 to 5) : ");
            int rating = scr.nextInt();

            String sqlQuery = "insert into javacore values(?,?,?)";

            String url = "jdbc:postgresql://localhost:5432/javajdbc";
            String user = "postgres";
            String password = "mypasswd";

            Connection connDB = DriverManager.getConnection(url,user,password);

            PreparedStatement psm = connDB.prepareStatement(sqlQuery);
            psm.setInt(1,sid);
            psm.setString(2,sname);
            psm.setInt(3,rating);

            if(psm.executeUpdate()==1){
                System.out.println("Inserted successfully");
            }else {
                System.out.println("Error in inserting");
            }
        }
        catch (Exception e){
            System.out.println("Exception is "+e.getMessage());
        }
    }
}
