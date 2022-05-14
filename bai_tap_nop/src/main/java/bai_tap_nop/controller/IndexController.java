package bai_tap_nop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bai_tap_nop.model.Player;

import static bai_tap_nop.script.GameMethod.*;

@SuppressWarnings("serial")
@WebServlet("/index")
public class IndexController extends HttpServlet {
	@Override
	public void init() throws ServletException {
		_players_ = new ArrayList<Player>();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		var state = "UNREGISTERED";
		var name = req.getParameter("playerName");
		List<Player> toRemove = new ArrayList<Player>();
		if (_players_.size() > 0) {
			for (var player : _players_) {
				if (player.getPlayerName().equals(name)) {
					state = "REGISTERED";
					toRemove.add(player); // fix ConcurrentModificationException
				}
			}
		}
		_players_.removeAll(toRemove);
		_currentPlayer_ = CreatePlayer(name, 0);
		req.setAttribute("playerState", state);
//		resp.sendRedirect("game.jsp");
	}
}
