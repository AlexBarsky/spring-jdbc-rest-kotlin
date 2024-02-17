CREATE TABLE IF NOT EXISTS cargo (
id       SERIAL CONSTRAINT cargo_pk PRIMARY KEY,
title    VARCHAR(100)      NOT NULL,
passenger_count INTEGER
);