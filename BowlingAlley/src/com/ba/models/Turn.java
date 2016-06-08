package com.ba.models;

public class Turn {// 2/3 turns per set

	private int turnCount;
	private int score;
	private int bonus;
	private boolean isLast;

	public int turnCount() {
		return turnCount;
	}

	public Turn turnCount(int turnCount) {
		this.turnCount = turnCount;
		return this;
	}

	public int score() {
		return score;
	}

	public Turn score(int score) {
		this.score = score;
		return this;
	}

	public int bonus() {
		return bonus;
	}

	public Turn bonus(int bonus) {
		this.bonus = bonus;
		return this;
	}

	public Turn isLast(boolean isLast) {
		this.isLast = isLast;
		return this;
	}

	public Boolean isLast() {
		return this.isLast;
	}

}
