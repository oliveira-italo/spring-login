# spring-login
Spring API demo project that stores and authenticates users of some system.

docker kafka: 
https://hub.docker.com/r/bashj79/kafka-kraft

docker pull bashj79/kafka-kraft

docker run --name kafka -p 9092:9092 -d bashj79/kafka-kraf


list topics:

docker exec -it kafka /bin/bash

sh kafka-topics.sh --bootstrap-server localhost:9092 --list