<%-- 
    Document   : list
    Created on : Mar 8, 2017, 4:58:30 PM
    Author     : Nam NV
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1px">
            <tr>
                <th>Code</th>
                <th>Name</th>
                <th>Age</th>
                <th>Address</th>
            </tr>
            <c:forEach items="${list}" var="p">
            <tr>
                <td>${p.code}</td>
                <td>${p.name}</td>
                <td>${p.age}</td>
                <td>${p.address}</td>
            </tr>
            </c:forEach>
            
            
        </table>
    </body>
</html>
