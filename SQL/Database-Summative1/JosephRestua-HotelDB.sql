Drop DATABASE IF EXISTS HotelReservation;

CREATE DATABASE HotelReservation;

USE HotelReservation;

CREATE TABLE Rooms (
	RoomNumber INT PRIMARY KEY,
    RoomType VARCHAR(10) NOT NULL,
    ADAAccessible TINYINT(1) NOT NULL,
    StandardOccupancy INT(2) NOT NULL,
    MaximumOccupancy INT(2) NOT NULL,
	BasePrice DECIMAL(5, 2) NOT NULL,
    ExtraPerson DECIMAL(4, 2) NOT NULL,
    -- Additional $10 if yes
    HasJacuzzi TINYINT(1) NOT NULL
    -- Additional $25 if yes
);


-- Has the amenities
CREATE TABLE Amenity (
	AmenityID INT PRIMARY KEY AUTO_INCREMENT,
    AmenityType VARCHAR(32)
);


CREATE TABLE RoomAmenity ( 
	RoomNumber INT NOT NULL,
	AmenityID INT NOT NULL,

PRIMARY KEY pk_RoomAmenity (RoomNumber, AmenityId),
	FOREIGN KEY fk_RoomAmenity_Rooms (RoomNumber) REFERENCES Rooms (RoomNumber),
 	FOREIGN KEY fk_RoomAmenity_Amenity (AmenityId) REFERENCES Amenity(AmenityId)
);


CREATE TABLE Reservations (
	ReservationsID INT PRIMARY KEY AUTO_INCREMENT,
    Adults INT(4) NOT NULL,
    Children INT(4) NOT NULL,
    StartDate DATE,
    EndDate DATE,
    TotalRoomCost DECIMAL(32, 2) NOT NULL
);


CREATE TABLE Guests (
	GuestID INT PRIMARY KEY AUTO_INCREMENT,
	FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    Address VARCHAR(100) NOT NULL,
	City VARCHAR(50) NOT NULL,
    State CHAR(2) NOT NULL,
	Zip CHAR(5) NOT NULL,
	Phone CHAR(14)
);


-- Guest to reservation
CREATE TABLE GuestReservations (
	GuestID INT not null,
	ReservationsID INT not null,
    
PRIMARY KEY pk_GuestReservations (GuestID, ReservationsID),
    FOREIGN KEY fk_GuestReservations_Guests (GuestID) REFERENCES Guests (GuestID),
	FOREIGN KEY fk_GuestReservations_Reservations (ReservationsID) REFERENCES Reservations (ReservationsID)
);


-- Room to reservation
CREATE TABLE RoomReservations (
	RoomNumber INT not null,
	ReservationsID INT not null,

PRIMARY KEY pk_RoomReservations (RoomNumber, ReservationsID),
    FOREIGN KEY fk_RoomReservations_Rooms (RoomNumber) REFERENCES Rooms (RoomNumber),
	FOREIGN KEY fk_RoomReservations_Reservations (ReservationsID) REFERENCES Reservations (ReservationsID)
);