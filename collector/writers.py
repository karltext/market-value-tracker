import os
import csv

from mysql.connector import connection
from dotenv import load_dotenv
load_dotenv()

class DBWriter(object):

    config = {
        'host': os.getenv('DB_HOST'),
        'user': os.getenv('DB_USER'),
        'password': os.getenv('DB_PASS'),
        'database': os.getenv('DB_NAME'),
        'raise_on_warnings': True
    }

    add_role = ("INSERT INTO `market_tracker`.`vt_role` ("
        "`skill`, `role_rank`, `rank_change`, `median_salary`, " 
        "`median_change`, `historical_ads`, `ad_percentage`, "
        "`live_vacancies`) "
        "VALUES (%s, %s, %s, %s, %s, %s, %s, %s)")

    def __init__(self, path):
        pass

    def __enter__(self): 
        self.cnx = connection.MySQLConnection(**self.config)
        self.cur = self.cnx.cursor()
        return self

    def __exit__(self, type, value, traceback):
        self.cnx.commit()
        self.cur.close()
        self.cnx.close()

    def writerow(self, row):
        self.cur.execute(self.add_role, row)


class CSVWriter(object):

    def __init__(self, path):
        self.path = path

    def __enter__(self): 
        self.fp = open(self.path, 'w+', newline='')
        return csv.writer(self.fp)

    def __exit__(self, type, value, traceback):
        self.fp.close()