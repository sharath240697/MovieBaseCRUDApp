<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j"%>
    <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3><a href="openuserhomeview">Home</a>  <a href="logout">Logout</a></h3>
<h3>${movie_empty}</h3>

<table border="1">
  		<thead>
    		<td>
    			<th>User</th>
      			<th>Movie Name</th>
     			 <th>Comments</th>
      			<th>Rating</th>
   			 </td>
  		</thead>
 		 <tbody>
     <j:forEach items="${movie_list}" var="bean" varStatus="status">
       <tr>
       	<td>${status.count})</td>
       	 <td>${bean.name}
         <td>${bean.movie_name}</td>
         <td>${bean.user_comments}</td>
         <td>${bean.movie_rating}</td>
       </tr>
     </j:forEach>
  </tbody>
</table>
</body>
</html>