<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/18
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>OMG!</title>
            <meta http-equiv="Content-Type" name="viewport" content="width=device-width, initial-scale=1.0;text/html;charset=utf-8">
            <!-- 引入 Bootstrap -->
            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/myself.css" rel="stylesheet">

            <!-- HTML5 Shim 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
            <!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
            <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
            <![endif]-->
        </head>
<body>
<div class="container" style="margin:0px 0px; padding: 0px 0px; width: 100%">
    <div class="row clearfix"  style="margin-top: 50px;background-color: #000000;width: 100%;margin:50px 0px;">
        <div class="col-md-6 column" style="width: 300px;">
            <h1 class="text-center" style="color: #FFFFFF;">
                优宜拜
            </h1>
        </div>
        <div class="col-md-6 column" style="padding: 0px;margin-right: 200px;width: 300px;">
            <ul class="nav nav-pills" style="margin-top: 20px;" >
                <li>
                    <a href="index.html" style="color: #FFFFFF;">首页</a>
                </li>
                <li style="color: #FFFFFF;">
                    <%
                        String Uname = (String)session.getAttribute("Uname");
                        System.out.print(Uname);
                        String url = "towebLogin.html";
                        if(Uname!=null && !Uname.equals("")){
                            url = "";
                            Uname = "["+Uname+"]";
                        }else{
                            Uname = "登录";
                        }
                    %>
                    <a href= <%=url %> style="color: #FFFFFF;"><%=Uname %></a>
                </li>
                <li style="color: #FFFFFF;">
                    <%
                        if(session.getAttribute("Uname")!=null){
                    %>
                    <a href="logout.html" style="color: #FFFFFF;">退出</a>
                    <%
                        }
                    %>
                </li>
                <!-- 					<li > -->
                <!-- 						 <a href="ReplaceFilterServlet">管理仓库</a> -->
                <!-- 						 <a href="manageGoods.jsp">管理仓库</a> -->
                <!-- 						 <a href="ManageGoodsServlet">管理仓库</a> -->
                <!-- 					</li> -->
            </ul>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column" style="padding: 0px;">
            <center>
                <label style="margin-top: 200px;"><font style="font-size: 100px;">Something Wrong!</font></label>
            </center>
        </div>
    </div>
</div>
<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="js/jquery-3.2.0.min.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="js/bootstrap.min.js"></script>


</body>
</html>
