<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
function upload() {
	$.ajax({
		type:"POST",
		url:"TestServlet",
		data:$('#form').serialize(),
		success:function(data){
			alert("Return:"+data);
			var arraydata = eval(data);
			alert("Analysis:"+arraydata);
		}
	})
}
</script>
<title>Ajax_Json_test</title>
</head>
<body>
	<!-- <form id="form">
        Userid:<input type="text" name="user_id" id="user_id">
        PassWord:<input type="password" name="password" id="password">
        <button type="button" onclick="upload()">提交</button>
    </form>
     -->  
     
     	<form action="TestServlet" method="post">
			Userid:<input type="text" name="user_id" id="user_id">
        	PassWord:<input type="password" name="password" id="password">
        	<input type="submit" value="登录" ></input> 
       </form>
</body>
</html>