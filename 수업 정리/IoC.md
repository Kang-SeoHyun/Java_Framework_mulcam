# IoC

## Inversion of Control

- 역제어 - 폴리 3
    - 객체 생성의 주체가 개발자에서 컨테이너로 넘어가는 것
    - 객체에 대한 모든 관리를 컨테이너가 하는 것
- 순제어 - 폴리 1, 폴리 2
    - 개발자가 자바 소스를 통해서 객체를 조절하는 것
    - 전통적인 자바 개발 형식
    - 문제: 소스를 수정하지 않으면 바뀌지않는다.
    - 유지보수에서 귀찮아짐
    

### 자동 완성을 위해 STS플러그인 설치하기

![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled.png)

- 꼭 선택된 폴더 하위에 어쩌고 체크풀기
- 위치 중요함.

![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%201.png)

- xml파일을 저거 에디터로 열어야 ctrl + space 눌렀을 때 속성값이 자동완성됨.

![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%202.png)

- xml에서 태그는 저렇게 네개만 앎
    - alias : 객체의 별칭을 등록할 때 씀
    - bean : 컨테이너한테 이 객체를 생성해달라고 할 때 씀
    - description : 주석
    - import : 잘 안씀 위에 읽을 때 import에 있는 애도 읽어줘

## bean🥜

<bean id="tv" class="polymorphism3.GoogleTV"></bean>

```jsx
id는 생략가능 but 컨테이너가 객체를 구별하기 위해 만든 아이디임.
	-> 유니크한 값이여야함, 아래처럼 안되어야한다는 소리
	-> <bean id="tv" class="polymorphism3.GoogleTV"></bean>
	-> <bean id="tv" class="polymorphism3.SamsungTV"></bean>

class는 등록된 객체 (해당 객체) id생략하면 "poly어쩌고TV#0" 이거로 생김

name은 id속성을 벗어나는 이름을 쓰고 싶을 때 쓰면 됨
	-> 권장은 안함
```

컨테이너 객체 생성 시점

![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%203.png)

삼성티비 객체가 생성될 때 디폴트 생성자만 생성되니까 멤버변수를 바꾸고 싶을 땐 생성자를 만들어야 함.

![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%204.png)

![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%205.png)

- 별도의 메소드를 xml설정을 통해 컨테이너가 호출할 수 있게 등록하면 사용가능하다.

![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%206.png)

![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%207.png)

- 컨테이너가 종료되면 destroy-method를 실행하여 메모리에서 지움.

![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%208.png)

- lazy-init은 false가 디폴트값임
    - 설정안하면 pre-loading이기 때문에.
    
    ```jsx
    클라이언트가 요청할 때까지 객체 생성 x
    -> lazy loading : 느리지만 메모리는 적게 먹음.
    xml파일 읽자마자 객체 생성 o
    -> pre loading : 빠르지만 메모리를 많이 차지함.
    ```
    

![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%209.png)

- singleton : 요청할 때 생성해둔 객체를 재 사용함.
- prototype : 요청할 때마다 새로운 객체가 생성됨.

![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2010.png)

→ ctrl + shift + / 는 주석

→ ctrl + shift + \ 는 주석 해제

## Dependency🤼‍♂️

### Constructor Injection

디폴트 생성자 대신 인자가 있는 다른 생성자로 객체를 만들고 싶을 때

- bean으로 스피커 하나 만들어주고
    - 생성자 만들라면 alt + shift + s
        
        ![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2011.png)
        
- 이런식으로 생성자가 여러개 있을 때
    
    ![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2012.png)
    
    - constructor-arg로 생성자 인자 넣어줌.
        
        ![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2013.png)
        
- alt + shift + t = 인터페이스 생성
    
    ![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2014.png)
    
    - 실수 정수 값이 들어가는 생성자 만들고 싶으면
        
        ![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2015.png)
        
        ![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2016.png)
        

### setter injection

