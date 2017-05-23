<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <link href="css/bootstrap.min.css" rel="stylesheet">
 <style type="text/css">
	 #submit1{
		 background-color:#00B5AD;
	 }
	 #submit1:hover{
		 background-color: #009C95;
	 }
	 li:hover{
		color: #000000;
	 }
 </style>
<head>
 <link href="css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="css/jquery-ui.css">
      <link href="css/myself.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册</title>
</head>
<body>
	<div class="container" style="margin:0px 0px; padding: 0px 0px; width: 100%">
		<div class="row clearfix"  style="background-color: #000000;width: 100%;margin:50px 0px;">
			<div class="col-md-6 column" style="width: 300px;">
				<h1 class="text-center" style="color: #FFFFFF;">
					优宜拜
				</h1>
			</div>
			<div class="col-md-6 column" style="padding: 0px;margin-right: 200px;width: 500px;fon">
				<ul class="nav nav-pills" style="margin-top: 20px;" >
					<li >
						<%--class="active"--%>
						 <a href="index.html" style="color: #FFFFFF;">首页</a>
					</li>
					<li>
						 <a href="towebLogin.html" style="color: #FFFFFF;">登录</a>
					</li>
				</ul>
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-12 column" style="padding: 0px;">
				<form class="form-horizontal" role="form" style="margin-top: 150px ;"
						action="webRegister.html" method="post" onsubmit="return validate();">
					<div class="form-group" style="margin-left: 30%;">
						 <label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-10" style="width: 30%;">
							<input type="text" class="form-control" id="inputEmail3" name="userName"
								   onkeyup="clearSpan();"
								   placeholder="请输入用户名..."/>
							<span class="required" style="color: red;">${hasUser }</span>
						</div>
					</div>
					<div class="form-group" style="margin-left: 30%;">
						 <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-10" style="width: 30%;">
							<input type="password" class="form-control" id="inputPassword3" name="password"
								   onkeyup="clearSpan();"
								   placeholder="请输入6-16位密码"/>
							<span class="required" style="color: red;">${pwWrong }</span>
						</div>
					</div>
					<div class="form-group" style="margin-left: 30%;">
						<label for="inputPassword3" class="col-sm-2 control-label">确认密码</label>
						<div class="col-sm-10" style="width: 30%;">
							<input type="password" class="form-control" id="inputPassword4" name="password2"
								   placeholder="请确认密码..."/>
							<span class="required" style="color: red;"></span>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10" style="margin-left: 43%;">
							 <button id="submit1" type="submit" class="btn btn-default" style="margin-right: 100px;">注册</button>
							 <button type="reset" class="btn btn-default">重置</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
      <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
      <script src="js/jquery-3.2.0.min.js"></script>
      <!-- 包括所有已编译的插件 -->
      <script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.js"></script>
	<script src="js/jquery-ui.js"></script>
      <script type="text/javascript">

          function clearSpan() {
              $("span")[0].innerText="";
              $("span")[1].innerText="";
          }

          function validate(){
              var email = document.getElementById("inputEmail3");
              var password = document.getElementById("inputPassword3");
			  var confirmPwd = document.getElementById("inputPassword4");
              if(email.value==""){
                  $("#content").text("用户名不能为空!");
                  $( "#dialog-message" ).dialog({
                      modal: true,
                      buttons: {
                          Ok: function() {
                              $( this ).dialog( "close" );
                              email.focus();
                          }
                      }
                  });

                  return false;
              } else if(password.value==""){
                  $("#content").text("密码不能为空!");
                  $( "#dialog-message" ).dialog({
                      modal: true,
                      buttons: {
                          Ok: function() {
                              $( this ).dialog( "close" );
                              password.focus();
                          }
                      }
                  });
                  return false;
              } else if (confirmPwd.value == ""){
                  $("#content").text("确认密码不能为空!");
                  $( "#dialog-message" ).dialog({
                      modal: true,
                      buttons: {
                          Ok: function() {
                              $( this ).dialog( "close" );
                              confirmPwd.focus();
                          }
                      }
                  });
                  return false;
			  } else if(password.value != confirmPwd.value){
                  $("#content").text("请保持两次密码一致!");
                  $( "#dialog-message" ).dialog({
                      modal: true,
                      buttons: {
                          Ok: function() {
                              $( this ).dialog( "close" );
                              confirmPwd.focus();
                          }
                      }
                  });
                  return false;
			  }

              return true;
          }
      </script>
	<div type="hidden" id="dialog-message" title="提示信息">
		<p id="content"></p>
	</div>
</body>
</html>