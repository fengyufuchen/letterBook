<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone)" action="admin/adminComment/updateComment.action" method="post" novalidate="novalidate">
	<input type="hidden" name="comment.coid" value="${comment.coid }"/>
	<div class="pageFormContent" layouth="58" style="height: 203px; overflow: auto;">
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;客&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;户：</label>
			<input type="text"  name="comment.user.uname" disabled="true" value="${comment.user.uname }"/>
		</div>
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;图&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;书：</label>
			<input type="text" disabled="true" name="comment.book.boname" value="${comment.book.boname }"/>
		</div>
		
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;评论内容：</label>
			<input class="required textInput" type="text"  name="comment.cocomment" value="${comment.cocomment }"/>
		</div>
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;回复内容：</label>
			<input class="required textInput" type="text"  name="comment.coreply" value="${comment.coreply }"/>
		</div>
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;有效状态：</label>
			<select class="required combox" name="comment.enabled">
				<option value="0" <c:if test="${comment.enabled == 0 }">selected="selected"</c:if>>停&nbsp;&nbsp;用&nbsp;&nbsp;</option>
				<option value="1" <c:if test="${comment.enabled == 1 }">selected="selected"</c:if>>正&nbsp;&nbsp;常&nbsp;&nbsp;</option>
			</select>
		</div>
	</div>
	<div class="formBar">
		<ul>
			<li>
				<div class="buttonActive">
					<div class="buttonContent">
						<button type="submit">提交</button>
					</div>
				</div>
			</li>
			<li>
				<div class="button">
					<div class="buttonContent">
						<button class="close" type="button">取消</button>
					</div>
				</div>
			</li>
		</ul>
	</div>
</form>