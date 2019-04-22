CREATE SEQUENCE menus_id_seq;
CREATE TABLE Menus (
    id bigint not null DEFAULT NEXTVAL('menus_id_seq'),
    genre varchar(123) NOT NULL
);
