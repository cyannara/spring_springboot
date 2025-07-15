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