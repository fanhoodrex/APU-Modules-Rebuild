SELECT * FROM [dbo].[AIRLINE]
SELECT * FROM [dbo].[AIRCRAFT]
SELECT * FROM [dbo].[FLIGHT]
SELECT * FROM [dbo].[AIRPORT]
SELECT * FROM [dbo].[PASSENGER]
SELECT * FROM [dbo].[TICKET]
SELECT * FROM [dbo].[CLASS]

-- Adding the foreign key constraint to each table
-- AIRCRAFT TABLE
ALTER TABLE [dbo].[AIRCRAFT]
ADD FOREIGN KEY ([Airline_ID]) REFERENCES [dbo].[AIRLINE]([Airline_ID]); -- Link AIRCRAFT to AIRLINE on [Airline_ID]

-- FLIGHT TABLE
ALTER TABLE FLIGHT
ADD FOREIGN KEY (Departure) REFERENCES AIRPORT(Airport_ID); -- Link FLIGHT to AIRPORT on [Departure]
ALTER TABLE FLIGHT
ADD FOREIGN KEY (Destination) REFERENCES AIRPORT(Airport_ID); -- Link FLIGHT to AIRPORT on [Destination]
ALTER TABLE FLIGHT
ADD FOREIGN KEY (Aircraft_ID) REFERENCES AIRCRAFT(Aircraft_ID); -- Link FLIGHT to AIRCRAFT on [Aircraft_ID]

-- TICKET TABLE
ALTER TABLE TICKET
ADD FOREIGN KEY (Flight_ID) REFERENCES FLIGHT(Flight_ID); -- Link TICKET to FLIGHT on [Flight_ID]
ALTER TABLE TICKET
ADD FOREIGN KEY (Passenger_ID) REFERENCES PASSENGER(Passenger_ID); -- Link TICKET to PASSENGER on [Passenger_ID]
ALTER TABLE TICKET
ADD FOREIGN KEY (Class_ID) REFERENCES CLASS(Class_ID); -- Link TICKET to CLASS on [Class_ID]

-- Member 1 DML Query - FANG
-- Create a query which shows direct flights only for given dates, source & destination.
SELECT [Reserved_Date],[Departure],[Destination]
FROM [dbo].[FLIGHT]
WHERE [Reserved_Date] = '2021-11-01' and Departure = 'ap01' and Destination = 'ap02';

-- Create a query which shows aircraft code, class code, and expected revenue for each class code, 
SELECT AIRCRAFT.Code as aircraft_code, CLASS.Code as class_code, SUM(Value) as expected_revenue
FROM PASSENGER -- link six table (PASSENGER, TICKET, CLASS, FLIGHT, AIRCRAFT, AIRLINE)
INNER JOIN TICKET
ON PASSENGER.Passenger_ID = TICKET.Passenger_ID
INNER JOIN CLASS
ON TICKET.Class_ID = CLASS.Class_ID
INNER JOIN FLIGHT
ON TICKET.Flight_ID = FLIGHT.Flight_ID
INNER JOIN AIRCRAFT
ON FLIGHT.Aircraft_ID = AIRCRAFT.Aircraft_ID
INNER JOIN AIRLINE
ON AIRCRAFT.Airline_ID = AIRLINE.Airline_ID 
WHERE AIRLINE.Airline_ID = 'al01'
GROUP BY  AIRCRAFT.Code, CLASS.Code

-- Along with the total revenue of each aircraft for a given airline in a single journey
SELECT AIRCRAFT.Aircraft_ID, SUM(Value) as total_revenue
FROM TICKET -- link four table (TICKET, FLIGHT, AIRCRAFT, AIRLINE)
INNER JOIN FLIGHT
ON TICKET.Flight_ID = FLIGHT.Flight_ID
INNER JOIN AIRCRAFT
ON FLIGHT.Aircraft_ID = AIRCRAFT.Aircraft_ID
INNER JOIN AIRLINE
ON AIRCRAFT.Airline_ID = AIRLINE.Airline_ID 
WHERE AIRLINE.Airline_ID = 'al01'
GROUP BY AIRCRAFT.Aircraft_ID

-- Create a query which shows all passenger numbers with their corresponding descriptions of reservation status for a specific airline.
SELECT Number as Passenger_Number, FLIGHT.Flight_ID, Reserved_Date, Departure, Destination, Boarding_Time, Duration, Gate
FROM PASSENGER
INNER JOIN TICKET
ON PASSENGER.Passenger_ID = TICKET.Passenger_ID
INNER JOIN FLIGHT
ON TICKET.Flight_ID = FLIGHT.Flight_ID
INNER JOIN AIRCRAFT
ON FLIGHT.Aircraft_ID = AIRCRAFT.Aircraft_ID
INNER JOIN AIRLINE
ON AIRCRAFT.Airline_ID = AIRLINE.Airline_ID -- link all four table (PASSENGER, TICKET, FLIGHT, AIRCRAFT, AIRLINE)
WHERE AIRLINE.Airline_ID = 'al01';

-- Create a query which shows the name of airline that has been most frequently travelled through 
-- by the passengers for specified source and destination in given range of dates.
SELECT TOP 1 AIRLINE.Airline_Name, count(*) AS Frequency
FROM FLIGHT
INNER JOIN AIRCRAFT
on FLIGHT.Aircraft_ID = AIRCRAFT.Aircraft_ID
INNER JOIN AIRLINE
on AIRCRAFT.Airline_ID = AIRLINE.Airline_ID
WHERE Departure = 'ap01' and Destination = 'ap02' and Reserved_Date BETWEEN '2021-11-01' AND '2021-11-03'
GROUP BY AIRLINE.Airline_Name
ORDER BY Frequency DESC;

-- Create a query which provides, for each age category of passengers, the following information:

-- The total number of infants, children, youths, adults & seniors 
-- travelling through specified flight in a single journey operated by a specified airline in given date.
-- Result should contain both detailed breakup & summary for above mentioned categories along with overall summary.
SELECT PASSENGER.Age_Category, count(*) as total_number
FROM PASSENGER
INNER JOIN TICKET
ON PASSENGER.Passenger_ID = TICKET.Passenger_ID
INNER JOIN FLIGHT
ON TICKET.Flight_ID = FLIGHT.Flight_ID
INNER JOIN AIRCRAFT
ON FLIGHT.Aircraft_ID = AIRCRAFT.Aircraft_ID
INNER JOIN AIRLINE
ON AIRCRAFT.Airline_ID = AIRLINE.Airline_ID
WHERE FLIGHT.[Flight_ID] = 'f01' and Reserved_Date = '2021-11-01'
GROUP BY PASSENGER.Age_Category


-- Create a query which shows the airline name offering maximum number of journey routes along with names of source and destination.
SELECT TOP 1 AIRLINE.Airline_Name, count(*) as number_of_journey, Departure, Destination
FROM FLIGHT
INNER JOIN AIRCRAFT
on FLIGHT.Aircraft_ID = AIRCRAFT.Aircraft_ID
INNER JOIN AIRLINE
on AIRCRAFT.Airline_ID = AIRLINE.Airline_ID
WHERE Departure = 'ap01' and Destination = 'ap02'
GROUP BY AIRLINE.Airline_Name, Departure, Destination

-- Member 2 DML Query - ADRIAN