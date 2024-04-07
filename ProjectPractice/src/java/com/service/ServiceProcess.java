/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.repocitory.RepositoryQueryPass;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class ServiceProcess {

    RepositoryQueryPass repoQuery = new RepositoryQueryPass();

    public ResultSet showData() throws SQLException, ClassNotFoundException {
        return repoQuery.showData();
    }

    public int deleteData(String id) throws SQLException {
        return repoQuery.deleteData(id);
    }
     public int insertData(String name,String email,String password,String mobile,String add) throws SQLException,ClassNotFoundException{
         return repoQuery.insertData(name, email, password, mobile, add);
     }
     public ResultSet getData(String id) throws SQLException,ClassNotFoundException{
         return repoQuery.getData(id);
     }
     public int updataData(String name,String email,String pass,String mobile,String add,String id) throws SQLException,ClassNotFoundException{
         return repoQuery.updataData(name, email, pass, mobile, add,id);
     }
}
