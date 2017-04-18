<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
<style type="text/css">
body{
  background-position:center;
/*   background-image:url("images/03.jpg"); */
}   
form{
    border:1px solid #ccc;
    width:570px;
    height:450px;
    margin: 0px auto;
    background-position:center;
/*     background-image:url("images/01.jpg"); */
    margin-top: 200px;
    padding-left: 25px;
    font-weight: bolder;
  }
  p{
    margin:30px;
    font-size: 25px;
  }
  input{
    width:150px;
    height:30px;
  }
 a{
  font-size: 15px;
 }
</style>
<script type="text/javascript">

</script>
</head>
<body>
<div class="d">

<div class="d1"></div>
<div class="d2">
  <form action="webLogin.html" method="post">
    <p>账户: <input type="text" name="Uname"/><a style="color:red" > 30长度的字母、数字、下划线</a></p>
    <span id="name_span"></span>
    <p>
    <input type="submit" value="登录" name="enter" id=""/>
    </p>
  </form>
  </div>
 </div> 
</body>
</html>