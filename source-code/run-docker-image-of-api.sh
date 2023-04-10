#!/bin/bash

##

set -e

set -x

##

reset

clear

##

echo "*** "
echo "*** Docker Container START: textformatdashboard.online/text-format-dashboard-api-java"
echo "*** "

docker run -p 44444:8888 textformatdashboard.online/text-format-dashboard-api-java

## 

echo "fin"