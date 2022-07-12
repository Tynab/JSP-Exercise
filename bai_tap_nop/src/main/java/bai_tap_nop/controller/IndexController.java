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
			_isMsgbox_ = "true";
			CheckRegister(req.getParameter("playerName"));
			req.setAttribute("savedName", _registerName_);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
			break;
		case "verify":
			DropPlayer(_registerName_);
		case "go":
			_currentPlayer_ = CreatePlayer(_registerName_, 0);
			resp.sendRedirect("game.jsp");
			break;
		}
	}
}
