create database fulfillment default character set utf8;
use fulfillment;

/* ***********************
=== drop 지우는 순서 ===
drop table calculate_cost;
drop table invoice;
drop table shopping_mall;
drop table trans_company;
drop table product;
drop table order_company;
************************* */

/* EVENT SCHEDULER 쓰기 위해서 반드시 설정해야 하는 부분. 여러 번 실행해도 에러 x */
SET GLOBAL event_scheduler = ON;
SET @@global.event_scheduler = ON;
SET GLOBAL event_scheduler = 1;
SET @@global.event_scheduler = 1;
/* 서버 재기동해도 돌아가도록 하려면 아래 경로의 파일에 추가 */
/* C:\ProgramData\MySQL\MySQL Server 5.7\my.ini  에 아래 문구 추가 */
/* 
[mysqld]
event_scheduler = ON
*/


/* table 생성 */
create table shopping_mall (
	s_id int(5) auto_increment primary key,
	s_name varchar(40)
) auto_increment=30001 default charset=utf8;

create table trans_company (
	t_id int(5) primary key auto_increment,
	t_pwd varchar(20),
	t_name varchar(40)
) auto_increment=50001 default charset=utf8;

create table order_company (
	o_id int(5)primary key auto_increment,
	o_pwd varchar(40),
	o_name varchar(40)
) auto_increment=70001 default charset=utf8;

create table product (
	p_id int(5) auto_increment,
	p_name varchar(30),
	p_img varchar(100),
	p_price int(10),
	p_amount int(5),
	p_oId int(5),
	primary key(p_id, p_name),
	foreign key (p_oId) references order_company(o_id) on delete cascade
) auto_increment=1 default charset=utf8;

create table invoice(
	i_id int(6) auto_increment,
	i_consigneeName varchar(10),
	i_consigneeTel varchar(13),
	i_consigneeAddr varchar(80),
	i_pId int(5),
	i_pName varchar(30),
	i_amount int(5),
	i_orderDate datetime,
	i_sId int(5),
	i_tId int(5),
	i_check varchar(1) default 'N',
	primary key(i_id),
	foreign key (i_pId, i_pName) references product(p_id, p_name),
	foreign key (i_sId) references shopping_mall(s_id),
	foreign key (i_tId) references trans_company(t_id)
) auto_increment=100001 default charset=utf8;

create table calculate_cost(
	c_iTel varchar(13),
	c_iDate datetime,
	c_sCost int(10),
	c_oCost int(10),
	c_tCost int(10) default 10000,
	primary key(c_iTel, c_iDate)
) default charset=utf8;


/*
http://database.sarang.net/?inc=read&aid=851&criteria=mssql&subcrit=&id=&limit=&keyword=&page=
*/

insert into shopping_mall(s_name) values('CI몰');
insert into shopping_mall(s_name) values('G-마트');
insert into shopping_mall(s_name) values('쿠팽');

insert into trans_company(t_pwd, t_name) values('asdf', '경기물류');
insert into trans_company(t_pwd, t_name) values('asdf', '중부물류');
insert into trans_company(t_pwd, t_name) values('asdf', '영남물류');
insert into trans_company(t_pwd, t_name) values('asdf', '서부물류');

insert into order_company(o_pwd, o_name) values('asdf', '책책책');
insert into order_company(o_pwd, o_name) values('asdf', '동물사랑');
insert into order_company(o_pwd, o_name) values('asdf', '올리브올드');
insert into order_company(o_pwd, o_name) values('asdf', '오렌지씨');
insert into order_company(o_pwd, o_name) values('asdf', '스위트홈');

