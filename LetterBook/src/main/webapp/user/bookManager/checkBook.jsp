<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 


<form method="post" action="" class="required-validate">
	<input type="hidden" name="book.boid" value="${book.boid }"/>
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
		<h4 class="modal-title">查看图书</h4>
	</div>
	<div class="modal-body">
			
		<div class="form-group">
			<label for="input-nickname">书名：</label>
			<input type="text" name="book.boname" disabled="true" value="${book.boname }" class="form-control" id="input-nickname">
			<div class="help-block with-errors"></div>
		</div>

		<div class="form-group">
			<label for="input-nickname">价格：</label>
			<input type="text" name="book.boprice" disabled="true" value="${book.boprice }" class="form-control" id="input-nickname">
			<div class="help-block with-errors"></div>
		</div>
		
		<div class="form-group">
			<label for="input-nickname">出版社：</label>
			<input type="text" name="book.bopress" disabled="true" value="${book.bopress }" class="form-control" id="input-nickname">
			<div class="help-block with-errors"></div>
		</div>
		
		<div class="form-group">
			<label for="input-nickname">出版时间：</label>
			<input type="text" name="book.botime" disabled="true" value="${book.botime }" class="form-control" id="input-nickname">
			<div class="help-block with-errors"></div>
		</div>
		
		<div class="form-group">
			<label for="input-nickname">简介：</label>
			<input type="text" name="book.boauthor" style="width:100%;height:20%;" disabled="true" value="${book.bosummary }" class="form-control" id="input-nickname">
			<div class="help-block with-errors"></div>
		</div>
		
		<div class="form-group">
			<label for="input-nickname">已售数量：</label>
			<input type="text" name="book.boamount" disabled="true" value="${book.boamount }" class="form-control" id="input-nickname">
			<div class="help-block with-errors"></div>
		</div>
		
		<div class="form-group">
			<label for="input-nickname">封面：</label>
			<img src="${book.boimg }" height="100%" width="100%" />
			<div class="help-block with-errors"></div>
		</div>	
	
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	</div>
</form>
