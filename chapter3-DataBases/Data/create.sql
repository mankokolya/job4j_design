CREATE DATABASE orders;
GO orders;

CREATE TABLE rules(
    rules_uuid UUID NOT NULL PRIMARY KEY
);
CREATE TABLE role (
    role_uuid UUID NOT NULL PRIMARY KEY
);
CREATE TABLE role_rules(
    role_rules_uuid UUID NOT NULL PRIMARY KEY
);
CREATE TABLE customer (
    user_uuid UUID NOT NULL PRIMARY KEY
);
CREATE TABLE state (
    state_uuid UUID NOT NULL PRIMARY KEY
);
CREATE TABLE comments (
    comments_uuid UUID NOT NULL PRIMARY KEY
);
CREATE TABLE attachment (
    attachment_uuid UUID NOT NULL PRIMARY KEY
);
CREATE TABLE category (
    category_uuid UUID NOT NULL PRIMARY KEY
);
CREATE TABLE item (
    item_uuid UUID NOT NULL PRIMARY KEY
);