insert into product(p_name, p_img, p_price, p_amount, p_oId) values('건축의 탄생', 'book1.jpg', 10000, 7, 70001);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('고려열전', 'book2.jpg', 11000, 8, 70001);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('대단한 스트레칭', 'book3.jpg', 9000, 17, 70001);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('숨은 신발 찾기', 'book4.jpg', 14000, 31, 70001);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('스페인 데이', 'book5.jpg', 13000, 25, 70001);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('프리다 칼로', 'book6.jpg', 12000, 25, 70001);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('프리모 레비의 말', 'book7.jpg', 15000, 10, 70001);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('가방', 'animal_bag.jpg', 30000, 21, 70002);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('캔', 'animal_can.jpg', 5000, 40, 70002);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('쿠션', 'animal_cushion.jpg', 11000, 28, 70002);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('사료', 'animal_feed.jpg', 12100, 40, 70002);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('애견 패드', 'animal_pad.jpg', 19900, 30, 70002);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('간식', 'animal_snack.jpg', 9900, 40, 70002);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('장난감', 'animal_toy.jpg', 3700, 40, 70002);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('앰플', 'cosmetic_ample.jpg', 9900, 40, 70003);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('크림', 'cosmetic_cream.jpg', 8900, 40, 70003);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('립밤', 'cosmetic_lipbalm.jpg', 3200, 70, 70003);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('로션', 'cosmetic_lotion.jpg', 10900, 70, 70003);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('마스크', 'cosmetic_mask.jpg', 2300, 70, 70003);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('선크림', 'cosmetic_suncream.jpg', 5600, 70, 70003);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('토너', 'cosmetic_toner.jpg', 8800, 40, 70003);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('아보카도', 'fruit_avocado.jpg', 19800, 50, 70004);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('코코넛', 'fruit_coconut.jpg', 22000, 50, 70004);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('용과', 'fruit_dragon.jpg', 21000, 50, 70004);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('키위', 'fruit_kiwi.jpg', 19000, 50, 70004);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('레몬', 'fruit_lemon.jpg', 11000, 50, 70004);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('라임', 'fruit_lime.jpg', 12000, 50, 70004);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('오렌지', 'fruit_orange.jpg', 9900, 50, 70004);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('전기밥솥', 'homeappliances_airfryer.jpg', 34000, 40, 70005);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('고데기', 'homeappliances_curlingiron.jpg', 9900, 50, 70005);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('헤어드라이기', 'homeappliances_hairdryer.jpg', 9900, 50, 70005);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('마사지기구', 'homeappliances_massage.jpg', 23000, 50, 70005);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('스팀다리미', 'homeappliances_steamiron.jpg', 19800, 50, 70005);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('진공청소기', 'homeappliances_vacuumcleaner.jpg', 22900, 30, 70005);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('정수기', 'homeappliances_waterpurifier.jpg', 32000, 30, 70005);


select * from product;
select * from shopping_mall;

select P.p_id, P.p_name, P.p_price, P.p_amount, P.p_oId, O.o_name from product as P
 inner join order_company as O on P.p_oId=O.o_id
 order by P.p_amount;


/* *********************************************************** */
/* 아래서부터는 eclipse에서 사용하는 쿼리문들. 실행하지 말 것  */
/* *********************************************************** */

/* ******************************************************************* */
/* ********************     관리자 화면 부분    * ******************** */
/* ******************************************************************* */

/* csv 파일 읽어오기 - invoice 테이블에 값을 insert 하는 부분 */
load data local infile 'D:/csv/temp3.csv'
ignore into table invoice
character set utf8
fields terminated by ','
lines terminated by '\r\n'
ignore 1 rows
(i_consigneeName, i_consigneeTel, i_consigneeAddr, i_pId, i_pName, i_amount, @var1, i_sId, i_tId)
 set i_orderDate = timestamp(str_to_date(@var1, '%Y-%m-%d %H:%i'));


/* 재고 화면 상세보기 클릭 시 출력되는 쿼리문 */
select P.p_id, P.p_name, P.p_img, P.p_price, P.p_amount, P.p_oId, O.o_name from product as P
 inner join order_company as O on O.o_id = P.p_oId
 where P.p_id = 1;

select * from invoice;
/* 날짜 확인해서 만족하면 && 재고 물량이 1개 이상이라면 ->
  invoice check 를 Y로 상태 바꾸기 &  product의 amount를 갱신하기 */
