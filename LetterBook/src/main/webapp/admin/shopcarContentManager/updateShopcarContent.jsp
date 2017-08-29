<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone)" action="admin/adminShopcarContent/updateShopcarContent.action" method="post" novalidate="novalidate">
	<input type="hidden" name="shopcarContent.sccid" value="${shopcarContent.sccid }"/>
	<div class="pageFormContent" layouth="58" style="height: 203px; overflow: auto;">
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;图&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;书：</label>
			<input type="text" disabled="true" name="shopcarContent.book.boname" value="${shopcarContent.book.boname }"/>
		</div>
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;格：</label>
			<input type="text" disabled="true" name="shopcarContent.book.boprice" value="${shopcarContent.book.boprice }"/>
		</div>
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;量：</label>
			<input class="required digits textInput" type="text"  name="shopcarContent.number" value="${shopcarContent.number }"/>
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