package exercise_2.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var userName = req.getParameter("username");
		var password = req.getParameter("password");
		if (userName.equals("admin") && password.equals("123456")) {
			resp.sendRedirect(req.getContextPath() + "/welcome");
		} else {
			req.setAttribute("checkLogin", "failed");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
}
