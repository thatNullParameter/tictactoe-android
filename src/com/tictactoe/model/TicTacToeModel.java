package com.tictactoe.model;

import com.tictactoe.utils.Coordinates;
import com.tictactoe.utils.Util;

public class TicTacToeModel {

	public boolean isValidMove(Coordinates c) {

		int house = Util.BOARD[c.getX() - 1][c.getY() - 1];

		if (house > 0) {
			return false;
		}

		return true;

	}

	public boolean play(Coordinates c) {
		Util.BOARD[c.getX() - 1][c.getY() - 1] = Util.CURRENT_PLAYER;
		if (didCurrentPlayerWin()) {
			return true;
		}
		return false;
	}

	public boolean didCurrentPlayerWin() {

		if ( // LINES
		Util.BOARD[0][0] == Util.CURRENT_PLAYER
				&& Util.BOARD[0][1] == Util.CURRENT_PLAYER
				&& Util.BOARD[0][2] == Util.CURRENT_PLAYER

				|| Util.BOARD[1][0] == Util.CURRENT_PLAYER
				&& Util.BOARD[1][1] == Util.CURRENT_PLAYER
				&& Util.BOARD[1][2] == Util.CURRENT_PLAYER

				|| Util.BOARD[2][0] == Util.CURRENT_PLAYER
				&& Util.BOARD[2][1] == Util.CURRENT_PLAYER
				&& Util.BOARD[2][2] == Util.CURRENT_PLAYER
				||
				// COLUMNS
				Util.BOARD[0][0] == Util.CURRENT_PLAYER
				&& Util.BOARD[1][0] == Util.CURRENT_PLAYER
				&& Util.BOARD[2][0] == Util.CURRENT_PLAYER

				|| Util.BOARD[0][1] == Util.CURRENT_PLAYER
				&& Util.BOARD[1][1] == Util.CURRENT_PLAYER
				&& Util.BOARD[2][1] == Util.CURRENT_PLAYER

				|| Util.BOARD[0][2] == Util.CURRENT_PLAYER
				&& Util.BOARD[1][2] == Util.CURRENT_PLAYER
				&& Util.BOARD[2][2] == Util.CURRENT_PLAYER
				||
				// DIAGONALS
				Util.BOARD[0][0] == Util.CURRENT_PLAYER
				&& Util.BOARD[1][1] == Util.CURRENT_PLAYER
				&& Util.BOARD[2][2] == Util.CURRENT_PLAYER

				|| Util.BOARD[0][2] == Util.CURRENT_PLAYER
				&& Util.BOARD[1][1] == Util.CURRENT_PLAYER
				&& Util.BOARD[2][0] == Util.CURRENT_PLAYER

		) {
			return true;
		} else {
			return false;

		}
	}

	public void togglePlayer() {
		if (Util.CURRENT_PLAYER == Util.PLAYER_A) {
			Util.CURRENT_PLAYER = Util.PLAYER_B;
		} else {
			Util.CURRENT_PLAYER = Util.PLAYER_A;
		}
	}
}
