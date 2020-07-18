<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Login!</h1><br/>
${register_message}<br/>
${loginerror_message}<br/>
<s:form action="login" modelAttribute="log_bean">
Enter Email-id: <s:input path="email"/><s:errors path="email"/><br/>
Enter Password: <s:password path="password"/><s:errors path="password"/><br/>

<input type="submit" value="Log In"/>

</s:form>

</body>
</html>