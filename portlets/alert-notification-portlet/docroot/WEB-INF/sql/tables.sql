create table aa_adminalert (
	alertId LONG not null primary key,
	groupId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	location VARCHAR(75) null,
	resolution VARCHAR(75) null,
	expectedResolutionTime DATE null,
	resolutionStatus VARCHAR(75) null
);