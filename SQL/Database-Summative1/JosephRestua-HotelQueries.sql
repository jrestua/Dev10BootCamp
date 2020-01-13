-- Part 4: Query the Database
-- Create a third SQL script that includes queries to retrieve the following data from the database.

USE HotelReservation;
-- 1. Write a query that returns a list of reservations that end in July 2023, including the name of 
-- the guest, the room number(s), and the reservation dates.
SELECT
	CONCAT(g.FirstName, ' ', g.LastName) GuestName,
	r.ReservationsID, 
	rr.RoomNumber,
	r.StartDate,
	r.EndDate
FROM
	Guests g
INNER JOIN GuestReservations gr
	ON gr.GuestID = g.GuestID
INNER JOIN Reservations r 
	ON r.ReservationsID = gr.ReservationsID
INNER JOIN RoomReservations rr
	ON rr.ReservationsID = r.ReservationsID
WHERE r.EndDate BETWEEN "2023-07-01" AND "2023-07-31";


-- Start from room
-- 2. Write a query that returns a list of all reservations for rooms with a jacuzzi, displaying the 
-- guest's name, the room number, and the dates of the reservation.
SELECT
	CONCAT(g.FirstName, ' ', g.LastName) GuestName,
	rr.ReservationsID,
	r.StartDate,
	r.EndDate,
	ro.RoomNumber,
	ro.HasJacuzzi
FROM
	Guests g
INNER JOIN GuestReservations gr
	ON gr.GuestID = g.GuestID
INNER JOIN Reservations r 
	ON r.ReservationsID = gr.ReservationsID
INNER JOIN RoomReservations rr
	ON rr.ReservationsID = r.ReservationsID
INNER JOIN Rooms ro
	ON ro.RoomNumber = rr.RoomNumber
WHERE ro.HasJacuzzi = 1;


-- 3. Write a query that returns all the rooms reserved for a specific guest, including the guest's name, 
-- the room(s) reserved, the starting date of the reservation, and how many people were included in the 
-- reservation. (Choose a guest's name from the existing data.)
Select
	r.ReservationsID,
	g.FirstName,
	g.LastName,
	r.StartDate,
	r.EndDate,
	r.Adults,
	r.Children
FROM
	Guests g
INNER JOIN GuestReservations gr
	ON gr.GuestID = g.GuestID
INNER JOIN Reservations r 
	ON r.ReservationsID = gr.ReservationsID
WHERE g.LastName = "Restua"
AND g.FirstName = "Joseph";


-- 4. Write a query that returns a list of rooms, reservation ID, and per-room cost for each 
-- reservation. The results should include all rooms, whether or not there is a reservation associated 
-- with the room.
SELECT
	r.RoomNumber,
	rr.ReservationsID,
	r.BasePrice
From
	Rooms r
Left Outer JOIN RoomReservations rr 
	ON rr.RoomNumber = r.RoomNumber;
-- WHERE rr.ReservationsID IS NOT NULL
-- OR NULL;


-- 5. Write a query that returns all the rooms accommodating at least three guests and that are reserved on 
-- any date in April 2023.
SELECT
    r.RoomNumber, 
    s.Adults,
    s.StartDate,
    s.EndDate
FROM
	RoomReservations r
INNER JOIN Reservations s
	ON s.ReservationsID = r.ReservationsID
WHERE s.StartDate BETWEEN "2023-04-01" AND "2023-04-30"
OR s.EndDate BETWEEN "2023-04-01" AND "2023-04-30"
HAVING s.Adults >= 3;


-- 6. Write a query that returns a list of all guest names and the number of reservations per guest, 
-- sorted starting with the guest with the most reservations and then by the guest's last name.
SELECT
	g.FirstName,
	g.LastName,
	COUNT(r.GuestID) Reservations
FROM
	Guests g
INNER JOIN GuestReservations r
	ON r.GuestID = g.GuestID
GROUP BY
	g.GuestID, g.LastName
ORDER BY
	Reservations DESC, g.LastName ASC;


-- 7. Write a query that displays the name, address, and phone number of a guest based on their 
-- phone number. (Choose a phone number from the existing data.)
SELECT
	*
FROM
	Guests
WHERE
	Phone = "(973) 722-6411";




-- For each query, include:
-- The request from this assignment as a comment above the query, including the number
-- The query itself
-- The results of the query in a comment under the query
-- Name the file YourName-HotelQueries.sql.