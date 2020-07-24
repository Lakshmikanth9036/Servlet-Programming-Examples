CREATE TABLE user_master(
	user_id INT UNIQUE NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50),
	email VARCHAR(50),
	mobile VARCHAR(50),
	password VARCHAR(50),
	PRIMARY KEY(user_id)
);
