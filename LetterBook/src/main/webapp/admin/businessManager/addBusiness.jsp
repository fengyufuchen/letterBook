<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript">
</script>

<form class="pageForm required-validate" id="addBusiness" onsubmit="return validateCallback(this, dialogAjaxDone)" action="admin/adminBusiness/saveBusiness.action" method="post" novalidate="novalidate">

	<div class="pageFormContent" layouth="58" style="height: 203px; overflow: auto;">
		<div class="unit">
			<label style="float: center;">&nbsp;&nbsp;账&nbsp;&nbsp;&nbsp;&nbsp;号：</label>
			<input style="float: center;" class="required textInput" type="text" name="baccount">
		</div>
		<div class="unit">
			<label style="float: center;">&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
			<input style="float: center;" type="password"  name="bpsw"/>
		</div>						
		<div class="unit">
			<label style="float: center;">&nbsp;&nbsp;姓&nbsp;&nbsp;&nbsp;&nbsp;名：</label>
			<input style="float: center;" class="required textInput" type="text" name="bname">
		</div>
		<div class="unit">
			<label  style="float: center;">&nbsp;&nbsp;性&nbsp;&nbsp;&nbsp;&nbsp;别：</label>
			<input style="float: center;" type="radio" name="bsex" value="M" checked="checked">男
			<input style="float: center;" type="radio" name="bsex" value="F">女
		</div>
		<div class="unit">
			<label style="float: center;">&nbsp;&nbsp;身份证：</label>
			<input style="float: center;" class="required digits textInput" type="text"  name="bidcard"/>
		</div>
		<div class="unit">
			<label style="float: center;">&nbsp;&nbsp;住&nbsp;&nbsp;&nbsp;&nbsp;址：</label>
			<input style="float: center;" class="required textInput" type="text" name="badr">
		</div>
		<div class="unit">
			<label style="float: center;">&nbsp;&nbsp;手&nbsp;&nbsp;&nbsp;&nbsp;机：</label>
			<input style="float: center;" class="required digits textInput" type="text"  name="bphone"/>
		</div>
		<div class="unit">
			<label style="float: center;">&nbsp;&nbsp;邮&nbsp;&nbsp;&nbsp;&nbsp;箱：</label>
			<input style="float: center;" class="required email textInput" type="text"  name="bemail"/>
		</div>
		<div class="unit">
			<label  style="float: center;">&nbsp;&nbsp;有效状态：</label>
			<select style="float: center;" class="required combox" name="enabled">
				<option value="0">停&nbsp;&nbsp;用&nbsp;&nbsp;</option>
				<option value="1" selected="selected">正&nbsp;&nbsp;常&nbsp;&nbsp;</option>
				<option value="2">待审核</option>
			</select>
		</div>
	</div>
	<div class="formBar">
		<ul>
			<li>
				<div class="buttonActive">
					<div class="buttonContent">
						<button type="submit" id="subBtn">提交</button>
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