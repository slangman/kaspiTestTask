<%--
  Created by IntelliJ IDEA.
  User: AttenCHUN
  Date: 11.09.2018
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Send Request</title>
</head>
<body>
<div>

    <c:set var="requestForEdit" value="${requestScope.get('requestForEdit')}"/>
    <c:choose>
        <c:when test="${requestForEdit!=null}">
            <form id="editRequest" method="post" action="${pageContext.request.contextPath}/requestEdited">

                <input type="hidden" value="${requestForEdit.id}" name="requestId">

                <div class="input-group">
                    <label for="editFirstName">First name</label><br>
                    <input type="text" name="firstName" id="editFirstName" value="${requestForEdit.firstName}">
                </div>

                <div class="input-group">
                    <label for="editMiddleName">Middle name</label><br>
                    <input type="text" name="middleName" id="editMiddleName" value="${requestForEdit.middleName}">
                </div>

                <div class="input-group">
                    <label for="editSecondName">Last name</label><br>
                    <input type="text" name="secondName" id="editSecondName" value="${requestForEdit.secondName}">
                </div>

                <div class="input-group">
                    <label for="editCompanyName">Company name</label><br>
                    <input type="text" name="companyName" id="editCompanyName" value="${requestForEdit.companyName}">
                </div>

                <div class="input-group">
                    <label for="editBin">BIN (12 digits)</label><br>
                    <input type="text" name="bin" id="editBin" value="${requestForEdit.bin}">
                </div>

                <div class="input-group">
                    <label for="editMobileNumber">Mobile number (format: +7-XXX-XXXXXXX)</label><br>
                    <input type="text" name="mobileNumber" id="editMobileNumber" value="${requestForEdit.mobileNumber}">
                </div>
                <br>
                <button type="submit" class="btn btn-info btn-flat">OK</button>

            </form>
        </c:when>

        <c:otherwise>

            <form id="sendRequest" method="post" action="${pageContext.request.contextPath}/sendRequest">

                <div class="input-group">
                    <label for="firstName">First name</label><br>
                    <input type="text" name="firstName" id="firstName">
                </div>

                <div class="input-group">
                    <label for="middleName">Middle name</label><br>
                    <input type="text" name="middleName" id="middleName">
                </div>

                <div class="input-group">
                    <label for="secondName">Last name</label><br>
                    <input type="text" name="secondName" id="secondName">
                </div>

                <div class="input-group">
                    <label for="companyName">Company name</label><br>
                    <input type="text" name="companyName" id="companyName">
                </div>

                <div class="input-group">
                    <label for="bin">BIN (12 digits)</label><br>
                    <input type="text" name="bin" id="bin">
                </div>

                <div class="input-group">
                    <label for="mobileNumber">Mobile number (format: +7-XXX-XXXXXXX)</label><br>
                    <input type="text" name="mobileNumber" id="mobileNumber">
                </div>
                <br>
                <button type="submit" class="btn btn-info btn-flat">OK</button>

            </form>

        </c:otherwise>

    </c:choose>


</div>
<div class="message-box">
    <c:set var="mobileNumberMessage" value="${requestScope.get('mobileNumberMessage')}"/>
    <c:if test="${mobileNumberMessage!=null}">${mobileNumberMessage}</c:if>
    <br>
    <c:set var="binMesage" value="${requestScope.get('binMessage')}"/>
    <c:if test="${binMesage!=null}">${binMesage}</c:if>
    <br>
    <c:set var="dublicateMessage" value="${requestScope.get('duplicateMessage')}"/>
    <c:if test="${dublicateMessage!=null}">${dublicateMessage}</c:if>
    <br>
    <c:set var="requestMessage" value="${requestScope.get('requestMessage')}"/>
    <c:if test="${requestMessage!=null}">${requestMessage}</c:if>
</div>
</body>
</html>
