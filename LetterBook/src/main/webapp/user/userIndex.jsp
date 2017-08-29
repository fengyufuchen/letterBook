<jsp:include page="../styles/default.jsp"></jsp:include>
<%@ page language="java"
	import="java.util.*, com.sachin.bl.entities.UserTable"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="方典禹">

<title>Bookstore</title>

</head>

<body>
	<%
		if (session.getAttribute("User") instanceof UserTable) {
			UserTable user = (UserTable) session.getAttribute("User");
			if (user != null) {
				((UserTable) session.getAttribute("User")).getUaccount();
	%>

	<!-- Fixed navbar -->
	<div class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand " href="/user/userIndex">Bookstore</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/user/bookspage" data-history>图书列表</a></li>
					<li><a href="/userShopcar/shopcarContentManagerPage"
						data-history>我的购物车</a></li>
					<li><a href="/userOrder/ordersPage" data-history>我的订单</a></li>
					<li><a href="/userComment/commentsPage" data-history>我的评论</a></li>
					<li class="dropdown"><a data-toggle="dropdown">帮助<span
							class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="/help" data-history>查看帮助</a></li>
							<li><a href="/contact" data-history>联系我们</a></li>
						</ul></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="/user/chpwd" data-toggle="modal"
						data-target="#modal-dialog">修改密码</a></li>
					<li><a href="/user/logout">退出</a></li>
				</ul>
			</div>
		</div>
	</div>




	<div class="container dwz-unit-box" id="container">

		<!-- Main component for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h1>
				Hello,
				<%=user.getUname()%>！
			</h1>
			<p>Bookstore，重新定义您的购书方式。</p>
			<p>
				<a class="btn btn-lg btn-primary" href="/user/bookspage"
					data-history="repairOrder" role="button">开始购书&raquo;</a>
			</p>
		</div>

		<div class="bs-glyphicons">
			<a href="/user/editUser" data-toggle="modal"
				data-target="#modal-dialog"> <span
				class="glyphicon glyphicon-user"></span> <span
				class="glyphicon-class">我的信息</span>
			</a> <a href="/userShopcar/shopcarContentManagerPage"
				data-history="repairOrder"> <span
				class="glyphicon glyphicon-th-large"></span> <span
				class="glyphicon-class">我的购物车</span>
			</a> <a href="/userOrder/orderPage" data-history="repairOrder">
				<span class="glyphicon glyphicon-edit"></span> <span
				class="glyphicon-class">我的订单</span>
			</a> <a href="/userComment/commentsPage"
				data-history="repairOrder"> <span
				class="glyphicon glyphicon-time"></span> <span
				class="glyphicon-class">我的评论</span>
			</a>

		</div>

	</div>

	<%
		} else {
	%>
	<script type="text/javascript" language="javascript">;
		var a = "<%=session.getAttribute("msg")%>";
		if(a != null && a != "")
 			alert(a);
		else
			alert("请重新登录！");
		window.location="/" ;                            // 跳转到登录界面
	</script>
	<%
		}
		} else {
	%>
	<script type="text/javascript" language="javascript">
		var a = "<%=session.getAttribute("msg")%>
		";
		if (a != null && a != "")
			alert(a);
		else
			alert("请重新登录！");
		window.location = "/"; // 跳转到登录界面
	</script>
	<%
		}
	%>


	<div id="background" style="display: none"></div>
	<div id="progressBar" style="display: none">数据加载中，请稍等...</div>

	<!-- Modal -->
	<div class="modal fade" id="modal-dialog" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content dwz-unit-box"></div>
		</div>
	</div>

</body>
</html>
