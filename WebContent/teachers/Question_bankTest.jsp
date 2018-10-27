<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>测试</title>
</head>
<body>
<form action="question_bankServlet">
user_id：<input type="text" name="user_id" placeholder="请输入user_id">
Que_chapter：<input type="text" name="Que_chapter" placeholder="请输入Que_chapter">
Que_type：<input type="text" name="Que_type" placeholder="请输入Que_type">
Que_content：<input type="text" name="Que_content" placeholder="请输入Que_content">
Que_options：<input type="text" name="Que_options" placeholder="请输入Que_options">
Que_answer：<input type="text" name="Que_answer" placeholder="请输入Que_answer">
<input type="submit" value="确定"/>
</form>
</body>
</html>