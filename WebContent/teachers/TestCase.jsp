<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>试卷详情</title>

<link rel="stylesheet" type="text/css" href="../css/public.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../css/student.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../css/style.css" media="screen" />

</head>
<body>
<div id="container">
<div id="findstu">
	<div class="reture">
	<button type="button" class="qr"><a href="http://localhost:8080/ExamSys/teachers/ClassCompletion.jsp">返回</a></button>
	</div>
	<table class="providerTable" cellpadding="0" cellspacing="0">
	                
                
       				
       				
       			<tr class="firstTr">                                     
                    <th style="text-align:left;">完成人数：${fnum}  总人数：${anum}</th>                  
                </tr>
                <tr class="firstTr">                                     
                    <th width="33%">学生学号</th>                   
                    <th width="33%">学生姓名</th>
                    <th width="33%">完成情况</th>                   
                </tr>
				  <c:if test="${!empty StuFinishStatus }">
				<c:forEach items="${StuFinishStatus}" var="StuFinishStatus" varStatus="loop">
					
                <tr>
                	<td>${StuFinishStatus.user_id }</td>
                    <td>${StuFinishStatus.user_name }</td>
                    <td>${StuFinishStatus.status}</td>  
                </tr>

       			</c:forEach>
				</c:if>
            </table>
            
<div class="m3">
	<div class="paging"><a href="#">尾页</a></div>
	<div class="paging"><a href="#">下一页</a></div>
	<div class="paging"><a href="#">1</a></div>
	<div class="paging"><a href="#">上一页</a></div>
	<div class="paging"><a href="#">首页</a></div>
</div>	
</div>
</div>



</body>
</html>