CREATE EXTENSION postgis;
Alter table users add column location geometry(point, 4326)