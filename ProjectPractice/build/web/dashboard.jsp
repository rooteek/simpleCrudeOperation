<%-- 
    Document   : dashboard
    Created on : 12-Dec-2023, 10:08:03 pm
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String sess = (String)session.getAttribute("username");
            if (session.getAttribute("username") == null) {
                response.sendRedirect("loginPage.jsp");
            }
        %>

        <h1>Hello World! <%= sess%></h1>
        <button onclick="processData('insert')">Add</button>
        <button onclick="processData('view')">View</button>
        <button onclick="processData('update')">Update</button>
        <button onclick="processData('delete')">Delete</button>
        <button onclick="LogoutUser()">Logout</button>

        <div id="ajax"></div>
        <script src="JS/index.js"></script>
    </body>
</html>
