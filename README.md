
#### spring 7일차 과제 
1. 로직 구현 연습
   url : https://developer.mozilla.org/ko/docs/Learn_web_development/Core/Scripting/A_first_splash  
   숫자맞추기 게임을 만드는 과정을 사이트대로 따라해보기  
 
2. 과제6.md에서 사원조회 기능 
3. 영화정보 조회
    url : http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=12664b24453335d2c3eca0fdc4b3b013&targetDt=20250531  
    url을 브라우저에서 확인하면 5월31일 박스오피스 순위가 보입니다.  
    아래의 코드를 movie.js로 만들고 node 명령어로 실행해서 결과를 확인합니다.  
    ```javascript
    function movieRankfirst(){
      const url = `http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=12664b24453335d2c3eca0fdc4b3b013&targetDt=20250531`
      fetch(url)
      .then(res=>res.json())
      .then(res=>{
        //1. 순위가 1위인 영화 제목을 출력

      })
    }

    function movieRank(){
      const url = `http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=12664b24453335d2c3eca0fdc4b3b013&targetDt=20250531`
      fetch(url)
      .then(res=>res.json())
      .then(res=>{
        //1. rank 와 영화제목을 모두 출력

      })
    }
    movieRankfirst();
    movieRank();
    ```

    ```javascript
      node movie.js
    ```

### 자바 과제

자바 보강 1일차 실습 - java01.md(작성중)    
자바 보강 1일차 실습문제 - java01work.md(작성중)  