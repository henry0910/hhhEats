Alter Table orders add column restaurant_id bigint;
Alter table orders ADD CONSTRAINT fk_restaurant_order
      FOREIGN KEY (restaurant_id)
      REFERENCES Restaurants (id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;