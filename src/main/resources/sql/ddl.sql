create table topic
(
    topic_id    int primary key auto_increment,
    name        varchar(30),
    description varchar(300)
);

create table test
(
    test_id     int primary key auto_increment,
    name        varchar(30),
    description varchar(300),
    topic_id    int,
    foreign key (topic_id) references topic (topic_id) on update cascade on delete cascade
);

create table question
(
    question_id int primary key auto_increment,
    description varchar(500),
    test_id     int,
    foreign key (test_id) references test (test_id) on update cascade on delete cascade

);

create table answer
(
    answer_id   int primary key auto_increment,
    description varchar(100),
    correct     boolean,
    question_id int,
    foreign key (question_id) references question (question_id) on update cascade on delete cascade
);

create table literature
(
    literature_id int primary key auto_increment,
    description   varchar(300),
    question_id   int,
    foreign key (question_id) references question (question_id) on update cascade on delete cascade
);

create table link
(
    link_id       int primary key auto_increment,
    link          varchar(500),
    literature_id int,
    foreign key (literature_id) references literature (literature_id) on update cascade on delete cascade

);

create table role
(
    role_id int primary key auto_increment,
    name    varchar(30)
);

create table usr
(
    user_id    int primary key auto_increment,
    first_name varchar(50),
    last_name  varchar(50),
    login      varchar(50),
    password   varchar(255)
);

create table usr_role
(
    user_id int,
    role_id int,
    foreign key (user_id) references usr (user_id),
    foreign key (role_id) references role (role_id),
    primary key (user_id, role_id)
);

create table statistics
(
    statistics_id int primary key auto_increment,
    date          date,
    correct       boolean,
    question_id   int,
    user_id       int,
    foreign key (question_id) references question (question_id) on update cascade on delete cascade,
    foreign key (user_id) references usr (user_id) on update cascade on delete cascade
);