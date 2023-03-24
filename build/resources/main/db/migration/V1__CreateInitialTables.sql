CREATE TABLE users
(
    id   int     NOT NULL AUTO_INCREMENT,
    name varchar(50),
    surname varchar(50),
    email varchar(50),
    password varchar(100),
    role varchar(50),
    PRIMARY KEY (id),
    UNIQUE (email)
);

CREATE TABLE events
(
    id         int NOT NULL AUTO_INCREMENT,
    name       varchar(50),
    description  varchar(200),
    location       varchar(50),
    date       varchar(50),
    organizer_id int,
    PRIMARY KEY (id),
    UNIQUE (name),
    FOREIGN KEY (organizer_id) REFERENCES users (id)
);