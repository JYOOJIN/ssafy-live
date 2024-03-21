-- 한줄 주석
# 한줄 주석
/* 여러줄 주석*/

-- 연결된 계정 정보 조회 : ssafy
select user();

-- 해당 데이터베이스 사용
use ssafydb;

-- 현재 사용중인 데이터 베이스 정보 조회 : ssafydb
select database();

-- 연결 계정의 데이터베이스 목록 조회
show databases;


-- 테이블 목록 조회
show tables;

-- 부서 테이블
describe departments;

-- 직원 테이블
describe employees;

# 연산자/함수

-- 연결 함수: concat(arg1, arg2, argX...)
-- 연결 연산자: data1 || data2 || dataX ... -> oracle 만 가능

-- 직원의 사번은 000이고 이름은 000 이다.
-- text는 ' 로 감싸준다. 별명(alias)은 " 로 감싸준다.
-- 컬럼명 "컬럼에 대한 별명" : 별명 공백, 대소문자 구분, 특수문자 사용 시에는 "" 감싸야함
-- 컬럼명 별명 : " 생략 가능하지만 oracle에서는 불가능

select concat('직원의 사번은 ',employee_id, ' 이고 이름은 ',first_name,' 이다') "직원 정보"
from employees;

-- select '직원의 사번은 ' || employee_id || ' 이고 이름은 ' || first_name ||' 이다' "직원 정보"
-- from employees;

-- boolean : where 조건 연산자 비교 시 
-- 0: false, 0이 아닌 숫자는 true

-- 해당 문자의 저장 위치 반환(index는 1부터), 대소문자 구분 X, 존재하지 않으면 0
-- 단어라면 단어 시작 위치 반환
select instr('Ssafy.com','s'); -- '1'
select instr('Ssafy.com','a'); -- '3'
select instr('Ssafy.com','COM'); -- '7'
select instr('ssafy.com','r'); -- '0'

-- 날짜 관련
select now(); -- '2024-03-13 13:55:16'
select curdate(), current_date(), current_date; -- '2024-03-13', '2024-03-13', '2024-03-13'

-- 시간 관련
 select curtime(), current_time(), current_time; -- '13:57:09', '13:57:09', '13:57:09'

-- 연, 월, 일 관련
select year(curdate()) 년도, month(now()) 월, day(current_date) 일; -- '2024', '3', '13'

-- 날짜 연산 : date_add(date, interval N day | month | week)
-- 3개월 후 날짜 조회 
select date_add(curdate(), interval 3 month) "3개월 후 날짜"; -- '2024-06-13'

-- 내가 살아온 날짜 일수 계산, 소수 이하 버림 처리
-- 경과 일수: datediff(끝 date, 시작 date)
select datediff( curdate(),'2000-01-12'); -- '8827'
select datediff(curdate(),'2024-01-02'); -- '71'

-- 오늘 요일 조회
select dayofweek(curdate()); -- '4'











