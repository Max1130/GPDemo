<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <link href="css/bootstrap.min.css" rel="stylesheet">
 <style type="text/css">
	 #submit1{
		 background-color:#00B5AD;
	 }
 </style>
<head>
 <link href="css/bootstrap.min.css" rel="stylesheet">
      <link href="css/myself.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册</title>
</head>
<body>
	<div class="container" style="margin:0px 0px; padding: 0px 0px; width: 100%">
		<div class="row clearfix"  style="background-color: #000000;width: 100%;margin:50px 0px;">
			<div class="col-md-6 column" style="width: 300px;">
				<h1 class="text-center" style="color: #FFFFFF;">
					Youyibuy
				</h1>
			</div>
			<div class="col-md-6 column" style="padding: 0px;margin-right: 200px;width: 500px;">
				<ul class="nav nav-pills" style="margin-top: 20px;" >
					<%--<li class="active">--%>
						 <%--<a href="index.jsp">首页</a>--%>
					<%--</li>--%>
					<li>
						 <a href="towebLogin.html">登录</a>
					</li>
				</ul>
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-12 column" style="padding: 0px;">
				<form class="form-horizontal" role="form" style="margin-top: 200px ;"
						action="UserRegisterServlet" method="post" onsubmit="return validate();">
					<div class="form-group" style="margin-left: 30%;">
						 <label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-10" style="width: 30%;">
							<input type="email" class="form-control" id="inputEmail3" name="userName" />
						</div>
					</div>
					<div class="form-group" style="margin-left: 30%;">
						 <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-10" style="width: 30%;">
							<input type="password" class="form-control" id="inputPassword3" name="password" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10" style="margin-left: 43%;">
							 <button id="submit1" type="submit" class="btn btn-default" style="margin-right: 100px;">注册</button>
							 <button type="reset" class="btn btn-default">重置</button>
						</div>
				</form>
			</div>
		</div>
	</div>
      <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
      <script src="js/jquery-3.2.0.min.js"></script>
      <!-- 包括所有已编译的插件 -->
      <script src="js/bootstrap.min.js"></script>
      <script type="text/javascript">
      	function validate(){
      		var email = document.getElementById("inputEmail3");
      		var password = document.getElementById("inputPassword3");
      		var nickname = document.getElementById("inputNickName3");
      		var pattern = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;

      		if(email.value==""){
      			alert("账号不能为空");
      			email.focus();
      			return false;
      		} else if(!pattern.test(email.value)){
      			alert("请输入邮箱格式的账号");
      			email.focus();
      			return false;
      		} else if(password.value==""){
      			alert("密码不能为空");
      			password.focus();
      			return false;
      		} else if(password.length<6 || password.length>16){
      			alert("密码长度不符合要求，请输入6-16位密码");
      			password.focus();
      			return false;
      		}

      		return true;
      	}
      </script>
</body>
</html>