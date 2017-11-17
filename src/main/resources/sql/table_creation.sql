CREATE TABLE user
(
	  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(64) NOT NULL,
    password VARCHAR(32) NOT NULL
);

CREATE TABLE user_attempts
(
	  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    attempt_amount INT,
    user_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE user_records
(
	  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    avg_attempt_amount INT,
    user_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user(id)
);