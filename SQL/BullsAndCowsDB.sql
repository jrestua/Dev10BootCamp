DROP DATABASE IF EXISTS BullsAndCowsDB;
CREATE DATABASE BullsAndCowsDB;

USE BullsAndCowsDB;

CREATE TABLE Games(
gameId INT PRIMARY KEY AUTO_INCREMENT,
isCorrect BOOLEAN DEFAULT false,
exact Varchar (4));


CREATE TABLE Rounds(
roundId INT PRIMARY KEY AUTO_INCREMENT,
gameId INT,
roundNumber INT,
guess Varchar (4),
bulls INT,
cows INT,
timestamps Varchar(64));

Select * from Games;

Select * from Rounds;