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
		   #pages a{
			   padding: 5px 10px;
		   }
		   #pages a:hover{
			   padding: 4px 12px;
			   background-color: #D1EEEE;
		   }
		   #pages a.current_page{
			   font-weight:bold;
			   color: black;
			   background-color: #D1EEEE;
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
		 <script src="js/index.js"></script>
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
	<div class="container">
	<div class="row clearfix">
		 <div >
		 	<center>
			 	<form action="index.html" method="GET">
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
		 <div class="col-md-6 column" style="margin-right: 50px;width: 1250px;margin-top:50px;">
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
						<th style="text-align:right;width: 10%">
							价格
						</th>
						<th style="text-align:left;">
							描述
						</th>
						<%if(session.getAttribute("Uname")!=null){ %>
							<th style="text-align:center;width: 10%">操作</th>
						<% 	}%>	
					</tr>
				</thead>

					<tbody>
					<c:forEach var="bean" items="${goodsList}" varStatus="status">


					<tr style="background-color:#D1EEEE" id="${bean.id}">
						<td >
							${status.index+1 }
						</td>
						<td >
							${bean.goodNumber}
						</td>
						<td>
							${bean.goodName }
						</td>
						<td style="text-align: right;">
							${bean.price }
						</td>
						<td style="text-align: left">
							${bean.description }
						</td>
						<%if(session.getAttribute("Uname")!=null){
 // 							// 把要查询的内容放到session中，只能用Ajax
						%>
							<td>
								<i class="iconfont icon-add"></i>
								<button onclick="jump(${bean.id })">查看详情</button>
							</td>
						<% 	}%>
					</tr>
					</c:forEach>
					</tbody>
			</table>
			</center>
		</div>
		<div class="col-md-4 column">
		</div>
	</div>
	<div class="row clearfix" id="pages">
		<div class="col-md-12 column" style="text-align: center;">
			<ul class="pagination">
				<li>

				</li>
				<li>
					<c:if test="${1==pageIndex }">
						<a href="#">Prev</a>
					</c:if>
					<c:if test="${1!=pageIndex }">
						<a href="index.html?pageIndex=${pageIndex-1 }&searchText=${operate }">Prev</a>
					</c:if>
				</li>
				<c:forEach begin="1" end="${totalPageSize }" var="i">
					<!-- 若循环到了当前页，则将页码高亮显示 -->
					<c:if test="${i==pageIndex }">
						<li>
							<a href="index.html?pageIndex=${i }&searchText=${operate }" class="current_page" >${i }</a>
						</li>
					</c:if>
					<!-- 若不是当前页，则去掉高亮的样式 -->
					<c:if test="${i!=pageIndex }">
						<li>
							<a href="index.html?pageIndex=${i }&searchText=${operate }">${i }</a>
						</li>
					</c:if>
				</c:forEach>
				<%--<li>--%>
					 <%--<a href="#">2</a>--%>
				<%--</li>--%>
				<%--<li>--%>
					 <%--<a href="#">3</a>--%>
				<%--</li>--%>
				<%--<li>--%>
					 <%--<a href="#">4</a>--%>
				<%--</li>--%>
				<%--<li>--%>
					 <%--<a href="#">5</a>--%>
				<%--</li>--%>
				<li>
					<c:if test="${totalPageSize == pageIndex }">
						<a href="#">Next</a>
					</c:if>
					<c:if test="${totalPageSize != pageIndex }">
						<a href="index.html?pageIndex=${pageIndex+1 }&searchText=${operate }">Next</a>
					</c:if>
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
//        /**
 //           * Created by Administrator on 2017/5/12.
 //           */
//
//
//          $(function () {
//              listGoodData();
//          })
//
//		  XMLHttpRequest
//
//          var params = {
//          };
//
//          function listGoodData()
//          {
//              var xmlhttp;
//              if (window.XMLHttpRequest)
//              {// code for IE7+, Firefox, Chrome, Opera, Safari
//                  xmlhttp=new XMLHttpRequest();
//              }
//              else
//              {// code for IE6, IE5
//                  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
//              }
//
//              xmlhttp.open("GET","listGoodData.html",true);
//              xmlhttp.send();
//          }

      	function jump(id){
      		location.href='QueryGoods?gid='+id;
      	}
      </script>
   </body>
</html>