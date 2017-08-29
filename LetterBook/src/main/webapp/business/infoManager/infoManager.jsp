<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)" action="business/businessInfo/updateBusiness.action" method="post" novalidate="novalidate">
	<input type="hidden" name="business.bid" value="${business.bid }"/>
	<input type="hidden" name="business.bpsw" value="${business.bpsw }"/>
	<input type="hidden" name="business.enabled" value="${business.enabled }"/>

	<div class="pageFormContent" layouth="58" style="height: 203px; overflow: auto;">
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</label>
			<input type="text"  name="business.baccount" disabled="true" value="${business.baccount }"/>
		</div>
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</label>
			<input class="required textInput" type="text"  name="business.bname" value="${business.bname }"/>
		</div>
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</label>
			<select class="required combox" name="business.bsex">
				<option value="M" <c:if test="${business.bsex=='M' }">selected="selected"</c:if>>男</option>
				<option value="F" <c:if test="${business.bsex=='F' }">selected="selected"</c:if>>女</option>
			</select>
		</div>
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;身&nbsp;&nbsp;份&nbsp;&nbsp;证：</label>
			<input class="required digits textInput" type="text"  name="business.bidcard" value="${business.bidcard }"/>
		</div>
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;住&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址：</label>
			<input class="required textInput" type="text"  name="business.badr" value="${business.badr }"/>
		</div>
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;手&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;机：</label>
			<input class="required digits textInput" type="text"  name="business.bphone" value="${business.bphone }"/>
		</div>
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：</label>
			<input class="required email textInput" type="text"  name="business.bemail" value="${business.bemail }"/>
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