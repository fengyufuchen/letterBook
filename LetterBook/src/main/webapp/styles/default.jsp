<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--  system values--%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="addr" value="http://${pageContext.request.serverName}:${pageContext.request.serverPort}" />
<c:set var="siteName" value="workplan" />

<link rel="shortcut icon" href="${ctx}/styles/images/workplan.png" type="image/x-icon" />
<link href="${ctx}/styles/css/font-awesome.min.css" rel="stylesheet">
<link href="${ctx}/styles/css/prettify-1.0.css" rel="stylesheet">     
<link href="${ctx}/styles/css/bootstrap-datetimepicker.css" rel="stylesheet">

<!-- Bootstrap core CSS -->
<link href="${ctx}/styles/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${ctx}/styles/css/style.css" rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="${ctx}/styles/js/ie10-viewport-bug-workaround.js"></script>
<script src="${ctx}/styles/js/html5shiv.min.js"></script>
<script src="${ctx}/styles/js/respond.min.js"></script>
	
<script src="${ctx}/styles/js/jquery-1.12.0.min.js"></script>
<script src="${ctx}/styles/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>

<script src="${ctx}/styles/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script src="${ctx}/styles/jquery-validation-1.14.0/dist/additional-methods.min.js"></script>
<script src="${ctx}/styles/jquery-validation-1.14.0/dist/localization/messages_zh.min.js"></script>

<script src="${ctx}/styles/js/dwz.core.js"></script>
<script src="${ctx}/styles/js/dwz.history.js"></script>
<script src="${ctx}/styles/js/dwz.pagination.js"></script>
<script src="${ctx}/styles/js/dwz.ui.js"></script>
<script src="${ctx}/styles/js/dwz.regional.zh.js"></script>

<script type="text/javascript" src="${ctx}/styles/js/jquery-2.1.1.min.js"></script>
<script src="${ctx}/styles/js/moment-with-locales.js"></script>
<script src="${ctx}/styles/js/bootstrap-datetimepicker.js"></script>

