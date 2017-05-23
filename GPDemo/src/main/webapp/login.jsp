<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <link href="css/bootstrap.min.css" rel="stylesheet">
 <link rel="stylesheet" href="css/jquery-ui.css">
 <style type="text/css">
	 #submit1{
		 background-color:#00B5AD;
	 }
	 #submit1:hover{
		 background-color: #009C95;
	 }
 </style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
</head>
<body>
	<div class="container" style="margin:0px 0px; padding: 0px 0px; width: 100%">
		<div class="row clearfix"  style="background-color: #000000;width: 100%;margin: 50px 0px;">
			<div class="col-md-6 column" style="width: 300px;">
				<h1 class="text-center" style="color: #FFFFFF;">
					优宜拜
				</h1>
			</div>
			<div class="col-md-6 column" style="padding: 0px;margin-right: 200px;width: 500px;">
				<ul class="nav nav-pills" style="margin-top: 20px;" >
 					<li>
 						 <a href="index.html" style="color: #FFFFFF;">首页</a>
					</li>
					<li>
						 <a href="towebRegister.html" style="color: #FFFFFF;">注册</a>
					</li>
				</ul>
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-12 column" style="padding: 0px;">
				<form class="form-horizontal" role="form" style="margin-top: 150px ;"
						action="webLogin.html" method="post" onsubmit="return validate();">
					<div class="form-group" style="margin-left: 30%;">
						 <label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-10" style="width: 30%;">
							<input type="text" class="form-control" id="inputEmail3"
								name="userName" placeholder="请输入用户名..."
								   onkeyup="clearSpan();"
							/><span class="required" style="color: red;">${noUser }</span>
						</div>
					</div>
					<div class="form-group" style="margin-left: 30%;">
						 <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-10" style="width: 30%;">
							<input type="password" class="form-control" id="inputPassword3"
								   onkeyup="clearSpan();"
								name="password" placeholder="请输入6-16位密码"/><span class="required" style="color: red;">${pwWrong }</span>
						</div>
					</div>
					<div class="form-group" style="margin-left: 30%;">
						<div class="col-sm-offset-2 col-sm-10">
							<div class="checkbox">
								 <label><input type="checkbox" />Remember me</label>
							</div>
						</div>
					</div>
					<div class="form-group" style="margin-left: 42%;">
						<div class="col-sm-offset-2 col-sm-10" style="margin: 0px;">
							 <button id="submit1" type="submit" class="btn btn-default" style="margin-right: 100px;">登录</button>
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
//          $("input").focus(function(){
//              $("span")[0].innerText="";
//              $("span")[1].innerText="";
//          });
		function clearSpan() {
            $("span")[0].innerText="";
              $("span")[1].innerText="";
        }


      	function validate(){
      		var email = document.getElementById("inputEmail3");
      		var password = document.getElementById("inputPassword3");

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

      		}

      		return true;
      	}
      </script>
	<div type="hidden" id="dialog-message" title="提示信息">
		<p id="content"></p>
	</div>
</body>
</html>