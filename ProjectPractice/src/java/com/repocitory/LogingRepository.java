
package com.repocitory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogingRepository {
    String path="jdbc:mysql://localhost:3306/rut";
    String username="root";
    String password="root";
    Connection con;
    public int checkValidation(String name,String pass) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(path, username, password);
        String query="select count(*) from curd where uname=? and password=?";
        PreparedStatement pstm=con.prepareStatement(query);
        pstm.setString(1, name);
        pstm.setString(2, pass);
        ResultSet rs=pstm.executeQuery();
        int status=0;
        if(rs.next()){
            status=rs.getInt(1);
        }
        return status;
    }
}
