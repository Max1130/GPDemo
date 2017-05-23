<%@page import="entity.MallingGoods"%>
<%@page import="java.util.List"%>
<%@page import="dao.MallingGoodDaoImpl"%>
<%@page import="dao.MallingGoodDao"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@page import="java.util.*,bean.GoodsBean,dao.GoodsDAO" %> --%>
<!DOCTYPE html>
<html>
   <head>
	   <style type="text/css">
		   .icon {
			   width: 1em; height: 1em;
			   vertical-align: -0.15em;
			   fill: currentColor;
			   overflow: hidden;
		   }
	   </style>
      <title>商品信息管理</title>
		<%
		response.setHeader("Pragma","No-cache");
		response.setHeader("Cache-Control","no-cache");
		response.setDateHeader("Expires", -10);
		%>
      <meta http-equiv="Pragma" contect="no-cache">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <!-- 引入 Bootstrap -->
      <link href="css/bootstrap.min.css" rel="stylesheet">
      <link href="css/myself.css" rel="stylesheet">
	   <link rel="stylesheet" type="text/css" href="css/iconfont.css">
 
      <!-- HTML5 Shim 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
      <!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
      <!--[if lt IE 9]>
         <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
         <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
		 <script src="js/iconfont.js"></script>
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
					<li class="active" >
						 <a href="index.html">首页</a>
					</li>
					<li style="color: #b92c28;">
					<%
						String Uname = (String)session.getAttribute("Uname");
						System.out.print(Uname);
						String url = "towebLogin.html";
						if(Uname!=null && !Uname.equals("")){
							url = "";
						}else{
							Uname = "登录";
						}
					%>
						 <a href= <%=url %>> <%=Uname %> </a>
					</li>
					<li >
						<%
						if(session.getAttribute("Uname")!=null){
						%>
						 <a href="logout.html">退出</a>
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
	<div class="container">
	<div class="row clearfix">
		 <div >
		 	<center>
			 	<form action="SearchGoodsServlet" method="GET">
			 		<span><input type="text" name="searchText" style="margin:0px;color:#778899;
			 			padding:0px;position:relative;top:1px;" value placeholder="商品名称..." ></span>
			 		<span >
			 			<button type="submit" style="position:relative;left:-5px;top:0px;width:50px;height:25px;
			 				padding:0px;background-color:#5CACEE;color:#FFFFFF;font-family:SimHei;"
			 				 class="btn btn-default">搜索</button>
			 		</span>
			 	</form>
		 	</center>
		 </div>
		 <div class="col-md-6 column" style="margin-left: 0px;width: 1250px;margin-top:50px;">
			<center>
			<table class="table" border="5px" style="width:1200px;text-align:center;">
				<thead style="background-color:#FFE1FF">
					<tr >
						<th style="text-align:center;width: 5%;">
							序号
						</th>
						<th style="text-align:center;width: 15%;">
							商品编号
						</th>
						<th style="text-align:center;width: 20%">
							商品
						</th>
						<th style="text-align:center;width: 10%">
							价格
						</th>
						<th style="text-align:center;">
							描述
						</th>
						<%if(session.getAttribute("Uname")!=null){ %>
							<th style="text-align:center;width: 10%">操作</th>
						<% 	}%>	
					</tr>
				</thead>


					<%
						MallingGoodDao goodDao = new MallingGoodDaoImpl();
						List<MallingGoods> goods = goodDao.queryAll();
 						if(goods!=null){
 						    int i = 0;
					%>
					<tbody>
					<% for(MallingGoods bean : goods){
					    i++;
 // 						int gid = bean.getGid();
 					%>
					<tr style="background-color:#D1EEEE" id=<%=bean.getId() %>>
						<td >
							<%=i %>
						</td>
						<td >
							<%=bean.getGoodNumber() %>
						</td>
						<td>
							<%=bean.getGoodName() %>
						</td>
						<td>
							<%=bean.getPrice() %>
						</td>
						<td>
							<%=bean.getDescription() %>
						</td>
						<%if(session.getAttribute("Uname")!=null){
 // 							// 把要查询的内容放到session中，只能用Ajax
						%>
							<td>
								<i class="iconfont icon-add"></i>
								<button onclick="jump(<%=bean.getId() %>)">查看详情</button>
							</td>
						<% 	}%>
					</tr>
					<% }%>
					</tbody>
					<%}else{ %>
							<h1>无法获取商品信息，请先登录</h1>
					<%} %>
			</table>
			</center>
		</div>
		<div class="col-md-4 column">
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-12 column" style="text-align: center;">
			<ul class="pagination">
				<li>
					 <a href="#">Prev</a>
				</li>
				<li>
					 <a href="#">1</a>
				</li>
				<li>
					 <a href="#">2</a>
				</li>
				<li>
					 <a href="#">3</a>
				</li>
				<li>
					 <a href="#">4</a>
				</li>
				<li>
					 <a href="#">5</a>
				</li>
				<li>
					 <a href="#">Next</a>
				</li>
			</ul>
		</div>
	</div>
</div>
	</div>
      <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
      <script src="js/jquery-3.2.0.min.js"></script>
      <!-- 包括所有已编译的插件 -->
      <script src="js/bootstrap.min.js"></script>
      <script type="text/javascript">
      	function jump(id){
      		location.href='queryGood?id='+id;
      	}
      </script>
   </body>
</html>