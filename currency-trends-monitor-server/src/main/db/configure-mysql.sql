#Create Databases
CREATE DATABASE currency_trends_monitor_dev;
CREATE DATABASE currency_trends_monitor_prod;

#Create database service accounts
CREATE USER 'ctms_dev_user'@'localhost' IDENTIFIED BY 'changeme';
CREATE USER 'ctms_prod_user'@'localhost' IDENTIFIED BY 'changeme';
CREATE USER 'ctms_dev_user'@'%' IDENTIFIED BY 'changeme';
CREATE USER 'ctms_prod_user'@'%' IDENTIFIED BY 'changeme';

#Database grants
GRANT SELECT ON currency_trends_monitor_dev.* to 'ctms_dev_user'@'localhost';
GRANT INSERT ON currency_trends_monitor_dev.* to 'ctms_dev_user'@'localhost';
GRANT DELETE ON currency_trends_monitor_dev.* to 'ctms_dev_user'@'localhost';
GRANT UPDATE ON currency_trends_monitor_dev.* to 'ctms_dev_user'@'localhost';
GRANT SELECT ON currency_trends_monitor_prod.* to 'ctms_prod_user'@'localhost';
GRANT INSERT ON currency_trends_monitor_prod.* to 'ctms_prod_user'@'localhost';
GRANT DELETE ON currency_trends_monitor_prod.* to 'ctms_prod_user'@'localhost';
GRANT UPDATE ON currency_trends_monitor_prod.* to 'ctms_prod_user'@'localhost';
GRANT SELECT ON currency_trends_monitor_dev.* to 'ctms_dev_user'@'%';
GRANT INSERT ON currency_trends_monitor_dev.* to 'ctms_dev_user'@'%';
GRANT DELETE ON currency_trends_monitor_dev.* to 'ctms_dev_user'@'%';
GRANT UPDATE ON currency_trends_monitor_dev.* to 'ctms_dev_user'@'%';
GRANT SELECT ON currency_trends_monitor_prod.* to 'ctms_prod_user'@'%';
GRANT INSERT ON currency_trends_monitor_prod.* to 'ctms_prod_user'@'%';
GRANT DELETE ON currency_trends_monitor_prod.* to 'ctms_prod_user'@'%';
GRANT UPDATE ON currency_trends_monitor_prod.* to 'ctms_prod_user'@'%';