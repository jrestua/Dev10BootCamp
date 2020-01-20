/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.bullsandcows.service;

import com.joe.bullsandcows.data.BullsAndCowsDao;
import com.joe.bullsandcows.models.Games;
import com.joe.bullsandcows.models.Rounds;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author joe
 */
@ControllerAdvice
@Service
public class BullsAndCowsServiceLayerImpl implements
        BullsAndCowsServiceLayer {

    @Autowired
    BullsAndCowsDao dao;

    public BullsAndCowsServiceLayerImpl(BullsAndCowsDao dao) {
        this.dao = dao;
    }

    @Override
    public String getExact() {
        return dao.getExact();
    }

    @Override
    public Rounds guessNumber(Rounds currentRound, Games currentGame) {
        Games checkGuess = dao.getGameById(currentGame.getGameId());
        if (checkGuess.getIsCorrect()) {
            currentRound.setGuess(null);
        }

        if (currentRound.getGuess().length() != 4) {

        } else {

            try {
                int i = Integer.parseInt(currentRound.getGuess());
            } catch (NumberFormatException e) {

            }
        }

        return dao.guessNumber(currentRound, currentGame);
    }

    @Override
    public int calculateBulls(String guess, Games currentGame) {
        return dao.calculateBulls(guess, currentGame);
    }

    @Override
    public int calculateCows(String guess, Games currentGame) {
        return dao.calculateCows(guess, currentGame);
    }

    @Override
    public List<Rounds> getGameRounds(int gameId) {
        return dao.getGameRounds(gameId);
    }

    @Override
    public List<Games> getAllGames() {
        return dao.getAllGames();
    }

    @Override
    public Games getGameById(int gameId) {
        return dao.getGameById(gameId);
    }

    @Override
    public boolean hasDuplicates(int num) {
        return dao.hasDuplicates(num);
    }

    @Override
    public int newGame(Games newGame) {
        return dao.newGame(newGame);
    }

    @Override
    public Rounds findRoundsByGameId(int gameId) {
        return dao.findRoundsByGameId(gameId);
    }

    private static final String CONSTRAINT_MESSAGE = "Guess cannot be saved."
            + " Please enter an existing gameId as well as a valid 4 digit guess.";

    private static final String SOLVED_MESSAGE = "Cannot play solved game.";

    private static final String DBNF_MESSAGE = "Database not found.";

    private static final String LEAD_ZERO_MESSAGE = "If guess begins with a ZERO, enter within quotes.";

    @ExceptionHandler(SQLSyntaxErrorException.class)
    public final ResponseEntity<com.joe.bullsandcows.service.Error> InvalidGameOrGuess(
            SQLSyntaxErrorException ex,
            WebRequest request) {

        com.joe.bullsandcows.service.Error err = new com.joe.bullsandcows.service.Error();
        err.setMessage(DBNF_MESSAGE);
        return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public final ResponseEntity<com.joe.bullsandcows.service.Error> InvalidGameGuess(
            SQLIntegrityConstraintViolationException e,
            WebRequest request) {

        com.joe.bullsandcows.service.Error err = new com.joe.bullsandcows.service.Error();
        err.setMessage(CONSTRAINT_MESSAGE);
        return new ResponseEntity<>(err, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public final ResponseEntity<com.joe.bullsandcows.service.Error> LeadingZeroes(
            HttpMessageNotReadableException e,
            WebRequest request) {

        com.joe.bullsandcows.service.Error err = new com.joe.bullsandcows.service.Error();
        err.setMessage(LEAD_ZERO_MESSAGE);
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public final ResponseEntity<com.joe.bullsandcows.service.Error> GameOver(
            NullPointerException e,
            WebRequest request) {

        com.joe.bullsandcows.service.Error err = new com.joe.bullsandcows.service.Error();
        err.setMessage(SOLVED_MESSAGE);
        return new ResponseEntity<>(err, HttpStatus.OK);
    }

}
