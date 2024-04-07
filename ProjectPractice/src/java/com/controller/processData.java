package com.controller;

import com.service.ServiceProcess;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class processData extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ServiceProcess serviProces =new ServiceProcess();
        
        PrintWriter out = response.getWriter();
        String process = request.getParameter("process");
        RequestDispatcher rd;
        ResultSet rs;
        try {

            if (process.equals("view")||process.equals("delete")||process.equals("update")) {
                rs=serviProces.showData();
                request.setAttribute("process", process);
                request.setAttribute("resultSet", rs);
                rd = request.getRequestDispatcher("process.jsp");
                rd.forward(request, response);
            }
            if(process.equals("dele")){
                String element=request.getParameter("element");
                int status=serviProces.deleteData(element);
                out.print(status);
            }
            if (process.equals("insert") ) {
                request.setAttribute("process", process);
                rd = request.getRequestDispatcher("process.jsp");
                rd.forward(request, response);
            }
            if(process.equals("insData")){
                String name=request.getParameter("name");
                String email=request.getParameter("email");
                String pass=request.getParameter("password");
                String mobile=request.getParameter("mobile");
                String address=request.getParameter("address");
                int status=serviProces.insertData(name, email, pass, mobile, address);
                out.print(status);
            }
            if(process.equals("getData")){
                String id =request.getParameter("id");
                rs = serviProces.getData(id);
                request.setAttribute("process", process);
                request.setAttribute("resultSet", rs);
                rd = request.getRequestDispatcher("process.jsp");
                rd.forward(request, response);
            }
            if(process.equals("updataData")){
                String id=request.getParameter("id");
                String name=request.getParameter("name");
                String email=request.getParameter("email");
                String pass=request.getParameter("password");
                String mobile=request.getParameter("mobile");
                String address=request.getParameter("address");
                int status=serviProces.updataData(name, email, pass, mobile, address,id);
                out.print(status);
            }
            
            
        } catch (Exception ex) {
            System.out.println("The Error is :--->" + ex.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
