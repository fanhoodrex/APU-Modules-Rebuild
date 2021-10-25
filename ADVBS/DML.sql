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
ALTER TABLE TICKET
ADD FOREIGN KEY (Meal) REFERENCES MEAL(Meal_ID); -- Link TICKET to MEAL on [Meal_ID]
ALTER TABLE TICKET
ADD FOREIGN KEY ([Service]) REFERENCES [SERVICE](Service_ID); -- Link TICKET to SERVICE on [Service_ID]

-- PASSENGER
ALTER TABLE PASSENGER
ADD FOREIGN KEY (Catogary) REFERENCES CATEGORY(Category_ID); -- Link PASSENGER to FARE on [Flight_ID]

-- MEAL
ALTER TABLE MEAL
ADD FOREIGN KEY (Airline) REFERENCES AIRLINE(Code); -- Link MEAL to AIRLINE on [AIRLINE.Code]



-- Member 1 DML Query (FANG)
-- i. Shows direct flights only for given dates, source & destination.
SELECT * FROM FLIGHT
WHERE Date = '2021-11-01' and Source = 'KUL' and Destination = 'SIN';

-- ii-1. shows aircraft code, class code, and expected revenue for each class code, 
SELECT AIRCRAFT.Code AS aircraft_code, CLASS.Code AS class_code, SUM(Value) AS expected_revenue
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

-- ii-2. Along with the total revenue of each aircraft for a given airline in a single journey
SELECT Flight.Aircraft, SUM(Value) AS total_revenue
FROM TICKET
INNER JOIN FLIGHT
ON TICKET.Flight_ID = FLIGHT.Flight_ID
INNER JOIN AIRCRAFT
ON FLIGHT.Aircraft = AIRCRAFT.Code
INNER JOIN AIRLINE
ON AIRCRAFT.Airline = AIRLINE.Code
WHERE AIRLINE.Code = 'AXM'
GROUP BY Flight.Aircraft

-- iii. Shows all passenger numbers with their corresponding descriptions of reservation status for a specific airline.
SELECT Number AS Passenger_Number, Ticket.Flight_ID, Date, Source, Destination
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

-- iv. Shows the name of airline that has been most frequently travelled through by the passengers for specified source and destination in given range of dates.
SELECT TOP 1 AIRLINE.Name, count(*) AS Frequency
FROM FLIGHT
INNER JOIN AIRCRAFT
ON FLIGHT.Aircraft = AIRCRAFT.Code
INNER JOIN AIRLINE
ON AIRCRAFT.Airline = AIRLINE.Code
WHERE Source = 'KUL' and Destination = 'SIN' and Date BETWEEN '2021-11-01' AND '2021-11-03'
GROUP BY AIRLINE.Name
ORDER BY Frequency DESC;

-- v. For each age category of passengers, the total number of infants, children, youths, adults & seniors travelling through specified flight in a single journey operated by a specified airline in given date.
SELECT CATEGORY.Category, count(*) AS total_number
FROM PASSENGER
INNER JOIN CATEGORY
ON PASSENGER.Category = CATEGORY.Category_ID
INNER JOIN TICKET
ON PASSENGER.Passenger_ID = TICKET.Passenger_ID
INNER JOIN FLIGHT
ON TICKET.Flight_ID = FLIGHT.Flight_ID
INNER JOIN AIRCRAFT
ON FLIGHT.Aircraft = AIRCRAFT.Code
INNER JOIN AIRLINE
ON AIRCRAFT.Airline = AIRLINE.Code
WHERE FLIGHT.Flight_ID = 'f01' and AIRLINE.Code = 'AXM' and Date = '2021-11-01'
GROUP BY CATEGORY.Category

-- vi. Shows the airline name offering maximum number of journey routes along with names of source and destination.
SELECT TOP 1 AIRLINE.Name, count(*) AS number_of_journey
FROM FLIGHT
INNER JOIN AIRCRAFT
ON FLIGHT.Aircraft = AIRCRAFT.Code
INNER JOIN AIRLINE
ON AIRCRAFT.Airline = AIRLINE.Code
WHERE Source = 'KUL' and Destination = 'SIN'
GROUP BY AIRLINE.Name

-- Member 2 DML Query (ADRIAN)
-- viii. Displays flight details, such as, the aircraft code, regular fare, and discounted fare for the first class. 
-- A 25% discount is being offered. Label the columns as Aircraft, Regular First-Class fare, and Discounted First Class fare.
Select Code As Aircraft, Value As Regular_FarePrice, (Value * 0.75) As Discounted_First_Class_Fare
From Aircraft
Cross Join Ticket
Where Ticket.Class_ID = 'c1'

-- Fang's Answer to viii
SELECT Code AS Aircraft_Code, Value AS Regular_FarePrice, (Value * 0.75) AS Discounted_First_Class_Fare
FROM TICKET
INNER JOIN FLIGHT
ON TICKET.Flight_ID = FLIGHT.Flight_ID
INNER JOIN AIRCRAFT
ON FLIGHT.Aircraft = AIRCRAFT.Code
Where Ticket.Class_ID = 'c1'

-- ix. Displays the sorted details of flights to given city code with the least duration flight displayed first.
Select * From Flight
Where Destination = 'SIN'
ORDER BY Duration_Mins ASC

-- x. Create a query which displays the types of non-vegetarian meals offered on flights.
SELECT Flight_ID, [Option], [Type]
FROM FLIGHT
INNER JOIN AIRCRAFT
ON FLIGHT.Aircraft = AIRCRAFT.Code
INNER JOIN AIRLINE
ON AIRCRAFT.Airline = AIRLINE.Code
INNER JOIN MEAL
ON AIRLINE.Code = MEAL.Airline
WHERE Type = 'non-vegetarian'
ORDER BY Flight_ID;

