/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.bullsandcows.models;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author joe
 */
public class Rounds {

    private int gameId;
    private int roundId;
    private int roundNumber;
    private String guess;
    private int bulls;
    private int cows;
    private String timestamps;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getRoundId() {
        return roundId;
    }

    public void setRoundId(int roundId) {
        this.roundId = roundId;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    public int getBulls() {
        return bulls;
    }

    public void setBulls(int bulls) {
        this.bulls = bulls;
    }

    public int getCows() {
        return cows;
    }

    public void setCows(int cows) {
        this.cows = cows;
    }

    public String getTimestamps() {
        return timestamps;
    }

    public void setTimestamps(String timestamps) {
        this.timestamps = timestamps;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.gameId;
        hash = 29 * hash + this.roundId;
        hash = 29 * hash + this.roundNumber;
        hash = 29 * hash + Objects.hashCode(this.guess);
        hash = 29 * hash + this.bulls;
        hash = 29 * hash + this.cows;
        hash = 29 * hash + Objects.hashCode(this.timestamps);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Rounds other = (Rounds) obj;
        if (this.gameId != other.gameId) {
            return false;
        }
        if (this.roundId != other.roundId) {
            return false;
        }
        if (this.roundNumber != other.roundNumber) {
            return false;
        }
        if (this.bulls != other.bulls) {
            return false;
        }
        if (this.cows != other.cows) {
            return false;
        }
        if (!Objects.equals(this.guess, other.guess)) {
            return false;
        }
        if (!Objects.equals(this.timestamps, other.timestamps)) {
            return false;
        }
        return true;
    }

}
