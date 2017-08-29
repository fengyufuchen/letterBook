<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<form method="post" action="/userShopcar/updateShopcarContent"
	class="required-validate"
	onsubmit="return validateCallback(this, dialogAjaxDone)" ">
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
				name="number" value="${shopcarContent.number }" class="form-control"
				id="input-nickname" placeholder="书名" required minlength="1"
				maxlength="10">
			<div class="help-block with-errors"></div>
		</div>

	</div>
	<div class="modal-footer">
		<button type="submit" class="btn btn-primary"
			data-loading-text="Loading...">提交</button>
		<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	</div>
</form>