CREATE SEQUENCE authorities_id_seq;
create table Authorities (
    id bigint not null DEFAULT NEXTVAL('authorities_id_seq'),
    name varchar(255) not null,
    user_id bigint DEFAULT null,
    primary key (id),
    CONSTRAINT fk_user_authority
      FOREIGN KEY (user_id)
      REFERENCES Users (id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);
ALTER SEQUENCE authorities_id_seq OWNED BY Authorities.id;