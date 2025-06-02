function read(){
  fetch('http://localhost:8081/board/21/replies?page=1')
  .then((response) => response.json())
  .then((json) => console.log(json));
}

function register(){
  fetch('http://localhost:8081/board/21/replies', {
    method: 'POST',
    body: JSON.stringify({
      title: 'foo',
      body: 'bar',
      userId: 1,
    }),
    headers: {
      'Content-type': 'application/json; charset=UTF-8',
    },
  })
    .then((response) => response.json())
    .then((json) => console.log(json));
}

function register2(){
  fetch('http://localhost:8081/board/21/replies?page=1', {
    method: 'POST',
    body: "reply=xxxx&replyer=yyyyy",
    headers: {
       'Content-Type': 'application/x-www-form-urlencoded',
    },
  })
    .then((response) => response.json())
    .then((json) => console.log(json));
}
register2();