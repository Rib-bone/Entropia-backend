
CREATE TYPE mob_type AS ENUM ('ROBOT', 'ANIMAL', 'MUTANT');

CREATE TABLE mob (

    id INT PRIMARY KEY NOT NULL,
    name VARCHAR NOT NULL,
    type mob_type

);