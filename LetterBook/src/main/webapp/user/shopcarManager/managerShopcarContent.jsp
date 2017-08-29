<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ol class="breadcrumb">
	<li><a href="/user/userIndex">首页</a></li>

	<li class="active">我的评论</li>
</ol>
<!-- dwz分页组件 -->

<form id="pagerForm" method="post"
	action="/userShopcar/shopcarContentManagerPage">
	<input type="hidden" name="pageNum" value="1"> <input
		type="hidden" name="numPerPage" id="numPerPage"
		value="${page.numPerPage }" /> <input type="hidden" name="orderField"
		value="${orderField}" /> <input type="hidden" name="orderDirection"
		value="${orderDirection}" />

	<div class="row search-bar">
		<div class="col-sm-6">
			<a class="btn btn-success" data-toggle="modal"
				data-target="#modal-dialog" href="/userShopcar/shopcarContentCount">去结算</a>
		</div>
	</div>

</form>

<div class="row">
	<div class="col-lg-12">

		<table class="table table-hover td-relative">
			<thead>
				<tr>
					<th width="25%">书名</th>
					<th width="15%">价格</th>
					<th width="15%">库存</th>
					<th width="15%">购买数量</th>
					<th style="width: 100px;">选择功能</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${page.content}" var="shopc">
					<tr>
						<td>${shopc.book.boname }</td>
						<td>${shopc.book.boprice }</td>
						<td>${shopc.book.boamount }</td>
						<td>${shopc.number }</td>
						<td><a class="btn btn-warning" data-toggle="modal"
							data-target="#modal-dialog"
							href="/userShopcar/editShopcarContent?sccid=${shopc.sccid}">修改数量</a>

<!-- navTab 页面上a 连接添加target=ajaxTo 后框架会自动绑定相应的ajax处理。 可选a 连接扩展属性 title="xx"提示确认信息 -->
							<a class="btn btn-danger" data-todo="ajaxTodo"
							title="确定将该图书从购物车中移除？"
							href="/userShopcar/deleteShopcarContent?sccid=${shopc.sccid}">移除图书</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

</div>


<div class="row search-bar">
	<div class="col-sm-4">当前总共 ${page.totalCount } 条数据</div>
	<div class="col-sm-8" style="text-align: right">

		<!-- 分页组件的使用方式 -->
		<div class="pagination" totalCount="${page.totalCount }"
			numPerPage="${page.numPerPage }" pageNumShown="${page.totalPageNum }"
			currentPage="${page.currentPage }"></div>
	</div>
</div>
