import os
import csv

from mysql.connector import connection
from dotenv import load_dotenv
load_dotenv()

config = {
    'host': os.getenv('DB_HOST'),
    'user': os.getenv('DB_USER'),
    'password': os.getenv('DB_PASS'),
    'database': os.getenv('DB_NAME'),
    'raise_on_warnings': True
}

add_role = ("INSERT INTO `market_tracker`.`roles` "
            "(`skill`, `rank`, `rank_change`, `median_salary`, " 
            "`median_change`, `historical_ads`, `ad_percentage`, `live_vacancies`) "
            "VALUES (%s, %s, %s, %s, %s, %s, %s, %s)")

cnx = connection.MySQLConnection(**config)
cur = cnx.cursor()

with open('data.csv', newline='') as fp:
    reader = csv.reader(fp)
    for row in reader:
        print(row)
        cur.execute(add_role, row)
cnx.commit()

cur.close()
cnx.close()
