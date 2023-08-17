#!/bin/bash

##

set -e;

## 

originalDirectory=`pwd`

##

source pass-01-build-docker-image-from-scratch.sh

cd $originalDirectory

##

source pass-02-run-locally-with-docker-compose.sh

cd $originalDirectory

##
