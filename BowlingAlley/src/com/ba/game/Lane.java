package com.ba.game;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import com.ba.models.Player;
import com.ba.models.Set;
import com.ba.models.Turn;

public class Lane extends Thread {

	public static final int randomMultiplyer = 45;
	public static final int totalSetsCount = 10;
	public static final int totalPins = 10;
	List<Player> players = new ArrayList<>();
	public Lane(List<Player> players){
		this.players=players;
	}
	
	@Override
	public void run() {
		
		System.out.println("-------- The lane"
				+ Thread.currentThread().getName() + " is started --------");

		
		
		for (int i = 1; i <= totalSetsCount; i++) {
			for (Player p : players) {
				System.out.println("============================= TURN " + i
						+ " | player " + p.name().toUpperCase()
						+ " =================");
				game(p, i);
			}
		}
	}

	public void game(Player p, int turn) {
		System.out.print("BEFORE : ");
		p.printScoreCard();
		p.scoreCard().addSet(bowl(p, turn));
		System.out.print("AFTER : ");
		p.printScoreCard();
	}

	private Set bowl(Player p, int turn) {
		Set s = new Set();
		s.addTurn(createTurn(s, 1, 0)); // turn 1
		if (s.isStrike()) {
			p.eligibleForExtraTurn(true);
			return s;
		}
		s.addTurn(createTurn(s, 2, s.turns().get(0).score())); // turn 2
		if (s.isSpare()) {
			p.eligibleForExtraTurn(true);
		}
		if (turn == totalSetsCount && p.eligibleForExtraTurn()) { // turn 3 if
																	// last and
																	// strike
			s.addTurn(createTurn(s, 3, 0));
		}
		return s;
	}

	private Turn createTurn(Set s, int turnCount, int firstTurnPins) {
		Integer pinsDown = randomNum(firstTurnPins);
		Turn t = new Turn().score(pinsDown).turnCount(turnCount);
		if (turnCount == 1 && pinsDown == totalPins) {
			t.bonus(10);
			s.markAsStrike();
		}
		if (turnCount == 2 && s.totalScore() == 10) {
			t.bonus(5);
			s.markAsSpare();
		}
		return t;
	}

	private int randomNum(int firstTurnPins) {
		int rand = randomNum();
		while (rand > (10 - firstTurnPins)) {
			rand = randomNum();
		}
		return rand;
	}

	private int randomNum() {
		Integer random = new Double(Math.random() * randomMultiplyer)
				.intValue() % 10;
		if (Calendar.getInstance().getTimeInMillis() % 2 == 0) {
			random += 1;
		}
		assert (random <= 10 && random >= 0);
		return random;
	}
}
