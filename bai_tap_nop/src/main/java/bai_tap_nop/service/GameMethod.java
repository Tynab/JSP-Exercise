package bai_tap_nop.service;

import java.util.*;

import bai_tap_nop.model.*;

import static bai_tap_nop.service.GameConstant.*;

import static java.lang.Integer.*;

import static java.util.Collections.*;

public class GameMethod {
	// fields
	public static List<Player> _players_ = new ArrayList<Player>();
	public static Player _currentPlayer_;
	public static String _registerState_ = "";
	public static String _registerName_ = "";
	public static String _isMsgbox_ = "false";
	public static String _checkState_ = "";
	public static String _isDialog_ = "false";
	public static int _guessNum_ = -1;

	// create player
	public static Player CreatePlayer(String name, int counter) {
		var player = new Player();
		player.setPlayerName(name);
		player.setCounter(counter);
		return player;
	}

	// remove player
	public static void DropPlayer(String name) {
		_players_.removeIf(player -> player.getPlayerName().equals(name)); // fix ConcurrentModificationException
	}

	// check register of new player
	public static void CheckRegister(String name) {
		_registerName_ = name;
		_registerState_ = "UNREGISTERED";
		if (_players_.size() > 0) {
			for (var player : _players_) {
				if (player.getPlayerName().equals(_registerName_)) {
					_registerState_ = "REGISTERED";
				}
			}
		}
	}

	// result string
	public static void CheckGamePlay(int num, int x) {
		_checkState_ = num == x ? "CORRECT" : num == _guessNum_ ? "EXIST" : "";
		_isDialog_ = _checkState_ == "" ? "false" : "true";
		_guessNum_ = num;
	}

	// result string
	public static String StrAnswer(int num, int x) {
		return num > x ? BIGGER : num < x ? SMALLER : CORRECT;
	}

	// reset root
	public static void MainReset() {
		_registerName_ = "";
		_registerState_ = "";
		_isMsgbox_ = "false";
	}

	// reset game
	public static void SubReset() {
		_checkState_ = "";
		_isDialog_ = "false";
		_guessNum_ = -1;
	}

	// reload and add current player to list
	public static void UpdateCurrentPlayer(int counter) {
		_currentPlayer_.setCounter(counter);
		_players_.add(_currentPlayer_);
	}

	// sort players list by performance
	public static void PlayersRanking() {
		sort(_players_, (o1, o2) -> compare(o1.getCounter(), o2.getCounter()));
	}
}
