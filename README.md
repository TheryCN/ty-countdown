# Countdown

1. Compile

mvn clean install

2. How to launch at startup on linux

Copy src/main/resources/countdown.service to /lib/systemd/system

sudo systemctl daemon-reload
sudo systemctl enable countdown.service
sudo reboot