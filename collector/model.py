import os

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

con = connection.MySQLConnection(**config)
con.close()
