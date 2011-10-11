package com.tictactoe.main;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.tictactoe.model.TicTacToeModel;
import com.tictactoe.utils.Coordinates;
import com.tictactoe.utils.Util;

public class TicTacToeActivity extends Activity {
	/** Called when the activity is first created. */

	private TicTacToeModel game = new TicTacToeModel();
	private int winner = -1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	public void onButtonClick(View v) {

		// someone wined already
		if (winner>=0) {
			printText("game ended");
			return;
		}
		
		
		switch (v.getId()) {

		case R.id.button1:
			play(v, new Coordinates(1, 1));
			break;
		case R.id.button2:
			play(v, new Coordinates(1, 2));
			break;
		case R.id.button3:
			play(v, new Coordinates(1, 3));
			break;
		case R.id.button4:
			play(v, new Coordinates(2, 1));
			break;
		case R.id.button5:
			play(v, new Coordinates(2, 2));
			break;
		case R.id.button6:
			play(v, new Coordinates(2, 3));
			break;
		case R.id.button7:
			play(v, new Coordinates(3, 1));
			break;
		case R.id.button8:
			play(v, new Coordinates(3, 2));
			break;
		case R.id.button9:
			play(v, new Coordinates(3, 3));
			break;

		}

	}

	public void resetView() {

		// clean model
		game = new TicTacToeModel();

		Util.BOARD = new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };

		// reset buttons
		cleanButton((Button) findViewById(R.id.button1));
		cleanButton((Button) findViewById(R.id.button2));
		cleanButton((Button) findViewById(R.id.button3));
		cleanButton((Button) findViewById(R.id.button4));
		cleanButton((Button) findViewById(R.id.button5));
		cleanButton((Button) findViewById(R.id.button6));
		cleanButton((Button) findViewById(R.id.button7));
		cleanButton((Button) findViewById(R.id.button8));
		cleanButton((Button) findViewById(R.id.button9));

	}

	private void cleanButton(Button b) {
		b.setText("-");
	}

	private void play(View v, Coordinates c) {
		if (game.isValidMove(c)) {
			String playerText;
			// text
			TextView t = (TextView) findViewById(R.id.textView1);
			
			t.setText("Time for: Player "); 
			
			if (Util.CURRENT_PLAYER == Util.PLAYER_A) {
				playerText = "A";
				t.append("B");
			} else {
				playerText = "B";
				t.append("A");
			}

			

			// button
			((Button) v).setText(playerText);

			if (game.play(c)) {
				printText("Player " + Util.CURRENT_PLAYER + " wins");
				winner = Util.CURRENT_PLAYER;
			} else {

				game.togglePlayer();
			}

		} else {
			printText("Invalid move");
		}
	}
	
	public void printText(String t) {
		Toast.makeText(this, t, Toast.LENGTH_SHORT).show();
	}
}