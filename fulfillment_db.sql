create database fulfillment default character set utf8;
use fulfillment;
/*
--- drop 지우는 순서 ---
drop table calculate_cost;
drop table invoice;
drop table shopping_mall;
drop table trans_company;
drop table product;
drop table order_company;
*/

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


/*
create table calculate_cost (
	c_iId int(6),
	c_iTel varchar(13),
	c_iDate datetime,
	c_sCost int(10),
	c_oCost int(10),
	c_tCost int(10) default 10000,
	primary key (c_iTel, c_iDate),
	foreign key (c_iId, c_iTel, c_iDate) references invoice(i_id, i_consigneeTel, i_orderDate) on update cascade
) default charset=utf8;
*/

create table calculate_cost(
 /*tempUK int(10) unique key auto_increment,auto_increment=1,*/
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


/*update order_company set o_name='오렌지씨' where o_id=70004;*/


insert into product(p_name, p_img, p_price, p_amount, p_oId) values('건축의 탄생', 'WebContent/img/book/book1.jpg', 10000, 20, 70001);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('고려열전', '/WebContent/img/book/book2.jpg', 11000, 19, 70001);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('대단한 스트레칭', 'img/book/book3.jpg', 9000, 17, 70001);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('숨은 신발 찾기', '/img/book/book4.jpg', 14000, 31, 70001);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('스페인 데이', 'FulFillmentService/WebContent/img/book/book5.jpg', 13000, 25, 70001);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('프리다 칼로', '/FulFillmentService/WebContent/img/book/book6.jpg', 12000, 25, 70001);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('프리모 레비의 말', '../img/book/book7.jpg', 15000, 10, 70001);

insert into product(p_name, p_img, p_price, p_amount, p_oId) values('가방', '../img/animalGoods/bag.jpg', 30000, 21, 70002);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('캔', '../img/animalGoods/can.jpg', 5000, 40, 70002);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('쿠션', '../img/animalGoods/cushion.jpg', 11000, 28, 70002);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('사료', '../img/animalGoods/feed.jpg', 12100, 40, 70002);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('애견 패드', '../img/animalGoods/pad.jpg', 19900, 30, 70002);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('간식', '../img/animalGoods/snack.jpg', 9900, 40, 70002);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('장난감', '../img/animalGoods/toy.jpg', 3700, 40, 70002);

insert into product(p_name, p_img, p_price, p_amount, p_oId) values('앰플', '../img/cosmetic/ample.jpg', 9900, 40, 70003);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('크림', '../img/cosmetic/cream.jpg', 8900, 40, 70003);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('립밤', '../img/cosmetic/lipbalm.jpg', 3200, 70, 70003);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('로션', '../img/cosmetic/lotion.jpg', 10900, 70, 70003);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('마스크', '../img/cosmetic/mask.jpg', 2300, 70, 70003);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('선크림', '../img/cosmetic/suncream.jpg', 5600, 70, 70003);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('토너', '../img/cosmetic/toner.jpg', 8800, 40, 70003);

insert into product(p_name, p_img, p_price, p_amount, p_oId) values('아보카도', '../img/fruit/avocado.jpg', 19800, 50, 70004);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('코코넛', '../img/fruit/coconut.jpg', 22000, 50, 70004);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('용과', '../img/fruit/drogon.jpg', 21000, 50, 70004);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('키위', '../img/fruit/kiwi.jpg', 19000, 50, 70004);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('레몬', '../img/fruit/lemon.jpg', 11000, 50, 70004);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('라임', '../img/fruit/lime.jpg', 12000, 50, 70004);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('오렌지', '../img/fruit/orange.jpg', 9900, 50, 70004);

insert into product(p_name, p_img, p_price, p_amount, p_oId) values('전기밥솥', '../img/homeAppliances/Airfryer.jpg', 34000, 40, 70005);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('고데기', '../img/homeAppliances/curlingiron.jpg', 9900, 50, 70005);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('헤어드라이기', '../img/homeAppliances/Hairdryer.jpg', 9900, 50, 70005);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('마사지기구', '../img/homeAppliances/Massage.jpg', 23000, 50, 70005);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('스팀다리미', '../img/homeAppliances/Steamiron.jpg', 19800, 50, 70005);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('진공청소기', '../img/homeAppliances/vacuumcleaner.jpg', 22900, 30, 70005);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('정수기', '../img/homeAppliances/waterpurifier.jpg', 32000, 30, 70005);

select * from product;
select p_img, p_name, p_price from product where p_img like '%book%';

/* csv 파일 읽어오기 - invoice 테이블에 값을 insert 하는 부분 */
load data local infile 'D:/csv/temp3.csv'
ignore into table invoice
character set utf8
fields terminated by ','
lines terminated by '\r\n'
ignore 1 rows
(i_consigneeName, i_consigneeTel, i_consigneeAddr, i_pId, i_pName, i_amount, @var1, i_sId, i_tId)
 set i_orderDate = timestamp(str_to_date(@var1, '%Y-%m-%d %H:%i'));


/* cost 테이블에 값들 insert 하는 부분 */
delete from calculate_cost;
insert into calculate_cost(c_iTel, c_iDate, c_sCost, c_oCost)
 select I.i_consigneeTel, I.i_orderDate, sum(P.p_price*I.i_amount), (sum(P.p_price*I.i_amount)*1.1 + 10000) from invoice as I
 inner join product as P on I.i_pId=P.p_id and I.i_check='Y'
 group by I.i_consigneeTel, I.i_orderDate order by I.i_id;


/* invoice  and I.i_id = 100005*/
/* 날짜 확인해서 만족하면 && 재고 물량이 10개 이상이라면 ->
  invoice check 를 Y로 상태 바꾸기 &  product의 amount를 갱신하기 */
update invoice as I inner join product as P on P.p_id=I.i_pId
 set I.i_check='Y', P.p_amount=P.p_amount-I.i_amount
 where P.p_amount - I.i_amount > 9
 and (
 	(I.i_orderDate <= date_sub(now(), interval 1 day) and hour(I.i_orderDate) < 18 )
 	or (
 	/*1-기록된 시간이 now-1일 && 오후 6시 이후 이거나
 	2-기록된 시간이 now일 && 오전9시  이전 이고
 	3-now시가 오전 9시 이후*/
 	 ((day(I.i_orderDate) = day(now()-1) and hour(I.i_orderDate) >= 18)
	 or (day(I.i_orderDate) = day(now()) and hour(I.i_orderDate) < 9))
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

select * from product;


/* 단순히 물품 가격만을 출력 */
select I.i_id, P.p_name, I.i_consigneeTel, I.i_orderDate, P.p_price*I.i_amount from product as P
 inner join invoice as I on I.i_pId=P.p_id
 order by I.i_id;

/* update 한 이후에 Y인 부분을 cost 테이블에 추가하도록 하기 
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
select * from calculate_cost;

/* 쇼핑몰 전체 판매 내역 확인 (월단위x)*/
select distinct C.c_iTel, C.c_iDate, C.c_sCost, I.i_sId, S.s_name from calculate_cost as C
 inner join invoice as I on I.i_consigneeTel=C.c_iTel and I.i_orderDate=C.c_iDate
 inner join shopping_mall as S on S.s_id=I.i_sId
 order by C.c_iDate desc;

/* 구매처 전체 판매 내역 확인 (월단위x)*/
select distinct C.c_iTel, C.c_iDate, C.c_oCost, O.o_id, O.o_name from calculate_cost as C
 inner join invoice as I on I.i_consigneeTel=C.c_iTel and I.i_orderDate=C.c_iDate
 inner join product as P on P.p_id=I.i_pId
 inner join order_company as O on O.o_id=P.p_oId
 order by C.c_iDate desc;
 
/* 운송 회사 전체 판매 내역 확인 (월단위x)*/
select distinct C.c_iTel, C.c_iDate, C.c_tCost, T.t_id, T.t_name from calculate_cost as C
 inner join invoice as I on I.i_consigneeTel=C.c_iTel and I.i_orderDate=C.c_iDate
 inner join trans_company as T on T.t_id=I.i_tId
 order by C.c_iDate desc;





 /* 연습하던 부분

select group_concat(i_pId separator ','), group_concat(i_amount separator ',') from invoice
 group by i_consigneeTel, i_orderDate;


insert into calculate_cost(c_iId, c_iTel, c_iDate, c_sCost, c_oCost)
 select C.c_iId, C.c_iTel, C.c_iDate from invoice as I inner join calculate_cost as C on I.i_check='Y' and 
 
 select i_id, i_consigneeTel, i_orderDate from invoice where i_check='Y' and i_id=100001
 select s cost
 select o cost;

select group_concat(invoice separator ',') from invoice
 group by 

 select C.c_iTel, C.c_iDate from invoice as I inner join calculate_cost as C on I.i_check='Y'
  and (select distinct concat(i_consigneeTel, ',', i_orderDate) from invoice);


select distinct concat(i_consigneeTel, ',', i_orderDate) from invoice where i_check='Y';


create table test (
	t_str varchar(100) primary key,
	t_shopCost int(10) 
) default charset=utf8;

select * from test;
drop table test;
insert ignore into test(t_str) select distinct concat(i_consigneeTel, ',', i_orderDate) from invoice where i_check='Y';

select I.i_pId, I.i_amount, P.p_price, (I.i_amount*P.p_price) from invoice as I
 inner join product as P
 on I.i_pId=P.p_id;


update test as T,
 inner join invoice as I
  on T.t_str=concat(I.i_consigneeTel, ',', I.i_orderDate)
 inner join product as P
  on P.p_id=I.i_pId
 set T.t_shopCost = sum(I.i_amount*P.p_price)
 where T.t_str=concat(I.i_consigneeTel, ',', I.i_orderDate);

select * from invoice as I
 inner join test as T on concat(I.i_consigneeTel, ',', I.i_orderDate)=T.t_str;


update test
 set t_shopCost=
 select sum(I.i_amount*P.p_price) from invoice as I
 inner join product as P
  on I.i_pId=P.p_id
 inner join test as T
  on concat(I.i_consigneeTel, ',', I.i_orderDate)=T.t_str
 where T.t_str=concat(I.i_consigneeTel, ',', I.i_orderDate);


select * from invoice where concat(i_consigneeTel, ',', i_orderDate)='010-1111-2222,2019-04-28 13:00:00';


select * from invoice where i_id=100001;
select * from test;

select substr(t_str from 1 for 13) from test;  전화번호 
select substr(t_str from 15) from test;  날짜 

select * from test where substr(t_str from 1 for 13)='010-1111-2222';

select * from invoice inner join test
 where substr(test.t_str from 1 for 13)=invoice.i_consigneeTel
  and substr(test.t_str from 15)=invoice.i_orderDate
  and concat(invoice.i_consigneeTel, ',', invoice.i_orderDate)=test.t_str;


select I.i_pId, I.i_amount, P.p_price, (I.i_amount*P.p_price) from invoice as I
 inner join product as P
 on I.i_pId=P.p_id;

 
select sum(I.i_amount*P.p_price), P.p_oId from invoice as I
 inner join product as P
  on I.i_pId=P.p_id
 inner join test as T
  on concat(I.i_consigneeTel, ',', I.i_orderDate)=T.t_str;
 

select count(distinct concat(i_consigneeTel, ',', i_orderDate)) from invoice;

select i_pId, i_amount from invoice where distinct concat(i_consigneeTel, ',', i_orderDate);

where distinct concat(i_consigneeTel, ',', i_orderDate)

select invoice as I inner join test as T

select concat('하이', ',', now());

select hour(now());
 
*/

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