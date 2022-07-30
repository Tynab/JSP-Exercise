package exercise_1.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import exercise_1.pojo.*;

import static java.lang.Double.*;
import static java.lang.Integer.*;

@SuppressWarnings("serial")
@WebServlet("/product")
public class ProductController extends HttpServlet {
	private List<User> mUsers = new ArrayList<>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("product.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var user = new User();
		user.setNameProduct(req.getParameter("nameproduct"));
		user.setAmount(parseInt(req.getParameter("amount")));
		user.setPrice(parseDouble(req.getParameter("price")));
		mUsers.add(user);
		req.setAttribute("list", mUsers);
		req.getRequestDispatcher("product.jsp").forward(req, resp);
	}
}
