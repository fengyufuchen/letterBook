<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 


<form method="post" action="/user/updateUser" class="required-validate">
	<input type="hidden" name="uid" value="${user.uid }"/>
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
		<h4 class="modal-title">我的信息</h4>
	</div>
	<div class="modal-body">

		<div class="form-group">
			<label for="input-nickname">账号</label>
			<input type="text" name="uaccount" class="form-control" id="input-nickname" value="${user.uaccount}" disabled="true" placeholder="账号" required minlength="2" maxlength="20">
		</div>
		<div class="form-group">
			<label for="input-nickname">姓名</label>
			<input type="text" name="uname" value="${user.uname }" class="form-control" id="input-nickname" placeholder="姓名" required minlength="2" maxlength="20">
			<div class="help-block with-errors"></div>
		</div>
		<div class="form-group">
			<label for="input-nickname">住址</label>
			<input type="text" name="uadr" value="${user.uadr }" class="form-control" id="input-nickname" placeholder="住址" required minlength="2" maxlength="50">
			<div class="help-block with-errors"></div>
		</div>
		<div class="form-group">
			<label for="input-mobile">手机</label>
			<input type="tel"  name="uphone" value="${user.uphone }" class="form-control" id="input-mobile" placeholder="手机" required minlength="11" maxlength="20" data-error="手机号非法">
			<div class="help-block with-errors"></div>
		</div>
		<div class="form-group">
			<label for="input-email">邮箱</label>
			<input type="email" name="uemail" value="${user.uemail }" class="form-control" id="input-email" placeholder="邮箱" required maxlength="100" data-error="邮箱非法">
			<div class="help-block with-errors"></div>
		</div>

	</div>
	<div class="modal-footer">
		<button type="submit" class="btn btn-primary" data-loading-text="Loading...">保存</button>
		<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	</div>
</form>