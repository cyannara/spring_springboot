### 공통컴포넌트 패키지 정의서

https://www.egovframe.go.kr/home/qainfo/qainfoRead.do?qaId=QA_00000000000024397  


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