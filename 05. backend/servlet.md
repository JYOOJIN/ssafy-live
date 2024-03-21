## BackEnd

- Dynamic Web Application
- Java 기반
- 구성 요소
  (1) WAS(Web Application Server)
  (2) Web Container: 웹 자바 실행환경(Java class, Servlet, JSP)\
  (3) Tomcat = WAS + Web Container : 무료

## CGI(Common Gateway Interface)

- 동적 웹 어플리케이션 기술
- ASP, PHP, C++ 등
  - 동적 웹, 특정 서버 종속
  - 프로세스 단위: 서버 부하 가중, 응답 시간 느림
- Servlet(JSP)
  - 동적 웹
  - Java 기술: 자바 특징 그대로 사용 가능
  - 플랫폼 독립적: O/S, DataBase, WAS
  - in processing: 먼저 메모리 로딩 수행(Servlet Life Cycle)
  - Multi Thread 단위: 서버 부하 감소

## 웹 어플리케이션 구성 요소

1. static

- html, css, javascript, image, media 등
- jsp = static + dynamic contents

2. 환경 설정

- web.xml: Deployment Descriptior
- xml 문서 구조: DTD, Schema

3. 라이브러리

- 미리 작성해서 제공하는 .class 들의 묶음 => \*.jar

4. Java Class

- Servlet: Java class
- Model: Java class

## Web Server 배포 구조(deploy 구조)

- spec. : 규약(apache-tomcat-10.1.18)을 반드시 준수해야 한다.

## Tomcata 서버 구조(서비스 운여 환경)

- 실제 서비스를 위한 운영 구조
- Tomcat\conf >server.xml (port="8080") -> 서버 충돌나면 바꾼다, web.xml (session-timeout, mime-type)
- .\webappsbom> startup.bat(startup.sh)P: 사버 구동, shutdown.bat(shutdowm.sh) - 서버증기
- .\

- .\work > hello.jsp => hello_jsp.java / hollow_jsp.class(변환 자바 소스콛, class 파일 독차지)

## STS(Element) IDE: 개발 환경 설정

- Target Runtime 설정
- STS\Servers > 관련 설정 copy
- STS\project >  
  \JavaResource > \_.java(servlet 등 Java class)  
  \src\main\webapp > static file(html, jsp, img, js 등)  
  \src\main\webapp\WEB-INF > web.xml  
  \src\main\webapp\WEB-INF\lib > \* .jar(라이브러리)  
  \src\main\webapp\WEB-INF> 부가적인 xml (context.xml - db connection pool 설정)

## Servlet 주요 API

- Servlet 6.0:  
  jakarata.servlet.\*  
  jakarata.servlet.http.\*
- Servlet 4.0:  
  java.servlet._ : 서블릿 관련 공통  
  javax.servlet. http. _ : http 프로토콜에 특화된 서블릿 관련

- API 계층 구조  
   (1) Servlet interface:

  - init(ServletConfig)
  - Service(ServletRequest, ServletResponse)
  - destroy()

  (2) abstract class GenericServlet

  - init(): 추가 중복 정의
  - abstract service(ServletRequest, ServletResponse):

  (3) abstrac class HttpServlet

  - service(ServletRequest, ServletResponse): 재정의
  - service(HttpServletRequest, HttpServletResponse): 추가 중복 정의
  - doPost(HttpServletRequest, HttpServletResponse): POST 요청 처리, 추가 중복 정의
  - doGet(HttpServletRequest, HttpServletResponse): Get 요청 처리, 추가 중복 정의
  - doXxx(HttpServletRequest, HttpServletResponse): 추가 중복 정의

## 웹 transaction

- 요청 ~ 응답
- 요청 객체: ServletRequest -> HttpServletRequest
- 응답객체: ServletResponse -> HttpServletResponse

## 웹 환경설정

- ServletConfig: 특정 서블릿에 대한 환경 설정
- ServletContext: 해당 웹어플리케이션에 대한 환경 설정(해당 어플리케이션에 속해있는 서블릿/jsp들이 공유 가능한 객체)

## 세션 처리를 위한 객체: 로그인~로그아웃(타임아웃)

- Cookie

- HttpSession

## Model2 Architecture 기반의 MVC Pattern

- Model
  - 업무 처리 로직: service, business logic
  - DB 처리 로직: DAO(Data Access Object)
  - Domain: DTO(Data transfer Object)
- View

  - 화면 처리 로직
  - 정적 화면: html/ css/ js/ bootstrap 등등
  - 동적 화면: jsp (정적+동적)

