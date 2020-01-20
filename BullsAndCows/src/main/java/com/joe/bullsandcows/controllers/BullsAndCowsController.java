/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.bullsandcows.controllers;

import com.joe.bullsandcows.data.BullsAndCowsDao;
import com.joe.bullsandcows.models.Games;
import com.joe.bullsandcows.models.Rounds;
import com.joe.bullsandcows.service.BullsAndCowsServiceLayer;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author joe
 */
@RestController
@RequestMapping("/api")
public class BullsAndCowsController {
    
    private BullsAndCowsServiceLayer service;
    
    public BullsAndCowsController(BullsAndCowsServiceLayer service) {
    this.service = service;
}

    /*
    private final BullsAndCowsDao dao;

    public BullsAndCowsController(BullsAndCowsDao dao) {
        this.dao = dao;
    }
    */

    @PostMapping("/begin")
    @ResponseStatus(HttpStatus.CREATED)
    public int createGame(@RequestBody Games newGame) {

        String exact = service.getExact();
        newGame.setExact(exact);
        newGame.setIsCorrect(false);

        service.newGame(newGame);

        return newGame.getGameId();
    }

    @PostMapping("/guess")
    @ResponseStatus(HttpStatus.CREATED)
    public Rounds makeGuess(@RequestBody Rounds newRound) {
        int bulls, cows;
        String guess = newRound.getGuess();
        int guessInt = Integer.parseInt(guess);
        if ((service.hasDuplicates(guessInt) == false) && (guess.length() == 4)) {
            Games currentGame = service.getGameById(newRound.getGameId());

            bulls = service.calculateBulls(guess, currentGame);
            cows = service.calculateCows(guess, currentGame);

            newRound.setBulls(bulls);
            if (bulls == 4) {
                currentGame.setIsCorrect(true);
            }
            newRound.setCows(cows);
            newRound.setRoundNumber(currentGame.getGameRounds() + 1);
            LocalTime time = LocalTime.now();
            newRound.setTimestamps(time.truncatedTo(ChronoUnit.SECONDS).toString());

            return service.guessNumber(newRound, currentGame);
        } else {
            return null;
        }
    }

    @GetMapping("/game")
    public List<Games> allGames() {
        List<Games> fullView = service.getAllGames();
        for (Games g : fullView) {
            if (g.getIsCorrect() == false) {
                g.setExact("****");
            }
        }
        return fullView;
    }

    @GetMapping("/game/{gameId}")
    public ResponseEntity<Games> gameById(@PathVariable int gameId) {
        Games g = service.getGameById(gameId);
        if (g.getGameId() == 0) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        } else {
            if (g.getIsCorrect() == false) {
                g.setExact("****");
            }
        }
        return ResponseEntity.ok(g);
    }

    @GetMapping("/rounds/{gameId}")
    public ResponseEntity<List<Rounds>> roundsPerGame(@PathVariable int gameId) {
        List<Rounds> fullView = service.getGameRounds(gameId);
        if (fullView.isEmpty()) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(fullView);
    }
}
