package com.csdn.dao;
// default package

import java.sql.Timestamp;


/**
 * Article entity. @author MyEclipse Persistence Tools
 */

public class Article implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String title;
     private Integer view;
     private Timestamp time;
     private String author;
     private String content;
     private String tag;


    // Constructors

    /** default constructor */
    public Article() {
    }

	/** minimal constructor */
    public Article(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public Article(Integer id, String title, Integer view, Timestamp time, String author, String content, String tag) {
        this.id = id;
        this.title = title;
        this.view = view;
        this.time = time;
        this.author = author;
        this.content = content;
        this.tag = tag;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getView() {
        return this.view;
    }
    
    public void setView(Integer view) {
        this.view = view;
    }

    public Timestamp getTime() {
        return this.time;
    }
    
    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getAuthor() {
        return this.author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    public String getTag() {
        return this.tag;
    }
    
    public void setTag(String tag) {
        this.tag = tag;
    }
   








}