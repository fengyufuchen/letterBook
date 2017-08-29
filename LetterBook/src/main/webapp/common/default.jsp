<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--  system values--%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="addr" value="http://${pageContext.request.serverName}:${pageContext.request.serverPort}" />
<c:set var="siteName" value="anyview" />

<script src="${ctx}/common/js/jq/jquery-1.8.3.min.js" type="text/javascript"></script>
<%-- css file define--%>
<link href="${ctx}/common/css/index.css" rel="stylesheet" type="text/css" media="screen" />

<link href="${ctx}/common/themes/type/default/style.css" rel="stylesheet" type="text/css" media="screen" />
<link href="${ctx}/common/themes/css/vcds/core.css" rel="stylesheet" type="text/css" media="screen" />
<link href="${ctx}/common/themes/css/vcds/print.css" rel="stylesheet" type="text/css" media="print" />
<link href="${ctx}/common/themes/css/vcds/uploadify.css" rel="stylesheet" type="text/css" media="print" />

<!-- user -->
<script src="${ctx}/common/js/common.js" type="text/javascript"></script>
<script src="${ctx}/common/js/index.js" type="text/javascript"></script>
<!-- jq -->
<script src="${ctx}/common/js/jq/jquery.cookie.js" type="text/javascript"></script>
<script src="${ctx}/common/js/jq/jquery.validate.js" type="text/javascript"></script>
<script src="${ctx}/common/js/jq/jquery.bgiframe.js" type="text/javascript"></script>
<!-- DWZ -->
<script src="${ctx}/common/js/vcds/dwz.ajax.js" type="text/javascript"></script>
<script src="${ctx}/common/js/vcds/dwz.tmpl.js" type="text/javascript"></script>
<script src="${ctx}/common/js/vcds/dwz.core.js" type="text/javascript"></script>
<script src="${ctx}/common/js/vcds/dwz.barDrag.js" type="text/javascript"></script>
<script src="${ctx}/common/js/vcds/dwz.drag.js" type="text/javascript"></script>
<script src="${ctx}/common/js/vcds/dwz.tree.js" type="text/javascript"></script>
<script src="${ctx}/common/js/vcds/dwz.accordion.js" type="text/javascript"></script>
<script src="${ctx}/common/js/vcds/dwz.ui.js" type="text/javascript"></script>
<script src="${ctx}/common/js/vcds/dwz.theme.js" type="text/javascript"></script>
<script src="${ctx}/common/js/vcds/dwz.switchEnv.js" type="text/javascript"></script>
<script src="${ctx}/common/js/vcds/dwz.alertMsg.js" type="text/javascript"></script>
<script src="${ctx}/common/js/vcds/dwz.contextmenu.js" type="text/javascript"></script>
<script src="${ctx}/common/js/vcds/dwz.navTab.js" type="text/javascript"></script>
<script src="${ctx}/common/js/vcds/dwz.tab.js" type="text/javascript"></script>
<script src="${ctx}/common/js/vcds/dwz.resize.js" type="text/javascript"></script>
<script src="${ctx}/common/js/vcds/dwz.dialog.js" type="text/javascript"></script>
<script src="${ctx}/common/js/vcds/dwz.dialogDrag.js" type="text/javascript"></script>
<script src="${ctx}/common/js/vcds/dwz.sortDrag.js" type="text/javascript"></script>
<script src="${ctx}/common/js/vcds/dwz.cssTable.js" type="text/javascript"></script>
<script src="${ctx}/common/js/vcds/dwz.database.js" type="text/javascript"></script>
<script src="${ctx}/common/js/vcds/dwz.effects.js" type="text/javascript"></script>
<script src="${ctx}/common/js/vcds/dwz.checkbox.js" type="text/javascript"></script>
<script src="${ctx}/common/js/vcds/dwz.stable.js" type="text/javascript"></script>
<script src="${ctx}/common/js/vcds/dwz.taskBar.js" type="text/javascript"></script>
<script src="${ctx}/common/js/vcds/dwz.pagination.js" type="text/javascript"></script>
<script src="${ctx}/common/js/vcds/dwz.panel.js" type="text/javascript"></script>
<script src="${ctx}/common/js/vcds/dwz.history.js" type="text/javascript"></script>
<script src="${ctx}/common/js/vcds/dwz.print.js" type="text/javascript"></script>
<script src="${ctx}/common/js/vcds/dwz.regional.zh.js" type="text/javascript"></script>
<script src="${ctx}/common/js/vcds/dwz.combox.js" type="text/javascript"></script>
<script src="${ctx}/common/js/vcds/dwz.util.date.js" type="text/javascript"></script>
<script src="${ctx}/common/js/vcds/dwz.datepicker.js" type="text/javascript"></script>
<script src="${ctx}/common/js/vcds/dwz.validate.method.js" type="text/javascript"></script>

<script src="${ctx}/common/js/vcds/raphael-min.js" type="text/javascript"></script>
<script src="${ctx}/common/js/vcds/g.raphael.js" type="text/javascript"></script>
<script src="${ctx}/common/js/vcds/g.pie.js" type="text/javascript"></script>
<script src="${ctx}/common/js/vcds/g.bar.js" type="text/javascript"></script>
<script src="${ctx}/common/js/vcds/highcharts.js" type="text/javascript"></script>
<script src="${ctx}/common/js/vcds/exporting.js" type="text/javascript"></script>
