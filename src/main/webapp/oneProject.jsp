<%--
  Created by IntelliJ IDEA.
  User: Farid
  Date: 2019-03-03
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Project ${project.title}</title>
</head>
<body>
<ul>
    <li>ID : <c:out value="${project.id}"/></li>
    <li>Title : <c:out value="${project.title}"/></li>
    <li>Description : <c:out value="${project.description}"/></li>
    <li>Budget : <c:out value="${project.budget}"/></li>
    <li>Deadline : <c:out value="${project.deadline}"/></li>
    <li>Image : <img style="width: 100px" src="<c:out value="${project.imageUrl}"/>"></li>
    <li> Skills :
        <ul>
            <c:forEach var="skill" items="${project.skills}">
                <li><c:out value="${skill.name} : ${skill.point}"/></li>
            </c:forEach>
        </ul>
    </li>
    <li> Bids :
        <ul>
            <c:if test="${not empty project.bids}">
                <c:forEach var="bid" items="${project.bids}">
                    <li>
                        <span>User : <c:out value="${user.firstName} ${user.lastName}"/></span>
                        <span> -> </span>
                        <span>BidAmount : <c:out value="${bid.bidAmount}"/></span>
                    </li>
                </c:forEach>
            </c:if>
            <c:if test="${empty project.bids}">
                <li>No Bids !</li>
            </c:if>
        </ul>
    </li>
</ul>
<form action="addBid" method=GET>
    <input type="number" placeholder="Enter Your suggestion bid for this project" name="bidAmount">
    <input type="hidden" name="userId" value="${user.id}">
    <input type="hidden" name="projectId" value="${project.id}">
    <input type="submit" value="Add Bid">
</form>
<c:if test="${not empty msg}">
    <h3 style="color: red;"><c:out value="${msg}"/></h3>
</c:if>
</body>
</html>
