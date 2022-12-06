#nom bdd = slackonscertif

DROP TABLE IF EXISTS channel;

CREATE TABLE channel (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    modification BOOLEAN DEFAULT TRUE
);

DROP TABLE IF EXISTS message;

CREATE TABLE message (
	id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    content TEXT NOT NULL,
    date_time DATETIME DEFAULT NOW() NOT NULL,
    channel_id INT NOT NULL,
    CONSTRAINT fk_channel_id FOREIGN KEY (channel_id) REFERENCES channel(id),
    CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES user(id)
);

DROP TABLE IF EXISTS user;

CREATE TABLE user (
	id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(15) NOT NULL
);

DROP TABLE IF EXISTS user_channel;

CREATE TABLE user_channel (
	channel_id INT NOT NULL,
    user_id INT NOT NULL,
    CONSTRAINT fk_channel_id FOREIGN KEY (channel_id) REFERENCES channel(id),
    CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES user(id)
);



INSERT INTO channel(name, modification) VALUES ('général', false), ('m2i', true), ('infotel', true);

INSERT INTO user(username) VALUES ('toto'), ('titi'), ('tata'), ('m2i');

INSERT INTO message(channel_id, user_id, content) VALUES (1, 1, 'coucou m2i'), (2, 2, 'coucou m2i'), (3, 3, 'coucou m2i'), (2, 4, 'coucou titi'), (3, 4, 'coucou tata');

INSERT INTO user_channel(channel_id, user_id) VALUES (1, 1),
(1, 2),
(1, 3),
(1, 4),
(2, 4),
(2, 3),
(3, 1),
(3, 2);