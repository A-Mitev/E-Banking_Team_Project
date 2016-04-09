<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="springForm"
	uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style> 
fieldset{
width:270px;
border: 5px solid #cef1ff;
background: #f1f5f6
}

input[type=text] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    box-sizing: border-box;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Code Confirmation</title>
</head>
<body>
		
		${hello}
		
		<springForm:form action="./test" method="post" commandName="ressetPassClient">
		<fieldset style="width:270px">
		
		<label>Please enter your confirmationCode!</label>
		<springForm:input path="code"/>
		<br/>
		<input type="submit" value="Continue" />
		
		</fieldset>
		</springForm:form> 
	
</body>
</html>