<%--
  Created by IntelliJ IDEA.
  User: rastin
  Date: 2019-03-01
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
    <head>
        <title>User <c:out value="${user.id}"/></title>
    </head>
    <body>
        <ul>
            <li>ID : <c:out value="${user.id}"/></li>
            <li>First Name : <c:out value="${user.firstName}"/></li>
            <li>Last Name : <c:out value="${user.lastName}"/></li>
            <li>Job Title : <c:out value="${user.jobTitle}"/></li>
            <li>Bio : <c:out value="${user.bio}"/></li>
            <li>Profile Picture : <img src="<c:out value="${user.profilePictureURL}"/>" alt="Profile Picture"></li>
            <c:choose>
                <c:when test="${canEndorse == 'no'}">
                        <li> Skills :
                            <ul>
                                <c:forEach var="skill" items="${user.skills}">
                                    <li>
                                        <c:out value="${skill.name} : ${skill.point}"/>
                                        <form action="removeSkill" method=GET style="margin-left: 1rem; display: inline">
                                            <input type="hidden" name="userId" value="${user.id}">
                                            <input type="hidden" name="skillName" value="${skill.name}">
                                            <input type="submit" value="delete skill">
                                        </form>
                                    </li>
                                </c:forEach>
                            </ul>
                        </li>
                    </ul>
                    <form action="addSkill" method=GET>
                        <input type="text" name="skillName" placeholder="Enter new skill name to add"/>
                        <input type="submit" value="add"/>
                    </form>
                </c:when>
                <c:when test="${canEndorse == 'yes'}">
                        <li> Skills :
                            <ul>
                                <c:forEach var="skill" items="${user.skills}">
                                    <li>
                                        <c:out value="${skill.name} : ${skill.point}"/>
                                        <form action="endorse" method=GET>
                                            <input type="hidden" name="skillName" value="${user.id} ${skill.name}">
                                            <input type="submit" name="endorse" value="Endorse">
                                        </form>
                                    </li>
                                </c:forEach>
                            </ul>
                        </li>
                    </ul>
                </c:when>
            </c:choose>
            <c:if test="${not empty msg}">
                <h3><c:out value="${msg}"/></h3>
            </c:if>
    </body>
</html>
