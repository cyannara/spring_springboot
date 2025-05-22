### 강의

| 일  | 수업          | 수업폴더             | 실습폴더      | 패키지                |
| :-- | :------------ | :------------------- | :------------ | :-------------------- |
| 1   | maven, gradle | sp01mvn , sp02gradle |               | com.yedam.app.demo    |
| 2   | DI            | sp02di               | work01di      | com.yedam.app.di      |
| 3   | AOP           | sp03aop              | work02aop     | com.yedam.app.aop     |
| 4   | MyBatis       | sp04mybatis          |               | com.yedam.app.mybatis |
| 5   | JPA           | sp05jpa              |               | com.yedam.app.jpa     |
| 6   | MVC           | sp06mvc              |               | com.yedam.app.mvc     |
| 7   | 실습-게시판   | sp07boad             |               |                       |
| 8   | REST API      | sp08rest             |               |                       |
| 9   | 실습-댓글     | sp09reply            |               |                       |
| 10  | 개인프로젝트  |                      | work10project |                       |
| 11  | springboot    | boot11               |               |                       |
| 12  | ThymeLeaf     |                      |               |                       |
| 13  | security      | boot13securiy        |               |                       |
| 14  | 개인프로젝트  |                      | work14project |                       |
| 15  | eGovFrame     | egov                 |               |                       |
| 16  | eGovFrame     |                      |               |                       |
| 17  | 시험          | exam01               |               |                       |

### 스프링을 왜 쓰는가?

- Microservices
- Reactive
- Event Driven
- Cloud
- Web Applications
- Serverless
- Batch

### 스프링 웹 애플리케이션 개발

- 스프링 프레임워크
- 스프링 데이터
- Mybatis
- 스프링 시큐리티
- 스프링 배치
- 서버사이트템플릿엔진( Thymeleaf )

### 스프링 프레임워크

- DI
- AOP
- MVC
- JDBC

<img src="./images/springcontext_dependency.png"/>

### 개발환경

- maven
- gradle
- spring : eGovFrame 4.3 (Eclipse 2024-03 (4.31.0) 적용, Lombok 포함)

#### eGovFrame

#### STS

- https://spring.io/tools

spring-tools-for-eclipse-4.30.0.RELEASE-e4.35.0-win32.win32.x86_64.zip

#### Lombok

https://projectlombok.org/setup/maven

```shell
> cd C:\Users\admin\.m2\repository\org\projectlombok\lombok\1.18.38
> java -jar lombok-1.18.38.jar
```

eclipse.ini

```
-javaagent:D:\sts-4.30.0.RELEASE\lombok.jar
```

#### pom.xml

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.yedam</groupId>
	<artifactId>app</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<dependencies>
		<!--
		https://mvnrepository.com/artifact/org.springframework/spring-context -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>6.2.7</version>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<version>1.18.38</version>
			<scope>provided</scope>
		</dependency>
	</dependencies>
	<build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<configuration>
					<annotationProcessorPaths>
						<path>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
							<version>1.18.38</version>
						</path>
					</annotationProcessorPaths>
				</configuration>
			</plugin>
		</plugins>
		<resources>
			<resource>
				<directory>src/main/java</directory>
				<includes>
					<include>**/*.xml</include>
				</includes>
			</resource>
		</resources>
	</build>
</project>
```

```xml
<build>
    <pluginManagement><!-- lock down plugins versions to avoid using Maven defaults (may be moved to parent pom) -->
      <plugins>
        <!-- clean lifecycle, see https://maven.apache.org/ref/current/maven-core/lifecycles.html#clean_Lifecycle -->
        <plugin>
          <artifactId>maven-clean-plugin</artifactId>
          <version>3.1.0</version>
        </plugin>
        <!-- default lifecycle, jar packaging: see https://maven.apache.org/ref/current/maven-core/default-bindings.html#Plugin_bindings_for_jar_packaging -->
        <plugin>
          <artifactId>maven-resources-plugin</artifactId>
          <version>3.0.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-compiler-plugin</artifactId>
          <version>3.8.0</version>
        </plugin>
        <plugin>
          <artifactId>maven-surefire-plugin</artifactId>
          <version>2.22.1</version>
        </plugin>
        <plugin>
          <artifactId>maven-jar-plugin</artifactId>
          <version>3.0.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-install-plugin</artifactId>
          <version>2.5.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-deploy-plugin</artifactId>
          <version>2.8.2</version>
        </plugin>
        <!-- site lifecycle, see https://maven.apache.org/ref/current/maven-core/lifecycles.html#site_Lifecycle -->
        <plugin>
          <artifactId>maven-site-plugin</artifactId>
          <version>3.7.1</version>
        </plugin>
        <plugin>
          <artifactId>maven-project-info-reports-plugin</artifactId>
          <version>3.0.0</version>
        </plugin>
      </plugins>
    </pluginManagement>
  </build>
```
