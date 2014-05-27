package de.cc;

import de.cc.entity.Player;

public class TennisGame {

	Player playerA;
	Player playerB;

	public TennisGame(String namePlayerA, String namePlayerB) {
		this.playerA = new Player(namePlayerA);
		this.playerB = new Player(namePlayerB);
	}

	public String getScore() {
		if (hasPlayerWon()) {
			return getLeadPlayer().getName() + " won";
		} else if (playerA.getScore() == 3 && playerB.getScore() == 3) {
			return "deuce";
		} else if (playerA.getScore() >= 3 && playerB.getScore() >= 3) {
			if ((Math.abs(playerA.getScore()) - Math.abs(playerB.getScore())) >= 2) {
				return getLeadPlayer().getName() + " won";
			} else if (playerA.getScore() == playerB.getScore()) {
				return "deuce";
			} else {
				return "advantage, " + getLeadPlayer().getName();
			}
		}
		return playerA.getScoredescribtion() + ", "
				+ playerB.getScoredescribtion();
	}

	private boolean hasPlayerWon() {
		if ((playerA.getScore() > 3 || playerB.getScore() > 3)
				&& (((Math.abs(playerA.getScore()) - Math.abs(playerB
						.getScore())) >= 2) || ((Math.abs(playerB.getScore()) - Math
						.abs(playerA.getScore())) >= 2)))
			return true;
		else
			return false;

	}

	private Player getLeadPlayer() {
		return (playerA.getScore() > playerB.getScore()) ? playerA : playerB;
	}

	public Player getPlayerA() {
		return playerA;
	}

	public void setPlayerA(Player playerA) {
		this.playerA = playerA;
	}

	public Player getPlayerB() {
		return playerB;
	}

	public void setPlayerB(Player playerB) {
		this.playerB = playerB;
	}

}