- alt + shift + s 로 getter 나 setter 생성해주고
    
    ![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2017.png)
    
- 원하는 메서드를 xml파일에서 property에서 설정
    
    ![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2018.png)
    
    ![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2019.png)
    

### Constructor Injection 🥊 setter injection 결론

```
생성자 인젝션은 생성자 오버라이딩을 통해서 알맞는 인자가 오면 객체를 생성하고
세터 인젝션은 간단하게 세터 메소드로 하는 것
 
-> 결과는 똑같으나 세터 인젝션을 많이 씀. 
왜냐❓ 생성자인젝션은 귀찮으니까
```

## list, props🛒

props 쓰는 법

![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2020.png)

![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2021.png)

![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2022.png)

결과

![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2023.png)

## 네임 스페이스 추가➕

컨테이너에게 다른 종류의 작업을 지시할 수 있다는 의미

![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2024.png)

- 태그 많아진 것 확인 가능
    
    ![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2025.png)
    

## Annotation@

Annotation 기반의 IoC를 위한 설정

- polymorphism3 패키지로 시작하는 모든 패키지에서 @Component가 붙은 클래스의 객체를 생성해라.
    
    ![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2026.png)
    

## Type Injection

![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2027.png)

## IoC를 이용한 비즈니스 컴포넌트 개발💎

→ 4개의 자바파일로 이루어져있음.

![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2028.png)

### 4단계를 거침

1. vo가 첫번째 - 클라이언트가 정보 넣어서 컨테이너한테 넘겨줘야함.
    1. vo class 만드는 법
        
        ![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2029.png)
        
    2. 위를 요약하고 싶으면 
        
        ![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2030.png)
        
2. vo 이용해서 DAO - 컨테이너가 생성해야하는 객체
    1. conn이 있다는 건 util을 이용해서 DB연결을 했다는 것.
    2. 연결했으면 연결 끊는 것도 finally에서 해야함.
        
        ![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2031.png)
        
    
3. alt shift 단축키 눌러서 Service 만들고
    1. 인터페이스 생성할때 alt + shift + t
        
        ![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2032.png)
        
4. 마지막 Impl 생성

### @Component - Annotation

![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2033.png)

- @Service
    - 위치: XXXServiceImpl
    - 의미: 비즈니스 로직을 처리하는 Service 객체
- @Repository
    - 위치: XXXDAO
    - 의미: 데이터베이스 연동을 처리하는 DAO 객체
- @Controller
    - 위치: XXXController
    - 의미: 사용자 요청을 제어하는 Controller 객체
    

**왜 클라이언트가 인터페이스를 호출하고 서비스 호출하고 DAO호출하고 할까? 그냥 DAO 해도되는데?**

답: 트렌젝션때문에

```
클라이언트가 우리은행 DAO 메소드를 해서 인출을 해요.
클라이언트가 신한은행 DAO 메소드를 호출해서 입금을 해요.
근데 신한은행에서 실패했어요. 그럼 돈 날아가요. 왜냐면 DAO하면 커밋되니까.

그래서 이체라는 비지니스 메서드(serviceImpl)가 필요한 것이예요.
이체에서 두번의 디비 연동을 할 것이고 잘 되면 커밋 안되면 롤백해야되니까.
성능상의 차이는 없으니까 그냥 트랜젝션 관리를 위해서도 비지니스 메소드관리는 필요합니다.
```

- Impl class 파일 만들 때, Add 눌러서 service interface 파일 추가해주기.

![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2034.png)

**용어정리**

- 조인포인트(Joinpoint)
    - 조인포인트는 클라이언트가 시스템을 사용하면서 호출하는 모든 비즈니스 메소드를 의미한다.
