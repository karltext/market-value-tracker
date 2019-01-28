## Instructions

### Install requirements
Install virtualenv, initialize a new virtual environment and activate it in the current shell session (more info on virtualenv https://virtualenv.pypa.io/en/latest/). 

On windows you may have to install virtualenv in administrator mode and update pip (more info on pip https://www.w3schools.com/python/python_pip.asp).
```
$ pip install virtualenv
$ virtualenv env
$ env\Scripts\activate
```

Install requirements.
```
$ pip install -r collector/requirements.txt
```

### Data Collection
Collect the data from the website and save to a csv file.
```
$ python collector/scraper.py --out=data/data.csv
```

### Initialise database
Run the mysql script in `model/schema.sql` to initialise the database -- you can just copy and paste the queries into the mysql command prompt.

Create a `.env` file in the `collector` directory with your database credentials stored in the format described in the `.env.example` file (more info about dotenv files: https://github.com/theskumar/python-dotenv). 

### Insert Data into Database

Insert the data in the mysql database by running.
```
$ python collector/model.py
```

Voila! you should be sorted for the day.



