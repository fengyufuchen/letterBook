<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 


<script type="text/javascript">

//全选与反选
function checkselectall(selectall){
	if(selectall.checked)
		$("input[name=uids]:checkbox").attr("checked",true);
	else
		$("input[name=uids]:checkbox").attr("checked",false);
}

//批删除提交
function delectUser(){
	var objs=document.getElementsByName('uids');
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
				$("#deleteuser").submit();
			},
			cancelCall:function(){
			}
		});
	}
}
</script>

<!--分页的form-->
<form id="pagerForm" action="admin/adminUser/getmanagerUserPage.action" method="post" >
</form>		

<div class="pageHeader">
				
<!--查询的form-->
<form id="searchClass" rel="pagerForm" onsubmit="return navTabSearch(this);" action="admin/adminUser/getmanagerUserPage.action" method="post">
	 <input type="hidden" name="pageNum" id="pageNum" value="1" />
	 <input type="hidden" name="numPerPage" id="numPerPage" value="${page.numPerPage }" />
	 <input type="hidden" name="orderField" value="${orderField}" />  
     <input type="hidden" name="orderDirection" value="${orderDirection}" />
			<div class="searchBar">
			<table class="searchContent">
			<tbody>
			<tr>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;账&nbsp;&nbsp;&nbsp;&nbsp;号：
					<input class="textInput" type="text" name="condition.uaccount" alt="输入客户账号" value="${condition.uaccount }"/>
				</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;姓&nbsp;&nbsp;&nbsp;&nbsp;名：
					<input class="textInput" type="text" name="condition.uname" alt="输入客户姓名" value="${condition.uname }"/>
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
	<form id="deleteuser" rel="pagerForm" onsubmit="return validateCallback(this, dialogAjaxDone);" action="admin/adminUser/deleteUser.action" method="post">
	<div class="panelBar">
		<ul class="toolBar">
			<li>
				<a class="add" mask="true" target="dialog" fresh="true" rel="userManager" href="admin/adminUser/addUser.action">
					<span>添加客户</span>
				</a>
			</li>
			<li >
				<a class="edit" mask="true" target="dialog" fresh="true" href="admin/adminUser/editUser.action?uid={uid}" warn="请选择一个客户!">
					<span>修改</span>
				</a>
			</li>
			<li>
				<a class="delete" id="deleteall" onclick="delectUser();">
					<span>删除</span>
				</a>
			</li>
			<li >
				<a class="icon" href="admin/adminUser/getmanagerUserPage.action" target="navTab" fresh="true" rel="userManager" title="客户管理">
					<span>刷新</span>
				</a>
			</li>
		</ul>
	</div>
	
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="4%" align="center"><input type="checkbox" id="selectall" onclick="checkselectall(this);"></th>
				<th width="10%" align="center" orderField="uaccount" <c:if test="${orderField=='uaccount' }">class="${orderDirection}"</c:if> >账号</th>
				<th width="10%" align="center" orderField="uname" <c:if test="${orderField=='uname' }">class="${orderDirection}"</c:if> >姓名</th>
				<th width="6%" align="center" orderField="usex" <c:if test="${orderField=='usex' }">class="${orderDirection}"</c:if> >性别</th>
				<th width="11%" align="center" orderField="uphone" <c:if test="${orderField=='uphone' }">class="${orderDirection}"</c:if> >手机</th>
				<th width="11%" align="center" orderField="uemail" <c:if test="${orderField=='uemail' }">class="${orderDirection}"</c:if> >邮箱</th>
				<th width="6%" align="center" orderField="enabled" <c:if test="${orderField=='enabled' }">class="${orderDirection}"</c:if> >有效状态</th>
				<th width="18%" align="center" orderField="uadr" <c:if test="${orderField=='uadr' }">class="${orderDirection}"</c:if> >住址</th>
				<th width="12%" align="center" orderField="createtime" <c:if test="${orderField=='createtime' }">class="${orderDirection}"</c:if> >创建时间</th>
				<th width="12%" align="center" orderField="updatetime" <c:if test="${orderField=='updatetime' }">class="${orderDirection}"</c:if> >更新时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.content}" var="us">
				<tr target="uid" rel="${us.uid}">
					<td align="center"><input name="uids"  type="checkbox" value="${us.uid}"></td>
					<td align="center">${us.uaccount }</td>
					<td align="center">${us.uname }</td>
					<td align="center">
						<c:choose>
							<c:when test="${us.usex == 'M' }">男</c:when>
							<c:otherwise>女</c:otherwise>
						</c:choose>
					</td>
					<td align="center">${us.uphone }</td>
					<td align="center">${us.uemail }</td>
					<td align="center">
						<c:choose>
							<c:when test="${us.enabled == 0 }">停用</c:when>
							<c:when test="${us.enabled == 1 }">正常</c:when>
						</c:choose>
					</td>
					<td align="center">${us.uadr }</td>
					<td align="center">${us.createtime }</td>
					<td align="center">${us.updatetime }</td>
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