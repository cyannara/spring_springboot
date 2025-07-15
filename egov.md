## [eGovFrame](https://www.egovframe.go.kr/home/main.do)

### 설치
1. 다운로드 -> 개발환경 -> 4.x 다운로드 > 개발자용 개발환경 for Windows 64bit (Implementation Tool) Version 4.3.0 첨부파일 다운받기  
2. eGovFrameDev-4.3.0-64bit.zip 파일 C:\ 에 하위폴더 생성 체크해서 압축해제하기  

```
c:\
  ┗━ eGovFrameDev-4.3.0-64bit
                           ┗━ eclipse
                           ┗━ workspace-egov

```


### 공통컴포넌트 패키지 정의서

[공통컴포넌트 클래스 구조](https://www.egovframe.go.kr/home/qainfo/qainfoRead.do?qaId=QA_00000000000024397)
[패키지 정의서](https://www.egovframe.go.kr/home/ntt/nttRead.do?menuNo=75&bbsId=3&nttId=561)


IS_AUTHENTICATED_REMEMBERED > IS_AUTHENTICATED_ANONYMOUSLY
ROLE_USER > IS_AUTHENTICATED_FULLY
IS_AUTHENTICATED_FULLY > IS_AUTHENTICATED_REMEMBERED
IS_AUTHENTICATED_ANONYMOUSLY > ROLE_ANONYMOUS
ROLE_ADMIN > ROLE_USER


###  패키지 구분 
 .rte : runtime  
- psl : Persistence Layer  
- fdl : Foundation Layer  
- ptl : Presentation Layer  

###  war 파일로 도커이미지로 만들기
```
FROM tomcat:9.0-jdk21
RUN rm -rf /usr/local/tomcat/webapps/*
ARG WAR_FILE=target/*.war
COPY ${WAR_FILE} /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
CMD ["catalina.sh", "run"]
```
WAR 이름이 ROOT.war이면 Tomcat에서 기본 경로(/)로 자동 배포됨. 

```
# 1. WAR 빌드
mvn clean install -DskipTests

# 2. Docker 🐳 이미지 빌드
docker build -t spring-legacy-app .

# 3. 🧹기존 컨테이너 종료 및 삭제
docker stop spring-app 2>/dev/null
docker rm spring-app 2>/dev/null

# 4. 새 컨테이너 실행
docker run -d -p 80:8080 -v/home/ec2-user/tomcat/logs:/usr/local/tomcat.logs -v/upload:/upload --name spring-app 도커계정/spring-app 
```

```
name: Spring Legacy CI/CD

on:
  push:
    branches: [ "main" ]

jobs:
  build-and-deploy:
    runs-on: ubuntu-latest

    steps:
      - name: ✅ Checkout
        uses: actions/checkout@v3

      - name: ☕️ Setup JDK
        uses: actions/setup-java@v3
        with:
          java-version: '21'
          distribution: 'adopt'

      - name: 🔨 Build WAR with Maven
        run: mvn clean install -DskipTests

      - name: 🐳 Build Docker Image
        run: docker build -t spring-legacy-app .

      - name: 🚀 Deploy (optionally SSH to server)
        run: echo "여기에 SSH 배포 코드 추가 가능"
```