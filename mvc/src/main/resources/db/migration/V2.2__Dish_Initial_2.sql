CREATE SEQUENCE dishes_id_seq;
CREATE TABLE Dishes (
    id bigint not null DEFAULT NEXTVAL('dishes_id_seq'),
    genre varchar(123) NOT NULL,
    name varchar(255) NOT NULL,
    price numeric(19, 2) NOT NULL,
    menu_id bigint DEFAULT NULL,
    order_id bigint DEFAULT NULL,
    primary key (id),
    CONSTRAINT fk_menu_dish
      FOREIGN KEY (menu_id)
      REFERENCES Menus (id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
    CONSTRAINT fk_order_dish
      FOREIGN KEY (order_id)
      REFERENCES Orders (id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);