<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>商品紹介</title>
    <style>
table th, table td {
	padding: 1em 10px 1em 1em;
	border-right: 1px solid #bbb;
}
</style>
  </head>
  <body>
    <h2>商品紹介</h2>
    <br />
    <div style="display:inline-flex">
      <img src="${requestScope.product.pro_img}" width="250" height="250">
        <div style="padding-left:50px; padding-top:30px">
        <form action="Cart" method="get">
          <table border="1" style="border-collapse: collapse">
            <tr>
              <td>商品名</td>
              <td align="right">${requestScope.product.pro_name}</td>
            </tr>
            <tr>
              <td>カテゴリ</td>
              <td align="right">${sessionScope.catList.get(product.cat_id).cat_name}
            </tr>
            <tr>
              <td>価格</td>
              <td align="right"><fmt:formatNumber value="${requestScope.product.pro_price}" type="CURRENCY" maxFractionDigits="0" currencySymbol="¥" /></td>
            </tr>
            <tr>
              <td>在庫</td>
              <td align="right"><fmt:formatNumber value="${requestScope.product.stock_no}" /></td>
            </tr>
            <tr>
              <td>商品紹介</td>
              <td align="right">${requestScope.product.pro_msg}</td>
            </tr>
          </table>
          個数
          <select name="number">
            <c:if test="${product.stock_no==0}"><option value="0">売り切れ</option></c:if>
            <c:forEach begin="1" end="${requestScope.product.stock_no}" var="i">

              <option><c:out value="${i}" /></option>
            </c:forEach>
          </select><input type="hidden" name="proCd" value="${requestScope.product.pro_cd}">
          <input type="submit" value="カートへ">
          <button type="button" onclick="history.back()">戻る</button>
        </form>
      </div>
    </div>
  </body>
</html>