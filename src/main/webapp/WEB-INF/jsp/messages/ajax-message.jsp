<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../layout/navbar.jsp"></jsp:include>

<div class="container">
 <h1>Ajax + Restful Page</h1>

 <input type="text" id="myMessage">
 <button id="submitBtn">送出</button>
 
 <div>
   <table class="mytable" id="list_table_json">
    <thead>
      <tr>
          <th>留言內容</th>
          <th>時間</th>
      </tr>
    </thead>
   </table>
 </div>
</div>


<script>
  $(document).ready(function(){
      $('#submitBtn').click(function(){
          var inputText = document.getElementById('myMessage').value;
          var dtoObj = {"message":inputText}
          var dtoJsonString= JSON.stringify(dtoObj);

          $.ajax({
              url:'http://localhost:8081/my-app/api/postMessage',
              contentType: 'application/json; chartset=UTF-8',  // 送過去的格式
              method: 'post',
              dataType: 'json', // 回傳的資料型別
              data: dtoJsonString,
              success: function(result){
                  console.log(result);
                  $('#list_table_json tbody tr td').remove();
                  msg_data = '<tbody>'
                  $.each(result, function(index, value){
                    msg_data += '<tr>'
                    msg_data += '<td>' + value.text + '</td>'
                    msg_data += '<td>' + value.added + '</td>'
                    msg_data += '</tr>'
                  })
                  msg_data += '</tbody>';
                  $('#list_table_json').append(msg_data)

              },
              error: function(err){
                  console.log(err);
              }
          })



      })
  })


</script>

</body>
</html>