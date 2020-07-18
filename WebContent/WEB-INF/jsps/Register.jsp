<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sp" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="sc" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
	<h1>Register</h1>
	
	<sp:form method="post" action="register" modelAttribute="reg" enctype="multipart/form-data">
		${register_message} <br/>
		Enter name: <sp:input path="uname"/><sp:errors path="uname"/><br/>
		Enter email: <sp:input path="email"/><sp:errors path="email"/><br/>
		Enter password: <sp:password path="pass"/><sp:errors path="pass"/><br/>
		Repeat password: <sp:password path="rpass"/><sp:errors path="rpass"/>${pass_error_msg} <br/> 
		Upload Pic: <input type="file" name=pic>  ${pic_message}
		
		<br/>
		
		<input type="submit" value="Register"/>
		
	</sp:form>
	
</body>
</html>