update invoice as I inner join product as P on P.p_id=I.i_pId
 set I.i_check='Y', P.p_amount=P.p_amount-I.i_amount
 where P.p_amount - I.i_amount > 1 and I.i_check='N'
 and (
 	(date(I.i_orderDate) <= date(date_sub(now(), interval 2 day)))
 	or ( date(I.i_orderDate) = date(date_sub(now(), interval 1 day)) and hour(I.i_orderDate) < 18 )
 	or (
 	/*1-기록된 시간이 now-1일 && 오후 6시 이후 이거나
 	2-기록된 시간이 now일 && 오전9시  이전 이고
 	3-now시가 오전 9시 이후*/
 	 ((day(I.i_orderDate) = day(date_sub(now(), interval 1 day))) and hour(I.i_orderDate) >= 18)
	 or (day(I.i_orderDate) = day(now()) and hour(I.i_orderDate) < 9)
	 and (hour(now()) >= 9)
	)
	or (
	/* 1-기록된 시간이 now일이고
	2-기록된 시간이 오전 9시 이후이고 오후 6시 이전(포함x)이고
	3-now가 오후 6시 이후*/
	 day(I.i_orderDate) = day(now())
	 and (hour(I.i_orderDate) >= 9 and hour(I.i_orderDate) < 18)
	 and (hour(now()) >= 18)
	)
);
select day(now())
select * from invoice where i_check='N'
/* update 한 이후에 Y인 부분을 cost 테이블에 추가하도록 하기 
 * cost 테이블에 값들 insert 하는 부분 
  ================================================
쇼핑몰 : 대금 청구액은 (물품 가격*1.1 + 송장 1건당 10000원)
구매처 : 지급해야 할 금액은 (물품 가격)
운송사 : 지급해야 할 금액은 송장 1건당 (10000원) - default값이 10000원
*/
delete from calculate_cost;
insert into calculate_cost(c_iTel, c_iDate, c_sCost, c_oCost)
 select I.i_consigneeTel, I.i_orderDate, sum(P.p_price*I.i_amount), (sum(P.p_price*I.i_amount)*1.1 + 10000) from invoice as I
 inner join product as P on I.i_pId=P.p_id and I.i_check='Y'
 group by I.i_consigneeTel, I.i_orderDate order by I.i_id;

/* 위에꺼 쿼리문 하다가 실패한 버전
insert into test(tel, ordertime, shoppingcost, ordercost)
 select I.i_consigneeTel, I.i_orderDate, sum(P.p_price*I.i_amount), (sum(P.p_price*I.i_amount)*1.1 + 10000) from invoice as I
 inner join product as P on I.i_pId=P.p_id and I.i_check='Y'
 group by I.i_consigneeTel, I.i_orderDate order by I.i_id
 where not exists (
  select i_consigneeTel, i_orderDate from invoice
   inner join test on test.tel=invoice.i_consigneeTel and test.ordertime=invoice.i_orderDate
   group by invoice.i_consigneeTel, invoice.i_orderDate
 );

select count(*) from invoice group by i_consigneeTel, i_orderDate order by i_id;
 
*/

/* 단순히 물품 가격만을 출력 */
select I.i_id, P.p_name, I.i_consigneeTel, I.i_orderDate, P.p_price*I.i_amount from product as P
 inner join invoice as I on I.i_pId=P.p_id
 order by I.i_id;
select * from calculate_cost;


/* 발주 화면 시 사용하는 쿼리문 */
select I.i_id, I.i_consigneeName, I.i_orderDate, S.s_id, S.s_name, T.t_id, T.t_name, i_check from invoice as I
 inner join shopping_mall as S on I.i_sId = S.s_id
 inner join trans_company as T on I.i_tId = T.t_id
 group by I.i_consigneeTel, I.i_orderDate
 order by i_orderDate;
 

/* 발주 요청 시 내일 10시가 지나면 재고 추가되도록 하기 */
/* 내일 오전 10시 select */
select CURDATE() + INTERVAL 0 SECOND + INTERVAL 1 DAY + INTERVAL 10 HOUR;

CREATE EVENT orderRequest_event_01
 ON SCHEDULE
 at (CURDATE() + INTERVAL 0 SECOND + INTERVAL 1 DAY + INTERVAL 10 HOUR)
 DO update product set p_amount = p_amount + 1 where p_id=1;

