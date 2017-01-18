package com.ba.models;

import java.util.ArrayList;
import java.util.List;

public class ScoreCard {

	private List<Set> sets = new ArrayList<>();

	public int totalScore() {
		Integer totalScore = 0;
		for (Set s : sets) {
			totalScore += s.totalScore();
		}
		return totalScore;
	}

	public List<Set> sets() {
		return this.sets;
	}

	public ScoreCard addSet(Set s) {
		sets.add(s);
		return this;
	}

}
