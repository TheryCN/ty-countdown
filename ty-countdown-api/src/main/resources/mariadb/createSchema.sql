# sudo apt install mariadb-server
# sudo systemctl status mariadb
# sudo mysql -u root
CREATE USER 'pi-countdown' IDENTIFIED BY 'pi-countdown';
CREATE SCHEMA `countdown` ;
GRANT ALL PRIVILEGES ON countdown.* TO 'pi-countdown'@'%' WITH GRANT OPTION;