insert into topic (name, description)
VALUES ('Java Core', 'There are some tests about JDK, Java Versions, SDK and etc.'),
       ('Data Structures', 'You can check your knowledge about native structures of data here.');

insert into test (name, description, topic_id)
VALUES ('Java Development Kit', 'How good you know JDK, JRE, JVM? Check it out that here.', 1),
       ('Java Core - Parent Class', 'The first things that every java developer must know.', 11);

insert into question (description, test_id)
VALUES ('What is JRE?', 1),
       ('What is JVM?', 1),
       ('Is there java compiler?', 1);

insert into answer (description, correct, question_id)
VALUES ('Java Runnable Entity', false, 1),
       ('Java Runtime Environment', true, 1),
       ('Java Runnable Environment', false, 1),
       ('Java Vendor Macintosh', false, 11),
       ('Java Virtual Model', false, 11),
       ('Java Virtual Machine', true, 11),
       ('In the JDK', true, 21),
       ('In the JRE', false, 21),
       ('In the JVM', false, 21),
       ('Compiler must be installed from a separate package (file)', false, 21);

insert into role (name)
values ('USER'),
       ('ADMIN'),
       ('MENTOR');

insert into usr (first_name, last_name, login, password)
values ('Roman', 'Popov', 'rom', 'pass'),
       ('Evgeniy', 'Kulik', 'evgen', 'pass'),
       ('Andrey', 'Gorevoi', 'andry', 'pass');

insert into usr_role (user_id, role_id)
VALUES (1, 1),
       (11, 11),
       (21, 21);

insert into statistic (date, correct, question_id, user_id)
VALUES ('10.10.2020', true, 1, 1),
       ('10.10.2020', true, 11, 1),
       ('10.10.2020', false, 21, 1),
       ('10.10.2020', true, 1, 11),
       ('10.10.2020', false, 11, 11),
       ('10.10.2020', true, 21, 11),
       ('10.10.2020', false, 1, 21),
       ('10.10.2020', true, 11, 21),
       ('10.10.2020', true, 21, 21);

insert into literature (description, question_id)
VALUES ('The best help you can find to google:)', 1),
       ('Wiki. About JVM.', 11),
       ('Wiki. About JDK.', 21);

insert into link (link, literature_id) VALUES
('https://www.google.com/search?q=What+is+JRE%3F%27&oq=What+is+JRE%3F%27&aqs=chrome..69i57.571j0j4&sourceid=chrome&ie=UTF-8', 1),
('https://en.wikipedia.org/wiki/Java_virtual_machine', 11),
('https://ru.wikipedia.org/wiki/Java_Development_Kit', 21);