drop event orderRequest_event_01;

show events from fulfillment like '%0%';
show events from fulfillment where db='fulfillment';
show create event 47Gc3HSvRA8747uwY4jm;
select EVENT_NAME, EVENT_DEFINITION, EXECUTE_AT from INFORMATION_SCHEMA.EVENTS;
select * from INFORMATION_SCHEMA.EVENTS
select replace(replace(EVENT_DEFINITION, ' where p_id = ', ','), 'update product set p_amount = p_amount + ', '') from INFORMATION_SCHEMA.EVENTS;
select substring_index(replace(replace(EVENT_DEFINITION, ' where p_id = ', ','), 'update product set p_amount = p_amount + ', ''), ',', 1) from INFORMATION_SCHEMA.EVENTS order by CREATED;
select substring_index(replace(replace(EVENT_DEFINITION, ' where p_id = ', ','), 'update product set p_amount = p_amount + ', ''), ',', -1) from INFORMATION_SCHEMA.EVENTS order by CREATED;
select events from fulfillment;


/* 매출 총 이익 출력하기 */
select sum(c_sCost-c_oCost-c_tCost) from calculate_cost;

select sum(c_sCost - c_oCost - c_tCost) from calculate_cost
 where year(c_iDate)=2019 and month(c_iDate) = 4;


/* ********************************************************************* */

/* 쇼핑몰 전체 판매 내역 확인 (월단위x)*/
select distinct C.c_iTel, C.c_iDate, C.c_sCost, I.i_sId, S.s_name from calculate_cost as C
 inner join invoice as I on I.i_consigneeTel=C.c_iTel and I.i_orderDate=C.c_iDate
 inner join shopping_mall as S on S.s_id=I.i_sId
 order by C.c_iDate desc;
 
/* 위에 쿼리문 결과 개수(페이징용) 세는 쿼리문(전체) */
select count(distinct C.c_iTel, C.c_iDate) from calculate_cost as C
 inner join invoice as I on I.i_consigneeTel=C.c_iTel and I.i_orderDate=C.c_iDate
 inner join shopping_mall as S on S.s_id=I.i_sId
 order by C.c_iDate desc; 
 
/* 쇼핑몰 월단위 판매 내역 확인 (선택한 월을 기준으로 출력) */
select distinct C.c_iTel, C.c_iDate, C.c_sCost, I.i_sId, S.s_name from calculate_cost as C
 inner join invoice as I on I.i_consigneeTel=C.c_iTel and I.i_orderDate=C.c_iDate
 inner join shopping_mall as S on S.s_id=I.i_sId
 where C.c_iDate like '%2019-05%'
 order by C.c_iDate desc;
 
/* 위에 쿼리문 결과 개수(페이징용) 세는 쿼리문(월단위) */
select count(distinct C.c_iTel, C.c_iDate) from calculate_cost as C
 inner join invoice as I on I.i_consigneeTel=C.c_iTel and I.i_orderDate=C.c_iDate
 inner join shopping_mall as S on S.s_id=I.i_sId
 where C.c_iDate like '%2019-05%'
 order by C.c_iDate desc;

/* ********************************************************************* */

/* 구매처 전체 판매 내역 확인 (월단위x)*/
select distinct C.c_iTel, C.c_iDate, C.c_oCost, O.o_id, O.o_name from calculate_cost as C
 inner join invoice as I on I.i_consigneeTel=C.c_iTel and I.i_orderDate=C.c_iDate
 inner join product as P on P.p_id=I.i_pId
 inner join order_company as O on O.o_id=P.p_oId
 order by C.c_iDate desc;
 
/* 쇼핑몰 월단위 판매 내역 확인 (선택한 월을 기준으로 출력) */
select distinct C.c_iTel, C.c_iDate, C.c_oCost, O.o_id, O.o_name from calculate_cost as C
 inner join invoice as I on I.i_consigneeTel=C.c_iTel and I.i_orderDate=C.c_iDate
 inner join product as P on P.p_id=I.i_pId
 inner join order_company as O on O.o_id=P.p_oId
 where C.c_iDate like '%2019-05%'
 order by C.c_iDate desc;
 
