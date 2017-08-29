<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 


<form method="post" action="" class="required-validate">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
		<h4 class="modal-title">图书评论</h4>
	</div>
	<div class="modal-body">
			
		<div class="form-group">
			<table class="table table-hover td-relative">
				<thead>
				<tr>
					<th width="10%">客户</th>
					<th width="45%">评论</th>
					<th width="20%">发布时间</th>
					<th width="25%">商家回复</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach items="${page.content}" var="com">
					<tr>
						<td>${com.user.uname }</td>
						<td>${com.cocomment }</td>
						<td>${com.createtime }</td>
						<td>${com.coreply }</td>				
					</tr>			
				</c:forEach>
			</tbody>
			</table>
		</div>
	
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	</div>
</form>
