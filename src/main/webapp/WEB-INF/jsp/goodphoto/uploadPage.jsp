<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>上傳圖片</title>
</head>
<body>
<jsp:include page="../layout/navbar.jsp"></jsp:include>


<div class="container">
<h1>上傳圖片Page</h1>

<form action="fileUpload" method="post" enctype="multipart/form-data">
  Name :  <input type="text" name="photoName">
<br />
 file : <input type="file" name="file">

 <br />

 <input type="submit" value="送出">
</form>


</div>


</body>
</html>