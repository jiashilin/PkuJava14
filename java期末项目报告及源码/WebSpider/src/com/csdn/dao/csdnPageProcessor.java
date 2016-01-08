package com.csdn.dao;

import java.sql.Timestamp;
import java.util.List;




import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class csdnPageProcessor implements PageProcessor{
	public static final String URL_LIST = "http://blog\\.csdn\\.net/(\\w+)/article/details/(\\w+)";
	private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
	Object obj = new Object();
	public int id = 1;
	ArticleDAO arDao=new ArticleDAO();
	@Override
	public void process(Page page) {
		if (page.getUrl().regex(URL_LIST).match()&&!page.getUrl().toString().contains("#")) {
			Article article=new Article();
			String title = page.getHtml().xpath("//div[@id='article_details']//h1//a/text()").toString();
			//String tag = page.getHtml().xpath("//div[@class='article_l']//a/text()").all().toString();
			List<String> strs2 = page.getHtml().xpath("//div[@class='article_l']//a/text()").all();			
			StringBuilder str2 = new StringBuilder();
			for(int i = 0;i<strs2.size()-1;i++){
				str2.append(strs2.get(i)+"	");
			}
			if(strs2.size()>0){
				str2.append(strs2.get(strs2.size()-1));
			}
			String tag = str2.toString();
			
			
			
			String date = page.getHtml().xpath("//div[@class='article_r']//span/text()").toString();
			int view = Integer.parseInt(page.getHtml().xpath("//span[@class='link_view']/text()").toString().replace("»À‘ƒ∂¡", ""));
			String author = page.getHtml().xpath("//div[@id='blog_userface']//span//a/text()").toString();
		
//			String str = null ;
//			List<String> strs = page.getHtml().xpath("//div[@class='article_content']/*").all();
//			for(int i = 0;i<strs.size();i++){
//				str+=strs.get(i);
//			}
//
//			String content = page.getHtml().xpath("//div[@class='bog_copyright']/*").toString()+str;
//			
			List<String> strs = page.getHtml().xpath("//div[@class='article_content']/*").all();
			StringBuilder str =  new StringBuilder();
			for(int i = 0;i<strs.size();i++){
				str.append(strs.get(i));
			}
			String content = page.getHtml().xpath("//div[@class='bog_copyright']/*").toString()+str;

			
			
			Timestamp time = Timestamp.valueOf(date+":00");
			
			//System.out.println("sdgsdfhdfhdahdznhzdf_____"+title+date);
			article.setAuthor(author);
			article.setContent(content);
			synchronized(obj){
				id++;
				article.setId(id);
			}
			article.setTag(tag);
			article.setTime(time);
			article.setTitle(title);
			article.setView(view);
			
			arDao.save(article);
//			System.out.println(arDao.findAll().size());
//			page.putField("title", page.getHtml().xpath("//div[@id='article_details']//h1//a/text()"));
//			page.putField("tag", page.getHtml().xpath("//div[@class='article_l']//a/text()").all());
//			page.putField("time", page.getHtml().xpath("//div[@class='article_r']//span/text()"));
//			page.putField("view", page.getHtml().xpath("//span[@class='link_view']/text()").toString());
//			page.putField("author", page.getHtml().xpath("//div[@id='blog_userface']//span//a/text()"));
//			page.putField("content",page.getHtml().xpath("//div[@class='bog_copyright']/*").toString()+page.getHtml().xpath("//div[@class='article_content']/text()").all());

//			System.out.println(content);
		}
		page.addTargetRequests(page.getHtml().links().regex("http://blog\\.csdn\\.net/.*").all());
	}

	@Override
	public Site getSite() {
		return site;
	}

	public static void main(String[] args) {
		Spider.create(new csdnPageProcessor()).addUrl("http://blog.csdn.net/").thread(50).run();
	}

}
