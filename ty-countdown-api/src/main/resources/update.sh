sudo systemctl stop countdown.service
git pull origin master
mvn clean install
sudo systemctl start countdown.service