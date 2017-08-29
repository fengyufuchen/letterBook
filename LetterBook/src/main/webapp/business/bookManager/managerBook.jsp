<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 


<script type="text/javascript">

//全选与反选
function checkselectall(selectall){
	if(selectall.checked)
		$("input[name=boids]:checkbox").attr("checked",true);
	else
		$("input[name=boids]:checkbox").attr("checked",false);
}

//批删除提交
function delectBook(){
	var objs=document.getElementsByName('boids');
	var isSel=false;//判断是否有选中项，默认为无
	for(var i=0;i<objs.length;i++)
	{
	  if(objs[i].checked==true)
	   {
	    isSel=true;
	    break;
	   }
	}
	if(isSel==false)
	{
		 alertMsg.error("请选择要删除的数据！"); 
	}else
	{
		alertMsg.confirm("确定要删除选中项么？",{
			okCall:function(){
				$("#deletebook").submit();
			},
			cancelCall:function(){
			}
		});
	}
}
</script>

<!--分页的form-->
<form id="pagerForm" action="business/businessBook/getBookPage.action" method="post" >
</form>		

<div class="pageHeader">
				
<!--查询的form-->
<form id="searchClass" rel="pagerForm" onsubmit="return navTabSearch(this);" action="business/businessBook/getBookPage.action" method="post">
	 <input type="hidden" name="pageNum" id="pageNum" value="1" />
	 <input type="hidden" name="numPerPage" id="numPerPage" value="${page.numPerPage }" />
	 <input type="hidden" name="orderField" value="${orderField}" />  
     <input type="hidden" name="orderDirection" value="${orderDirection}" />
			<div class="searchBar">
			<table class="searchContent">
			<tbody>
			<tr>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;图&nbsp;&nbsp;&nbsp;&nbsp;书：
					<input class="textInput" type="text" name="condition.boname" alt="输入图书名字" value="${condition.boname }"/>
				</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;作&nbsp;&nbsp;&nbsp;&nbsp;者：
					<input class="textInput" type="text" name="condition.boauthor" alt="输入图书作者" value="${condition.boauthor }"/>
				</td>
			</tr>
			</tbody>
			</table>
						
			<div class="subBar">
				<ul>
					<li>
						<div class="buttonActive">
							<div class="buttonContent">
								<button type="submit" id="searchBtn">
									检索
								</button>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</form>
</div>
			

<div class="pageContent">
	<form id="deletebook" rel="pagerForm" onsubmit="return validateCallback(this, dialogAjaxDone);" action="business/businessBook/deleteBook.action" method="post">
	<div class="panelBar">
		<ul class="toolBar">
			<li>
				<a class="add" mask="true" target="dialog" fresh="true" rel="booksManager" href="business/businessBook/addBook.action">
					<span>添加图书</span>
				</a>
			</li>
			<li >
				<a class="edit" mask="true" target="dialog" fresh="true" href="business/businessBook/editBook.action?boid={boid}" warn="请选择一个图书!">
					<span>查看详情</span>
				</a>
			</li>
			<li >
				<a class="edit" mask="true" target="navTab" title="评论内容" rel="commentManager" fresh="true" href="business/businessBook/getCommentPage.action?boid={boid}" warn="请选择一个图书!">
					<span>查看评论</span>
				</a>
			</li>
			<li>
				<a class="delete" id="deleteall" onclick="delectBook();">
					<span>删除</span>
				</a>
			</li>
			<li >
				<a class="icon" href="business/businessBook/getBookPage.action" target="navTab" fresh="true" rel="booksManager" title="图书管理">
					<span>刷新</span>
				</a>
			</li>
		</ul>
	</div>
	
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="4%" align="center"><input type="checkbox" id="selectall" onclick="checkselectall(this);"></th>
				<th width="12%" align="center" orderField="boname" <c:if test="${orderField=='boname' }">class="${orderDirection}"</c:if> >书名</th>
				<th width="12%" align="center" orderField="boauthor" <c:if test="${orderField=='boauthor' }">class="${orderDirection}"</c:if> >作者</th>
				<th width="12%" align="center" orderField="boprice" <c:if test="${orderField=='boprice' }">class="${orderDirection}"</c:if> >价格</th>
				<th width="12%" align="center" orderField="bopress" <c:if test="${orderField=='bopress' }">class="${orderDirection}"</c:if> >出版社</th>
				<th width="16%" align="center" orderField="botime" <c:if test="${orderField=='botime' }">class="${orderDirection}"</c:if> >出版时间</th>
				<th width="12%" align="center" orderField="bosummary" <c:if test="${orderField=='bosummary' }">class="${orderDirection}"</c:if> >简介</th>
				<th width="7%" align="center" orderField="bonumber" <c:if test="${orderField=='bonumber' }">class="${orderDirection}"</c:if> >总数量</th>
				<th width="7%" align="center" orderField="boamount" <c:if test="${orderField=='boamount' }">class="${orderDirection}"</c:if> >剩余数量</th>
				<th width="6%" align="center" orderField="enabled" <c:if test="${orderField=='enabled' }">class="${orderDirection}"</c:if> >状态</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.content}" var="bo">
				<tr target="boid" rel="${bo.boid}">
					<td align="center"><input name="boids"  type="checkbox" value="${bo.boid}"></td>
					<td align="center">${bo.boname }</td>
					<td align="center">${bo.boauthor }</td>
					<td align="center">${bo.boprice }</td>
					<td align="center">${bo.bopress }</td>
					<td align="center">${bo.botime }</td>
					<td align="center">${bo.bosummary }</td>
					<td align="center">${bo.bonumber }</td>
					<td align="center">${bo.boamount }</td>
					<td align="center">
						<c:choose>
							<c:when test="${bo.enabled == 0 }">停用</c:when>
							<c:when test="${bo.enabled == 1 }">正常</c:when>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</form>
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