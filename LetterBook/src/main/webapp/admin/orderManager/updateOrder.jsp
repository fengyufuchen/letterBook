<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone)" action="admin/adminOrder/updateOrder.action" method="post" novalidate="novalidate">
	<input type="hidden" name="order.oid" value="${order.oid }"/>
	<div class="pageFormContent" layouth="58" style="height: 203px; overflow: auto;">
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;客&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;户：</label>
			<input type="text"  name="order.user.uname" disabled="true" value="${order.user.uname }"/>
		</div>
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;商&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;家：</label>
			<input type="text" disabled="true" name="order.business.bname" value="${order.business.bname }"/>
		</div>
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;收&nbsp;&nbsp;件&nbsp;&nbsp;人：</label>
			<input class="required textInput" type="text"  name="order.oname" value="${order.oname }"/>
		</div>
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联系方式：</label>
			<input class="required digits textInput" type="text"  name="order.ophone" value="${order.ophone }"/>
		</div>
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;收件地址：</label>
			<input class="required textInput" type="text"  name="order.oadr" value="${order.oadr }"/>
		</div>
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;下单时间：</label>
			<input class="date textInput readonly required" type="text" name="order.otime" value="${order.otime }" readonly="true" dateFmt="yyyy-MM-dd HH:mm:ss.0">
			<a class="inputDateButton" href="javascript:;">选择</a>
		</div>
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;订单价格：</label>
			<input class="required textInput" type="text"  name="order.oprice" value="${order.oprice }"/>
		</div>
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;订单状态：</label>
			<select class="required combox" name="order.ostate">
				<option value="1" <c:if test="${order.ostate == 1 }">selected="selected"</c:if>>取消订单&nbsp;&nbsp;</option>
				<option value="2" <c:if test="${order.ostate == 2 }">selected="selected"</c:if>>买家已付款</option>
				<option value="3" <c:if test="${order.ostate == 3 }">selected="selected"</c:if>>卖家已发货</option>
				<option value="4" <c:if test="${order.ostate == 4 }">selected="selected"</c:if>>待评价</option>
				<option value="5" <c:if test="${order.ostate == 5 }">selected="selected"</c:if>>交易成功</option>
			</select>
		</div>
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;有效状态：</label>
			<select class="required combox" name="order.enabled">
				<option value="0" <c:if test="${order.enabled == 0 }">selected="selected"</c:if>>停&nbsp;&nbsp;用&nbsp;&nbsp;</option>
				<option value="1" <c:if test="${order.enabled == 1 }">selected="selected"</c:if>>正&nbsp;&nbsp;常&nbsp;&nbsp;</option>
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