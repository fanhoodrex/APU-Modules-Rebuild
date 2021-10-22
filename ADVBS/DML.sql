SELECT * FROM AIRLINE
SELECT * FROM AIRCRAFT
SELECT * FROM [dbo].[FLIGHT]
SELECT * FROM [dbo].[AIRPORT]
SELECT * FROM [dbo].[PASSENGER]
SELECT * FROM [dbo].[TICKET]
SELECT * FROM [dbo].[CLASS]

-- Adding the foreign key constraint to each table
-- AIRCRAFT
ALTER TABLE [dbo].[AIRCRAFT]
ADD FOREIGN KEY (Airline) REFERENCES AIRLINE(Code); -- Link AIRCRAFT to AIRLINE on [Airline_ID]

-- FLIGHT
ALTER TABLE FLIGHT
ADD FOREIGN KEY (Source) REFERENCES AIRPORT(Code); -- Link FLIGHT to AIRPORT on [Source]
ALTER TABLE FLIGHT
ADD FOREIGN KEY (Destination) REFERENCES AIRPORT(Code); -- Link FLIGHT to AIRPORT on [Destination]
ALTER TABLE FLIGHT 
ADD FOREIGN KEY (Aircraft) REFERENCES AIRCRAFT(Code); -- Link FLIGHT to AIRPORT on [Aircraft]

-- TICKET
ALTER TABLE TICKET
ADD FOREIGN KEY (Flight_ID) REFERENCES FLIGHT(Flight_ID); -- Link TICKET to FLIGHT on [Flight_ID]
ALTER TABLE TICKET
ADD FOREIGN KEY (Passenger_ID) REFERENCES PASSENGER(Passenger_ID); -- Link TICKET to PASSENGER on [Passenger_ID]
ALTER TABLE TICKET
ADD FOREIGN KEY (Class_ID) REFERENCES CLASS(Class_ID); -- Link TICKET to CLASS on [Class_ID]

-- PASSENGER
ALTER TABLE PASSENGER
ADD FOREIGN KEY (Catogary) REFERENCES FARE([FARE_ID]); -- Link PASSENGER to FARE on [Flight_ID]

-- Member 1 DML Query - FANG
-- Create a query which shows direct flights only for given dates, source & destination.
SELECT * FROM FLIGHT
WHERE Date = '2021-11-01' and Source = 'KUL' and Destination = 'SIN';

-- Create a query which shows aircraft code, class code, and expected revenue for each class code, 
SELECT AIRCRAFT.Code as aircraft_code, CLASS.Code as class_code, SUM(Value) as expected_revenue
FROM TICKET
INNER JOIN PASSENGER 
ON PASSENGER.Passenger_ID = TICKET.Passenger_ID
INNER JOIN CLASS
ON TICKET.Class_ID = CLASS.Class_ID
INNER JOIN FLIGHT
ON TICKET.Flight_ID = FLIGHT.Flight_ID
INNER JOIN AIRCRAFT
ON FLIGHT.Aircraft = AIRCRAFT.Code
INNER JOIN AIRLINE
ON AIRCRAFT.Airline = AIRLINE.Code
GROUP BY AIRCRAFT.Code, CLASS.Code
ORDER BY aircraft_code

-- Along with the total revenue of each aircraft for a given airline in a single journey
SELECT Flight.Aircraft, SUM(Value) as total_revenue
FROM TICKET
INNER JOIN FLIGHT
ON TICKET.Flight_ID = FLIGHT.Flight_ID
INNER JOIN AIRCRAFT
ON FLIGHT.Aircraft = AIRCRAFT.Code
INNER JOIN AIRLINE
ON AIRCRAFT.Airline = AIRLINE.Code
WHERE AIRLINE.Code = 'AXM'
GROUP BY Flight.Aircraft

-- Create a query which shows all passenger numbers with their corresponding descriptions of reservation status for a specific airline.
SELECT Number as Passenger_Number, Ticket.Flight_ID, Date, Source, Destination
FROM PASSENGER
INNER JOIN TICKET
ON PASSENGER.Passenger_ID = TICKET.Passenger_ID
INNER JOIN FLIGHT
ON TICKET.Flight_ID = FLIGHT.Flight_ID
INNER JOIN AIRCRAFT
ON FLIGHT.Aircraft = AIRCRAFT.Code
INNER JOIN AIRLINE
ON AIRCRAFT.Airline = AIRLINE.Code -- link all four table (PASSENGER, TICKET, FLIGHT, AIRCRAFT, AIRLINE)
WHERE AIRLINE.Code = 'AXM';

