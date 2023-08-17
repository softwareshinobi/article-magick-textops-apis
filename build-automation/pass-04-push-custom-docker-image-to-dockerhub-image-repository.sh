set ex;

reset;

clear;

docker tag software-shinobi-resume softwareshinobi/software-shinobi-resume:latest

docker push softwareshinobi/software-shinobi-resume
docker push softwareshinobi/software-shinobi-resume:latest
