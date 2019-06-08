Alter Table restaurants add column category_id bigint;
Alter table restaurants ADD CONSTRAINT fk_restaurant_category
      FOREIGN KEY (category_id)
      REFERENCES Categories (id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;