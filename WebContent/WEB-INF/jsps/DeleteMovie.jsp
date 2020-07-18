<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form"  prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3><a href="openuserhomeview">Home</a>  <a href="logout">Logout</a></h3>
<s:form action="deletemovie" modelAttribute="movie_bean">
Movie id: <input type="text" name="sl_no" value=${movie_bean.sl_no} readonly><br/>
Movie name: <s:input path="movie_name"/><br/>
Comments: <s:textarea path="user_comments"/><br/>
Rating: <s:input path="movie_rating"/><br/>
<br/>
<input type="submit" value="Confirm Delete">
</s:form>
</body>
</html>