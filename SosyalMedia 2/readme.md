# Notlar

## Docker Image larını eklemek

    PostgreSQL
    userName: postgres
    password: root
    DB: AuthDB
```bash
docker run -d --name postgresql -p 5432:5432 muhammedali55/postgresql:v.0.1
```
    MongoDB
    userName: admin
    password: root
    DB: UserProfileDB
```bash
docker run -d --name mongodb -p 27017:27017 muhammedali55/mongodb:v.0.3
```

    mongod: 
    db.createUser({user: "muhammet",pwd: "root",roles: ["readWrite","dbAdmin"]}) 

## Docker üzerinde Redis Single Node oluşturmak

```bash
    docker run --name microservice-redis -p 6379:6379 -d redis
```

```bash
    docker run  --name redis-gui -d -p 8001:8001 redislabs/redisinsight:1.14.0
```

## Redis Spring Boot Configuration
    İlgili bağımlılık eklenir.

    implementation 'org.springframework.boot:spring-boot-starter-data-redis:3.2.2'

    DİKKAT!!!!
    Redis repository olarak kullanılabileceği gibi, Cache olarakta kullanılabilir, Bu nedenle Spring te Cache i 
    ve Redis Repostory aktif etmek için gerekli annotasyonları config e eklemeniz uygun olacaktır.

```java
@Configuration
@EnableRedisRepositories
@EnableCaching
public class RedisConfig {

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {

        return new LettuceConnectionFactory(new RedisStandaloneConfiguration("localhost", 6379));
    }

}
```

## Dockerfile ile image oluşturmak
    DİKKAT!!!!!
    1- lokalinizde çalıştırılacak imajlar için kullanım
````bash
docker build -t configserver:v01 .
````
    2- docker hub üzerinde yayınlanacak ise
````bash
docker build -t muhammedali55/configserver:v01 .
````
    3- Eğer M chip bir macOS var ise 
````bash
docker build --platform linux/amd64 -t muhammedali55/egitimconfigserver:v01 .


docker build --platform linux/amd64 -t muhammedali55/egitimauth:v02 .


docker build --platform linux/amd64 -t muhammedali55/egitimuser:v02 .

````
