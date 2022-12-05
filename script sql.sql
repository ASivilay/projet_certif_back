CREATE TABLE canal (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE message (
	id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(15) NOT NULL,
    content TEXT NOT NULL,
    message_date DATETIME DEFAULT NOW() NOT NULL,
    canal_id INT NOT NULL,
    CONSTRAINT fk_canal_id FOREIGN KEY (canal_id) REFERENCES canal(id)
);




INSERT INTO canal(name) VALUES ('général'), ('m2i'), ('infotel');

INSERT INTO message(idCanal, username, content) VALUES (1, 'toto', 'coucou m2i'), (2, 'titi', 'coucou m2i'), (3, 'tata', 'coucou m2i'), (2, 'm2i', 'coucou titi'), (3, 'm2i', 'coucou tata');


/*1. Rechercher tous les utilisateurs du canal général*/
SELECT DISTINCT message.username
FROM message, canal
WHERE message.idCanal = canal.id
AND canal.name = 'général';

/*2. Rechercher tous les messages du canal général trié par date de création*/
SELECT DISTINCT message.content
FROM message, canal
WHERE message.idCanal = canal.id
AND canal.name = 'général'
ORDER BY message.message_date;

/*3. Rechercher tous les messages d'un utilisateur*/
SELECT message.content
FROM message
WHERE message.username = 'toto'

/*4. Rechercher tous les messages d'un utilisateur sur un canal*/
SELECT message.content
FROM message,canal
WHERE message.username = 'toto'
AND canal.id = message.idCanal
AND canal.name = 'infotel';

/*7. Recherche tous les messages parlant de m2i*/
SELECT *
FROM message
WHERE message.content LIKE '%m2i%'

/*8. Rechercher le nom de tous les utilisateurs ayant parlé de m2i*/
SELECT message.username
FROM message
WHERE message.content LIKE '%m2i%'

/*9. Rechercher le premier canal créait*/
SELECT DISTINCT FIRST_VALUE(canal.name) OVER(ORDER BY canal.id) 
FROM canal

/*10. Rechercher le premier message envoyé*/
SELECT DISTINCT message.message_date, FIRST_VALUE(message.content) OVER(ORDER BY message.message_date) 
FROM message




