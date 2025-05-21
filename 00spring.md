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

mvn archetype:generate -DgroupId=com.yedam.app -DartifactId=demo1 -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.5 -DinteractiveMode=false

### maven

| 명령어   | 설명                          |
| :------- | :---------------------------- |
| clean    | target 폴더 삭제              |
| validate | 프로젝트 구조/설정 확인       |
| compile  | 자바 코드 컴파일(target 폴더) |
| test     | 단위 테스트 수행              |
| package  | .jar .war 등 패키징           |
| verify   | 패키지 검증                   |
| install  | 로컬 저장소에 설치(.m2)       |
| deploy   | 원격저장소에 업로드           |

validate → compile → test → package → verify → install → deploy

```
> tree /f target
> nvm clean package
> npm install
```
