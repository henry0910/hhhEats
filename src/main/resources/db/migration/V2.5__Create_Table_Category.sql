CREATE SEQUENCE categories_id_seq;
create table Categories (
    id bigint not null DEFAULT NEXTVAL('categories_id_seq'),
    primary key (id),
    name varchar(255) NOT null

);
ALTER SEQUENCE categories_id_seq OWNED BY Categories.id;
