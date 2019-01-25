import os

import mysql.connector
from dotenv import load_dotenv
load_dotenv()

dbconfig = {
    'host': os.getenv('DB_HOST'),
    'user': os.getenv('DB_USER'),
    'password': os.getenv('DB_PASS'),
    'database': os.getenv('DB_NAME')
}

con = mysql.connector.connect(dbconfig)

