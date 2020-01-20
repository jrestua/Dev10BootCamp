/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.bullsandcows.data;

import com.joe.bullsandcows.models.Games;
import com.joe.bullsandcows.models.Rounds;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author joe
 */
public interface BullsAndCowsDao {

    public int newGame(Games newGame);

    String getExact();

    public Rounds guessNumber(Rounds currentRound, Games currentGame);

    boolean hasDuplicates(int num);

    int calculateBulls(String guess, Games currentGame);

    int calculateCows(String guess, Games currentGame);

    public List<Rounds> getGameRounds(int gameId);

    public List<Games> getAllGames();

    public Games getGameById(int gameId);

    public Rounds findRoundsByGameId(int gameId);
}
