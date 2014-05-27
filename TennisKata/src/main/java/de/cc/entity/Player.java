package de.cc.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {

	public static final List<String> scoreDescribtion = Arrays.asList("love","fifteen","thirty","forty");
	int score;
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	String name;
	
	public Player(String name) {
		this.name = name;
		this.score = 0;
	}
	
	public void winner() {
		this.score++;
	}

	public String getScoredescribtion() {
		return scoreDescribtion.get(score);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Player [scoreDescribtion=" + scoreDescribtion + ", name=" + name + "]";
	}
	
	
}
