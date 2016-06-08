package com.ba.models;

import java.util.ArrayList;
import java.util.List;

public class Set { // 10 sets

	List<Turn> turns = new ArrayList<>();

	boolean isSpare = false;
	boolean isStrike = false;

	public Set markAsSpare() {
		this.isSpare = true;
		return this;
	}

	public Set markAsStrike() {
		this.isStrike = true;
		return this;
	}

	public boolean isStrike() {
		return this.isStrike;
	}
	public boolean isSpare() {
		return this.isSpare;
	}

	public List<Turn> turns() {
		return turns;
	}

	public Set addTurn(Turn turn) {
		turns.add(turn);
		return this;
	}

	public Integer totalScore() {
		Integer total = 0;
		for (Turn t : turns) {
			total += t.score() + t.bonus();
		}
		return total;
	}

	public String print(Player p, boolean lastSet) {
		assert(isStrike && turns.size()<2);
		StringBuilder sb = new StringBuilder();
		for (Turn t : turns) {
			if (t.turnCount()==1 && totalScore().equals(10)) {
				sb.append("X,");
			} else if (t.turnCount() == 2 && totalScore().equals(10)) {
				sb.append("/,");
			} else {
				sb.append(t.score()).append(",");
			}
		}
		sb.append("Total :");
		if (lastSet) {
			sb.append(p.scoreCard().totalScore());
		} else {
			sb.append(totalScore());
		}
		return sb.toString();
	}
}
