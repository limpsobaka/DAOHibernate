--liquibase formatted sql

--changeset smirnov:1
create table "person"
(
    "name"         varchar(255),
    surname        varchar(255),
    "age"          int,
    phone_number   bigint,
    city_of_living varchar(255),
    primary key ("name", surname, "age")
);
--rollback drop table person