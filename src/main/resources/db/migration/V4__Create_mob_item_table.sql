
CREATE TABLE mob_item (

    mob_id INT references mob(id),
    item_id INT references item(id),
    frequency VARCHAR,
    CONSTRAINT primary_key PRIMARY KEY (mob_id, item_id)

);