CREATE TYPE damage_type_enum AS ENUM ('STAB', 'CUT', 'IMPACT', 'PENETRATION', 'SHRAPNEL', 'BURN', 'COLD', 'ACID', 'ELECTRIC');

CREATE TABLE damage_type
(
    id          INT PRIMARY KEY NOT NULL,
    damage_type damage_type_enum
);

INSERT INTO damage_type (id, damage_type)
VALUES (1, 'STAB'),
       (2, 'CUT'),
       (3, 'IMPACT'),
       (4, 'PENETRATION'),
       (5, 'SHRAPNEL'),
       (6, 'BURN'),
       (7, 'COLD'),
       (8, 'ACID'),
       (9, 'ELECTRIC');