package com.csdn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csdn.dao.Article;
import com.csdn.dao.ArticleDAO;


public class statisticServlet extends HttpServlet{

	/**
	 * Constructor of the object.
	 */
	public statisticServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		ArticleDAO arDao=new ArticleDAO();
		//Long sum=arDao.findCount();//文章总数
		
		//阅读量最高的文章
		Article ar=new Article();
		ar=(Article) arDao.findByProperty("id", new Integer(6655)).get(0);
		System.out.println(ar.getTitle());
//		int java=arDao.findByS("java").size();
//		int c=arDao.findByS("c").size();
//		int cc=arDao.findByS("c++").size();
//		int ca=arDao.findByS("C#").size();
//		int Python=arDao.findByS("python").size();
//		int php=arDao.findByS("php").size();
		Integer sum=new Integer(67733);
		Integer java=new Integer(5143);
		Integer cc=new Integer(1229);
		Integer ca=new Integer(1300);
		Integer Python=new Integer(927);
		Integer php=new Integer(1002);
		
		//request.getSession().setAttribute("sum", sum);
		request.getSession().setAttribute("articleMax", ar);
//		request.getSession().setAttribute("java", java);
//		request.getSession().setAttribute("cc", cc);
//		request.getSession().setAttribute("ca", ca);
//		request.getSession().setAttribute("python", Python);
//		request.getSession().setAttribute("php", php);
		
		/*
		Integer sum=(Integer)session.getAttribute("sum");;
    	Integer java=(Integer)session.getAttribute("java");
		Integer cc=(Integer)session.getAttribute("cc");
		Integer ca=(Integer)session.getAttribute("ca");
		Integer python=(Integer)session.getAttribute("python");
		Integer php=(Integer)session.getAttribute("php");*/
		
		response.sendRedirect("statistic.jsp");
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
}

