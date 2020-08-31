<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<style>

</style>
</head>
<body>
<h1>ログイン</h1>
<h3>名前とパスワードを入力して下さい。</h3>
<c:if test="${not empty error}">
<div class="box">
<div class="box-title">
<p>${error}</p>
</div></div></c:if>
<form action="/Shopping/Login" method="post">
<table>
  <tr>
    <td align="right"><b>名前</b></td>
    <td><input type="text" name="cd" size="30" maxlength="20"></td>
  </tr>
  <tr>
    <td align="right"><b> パスワード</b></td>
    <td><input type="text" name="pass" size="30" maxlength="22"></td>
  </tr><tr>
    <td></td>
    <td>
      <input type="submit" value="LOGIN">
      <input type="reset" value="RESET">
    </td>
  </tr></table></form>
</body>
</html>
