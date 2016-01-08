package com.csdn.dao;
import java.sql.Timestamp;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Article ar=new Article();
		ArticleDAO arDao=new ArticleDAO();
		//System.out.println(arDao.findCount());
		System.out.println(((Article) arDao.findByProperty("id", 6655).get(0)).getTitle());
		//System.out.println(arDao.findByS("java").size());
		//System.out.println(arDao.findByS("c++").size());
//		System.out.println(arDao.findByS("c#").size());
//		System.out.println(arDao.findByS("python").size());
//		System.out.println(arDao.findByS("php").size());
		
	}

}
