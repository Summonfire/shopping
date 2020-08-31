<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入完了画面</title>
</head>
<body>
<h1>お買い上げありがとうございました！</h1>


<input type="button" value="買い物を続ける" onclick="history.go(-4)" />
<form action="/Shopping/Logout" name="logout" method="get">
<input type="submit" value="ログアウト">
</form>
</body>
</html>