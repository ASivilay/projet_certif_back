#nom bdd = slackonscertif

DROP TABLE channel, message ;

CREATE TABLE channel (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    modification BOOLEAN DEFAULT TRUE
);

CREATE TABLE message (
	id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(15) NOT NULL,
    content TEXT NOT NULL,
    date_time DATETIME DEFAULT NOW() NOT NULL,
    channel_id INT NOT NULL,
    CONSTRAINT fk_channel_id FOREIGN KEY (channel_id) REFERENCES channel(id)
);




INSERT INTO channel(name, modification) VALUES ('général', false), ('m2i', true), ('infotel', true);

INSERT INTO message(channel_id, username, content) VALUES (1, 'toto', 'coucou m2i'), (2, 'titi', 'coucou m2i'), (3, 'tata', 'coucou m2i'), (2, 'm2i', 'coucou titi'), (3, 'm2i', 'coucou tata');
