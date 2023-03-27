<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增留言</title>
</head>
<body>
<jsp:include page="../layout/navbar.jsp"></jsp:include>

<div class="container">
<h1>新增留言頁面</h1>


<div class="card">
  <div class="card-header">
    新增訊息
  </div>
  <div class="card-body">
     <form:form action="${contextRoot}/messages/add" method="post" modelAttribute="workMessages">
       <div class="input-group">
         <form:textarea path="text" class="form-control"/>
       </div>
       <input type="submit" name="submit" value="送出">
     </form:form>
  </div>
</div>

<br />

<div class="card">
  <div class="card-header">
    最新訊息，時間 :<span><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss EEEE" value="${latestMsg.added}"/></span>
  </div>
  <div class="card-body">
     ${latestMsg.text}
  </div>
</div>


</div>

</body>
</html>