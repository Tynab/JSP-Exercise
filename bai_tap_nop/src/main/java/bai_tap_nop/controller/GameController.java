package bai_tap_nop.controller;

import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static java.lang.Integer.*;
import static bai_tap_nop.script.GameConstant.*;
import static bai_tap_nop.script.GameMethod.*;

@SuppressWarnings("serial")
@WebServlet("/game")
public class GameController extends HttpServlet {
	// fields
	private int _counter = 0;
	private int _x = new Random().nextInt(HI_VAL - LO_VAL) + LO_VAL;

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
			CheckGamePlay(num, _x);
			if (_checkState_ != "EXIST") {
				_counter++;
				req.setAttribute("botRep", StrAnswer(num, _x));
			}
			if (_guessNum_ > -1) {
				req.setAttribute("savedNum", _guessNum_);
			}
			req.getRequestDispatcher("game.jsp").forward(req, resp);
			break;
		case "checkout":
			UpdateCurrentPlayer(_counter);
			SelfReset();
			PlayersRanking();
			resp.sendRedirect("index.jsp");
			break;
		}
	}

	// reset game
	private void SelfReset() {
		_counter = 0;
		_x = new Random().nextInt(HI_VAL - LO_VAL) + LO_VAL;
		MainReset();
		SubReset();
	}
}
