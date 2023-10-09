package level_2_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class RecordsOFMaxRating {
    public static void main(String[] args) {
        try{
            StringBuffer sqlStrb =
                    new StringBuffer("select * from javacore where grade = (select max(grade) from javacore)");

            String url = "jdbc:postgresql://localhost:5432/javajdbc";
            String user = "postgres";
            String password = "mypasswd";

            Connection connDB = DriverManager.getConnection(url,user,password);

            Statement pst = connDB.createStatement();
            ResultSet rs = pst.executeQuery(String.valueOf(sqlStrb));

            if(rs.next()){
                while (rs.next()){
                    int sid = rs.getInt("sid");
                    String sname = rs.getString("sname");
                    int grade = rs.getInt("grade");
                    System.out.println(sid+"  "+sname+"  "+grade);
                }
            }else{
                System.out.println("Error in geting maximum record");
            }

        }
        catch (Exception e){
            System.out.println("Exception is "+e.getMessage());
        }
    }
}
