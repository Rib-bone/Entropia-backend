CREATE TABLE mob_damage_type
(
    mob_id         INT REFERENCES mob (id),
    maturity_id    INT REFERENCES maturity (id),
    damage_type_id INT REFERENCES damage_type (id),
    damage_amount  INT,
    CONSTRAINT mob_damage_type_primary_key PRIMARY KEY (mob_id, maturity_id, damage_type_id)
);