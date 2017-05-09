#!/bin/bash

function createdb() {
  DATABASE=$1
  USER=root
  PASSWORD=rootpass
  mysql -u$USER -p$PASSWORD -f -e "DROP DATABASE IF EXISTS ${DATABASE};"
  mysqladmin -u$USER -p$PASSWORD create $DATABASE
  mysql -u$USER -p$PASSWORD $DATABASE < backup.sql;
}

createdb "wkh_poc"
