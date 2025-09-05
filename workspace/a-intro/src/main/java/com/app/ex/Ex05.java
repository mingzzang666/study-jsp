package com.app.ex;

import java.io.IOException;
import java.net.URLEncoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Ex05 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/ex05.jsp").forward(req, resp);
//		System.out.println(req.getRequestDispatcher("/ex05.jsp"));
	}
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		    String id = req.getParameter("id");
		    String password = req.getParameter("password");

		    boolean loginSuccess = "test".equals(id) && "1234".equals(password);

		    if (loginSuccess) {
		        String loginMessage = URLEncoder.encode(id + "님 환영합니다.", "UTF-8");
		        resp.sendRedirect(req.getContextPath() + "/ex05-result?loginMessage=" + loginMessage);
		    } else {
		        resp.sendRedirect(req.getContextPath() + "/ex05?error=" + URLEncoder.encode("로그인에 실패하였습니다. 다시 시도하세요.", "UTF-8"));
		    }
	}
}
