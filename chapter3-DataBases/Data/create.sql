drop DATABASE IF EXISTS orders;

create DATABASE orders;
\c orders;
CREATE EXTENSION "uuid-ossp";

create table rules(
    rules_uuid uuid default uuid_generate_v4 (),
    rule varchar(200) not null,
    primary key(rules_uuid)
);

create table role (
    role_uuid uuid default uuid_generate_v4 (),
    role varchar(100) not null,
    primary key(role_uuid)
);

create table role_rules(
    role_rules_uuid uuid default uuid_generate_v4 (),
    role_uuid uuid references role(role_uuid),
    rules_uuid uuid references rules(rules_uuid),
    primary key(role_rules_uuid)
);

create table customer (
    customer_uuid uuid default uuid_generate_v4 (),
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    email varchar(200),
    role_uuid uuid references role(role_uuid),
    primary key (customer_uuid)
);

create table state (
    state_uuid uuid default uuid_generate_v4 (),
    condition varchar(100) not null,
    primary key (state_uuid)
);

create table category (
    category_uuid uuid default uuid_generate_v4 (),
    category varchar(100) not null,
    primary key (category_uuid)
);

create table item (
    item_uuid uuid default uuid_generate_v4 (),
    customer_uuid uuid references customer(customer_uuid),
    state_uuid uuid references state(state_uuid),
    category_uuid uuid references category(category_uuid),
    primary key (item_uuid)
);

create table comments (
    comments_uuid uuid default uuid_generate_v4 (),
    comment varchar(200) not null,
    item_uuid uuid references item(item_uuid),
    primary key (comments_uuid)
);

create table attachments (
    attachment_uuid uuid default uuid_generate_v4 (),
    attachment varchar(200),
    item_uuid uuid references item(item_uuid),
    primary  key (attachment_uuid)
);

insert into rules(rule) values ('Implement');
insert into role(role) values ('Ingineer');
insert into customer(first_name, last_name, email) values ('Nick', 'Manko', 'mankokolya@gmail.com');
insert into state(condition) values ('in progress');
insert into category(category) values ('website');
insert into comments(comment) values ('waiting for frontend implementation');
insert into attachments(attachment) values ('https://drive.google.com/file/d/15O8L1bCHwz2h8peODV2dAv4O3Jr3Olji/view?usp=sharing');