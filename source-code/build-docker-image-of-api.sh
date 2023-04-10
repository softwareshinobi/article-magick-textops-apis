#! /bin/bash

##

set -e

set -x

##

reset

clear

##

docker system prune -a -f

git pull

##

reset

clear

##

docker build -t textformatdashboard.online/text-format-dashboard-api-java .

docker run -p 44444:8888 textformatdashboard.online/text-format-dashboard-api-java

## 

echo "fin"