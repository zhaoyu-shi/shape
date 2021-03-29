package com.shi.ch05.session;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class BookDB {
	private static Map<String,Book> book = new LinkedHashMap <String , Book>();
	static {
		book.put("1", new Book("1","JavaWeb开发"));
		book.put("2", new Book("2","Jdbc开发"));
		book.put("3", new Book("3","Java基础"));
		book.put("4", new Book("4","Struts开发"));
		book.put("5", new Book("5","Spring开发"));
	}
	//获得所有的书籍
	public static Collection <Book> getAll(){
		return book.values();
	}
	//根据指定的id获得书籍
	public static Book getBook(String id) {
		return book.get(id);
	}
}