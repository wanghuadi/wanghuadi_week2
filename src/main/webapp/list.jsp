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
</head>
<body>
	
	
	<form action="querAll" method="post">
		编号:<input type="text" name="id">
		关键字:<input type="text" name="keyword">
		描述:<input type="text" name="mes">
		公司名称:<input type="text" name="name">
		主营产品:<input type="text" name="product">
		地址:<input type="text" name="address">
		注册资本:<input type="text" name="startCapital">~<input type="text" name="endCapital">
		成立时间:<input type="text" name="startIdate">~<input type="text" name="endIdate">
		<input type="submit" value="查询">
	</form>
	
	<table>
		<tr>
			<td>编号</td>
			<td>关键字</td>
			<td>描述</td>
			<td>公司名称</td>
			<td>主营产品</td>
			<td>地址</td>
			<td>注册资本</td>
			<td>成立时间</td>
			<td>年检日期</td>
			<td>年检状态</td>
			<td>备注</td>
			<td>操作</td>
		</tr>
	<c:forEach items="${page.list }" var="i">
		<tr>
			<td>${i.id }</td>
			<td>${i.keyword }</td>
			<td>${i.mes }</td>
			<td>${i.name }</td>
			<td>${i.product }</td>
			<td>${i.address }</td>
			<td>${i.capital }</td>
			<td>
				<fmt:formatDate value="${i.idate }" pattern="yyyy-MM-dd"/>
			</td>
			<td>
				<fmt:formatDate value="${i.inspection_time }" pattern="yyyy-MM-dd"/>
			</td>
			<td>${i.status.getName() }</td>
			<td>${i.remark }</td>
			<td>
				<a href="queryById?id=${i.id }"><input type="button" value="年检审核"></a>
			</td>
		</tr>
	</c:forEach>
	
	<tr>
		<td colspan="20">
			共${page.total }数据/共${page.pages }页
			
			<c:forEach begin="1" end="${page.pages }" step="1" var="num">
				<a href="?pageNum=${num }">${num }</a>
			</c:forEach>
			
		</td>
	</tr>
	</table>
</body>
</html>