<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Bean.ProductBean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>確認画面</title>
<style>
table th, table td {
	padding: 1em 10px 1em 1em;
	border-right: 1px solid #bbb;
}
</style>
</head>
<body>
<h1>購入してよろしいでしょうか？</h1>
<table border="1" style="border-collapse: collapse">
<tr><th>商品名</th><th>単価</th><th>数量</th></tr>
<c:set value="0" var="price" /><c:forEach var="product" items="${sessionScope.cart}">
<tr><td>${product.pro_name}</td>
<td align="right"><fmt:formatNumber value="${product.pro_price}" type="CURRENCY" maxFractionDigits="0" currencySymbol="¥" /></td>
<td>${product.stock_no}</td>
</tr>
<c:set var="price" value="${price+product.pro_price*product.stock_no}" />
 </c:forEach>
<tr><th colspan="2">消費税</th><td>
<fmt:formatNumber value="${price*0.1}" type="CURRENCY" maxFractionDigits="0" currencySymbol="¥" /></td></tr>
<tr><th colspan="2">合計金額</th><td>
<fmt:formatNumber value="${price*1.1}" type="CURRENCY" maxFractionDigits="0" currencySymbol="¥" /></td></tr>
</table><table border="0">
<tr><td><form action="Confirmation" method="get"><input type="submit" value="はい"></form></td>
<td> <input type="button" value="いいえ" onclick="history.go(-3)" /></td></tr>
</table>
</body>
</html>