/* 위에 쿼리문 결과 개수(페이징용) 세는 쿼리문(월단위) */
select count(distinct C.c_iTel, C.c_iDate) from calculate_cost as C
 inner join invoice as I on I.i_consigneeTel=C.c_iTel and I.i_orderDate=C.c_iDate
 inner join product as P on P.p_id=I.i_pId
 inner join order_company as O on O.o_id=P.p_oId
 where C.c_iDate like '%2019-05%'
 order by C.c_iDate desc;
 
/* ********************************************************************* */
 
/* 운송 회사 전체 판매 내역 확인 (월단위x)*/
select distinct C.c_iTel, C.c_iDate, C.c_tCost, T.t_id, T.t_name from calculate_cost as C
 inner join invoice as I on I.i_consigneeTel=C.c_iTel and I.i_orderDate=C.c_iDate
 inner join trans_company as T on T.t_id=I.i_tId
 order by C.c_iDate desc;
 
/* 운송 회사 월단위 판매 내역 확인 (선택한 월을 기준으로 출력) */
select distinct C.c_iTel, C.c_iDate, C.c_tCost, T.t_id, T.t_name from calculate_cost as C
 inner join invoice as I on I.i_consigneeTel=C.c_iTel and I.i_orderDate=C.c_iDate
 inner join trans_company as T on T.t_id=I.i_tId
 where C.c_iDate like '%2019-05%'
 order by C.c_iDate desc;
 
/* 위에 쿼리문 결과 개수(페이징용) 세는 쿼리문(월단위) */
select count(distinct C.c_iTel, C.c_iDate) from calculate_cost as C
 inner join invoice as I on I.i_consigneeTel=C.c_iTel and I.i_orderDate=C.c_iDate
 inner join trans_company as T on T.t_id=I.i_tId
 where C.c_iDate like '%2019-05%'
 order by C.c_iDate desc;
 
/* ********************************************************************* */

/* 재고가 10개 이하이면 알림 메시지 띄워주기 */
select count(p_id) from product where p_amount <= 10;



/* ******************************************************************* */
/* ***************    발주 회사 화면 부분   ************************** */
/* ******************************************************************* */

/* 발주 회사의 일별 주문 내역을 확인하는 부분  */
select I.i_id, I.i_consigneeName, I.i_consigneeTel, I.i_orderDate, C.c_tCost from invoice as I
 inner join calculate_cost as C on C.c_iTel=I.i_consigneeTel and C.c_iDate=I.i_orderDate
 inner join trans_company as T on T.t_id=I.i_tId
 where I.i_orderDate like '%2019-05-08%' and I.i_tId = 50001
 group by I.i_consigneeTel, I.i_orderDate
 order by I.i_orderDate desc;

/* 발주 회사의 일별 주문 내역 화면 출력 시 default값은 오늘 날짜 */
select I.i_id, I.i_consigneeName, I.i_consigneeTel, I.i_orderDate, C.c_tCost from invoice as I
 inner join calculate_cost as C on C.c_iTel=I.i_consigneeTel and C.c_iDate=I.i_orderDate
 inner join trans_company as T on T.t_id=I.i_tId
 where date(I.i_orderDate) = date(now())-5 and I.i_tId=50001
 group by I.i_consigneeTel, I.i_orderDate
 order by I.i_orderDate desc;
 
/* 발주 회사의 월별 주문 내역을 확인하는 부분  */
select I.i_id, I.i_consigneeName, I.i_consigneeTel, I.i_orderDate, C.c_tCost from invoice as I
 inner join calculate_cost as C on C.c_iTel=I.i_consigneeTel and C.c_iDate=I.i_orderDate
 inner join trans_company as T on T.t_id=I.i_tId
 where I.i_orderDate like '%2019-05%' and I.i_tId = 50001
 group by I.i_consigneeTel, I.i_orderDate
 order by I.i_orderDate desc;

