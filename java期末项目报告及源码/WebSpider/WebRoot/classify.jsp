<%@ page language="java"
	import="java.util.*,com.csdn.dao.*,com.csdn.dao.ArticleDAO,com.csdn.model.*,com.csdn.servlet.*"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>个人博客</title>
<meta name="keywords" content="个人博客" />
<meta name="description" content="如影随形主题的个人博客模板，神秘、俏皮。" />
<link href="css/base.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">
<link href="css/media.css" rel="stylesheet">
<link href="css/classify.css" rel="stylesheet">
<meta name="viewport"
	content="width=device-width, minimum-scale=1.0, maximum-scale=1.0">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<div class="ibody">
		<header>
		<h1>无垠</h1>
		<h2>岁月如水 流到什么地方 就有什么样的时尚 我们怎能苛求 世事与沧桑....</h2>
		<div class="logo">
			<a href="index.jsp"></a>
		</div>
		<nav id="topnav">
		<a href="index.jsp">首页</a>
		<a href="search.jsp">搜索</a>
		<a href="classify.jsp">文章分类</a>
		<a href="statistic.jsp">数据统计</a></nav> 
		</header>
		<article>
		<div class="banner">
			<ul class="texts">
				<p>To feel the flame of dreaming and to feel the moment of
					dancing,when all</p>
				<p>the romance is far away,the eternity is always there.</p>
				<p>感受梦的火焰，感觉飞舞瞬间，当一切浪漫遥远，永恒依然。</p>
			</ul>
		</div>
		<div class="bloglist">
			<h2>
				<p>
					<span>文章</span>分类
				</p>
			</h2>
		</div>
		<div class="classify">
<div class="navbox">
<ul class="nav">
<h style="font-size:25px; font-family:songti;font-weight:bold;">编程语言</h>
<li><a href="ClassifyDetailServlet?str=java">Java</a></li>
<li><a href="ClassifyDetailServlet?str=C">C</a></li>
<li><a href="ClassifyDetailServlet?str=C++">C++</a></li>
<li><a href="ClassifyDetailServlet?str=python">Python</a></li>
<li><a href="ClassifyDetailServlet?str=C#">C#</a></li>
<li><a href="ClassifyDetailServlet?str=其他">其他</a></li>
</ul>
</div>

<div class="navbox">
<ul class="nav">
<h style="font-size:25px; font-family:songti;font-weight:bold;">数据库</h>
<li><a href="ClassifyDetailServlet?str=Oracle">Oracle</a></li>
<li><a href="ClassifyDetailServlet?str=Sybase">Sybase</a></li>
<li><a href="ClassifyDetailServlet?str=DB2">DB2</a></li>
<li><a href="ClassifyDetailServlet?str=Access">Access</a></li>
<li><a href="ClassifyDetailServlet?str=SQL Server">SQL Server</a></li>
<li><a href="ClassifyDetailServlet?str=mongobd">mongobd</a></li>
<li><a href="ClassifyDetailServlet?str=其他">其他</a></li>
</ul>
</div>

<div class="navbox">
<ul class="nav">
<h style="font-size:25px; font-family:songti;font-weight:bold;">Web前端</h>
<li><a href="ClassifyDetailServlet?str=html">HTML</a></li>
<li><a href="ClassifyDetailServlet?str=HTML5">HTML5</a></li>
<li><a href="ClassifyDetailServlet?str=CSS">CSS</a></li>
<li><a href="ClassifyDetailServlet?str=PHP">PHP</a></li>
<li><a href="ClassifyDetailServlet?str=JSP">JSP</a></li>
<li><a href="ClassifyDetailServlet?str=js">js</a></li>
<li><a href="ClassifyDetailServlet?str=ASP">ASP</a></li>
<li><a href="ClassifyDetailServlet?str=其他">其他</a></li>
</ul>
</div>




<div class="navbox">
<ul class="nav">
<h style="font-size:25px; font-family:songti;font-weight:bold;">云计算</h>
<li><a href="ClassifyDetailServlet?str=Hadoop">Hadoop</a></li>
<li><a href="ClassifyDetailServlet?str=OpenStack">OpenStack</a></li>
<li><a href="ClassifyDetailServlet?str=Spark">Spark</a></li>
<li><a href="ClassifyDetailServlet?str=其他">其他</a></li>
</ul>
</div>

<div class="navbox">
<ul class="nav">
<h style="font-size:25px; font-family:songti;font-weight:bold;">移动开发</h>
<li><a href="ClassifyDetailServlet?str=IOS">IOS</a></li>
<li><a href="ClassifyDetailServlet?str=Andriod">Andriod</a></li>
<li><a href="ClassifyDetailServlet?str=Windows Phone">Windows Phone</a></li>
<li><a href="ClassifyDetailServlet?str=其他">其他</a></li>
</ul>
</div>

<div class="navbox">
<ul class="nav">
<h style="font-size:25px; font-family:songti;font-weight:bold;">其他</h>
<li><a href="ClassifyDetailServlet?str=架构设计">架构设计</a></li>
<li><a href="ClassifyDetailServlet?str=系统运维">系统运维</a></li>
<li><a href="ClassifyDetailServlet?str=研发管理">研发管理</a></li>
</ul>
</div>

</div>
		</article>
		<aside>
		<div class="avatar">
			<a href="index.jsp"><span>关于无垠</span></a>
		</div>
		<div class="topspaceinfo">
			<h1>岁月静好，现世安稳</h1>
			<p>一剪闲云一溪月，一程山水一年华....</p>
		</div>
		<div class="about_c">
			<p>网名：无垠</p>
			<p>职业：程序员</p>
			<p>籍贯：山东-临沂</p>
			<p>电话：1301223****</p>
			<p>邮箱：970584280@qq.com</p>
		</div>
		<div class="bdsharebuttonbox">
			<a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a> <a
				href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a> <a
				href="#" class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博"></a> <a
				href="#" class="bds_renren" data-cmd="renren" title="分享到人人网"></a> <a
				href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a> <a
				href="#" class="bds_more" data-cmd="more"></a>
		</div>
		
		<div class="links">
			<h2>
				<p>友情链接</p>
			</h2>
			<ul>
				<li><a href="http://blog.csdn.net/wuyin1993">个人博客</a></li>
				<li><a href="http://blog.csdn.net/">CSDN技术社区</a></li>
			</ul>
		</div>
		<div class="copyright">
			<ul>
				<p>
					Design by <a href="http://blog.csdn.net/wuyin1993">Vast</a>
				</p>
				<p>鲁ICP备12345678号-1</p>
				</p>
			</ul>
		</div>
		</aside>
		<script src="js/silder.js"></script>
		<div class="clear"></div>
		<!-- 清除浮动 -->
	</div>
</body>
</html>
