<%@ page language="java" import="java.util.*,com.csdn.dao.*,com.csdn.dao.Article,com.csdn.dao.ArticleDAO,com.csdn.model.*,com.csdn.servlet.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
		<title>个人博客</title>
		<meta name="keywords" content="个人博客" />
		<meta name="description" content="如影随形主题的个人博客模板，神秘、俏皮。" />
		<link href="css/base.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
		<link href="css/media.css" rel="stylesheet">
		<link href="css/index.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="css/demo.css" />
		<link rel="stylesheet" type="text/css" href="css/bookblock.css" />
		<link rel="stylesheet" type="text/css" href="css/component.css" />
		<meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0">
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
				<nav id="topnav"><a href="index.jsp">首页</a>
		<a href="search.jsp">搜索</a>
		<a href="classify.jsp">文章分类</a>
		<a href="statistic.jsp">数据统计</a></nav>
			</header>
			<article>
				<h2 class="about_h">您现在的位置是：<a href="index.html">首页</a>><a href="1/">诗歌欣赏</a></h2>
				<div class="news">
				<%
    	if(session.getAttribute("article")!=null){
    		Article artic=new Article();
    		artic=(Article)session.getAttribute("article");
    	%>	
					<h2 ><%=artic.getTitle()%></h2>
					<%=artic.getContent()%>
				</div>
				<div class="index_about">
					<div class="keybq">
						<p><span>关键字词</span><%=artic.getTag() %></p>
					</div>
					
					<div class="nextinfo">
						<p>上一篇：<a href="ArticleDetailServlet?id=<%=artic.getId()-1 %>">上一篇标题</a></p>
						<p>下一篇：<a href="ArticleDetailServlet?id=<%=artic.getId()+1 %>">下一篇标题</a></p>
					</div>	
					<%} %>				
				</div>
			</article>
			<aside>
				<div class="avatar"><a href="index.jsp"><span>关于无垠</span></a></div>
				<div class="topspaceinfo">
					<h1>岁月静好，现世安稳</h1>
					<p>一剪闲云一溪月，一程山水一年华....</p>
				</div>
				<div class="about_c">
					<p>网名：无垠 </p>
					<p>职业：程序员 </p>
					<p>籍贯：山东-临沂</p>
					<p>电话：1301223****</p>
					<p>邮箱：970584280@qq.com</p>
				</div>
				<div class="bdsharebuttonbox">
					<a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a>
					<a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a>
					<a href="#" class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博"></a>
					<a href="#" class="bds_renren" data-cmd="renren" title="分享到人人网"></a>
					<a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a>
					<a href="#" class="bds_more" data-cmd="more"></a>
				</div>
				<div class="links">
					<h2>
        <p>友情链接</p>
      </h2>
					<ul>
						<li><a href="/">个人博客</a></li>
						<li><a href="/">CSDN技术社区</a></li>
					</ul>
				</div>
				<div class="copyright">
					<ul>
						<p> Design by <a href="http://blog.csdn.net/wuyin1993">Vast</a></p>
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
