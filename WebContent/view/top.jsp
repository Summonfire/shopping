<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login and signup</title>
<style>

body {

  background-image: url("/EC/A/StacksofWheat(EndofSummer)(1).jpg");
  background-repeat: no-repeat;
   background-position:center bottom;                     /* 画像の表示位置を指定 */
    background-size:cover;                                 /* 画像のサイズを指定  */
    width:100%;                                            /* 横幅のサイズを指定  */
    height:600px;
}

#login{
   text-align:center;

}

#popup{
  width:30%;

  background: linear-gradient(170deg, rgba(#eef, 0.8), rgba(#ccf, 0.3));

  box-sizing:border-box;
  display:none;
  position:fixed;
  top:50%;
  left:50%;
  -webkit-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}
label{
  display:block;
}
label span{
  display:block;
  background-color:#dcdcdc;
  color:#fff;
  width:200px;
  text-align:center;
}
input[type="checkbox"]{
  display:none;
}

input[class="pop"]:checked + #popup{
  display:block;
  transition:.2s;
}

input, text, textarea {
color: #dcdcdc;
}
input, text, textarea {
color: #dcdcdc;
}
.button {
  display       : inline-block;
  border-radius : 6%;          /* 角丸       */
  font-size     : 11pt;        /* 文字サイズ */
  text-align    : center;      /* 文字位置   */
  cursor        : pointer;     /* カーソル   */
  padding       : 3px 7px;   /* 余白       */
  background    : #f5deb3;     /* 背景色     */
  color         : #fff;     /* 文字色     */
  line-height   : 1em;         /* 1行の高さ  */
  transition    : .3s;         /* なめらか変化 */

}
.button:hover {
  color         : #6666ff;     /* 背景色     */
  background    : #ffffff;     /* 文字色     */
}

CSS
ul{
display: table;
margin: 0 auto;
padding: 0;
width: 100%;
text-align: center;
}
ul li{
display: table-cell;
min-width: 50px;
}
ul li a{
display: block;
width: 100%;

text-decoration: none;
color: #555;
font-weight: bold;
}
ul li.current{
background-color: #DEEBF7;
}
ul li.current a{
color: #555;
}
ul li:hover{
background-color: #FFF2CC;
}

</style>
</head>
<body>

<form class="contact-form row" role="search" action="/search" method="get"> <div class="form-field col x-50">
      <input type="text" name="key" class="search-module-input" value="" placeholder="search">
      <input type="submit" value="&#xf01a" class="button" style="font-family:blogicon;transform:rotateY(180deg);font-size: 130%;width: 1.3em;margin-bottom: -2px;">
</div></form>

<nav>
<ul>
<li class=”current”><a href=”#”>Home</a></li>
<li><a href=”#”>news</a></li>
<li><a href=”#”>about</a></li>
<li><a href=”#”>collection  </a></li>

</ul>
</nav><br><br><br>


<div id="login">
<form action="Login" method="post">
<input type="text" name="name" value="login name">
<input type="text" name="pass" value="login password">
<input type="submit" class="button" value="send">
</form></div>

<label>
  <center><span>sigh up</span></center>
  <input type="checkbox" class="pop" name="checkbox">
<div id="popup">
<br><br><br><br><br><br><br><br>
<form action="Signup" method="post">
<p><input type="text" name="name" value="name" required></p>
<p>
male<input type="radio" name="gender" value="male">
female<input type="radio" name="gender" value="female">
other<input type="radio" name="gender" value="other">
</p>
<p><input type="text" name="nationallity" value="nationallity"></p>
<p><input type="text" name="cardno" value="card no"></p>
<p><input type="text" name="pass" value="password" required></p>
<p><input type="submit" class="button" value="send"></p>
</form></div>
</label>


</body>
</html>
