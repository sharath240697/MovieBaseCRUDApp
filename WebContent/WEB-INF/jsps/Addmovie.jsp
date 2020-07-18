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
<h3><a href="openuserhomeview">Home</a>  <a href="logout">Logout</a></h3>

<h1>Yo add your favourite movie here!</h1><br/>
${error_adding}<br/>
<s:form action = "addmovie" modelAttribute="movie_bean">
Enter Movie name: <s:input path="movie_name"/><s:errors path="movie_name"/><br/>
Enter Comment: <s:textarea path="user_comments"/><s:errors path="user_comments"/><br/>
Enter Rating: <s:input path="movie_rating"/><s:errors path="movie_rating"/><br>
<input type="submit" value="Add">
</s:form>
</body>
</html>