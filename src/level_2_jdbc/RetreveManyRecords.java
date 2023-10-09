package level_2_jdbc;

import java.sql.*;

public class RetreveManyRecords {
    public static void main(String[] args) {
        try{
            String sqlQuery = "select * from javacore";

            String url = "jdbc:postgresql://localhost:5432/javajdbc";
            String user = "postgres";
            String password = "mypasswd";

            Connection connDB = DriverManager.getConnection(url,user,password);

            Statement pst = connDB.createStatement();

            ResultSet rs = pst.executeQuery(sqlQuery);

            if(rs.next()){
                while (rs.next()) {
                    int sid = rs.getInt("sid");
                    String sname = rs.getString("sname");
                    int grade= rs.getInt("grade");
                    System.out.println(sid+"  "+sname+"  "+grade);
                }
            }else {
                System.out.println("Error");
            }
        }
        catch (Exception e){
            System.out.println("Exception is "+e.getMessage());
        }
    }
}
