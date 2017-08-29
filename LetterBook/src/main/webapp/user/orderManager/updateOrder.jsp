<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 


<form method="post" action="/userOrder/updateOrder" class="required-validate">
	<input type="hidden" name="oid" value="${order.oid }"/>
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
		<h4 class="modal-title">修改订单</h4>
	</div>
	<div class="modal-body">
	
		<div class="form-group">
			<label for="input-nickname">收件人</label>
			<input type="text" name="oname" value="${order.oname }" class="form-control" id="input-nickname" placeholder="姓名" required minlength="2" maxlength="20">
			<div class="help-block with-errors"></div>
		</div>	
		<div class="form-group">
			<label for="input-mobile">联系方式</label>
			<input type="tel"  name="ophone" value="${order.ophone }" class="form-control" id="input-mobile" placeholder="手机" required minlength="11" maxlength="20" data-error="手机号非法">
			<div class="help-block with-errors"></div>
		</div>
		<div class="form-group">
			<label for="input-nickname">收件地址</label>
			<input type="text" name="oadr" value="${order.oadr }" class="form-control" id="input-nickname" placeholder="住址" required minlength="2" maxlength="50">
			<div class="help-block with-errors"></div>
		</div>
		
	</div>
	<div class="modal-footer">
		<button type="submit" class="btn btn-primary" data-loading-text="Loading...">提交</button>
		<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	</div>
</form>