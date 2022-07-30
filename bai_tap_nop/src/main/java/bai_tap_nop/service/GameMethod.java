package bai_tap_nop.service;

import java.util.*;

import bai_tap_nop.model.*;

import static bai_tap_nop.service.GameConstant.*;
import static java.lang.Integer.*;
import static java.util.Collections.*;

public class GameMethod {
	// fields
	public static List<Player> players = new ArrayList<>();
	public static Player current_player;
	public static String register_name = "";
	public static String register_state = "";
	public static String check_state = "";
	public static String is_msgBox = "false";
	public static String is_dialog = "false";
	public static int guess_num = -1;

	// create player
	public static Player createPlayer(String name, int counter) {
		var player = new Player();
		player.setPlayerName(name);
		player.setCounter(counter);
		return player;
	}

	// remove player
	public static void dropPlayer(String name) {
		players.removeIf(player -> player.getPlayerName().equals(name)); // fix ConcurrentModificationException
	}

	// check register of new player
	public static void checkRegister(String name) {
		register_name = name;
		register_state = "UNREGISTERED";
		if (players.size() > 0) {
			for (var player : players) {
				if (player.getPlayerName().equals(register_name)) {
					register_state = "REGISTERED";
				}
			}
		}
	}

	// result string
	public static void checkGamePlay(int num, int x) {
		check_state = num == x ? "CORRECT" : num == guess_num ? "EXIST" : "";
		is_dialog = check_state == "" ? "false" : "true";
		guess_num = num;
	}

	// result string
	public static String strAnswer(int num, int x) {
		return num > x ? BIGGER : num < x ? SMALLER : CORRECT;
	}

	// reset root
	public static void mainReset() {
		register_name = "";
		register_state = "";
		is_msgBox = "false";
	}

	// reset game
	public static void subReset() {
		check_state = "";
		is_dialog = "false";
		guess_num = -1;
	}

	// reload and add current player to list
	public static void updateCurrentPlayer(int counter) {
		current_player.setCounter(counter);
		players.add(current_player);
	}

	// sort players list by performance
	public static void playersRanking() {
		sort(players, (o1, o2) -> compare(o1.getCounter(), o2.getCounter()));
	}
}