- Controller
  - 요청~응답 제어하는 로직(역할) : Servlet => 로직 외우기!!!  
    (1) 요청 파악  
    (2) 요청 데이터 추출하기  
    (3) 요청 데이터 검증: 필수여부, 길이, pattern-타입 등  
    (4) Model 요청 의뢰(+ 검증데이터): Service => DAO/DTO  
    (5) Model 응답 받아서 응답을 위한 설정: setAttribute(K,V)  
    (6) 응답 페이지 이동

### 요청 데이터 추출하기

- HttpServletRequest  
  (1) getParameter("key"): String -> 단일 입력값  
  (2) getParameterValues("key"): String[] -> 단일/다중 입력값  
  (3) getParameterMap(): Map<String, String[]>  
  (4) getParameterNames(): Enumeration

### 웹 설정 데이터 scope(범위)

(1) 현재 페이지: pageScope  
(2) 요청~응답 : HttpServletRequest(requestScope)  
(3) 로그인~로그아웃(타임아웃) : HttpSession(sessionScope)  
(4) 어플리케이션 구동~어플리케이션종료: servletContext(applicationScope)

### 응답 페이지 이동 방법

(1) forward: 기존 요청, 응답 객체를 가지고 페이지 이동(기존 정보를 이동페이지 사용 가능)  
(2) redirect: 새로운 요청, 응답 객체를 생성해서 페이지 이동(기존 정보는 사용할 수 없음)

## 서블릿 프로그래밍 작성 순서

1. extends HttpServlet
2. 서비스 메서드 재정의
   - service(ServletRequest, ServletResponse)
   - service(HttpServletRequest, HttpServletResponse)
   - doGet(HttpServletRequest, HttpServletResponse)
   - doPost(HttpServletRequest, HttpServletResponse)
3. doGet()/ doPost()  
   (1) 요청 객체에 대한 한글 인코딩 설정
   ```
    request.setCharacterEncoidng("utf-8");
   ```
   (2) 요청 객체로 전달받은 parameter 요청 데이터 가져오기
   ```
    String data=getParameter("key");
    String[] data=getParameterValues("key");
   ```
   (3) Model 업무 처리 요청...  
   (4) 응답 위한 mime-type 및 한글 인코딩 설정 => jsp 배우면 페이지 이동으로 처리
   ```
   response.setContentType("text/html; charset=utf-8");
   ```
   (5) 응답 위한 출력 스트림 생성 => jsp 배우면 페이지 이동으로 처리
   ```
   PrintWriter out = response.getWriter(); => jsp 배우면 페이지 이동으로 처리
   ```
   (6) 출력 스트림을 통해서 동적 html 코드 응답(전송)
   ```
   out.println("<html?><head></head><body>");
   out.println("동적화면...작성");
   out.println("</body></html>");
   out.close();
   ```

## 서블릿 클래스 url 경로 지정 방법

1. 절대경로

   > http://localhost:8080/context-path/경로지정

2. 컨텍스트경로 기준 상대경로

   > /context-path/경로지정

3. 상대경로 경로지정

## 서블릿 요청~응답 흐름 순서

1. 톰캣 서버 구동: tomcat\config> \*.xml
2. tomcat\webapps\context-path\WEB-INF > web.xml  
    tomcat\webapps\board\WEB-INF > web.xml  
   => 서버에 배포(deploy) 한 어플리케이션의 환경 설정 로딩
3. web.xml 로딩  
   => 시작 페이지

   ```
   <welcome-file-list></welcome-file-list>
   ```

   ```
    <servlet>
      <load-on-startup>
    </servlet>
   ```

4. (1) 서블릿 클래스 로딩: static{ } => if(로딩되어있으면 기존 서블릿 변경 되었니?)  
   (2) 서블릿 객체 생성: 생성자 수행  
   (3) init(): 초기화 메서드 수행 - 처음에 수행  
   (4) service(): 서비스 메서드 반복 수행  
   (5) destroy(): 자원해제 - 서비스 변경 또는 중지에 수행

## 글쓰기 요청~응답

1. 글쓰기 링크(화면 이동): board/write.html
2. board/write.html 글쓰기 데이터 입력

   #### `<form id="form-register" method="POST" action="">`

   - 아이디: name="userid"
   - 제목: name="subject"
   - 내용: name="content"
   - 글 작성: `<button id="btn-register">`
     ```
     <script>
        ...
        let form=document.querySelector("#form-register");
        form.setAttribute("action","/board/register"); //servlet 경로가 register
        form.submit();
     </script>
     ```
