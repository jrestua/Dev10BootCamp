/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dc527x.guessnumber.dao;

import dc527x.guessnumber.TestApplicationConfiguration;
import dc527x.guessnumber.dto.Game;
import dc527x.guessnumber.dto.Round;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author diego
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class GuessNumberDBDaoImplTest {
    @Autowired
    GuessNumberDao dao;
    
    public GuessNumberDBDaoImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        dao.deleteData();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllGames method, of class GuessNumberDBDaoImpl.
     */
    @Test
    public void testGetAllGames() {
        Game game = new Game();
        game.setAnswerNumber("1234");
        game.setGameId(1);
        game.setGameRounds(0);
        game.setIsCorrect(false);
        dao.newGame(game);

        Game game2 = new Game();
        game2.setAnswerNumber("1234");
        game2.setGameId(2);
        game2.setGameRounds(0);
        game2.setIsCorrect(false);
        dao.newGame(game2);        
        
        List<Game> games = dao.getAllGames();
        
        assertEquals(2, games.size());
        assertTrue(games.contains(game));
        assertTrue(games.contains(game2));
    }

    /**
     * Test of getGameRounds method, of class GuessNumberDBDaoImpl.
     */
    @Test
    public void testAddGetRounds() {
        Game game = new Game();
        game.setAnswerNumber("1234");
        game.setGameId(1);
        game.setGameRounds(0);
        game.setIsCorrect(false);
        dao.newGame(game);        
        
        Round round1 = new Round();
        round1.setExact(0);
        round1.setPartial(0);
        round1.setGameId(1);
        round1.setGuessNumber("5678");
        round1.setRoundId(1);
        round1.setRoundNumber(1);
        round1.setTime("01:01:01");
        dao.guessNumber(round1, game);
        
        Round round2 = new Round();
        round2.setExact(0);
        round2.setPartial(0);
        round2.setGameId(1);
        round2.setGuessNumber("5678");
        round2.setRoundId(2);
        round2.setRoundNumber(2);
        round2.setTime("01:01:01");
        dao.guessNumber(round2, game);
        
        Game fromDao = dao.getGameById(game.getGameId());
        List<Round> roundsFromDao = dao.getGameRounds(fromDao.getGameId());
        
        assertEquals(2, roundsFromDao.size());
    }

    /**
     * Test of newGame method, of class GuessNumberDBDaoImpl.
     */
    @Test
    public void testNewGameGetGame() {
        Game game = new Game();
        game.setAnswerNumber("1234");
        game.setGameId(1);
        game.setGameRounds(0);
        game.setIsCorrect(false);
        dao.newGame(game);
        
        Game fromDao = dao.getGameById(game.getGameId());
        
        assertEquals(game, fromDao);
    }

    /**
     * Test of finishGame method, of class GuessNumberDBDaoImpl.
     */
    @Test
    public void testDeleteData() {
        Game game = new Game();
        game.setAnswerNumber("1234");
        game.setGameId(1);
        game.setGameRounds(0);
        game.setIsCorrect(false);
        dao.newGame(game);        
        
        Round round1 = new Round();
        round1.setExact(0);
        round1.setPartial(0);
        round1.setGameId(1);
        round1.setGuessNumber("5678");
        round1.setRoundId(1);
        round1.setRoundNumber(1);
        round1.setTime("01:01:01");
        dao.guessNumber(round1, game);
        
        Round round2 = new Round();
        round2.setExact(0);
        round2.setPartial(0);
        round2.setGameId(1);
        round2.setGuessNumber("5678");
        round2.setRoundId(2);
        round2.setRoundNumber(2);
        round2.setTime("01:01:01");
        dao.guessNumber(round2, game);

        dao.deleteData();
        
        List<Game> gamesFromDao = dao.getAllGames();
        List<Round> roundsFromDao1 = dao.getGameRounds(1);
        List<Round> roundsFromDao2 = dao.getGameRounds(2);
        
        assertEquals(0, gamesFromDao.size());
        assertEquals(0, roundsFromDao1.size());
        assertEquals(0, roundsFromDao2.size());
    }
    
}
