<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 


<script type="text/javascript">

//全选与反选
function checkselectall(selectall){
	if(selectall.checked)
		$("input[name=bids]:checkbox").attr("checked",true);
	else
		$("input[name=bids]:checkbox").attr("checked",false);
}

//批删除提交
function delectBusiness(){
	var objs=document.getElementsByName('bids');
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
				$("#deletebusiness").submit();
			},
			cancelCall:function(){
			}
		});
	}
}
</script>

<!--分页的form-->
<form id="pagerForm" action="admin/adminBusiness/getmanagerBusinessPage.action" method="post" >
</form>		

<div class="pageHeader">
				
<!--查询的form-->
<form id="searchClass" rel="pagerForm" onsubmit="return navTabSearch(this);" action="admin/adminBusiness/getmanagerBusinessPage.action" method="post">
	 <input type="hidden" name="pageNum" id="pageNum" value="1" />
	 <input type="hidden" name="numPerPage" id="numPerPage" value="${page.numPerPage }" />
	 <input type="hidden" name="orderField" value="${orderField}" />  
     <input type="hidden" name="orderDirection" value="${orderDirection}" />
			<div class="searchBar">
			<table class="searchContent">
			<tbody>
			<tr>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;账&nbsp;&nbsp;&nbsp;&nbsp;号：
					<input class="textInput" type="text" name="condition.baccount" alt="输入商家账号" value="${condition.baccount }"/>
				</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;姓&nbsp;&nbsp;&nbsp;&nbsp;名：
					<input class="textInput" type="text" name="condition.bname" alt="输入商家姓名" value="${condition.bname }"/>
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
	<form id="deletebusiness" rel="pagerForm" onsubmit="return validateCallback(this, dialogAjaxDone);" action="admin/adminBusiness/deleteBusiness.action" method="post">
	<div class="panelBar">
		<ul class="toolBar">
			<li>
				<a class="add" mask="true" target="dialog" fresh="true" rel="businessManager" href="admin/adminBusiness/addBusiness.action">
					<span>添加商家</span>
				</a>
			</li>
			<li >
				<a class="edit" mask="true" target="dialog" fresh="true" href="admin/adminBusiness/editBusiness.action?bid={bid}" warn="请选择一个商家!">
					<span>修改</span>
				</a>
			</li>
			<li>
				<a class="delete" id="deleteall" onclick="delectBusiness();">
					<span>删除</span>
				</a>
			</li>
			<li >
				<a class="icon" href="admin/adminBusiness/getmanagerBusinessPage.action" target="navTab" fresh="true" rel="businessManager" title="商家管理">
					<span>刷新</span>
				</a>
			</li>
		</ul>
	</div>
	
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="4%" align="center"><input type="checkbox" id="selectall" onclick="checkselectall(this);"></th>
				<th width="10%" align="center" orderField="baccount" <c:if test="${orderField=='baccount' }">class="${orderDirection}"</c:if> >账号</th>
				<th width="10%" align="center" orderField="bname" <c:if test="${orderField=='bname' }">class="${orderDirection}"</c:if> >姓名</th>
				<th width="6%" align="center" orderField="ubsex" <c:if test="${orderField=='bsex' }">class="${orderDirection}"</c:if> >性别</th>
				<th width="18%" align="center" orderField="bidcard" <c:if test="${orderField=='bidcard' }">class="${orderDirection}"</c:if> >身份证</th>
				<th width="11%" align="center" orderField="bphone" <c:if test="${orderField=='bphone' }">class="${orderDirection}"</c:if> >手机</th>
				<th width="11%" align="center" orderField="bemail" <c:if test="${orderField=='bemail' }">class="${orderDirection}"</c:if> >邮箱</th>
				<th width="6%" align="center" orderField="enabled" <c:if test="${orderField=='enabled' }">class="${orderDirection}"</c:if> >有效状态</th>				
				<th width="12%" align="center" orderField="createtime" <c:if test="${orderField=='createtime' }">class="${orderDirection}"</c:if> >创建时间</th>
				<th width="12%" align="center" orderField="updatetime" <c:if test="${orderField=='updatetime' }">class="${orderDirection}"</c:if> >更新时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.content}" var="bu">
				<tr target="bid" rel="${bu.bid}">
					<td align="center"><input name="bids"  type="checkbox" value="${bu.bid}"></td>
					<td align="center">${bu.baccount }</td>
					<td align="center">${bu.bname }</td>
					<td align="center">
						<c:choose>
							<c:when test="${bu.bsex == 'M' }">男</c:when>
							<c:otherwise>女</c:otherwise>
						</c:choose>
					</td>
					<td align="center">${bu.bidcard }</td>
					<td align="center">${bu.bphone }</td>
					<td align="center">${bu.bemail }</td>
					<td align="center">
						<c:choose>
							<c:when test="${bu.enabled == 0 }">停用</c:when>
							<c:when test="${bu.enabled == 1 }">正常</c:when>
							<c:when test="${bu.enabled == 2 }">待审核</c:when>
						</c:choose>
					</td>			
					<td align="center">${bu.createtime }</td>
					<td align="center">${bu.updatetime }</td>
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