<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<ol class="breadcrumb">
	<li><a href="/user/userIndex">首页</a></li>
	<li class="active">售书列表</li>
</ol>

<form id="pagerForm" method="post" action="/user/bookspage" onsubmit="return DWZ.dwzSearch(this)">
	<input type="hidden" name="pageNum" value="1">
	<input type="hidden" name="numPerPage" id="numPerPage" value="${page.numPerPage }" />
	<input type="hidden" name="orderField" value="${orderField}" />  
    <input type="hidden" name="orderDirection" value="${orderDirection}" />
    
	<div class="row">
		<div class="col-lg-5">
			<div class="input-group">
				<input type="text" name="boname" class="form-control" value="${condition.boname }"/>
				<span class="input-group-btn">
					<button class="btn btn-default" type="submit">搜索图书</button>
				</span>
			</div>
		</div>
		<div class="col-lg-5">
			<div class="input-group">
				<input type="text" name="boauthor" class="form-control" value="${condition.boauthor }"/>
				<span class="input-group-btn">
					<button class="btn btn-default" type="submit">搜索作者</button>
				</span>
			</div>
		</div>
	</div>

</form>

<div class="row">
	<div class="col-lg-12">

		<table class="table table-hover td-relative">
			<thead>
			<tr>
				<th width="20%" orderField="boname" <c:if test="${orderField=='boname' }">class="${orderDirection}"</c:if> >书名</th>
				<th width="18%" orderField="boauthor" <c:if test="${orderField=='boauthor' }">class="${orderDirection}"</c:if> >作者</th>
				<th width="18%" orderField="bopress" <c:if test="${orderField=='bopress' }">class="${orderDirection}"</c:if> >出版社</th>
				<th width="8%" orderField="boprice" <c:if test="${orderField=='boprice' }">class="${orderDirection}"</c:if> >单价</th>
				<th width="8%" orderField="boamount" <c:if test="${orderField=='boamount' }">class="${orderDirection}"</c:if> >库存</th>
				<th style="width:200px;">选择功能</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${page.content}" var="bok">
				<tr>
					<td>${bok.boname }</td>
					<td>${bok.boauthor }</td>
					<td>${bok.bopress }</td>
					<td>${bok.boprice }</td>
					<td>${bok.boamount }</td>
					<td>
						<a class="btn btn-primary" data-toggle="modal" data-target="#modal-dialog" href="/userBook/checkBook?boid=${bok.boid}">查看简介</a>
						<a class="btn btn-primary" data-toggle="modal" data-target="#modal-dialog" href="/userBook/getCommentByBoidPage?boid=${bok.boid}">查看评论</a>
						<a class="btn btn-warning" data-todo="ajaxTodo" title="确定将该图书加入购物车？" href="/userBook/addBookShopcar?boid=${bok.boid}">加入购物车</a>									
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
