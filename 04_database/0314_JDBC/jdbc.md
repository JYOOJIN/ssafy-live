## JDBC API

- java.sql.\* : JavaSE

- javax.sql.\* : JavaEE (BackEnd-Servlet/JSP)
- javax.naming.\* : JNDI API JavaEE (BackEnd-Servlet/JSP)

## JDBC 주요 API

1. DriverManager class
2. Connection interface
3. Statement / PreparedStatement / CallableStatement interface
4. ResultSet interface

## JDBC 예외 클래스

1. java.sql.SQLException
2. java.lang.ClassNotFoundException

## JDBC 프로그램 위한 구성요소

1. DB Server : MySQL, Oracle, DB2, ...
2. JDBC API : JavaSE API 포함 (java.sql, javax.sql)
3. JDBC Driver : DB벤더가 구현해서 제공하는 구현물 (\*.jar)

## JDBC 프로그래밍 기본 절차

1. JDBC Driver 로딩 : 버전 자동 로딩 가능(jdbc4.0-jdk1.6 이상)
   Class.forName(driver-name)
2. DB 연결 :
   Connection conn = DriverManager.getConnection(url, user, password);
3. DB 서버와 SQL 수행 위한 통로 개설

   - Statement : 빈통로, 동적 SQL 수행, 보안 이슈, sql 문자열 변환 불편
   - PreparedStatement : 전용 통로, 정적 SQL 수행, setString('컬럼명',data) - 자동으로 'data' 변환
   - CallableStatement : DB 저장된 procedure/function 호출 사용

```
Statement stmt=conn.createStatement(); //통로 생성
stmt.executeUpdate(sql); // sql 실행시에 sql 구문 동적 전달
```

```
// String sql="insert into table-name values ('user01','pass01','홍길동')";
String sql="insert into table-name values (?,?,?)"; //미완성 통로. data 모를 때 ? 넣는다. 이때 '' 사용 X
PreparedStatement pstmt=conn.prepareStatement(sql); //통로 만들 때 sql 넣음
pstmt.setString(index, data); // ?에 매핑되는 값을 설정, index는 1부터 시작
pstmt.setInt(index, data);
pstmt.setXXX(index, data);

pstmt.executeUpdate(); // 전용통로이므로 sql 수행 시에 sql 구문을 지정해서는 안됨!!!

```

4. SQL 통로를 이용해서 SQL 실행 요청

   - CUD : executeUpdate(): int
   - R : executeQuery(): ResultSet
   - 기타 : execute() : boolean

   - ResultSet : select 수행 결과에 대한 객체
     - next() : boolean - 커서 이동
     - getString("columnn-name" | index | lavel-name) : String
     - getInt() : int
     - getXXX() : XXX

5. Java 이용해서 결과처리
6. 자원해제
   - close()
   - Result#close()
   - Statement#close(), PreparedStatement#close()
   - Connection#close()

## JDBC 관련 Pattern Programming

1. DTO(Data Transfer Object) Pattern

   - DB Table mapping
   - BoardDto.java
   - Encapsulation, 직렬화 객체
   -

2. DAO(Data Access Object) Pattern

   - Singleton Pattern 적용 설계
   - DB Access를 위한 기능
   - CRUD, DB
   - Driver 로딩(공통), DB 연결(공통), 통로 개설, 자원 해제(공통)

3. Factory Pattern

   - Singleton Pattern
   - 필요한 기능을 제공받아서 사용
   - Driver 로딩(공통), DB 연결(공통), 자원 해제(공통)

4. Singleton Pattern
   - 단일 instance 제공
   - 설계 규칙  
      (1) private 생성자()  
     (2) public static 클래스 이름 getInstance(){ return instance; }  
     (3) private static 클래스 이름 instance = new 클래스이름();  
     (4) 사용: 직접 객체 생성 사용 불가  
      클래스이름 참조변수명 = 클래스이름.getInstance();

## console

workspace 보다는 console 에서 진행

고급 시스템 환경 설정> 환경변수> 시스템변수 path > 편집> 새로만들기 > C:\Program Files\MySQL\MySQL Server 8.0\bin

C:\Users\SSAFY>mysql -u ssafy -p ssafy

mysql> select version();

mysql> exit

cd C:\SSAFY\yoojin\live\05. database\scott_demo_mysql

C:\Users\SSAFY>mysql -u ssafy -p ssafy

system dir

- sql 실행
  source scott\_\_demo_mysql.sql

status

show tables;

desc emp;
