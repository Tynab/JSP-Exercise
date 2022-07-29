package bai_tap_nop.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import static bai_tap_nop.service.GameConstant.*;
import static bai_tap_nop.service.GameMethod.*;
import static java.lang.Integer.*;

@SuppressWarnings("serial")
@WebServlet("/game")
public class GameController extends HttpServlet {
	// fields
	private int counter = 0;
	private int x = new Random().nextInt(HI_VAL - LO_VAL) + LO_VAL;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SubReset();
		req.getRequestDispatcher("game.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		switch (req.getParameter("submit")) {
		case "checkin":
			var num = parseInt(req.getParameter("numGuess"));
			CheckGamePlay(num, x);
			if (checkState != "EXIST") {
				counter++;
				req.setAttribute("botRep", StrAnswer(num, x));
			}
			if (guessNum > -1) {
				req.setAttribute("savedNum", guessNum);
			}
			req.getRequestDispatcher("game.jsp").forward(req, resp);
			break;
		case "checkout":
			UpdateCurrentPlayer(counter);
			SelfReset();
			PlayersRanking();
			resp.sendRedirect("index.jsp");
			break;
		}
	}

	// reset game
	private void SelfReset() {
		counter = 0;
		x = new Random().nextInt(HI_VAL - LO_VAL) + LO_VAL;
		MainReset();
		SubReset();
	}
}
