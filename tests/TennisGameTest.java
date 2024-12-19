import static org.junit.Assert.*;

import org.junit.Test;

public class TennisGameTest {
	
// Here is the format of the scores: "player1Score - player2Score"
// "love - love"
// "15 - 15"
// "30 - 30"
// "deuce"
// "15 - love", "love - 15"
// "30 - love", "love - 30"
// "40 - love", "love - 40"
// "30 - 15", "15 - 30"
// "40 - 15", "15 - 40"
// "player1 has advantage"
// "player2 has advantage"
// "player1 wins"
// "player2 wins"
	@Test
	
	// tests avoid else, some {}
	
	public void testTennisGame_Start() {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "love - love", score);		
	}
	
	@Test
	public void testTennisGame_EahcPlayerWin4Points_Score_Deuce() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "deuce", score);		
	}
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player1WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		// This statement should cause an exception
		game.player1Scored();			
	}	
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player2WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		// This statement should cause an exception
		game.player2Scored();			
	}
	
	@Test 
	public void testTennisGame_Player1Wins() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		String score = game.getScore();
		assertEquals("player1 victory error", "player1 wins", score);
	}
	
	@Test 
	public void testTennisGame_Player2Wins() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		String score = game.getScore();
		assertEquals("player2 victory error", "player2 wins", score);
	}
	
	@Test
	public void testTennisGame_Player1advantage() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();

		String score = game.getScore();
		assertEquals("Player1 advantage is incorrect", "player1 has advantage", score);
	}
	@Test
	public void testTennisGame_Player2advantage() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();


		String score = game.getScore();
		assertEquals("Player2 advantage is incorrect", "player2 has advantage", score);
	}
	@Test
	public void testTennisGame_Player1HasOnePoint() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//act
		game.player1Scored();

		String score = game.getScore();
		assertEquals("One point is incorrect", "love - 15", score);
	}
	
	@Test
	public void testTennisGame_Player1HasTwoPoints() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//act
		game.player1Scored();
		game.player1Scored();

		String score = game.getScore();
		assertEquals("Two points is incorrect", "love - 30", score);
	}
	
	@Test
	public void testTennisGame_Player1HasThreePoints() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();

		String score = game.getScore();
		assertEquals("Three points is incorrect", "love - 40", score);
	}
	
}
