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
	<h1>Welcome ${user}</h1>
	<img alt="DP" src="getdp" width="200" height="200">
	<h3>Your movie List ${movie_empty}</h3>
	<h3>${successfully_added}</h3>
	<h3>${update_message}</h3>
	<h3>${delete_message}</h3>
	<table border="1">
  		<thead>
    		<td>
    			
      			<th>Movie Name</th>
     			 <th>Comments</th>
      			<th>Rating</th>
      			<th colspan="2">Options</th>
   			 </td>
  		</thead>
 		 <tbody>
     <j:forEach items="${movie_list}" var="bean" varStatus="status">
       <tr>
       	<td>${status.count})</td>
         <td>${bean.movie_name}</td>
         <td>${bean.user_comments}</td>
         <td>${bean.movie_rating}</td>
         <td><a href="editmovieview?sl_no=${bean.sl_no}&movie_name=${bean.movie_name}&user_comments=${bean.user_comments}&movie_rating=${bean.movie_rating}">Edit</a></td>
         <td><a href="deletemovieview?sl_no=${bean.sl_no}&movie_name=${bean.movie_name}&user_comments=${bean.user_comments}&movie_rating=${bean.movie_rating}">Delete</a></td>
       </tr>
     </j:forEach>
  </tbody>
</table>
	
   <br/>
	
	<a href="openAddMovieView">Click here to add movies to your list</a> <br/>
	<a href="movie_base_view">Click to read ratings and comments of all the users</a> <br/>
	<a href="logout">Logout</a> 
</body>
</html>