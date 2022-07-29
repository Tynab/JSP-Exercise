package bai_tap_nop.service;

import java.util.*;

import bai_tap_nop.model.*;

import static bai_tap_nop.service.GameConstant.*;
import static java.lang.Integer.*;
import static java.util.Collections.*;

public class GameMethod {
	// fields
	public static List<Player> players = new ArrayList<Player>();
	public static Player currentPlayer;
	public static String registerState = "";
	public static String registerName = "";
	public static String isMsgbox = "false";
	public static String checkState = "";
	public static String isDialog = "false";
	public static int guessNum = -1;

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
		registerName = name;
		registerState = "UNREGISTERED";
		if (players.size() > 0) {
			for (var player : players) {
				if (player.getPlayerName().equals(registerName)) {
					registerState = "REGISTERED";
				}
			}
		}
	}

	// result string
	public static void checkGamePlay(int num, int x) {
		checkState = num == x ? "CORRECT" : num == guessNum ? "EXIST" : "";
		isDialog = checkState == "" ? "false" : "true";
		guessNum = num;
	}

	// result string
	public static String strAnswer(int num, int x) {
		return num > x ? BIGGER : num < x ? SMALLER : CORRECT;
	}

	// reset root
	public static void mainReset() {
		registerName = "";
		registerState = "";
		isMsgbox = "false";
	}

	// reset game
	public static void subReset() {
		checkState = "";
		isDialog = "false";
		guessNum = -1;
	}

	// reload and add current player to list
	public static void updateCurrentPlayer(int counter) {
		currentPlayer.setCounter(counter);
		players.add(currentPlayer);
	}

	// sort players list by performance
	public static void playersRanking() {
		sort(players, (o1, o2) -> compare(o1.getCounter(), o2.getCounter()));
	}
}
