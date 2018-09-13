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
    <form id="sendRequest" method="post" action ="${pageContext.request.contextPath}/sendReques">

        <div class="input-group">
            <label for = "firstName">First name</label>
            <input type="text" name="firstName" id="firstName">
        </div>

        <div class="input-group">
            <label for = "middleName">Middle name</label>
            <input type="text" name = "middleName" id = "middleName">
        </div>

        <div class="input-group">
            <label for = "lastName">Last name</label>
            <input type="text" name="lastName" id = "lastName">
        </div>

        <div class="input-group">
            <label for = "companyName">Company name</label>
            <input type="text" name="companyName" id = "companyName">
        </div>

        <div class="input-group">
            <label for = "bin">BIN</label>
            <input type="text" name="bin" id = "bin">
        </div>

        <div class="input-group">
            <label for = "mobileNumber">Mobile number</label>
            <input type="text" name="mobileNumber" id = "mobileNumber">
        </div>

        <label for="taskDescription">Task description</label>
        <input type="text" id="taskDescription" name="taskDescription">

        <button type="submit" class="btn btn-info btn-flat">OK</button>

    </form>
</body>
</html>
