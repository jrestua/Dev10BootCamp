/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.bullsandcows.service;

import com.joe.bullsandcows.models.Games;
import com.joe.bullsandcows.models.Rounds;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author joe
 */
@Service
public interface BullsAndCowsServiceLayer {
    
    String getExact();
    
    public Rounds guessNumber(Rounds currentRound, Games currentGame);
    
    int calculateBulls(String guess, Games currentGame);
    
    int calculateCows(String guess, Games currentGame);
    
    public List<Rounds> getGameRounds(int gameId);
    
    public List<Games> getAllGames();
    
    public Games getGameById(int gameId);
    
    boolean hasDuplicates(int num);
    
    public int newGame(Games newGame);
     
    Rounds findRoundsByGameId(int gameId);
    
}
