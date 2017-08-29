<jsp:include page="../common/default.jsp"></jsp:include>
<%@ page language="java"
	import="java.util.*, com.sachin.bl.entities.AdminTable"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理员主页</title>
<script type="text/javascript">	
		$(function() {
			DWZ.init("dwz.frag.xml", {
				loginUrl : "adminLogin.jsp",
				loginTitle : "登录",
				statusCode : { ok : 200,error : 300,timeout : 301},
				pageInfo : { pageNum : "pageNum",numPerPage : "numPerPage",orderField : "orderField",orderDirection : "orderDirection"},
				debug : true,
				callback : function() {
					initEnv();
					$("#themeList").theme( { themeBase : "common/themes/type" });
				}
			});
		});
	</script>
</head>
<body scroll="no">
	<div id="layout">

		<div id="header">
			<div class="headerNav">
				<ul class="nav">
					<li><a href="javascript:void(0)"> <%
 	if (session.getAttribute("User") instanceof AdminTable) {
 		AdminTable admin = (AdminTable) session.getAttribute("User");
 		if (admin != null) {
 %> <%=((AdminTable) session.getAttribute("User")).getAname()%></a> <%
 	} else {
 %>
						<script type="text/javascript" language="javascript">
								alert("<%=session.getAttribute("msg")%>");
								window.location="/BooksOnLine/adminLogin.jsp" ;                            // 跳转到登录界面
							</script> <%
 	}
 	} else {
 %> <script type="text/javascript"
							language="javascript">
								alert("<%=session.getAttribute("msg")%>
								");
								window.location = "/BooksOnLine/adminLogin.jsp"; // 跳转到登录界面
							</script> <%
 	}
 %></li>
					<li>管理员</li>
					<li id="switchEnvBox"><a href="javascript:void(0);;"><span
							id="currentSpan"><s:property
									value="#session.classCourse.course.cname" /></span></a>
						<ul>
						</ul></li>
					<li><a href="adminLoginOut.action">退出</a></li>
				</ul>
				<ul class="themeList" id="themeList">
					<li theme="default"><div class="selected">蓝色</div></li>
					<li theme="green"><div>绿色</div></li>
					<li theme="purple"><div>紫色</div></li>
					<li theme="silver"><div>银色</div></li>
					<li theme="azure"><div>天蓝</div></li>
				</ul>
			</div>
		</div>

		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse">
						<div></div>
					</div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse">
					<h2>主菜单</h2>
					<div>收缩</div>
				</div>
				<div class="accordion" fillSpace="sidebar">
					<div class="accordionHeader">
						<h2>
							<span>Folder</span>界面组件
						</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a href="javascript:void(0);">选择功能</a>
								<ul>
									<li><a href="admin/adminUser/getmanagerUserPage.action"
										target="navTab" fresh="true" rel="userManager">客户管理</a></li>
									<li><a
										href="admin/adminBusiness/getmanagerBusinessPage.action"
										target="navTab" fresh="true" rel="businessManager">商家管理</a></li>
									<li><a href="admin/adminBook/getmanagerBookPage.action"
										target="navTab" fresh="true" rel="bookManager">图书管理</a></li>
									<li><a href="admin/adminOrder/getmanagerOrderPage.action"
										target="navTab" fresh="true" rel="orderManager">订单管理</a></li>
									<li><a
										href="admin/adminComment/getmanagerCommentPage.action"
										target="navTab" fresh="true" rel="commentManager">评论管理</a></li>
									<li><a
										href="admin/adminShopcar/getmanagerShopcarPage.action"
										target="navTab" fresh="true" rel="shopcarManager">购物车管理</a></li>
									<li><a href="admin/passwordManager/passwordManager.action"
										target="navTab" fresh="true" rel="passwordManager">修改密码</a></li>
								</ul></li>
						</ul>
					</div>
					<div class="accordionFooter"></div>
				</div>
			</div>
		</div>

		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent">
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:void(0);"><span><span
										class="home_icon">我的主页</span></span></a></li>
						</ul>
					</div>

					<div class="tabsLeft">left</div>
					<div class="tabsRight">right</div>
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:;">我的主页</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div class="page unitBox">
						<iframe frameborder="no" marginheight="0" marginwidth="0"
							border="0" style="width: 100%; height: 502px;" src=""></iframe>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="footer">Copyright &copy;
		广东工业大学&nbsp;&nbsp;&nbsp;&nbsp;计算机学院&nbsp;&nbsp;&nbsp;&nbsp;2013级计算机科学与技术3班&nbsp;&nbsp;&nbsp;&nbsp;方典禹&nbsp;&nbsp;&nbsp;&nbsp;黄俊维&nbsp;&nbsp;&nbsp;&nbsp;姚国海
	</div>
</body>
</html>
