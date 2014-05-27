package de.cc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.beans.HasProperty.hasProperty;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

public class TennisGameTest {
	
	TennisGame game;
	
	@Before
	public void init() {
		game = new TennisGame("Andi", "Roger");
	}

	@Test
	public void testTennisGameHasScore() {
		assertThat(game, hasProperty("playerA"));
		assertThat(game, hasProperty("playerB"));
	}
	
	@Test
	public void testPlayerAScores() {
		game.playerA.winner();
		assertThat(game, hasProperty("score", is("fifteen, love")));
	}
	
	@Test
	public void testDeuce() {
		game.playerA.winner();
		game.playerA.winner();
		game.playerA.winner();
		game.playerB.winner();
		game.playerB.winner();
		game.playerB.winner();
		assertThat(game, hasProperty("score", is("deuce")));
	}
	
	@Test
	public void testAdvantagePlayerA() {
		game.playerA.winner();
		game.playerA.winner();
		game.playerA.winner();
		game.playerB.winner();
		game.playerB.winner();
		game.playerB.winner();
		game.playerA.winner();
		assertThat(game, hasProperty("score", is("advantage, Andi")));
	}
	
	@Test
	public void testAdvantagePlayerB() {
		game.playerA.winner();
		game.playerA.winner();
		game.playerA.winner();
		game.playerB.winner();
		game.playerB.winner();
		game.playerB.winner();
		game.playerB.winner();
		assertThat(game, hasProperty("score", is("advantage, Roger")));
	}
	
	@Test
	public void testPlayerAWon() {
		game.playerA.winner();
		game.playerA.winner();
		game.playerA.winner();
		game.playerB.winner();
		game.playerB.winner();
		game.playerB.winner();
		game.playerA.winner();
		game.playerA.winner();
		assertThat(game, hasProperty("score", is("Andi won")));
	}
	
	@Test
	public void testPlayerAWonStraight() {
		game.playerA.winner();
		game.playerA.winner();
		game.playerA.winner();
		game.playerA.winner();
		assertThat(game, hasProperty("score", is("Andi won")));
	}
	
	@Test
	public void testPlayerBWonStraight() {
		game.playerB.winner();
		game.playerB.winner();
		game.playerB.winner();
		game.playerB.winner();
		assertThat(game, hasProperty("score", is("Roger won")));
	}
	
	@Test
	public void someResult() {
		game.playerA.winner();
		game.playerB.winner();
		game.playerA.winner();
		game.playerA.winner();
		game.playerB.winner();
		assertThat(game, hasProperty("score", is("forty, thirty")));
		
	}
	
	
	
}
