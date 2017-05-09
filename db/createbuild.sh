#!/bin/bash

DATABASE=$1
USER=$2
PASSWORD=$3
mysql -u${USER} -p${PASSWORD} -f -e "DROP DATABASE IF EXISTS ${DATABASE};"
mysqladmin -u${USER} -p${PASSWORD} create ${DATABASE}
mysql -u${USER} -p${PASSWORD} ${DATABASE} < backup.sql;



