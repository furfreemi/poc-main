CREATE TABLE build1 (
   id SERIAL PRIMARY KEY,
   message CHARACTER VARYING(255) NOT NULL
 );

INSERT INTO build1 VALUES (1, 'build message1');
INSERT INTO build1 VALUES (2, 'build message2');
INSERT INTO build1 VALUES (3, 'build message3');


CREATE TABLE build2 (
   id SERIAL PRIMARY KEY,
   message CHARACTER VARYING(255) NOT NULL,
   val INTEGER
 );

INSERT INTO build2 VALUES (1, 'build message1', 5);
INSERT INTO build2 VALUES (2, 'build message2', 6);
INSERT INTO build2 VALUES (3, 'build message3', 7);