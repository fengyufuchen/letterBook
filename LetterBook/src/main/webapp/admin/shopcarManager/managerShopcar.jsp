<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 


<script type="text/javascript">

//全选与反选
function checkselectall(selectall){
	if(selectall.checked)
		$("input[name=scids]:checkbox").attr("checked",true);
	else
		$("input[name=scids]:checkbox").attr("checked",false);
}

//批删除提交
function delectShopcar(){
	var objs=document.getElementsByName('scids');
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
				$("#deleteshopcar").submit();
			},
			cancelCall:function(){
			}
		});
	}
}
</script>

<!--分页的form-->
<form id="pagerForm" action="admin/adminShopcar/getmanagerShopcarPage.action" method="post" >
	 <input type="hidden" name="pageNum" id="pageNum" value="1" />
	 <input type="hidden" name="numPerPage" id="numPerPage" value="${page.numPerPage }" />
	 <input type="hidden" name="orderField" value="${orderField}" />
     <input type="hidden" name="orderDirection" value="${orderDirection}" />
</form>	

<div class="pageOrder">
	<form id="deleteshopcar" rel="pagerForm" onsubmit="return validateCallback(this, dialogAjaxDone);" action="admin/adminShopcar/deleteShopcar.action" method="post">
	<div class="panelBar">
		<ul class="toolBar">
			<li>
				<a class="add" mask="true" target="navTab" title="购物车内容" rel="shopcarContentManager" fresh="true" href="admin/adminShopcarContent/getmanagerShopcarContentPage.action?scid={scid}" warn="请选择一个购物车!">
					<span>查看内容</span>
				</a>
			</li>
			<li>
				<a class="edit" mask="true" target="dialog" fresh="true" href="admin/adminShopcar/editShopcar.action?scid={scid}" warn="请选择一个购物车!">
					<span>修改</span>
				</a>
			</li>
			<li>
				<a class="delete" id="deleteall" onclick="delectShopcar();">
					<span>删除</span>
				</a>
			</li>
			<li>
				<a class="icon" href="admin/adminShopcar/getmanagerShopcarPage.action" target="navTab" fresh="true" rel="shopcarManager" title="购物车管理">
					<span>刷新</span>
				</a>
			</li>
		</ul>
	</div>
	
	<table class="table" width="100%" layoutH="76">
		<thead>
			<tr>
				<th width="4%" align="center"><input type="checkbox" id="selectall" onclick="checkselectall(this);"></th>
				<th width="30%" align="center">客户</th>
				<th width="16%" align="center" orderField="enabled" <c:if test="${orderField=='enabled' }">class="${orderDirection}"</c:if> >状态</th>
				<th width="25%" align="center" orderField="createtime" <c:if test="${orderField=='createtime' }">class="${orderDirection}"</c:if> >创建时间</th>
				<th width="25%" align="center" orderField="updatetime" <c:if test="${orderField=='updatetime' }">class="${orderDirection}"</c:if> >更新时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.content}" var="sc">
				<tr target="scid" rel="${sc.scid}">
					<td align="center"><input name="scids"  type="checkbox" value="${sc.scid}"></td>
					<td align="center">${sc.user.uname }</td>
					<td align="center">
						<c:choose>
							<c:when test="${sc.enabled == 0 }">停用</c:when>
							<c:when test="${sc.enabled == 1 }">正常</c:when>
						</c:choose>
					</td>
					<td align="center">${sc.createtime }</td>
					<td align="center">${sc.updatetime }</td>
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