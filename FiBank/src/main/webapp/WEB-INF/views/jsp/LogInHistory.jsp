<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.text.SimpleDateFormat" %>
<%@ page errorPage="error.jsp" %>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LogInHistory</title>
</head>
<body>
<jsp:include page="Home.jsp"></jsp:include>
 <div class="container">

        <h2>Log In History</h2>
        <table class="table table-striped">
            <thead>
            <tr>
				<th>SenderIBAN</th>
                <th>ReceiverIBAN</th>
                <th>SUM</th>
                <th>CURRENCY</th>
                <th>DATE</th>
            </tr>
            </thead>
            <tbody>
			<c:forEach var="transaction" items="${transactions}">
			<tr>
			<td>${transaction.getIbanSender}</td>
			<td>${transaction.getIbanReceiver}</td>
			<td>${transaction.getSum}</td>
			<td>${transaction.getCurrency}</td>
			<td>${new SimpleDateFormat().format(transaction.getDate())}</td>
			</tr>
		    </c:forEach>
            </tbody>
        </table>

    </div>
</body>
</html>