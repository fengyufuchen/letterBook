<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bookstore</title>

<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
<link rel="stylesheet"
	href="/styles/bootstrap-3.3.5-dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/styles/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="/styles/css/form-elements.css">
<link rel="stylesheet" href="/styles/css/styles.css">

<link rel="shortcut icon" href="/styles/images/workplan.png"
	type="image/x-icon" />

<script type="text/javascript">
	
</script>

</head>

<style type="text/css">
html {
	width: 100%;
	height: 100%;
}

body {
	width: 100%;
	height: 100%;
	font-family: 'Open Sans', sans-serif;
	background: #092756;
	background: -moz-radial-gradient(0% 100%, ellipse cover, rgba(104, 128, 138, .4)
		10%, rgba(138, 114, 76, 0) 40%),
		-moz-linear-gradient(top, rgba(57, 173, 219, .25) 0%,
		rgba(42, 60, 87, .4) 100%),
		-moz-linear-gradient(-45deg, #670d10 0%, #092756 100%);
	background: -webkit-radial-gradient(0% 100%, ellipse cover, rgba(104, 128, 138, .4)
		10%, rgba(138, 114, 76, 0) 40%),
		-webkit-linear-gradient(top, rgba(57, 173, 219, .25) 0%,
		rgba(42, 60, 87, .4) 100%),
		-webkit-linear-gradient(-45deg, #670d10 0%, #092756 100%);
	background: -o-radial-gradient(0% 100%, ellipse cover, rgba(104, 128, 138, .4)
		10%, rgba(138, 114, 76, 0) 40%),
		-o-linear-gradient(top, rgba(57, 173, 219, .25) 0%,
		rgba(42, 60, 87, .4) 100%),
		-o-linear-gradient(-45deg, #670d10 0%, #092756 100%);
	background: -ms-radial-gradient(0% 100%, ellipse cover, rgba(104, 128, 138, .4)
		10%, rgba(138, 114, 76, 0) 40%),
		-ms-linear-gradient(top, rgba(57, 173, 219, .25) 0%,
		rgba(42, 60, 87, .4) 100%),
		-ms-linear-gradient(-45deg, #670d10 0%, #092756 100%);
	background: -webkit-radial-gradient(0% 100%, ellipse cover, rgba(104, 128, 138, .4)
		10%, rgba(138, 114, 76, 0) 40%),
		linear-gradient(to bottom, rgba(57, 173, 219, .25) 0%,
		rgba(42, 60, 87, .4) 100%),
		linear-gradient(135deg, #670d10 0%, #092756 100%);
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#3E1D6D',
		endColorstr='#092756', GradientType=1);
}
</style>



<body>
	<!-- Top content -->
	<div class="top-content">

		<div class="inner-bg">
			<div class="container">
				<div class="row">
					<div class="col-sm-8 col-sm-offset-2 text">
						<div class="description">
							<p>简易几步，重新定义您的购物方式。</p>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6 col-sm-offset-3 form-box">

						<form role="form" method="post" onsubmit="return false;"
							class="registration-form">

							<fieldset>
								<div class="form-top">
									<div class="form-top-left">
										<h3>步骤 1 / 3</h3>
										<p>(个人简介)</p>
									</div>
									<div class="form-top-right">
										<i class="fa fa-user"></i>
									</div>
								</div>
								<div class="form-bottom">
									<div class="form-group">
										<label class="sr-only" for="form-last-name">姓名</label> <input
											type="text" name="uname" placeholder="请输入您的姓名"
											class="form-last-name form-control" id="form-last-name"
											value="${user.uname }">
									</div>
									<div class="form-group">
										<label><input name="usex" type="radio" value="M"
											checked="checked" />&nbsp;男&nbsp;&nbsp;&nbsp;&nbsp;</label> <label><input
											name="usex" type="radio" value="F" />&nbsp;女&nbsp;&nbsp;&nbsp;&nbsp;</label>
									</div>
									<button type="button" class="btn btn-next">下一步</button>
								</div>
							</fieldset>

							<fieldset>
								<div class="form-top">
									<div class="form-top-left">
										<h3>步骤 2 / 3</h3>
										<p>(注册信息)</p>
									</div>
									<div class="form-top-right">
										<i class="fa fa-key"></i>
									</div>
								</div>
								<div class="form-bottom">
									<div class="form-group">
										<label class="sr-only" for="form-first-name">账号</label> <input
											type="text" name="uaccount" placeholder="请输入账号"
											class="form-first-name form-control" id="form-first-name"
											value="${user.uaccount }">
									</div>
									<div class="form-group">
										<label class="sr-only" for="form-password">密码</label> <input
											type="password" name="upsw" placeholder="请输入密码"
											class="form-password form-control" id="form-password">
									</div>
									<div class="form-group">
										<label class="sr-only" for="form-repeat-password">重复密码</label>
										<input type="password" name="upsw" placeholder="请重复输入密码"
											class="form-repeat-password form-control"
											id="form-repeat-password">
									</div>
									<button type="button" class="btn btn-previous">上一步</button>
									<button type="button" class="btn btn-next">下一步</button>
								</div>
							</fieldset>

							<fieldset>
								<div class="form-top">
									<div class="form-top-left">
										<h3>步骤 3 / 3</h3>
										<p>(个人信息)</p>
									</div>
									<div class="form-top-right">
										<i class="fa fa-twitter"></i>
									</div>
								</div>
								<div class="form-bottom">
									<div class="form-group">
										<label class="sr-only" for="form-facebook">手机</label> <input
											type="text" name="uphone" placeholder="请输入手机"
											class="form-facebook form-control" id="form-facebook"
											value="${user.uphone }">
									</div>
									<div class="form-group">
										<label class="sr-only" for="form-twitter">邮箱</label> <input
											type="text" name="uemail" placeholder="请输入邮箱"
											class="form-twitter form-control" id="form-twitter"
											value="${user.uemail }">
									</div>
									<div class="form-group">
										<label class="sr-only" for="form-first-name">住址</label> <input
											type="text" name="uadr" placeholder="请输入住址"
											class="form-first-name form-control" id="form-first-name"
											value="${user.uadr }">
									</div>
									<button type="button" class="btn btn-previous">上一步</button>
									<button type="button" class="btn" id="submitBtn">提交</button>

									<span id="tipMsg" style="color: red"></span>
								</div>
							</fieldset>

						</form>

					</div>
				</div>
			</div>
		</div>

	</div>




	<!-- Javascript -->
	<script src="/styles/js/jquery-1.11.1.min.js"></script>
	<script src="/styles/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
	<script src="/styles/js/jquery.backstretch.min.js"></script>
	<script src="/styles/js/retina-1.1.0.min.js"></script>
	<script src="/styles/js/scripts.js"></script>

	<!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

</body>

<script type="text/javascript">
	$(function() {

		$("#submitBtn").bind("click", function() {

			var data = $(".registration-form").serialize();
			$.ajax({

				url : "/user/register",
				data : data,
				type : "post",
				success : function(data) {
					if (data.status = 200) {
						window.location.href = "/";
					} else {

						$("#tipMsg").text(data.msg);

					}

				}
			});

		})
	})
</script>

</html>