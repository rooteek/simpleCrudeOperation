<%-- 
    Document   : process
    Created on : 12-Dec-2023, 10:11:59 pm
    Author     : admin
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="JS/index.js"></script>

<c:if test="${process eq 'insert'}">
    <style>
        div{
            margin-bottom: 10px;
        }

    </style>
    <center>
        <form>
            <div>
                <h1>Insert New Data</h1>
                <div>
                    Enter User name
                    <input type="text" required name="name" id="uname">
                </div>
                <div>
                    Enter User Email
                    <input type="text" required name="email" id="emailId">
                </div>
                <div>
                    Enter User Password
                    <input type="text" required name="password" id="pass">
                </div><div>
                    Enter User Mobile
                    <input type="text" required name="mobile" id="phone">
                </div>
                <div>
                    Enter User Address
                    <input type="text" required name="address" id="add">
                </div>
                <button onclick="insertData()">Insert Data</button>
            </div>
        </form>
        <div id="inserData"></div>
    </center>
</c:if>
<%--<c:if test="${process eq 'update'}">
    <h1>Update</h1>
</c:if>
<c:if test="${process eq 'delete'}">
    <h1>delete</h1>
</c:if>--%>
<c:if test="${process eq 'view' or process eq 'delete' or process eq 'update'}">
    <!--<h1>view</h1>-->
    <table>

        <thead>
            <tr>
                <th>User id</th>
                <th>User Name</th>
                <th>Email</th>
                <th>Password</th>
                <th>Mobile</th>
                <th>Address</th>
            </tr>
        </thead>
        <tbody>
            <%

                ResultSet rs = (ResultSet) request.getAttribute("resultSet");
                while (rs.next()) {

            %>
            <tr>
                <td><%=rs.getInt("user_id")%></td>
                <td><%=rs.getString("uname")%></td>
                <td><%=rs.getString("email")%></td>
                <td><%=rs.getString("password")%></td>
                <td><%=rs.getString("mobile")%></td>
                <td><%=rs.getString("address")%></td>
                <c:if test="${process eq 'delete'}">
                    <td><button onclick="deleteData(this)" Did="<%=rs.getInt("user_id")%>">Delete</button></td>
                </c:if>
                <c:if test="${process eq 'update'}">
                    <td><button onclick="getaData(this)" uid="<%=rs.getInt("user_id")%>">Update</button></td>
                </c:if>
            </tr>
            <%        }
            %>
        </tbody>
    </table>
    <div id="dell"></div>
            <div id="getData"></div>

</c:if>

<c:if test="${process eq 'getData'}">
    <center>
        <form>
            <%

                ResultSet ss = (ResultSet) request.getAttribute("resultSet");
                while (ss.next()) {

            %>
            <div>
                <h1>Update New Data</h1>
                <div>
                    User ID
                    <input type="text" required name="name" id="uid" value="<%=ss.getString("user_id")%>">
                </div>
                <div>
                    Enter User name
                    <input type="text" required name="name" id="uname" value="<%=ss.getString("uname")%>">
                </div>
                <div>
                    Enter User Email
                    <input type="text" required name="email" id="emailId" value="<%=ss.getString("email")%>">
                </div>
                <div>
                    Enter User Password
                    <input type="text" required name="password" id="pass" value="<%=ss.getString("password")%>">
                </div><div>
                    Enter User Mobile
                    <input type="text" required name="mobile" id="phone" value="<%=ss.getString("mobile")%>"> 
                </div>
                <div>
                    Enter User Address
                    <input type="text" required name="address" id="add" value="<%=ss.getString("address")%>">
                </div>
                <button onclick="return editData()">Update Data</button>
            </div>
                <%
                    }%>
        </form>
        <div id="updateDa"></div>
    </center>
</c:if>
