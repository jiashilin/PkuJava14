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
		<a href="statistic.jsp">数据统计</a></nav> </header>
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
					<span>搜索</span>文章
				</p>
			</h2>
		<%
				List articleList = null;
				if(session.getAttribute("searcharticleList")!=null){
					articleList=(List)session.getAttribute("searcharticleList");
				for (int i = 0; i < articleList.size()&&i<5; i++) {
					Article article = (Article) articleList.get(i);
			%>
			<div style="text-align:center; vertical-align:middel; margin: 0 20px 20px 20px; position: relative;   padding-top:10px;  padding-right:0.25em;    padding-bottom:2ex;">
				<h3 style="text-align:left; font-size: 14px; font-weight: bold; margin-bottom: 15px; transition: all .5s">
					<a  style="color: #474645;" href="ArticleDetailServlet?id=<%=article.getId() %>"><%=article.getTitle()%></a>
					<p class="autor">
					<span>作者：</span><span><%=article.getAuthor()%></span><span>浏览</span><span>（<%=article.getView()%>）</span><span>发表时间：</span><span><%=article.getTime()%></span>
					</p>
					<a href="ArticleDetailServlet?id=<%=article.getId() %>" class="readmore">阅读全文&gt;&gt;</a>
				
				</h3>
				
				
				<div class="dateview"><%=article.getTime()%></div>
			</div>
			<%
				}
				}
			%>


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
