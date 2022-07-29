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
		MainReset();
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		switch (req.getParameter("submit")) {
		case "check":
			isMsgbox = "true";
			CheckRegister(req.getParameter("playerName"));
			req.setAttribute("savedName", registerName);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
			break;
		case "verify":
			DropPlayer(registerName);
		case "go":
			currentPlayer = CreatePlayer(registerName, 0);
			resp.sendRedirect("game.jsp");
			break;
		}
	}
}
