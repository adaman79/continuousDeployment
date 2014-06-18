package de.cc;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class TennisGameSteps {

	TennisGame tennisGame;

	@Given("A tennisGame with <playerA> and <playerB>")
	public void givenAnEmptyTennisGame(@Named("playerA") String playerA, @Named("playerB") String playerB) {
		tennisGame = new TennisGame(playerA, playerB);
	}

	@When("PlayerA scores a winner")
	public void whenPlayerAScoresAWinner() {
		tennisGame.playerA.winner();
	}

	@Then("The tennis game score should count <message>")
	public void thenTheTennisGameShouldCount(@Named("message") String message) {
		String actual = tennisGame.getScore();
		if (!actual.equals(message)) {
			throw new RuntimeException("message:" + message + ";actual:"
					+ actual);
		}
	}
}