/* 발주 회사의 일별 주문 내역 화면 출력 시 default값은 현재 달 */
select I.i_id, I.i_consigneeName, I.i_consigneeTel, I.i_orderDate, C.c_tCost from invoice as I
 inner join calculate_cost as C on C.c_iTel=I.i_consigneeTel and C.c_iDate=I.i_orderDate
 inner join trans_company as T on T.t_id=I.i_tId
 where year(I.i_orderDate) = year(now()) and month(I.i_orderDate)=month(now()) and I.i_tId=50001
 group by I.i_consigneeTel, I.i_orderDate
 order by I.i_orderDate desc;
 

/* ********************************************************************* */
/* ***************      구매처  화면 부분     ************************** */
/* ********************************************************************* */

/* 구매처의 일별 주문 내역을 확인하는 부분  */
select I.i_id, I.i_consigneeName, I.i_consigneeTel, I.i_orderDate, C.c_oCost from invoice as I
 inner join calculate_cost as C on C.c_iTel=I.i_consigneeTel and C.c_iDate=I.i_orderDate
 inner join product as P on I.i_pId=P.p_id
 inner join order_company as O on O.o_id=P.p_oId
 where date(I.i_orderDate) = date('2019-05-08') and O.o_id = 70001
 group by I.i_consigneeTel, I.i_orderDate
 order by I.i_orderDate desc;

/* 구매처의 일별 주문 내역 화면 출력 시 default값은 오늘 날짜 */
select I.i_id, I.i_consigneeName, I.i_consigneeTel, I.i_orderDate, C.c_oCost from invoice as I
 inner join calculate_cost as C on C.c_iTel=I.i_consigneeTel and C.c_iDate=I.i_orderDate
 inner join product as P on I.i_pId=P.p_id
 inner join order_company as O on O.o_id=P.p_oId
 where date(I.i_orderDate) = date(now()) and O.o_id = 70001
 group by I.i_consigneeTel, I.i_orderDate
 order by I.i_orderDate desc;
 
/* 발주 회사의 월별 주문 내역을 확인하는 부분  */
select I.i_id, I.i_consigneeName, I.i_consigneeTel, I.i_orderDate, C.c_oCost from invoice as I
 inner join calculate_cost as C on C.c_iTel=I.i_consigneeTel and C.c_iDate=I.i_orderDate
 inner join product as P on I.i_pId=P.p_id
 inner join order_company as O on O.o_id=P.p_oId
 where I.i_orderDate like '%2019-05%' and O.o_id = 70001
 group by I.i_consigneeTel, I.i_orderDate
 order by I.i_orderDate desc;
 
/* 구매처의 일별 주문 내역 화면 출력 시 default값은 현재 달 */
select I.i_id, I.i_consigneeName, I.i_consigneeTel, I.i_orderDate, C.c_oCost from invoice as I
 inner join calculate_cost as C on C.c_iTel=I.i_consigneeTel and C.c_iDate=I.i_orderDate
 inner join product as P on I.i_pId=P.p_id
 inner join order_company as O on O.o_id=P.p_oId
 where year(I.i_orderDate) = year(now()) and month(I.i_orderDate)=month(now()) and O.o_id = 70001
 group by I.i_consigneeTel, I.i_orderDate
 order by I.i_orderDate desc;

select * from product;

/* ********************************************************************* */

/* calculate_cost */
/* 비용 계산 테이블 값 추가하는 쿼리문 */
/* csv 파일에서 그냥 직접 운송회사 아이디 입력하는 걸로 하기. 사용 안하는 쿼리문.
insert into calculate_cost(c_iId, c_iTel, c_iDate, c_sId, c_tId)
 select i_id, i_consigneeTel, i_orderDate, i_sId, 50001 from invoice
 where i_id=100001 and i_check='Y'
 and (substr(i_consigneeAddr, 1, 3)='수원시' or substr(i_consigneeAddr, 1, 3)='성남시' or substr(i_consigneeAddr, 1, 3)='평택시');
*/


/* 월단위 판매내역(쇼핑몰) 출력 시 사용하는 쿼리문 - calculate_cost table 수정 이전 버전임. 사용 x  */
/*select C.c_iId, I.i_consigneeName, C.c_iTel, C.c_iDate, I.i_sId, C.c_sCost from calculate_cost as C
 inner join invoice as I
 on I.i_id=C.c_iId;*/