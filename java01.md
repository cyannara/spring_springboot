### 덧셈 계산 기능 구현하기

1. 절차지향 언어로 짠 프로그램  
```java
public class MainApp1 {

	public static void main(String[] args) {
		System.out.println("====================");
		System.out.println("=======header=======");
		System.out.println("====================");
		
		System.out.println(String.format("%d + %d = %d", 5,3,5+3) );

		System.out.println("====================");
		System.out.println("=======footer=======");
		System.out.println("====================");
	}
}
```

2. 반복되는 코드나 특정 기능을 수행하는 코드 영역을 메서드로 만들기
```java
public class MainApp2 {

	public static void main(String[] args) {
    //코드를 기능별로 분리하여 함수로 만들고 호출하도록 함. 
    //메인 메서드만 보면 되므로 가독성도 뛰어나고 유지보수도 편함
		printHeader();
		add(5,3);
		printFooter();

	}
	
	public static void add(int a, int b) {
		System.out.println(String.format("%d + %d = %d", a,b,a+b) );
	}
	
	public static void printHeader() {
		System.out.println("====================");
		System.out.println("=======header=======");
		System.out.println("====================");
	}
	
	public static void printFooter() {
		System.out.println("====================");
		System.out.println("=======footer=======");
		System.out.println("====================");
	}
}
```

3. 객체지향 언어로 짠 프로그램
코드를 재활용 할 수 있도록 별도의 클래스(Calc)로 만들고 MainApp3 에서 Calc 클래스를 사용합니다.  

```java
public class MainApp3 {

	public static void main(String[] args) {
		int kor=100;
		int eng=100;
		
		Calc calc = new Calc(kor, eng);
		calc.printMsg("header");	
		calc.printMsg("footer");	
		calc.add();
	}

}
```
```java
public class Calc {
	private int kor;
	private int eng;

	public Calc(int kor, int eng) {
		this.kor = kor;
		this.eng = eng;
	}

	public void add() {
		System.out.println(String.format("%d + %d = %d", 
				                         kor,eng,kor+eng) );
	}
	
	public void printMsg(String msg) {
		System.out.println("====================");
		System.out.println("=======header=======");
		System.out.println("====================");
	}
}
```
객체지향은 재사용하고 쉽게 배포할 수 있도록 설계를 해야함.  
절차지향에서는 필요한 코드가 있으면 코드 자체를 복사를 해야해지만 클래스인 경우는 클래스 파일만 배포하면 됨.  

3. 프로그램 개발 단계
   1. 요구사항 분석
   2. 데이터와 함수 추출  (vue의 data와 methods와 같음) 
   3. 클래스 설계 : Calc 클래스 선언
   4. 클래스 사용하기 : MainApp에서 Calc 클래스를 사용
