package com.shi.ch05.session;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class BookDB {
	private static Map<String,Book> book = new LinkedHashMap <String , Book>();
	static {
		book.put("1", new Book("1","JavaWeb����"));
		book.put("2", new Book("2","Jdbc����"));
		book.put("3", new Book("3","Java����"));
		book.put("4", new Book("4","Struts����"));
		book.put("5", new Book("5","Spring����"));
	}
	//������е��鼮
	public static Collection <Book> getAll(){
		return book.values();
	}
	//����ָ����id����鼮
	public static Book getBook(String id) {
		return book.get(id);
	}
}