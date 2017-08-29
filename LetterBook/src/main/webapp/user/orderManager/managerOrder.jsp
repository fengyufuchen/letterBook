<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ol class="breadcrumb">
	<li><a href="/user/userIndex">首页</a></li>

	<li class="active">我的订单</li>
</ol>

<form id="pagerForm" method="post"
	action="/userOrder/ordersPage">
	<input type="hidden" name="pageNum" value="1"> <input
		type="hidden" name="numPerPage" id="numPerPage"
		value="${page.numPerPage }" /> <input type="hidden" name="orderField"
		value="${orderField}" /> <input type="hidden" name="orderDirection"
		value="${orderDirection}" />

	<div class="row search-bar">
		<div class="col-sm-6">
			<a class="btn btn-success" data-history="repairOrder"
				href="/userOrder/orderPage">刷&nbsp;&nbsp;新</a>
		</div>
	</div>

</form>

<div class="row">
	<div class="col-lg-12">

		<table class="table table-hover td-relative">
			<thead>
				<tr>
					<th width="10%" orderField="oname"
						<c:if test="${orderField=='oname' }">class="${orderDirection}"</c:if>>收件人</th>
					<th width="10%" orderField="ophone"
						<c:if test="${orderField=='ophone' }">class="${orderDirection}"</c:if>>联系方式</th>
					<th width="20%" orderField="oadr"
						<c:if test="${orderField=='oadr' }">class="${orderDirection}"</c:if>>收件地址</th>
					<th width="10%" orderField="oprice"
						<c:if test="${orderField=='oprice' }">class="${orderDirection}"</c:if>>价格</th>
					<th width="20%" orderField="otime"
						<c:if test="${orderField=='otime' }">class="${orderDirection}"</c:if>>下单时间</th>
					<th width="10%" orderField="ostate"
						<c:if test="${orderField=='ostate' }">class="${orderDirection}"</c:if>>订单状态</th>
					<th style="width: 100px;">选择功能</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${page.content}" var="ord">
					<tr>
						<td>${ord.oname }</td>
						<td>${ord.ophone }</td>
						<td>${ord.oadr }</td>
						<td>${ord.oprice }</td>
						<td>${ord.otime }</td>
						<td><c:choose>
								<c:when test="${ord.ostate == 1 }">取消订单</c:when>
								<c:when test="${ord.ostate == 2 }">买家已付款</c:when>
								<c:when test="${ord.ostate == 3 }">卖家已发货</c:when>
								<c:when test="${ord.ostate == 4 }">交易成功</c:when>
							</c:choose></td>
						<td><a class="btn btn-primary" data-history
							href="/userOrder/orderContentPage?oid=${ord.oid}">查看</a>
							<a class="btn btn-warning" data-toggle="modal"
							data-target="#modal-dialog"
							href="/userOrder/editOrder?oid=${ord.oid}">修改</a> <a
							class="btn btn-danger" data-todo="ajaxTodo" title="确认删除该订单？"
							href="/userOrder/deleteOrder?oid=${ord.oid}">删除</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

</div>


<div class="row search-bar">
	<div class="col-sm-4">当前总共 ${page.totalCount } 条数据</div>
	<div class="col-sm-8" style="text-align: right">
		<div class="pagination" totalCount="${page.totalCount }"
			numPerPage="${page.numPerPage }" pageNumShown="${page.totalPageNum }"
			currentPage="${page.currentPage }"></div>
	</div>
</div>
