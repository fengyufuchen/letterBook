<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone)" action="admin/adminBook/updateBook.action" method="post" novalidate="novalidate">
	<input type="hidden" name="book.boid" value="${book.boid }"/>
	<div class="pageFormContent" layouth="58" style="height: 203px; overflow: auto;">
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;商&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;家：</label>
			<input type="text" disabled="true" name="book.business.bname" value="${book.business.bname }"/>
		</div>
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;书&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</label>
			<input type="required textInput"  name="book.boname" value="${book.boname }"/>
		</div>
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;者：</label>
			<input class="required textInput" type="text"  name="book.boauthor" value="${book.boauthor }"/>
		</div>
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;格：</label>
			<input class="required textInput" type="text"  name="book.boprice" value="${book.boprice }"/>
		</div>
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;出&nbsp;&nbsp;版&nbsp;&nbsp;社：</label>
			<input class="required textInput" type="text"  name="book.bopress" value="${book.bopress }"/>
		</div>
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;出版时间：</label>
			<input class="date textInput readonly required" type="text" name="book.botime" value="${book.botime }" readonly="true" dateFmt="yyyy-MM-dd HH:mm:ss.0">
			<a class="inputDateButton" href="javascript:;">选择</a>
		</div>
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;总&nbsp;&nbsp;数&nbsp;&nbsp;量：</label>
			<input class="required digits textInput" type="text"  name="book.bonumber" value="${book.bonumber }"/>
		</div>
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;剩余数量：</label>
			<input class="required digits textInput" type="text"  name="book.boamount" value="${book.boamount }"/>
		</div>		
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;有效状态：</label>
			<select class="required combox" name="book.enabled">
				<option value="0" <c:if test="${book.enabled == 0 }">selected="selected"</c:if>>停&nbsp;&nbsp;用&nbsp;&nbsp;</option>
				<option value="1" <c:if test="${book.enabled == 1 }">selected="selected"</c:if>>正&nbsp;&nbsp;常&nbsp;&nbsp;</option>
			</select>
		</div>
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;书本简介：</label>			
		</div>
			<textarea type="textarea" name="book.bosummary" cols="55" rows="5" >${book.bosummary }</textarea>
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;书本封面：</label>	
			<img src="${book.boimg }" height="380" width="320"/>
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