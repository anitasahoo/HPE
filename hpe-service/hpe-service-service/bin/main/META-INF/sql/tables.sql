create table HPE_Actor (
	uuid_ VARCHAR(75) null,
	actorId LONG not null primary key,
	actorName VARCHAR(75) null,
	age INTEGER,
	languages VARCHAR(75) null,
	movies VARCHAR(75) null,
	criticRating INTEGER
);