<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 


<form method="post" action="/userShopcar/summitOrder" class="required-validate">
	<input type="hidden" name="" value="${s}"/>
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
		<h4 class="modal-title">订单信息</h4>
	</div>
	<div class="modal-body">
		<div class="form-group">
			<table class="table table-hover td-relative">
			<thead>
				<tr>
					<th width="60%">书名</th>
					<th width="20%">价格</th>
					<th width="20%">购买数量</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${page.content}" var="shopc">
					<tr>
						<td>${shopc.book.boname }</td>
						<td>${shopc.book.boprice }</td>
						<td>${shopc.number }</td>				
					</tr>			
				</c:forEach>
			</tbody>
			</table>
		</div>
		<div class="form-group">
			<label for="input-nickname">总价：</label>
			<input type="text" name="oprice" value="${oprict }" class="form-control" id="input-nickname" disabled="true">
			<div class="help-block with-errors"></div>
		</div>
		<div class="form-group">
			<label for="input-nickname">收件人：</label>
			<input type="text" name="oname" class="form-control" id="input-nickname" placeholder="姓名" required minlength="2" maxlength="20">
			<div class="help-block with-errors"></div>
		</div>
		<div class="form-group">
			<label for="input-mobile">联系方式：</label>
			<input type="tel"  name="ophone" class="form-control" id="input-mobile" placeholder="手机" required minlength="11" maxlength="20" data-error="手机号非法">
			<div class="help-block with-errors"></div>
		</div>
		<div class="form-group">
			<label for="input-nickname">收件地址：</label>
			<input type="text" name="oadr"  class="form-control" id="input-nickname" placeholder="住址" required minlength="2" maxlength="100">
			<div class="help-block with-errors"></div>
		</div>
		

	</div>
	<div class="modal-footer">
		<button type="submit" class="btn btn-primary" data-loading-text="Loading...">确认下单</button>
		<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	</div>
</form>