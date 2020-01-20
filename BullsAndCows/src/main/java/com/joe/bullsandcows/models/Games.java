/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.bullsandcows.models;

import java.util.Objects;

/**
 *
 * @author joe
 */
public class Games {

    private int gameId;
    private String exact;
    private boolean isCorrect;
    private int gameRounds;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public boolean getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    public String getExact() {
        return exact;
    }

    public void setExact(String exact) {
        this.exact = exact;
    }

    public int getGameRounds() {
        return gameRounds;
    }

    public void setGameRounds(int gameRounds) {
        this.gameRounds = gameRounds;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.gameId;
        hash = 47 * hash + Objects.hashCode(this.exact);
        hash = 47 * hash + (this.isCorrect ? 1 : 0);
        hash = 47 * hash + this.gameRounds;
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
        final Games other = (Games) obj;
        if (this.gameId != other.gameId) {
            return false;
        }
        if (this.isCorrect != other.isCorrect) {
            return false;
        }
        if (this.gameRounds != other.gameRounds) {
            return false;
        }
        if (!Objects.equals(this.exact, other.exact)) {
            return false;
        }
        return true;
    }

}
