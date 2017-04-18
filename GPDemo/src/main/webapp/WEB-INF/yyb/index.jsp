<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GrassLiuCommunity</title>
<link type="text/css" rel="stylesheet" media="all" href="styles/index.css"/>
</head>
<body>
	<!-- header开始 -->
	<div id="header">
	<!-- 
		当前:/xxx/WEB-INF/mainInvc/...
		img:/xxx/images/..
	 -->
		<img alt="logo" src="images/logo.png" onclick="location.reload(true);">
		<c:if test="${isIn == null }">
			<c:import url="../logo_out.jsp"></c:import>
		</c:if>
		<c:if test="${isIn == 1 }">
			<c:import url="../logo_in.jsp"></c:import>
		</c:if>
	</div>
	<!-- header结束 -->
	<!-- body开始 -->
	<div id="body">
		<!-- 资源区开始 -->
		<div id="resource">
			<div id="resource_text" align="center" onclick="location.href='find.resources'">
				<div><br>资</div>
				<div><br>源</div>
				<div><br>区</div>
			</div>
		</div>
		<!-- 资源区结束 -->
		
		<!-- 帖子区开始 -->
		<div id="invitation">
			<!-- 导航区开始 -->
			<div id="navigation">
				<c:if test="${isIn == null }">
					<a href="tologin.jsp"><p id="pmsg" align="center">发帖</p></a>
				</c:if>
				<c:if test="${isIn == 1 }">
					<a href="toPost.invition"><p id="pmsg" align="center">发帖</p></a>
				</c:if>
				<a href="#"><p id="to_top"></p></a>
			</div>
			<!-- 导航区结束 -->
			<!-- 帖子类别区 -->
			<div class="regions">
				<c:if test="${isIn == null }">
					<c:if test="${type==4 }">
						<p class="current_type" align="center" onclick="location.href='find.invition?type=4'">全部</p>
					</c:if>
					<c:if test="${type!=4 }">
						<p align="center" onclick="location.href='find.invition?type=4'">全部</p>
					</c:if>
					<c:if test="${type==0 }">
						<p class="current_type" align="center" onclick="location.href='find.invition?type=0'">小说</p>
					</c:if>
					<c:if test="${type!=0 }">
						<p align="center" onclick="location.href='find.invition?type=0'">小说</p>
					</c:if>
					<c:if test="${type==1 }">
						<p class="current_type" align="center" onclick="location.href='find.invition?type=1'">电视剧</p>
					</c:if>
					<c:if test="${type!=1 }">
						<p align="center" onclick="location.href='find.invition?type=1'">电视剧</p>
					</c:if>
					<c:if test="${type==2 }">
						<p class="current_type" align="center" onclick="location.href='find.invition?type=2'">电影</p>
					</c:if>
					<c:if test="${type!=2 }">
						<p align="center" onclick="location.href='find.invition?type=2'">电影</p>
					</c:if>
					<c:if test="${type==3 }">
						<p class="current_type" align="center" onclick="location.href='find.invition?type=3'">其他</p>
					</c:if>
					<c:if test="${type!=3 }">
						<p align="center" onclick="location.href='find.invition?type=3'">其他</p>
					</c:if>
				</c:if>
				<c:if test="${isIn == 1 }">
					<c:if test="${type==4 }">
						<p class="current_type" align="center" onclick="location.href='find.invition?type=4&isIn=1'">全部</p>
					</c:if>
					<c:if test="${type!=4 }">
						<p align="center" onclick="location.href='find.invition?type=4&isIn=1'">全部</p>
					</c:if>
					<c:if test="${type==0 }">
						<p class="current_type" align="center" onclick="location.href='find.invition?type=0&isIn=1'">小说</p>
					</c:if>
					<c:if test="${type!=0 }">
						<p align="center" onclick="location.href='find.invition?type=0&isIn=1'">小说</p>
					</c:if>
					<c:if test="${type==1 }">
						<p class="current_type" align="center" onclick="location.href='find.invition?type=1&isIn=1'">电视剧</p>
					</c:if>
					<c:if test="${type!=1 }">
						<p align="center" onclick="location.href='find.invition?type=1&isIn=1'">电视剧</p>
					</c:if>
					<c:if test="${type==2 }">
						<p class="current_type" align="center" onclick="location.href='find.invition?type=2&isIn=1'">电影</p>
					</c:if>
					<c:if test="${type!=2 }">
						<p align="center" onclick="location.href='find.invition?type=2&isIn=1'">电影</p>
					</c:if>
					<c:if test="${type==3 }">
						<p class="current_type" align="center" onclick="location.href='find.invition?type=3&isIn=1'">其他</p>
					</c:if>
					<c:if test="${type!=3 }">
						<p align="center" onclick="location.href='find.invition?type=3&isIn=1'">其他</p>
					</c:if>
				</c:if>
			</div>
			<!-- 帖子类别区 -->
			<!-- 帖子数据展示区开始 -->
			<div class="invidata">
				<table id="datalist">
					<c:if test="${isIn == null }">
						<c:forEach items="${invits}" var="i">
							<tr>
								<td class="name"><a href="toShowUserInfo.invition?Uname=${i.getUname() }">${i.getUname() }</a></td>
								<td class="title"><a href="findContent.invition?Iid=${i.getIid() }">${i.getInvname() }</a></td>
								<td class="time"><fmt:formatDate value="${i.getInvDate()}" pattern="yyyy/MM/dd HH:mm:ss"/></td>
							</tr>
					</c:forEach>
					</c:if>
					<c:if test="${isIn == 1 }">
						<c:forEach items="${invits}" var="i">
							<tr>
								<td class="name"><a href="toShowUserInfo.invition?Uname=${i.getUname() }">${i.getUname() }</a></td>
								<td class="title"><a href="findContent.invition?Iid=${i.getIid() }&isIn=1">${i.getInvname() }</a></td>
								<td class="time"><fmt:formatDate value="${i.getInvDate()}" pattern="yyyy/MM/dd HH:mm:ss"/></td>
							</tr>
					</c:forEach>
					</c:if>
					
				</table>
			</div>
			<!-- 帖子数据展示区结束 -->
			<!--分页-->
			<div id="pages">
				<c:if test="${isIn == null }">
					<!-- 跳转到首页 -->
					<a href="find.invition?page=1&&type=${type }">首页</a>
					<!-- 当前是第1页，则不能点上一页 -->
					<c:if test="${page==1 }">
						<a href="">&lt;上一页</a>
					</c:if>
					<c:if test="${page!=1 }">
						<a href="find.invition?page=${page-1 }&&type=${type }">&lt;上一页</a>
					</c:if>
					<!-- 
	                 	begin：循环起始位置；
	                 	end：循环终止位置；
	                 -->
					<c:forEach begin="1" end="${total }" var="i">
						<!-- 若循环到了当前页，则将页码高亮显示 -->
						<c:if test="${i==page }">
							<a href="find.invition?page=${i }&&type=${type }" class="current_page">${i }</a>
						</c:if>
						<!-- 若不是当前页，则去掉高亮的样式 -->
						<c:if test="${i!=page }">
							<a href="find.invition?page=${i }&&type=${type }">${i }</a>
						</c:if>
					</c:forEach>
	
					<!-- 当前页是最后一页，则不能点下一页 -->
					<c:if test="${page==total }">
						<a href="">下一页&gt;</a>
					</c:if>
					<c:if test="${page!=total }">
						<a href="find.invition?page=${page+1 }&&type=${type }">下一页&gt;</a>
					</c:if>
					<!-- 跳转到最后一页 -->
					<a href="find.invition?page=${total }&&type=${type }">尾页</a>
				</c:if>
				<c:if test="${isIn == 1 }">
					<a href="find.invition?page=1&&type=${type }&&isIn=1">首页</a>
					<!-- 当前是第1页，则不能点上一页 -->
					<c:if test="${page==1 }">
						<a href="">&lt;上一页</a>
					</c:if>
					<c:if test="${page!=1 }">
						<a href="find.invition?page=${page-1 }&&type=${type }&&isIn=1">&lt;上一页</a>
					</c:if>
					<!-- 
	                 	begin：循环起始位置；
	                 	end：循环终止位置；
	                 -->
					<c:forEach begin="1" end="${total }" var="i">
						<!-- 若循环到了当前页，则将页码高亮显示 -->
						<c:if test="${i==page }">
							<a href="find.invition?page=${i }&&type=${type }&&isIn=1" class="current_page">${i }</a>
						</c:if>
						<!-- 若不是当前页，则去掉高亮的样式 -->
						<c:if test="${i!=page }">
							<a href="find.invition?page=${i }&&type=${type }&&isIn=1">${i }</a>
						</c:if>
					</c:forEach>
	
					<!-- 当前页是最后一页，则不能点下一页 -->
					<c:if test="${page==total }">
						<a href="">下一页&gt;</a>
					</c:if>
					<c:if test="${page!=total }">
						<a href="find.invition?page=${page+1 }&&type=${type }&&isIn=1">下一页&gt;</a>
					</c:if>
					<!-- 跳转到最后一页 -->
					<a href="find.invition?page=${total }&&type=${type }&&isIn=1">尾页</a>
				</c:if>
			</div>
		</div>
		<div id="d0" style="clear: left; border: 0;"></div>
		<!-- 帖子区结束 -->
	</div>
	<!-- body結束 -->
	<div id="foot">
		<p align="center">这是一个交易网站</p>
		<p align="center">在这里可以进行交流,资源购买</p>
	</div>
</body>
</html>