
CREATE TABLE maturity (

    id INT PRIMARY KEY NOT NULL,
    name VARCHAR NOT NULL,
    health INT,
    attacks_per_minute INT,
    regeneration_interval INT,
    regeneration_amount INT,

    mob_id INT references mob(id)
);