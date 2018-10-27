<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生答题记录详情列表</title>
<link rel="stylesheet" type="text/css" href="../css/public.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../css/student.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../css/style.css" media="screen" />
</head>
<body>
<div id="findstu">
	
	<table class="providerTable" cellpadding="0" cellspacing="0">
               <tr class="firstTr">
                    <th width="70%" style="text-align:left;">题目</th>                    
                    <th width="10%">答错标记</th>                   
                    <th width="20%">答题时间</th>                   
                </tr>
              
              <ul>
                 <c:if test="${!empty Answer_record }">
				<c:forEach items="${Answer_record}" var="answer_record" varStatus="loop">
				<tr>					
                    <td style="text-align:left;"> ${answer_record.que_content }</td>             
                    <td>${answer_record.error_flag }</td>                      
                    <td>${answer_record.time}	</td>    
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

</body>
</html>