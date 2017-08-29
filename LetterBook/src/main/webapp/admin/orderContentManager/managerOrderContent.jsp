<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 


<script type="text/javascript">

//全选与反选
function checkselectall(selectall){
	if(selectall.checked)
		$("input[name=ocids]:checkbox").attr("checked",true);
	else
		$("input[name=ocids]:checkbox").attr("checked",false);
}

//批删除提交
function delectOrderContent(){
	var objs=document.getElementsByName('ocids');
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
				$("#deleteorderContent").submit();
			},
			cancelCall:function(){
			}
		});
	}
}
</script>

<!--分页的form-->
<form id="pagerForm" action="admin/adminOrderContent/getmanagerOrderContentPage.action" method="post" >
	 <input type="hidden" name="pageNum" id="pageNum" value="1" />
	 <input type="hidden" name="numPerPage" id="numPerPage" value="${page.numPerPage }" />
	 <input type="hidden" name="orderField" value="${orderField}" />
     <input type="hidden" name="orderDirection" value="${orderDirection}" />
</form>	

<div class="pageOrder">
	<form id="deleteorderContent" rel="pagerForm" onsubmit="return validateCallback(this, dialogAjaxDone);" action="admin/adminOrderContent/deleteOrderContent.action" method="post">
	<div class="panelBar">
		<ul class="toolBar">
			<li>
				<a class="edit" mask="true" target="dialog" fresh="true" href="admin/adminOrderContent/editOrderContent.action?ocid={ocid}" warn="请选择一个订单内容!">
					<span>修改</span>
				</a>
			</li>
			<li>
				<a class="delete" id="deleteall" onclick="delectOrderContent();">
					<span>删除</span>
				</a>
			</li>
			<li>
				<a class="icon" href="admin/adminOrderContent/getmanagerOrderContentPage.action" target="navTab" fresh="true" rel="orderContentManager" title="订单内容">
					<span>刷新</span>
				</a>
			</li>
		</ul>
	</div>
	
	<table class="table" width="100%" layoutH="76">
		<thead>
			<tr>
				<th width="4%" align="center"><input type="checkbox" id="selectall" onclick="checkselectall(this);"></th>
				<th width="30%" align="center">图书</th>
				<th width="25%" align="center">作者</th>
				<th width="25%" align="center">价格</th>
				<th width="16%" align="center" orderField="number" <c:if test="${orderField=='number' }">class="${orderDirection}"</c:if> >数量</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.content}" var="ordc">
				<tr target="ocid" rel="${ordc.ocid}">
					<td align="center"><input name="ocids"  type="checkbox" value="${ordc.ocid}"></td>
					<td align="center">${ordc.book.boname }</td>
					<td align="center">${ordc.book.boauthor }</td>
					<td align="center">${ordc.book.boprice }</td>
					<td align="center">${ordc.number }</td>
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