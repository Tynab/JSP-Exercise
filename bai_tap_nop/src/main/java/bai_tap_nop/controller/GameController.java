package bai_tap_nop.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static java.lang.Integer.*;
import static java.util.Collections.*;

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
		req.getRequestDispatcher("game.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		_counter++;
		var num = parseInt(req.getParameter("numGuess"));
		var answer = StrAnswer(1, num);
		if (answer.equals(CORRECT)) {
			UpdateCurrentPlayer();
			SelfReset();
			PlayersRanking();
			req.setAttribute("playerList", _players_);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} else {
			req.setAttribute("botRep", answer);
			req.getRequestDispatcher("game.jsp").forward(req, resp);
		}
	}

	// reset default
	private void SelfReset() {
		_counter = 0;
		_x = new Random().nextInt(HI_VAL - LO_VAL) + LO_VAL;
	}

	// reload and add current player to list
	private void UpdateCurrentPlayer() {
		_currentPlayer_.setCounter(_counter);
		_players_.add(_currentPlayer_);
	}

	// sort players list by performance
	private void PlayersRanking() {
		sort(_players_, (o1, o2) -> compare(o1.getCounter(), o2.getCounter()));
	}
}
