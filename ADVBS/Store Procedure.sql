-- FANG
CREATE PROCEDURE SearchFlight
    @Date Date,
    @Source nvarchar(50),
    @Destination nvarchar(50)
AS
IF @Date in (Select [Date] from FLIGHT)
    IF @Source in (Select [Source] from FLIGHT)
        IF @Destination in (Select [Destination] from FLIGHT)
            SELECT * FROM FLIGHT
            WHERE Date = @Date and @Source = 'KUL' and @Destination = 'SIN'
        ELSE
            Print 'Destination of flight not found'
    ELSE
        Print 'Source of flight not found'
ELSE
    Print 'Date of flight not found'
GO

EXEC SearchFlight @Date = '2021-10-28', @Source = 'KUL', @Destination = 'SIN'

-- ADRIAN
CREATE PROCEDURE ShowVegetarianOrder @Type varchar(20)
AS BEGIN
SELECT Flight_ID, [Option], [Type]
FROM FLIGHT
INNER JOIN AIRCRAFT
ON FLIGHT.Aircraft = AIRCRAFT.Code
INNER JOIN AIRLINE
ON AIRCRAFT.Airline = AIRLINE.Code
INNER JOIN MEAL
ON AIRLINE.Code = MEAL.Airline
Where [Type] = @Type
ORDER BY Flight_ID;
END 
EXEC ShowVegetarianOrder @Type = 'non-vegetarian';

-- SOONG
CREATE PROCEDURE ShowJourney @PassengerID varchar(10)
AS BEGIN
SELECT PASSENGER.Name, Date, count(*) AS number_of_booked_seats, Class
FROM TICKET
INNER JOIN FLIGHT
ON TICKET.Flight_ID = FLIGHT.Flight_ID
INNER JOIN PASSENGER 
ON PASSENGER.Passenger_ID = TICKET.Passenger_ID
INNER JOIN CLASS
ON TICKET.Class_ID = CLASS.Class_ID
WHERE TICKET.Passenger_ID = @PassengerID
GROUP BY PASSENGER.Name, Date, Class;
END

EXEC ShowJourney @PassengerID = 'p01';