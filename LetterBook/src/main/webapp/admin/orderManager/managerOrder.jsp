<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 


<script type="text/javascript">

//全选与反选
function checkselectall(selectall){
	if(selectall.checked)
		$("input[name=oids]:checkbox").attr("checked",true);
	else
		$("input[name=oids]:checkbox").attr("checked",false);
}

//批删除提交
function delectOrder(){
	var objs=document.getElementsByName('oids');
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
				$("#deleteorder").submit();
			},
			cancelCall:function(){
			}
		});
	}
}
</script>

<!--分页的form-->
<form id="pagerForm" action="admin/adminOrder/getmanagerOrderPage.action" method="post" >
	 <input type="hidden" name="pageNum" id="pageNum" value="1" />
	 <input type="hidden" name="numPerPage" id="numPerPage" value="${page.numPerPage }" />
	 <input type="hidden" name="orderField" value="${orderField}" />
     <input type="hidden" name="orderDirection" value="${orderDirection}" />
</form>	

<div class="pageOrder">
	<form id="deleteorder" rel="pagerForm" onsubmit="return validateCallback(this, dialogAjaxDone);" action="admin/adminOrder/deleteOrder.action" method="post">
	<div class="panelBar">
		<ul class="toolBar">
			<li>
				<a class="add" mask="true" target="navTab" title="订单内容" rel="orderContentManager" fresh="true" href="admin/adminOrderContent/getmanagerOrderContentPage.action?oid={oid}" warn="请选择一个订单!">
					<span>查看内容</span>
				</a>
			</li>
			<li>
				<a class="edit" mask="true" target="dialog" fresh="true" href="admin/adminOrder/editOrder.action?oid={oid}" warn="请选择一个订单!">
					<span>修改</span>
				</a>
			</li>
			<li>
				<a class="delete" id="deleteall" onclick="delectOrder();">
					<span>删除</span>
				</a>
			</li>
			<li>
				<a class="icon" href="admin/adminOrder/getmanagerOrderPage.action" target="navTab" fresh="true" rel="orderManager" title="订单管理">
					<span>刷新</span>
				</a>
			</li>
		</ul>
	</div>
	
	<table class="table" width="100%" layoutH="76">
		<thead>
			<tr>
				<th width="4%" align="center"><input type="checkbox" id="selectall" onclick="checkselectall(this);"></th>
				<th width="12%" align="center" orderField="oname" <c:if test="${orderField=='oname' }">class="${orderDirection}"</c:if> >收件人</th>
				<th width="12%" align="center" orderField="ophone" <c:if test="${orderField=='ophone' }">class="${orderDirection}"</c:if> >联系方式</th>
				<th width="12%" align="center" orderField="otime" <c:if test="${orderField=='otime' }">class="${orderDirection}"</c:if> >下单时间</th>
				<th width="12%" align="center" orderField="oprice" <c:if test="${orderField=='oprie' }">class="${orderDirection}"</c:if> >订单价格</th>
				<th width="12%" align="center" orderField="ostate" <c:if test="${orderField=='ostate' }">class="${orderDirection}"</c:if> >交易状态</th>
				<th width="12%" align="center" orderField="enabled" <c:if test="${orderField=='enabled' }">class="${orderDirection}"</c:if> >订单状态</th>
				<th width="12%" align="center">所属客户</th>
				<th width="12%" align="center">所属商家</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.content}" var="ord">
				<tr target="oid" rel="${ord.oid}">
					<td align="center"><input name="oids"  type="checkbox" value="${ord.oid}"></td>
					<td align="center">${ord.oname }</td>
					<td align="center">${ord.ophone }</td>
					<td align="center">${ord.otime }</td>
					<td align="center">${ord.oprice }</td>
					<td align="center">
						<c:choose>
							<c:when test="${ord.ostate == 1 }">取消订单</c:when>
							<c:when test="${ord.ostate == 2 }">买家已付款</c:when>
							<c:when test="${ord.ostate == 3 }">卖家已发货</c:when>
							<c:when test="${ord.ostate == 4 }">待评价</c:when>
							<c:when test="${ord.ostate == 5 }">交易成功</c:when>
						</c:choose>
					</td>
					<td align="center">
						<c:choose>
							<c:when test="${ord.enabled == 0 }">停用</c:when>
							<c:when test="${ord.enabled == 1 }">正常</c:when>
						</c:choose>
					</td>
					<td align="center">${ord.user.uname }</td>
					<td align="center">${ord.business.bname }</td>
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