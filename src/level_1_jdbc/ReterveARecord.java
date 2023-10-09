package level_1_jdbc;

import java.sql.*;
import java.util.Scanner;

public class ReterveARecord {
    public static void main(String[] args) {
        try{

            Scanner scr = new Scanner(System.in);

            System.out.print("Enter the sid : ");
            int inputSId = scr.nextInt();

            String sqlQuery = "select sname from javacore where sid=?";

            String url = "jdbc:postgresql://localhost:5432/javajdbc";
            String user = "postgres";
            String password = "mypasswd";

            Connection connDB = DriverManager.getConnection(url,user,password);

            PreparedStatement pst = connDB.prepareStatement(sqlQuery);
            pst.setInt(1,inputSId);


            ResultSet rs = pst.executeQuery();

            if(rs.next()){

                String result = rs.getString(1);

                System.out.println("Result is "+result);

            }else{
                System.out.println("No record with sid "+inputSId);
            }

        }
        catch (Exception e){
            System.out.println("Exception is "+e.getMessage());
        }
    }
}
