import requests
from bs4 import BeautifulSoup

# https://www.itjobswatch.co.uk/default.aspx?page=1
# http://docs.python-requests.org/en/master/
# https://www.crummy.com/software/BeautifulSoup/bs4/doc/

def main():
    for n in range(324):
        parse_page(n)
            
def parse_page(pagenum):
    # data = load_testdata('testdata/sample.html')
    data = getpage(pagenum)
    soup = BeautifulSoup(data, 'html.parser')
    parse_table(soup)

def parse_table(soup):
    rows = []
    for tab in soup.find_all('table', {"class": "results"}):
        for row in tab.find_all('tr'):
            row = parse_row(row)
            if row:
                print(join_csv(row))

def join_csv(row):
    return ','.join(repr(c) for c in row)

def parse_row(row):
    columns = []
    for col in row.find_all('td'):
        txt = col.get_text()
        if not txt or txt.isspace():
            continue
        columns.append(txt)
    return columns

def load_testdata(filepath):
    with open(filepath, 'r', encoding='utf-8') as fp:
        return fp.read()

def getpage(pagenum):
    'fetch the entire html from the given webpage'
    params = {'page': pagenum}
    r = requests.get(url, params=params)
    return r.text

url = 'https://www.itjobswatch.co.uk/default.aspx'

if __name__ == '__main__':
    main()