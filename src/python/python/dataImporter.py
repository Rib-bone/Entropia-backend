import psycopg2
import json
import os


def main():
    connection = psycopg2.connect(database="entropiaDB", user='entropia', password=os.environ['DB_PASSWORD'],
                                  host="localhost", port=5432, )
    cursor = connection.cursor()
    for mob_id in range(1000):
        print(f'{mob_id}')
        try:
            file = open(f'../../../data/data_{mob_id}.json', 'r')
        except FileNotFoundError:
            continue
        jsonObject = json.load(file)
        print(jsonObject)
        columns = ["name", "type"]
        sql_context = f"""
            INSERT INTO public.mob (id, {', '.join(columns)})
                VALUES (%s, %s, %s)
                ON CONFLICT (id)
                DO UPDATE SET
                  {columns[0]} = EXCLUDED.{columns[0]},
                  {columns[1]} = EXCLUDED.{columns[1]};
            """
        if jsonObject['Type'] is not None:
            data = (mob_id, jsonObject['Name'], jsonObject['Type'].upper())
        else:
            data = (mob_id, jsonObject['Name'], jsonObject['Type'])
        cursor.execute(sql_context, data)

        for maturity in jsonObject['Maturities']:
            columns = ["name", "health", "attacks_per_minute", "regeneration_interval", "regeneration_amount", "mob_id"]
            sql_context = f"""
                INSERT INTO public.maturity (id, {', '.join(columns)})
                    VALUES (%s, %s, %s, %s, %s, %s, %s)
                    ON CONFLICT (id)
                    DO UPDATE SET
                      {columns[0]} = EXCLUDED.{columns[0]},
                      {columns[1]} = EXCLUDED.{columns[1]},
                      {columns[2]} = EXCLUDED.{columns[2]},
                      {columns[3]} = EXCLUDED.{columns[3]},
                      {columns[4]} = EXCLUDED.{columns[4]},
                      {columns[5]} = EXCLUDED.{columns[5]};
                """
            data = (maturity["Id"], maturity["Name"], maturity["Properties"]["Health"],
                    maturity["Properties"]["AttacksPerMinute"], maturity["Properties"]["RegenerationInterval"],
                    maturity["Properties"]["RegenerationAmount"], mob_id)
            cursor.execute(sql_context, data)

        file.close()
    connection.commit()
    cursor.close()
    connection.close()


if __name__ == "__main__":
    main()
