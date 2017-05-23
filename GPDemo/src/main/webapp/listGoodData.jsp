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
					<%--<%--%>
						<%--MallingGoodDao goodDao = new MallingGoodDaoImpl();--%>
						<%--List<MallingGoods> goods = goodDao.queryAll();--%>
 						<%--if(goods!=null){--%>
 						    <%--int i = 0;--%>
					<%--%>--%>
					<tbody>
					<%--<% for(MallingGoods bean : goods){--%>
					    <%--i++;--%>
 <%--// 						int gid = bean.getGid();--%>
 					<%--%>--%>
					<c:forEach var="bean" items="${goodsList}" varStatus="status">
					<tr style="background-color:#D1EEEE" id="${bean.id}">
						<td >
							${status+1}
						</td>
						<td >
							${bean.goodNumber}
							<%--<%=bean.getGoodNumber() %>--%>
						</td>
						<td>
							${bean.goodName}
							<%--<%=bean.getGoodName() %>--%>
						</td>
						<td>
							${bean.price}
							<%--<%=bean.getPrice() %>--%>
						</td>
						<td>
							${bean.description}
							<%--<%=bean.getDescription() %>--%>
						</td>
						<% 
							if(session.getAttribute("Uname")!=null){
 // 							// 把要查询的内容放到session中，只能用Ajax
						%>
							<td>
								<i class="iconfont icon-add"></i>
								<button onclick="jump(${bean.id})">查看详情</button>
							</td>
						<% 	}%>
					</tr>
					</c:forEach>
					</tbody>
   </body>
</html>