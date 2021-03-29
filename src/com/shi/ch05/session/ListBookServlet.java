package com.shi.ch05.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListBookServlet
 */
public class ListBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Collection <Book> books = BookDB.getAll();
		out.write("��վ�ṩ���鼮�У�");
		for(Book book : books) {
			String url = "/ch05/PurchaseSerblet?id="+book.getId();
			out.write(book.getName() + "<a href='"+url+"'>�������</a><br />");
		}
	}
}
