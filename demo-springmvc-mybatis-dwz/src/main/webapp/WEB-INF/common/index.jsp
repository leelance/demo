<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>首页</title>

<link href="${ctx}/static/dwz/themes/default/style.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/static/dwz/themes/css/core.css" rel="stylesheet" type="text/css" />

<!--[if IE]>
<link href="<c:url value='/styles/dwz/themes/css/ieHack.css'/>" rel="stylesheet" type="text/css" />
<![endif]-->

<script src="${ctx}/static/dwz/js/speedup.js" type="text/javascript"></script>
<script src="${ctx}/static/dwz/js/jquery-1.7.2.js" type="text/javascript"></script>
<script src="${ctx}/static/dwz/js/jquery.cookie.js" type="text/javascript"></script>
<script src="${ctx}/static/dwz/js/jquery.validate.js" type="text/javascript"></script>
<script src="${ctx}/static/dwz/js/jquery.bgiframe.js" type="text/javascript"></script>

<script src="${ctx}/static/dwz/js/dwz.min.js" type="text/javascript"></script>
<script src="${ctx}/static/dwz/js/dwz.regional.zh.js" type="text/javascript"></script>
</head>
<script type="text/javascript">
$(function(){
	DWZ.init("${ctx}/static/dwz/dwz.frag.xml", {
		//loginTitle:"Login",	// 弹出登录对话框
		//loginUrl:"<c:url value='/login' />",	// 跳到登录页面
		pageInfo:{pageNum:"pageNum", numPerPage:"pageSize", orderField:"orderField", orderDirection:"orderDirection"}, 
		debug:false,	// 调试模式 【true|false】
		callback:function(){
			initEnv();
		}
	});
});

</script>
<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<a class="logo" href="javascript:void(0)">Logo</a>
				<ul class="nav">
					<li><a href="<c:url value='/'/>" target="website">Home</a></li>
					<li><a href="<c:url value='/passport/logout'/>">Log out</a></li>
				</ul>
			</div>
		</div>
		
		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse"><div></div></div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse"><h2>导航</h2><div>collapse</div></div>
			
				<div class="accordion" fillSpace="sideBar">
					<div class="accordionHeader">
						<h2><span>Folder</span>客户管理</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a href="" target="navTab" rel="websiteNav">创建客户</a></li>
							<li><a href="#" target="navTab" rel="pageLiNav">客户列表</a></li>
						</ul>
					</div>
					
					<div class="accordionHeader">
						<h2><span>Folder</span>系统管理</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a href="" target="navTab" rel="userLiNav">积分等级</a></li>
						</ul>
					</div>
					
					<div class="accordionHeader">
						<h2><span>Folder</span>其它</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder">
							<li><a href="" target="navTab" rel="newsLiNav">资讯管理</a></li>
						</ul>
					</div>
					
				</div>
				
			</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:void(0)"><span><span class="home_icon">My Home</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:void(0)">My Home</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div>
						<sitemesh:write property='body'/>
					</div>
				</div>
			</div>
		</div>

	</div>
	
	<div id="footer"><fmt:message key="ui.copyrights" /></div>


</body>
</html>