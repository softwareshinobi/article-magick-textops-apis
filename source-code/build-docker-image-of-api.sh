#!/bin/bash

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

echo "*** "
echo "*** Docker Image Build START: textformatdashboard.online/text-format-dashboard-api-java"
echo "*** "

docker build -t textformatdashboard.online/text-format-dashboard-api-java .

## 

reset

clear

##

echo "*** "
echo "*** Docker Image Build COMPLETE: textformatdashboard.online/text-format-dashboard-api-java"
echo "*** "
