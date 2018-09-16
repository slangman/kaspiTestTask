<%--
  Created by IntelliJ IDEA.
  User: AttenCHUN
  Date: 16.09.2018
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>View all requests</title>
</head>
<body>

    <table class="table">
        <thead>
        <tr>
            <th>Дата</th>
            <th>Компания</th>
            <th>Действие</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.get('requestsList')}" var="requestItem">
            <tr>
                <td>date</td>
                <td>${requestItem.companyName}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/viewRequest/${requestItem.id}"
                       name="${requestItem.id}">Просмотреть заявку</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="message-box">
        <c:set var="deleteMessage" value="${requestScope.get('deleteMessage')}"/>
        <c:if test="${deleteMessage!=null}">${deleteMessage}</c:if>
    </div>
</body>
</html>
