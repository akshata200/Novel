package com.example.novel.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long bookId;
	String bookname;
	String author;
	String description;
	Integer totalChapters;
	// readers value will determine popularity of the novel
	Integer readers;
	boolean completed = false;
	
	// this attribute will have chapter name
	@Column
	@ElementCollection(targetClass=String.class)
	List<String> chapterName = new LinkedList<>();
	
	// this attribute will have chapter's content
	@Column
	@ElementCollection(targetClass=String.class)
	List<String> chapterContent = new LinkedList<>();
	
	
	// tage will help to find genre and also novels can be filtered by tag
	@Column
	@ElementCollection(targetClass=String.class)
	List<String> tags = new LinkedList<>();
	
	
	
	
	
}
