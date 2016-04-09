<%@page import="javax.servlet.descriptor.TaglibDescriptor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style> 
fieldset{
width:270px;
border: 5px solid #cef1ff;
background: #f1f5f6
}
.error {
    color: #ff0000;
    font-style: italic;
    font-weight: bold;
}


input[type=text] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    box-sizing: border-box;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register Page</title>
</head>
<body>
<jsp:include page="Home.jsp"></jsp:include>
<div align="center">
	<br />
	<springForm:form method="post" commandName="user" >
	<fieldset>
		<legend>Opening new account: </legend>
		<br/>
		<label>Choose a product:</label>
		 <select name="bank products">
           <option value="bankpr1">bankpr1</option>
           <option value="bankpr1">bankpr1</option>
         </select>
		<label>Choose currency:</label>
		<select name="curr">
           <option value="curr1">bankpr1</option>
           <option value="curr2">bankpr1</option>
         </select>
		<label>Enter initial sum:</label>
		<input type="number" value="sum" />
		<input type="submit" value="Open an account!" />
		</fieldset>
	</springForm:form>
	</div>
</body>