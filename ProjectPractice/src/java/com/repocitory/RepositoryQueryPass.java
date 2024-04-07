
package com.repocitory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositoryQueryPass {
    
    String path="jdbc:mysql://localhost:3306/rut";
    String username="root";
    String password="root";
    PreparedStatement pstm;
    ResultSet rs;
    Connection con;
    
    
    public ResultSet showData() throws SQLException,ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(path, username, password);
        String query="select * from curd";
        pstm=con.prepareStatement(query);
        rs=pstm.executeQuery();
        return rs;
    }
    public int deleteData(String id) throws SQLException{
        con=DriverManager.getConnection(path, username, password);
        String query="delete from curd where user_id=?";
        pstm=con.prepareStatement(query);
        pstm.setString(1, id);
        int status=pstm.executeUpdate();
        return status;
    }
    public int insertData(String name,String email,String passwo,String mobile,String add) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(path, username, password);
        String query="insert into curd(uname,email,password,mobile,address) values(?,?,?,?,?)";
        pstm=con.prepareStatement(query);
        pstm.setString(1, name);
        pstm.setString(2, email);
        pstm.setString(3, passwo);
        pstm.setString(4, mobile);
        pstm.setString(5, add);
        int status=pstm.executeUpdate();
        return status;
    }
    public ResultSet getData(String id) throws SQLException,ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(path, username, password);
        String query="select * from curd where user_id=?";
        pstm=con.prepareStatement(query);
        pstm.setString(1, id);
        rs=pstm.executeQuery();
        return rs;
    }
    
    public int updataData(String name,String email,String pass,String mobile,String add,String id) throws SQLException, ClassNotFoundException{
//       Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(path, username, password);
        String query="update curd set uname=?,email=?,password=?,mobile=?,address=? where user_id=?";
        pstm=con.prepareStatement(query);
        pstm.setString(1, name);
        pstm.setString(2, email);
        pstm.setString(3, pass);
        pstm.setString(4, mobile);
        pstm.setString(5, add);
        pstm.setString(6, id);
        int status=pstm.executeUpdate();
        return status;
    }   
}
