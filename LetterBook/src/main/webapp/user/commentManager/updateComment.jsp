<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 


<form method="post" action="/userComment/updateComment" class="required-validate">
	<input type="hidden" name="coid" value="${comment.coid }"/>
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
		<h4 class="modal-title">修改评论</h4>
	</div>
	<div class="modal-body">

		<div class="form-group">
			<label for="input-nickname">图书：</label>
			<input type="text" name="bookTable.boname" disabled="true" value="${comment.bookTable.boname }" class="form-control" id="input-nickname" placeholder="书名" required minlength="2" maxlength="50">
			<div class="help-block with-errors"></div>
		</div>
		<div class="form-group">
			<label for="input-nickname">我的评论：</label>
			<input type="text" name="cocomment" value="${comment.cocomment }" class="form-control" id="input-nickname" placeholder="计划表名" required minlength="2" maxlength="250">
			<div class="help-block with-errors"></div>
		</div>

	</div>
	<div class="modal-footer">
		<button type="submit" class="btn btn-primary" data-loading-text="Loading...">提交</button>
		<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	</div>
</form>