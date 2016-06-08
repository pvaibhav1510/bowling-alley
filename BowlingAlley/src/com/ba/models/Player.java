package com.ba.models;

public class Player {

	private String name;
	private ScoreCard card = new ScoreCard();

	private boolean eligibleForExtraTurn = false;

	public String name() {
		return name;
	}

	public Player name(String name) {
		this.name = name;
		return this;
	}

	public ScoreCard scoreCard() {
		return card;
	}

	public Player eligibleForExtraTurn(Boolean eligibleForExtraTurn) {
		this.eligibleForExtraTurn = eligibleForExtraTurn;
		return this;
	}

	public Boolean eligibleForExtraTurn() {
		return eligibleForExtraTurn;
	}

	public void printScoreCard() {
		for (Set s : scoreCard().sets()) {
			boolean lastSet = false;
			if (scoreCard().sets().indexOf(s) == scoreCard().sets().size() - 1) {
				lastSet = true;
			}
			System.out.println(s.print(this, lastSet));
		}
	}
}
