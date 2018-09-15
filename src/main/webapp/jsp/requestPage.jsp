<%--
  Created by IntelliJ IDEA.
  User: AttenCHUN
  Date: 11.09.2018
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Send Request</title>
</head>
<body>
<div>
    <form id="sendRequest" method="post" action ="${pageContext.request.contextPath}/sendRequest">

        <div class="input-group">
            <label for = "firstName">First name</label><br>
            <input type="text" name="firstName" id="firstName">
        </div>

        <div class="input-group">
            <label for = "middleName">Middle name</label><br>
            <input type="text" name = "middleName" id = "middleName">
        </div>

        <div class="input-group">
            <label for = "secondName">Last name</label><br>
            <input type="text" name="secondName" id = "secondName">
        </div>

        <div class="input-group">
            <label for = "companyName">Company name</label><br>
            <input type="text" name="companyName" id = "companyName">
        </div>

        <div class="input-group">
            <label for = "bin">BIN (12 digits)</label><br>
            <input type="text" name="bin" id = "bin">
        </div>

        <div class="input-group">
            <label for = "mobileNumber">Mobile number (format: +7-XXX-XXXXXXX)</label><br>
            <input type="text" name="mobileNumber" id = "mobileNumber">
        </div>
        <br>
        <button type="submit" class="btn btn-info btn-flat">OK</button>

    </form>
</div>
<div class="message-box">
    <c:set var="mobileNumberMessage" value="${requestScope.get('mobileNumberMessage')}"/>
    <c:if test="${mobileNumberMessage!=null}">${mobileNumberMessage}</c:if>
    <br>
    <c:set var="binMesage" value="${requestScope.get('binMesage')}"/>
    <c:if test="${binMesage!=null}">${binMesage}</c:if>
    <br>
    <c:set var="dublicateMessage" value="${requestScope.get('dublicateMessage')}"/>
    <c:if test="${dublicateMessage!=null}">${dublicateMessage}</c:if>
    <br>
    <c:set var="requestMessage" value="${requestScope.get('requestMessage')}"/>
    <c:if test="${requestMessage!=null}">${requestMessage}</c:if>
</div>
</body>
</html>
