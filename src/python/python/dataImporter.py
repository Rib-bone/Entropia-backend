import psycopg2
import json

def main():
    connection = psycopg2.connect(database="entropiaDB", user='entropia', password='example', host="localhost", port=5432, )
    cursor = connection.cursor()
    for x in range(1000):
        print(f'{x}')
        try:
            file = open(f'../../../data/data_{x}.json', 'r')
        except FileNotFoundError:
            continue
        jsonObject = json.load(file)
        print(jsonObject)
        columns = ["name"]
        sql_context =f"""
            INSERT INTO public.mob (id, {', '.join(columns)})
                VALUES (%s, %s)
                ON CONFLICT (id)
                DO UPDATE SET
                  name = EXCLUDED.name;
            """
        data = (x, jsonObject['Name'])
        cursor.execute(sql_context, data)

        file.close()
    connection.commit()
    cursor.close()
    connection.close()

if __name__ == "__main__":
    main()
