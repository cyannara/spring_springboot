## MSA

### RabbitMQ 실습

properites rabitMQ 설정 (mq1)

```
rabbitmq.exchange.name: mqtestexchange
rabbitmq.routing.key: mqtestkey
```

properites rabitMQ 설정 (mq2 )

```
rabbitmq.queue.name=mqtestqueue
```

```
spring.rabbitmq.host=rabbitmq
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest
```

bootapp 이미지 빌드

```shell
docker build -t app/mq1  .    #rabbitmq1 폴더에서 실행
docker build -t app/mq2  .    #rabbitmq2 폴더에서 실행
# ./gradlew bootBuildImage --imageName=app/mq1 --builder paketobuildpacks/builder:base

```

RabbiMQ 사용자 계정 생성

```shell
# rabbimq 컨테이너 터미널
docker exec -it rabbitmq bash
rabbitmqctl add_user myuser 1234
rabbitmqctl set_user_tags myuser administrator
rabbitmqctl set_permissions -p / myuser ".*" ".*" ".*"
```

컨테이너 생성(이미지 실행)

```shell
docker network create msa-net
docker network inspect msa-net

docker run  --name rabbitmq --network msa-net -d -p 5672:5672 -p 15672:15672 -v rabbitmq_data:/var/lib/rabbitmq  rabbitmq:4-management
# -e RABBITMQ_DEFAULT_USER=guest  -e RABBITMQ_DEFAULT_PASS=guest <=  RabbitMQ 컨테이너 시작 시 기본 사용자 생성

docker run --name mq1 --network msa-net -d -p 7077:7077  app/mq1
docker run --name mq2 --network msa-net -d -p 7078:7078  app/mq2
# -e SPRING_RABBITMQ_USERNAME=myuser -e SPRING_RABBITMQ_PASSWORD=1234 <= RabbitMQ에 접속할 때 사용할 계정 정보

docker network inspect msa-net

```

docker-compose/yml

```
version: "3.8"

services:
  rabbitmq:
    image: rabbitmq:4-management
    container_name: rabbitmq
    ports:
      - "5672:5672" # AMQP 포트
      - "15672:15672" # 관리 UI 포트
    environment:
      RABBITMQ_DEFAULT_USER: guest
      RABBITMQ_DEFAULT_PASS: guest
    volumes:
      - rabbitmq_data:/var/lib/rabbitmq
    networks:
      - msa-net

  bootapp1:
    image: app/mq1
    container_name: mp1
    depends_on:
      - rabbitmq
    environment:
      SPRING_RABBITMQ_HOST: rabbitmq
      SPRING_RABBITMQ_PORT: 5672
      SPRING_RABBITMQ_USERNAME: guest
      SPRING_RABBITMQ_PASSWORD: guest
    networks:
      - msa-net
    ports:
      - "7077:7077"

  boootapp2:
    image: app/mq2
    container_name: mq2
    depends_on:
      - rabbitmq
    environment:
      SPRING_RABBITMQ_HOST: rabbitmq
      SPRING_RABBITMQ_PORT: 5672
      SPRING_RABBITMQ_USERNAME: guest
      SPRING_RABBITMQ_PASSWORD: guest
    networks:
      - msa-net
    ports:
      - "7078:7078"

volumes:
  rabbitmq_data:

networks:
  msa-net:
    driver: bridge

```

compose 명령

```
docker compose up -d
docker compose -f "docker-compose.yml" up -d --build
```

```shell
docker exec -it mq1 ping rabbitmq
docker exec -it mq1 env | grep SPRING_RABBITMQ
docker exec -it mq1 curl rabbitmq:5672

#D:\gitwork\spring_springboot\rabbitmq2
-e SPRING_RABBITMQ_HOST=rabbitmq -e SPRING_RABBITMQ_PORT=5672 -e SPRING_RABBITMQ_USERNAME=myuser -e SPRING_RABBITMQ_PASSWORD=1234
```
