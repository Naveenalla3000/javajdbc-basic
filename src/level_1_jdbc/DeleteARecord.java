package level_1_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteARecord {
    public static void main(String[] args) {
        try{
            Scanner scr = new Scanner(System.in);

            System.out.print("Enter the sid : ");
            int sid = scr.nextInt();

            String sqlQuery = "delete from javacore where sid=?";

            String url = "jdbc:postgresql://localhost:5432/javajdbc";
            String user = "postgres";
            String password = "mypasswd";

            Connection connDB = DriverManager.getConnection(url,user,password);

            PreparedStatement psm = connDB.prepareStatement(sqlQuery);
            psm.setInt(1,sid);

            if(psm.executeUpdate()==1){
                System.out.println("Recore deleted");
            }else{
                System.out.println("no record found with sid "+sid);
            }


        }
        catch (Exception e){
            System.out.println("Exception is "+e.getMessage());
        }
    }
}
