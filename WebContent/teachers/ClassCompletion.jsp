<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>班级完成情况</title>
<link rel="stylesheet" type="text/css" href="../css/public.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../css/student.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../css/style.css" media="screen" />

</head>
<body>

<div id="container">
<div id="findstu">
	
	<table class="providerTable" cellpadding="0" cellspacing="0">
			<tr>	 
                    <td width="30%">试卷名称</td>             
                    <td width="35%">截止时间</td>                      
                    <td width="20%">完成人数</td>
                    <td width="15%"></td>    
                </tr>

	       <c:if test="${!empty findExamination }">
			<c:forEach items="${findExamination}" var="findExamination" varStatus="loop">
				<tr>	 
                    <td width="30%">${findExamination.exam_name}</td>             
                    <td width="35%">${findExamination.exam_end}</td>                      
                    <td width="20%">${findExamination.user_id } / ${stu_Cnum}</td>
                    <td width="15%"><a href="tstudent_management?action=findStuStatus&exam_id=${findExamination.exam_id }&class_id=${class_id }&fnum=${findExamination.user_id }&anum=${stu_Cnum}">试卷详情</a></td>    
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