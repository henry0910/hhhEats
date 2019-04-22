DROP TABLE Menus;
CREATE TABLE Menus (
    id bigint not null DEFAULT NEXTVAL('menus_id_seq'),
    genre varchar(123) NOT NULL,
    primary key (id)
);