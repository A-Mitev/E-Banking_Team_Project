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
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TransactionHistory</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="Home.jsp"></jsp:include>
 <div class="container">

        <h2>Transactions history</h2>
        <table class="table table-striped">
            <thead>
            <tr>
				<th>SenderIBAN</th>
                <th>ReceiverIBAN</th>
                <th>SUM</th>
                <th>CURRENCY</th>
                
            </tr>
            </thead>
            <tbody>
			<c:forEach var="transaction" items="${transactions}">
			<tr>
			<td><c:out value="${transaction.ibanSender}"/></td>
			<td><c:out value="${transaction.ibanReceiver}"/></td>
			<td><c:out value="${transaction.sum}"/></td>
			<td><c:out value="${transaction.currency}"/></td>
			</tr>
		    </c:forEach>
            </tbody>
        </table>

    </div>
</body>
</html>