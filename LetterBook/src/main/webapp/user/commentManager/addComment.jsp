<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<form method="post" action="/userComment/saveComment"
	class="required-validate">
	<input type="hidden" name="boid" value="${boid }" />
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal">
			<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
		</button>
		<h4 class="modal-title">新建评论</h4>
	</div>
	<div class="modal-body">

		<div class="form-group">
			<label for="input-nickname">我的评论：</label> <input type="text"
				name="cocomment" style="width: 100%; height: 20%;"
				class="form-control" id="input-nickname">
		</div>

	</div>
	<div class="modal-footer">
		<button type="submit" class="btn btn-primary"
			data-loading-text="Loading...">提交</button>
		<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	</div>
</form>