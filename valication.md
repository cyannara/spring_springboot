# valication
- [spring validation](https://docs.spring.io/spring-framework/reference/core/validation/validator.html)

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```


## egovframe에 어노테이션 기반 validation

dependency 설정  
```xml
<!-- Bean Validation API -->
<dependency>
    <groupId>javax.validation</groupId>
    <artifactId>validation-api</artifactId>
    <version>2.0.1.Final</version>
</dependency>

<!-- Hibernate Validator: Bean Validation 구현체 -->
<dependency>
    <groupId>org.hibernate.validator</groupId>
    <artifactId>hibernate-validator</artifactId>
    <version>6.2.5.Final</version>
</dependency>
```

egov-com-servlet.xml 에 validation 빈 등록하고 annotation-driven 설정  

```xml
<bean id="validator"
      class="org.springframework.validation.beanvalidation.LocalValidatorFactoryBean" />

<mvc:annotation-driven validator="validator"/>
```

```java
  @NotBlank(message = "이름은 필수입니다.")
	private String nttCn = "";

	@NotBlank
	@Size(min=2, max=30)
	private String nttSj = "";

```

|어노테이션|	설명|
|:-|:-|
|@NotNull|	null 금지 (모든 타입)|
|@NotBlank|	null/빈문자열/공백 금지 (문자열 전용)|
|@NotEmpty|	null/빈문자열 금지|
|@Size(min, max)|	길이 또는 요소 개수 제한|
|@Email|	이메일 형식인지 검사|
|@Min, @Max|	숫자 범위|
|@Pattern	|정규 표현식 검사|
|@Positive, @Negative|	양수/음수 여부|
|@Past, @Future|	날짜 과거/미래 확인|

```html
<form:form modelAttribute="articleVO" >
  <form:input path="nttSj" title="${title} ${inputTxt}" size="70" maxlength="70" />
   <form:input value="${articleVO.nttSj}"  size="70" maxlength="70" />
   <form:errors path="nttSj" cssClass="error" />
</form:form>

```

validator/validator-rules.xml  
message/com/message-c0mmon.properties  