- 포인트컷(Pointcut)
    - 클라이언트가 호출하는 모든 비즈니스 메소드가 조인포인트라면, 포인트컷은 필터링된 조인포인트를 의미한다.
        
        ![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2035.png)
        
    - <aop:pointcut id="allPointcut" expression="execution(* [com.multicampus.biz](http://com.multicampus.biz/)..*Impl.*(..))"/>
    - 리턴 경로 지정
        - 가장 일반적인 반환형 지정은 '*' 캐릭터를 이용하는 것이다.
        
        ![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2036.png)
        
    - 패키지 경로 지정
        
        ![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2037.png)
        
    - 클래스 이름 지정
        
        ![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2038.png)
        
    - 메소드 지정
        
        ![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2039.png)
        
    - 매개변수 지정
        
        ![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2040.png)
        
- 어드바이스
    - before와 after 외에도 after-returning, after-throwing, around를 포함하여
    총 5가지의 동작 시점을 제공한다
        
        ![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2041.png)
        
- 애스팩트(Aspect) or 어드바이저(Advisor)
    - 애스팩트는 포인트컷과 어드바이스의 결합

## AOP 결론✨

![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2042.png)

```
컨테이너야 allPointcut 필터링 된 비지니스 메서드가 실행되기 이전에 aspect인 log 객체가 
가진 printLog 실행해줘.

‼ aspect: 포인트컷과 어드바이스의 연결고리 ‼
```

![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2043.png)

## 어드바이스 동작 시점

before

→ 사전

after

→ 사후

after-returning

→ after과 차이 : returning 속성을 사용할 수 있다.

→ 즉, after은 log출력밖에 못하는데 returning은 비지니스 메서드 리턴값을 받아서 사후처리 할 수 있다.

![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2044.png)

![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2045.png)

after-throwing

→ throwing 이란 예외가 발생했을 때, After-Throwing으로 점프해서 발생한 예외처리를 매개변수로 받아서 분기 시킬 수 있다.

![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2046.png)

![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2047.png)

around

→ 비지니스 메소드를 기준으로 사전 처리와 사후 처리를 모두 하고 싶을 때

![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2048.png)

정리

![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2049.png)

**문법**

- Before, After Returning, After Throwing, After 어드바이스에서는 JoinPoint를 사용해야 하고, 유일하게 Around 어드바이스에서만 ProceedingJoinPoint를 매개변수로 사용해야 한다.
- 이는 Around 어드바이스가 proceed 메소드를 필요로 하기 때문이다.
- JoinPoint와 ProceedingJoinPoint 모두 반드시 첫 번째 매개변수로 선언되어야 한다.

**자바는 느리지만 유지보수가 쉽다. 빠르고 메모리 적게 이용하는 거 쓸라면 C++하셈**

![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2050.png)

![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2051.png)

- 값이 몇개만 필요하다 해도 객체 자체를 가져와서 메모리 낭비를 하며 처리하는 이유는 나중에 계속 필요한 매개변수가 계속 변할 수 있기 때문이다.  - 귀찮아짐.

## Annotation 사용을 위한 XML 설정🎨

- 빈 등록 하지말고 component 하자
    
    ![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2052.png)
    
- 이것도 없앨 수 있음.
    
    ![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2053.png)
    
- 바로 이런 식으로 포인트컷 설정
    
    ![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2054.png)
    
    ![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2055.png)
    
    ![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2056.png)
    
    - 실수주의
        - returning 일 때는 뭔가를 뱉어야 하니까 뭔가 리턴되는 메소드에서 해야되는거 잘 생각하기
        - ex) get인 거
            
            ![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2057.png)
            
    - xml
        
        ![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2058.png)
        
    
- 이거 간략하게 하기
    
    ![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2059.png)
    
    - class 생성 이후
        
        ![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2060.png)
        
    - class 이름 적어주면 끗
        
        ![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2061.png)
        

## JDBC🛍

![Untitled](IoC%20e7b929e3ef3f4ff49ca211a8fc627c05/Untitled%2062.png)

jdbc 메서드만 호출하면 코드가 엄청 줄어든다.