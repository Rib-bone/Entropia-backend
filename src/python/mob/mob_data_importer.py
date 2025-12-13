import psycopg2
import json
import os

mob_insert_columns = [
    "name",
    "type"
]

maturity_insert_columns = [
    "name",
    "health",
    "attacks_per_minute",
    "regeneration_interval",
    "regeneration_amount",
    "mob_id"
]


def create_mob_insert_clause(columns):
    return f"""
            INSERT INTO public.mob (id, {', '.join(columns)})
                VALUES (%s, %s, %s)
                ON CONFLICT (id)
                DO UPDATE SET
                  {columns[0]} = EXCLUDED.{columns[0]},
                  {columns[1]} = EXCLUDED.{columns[1]};
            """


def create_maturity_insert_clause(columns):
    sql = f"""
            INSERT INTO public.maturity (id, {', '.join(columns)})
                VALUES (%s, %s, %s, %s, %s, %s, %s)
                ON CONFLICT (id)
                DO UPDATE SET
            """
    for i, column in enumerate(columns):
        sql = sql + f"{column} = EXCLUDED.{column}"
        if len(columns) - 1 != i:
            sql = sql + ","
        if len(columns) - 1 == i:
            sql = sql + ";"
    return sql


def create_mob_insert_data_with_uppercase_type(mob_id, json_object):
    return (
        mob_id,
        json_object['Name'],
        json_object['Type'].upper()
    )


def create_mob_insert_data(mob_id, json_object):
    return (
        mob_id,
        json_object['Name'],
        json_object['Type']
    )


def create_maturity_insert_data(mob_id, maturity):
    return (
        maturity["Id"],
        maturity["Name"],
        maturity["Properties"]["Health"],
        maturity["Properties"]["AttacksPerMinute"],
        maturity["Properties"]["RegenerationInterval"],
        maturity["Properties"]["RegenerationAmount"],
        mob_id
    )


def main():
    connection = psycopg2.connect(database="entropiaDB", user='entropia', password=os.environ['DB_PASSWORD'],
                                  host="localhost", port=5432, )
    cursor = connection.cursor()
    for mob_id in range(1, 1000):
        print(f'{mob_id}')
        try:
            file = open(f'../../data/mob/mob_{mob_id}.json', 'r')
        except FileNotFoundError:
            print(f'File not found: data/mob/mob_{mob_id}.json')
            continue
        json_object = json.load(file)
        print(json_object)

        insert_mob(cursor, json_object, mob_id)

        for maturity in json_object['Maturities']:
            insert_maturity(cursor, maturity, mob_id)

        insert_loots(cursor, json_object['Loots'], mob_id)

        file.close()
    connection.commit()
    cursor.close()
    connection.close()


def insert_maturity(cursor, maturity, mob_id: int):
    sql_context = create_maturity_insert_clause(maturity_insert_columns)
    data = create_maturity_insert_data(mob_id, maturity)
    cursor.execute(sql_context, data)


def insert_mob(cursor, json_object, mob_id: int):
    sql_context = create_mob_insert_clause(mob_insert_columns)
    if json_object['Type'] is not None:
        data = create_mob_insert_data_with_uppercase_type(mob_id, json_object)
    else:
        data = create_mob_insert_data(mob_id, json_object)
    cursor.execute(sql_context, data)


def insert_loots(cursor, loots, mob_id):
    for loot in loots:
        if loot["IsDropping"]:
            mob_maturity = loot["Maturity"]["Name"]
            print(mob_maturity)

            item_name = (
                loot["Item"]["Name"],
            )
            print(item_name)
            sql = f"""SELECT id FROM item WHERE name LIKE %s"""
            cursor.execute(sql, item_name)
            item_id = cursor.fetchall()
            if len(item_id) == 0:
                print(f"WARN - Missing item: {item_name}")
                continue
            if len(item_id) > 1:
                print(f"WARN - Multiple items found for: {item_name}")
                continue

            frequency = loot["Frequency"]

            sql = f"""INSERT INTO mob_item VALUES (%s, %s, %s)
                        ON CONFLICT (mob_id, item_id)
                        DO UPDATE SET
                            frequency = EXCLUDED.frequency
                    """

            mob_and_item_data = (
                mob_id,
                item_id[0],
                frequency
            )
            cursor.execute(sql, mob_and_item_data)


if __name__ == "__main__":
    main()
