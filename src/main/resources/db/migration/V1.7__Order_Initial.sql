CREATE SEQUENCE orders_id_seq;
CREATE TABLE Orders (
    id bigint not null DEFAULT NEXTVAL('orders_id_seq'),
    amount bigint not NULL,
    user_id bigint DEFAULT NULL,
    courier_id bigint DEFAULT NULL,
    primary key (id),
    CONSTRAINT fk_user_order
      FOREIGN KEY (user_id)
      REFERENCES Users (id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
    CONSTRAINT fk_courier_order
      FOREIGN KEY (courier_id)
      REFERENCES Couriers (id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);