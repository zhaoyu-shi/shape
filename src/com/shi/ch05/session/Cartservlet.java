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
		//����cart�����û��Ĺ��ﳵ
		List<Book> cart = null;
		//����pruFlag����û��Ƿ������Ʒ
		boolean purFlag = true;
		//����û���session
		HttpSession session = request.getSession(false);
		//���sessionΪnull��purFlag��Ϊfalse
		if(session == null) {
			purFlag = false;
		}else {
			//����û����ﳵ
			cart = (List)session.getAttribute("cart");
			//����õĹ��ﳵΪnull��purFlag��Ϊfalse
			if(cart == null) {
				purFlag = false;
			}
		}
		/*
		 * ���purFulagΪfalse�������û�û�й���ͼ�� �ض���ΪListServletҳ��
		 */
		if(!purFlag) {
			out.write("�Բ�������û�й����κ���Ʒ��<br />");
		}else {
			//������ʾ�û������ͼ����Ϣ
			out.write("�������ͼ���У�<br />");
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
