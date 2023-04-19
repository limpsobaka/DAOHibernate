--liquibase formatted sql

--changeset smirnov:1
insert into "person" (age, "name", surname, city_of_living, phone_number)
values (18, 'Maksim', 'Fedorov', 'Moscow', 9012365498),
       (25, 'Aleksey', 'Ezhov', 'Moscow', 9059632145),
       (30, 'Fedor', 'Arbuzov', 'Yaroslavl', 9023654789)
--rollback ;