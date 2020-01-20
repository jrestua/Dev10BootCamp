/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dc527x.guessnumber.controller;

import dc527x.guessnumber.dao.GuessNumberDao;
import dc527x.guessnumber.dto.Game;
import dc527x.guessnumber.dto.Round;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;
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
 * @author diego
 */
@RestController
@RequestMapping("/api")
public class GuessNumberController {

    private GuessNumberDao dao;

    public GuessNumberController(GuessNumberDao dao) {
        this.dao = dao;
    }

    @GetMapping("/game")
    public List<Game> allGames() {
        List<Game> fullView = dao.getAllGames();
        for (Game g : fullView) {
            if (g.getIsCorrect() == false) {
                g.setAnswerNumber("****");
            }
        }
        return fullView;
    }

    @GetMapping("/game/{gameId}")
    public ResponseEntity<Game> gameById(@PathVariable int gameId) {
        Game g = dao.getGameById(gameId);
        if (g.getGameId() == 0) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        } else {
            if (g.getIsCorrect() == false) {
                g.setAnswerNumber("****");
            }
        }
        return ResponseEntity.ok(g);
    }

    @GetMapping("/rounds/{gameId}")
    public ResponseEntity<List<Round>> roundsPerGame(@PathVariable int gameId) {
        List<Round> fullView = dao.getGameRounds(gameId);
        if (fullView.isEmpty()) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(fullView);
    }

    @PostMapping("/begin")
    @ResponseStatus(HttpStatus.CREATED)
    public int beginGame(@RequestBody Game newGame) {

        String answer = generateAnswer();
        newGame.setAnswerNumber(answer);
        newGame.setIsCorrect(false);

        dao.newGame(newGame);

        return newGame.getGameId();
    }

    @PostMapping("/guess")
    @ResponseStatus(HttpStatus.CREATED)
    public Round makeGuess(@RequestBody Round newRound) {
        int exactCount, partialCount;
        String guess = newRound.getGuessNumber();
        Game currentGame = dao.getGameById(newRound.getGameId());

        exactCount = calcExact(guess, currentGame);
        partialCount = calcPartial(guess, currentGame);

//        while (!currentGame.getIsCorrect()) {
        newRound.setExact(exactCount);
        if (exactCount == 4) {
            currentGame.setIsCorrect(true);
        }
        newRound.setPartial(partialCount);
        newRound.setRoundNumber(currentGame.getGameRounds() + 1);
        LocalTime time = LocalTime.now();
        newRound.setTime(time.truncatedTo(ChronoUnit.SECONDS).toString());

        return dao.guessNumber(newRound, currentGame);

    }

    private String generateAnswer() {
        Random generator = new Random();
        String answer = "";
        while (answer.length() < 4) {
            int randomNumber = generator.nextInt(10);
            if (answer.contains(Integer.toString(randomNumber))) {
                answer = answer;
            } else {
                answer += randomNumber;
            }
        }
        return answer;
    }


}
