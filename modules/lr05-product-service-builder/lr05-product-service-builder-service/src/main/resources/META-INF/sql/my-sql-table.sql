create table LR_PRODUCT_SB_Product (
	id_ INT(7) not null,
	uuid_ VARCHAR(75) default null,
	name VARCHAR(75) default null,
	quantity INTEGER default 0,
	unitPrice VARCHAR(75) default '0.00',
	description VARCHAR(75) default null,
	status INTEGER default 0,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) default null,
	statusDate DATE default null,
	userId INT(7),
	groupId INT(7),
	companyId INT(7),
	userName VARCHAR(75) default null,
	createDate DATE default null,
	modifiedDate DATE default null,
    PRIMARY KEY(id_)
);