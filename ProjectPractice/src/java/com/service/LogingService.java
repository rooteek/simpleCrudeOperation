/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.repocitory.LogingRepository;
import java.sql.SQLException;

public class LogingService {
    LogingRepository logRepo=new LogingRepository();
    public int checkValidation(String name,String pass) throws SQLException,ClassNotFoundException{
         return logRepo.checkValidation(name, pass);
     }
}