-- xi. Create a query which shows the names of countries to which TSI provides flight reservations. Ensure that duplicate  country names are eliminated from the list.
Select DISTINCT(Country)
FROM Flight
INNER JOIN AIRCRAFT
ON FLIGHT.Aircraft = AIRCRAFT.Code
INNER JOIN AIRLINE
ON AIRCRAFT.Airline = Airline.Code

-- xii. for each airline, the total number of flights scheduled in a given date.
SELECT Name AS airline, Date, Source, Destination, count(*) AS total_number_of_flights
FROM Flight
INNER JOIN AIRCRAFT
ON FLIGHT.Aircraft = AIRCRAFT.Code
INNER JOIN AIRLINE
ON AIRCRAFT.Airline = Airline.Code
WHERE Date = '2021-11-1'
GROUP BY Name, Date, Source, Destination

-- xiii. Shows the names of the meal options available on the given airline.
SELECT Name, [Option]
FROM MEAL
INNER JOIN AIRLINE
ON MEAL.Airline = AIRLINE.Code
WHERE Airline = 'AXM'

-- Member 3 DML Query (SOONG CHUK MING)
-- xv. Shows the minimum, maximum, and average journey hours for flights to given city code. Display column headings as, Minimum duration, Maximum duration, and Average duration respectively.
SELECT MIN(Duration_Mins) AS Minimum_duration, 
    MAX(Duration_Mins) AS Maximum_duration,
    AVG(Duration_Mins) AS Average_duration
FROM FLIGHT
WHERE Destination = 'SIN'

-- xvi. Shows the journey date, number of booked seats, and class name for given passenger.
SELECT PASSENGER.Name, Date, count(*) AS number_of_booked_seats, Class
FROM TICKET
INNER JOIN FLIGHT
ON TICKET.Flight_ID = FLIGHT.Flight_ID
INNER JOIN PASSENGER 
ON PASSENGER.Passenger_ID = TICKET.Passenger_ID
INNER JOIN CLASS
ON TICKET.Class_ID = CLASS.Class_ID
WHERE TICKET.Passenger_ID = 'p01'
GROUP BY PASSENGER.Name, Date, Class;

-- xvii. Shows the names of meals not requested by any passenger.
SELECT [Option] AS names_of_meals
FROM MEAL
WHERE [Option] NOT IN (
    SELECT DISTINCT([Option])
    FROM PASSENGER
    INNER JOIN TICKET
    ON PASSENGER.Passenger_ID = TICKET.Passenger_ID
    INNER JOIN MEAL
    ON TICKET.Meal = MEAL.Meal_ID
)

-- xviii. Shows the details of passengers booked through a specified airline in a given date for multi-city flights.
SELECT PASSENGER.Passenger_ID, [Number], PASSENGER.Name, Gender, Passport, Source, Destination
FROM PASSENGER
INNER JOIN TICKET
ON PASSENGER.Passenger_ID = TICKET.Passenger_ID
INNER JOIN FLIGHT
ON TICKET.Flight_ID = FLIGHT.Flight_ID
INNER JOIN AIRCRAFT
ON FLIGHT.Aircraft = AIRCRAFT.Code
INNER JOIN AIRLINE
ON AIRCRAFT.Airline = AIRLINE.Code
WHERE AIRLINE.Code= 'AXM' AND [Date] = '2021-11-1';

--xix. for each airline, total number of unaccompanied children travelling in a given date.
SELECT AIRLINE.Code, AIRLINE.[Name], COUNT(*) as total_number_of_unaccompanied_children
FROM PASSENGER
INNER JOIN CATEGORY
ON PASSENGER.Category = CATEGORY.Category_ID
INNER JOIN TICKET
ON PASSENGER.Passenger_ID = TICKET.Passenger_ID
INNER JOIN [SERVICE]
ON TICKET.[Service] = [SERVICE].Service_ID
INNER JOIN FLIGHT
ON TICKET.Flight_ID = FLIGHT.Flight_ID
INNER JOIN AIRCRAFT
ON FLIGHT.Aircraft = AIRCRAFT.Code
INNER JOIN AIRLINE
ON AIRCRAFT.Airline = AIRLINE.Code
WHERE [Date] = '2021-11-01' AND Service_ID = 's2'
GROUP BY AIRLINE.Code, AIRLINE.[Name];

--xx. Shows the details of passengers who have availed any extra, services for a given flight on specified date.
SELECT PASSENGER.Passenger_ID, Number, PASSENGER.[Name], Gender, Passport, DOB, CATEGORY.Category, [Description] AS Extra_Service
FROM PASSENGER
INNER JOIN CATEGORY
ON PASSENGER.Category = CATEGORY.Category_ID
INNER JOIN TICKET
ON PASSENGER.Passenger_ID = TICKET.Passenger_ID
INNER JOIN [SERVICE]
ON TICKET.[Service] = [SERVICE].Service_ID
INNER JOIN FLIGHT
ON TICKET.Flight_ID = FLIGHT.Flight_ID
INNER JOIN AIRCRAFT
ON FLIGHT.Aircraft = AIRCRAFT.Code
INNER JOIN AIRLINE
ON AIRCRAFT.Airline = AIRLINE.Code
WHERE AIRLINE.Code = 'AXM' AND [Date] = '2021-11-01';