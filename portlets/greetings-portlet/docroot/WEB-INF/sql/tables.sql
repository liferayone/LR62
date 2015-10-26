create table greetings_GreetingsMessage (
	StatusId LONG not null primary key,
	Message VARCHAR(75) null,
	button_color VARCHAR(75) null
);

create table greetings_User_Status (
	UserId LONG not null primary key,
	StatusId LONG
);