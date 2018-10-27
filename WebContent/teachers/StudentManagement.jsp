<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生管理答题排名</title>

<link rel="stylesheet" type="text/css" href="../css/public.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../css/student.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../css/style.css" media="screen" />
</head>
<body>
<!-- header -->
<div class="header">
 		<c:if test="${!empty UserList }">
		<c:forEach items="${UserList}" var="user" varStatus="loop">
		<p>学号：${user.user_id }   &nbsp;&nbsp;姓名：${user.user_name } </p>

		<div class="contact"><a href="LoginOut" style="text-decoration: none;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;退出</a></div>

</div>
<div class="header1">
		<p>生物判题考试管理系统</p>
		
		<div class="w1">您好，欢迎进入生物考试教师管理系统！</div>
		
		<div class="w2">
		<ul>
			<li><a href="http://localhost:8080/TestSystem/User/Testchoose.jsp#">教学公告</a></li>
			<li><a href="http://localhost:8080/TestSystem/User/ChapterPractice.jsp#">试题资源</a></li>
			<li><a href="tstudent_management?action=showCl&user_id=${user.user_id }">学生管理</a></li>
			<li><a href="http://localhost:8080/TestSystem/User/CheckTest.jsp#">统计管理</a></li>
			<li><a href="#">其他</a></li>
		</ul>
				
		</div>

</div>
<!-- header结束 -->
<div class="m1">

 	<div class="round1"><a href="tstudent_management?action=showCl&user_id=${user.user_id }">答题排名</a></div>
 	
 	<div class="round2"><a href="tstudent_management?action=showStuClass&user_id=${user.user_id }">班级管理</a></div>

</div>

<div class="m2">
	
	<br>
	<hr style="border:1px dashed green;width:67%;margin-left:15%; ">

</div>

<iframe id="findallstu" name="findallstu"  src="tstudent_management?action=showRank&user_id=${user.user_id }" frameborder="0">

</iframe>



</c:forEach>
		</c:if>
</body>
</html>