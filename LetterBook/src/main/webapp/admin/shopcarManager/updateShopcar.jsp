<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone)" action="admin/adminShopcar/updateShopcar.action" method="post" novalidate="novalidate">
	<input type="hidden" name="shopcar.scid" value="${shopcar.scid }"/>
	<div class="pageFormContent" layouth="58" style="height: 203px; overflow: auto;">
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;客&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;户：</label>
			<input type="text"  name="shopcar.user.uname" disabled="true" value="${shopcar.user.uname }"/>
		</div>

		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;有效状态：</label>
			<select class="required combox" name="shopcar.enabled">
				<option value="0" <c:if test="${shopcar.enabled == 0 }">selected="selected"</c:if>>停&nbsp;&nbsp;用&nbsp;&nbsp;</option>
				<option value="1" <c:if test="${shopcar.enabled == 1 }">selected="selected"</c:if>>正&nbsp;&nbsp;常&nbsp;&nbsp;</option>
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