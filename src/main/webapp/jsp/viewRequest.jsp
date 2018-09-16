<%--
  Created by IntelliJ IDEA.
  User: AttenCHUN
  Date: 16.09.2018
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>View request</title>
</head>
<body>
<c:set var="requestForView" value="${requestScope.get('requestForView')}"/>
<c:if test="${requestForView!=null}">
    <table class="table">
        <tr>
            <td>Компания</td><td>${requestForView.companyName}</td>
        </tr>
        <tr>
            <td>БИН компании</td><td>${requestForView.bin}</td>
        </tr>
        <tr>
            <td>Ф.И.О. контактного лица</td><td>${requestForView.firstName} ${requestForView.middleName} ${requestForView.secondName}</td>
        </tr>
        <tr>
            <td>Телефон:</td><td>${requestForView.mobileNumber}</td>
        </tr>
    </table>
    <br>
    <a href="${pageContext.request.contextPath}/editRequest/${requestForView.id}">Редактировать</a>
    <br>
    <a href="${pageContext.request.contextPath}/deleteRequest/${requestForView.id}">Удалить</a>
</c:if>
<div class="message-box">
    <c:set var="deleteMessage" value="${requestScope.get('deleteMessage')}"/>
    <c:if test="${deleteMessage!=null}">${deleteMessage}</c:if>
</div>
</body>
</html>
