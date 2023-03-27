<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顯示圖片</title>
</head>
<body>
<jsp:include page="../layout/navbar.jsp"></jsp:include>

<div class="container">
<h1>查看所有圖片</h1>

<table>
  <c:forEach var="onePhoto" items="${goodPhotoList}">
    <tr>
       <td>${onePhoto.photoName}</td>
       <td><img width="100px" src="${pageContext.request.contextPath}/downloadImage/${onePhoto.id}" /></td>
    </tr>
  
  </c:forEach>


</table>

</div>

</body>
</html>