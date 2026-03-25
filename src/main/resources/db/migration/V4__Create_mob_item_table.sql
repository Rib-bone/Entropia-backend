CREATE TABLE mob_item
(
    mob_id    INT references mob (id),
    item_id   INT references item (id),
    frequency VARCHAR,
    CONSTRAINT mob_item_primary_key PRIMARY KEY (mob_id, item_id)
);