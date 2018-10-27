<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>table examination</title>
<link rel="stylesheet" type="text/css" href="../css/1.css" />
<link rel="stylesheet" type="text/css"
	href="../bootstrap-3.3.7-dist/css/bootstrap.min.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
<script type="text/javascript">
	function examination() {
		$.ajax({
			type : "POST",
			url : "examinationServlet",
			data : $('#form').serialize(),
			success : function(data) {
				window.location.href = 'que_exam.jsp';  // 跳转到题库分页页面 
				alert("Return:" + data);
				var arraydata = eval(data);
				alert("Analysis:" + arraydata);
			}
		})
	}

	function msgbox(n) {
		document.getElementById('inputbox').style.display = n ? 'block'
				: 'none'; /* 点击按钮打开/关闭 对话框 */
	}
	
</script>
</head>
<body>
	<%
		Integer user_id = (Integer) session.getAttribute("user_id");
		System.out.println();
		session.setAttribute("user_id", user_id);
	%>
	<div class="header">
	<c:if test="${!empty UserList }">
		<c:forEach items="${UserList}" var="user" varStatus="loop">
		<p>学号：${user.user_id }   &nbsp;&nbsp;姓名：${user.user_name } </p>

		<div class="contact"><a href="LoginOut" style="text-decoration: none;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;退出</a></div>
	</c:forEach>
	</c:if>
		
	</div>
	
	
	<div class="header1">
		<p>生物判题考试管理系统</p>
		<br> <br> <br>
		<div class="w2">
			<ul>
				<li><a
					href="http://localhost:8080/TestSystem/User/Testchoose.jsp#" target="_top">教学公告</a></li>
				<li><a href="http://localhost:8080/TestSystem/User/ChapterPractice.jsp#" target="_top">试题资源</a></li>
				<li><a href="http://localhost:8080/TestSystem/User/Test.jsp#" target="_top">学生管理</a></li>
				<li><a href="http://localhost:8080/TestSystem/User/CheckTest.jsp#" target="_top">统计管理</a></li>
				<li><a href="#" target="_top">修改密码</a></li>
			</ul>
		</div>
	</div>	
	<br>
	

	<div class="c">
		<div class="c3">试题</div><div class="c3">试卷</div>
		
		<div class="c4">
			<a href="#" onClick="msgbox(1)">+</a>
		</div>
		<form id="form">
			<div id='inputbox' class="box" style="position: absolute; z-index: 1000">
				<a class='x' href='' onclick="msgbox(0); return false;">关闭</a> 
				<input type="text" name="num" id="num" placeholder="请输入试卷题目数量"> <!-- 试卷的试题数 -->
				<input type="text" name="exam_name" id="exam_name" placeholder="请输入试卷名"> 
				<input type="text" name="exam_begin" id="exam_begin" placeholder="请输入考试开始时间"> 
				<input type="text" name="exam_end" id="exam_end" placeholder="请输入考试结束时间"> 
				<button type="button" onclick="examination()">添加试题</button>
			</div>
		</form>
		<!--  	<p>
	    <input type="submit" name="submit" value="添加试题" onclick="openwin()" />-->
		<!-- 题库分页显示页面 -->

		<br> <br> <br> <br> <br>
		<div>---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</div>
	</div>
		<br>
</body>
</html>