package level_1_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdataARecord {
    public static void main(String[] args) {
        try{
            Scanner scr = new Scanner(System.in);

            System.out.print("Enter the sid to updata :");
            int inputSid = scr.nextInt();

            scr.nextLine();
            System.out.print("Enter the new sname: ");
            String inputSname = scr.nextLine();

            String sqlQuery = "update javacore set sname=? where sid=?";

            String url = "jdbc:postgresql://localhost:5432/javajdbc";
            String user = "postgres";
            String password = "mypasswd";

            Connection connDB = DriverManager.getConnection(url,user,password);

            PreparedStatement pst = connDB.prepareStatement(sqlQuery);
            pst.setString(1,inputSname);
            pst.setInt(2,inputSid);

            if(pst.executeUpdate()==1){
                System.out.println("Updated successfully");
            }else{
                System.out.println("No recored found with sid"+inputSid);
            }

        }
        catch (Exception e){
            System.out.println("Exception is "+e.getMessage());
        }
    }
}
