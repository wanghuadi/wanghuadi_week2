<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath() %>/css/css.css" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
	function shenhe(id){
		var status = $("#status").val()
		alert(status);
		$.post("updateStatus",{"id":id,"status":status},function(data){
			if(data){
				alert('审核成功!');
				location.href="querAll";
			}else{
				alert('审核失败!');
			}
		})
		
	}
</script>
</head>
<body>

	<form action="#">
		关键字:<input type="text" value="${inspection.keyword }">	描述:<input type="text" value="${inspection.mes }"> <br><br>
		编号:<input type="text" value="${inspection.id }">		公司名称:<input type="text" value="${inspection.name }"><br><br>
		主营产品:<input type="text" value="${inspection.product }">		地址:<input type="text" value="${inspection.address }"><br><br>
		注册资本:<input type="text" value="${inspection.capital }">		成立时间:<input type="date" value="<fmt:formatDate value="${inspection.idate }" pattern="yyyy-MM-dd"/>"><br><br>
		年检日期:<input type="date" value="<fmt:formatDate value="${inspection.inspection_time }" pattern="yyyy-MM-dd"/>"><br><br>
		${inspection.status.name }
		年检状态:<select id="status">
				<option value="通过" <c:if test="${inspection.status.name == '通过' }">selected="selected"</c:if>>通过</option>
				<option value="未通过" <c:if test="${inspection.status.name == '未通过' }">selected="selected"</c:if>>未通过</option>
				<option value="待审核" <c:if test="${inspection.status.name == '待审核' }">selected="selected"</c:if>>待审核</option>
			  </select><br><br>
		备注:<textarea rows="10" cols="10">${inspection.remark }</textarea>
		<input type="button" value="审核" onclick="shenhe('${inspection.id }')">
	</form>
	
	
</body>
</html>