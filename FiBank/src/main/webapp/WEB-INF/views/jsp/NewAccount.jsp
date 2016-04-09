<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new account</title>
<style>
.error {
 color: #ff0000;
}
 
.commonerrorblock {
 color: #000;
 background-color: #ffEEEE;
 border: 3px solid #ff0000;
 
}
</style>
</head>
<body>
<jsp:include page="Home.jsp"></jsp:include>
<div align="center">
${text}
 <form:form method="post"  commandName="combined">
 <form:errors path="*" element="div" cssClass="commonerrorblock"/>
 <table>
 <tr>
 <td>Bank products: </td>
 <td>
 <form:select path="description">
 <form:option value="" />
 <form:options items="${bankProducts}"/>
 </form:select>
 </td>
 <td>
 <form:errors path="description" cssClass="error"/>
 </td>
 </tr>
 <tr>
 <td>Currency: </td>
 <td>
 <form:select path="currency">
 <form:option value="" />
 <form:options items="${currency}"/>
 </form:select>
 </td>
 <td>
 <form:errors path="description" cssClass="error"/>
 </td>
 </tr>
  <tr>
 <td>Initial sum: </td>
 <td>
 <form:input type="number" path="currency"/>
 </td>
 <td>
 <form:errors path="currency" cssClass="error"/>
 </td>
 </tr>
 <tr>
 <td></td><td><input type="submit" value="Add new account!"></td>
 </tr>
 </table>	
 </form:form>
 </div>
</body>
</html>