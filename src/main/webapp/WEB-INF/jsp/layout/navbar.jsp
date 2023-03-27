<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link href="${contextRoot}/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="${contextRoot}/">Cool App</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="${contextRoot}/">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${contextRoot}/messages/add">新增留言</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${contextRoot}/messages/page">分頁顯示</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${contextRoot}/messages/ajax">ajax Demo</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${contextRoot}/newPhoto">上傳圖片</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${contextRoot}/listGoodPhoto">查看圖片</a>
      </li>
      
    </ul>
  </div>
</nav>

<script src="${contextRoot}/js/jquery-3.6.1.min.js" type="text/javascript"></script>
<script src="${contextRoot}/js/bootstrap.bundle.min.js" type="text/javascript"></script>
</body>
</html>