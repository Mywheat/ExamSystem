<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<%@ page import="java.util.*"%> 
<%@ page import="java.text.*"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>������Դ</title>
<link rel="stylesheet" type="text/css" href="../css/1.css" />
</head>
<body>
<%
String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()); //��ȡϵͳʱ�� 
String exam_name = (String)session.getAttribute("exam_name");
Integer tea_id = (Integer)session.getAttribute("user_id");
//String date = (String)session.getAttribute("date");
System.out.println("lllllllllll"+exam_name+" "+tea_id);
%>

<div class="c6">
</div>
<div class="c7">
 <!--        2017-2018(1) xxx����-->  
 <%= exam_name%>
    
    <select id="kind1" name="kind1"  style="margin-left:200px;">
    <option value="ȫ����Դ">ȫ����Դ</option>
    <option value="δ������Դ">δ������Դ</option>
    </select>
</div>
<div class="c8">
�ϴ���:&nbsp;<%=tea_id %>&nbsp;|&nbsp;
�ϴ�ʱ��:&nbsp;<%=date %>&nbsp;&nbsp;
<a href="insertExam_Class.jsp">��Ӱ༶</a>
</div>
<br>
<div class="c9">-------------------------------------------------------------------------------</div>


</body>
</html>