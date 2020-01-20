/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.bullsandcows.data;

import com.joe.bullsandcows.models.Games;
import com.joe.bullsandcows.models.Rounds;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author joe
 */
@Repository
public class BullsAndCowsDatabaseDao implements BullsAndCowsDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BullsAndCowsDatabaseDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public int newGame(Games newGame) {
        final String sql = "INSERT INTO Games(isCorrect, exact) "
                + "VALUES (?, ?);";
        GeneratedKeyHolder key = new GeneratedKeyHolder();

        jdbcTemplate.update((Connection conn) -> {
            PreparedStatement statement = conn.prepareStatement(
                    sql, Statement.RETURN_GENERATED_KEYS);

            statement.setBoolean(1, newGame.getIsCorrect());
            statement.setString(2, newGame.getExact());
            return statement;
        }, key);

        newGame.setGameId(key.getKey().intValue());

        return newGame.getGameId();
    }

    @Override
    public String getExact() {
        Random gen = new Random();
        int exact = 0;
        while (hasDuplicates(exact = (gen.nextInt(9000) + 1000)));
        String exactStr = exact + "";
        return exactStr;
    }

    @Override
    @Transactional
    public Rounds guessNumber(Rounds currentRound, Games currentGame) {
        final String sql = "INSERT INTO Rounds(roundNumber, guess, bulls, cows, timestamps, gameId) "
                + "VALUES (?, ?, ?, ?, ?, ?);";
        GeneratedKeyHolder key = new GeneratedKeyHolder();

        if (currentRound.getGuess().length() != 4) {
            currentRound.setGuess(null);
        } else {
            try {
                int i = Integer.parseInt(currentRound.getGuess());
            } catch (NumberFormatException e) {
                currentRound.setGuess(null);
            }
        }

        jdbcTemplate.update((Connection conn) -> {
            PreparedStatement statement = conn.prepareStatement(
                    sql, Statement.RETURN_GENERATED_KEYS);

            statement.setInt(1, currentRound.getRoundNumber());
            statement.setString(2, currentRound.getGuess());
            statement.setInt(3, currentRound.getBulls());
            try {
                int i = Integer.parseInt(currentRound.getGuess());
            } catch (NumberFormatException e) {
                currentRound.setGuess(null);
            }
            statement.setInt(4, currentRound.getCows());
            statement.setString(5, currentRound.getTimestamps());
            statement.setInt(6, currentRound.getGameId());
            return statement;
        }, key);

        currentRound.setRoundId(key.getKey().intValue());

        final String sqlGame = "UPDATE Games "
                + "SET isCorrect = ? WHERE gameId = ?;";

        jdbcTemplate.update((Connection conn) -> {
            PreparedStatement statement = conn.prepareStatement(
                    sqlGame, Statement.RETURN_GENERATED_KEYS);

            statement.setBoolean(1, currentGame.getIsCorrect());
            statement.setInt(2, currentGame.getGameId());
            return statement;
        });

        return currentRound;
    }

    @Override
    public boolean hasDuplicates(int num) {
        boolean[] digs = new boolean[10];
        while (num > 0) {
            if (digs[num % 10]) {
                return true;
            }
            digs[num % 10] = true;
            num /= 10;
        }
        return false;
    }

    @Override
    public int calculateBulls(String guess, Games currentGame) {
        if (guess == null || currentGame.getGameId() == 0) {
            return -1;
        }
        int exact = 0;
        String actualAnswer = currentGame.getExact();

        for (int i = 0; i < actualAnswer.length(); i++) {
            for (int j = 0; j < guess.length(); j++) {
                if (i == j && actualAnswer.charAt(i) == guess.charAt(j)) {
                    exact++;
                }
            }
        }
        return exact;
    }

    @Override
    public int calculateCows(String guess, Games currentGame) {
        if (guess == null || currentGame.getGameId() == 0) {
            return -1;
        }
        int partial = 0;
        String actualAnswer = currentGame.getExact();

        for (int i = 0; i < actualAnswer.length(); i++) {
            for (int j = 0; j < guess.length(); j++) {
                if (i != j && actualAnswer.charAt(i) == guess.charAt(j)) {
                    partial++;
                }
            }
        }
        return partial;
    }

    @Override
    public List<Rounds> getGameRounds(int gameId) {
        final String sql = "SELECT r.* "
                + "FROM Rounds r WHERE r.gameId = ? ORDER BY `timestamps` ASC;";

        return jdbcTemplate.query(sql, new RoundsMapper(), gameId);
    }

    @Override
    public List<Games> getAllGames() {
        final String sql = "SELECT g.*, COUNT(r.RoundNumber) NumberOfRounds FROM "
                + "Games g LEFT OUTER JOIN Rounds r ON g.gameId = r.gameId GROUP BY "
                + "g.gameId;";
        return jdbcTemplate.query(sql, new GamesMapper());
    }

    @Override
    public Games getGameById(int gameId) {
        final String sql = "SELECT g.*, COUNT(r.RoundNumber) NumberOfRounds FROM "
                + "Games g LEFT OUTER JOIN Rounds r ON g.gameId = r.gameId "
                + "WHERE g.gameId = ?;";

        return jdbcTemplate.queryForObject(sql, new GamesMapper(), gameId);
    }

    @Override
    public Rounds findRoundsByGameId(int gameId) {

        final String sql = "SELECT gameId "
                + "FROM Rounds WHERE gameId = ?;";

        return jdbcTemplate.queryForObject(sql, new RoundsMapper(), gameId);
    }

    private static final class GamesMapper implements RowMapper<Games> {

        @Override
        public Games mapRow(ResultSet rs, int index) throws SQLException {
            Games g = new Games();
            g.setGameId(rs.getInt("gameId"));
            g.setIsCorrect(rs.getBoolean("isCorrect"));
            g.setExact(rs.getString("exact"));
            g.setGameRounds(rs.getInt("NumberOfRounds"));
            return g;
        }
    }

    private static final class RoundsMapper implements RowMapper<Rounds> {

        @Override
        public Rounds mapRow(ResultSet rs, int index) throws SQLException {
            Rounds r = new Rounds();
            r.setGameId(rs.getInt("gameId"));
            r.setRoundId(rs.getInt("roundId"));
            r.setRoundNumber(rs.getInt("roundNumber"));
            r.setGuess(rs.getString("guess"));
            r.setBulls(rs.getInt("bulls"));
            r.setCows(rs.getInt("cows"));
            r.setTimestamps(rs.getString("timestamps"));
            return r;
        }
    }
}
