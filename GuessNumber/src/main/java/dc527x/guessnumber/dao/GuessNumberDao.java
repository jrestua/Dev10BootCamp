/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dc527x.guessnumber.dao;

import dc527x.guessnumber.dto.Game;
import dc527x.guessnumber.dto.Round;
import java.util.List;

/**
 *
 * @author diego
 */
public interface GuessNumberDao {
    
    public List<Game> getAllGames();
    
    public Game getGameById(int gameId);
    
    public List<Round> getGameRounds(int gameId);
    
    //will begin a newGame
    public int newGame(Game newGame);
    
    //will be called to make a guess
    public Round guessNumber(Round currentRound, Game currentGame);
    
    //will be called after every guess to verify if game is over
    //will also be use to display Es and Ps
    public void deleteData();
}
