package bai_tap_nop.script;

import java.util.List;

import bai_tap_nop.model.Player;

import static bai_tap_nop.script.GameConstant.*;

public class GameMethod {
	// fields
	public static List<Player> _players_;
	public static Player _currentPlayer_;

	// create player
	public static Player CreatePlayer(String name, int counter) {
		var player = new Player();
		player.setPlayerName(name);
		player.setCounter(counter);
		return player;
	}

	// result string
	public static String StrAnswer(int x, int num) {
		return num > x ? BIGGER : num < x ? SMALLER : CORRECT;
	}
}
