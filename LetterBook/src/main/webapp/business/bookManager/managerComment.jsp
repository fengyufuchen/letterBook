<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!--分页的form-->
<form id="pagerForm" action="business/businessBook/getCommentPage.action" method="post" >
	 <input type="hidden" name="pageNum" id="pageNum" value="1" />
	 <input type="hidden" name="numPerPage" id="numPerPage" value="${page.numPerPage }" />
	 <input type="hidden" name="orderField" value="${orderField}" />
     <input type="hidden" name="orderDirection" value="${orderDirection}" />
</form>	

<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li>
				<a class="edit" mask="true" target="dialog" fresh="true" href="business/businessBook/editsComment.action?coid={coid}" warn="请选择一个评论!">
					<span>回复</span>
				</a>
			</li>
			<li>
				<a class="icon" href="business/businessBook/getCommentPage.action" target="navTab" fresh="true" rel="commentManager" title="评论管理">
					<span>刷新</span>
				</a>
			</li>
		</ul>
	</div>
	
	<table class="table" width="100%" layoutH="76">
		<thead>
			<tr>
				<th width="10%" align="center">图书</th>
				<th width="10%" align="center">客户</th>				
				<th width="20%" align="center">评论内容</th>
				<th width="20%" align="center">回复内容</th>
				<th width="10%" align="center">状态</th>
				<th width="15%" align="center">创建时间</th>
				<th width="15%" align="center">更新时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.content}" var="co">
				<tr target="coid" rel="${co.coid}">
					<td align="center">${co.book.boname }</td>
					<td align="center">${co.user.uname }</td>	
					<td align="center">${co.cocomment }</td>
					<td align="center">${co.coreply }</td>
					<td align="center">
						<c:choose>
							<c:when test="${co.enabled == 0 }">停用</c:when>
							<c:when test="${co.enabled == 1 }">正常</c:when>
						</c:choose>
					</td>
					<td align="center">${co.createtime }</td>
					<td align="center">${co.updatetime }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox" name="numperPage" onchange="navTabPageBreak({numPerPage:this.value})">
					<option value="10" <c:if test="${page.numPerPage==10}">selected="selected"</c:if>>10</option>
					<option value="20" <c:if test="${page.numPerPage==20}">selected="selected"</c:if>>20</option>
					<option value="30" <c:if test="${page.numPerPage==30}">selected="selected"</c:if>>30</option>
					<option value="50" <c:if test="${page.numPerPage==50}">selected="selected"</c:if>>50</option>
					<option value="100" <c:if test="${page.numPerPage==100}">selected="selected"</c:if>>100</option>
			</select>
			<span> 条，共${page.totalCount }条</span>
		</div>
		<!--分页组件-->
		<div class="pagination" targetType="navTab" totalCount="${page.totalCount }" numPerPage="${page.numPerPage }" pageNumShown="${page.totalPageNum }" currentPage="${page.currentPage }"></div>
	</div>
</div>