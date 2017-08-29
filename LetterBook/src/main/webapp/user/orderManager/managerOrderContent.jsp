<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<ol class="breadcrumb">
	<li><a href="/user/userIndex">首页</a></li>

	<li class="active">订单内容</li>
</ol>

<form id="pagerForm" method="post" action="userOrder/getOrderContentPage.action">
	<input type="hidden" name="pageNum" value="1">
	<input type="hidden" name="oid" value="${oid}" >
	<input type="hidden" name="numPerPage" id="numPerPage" value="${page.numPerPage }" />
	<input type="hidden" name="orderField" value="${orderField}" />  
    <input type="hidden" name="orderDirection" value="${orderDirection}" />


</form>

<div class="row">
	<div class="col-lg-12">

		<table class="table table-hover td-relative">
			<thead>
			<tr>
				<th width="25%">书名</th>
				<th width="25%">价格</th>
				<th width="25%">数量</th>
				<th width="25%">选择功能</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${page.content}" var="ordc">
				<tr>
					<td>${ordc.bookTable.boname }</td>
					<td>${ordc.bookTable.boprice }</td>
					<td>${ordc.number }</td>
					<td>
						<a class="btn btn-primary" data-toggle="modal" data-target="#modal-dialog" 
						<c:choose>
							<c:when test="${ordc.orderTable.ostate == '4' }">href="/userComment/addComment?boid=${ordc.book.boid}"</c:when>
							<c:when test="${ordc.orderTable.ostate != '4' }"> disabled="true" </c:when>
						</c:choose>>评论</a>								
					</td>				
				</tr>			
			</c:forEach>
			</tbody>
		</table>

	</div>

</div>


<div class="row search-bar">
	<div class="col-sm-4">
		当前总共 ${page.totalCount } 条数据
	</div>
	<div class="col-sm-8" style="text-align: right">
		<div class="pagination" totalCount="${page.totalCount }"  numPerPage="${page.numPerPage }" pageNumShown="${page.totalPageNum }" currentPage="${page.currentPage }"></div>
	</div>
</div>
