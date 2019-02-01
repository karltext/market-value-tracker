'''
scraper.py : collect tabulated data from site and save to csv file.

usage: scraper.py [-h] [-o OUT] [-n NUM] [-l LOCATION]

optional arguments:
  -h, --help            show this help message and exit
  -o OUT, --out OUT     ouput filepath
  -n NUM, --num NUM     number of pages
  -l LOCATION, --location LOCATION
                        query location
'''
import argparse
import csv

# http://docs.python-requests.org/en/master/
import requests
# https://www.crummy.com/software/BeautifulSoup/bs4/doc/
from bs4 import BeautifulSoup

import writers

URL = 'https://www.itjobswatch.co.uk/default.aspx'

def main():
    args = parse_args()
    with args.writer(args.out) as w:
        for n in range(args.num):
            parse_page(w, n)
            
def parse_page(writer, pagenum):
    data = getpage(pagenum)
    soup = BeautifulSoup(data, 'html.parser')
    for row in parse_table(soup):
        writer.writerow(row)

def parse_table(soup):
    for tab in soup.find_all('table', {"class": "results"}):
        for row in tab.find_all('tr'):
            row = list(parse_row(row))
            if not row:
                continue
            if len(row) < 8:
                row.append(0)
            yield row

def parse_row(row):
    x = 0
    for col in row.find_all('td'):
        raw = col.get_text()
        if not raw or raw.isspace():
            continue
        w = cleanchars(raw)
        x += 1
        if x == 6:
            for wn in w.split(' '):
                yield wn
            continue
        yield w

def load_testdata(filepath):
    with open(filepath, 'r', encoding='utf-8') as fp:
        return fp.read()

def getpage(pagenum):
    'fetch the entire html from the given webpage'
    params = {'page': pagenum}
    r = requests.get(URL, params=params)
    return r.text

def parse_args():
    parser = argparse.ArgumentParser()
    parser.add_argument(
        '-o', '--out', help="ouput filepath", type=str)
    parser.add_argument(
        '-n', '--num', help="number of pages", type=int, default=324)
    parser.add_argument(
        '-l', '--location', help="query location", type=str)
    parser.add_argument(
        '--writer', action='store_const', 
        const=writers.CSVWriter, 
        default=writers.DBWriter,
        help='Write to csv (default: write to database)'
    )
    return parser.parse_args()

def cleanchars(string):
    w = cat(s for s in string if s not in chars)
    return w if w != '-' else 0

cat = ''.join
chars = '+$£%(),\n'

if __name__ == '__main__':
    main()