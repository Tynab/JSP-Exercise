package exercise_1.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static java.lang.Integer.*;
import static java.lang.Double.*;

import exercise_1.pojo.User;

@SuppressWarnings("serial")
@WebServlet("/product")
public class ProductController extends HttpServlet {
	List<User> users = new ArrayList<>();

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
		users.add(user);
		req.setAttribute("list", users);
		req.getRequestDispatcher("product.jsp").forward(req, resp);
	}
}
