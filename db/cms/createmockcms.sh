#!/bin/bash

DATABASE=$1
USER=$2
PASSWORD=$3
mysql -u${USER} -p${PASSWORD} -f -e "DROP DATABASE IF EXISTS ${DATABASE};"
mysqladmin -u${USER} -p${PASSWORD} create ${DATABASE};
mysql --local-infile -u${USER} -p${PASSWORD} ${DATABASE} -e "CREATE TABLE epn_name_of (epn_name_id INTEGER, drg_desc_id INTEGER, epn_nm VARCHAR(80), epn_nm_length INTEGER, override_flag VARCHAR(1)); LOAD DATA LOCAL INFILE 'epn_name_of.csv' INTO TABLE epn_name_of FIELDS TERMINATED BY ',' ENCLOSED BY '\"' LINES TERMINATED BY '\n' IGNORE 1 LINES;"
mysql --local-infile -u${USER} -p${PASSWORD} ${DATABASE} -e "CREATE TABLE item_of (ndc BIGINT, prod_id INTEGER, ina_dt VARCHAR(40), rin_dt VARCHAR(40)); LOAD DATA LOCAL INFILE 'item_of.csv' INTO TABLE item_of FIELDS TERMINATED BY ',' ENCLOSED BY '\"' LINES TERMINATED BY '\n' IGNORE 1 LINES;"
mysql --local-infile -u${USER} -p${PASSWORD} ${DATABASE} -e "CREATE TABLE prod_of (prod_id INTEGER, prod_nm_30 VARCHAR(55), drg_desc_id INTEGER); LOAD DATA LOCAL INFILE 'prod_of.csv' INTO TABLE prod_of FIELDS TERMINATED BY ',' ENCLOSED BY '\"' LINES TERMINATED BY '\n' IGNORE 1 LINES;"


#mysql --local-infile -u'root' -p'rootpass' wkh_mock_cms
#CREATE TABLE epn_name_of (epn_name_id INTEGER, drg_desc_id INTEGER, epn_nm VARCHAR(80), epn_nm_length INTEGER, override_flag VARCHAR(1));
#LOAD DATA LOCAL INFILE 'epn_name_of.csv' INTO TABLE epn_name_of FIELDS TERMINATED BY ',' ENCLOSED BY '"' LINES TERMINATED BY '\n' IGNORE 1 LINES;

#CREATE TABLE item_of (ndc BIGINT, prod_id INTEGER, ina_dt VARCHAR(40), rin_dt VARCHAR(40));
#LOAD DATA LOCAL INFILE 'item_of.csv' INTO TABLE item_of FIELDS TERMINATED BY ',' ENCLOSED BY '"' LINES TERMINATED BY '\n' IGNORE 1 LINES;

#CREATE TABLE prod_of (prod_id INTEGER, prod_nm_30 VARCHAR(55), drg_desc_id INTEGER);
#LOAD DATA LOCAL INFILE 'prod_of.csv' INTO TABLE prod_of FIELDS TERMINATED BY ',' ENCLOSED BY '"' LINES TERMINATED BY '\n' IGNORE 1 LINES;
