/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.bullsandcows.data;

import com.joe.bullsandcows.TestApplicationConfiguration;
import com.joe.bullsandcows.models.Games;
import com.joe.bullsandcows.models.Rounds;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author joe
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class BullsAndCowsDatabaseDaoTest {
    
    public BullsAndCowsDatabaseDaoTest() {
    }
    
@Autowired
    BullsAndCowsDao dao;
        
    /**
     * Test of newGame method, of class GuessNumberDBDaoImpl.
     */
    @Test
    public void testNewGameGetGame() {
        Games game = new Games();
        game.setExact("5632");
        game.setGameId(1);
        game.setGameRounds(0);
        game.setIsCorrect(false);
        dao.newGame(game);
        
        Games fromDao = dao.getGameById(game.getGameId());
        
        assertEquals(game, fromDao);
    }
    
    /**
     * Test of getAllGames method, of class GuessNumberDBDaoImpl.
     */
    @Test
    public void testGetAllGames() {
        Games game = new Games();
        game.setExact("7890");
        game.setGameId(1);
        game.setGameRounds(0);
        game.setIsCorrect(false);
        dao.newGame(game);

        Games game2 = new Games();
        game2.setExact("4532");
        game2.setGameId(2);
        game2.setGameRounds(0);
        game2.setIsCorrect(false);
        dao.newGame(game2);        
        
        //lists the two games added above
        List<Games> games = dao.getAllGames();
        
        assertEquals(2, games.size());
        assertTrue(games.contains(game));
        assertTrue(games.contains(game2));
    }

    /**
     * Test of getGameRounds method, of class GuessNumberDBDaoImpl.
     */
    @Test
    public void testAddGetRounds() {
        Games game = new Games();
        game.setExact("6789");
        game.setGameId(1);
        game.setGameRounds(0);
        game.setIsCorrect(false);
        dao.newGame(game);        
        
        Rounds round1 = new Rounds();
        round1.setBulls(0);
        round1.setCows(0);
        round1.setGameId(game.getGameId());
        round1.setGuess("1234");
        round1.setRoundId(1);
        round1.setRoundNumber(1);
        round1.setTimestamps("10:15:10");
        dao.guessNumber(round1, game);
        
        Rounds round2 = new Rounds();
        round2.setBulls(0);
        round2.setCows(0);
        round2.setGameId(game.getGameId());
        round2.setGuess("1456");
        round2.setRoundId(2);
        round2.setRoundNumber(2);
        round2.setTimestamps("10:20:05");
        dao.guessNumber(round2, game);
        
        Games fromDao = dao.getGameById(game.getGameId());
        List<Rounds> roundsFromDao = dao.getGameRounds(fromDao.getGameId());
        
        assertEquals(2, roundsFromDao.size());
    
}
}