<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<ol class="breadcrumb">
	<li><a href="/user/userIndex">首页</a></li>
	<li class="active">我的评论</li>
</ol>

<form id="pagerForm" method="post" action="/userComment/commentsPage">
	<input type="hidden" name="pageNum" value="1">
	<input type="hidden" name="numPerPage" id="numPerPage" value="${page.numPerPage }" />
	<input type="hidden" name="orderField" value="${orderField}" />  
    <input type="hidden" name="orderDirection" value="${orderDirection}" />

	<div class="row search-bar">
		<div class="col-sm-6">
			<a class="btn btn-success" data-history="repairOrder" href="/userComment/commentsPage">刷&nbsp;&nbsp;新</a>
		</div>
	</div>

</form>

<div class="row">
	<div class="col-lg-12">

		<table class="table table-hover td-relative">
			<thead>
			<tr>
				<th width="20%">书名</th>
				<th width="20%" orderField="cocomment" <c:if test="${orderField=='cocomment' }">class="${orderDirection}"</c:if> >评论内容</th>
				<th width="20%" orderField="coreply" <c:if test="${orderField=='coreply' }">class="${orderDirection}"</c:if> >评论内容</th>
				<th width="20%" orderField="createtime" <c:if test="${orderField=='createtime' }">class="${orderDirection}"</c:if> >创建时间</th>
				<th style="width:100px;">选择功能</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${page.content}" var="co">
				<tr>
					<td>${co.bookTable.boname }</td>
					<td>${co.cocomment }</td>
					<td>${co.coreply }</td>
					<td>${co.createtime }</td>
					<td>
						<a class="btn btn-warning" data-toggle="modal" data-target="#modal-dialog" href="/userComment/editComment?coid=${co.coid}">修改</a>
						<a class="btn btn-danger" data-todo="ajaxTodo" title="确认删除该评论？" href="/userComment/deleteComment?coid=${co.coid}">删除</a>									
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
