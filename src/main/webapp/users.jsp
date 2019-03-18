<%--
  Created by IntelliJ IDEA.
  User: rastin
  Date: 2019-03-01
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
    <head>
        <title>Users</title>
    </head>
    <body>
        <table>
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Job Title</th>
            </tr>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td><c:out value="${user.id}"/></td>
                    <td><c:out value="${user.firstName}"/></td>
                    <td><c:out value="${user.lastName}"/></td>
                    <td><c:out value="${user.jobTitle}"/></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
