<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>GrassLiuCommunity</title>
<link type="text/css" rel="stylesheet" media="all" href="styles/index.css" />
<link type="text/css" rel="stylesheet" media="all" href="styles/post.css"/>
<!-- <script type="text/javascript" src="js/BasePage.js"></script> -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<script src="js/uploadPreview.js" type="text/javascript"></script>
<script type="text/javascript">
	window.onload = function () { 
    	new uploadPreview({ UpBtn: "up_img", DivShow: "imgdiv", ImgShow: "imgShow" });
	}
	function checkData(){
// 		alert(1);
		//获取参数
// 		var Uname = $("#Uname_text").val().trim();
		var inviname = $("#inviname_text").val().trim();
		var Content = $("#content_textarea").val().trim();
		$("#Uname_span").html("*");
		$("#inviname_span").html("* 50长度的字母、数字、汉字和下划线的组合");
		$("#content_span").html("100长度的字母、数字、汉字和下划线的组合");
		
// 		alert("Uname:"+Uname);
		
		//正则表达式
		//字母、数字、汉字和下划线的组合
		var reg = /[\u4e00-\u9fa5_a-zA-Z0-9]/;
		//格式检测
// 		if (Uname == "") {
// 			$("#Uname_span").html("发帖人不能为空");
// 			return false;
// 		}
		if (inviname == "") {
			$("#inviname_span").html("帖子标题不能为空");
			return false;
		}else if (!reg.test(inviname)) {
			$("#inviname_span").html("标题包含不合法字符");
			return false;
		}else if (inviname.length > 50) {
			$("#inviname_span").html("标题不超过50个字符");
			return false;
		}
		if (Content.length > 100) {
			$("#content_span").html("内容不超过100个字符");
			return false;
		}
		
		return true;
	}
</script>
</head>
<body>
	<!-- header开始 -->
	<div id="header">
		<img alt="logo" src="images/logo.png" onclick="location.href='find.invition?isIn=1';">
		<c:import url="../logo_in.jsp"></c:import>
	</div>
	<!-- header结束 -->
	<!-- body开始 -->
	<div id="body">
		<!-- 导航区开始 -->
		<div id="navigation">
			<a href="#"><p id="to_top"></p></a>
		</div>
		<!-- 导航区结束 -->
		<form action="addPost.invition" method="post" onsubmit="return checkData();" enctype="multipart/form-data">
<!-- 		  style="display: none;" -->
<!-- 			<div class="text_info"> -->
<!-- 				<span>发帖人：</span>	 -->
<!-- 			</div> -->
<!-- 			<div> -->
<!-- 				<input type="text" id="Uname_text" class="width300" name="Uname" /> -->
<!-- 				<span id="Uname_span" class="required">*</span> -->
<!-- 			</div> -->
			<div class="text_info">
				<span>帖子名称：</span>
			</div>
			<div class="input_info">
				<input type="text" id="inviname_text" class="width300" name="inviname" /> 
				<span id="inviname_span" class="required">* 50长度的字母、数字、汉字和下划线的组合</span>
			</div>
			<div class="text_info">
				<span>帖子类型：</span>
			</div>
			<div class="input_info invi_type">
				<input type="radio" name="inviType" value="0" id="story" checked/> 
					<label for="story">小说</label> 
				<input type="radio" name="inviType" value="1" id="tvPlay"/> 
					<label for="tvPlay">电视剧</label>
				<input type="radio" name="inviType" value="2" id="movies"/> 
					<label for="movies">电影</label> 
				<input type="radio" name="inviType" value="3" id="other" /> 
					<label for="other">其他</label>
			</div>
			<div class="text_info">
				<span>帖子内容：</span>
			</div>
			<div class="input_info_high">
				<textarea length="100" name="Content" id="content_textarea" class="width300 height70"></textarea>
				<span id="content_span" class="required">100长度的字母、数字、汉字和下划线的组合</span>
			</div>
			<div>
				图片: <a href="javascript:;" class="file">选择文件
    					<input type="file" name="file"  id="up_img">
					</a>
					<img id="imgShow" width="150px;" />
				<span id="img_span" class="required">可选发图片</span>
			</div>
			<div class="button_info">
				<input type="submit" id="send" value="发帖" class="btn_save"/>
				<!-- 
                    	取消按钮的事件：
                    		超链接：location.href='toIndex.invition';
                    		或者历史记录：history.back();
                     -->
				<input type="button" id="cancel" value="取消" class="btn_save"
					onclick="location.href='find.invition?isIn=1';" />
			</div>
		</form>
	</div>
	<!-- body开始 -->
	<div id="foot">
		<p align="center">这是一个交易网站</p>
		<p align="center">在这里可以进行交流,资源购买</p>
	</div>
</body>
</html>