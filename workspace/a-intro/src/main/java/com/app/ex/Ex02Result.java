package com.app.ex;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Ex02Result extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String num1 = req.getParameter("num1");
			String num2 = req.getParameter("num2");
			req.setAttribute("num1", num1);
			req.setAttribute("num2", num2);
			req.getRequestDispatcher("/ex02-result.jsp").forward(req, resp);
			
	}
}
