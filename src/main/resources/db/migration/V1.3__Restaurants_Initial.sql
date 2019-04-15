CREATE SEQUENCE restaurants_id_seq;
create table Restaurants (
    id bigint not null DEFAULT NEXTVAL('restaurants_id_seq'),
    primary key (id)
);
ALTER SEQUENCE restaurants_id_seq OWNED BY Restaurants.id;

CREATE SEQUENCE couriers_id_seq;
create table Couriers (
    id bigint not null DEFAULT NEXTVAL('couriers_id_seq'),
    primary key (id)
);
ALTER SEQUENCE couriers_id_seq OWNED BY Couriers.id;
