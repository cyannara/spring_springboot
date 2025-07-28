
1. 의존성


```gradle
implementation 'org.springframework.boot:spring-boot-starter-security'
implementation 'io.jsonwebtoken:jjwt-api:0.11.5'
runtimeOnly 'io.jsonwebtoken:jjwt-impl:0.11.5'
runtimeOnly('io.jsonwebtoken:jjwt-jackson:0.11.5') // JSON 직렬화
```
```xml
<!-- Spring Boot Security -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>

<!-- JWT (jjwt) -->
<!-- JWT 토큰 생성, 파싱 등 API -->
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-api</artifactId>
    <version>0.11.5</version>
</dependency>
<!-- 실제 구현체 (runtime 필요) -->
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-impl</artifactId>
    <version>0.11.5</version>
    <scope>runtime</scope>
</dependency>

<!--JWT 파싱 시 JSON 처리용 -->
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-jackson</artifactId> <!-- or jjwt-gson 가능 -->
    <version>0.11.5</version>
    <scope>runtime</scope>
</dependency>
```
2. JwtUtil   : 토큰생성, 유효성 체크
  └ generateToken
  └ extractUsername
  └ validateToken


**"SecurityConfig에서 허용" + "Jwt 필터에서 제외"*