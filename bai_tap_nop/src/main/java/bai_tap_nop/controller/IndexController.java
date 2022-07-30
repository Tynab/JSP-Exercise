package bai_tap_nop.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import static bai_tap_nop.service.GameMethod.*;

@SuppressWarnings("serial")
@WebServlet("/index")
public class IndexController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		mainReset();
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		switch (req.getParameter("submit")) {
		case "check":
			is_msgBox = "true";
			checkRegister(req.getParameter("playerName"));
			req.setAttribute("savedName", register_name);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
			break;
		case "verify":
			dropPlayer(register_name);
		case "go":
			current_player = createPlayer(register_name, 0);
			resp.sendRedirect("game.jsp");
			break;
		}
	}
}
