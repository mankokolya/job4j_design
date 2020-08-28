CREATE DATABASE spammer;
\c spammer;
CREATE TABLE users (
    id bigserial not null primary key,
    name varchar(100),
    email varchar(150) not null
);