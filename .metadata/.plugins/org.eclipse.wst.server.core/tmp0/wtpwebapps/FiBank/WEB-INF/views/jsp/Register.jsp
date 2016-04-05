<%@page import="javax.servlet.descriptor.TaglibDescriptor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register Page</title>
</head>
<body>
		${text};
	<br/>
	<springForm:form method="post" commandName="user">
	<label>Enter your EGN/Bulstat:</label>
	<springForm:input type="text" path="id"/>
	<br/>
	<label>Enter your name:</label>
	<springForm:input type="text" path="name"/>
	<br/>
	<label>Enter your address:</label>
	<springForm:input type="text" path="address"/>
	<br/>
	<label>Enter your phone number:</label>
	<springForm:input type="text" path="phone"/>
	<br/>
	<label>Enter your email:</label>
	<springForm:input type="text" path="email"/>
	<br/>
	<label>Enter your password:</label>
	<springForm:input type="text" path="password"/>
	<br/>
	<br/>
	<input type="submit" value="Register as new client!"/>
	</springForm:form>
</body>
</html>