-- Create a query which shows the name of airline that has been most frequently travelled through by the passengers for specified source and destination in given range of dates.
SELECT TOP 1 AIRLINE.Name, count(*) AS Frequency
FROM FLIGHT
INNER JOIN AIRCRAFT
on FLIGHT.Aircraft = AIRCRAFT.Code
INNER JOIN AIRLINE
on AIRCRAFT.Airline = AIRLINE.Code
WHERE Source = 'KUL' and Destination = 'SIN' and Date BETWEEN '2021-11-01' AND '2021-11-03'
GROUP BY AIRLINE.Name
ORDER BY Frequency DESC;

-- Create a query which provides, for each age category of passengers, the following information:
-- The total number of infants, children, youths, adults & seniors travelling through specified flight in a single journey operated by a specified airline in given date.
SELECT FARE.Category, count(*) as total_number
FROM PASSENGER
INNER JOIN FARE
ON PASSENGER.Category = FARE.FARE_ID
INNER JOIN TICKET
ON PASSENGER.Passenger_ID = TICKET.Passenger_ID
INNER JOIN FLIGHT
ON TICKET.Flight_ID = FLIGHT.Flight_ID
INNER JOIN AIRCRAFT
ON FLIGHT.Aircraft = AIRCRAFT.Code
INNER JOIN AIRLINE
ON AIRCRAFT.Airline = AIRLINE.Code
WHERE FLIGHT.Flight_ID = 'f01' and AIRLINE.Code = 'AXM' and Date = '2021-11-01'
GROUP BY FARE.Category

-- Create a query which shows the airline name offering maximum number of journey routes along with names of source and destination.
SELECT TOP 1 AIRLINE.Name, count(*) as number_of_journey
FROM FLIGHT
INNER JOIN AIRCRAFT
on FLIGHT.Aircraft = AIRCRAFT.Code
INNER JOIN AIRLINE
on AIRCRAFT.Airline = AIRLINE.Code
WHERE Source = 'KUL' and Destination = 'SIN'
GROUP BY AIRLINE.Name

-- Member 2 DML Query - ADRIAN
--Create a query which displays flight details, such  as, the aircraft code, regular fare, and discounted fare for the first class. 
--A 25% discount is being offered. Label the columns as Aircraft, Regular First-Class fare, and Discounted First Class fare.
Select Code As Aircraft, Value As RegularFarePrice, (Value * 0.75) As DiscountedFirstClassFare
From Aircraft
Cross Join Ticket
Where Ticket.Class_ID='c1'

--Create a query which displays the sorted details of flights to given city code with the least duration flight displayed first .
Select * From Flight
Where Destination = 'ap02'
ORDER BY Duration ASC

--Create a query which displays the types of non-vegetarian meals offered on flights. 


--Create a query which shows the names of countries to which TSI provides flight reservations. 
--Ensure that duplicate  country names are eliminated from the list.
Select Destination from Flight

--Create a query which provides, for each airline, the following information:
--The total number of flights scheduled in a given date. 
--Result should contain both detailed breakup & summary for flights each airline along with overall summary.



-- Member 3 DML Query - SOONG CHUK MING
--Create a query which shows the minimum, maximum, and average journey hours for flights to given city code. 
--Display column headings as, Minimum duration, Maximum duration, and Average duration respectively.
Select 

--Create a query which shows the journey date, number of booked seats, 
--and class name for given passenger.


--Create a query which shows the names of meals 
--not requested by any passenger.


--Create a query which shows the details of passengers booked through a specified airline 
--in a given date for multi-city flights.


--xix) Create a query which provides, for each airline, 
--the following information
--total number of unaccompanied children travelling in a given date. 


--Create a query which shows the details of passengers who have availed any extra 
--services for a given flight on specified date. 


--Develop one additional query of your own which provides information that would be useful for the business. Marks will be awarded depending on the 
--technical skills shown and the relevance of the query.