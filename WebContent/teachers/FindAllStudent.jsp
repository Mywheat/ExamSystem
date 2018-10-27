<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>答题排名</title>

<link rel="stylesheet" type="text/css" href="../css/public.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../css/student.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../css/style.css" media="screen" />

</head>
<body>
<div id="container">
<div id="findstu">
	<table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="19%">排名序号</th>                    
                    <th width="19%">学生学号</th>                   
                    <th width="19%">学生姓名</th>
                    <th width="19%">答题次数</th>
                    <th width="19%">答题记录</th>
                </tr>
                
                <c:if test="${!empty Answer_rank }">
			<c:forEach items="${Answer_rank}" var="Answer_rank" varStatus="loop">
       			<tr>
					<td>${Answer_rank.rank_id }</td> 
                    <td>${Answer_rank.user_id }</td>
                    <td>${Answer_rank.user_name }</td>
                    <td>${Answer_rank.count}</td>              
                    <td><a href="tstudent_management?action=showStuAns&user_id=${Answer_rank.user_id }&user_name=${Answer_rank.user_name }">点击查看答题记录</a></td>                      
                        
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