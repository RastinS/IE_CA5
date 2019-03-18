<%--
  Created by IntelliJ IDEA.
  User: rastin
  Date: 2019-03-01
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
    <head>
        <title>Projects</title>
    </head>
    <body>
        <table>
            <tr>
                <th>id</th>
                <th>title</th>
                <th>budget</th>
            </tr>
            <c:forEach var="project" items="${projects}">
                <tr>
                    <td><c:out value="${project.id}"/></td>
                    <td style="direction: rtl"><c:out value="${project.title}"/></td>
                    <td><c:out value="${project.budget}"/></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
