package com.shi.ch05.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Cartservlet
 */
public class Cartservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//变量cart引用用户的购物车
		List<Book> cart = null;
		//变量pruFlag标记用户是否买过商品
		boolean purFlag = true;
		//获得用户的session
		HttpSession session = request.getSession(false);
		//如果session为null，purFlag置为false
		if(session == null) {
			purFlag = false;
		}else {
			//获得用户购物车
			cart = (List)session.getAttribute("cart");
			//如果用的购物车为null，purFlag置为false
			if(cart == null) {
				purFlag = false;
			}
		}
		/*
		 * 如果purFulag为false，表明用户没有购买图书 重定向为ListServlet页面
		 */
		if(!purFlag) {
			out.write("对不起！您还没有购买任何商品！<br />");
		}else {
			//否则显示用户购买的图书信息
			out.write("您购买的图书有：<br />");
			double price = 0;
			for(Book book : cart) {
				out.write(book.getName()+"<br />");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
