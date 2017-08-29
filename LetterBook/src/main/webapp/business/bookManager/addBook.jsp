<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form name = "form" enctype="multipart/form-data" class="pageForm required-validate" onclick = "return ajaxFileUpload()"  action="business/businessBook/saveBook.action" method="post" novalidate="novalidate" >

	<div class="pageFormContent" layouth="58" style="height: 203px; overflow: auto;">
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;书&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</label>
			<input type="required textInput"  name="boname"/>
		</div>
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;者：</label>
			<input class="required textInput" type="text"  name="boauthor"/>
		</div>
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;格：</label>
			<input class="required textInput" type="text"  name="boprice"/>
		</div>
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;出&nbsp;&nbsp;版&nbsp;&nbsp;社：</label>
			<input class="required textInput" type="text"  name="bopress"/>
		</div>
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;出版时间：</label>
			<input class="date textInput readonly required" type="text" name="botime" readonly="true" dateFmt="yyyy-MM-dd HH:mm:ss.0">
			<a class="inputDateButton" href="javascript:;">选择</a>
		</div>
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;总&nbsp;&nbsp;数&nbsp;&nbsp;量：</label>
			<input class="required digits textInput" type="text"  name="bonumber""/>
		</div>	
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;书本简介：</label>			
		</div>
			<textarea type="textarea" name="bosummary" cols="55" rows="5" ></textarea>
		<div class="unit">
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;图书封面：</label>		
     		<input type="file" name="upload" siez="20" accept=".jpg">
		</div>	
	</div>
	<div class="formBar">
		<ul>
			<li>
				<div class="buttonActive">
					<div class="buttonContent">
						<button type="submit">提交</button>
					</div>
				</div>
			</li>
			<li>
				<div class="button">
					<div class="buttonContent">
						<button class="close" type="button">取消</button>
					</div>
				</div>
			</li>
		</ul>
	</div>
</form>
<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript" src="ajaxfileupload.js"></script>

