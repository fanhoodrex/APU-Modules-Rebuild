CREATE TABLE [dbo].[User] (
    [Id]       VARCHAR (50)  NOT NULL,
    [username] VARCHAR (50)  NOT NULL,
    [password] VARCHAR (50)  NOT NULL,
    [emaill]   VARCHAR (255) NOT NULL,
    [telphone] VARCHAR (20)  NULL,
    [address]  VARCHAR (255) NULL,
    PRIMARY KEY CLUSTERED ([Id] ASC)
);

