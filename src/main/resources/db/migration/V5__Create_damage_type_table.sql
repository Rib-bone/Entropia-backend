
CREATE TABLE damage_type (

    id INT PRIMARY KEY NOT NULL,
    stab INT,
    cut INT,
    impact INT,
    penetration INT,
    shrapnel INT,
    burn INT,
    cold INT,
    acid INT,
    electric INT,

    maturity_id INT references maturity(id),
    mob_id INT references mob(id)
);