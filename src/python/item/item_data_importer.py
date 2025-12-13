import psycopg2
import csv
import os


class Item:
    id: int
    name: str
    type: str
    tt_value: str
    mu: str


item_insert_columns = [
    "name",
    "type",
    "max_tt",
    "markup"
]


def create_item_insert_clause(columns):
    sql = f"""
            INSERT INTO public.item (id, {', '.join(columns)})
                VALUES (%s, %s, %s, %s, %s)
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


def create_item_insert_data(item):
    if item.tt_value == "":
        item.tt_value = None
    if item.mu == "":
        item.mu = None
    return (
        item.id,
        item.name,
        item.type,
        item.tt_value,
        item.mu
    )


def main():
    connection = psycopg2.connect(database="entropiaDB", user='entropia', password=os.environ['DB_PASSWORD'],
                                  host="localhost", port=5432, )
    cursor = connection.cursor()
    item_index = 1

    for x in range(1, 5):
        item_index = read_files(cursor, item_index, f'../../../data/item/ArmorItem.{x}.csv')
    item_index = read_files(cursor, item_index, f'../../../data/item/Attachment.1.csv')
    for x in range(1,3):
        item_index = read_files(cursor, item_index, f'../../../data/item/Clothes.{x}.csv')
    item_index = read_files(cursor, item_index, f'../../../data/item/FirstAidPack.1.csv')
    item_index = read_files(cursor, item_index, f'../../../data/item/Implant.1.csv')
    for x in range(1, 7):
        item_index = read_files(cursor, item_index, f'../../../data/item/Material.{x}.csv')
    item_index = read_files(cursor, item_index, f'../../../data/item/Misc.1.csv')
    item_index = read_files(cursor, item_index, f'../../../data/item/MiscTool.1.csv')
    item_index = read_files(cursor, item_index, f'../../../data/item/Plating.1.csv')
    item_index = read_files(cursor, item_index, f'../../../data/item/Synchronization.1.csv')
    item_index = read_files(cursor, item_index, f'../../../data/item/Teleportation.1.csv')
    for x in range(1, 7):
        item_index = read_files(cursor, item_index, f'../../../data/item/Weapon.{x}.csv')

    print(f"Imported {item_index - 1} items")
    connection.commit()
    cursor.close()
    connection.close()


def read_files(cursor, item_index: int, file_path):
    file = open(file_path, 'r')
    item_index = read_files_items(cursor, file, item_index)
    file.close()
    return item_index


def read_files_items(cursor, file, item_index: int):
    reader = csv.reader(file, delimiter=';', quotechar='|')
    row_index = 0
    for row in reader:
        if row_index == 0:
            #Skipping the Header row of csv
            row_index = row_index + 1
            continue
        cell_index = 0
        item = Item()
        item.id = item_index
        for cell in row:
            map_cell_to_item(cell, cell_index, item)
            cell_index = cell_index + 1
        insert_item(cursor, item)
        item_index = item_index + 1
        row_index = row_index + 1
        print("---------------------------------------")
    return item_index


def map_cell_to_item(cell: str, cell_index: int, item: Item):
    match cell_index:
        case 0:
            item.name = cell.strip()
            print(f"Name: {cell.strip()}")
        case 1:
            item.type = cell.strip()
            print(f"Type: {cell.strip()}")
        case 2:
            item.tt_value = cell.strip()
            print(f"TT: {cell.strip()}")
        case 3:
            item.mu = cell.strip()
            print(f"Markup: {cell.strip()}")
        case _:
            print(f"WARN - unmapped cell: {cell.strip()}")


def insert_item(cursor, item):
    sql_context = create_item_insert_clause(item_insert_columns)
    data = create_item_insert_data(item)
    cursor.execute(sql_context, data)


if __name__ == "__main__":
    main()
