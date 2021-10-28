-- ADRIAN
CREATE TRIGGER Delay
on FLIGHT
INSTEAD OF DELETE
AS
BEGIN
    RAISERROR ('Flight reservation cannot be proceeded, Flight will be postpone.', 16,10)
    SELECT * FROM FLIGHT
    UPDATE FLIGHT SET Status = 'Delayed'
    FROM FLIGHT f INNER JOIN DELETED d ON f.Flight_ID = d.Flight_ID
END
GO

DELETE FROM FLIGHT WHERE Flight_ID= 'f14';

-- FANG
ALTER TRIGGER Cancellation
ON FLIGHT
AFTER DELETE
AS
BEGIN
    DECLARE @ID NVARCHAR
    SELECT @ID = Flight_ID FROM DELETED
    INSERT INTO [AUDIT] VALUES ('Flight_ID = ' + CAST(@ID AS nvarchar) +  ' is cancelled at ' + CAST(Getdate() AS nvarchar))
END

DELETE FROM FLIGHT WHERE Flight_ID = 'f15'

--Soong
Create Trigger Reschedule
On FLIGHT
AFTER INSERT, UPDATE 
AS BEGIN
    SELECT * FROM FLIGHT
	UPDATE FLIGHT SET FLIGHT.Date = GetDate()
	FROM INSERTED j INNER JOIN INSERTED i ON j.FLight_ID = i.Flight_ID
	END

UPDATE FLIGHT SET FLIGHT.Date = DATEADD(month, 1, GetDate()) WHERE FLIGHT.Flight_ID='f11';
Select * FROM Flight