<jsp:include page="common/default.jsp"></jsp:include>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
</head>
<body>
	欢迎使用任务计划管理系统！
	<form action="/test/node">
		<input type="text" name="y"> <input type="text" name="x">
		<input type="submit" value="submit">

	</form>

	<form action="/test/node">
		<input type="text" name="y.value"> <input type="text" name="x">
		<input type="submit" value="submit">

	</form>



	<input type="button" value="测试返回是否乱码" id="input1">
	<input type="button" value="测试堆返回数据进行编码" id="input2">

	<form method="post" action=""
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>客户昵称：</label> <input id="cus_id" type="text"
					name="customer.cus_id" size="30" class="required" />
			</p>
			<p>
				<label>客户名：</label> <input id="cus_name" type="text"
					name="customer.cus_name" size="30" class="required" />
			</p>
			<p>
				<label>邮箱：</label> <input id="cus_email" type="text"
					name="customer.cus_email" size="30" class="required email" />
			</p>
			<p>
				<label>客户类型：</label> <select name="customer.cus_type"
					class="required combox">
					<option value="">请选择</option>
					<option value="1">管理员</option>
					<option value="2" selected>客户</option>
				</select>
			</p>
		</div>
		<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">保存</button>
						</div>
					</div></li>
				<li>
					<div class="button">
						<div class="buttonContent">
							<button type="button" class="close">取消</button>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</form>

	<form method="post" action="/userShopcar/updateShopcarContent"
		class="required-validate">
		<input type="hidden" name="sccid" value="${shopcarContent.sccid }" />
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">
				<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
			</button>
			<h4 class="modal-title">修改购物车</h4>
		</div>
		<div class="modal-body">

			<div class="form-group">
				<label for="input-nickname">图书：</label> <input type="text"
					name="shopcarContent.book.boname" disabled="true"
					value="${shopcarContent.book.boname }" class="form-control"
					id="input-nickname" placeholder="书名" required minlength="2"
					maxlength="50">
				<div class="help-block with-errors"></div>
			</div>
			<div class="form-group">
				<label for="input-nickname">购买数量：</label> <input type="tel"
					name="number" value="${shopcarContent.number }"
					class="form-control" id="input-nickname" placeholder="书名" required
					minlength="1" maxlength="10">
				<div class="help-block with-errors"></div>
			</div>

		</div>
		<div class="modal-footer">
			<button type="submit" class="btn btn-primary"
				data-loading-text="Loading...">提交</button>
			<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		</div>
	</form>

</body>
<script type="text/javascript" src="common/js/jq/jquery-1.7.1.js"></script>
<script type="text/javascript">
	$(function() {

		$("#input1").bind("click", function() {
			$.ajax({

				url : "/test/ajax",
				success : function(data) {
					console.log(data)
				}

			})

		});
		$("#input2").bind("click", function() {
			$.ajax({

				url : "/test/utfajax",
				success : function(data) {
					console.log(data)
				}

			})

		});

	})
</script>
</html>