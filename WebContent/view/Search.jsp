<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索</title>
<style>
table th, table td {
	padding: 1em 10px 1em 1em;
	border-right: 1px solid #bbb;
}
</style>
</head>
<body>
	<h2>検索</h2>
	<c:if test="${not empty error}">
		<div class="box">
			<div class="box-title">
				<p>${error}</p>
			</div>
		</div>
	</c:if>
	<span style="color: #ff0000;">${search_result_message}</span>
	<form action="Search" method="post">
		<input type="text" name="product_name"> <br> カテゴリ： <select
			name="category">
			<option value="">すべて</option>
			<c:forEach var="category" items="${sessionScope.catList}">
				<option value="${category.key}"><c:out
						value="${category.value.cat_name}" /></option>
			</c:forEach>
		</select> <br> <input type="submit" value="検索">
	</form>
	<c:if test="${not empty requestScope.proList}">
		<form action="ProductDetails" method="get">
			<br />
			<table border="1" style="border-collapse: collapse">
				<tr>
					<td >商品名</td>
					<td>価格</td>
					<td>在庫</td>
					<td>詳細</td>
				</tr>
				<c:forEach var="product" items="${requestScope.proList}">
					<tr>
						<td><c:out value="${product.pro_name}" /></td>
						<td align="right"><fmt:formatNumber
								value="${product.pro_price}" type="CURRENCY"
								maxFractionDigits="0" currencySymbol="¥" /></td>
						<td align="right"><fmt:formatNumber
								value="${product.stock_no}" /></td>
						<td><button type="submit" value="${product.pro_cd}"
								name="pro_cd">詳細</button></td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</c:if>
</body>
</html>