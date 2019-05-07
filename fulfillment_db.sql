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
	p_price varchar(10),
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
	primary key(i_id, i_consigneeTel, i_orderDate),
	foreign key (i_pId, i_pName) references product(p_id, p_name),
	foreign key (i_sId) references shopping_mall(s_id),
	foreign key (i_tId) references trans_company(t_id)
) auto_increment=100001 default charset=utf8;

select i_id, i_consigneeName, i_orderDate, i_sId, i_tId, i_check from invoice;

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


insert into product(p_name, p_img, p_price, p_amount, p_oId) values('건축의 탄생', '../img/book/book1.jpg', 10000, 20, 70001);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('고려열전', '../img/book/book2.jpg', 11000, 19, 70001);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('대단한 스트레칭', '../img/book/book3.jpg', 9000, 17, 70001);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('숨은 신발 찾기', '../img/book/book4.jpg', 14000, 31, 70001);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('스페인 데이', '../img/book/book5.jpg', 13000, 25, 70001);
insert into product(p_name, p_img, p_price, p_amount, p_oId) values('프리다 칼로', '../img/book/book6.jpg', 12000, 25, 70001);
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
select * from trans_company;
select * from shopping_mall;
select * from invoice;

insert into invoice(i_consigneeName, i_consigneeTel, i_consigneeAddr, i_pId, i_pName, i_amount, i_orderDate, i_sId, i_tId)
 values('홍길동', '010-1111-2222', '수원시 장안구 정자1동', 2, '고려열전', 1, date_format('2019-04-28 13:00','%y-%m-%d %H:%i'), 30001, 50001);
insert into invoice(i_consigneeName, i_consigneeTel, i_consigneeAddr, i_pId, i_pName, i_amount, i_orderDate, i_sId, i_tId)
 values('홍길동', '010-1111-2222', '성남시 중원구 성남동', 3, '대단한 스트레칭', 2, date_format('2019-04-28 13:00','%y-%m-%d %H:%i'), 30001, 50001);
insert into invoice(i_consigneeName, i_consigneeTel, i_consigneeAddr, i_pId, i_pName, i_amount, i_orderDate, i_sId, i_tId)
 values('전우치', '010-2222-3333', '평택시 신평동', 12, '애견 패드', 2, date_format('2019-04-29 14:25','%y-%m-%d %H:%i'), 30002, 50001);
insert into invoice(i_consigneeName, i_consigneeTel, i_consigneeAddr, i_pId, i_pName, i_amount, i_orderDate, i_sId, i_tId)
 values('허균', '010-3333-4444', '천안시 중앙동', 15, '앰플', 4, date_format('2019-04-30 08:25','%y-%m-%d %H:%i'), 30003, 50002);
insert into invoice(i_consigneeName, i_consigneeTel, i_consigneeAddr, i_pId, i_pName, i_amount, i_orderDate, i_sId, i_tId)
 values('김철수', '010-4444-5555', '논산시 부창동', 24, '용과', 4, date_format('2019-04-30 09:25','%y-%m-%d %H:%i'), 30003, 50002);
insert into invoice(i_consigneeName, i_consigneeTel, i_consigneeAddr, i_pId, i_pName, i_amount, i_orderDate, i_sId, i_tId)
 values('김철수', '010-4444-5555', '대전시 서구 월평동', 26, '레몬', 5, date_format('2019-04-30 09:25','%y-%m-%d %H:%i'), 30003, 50002);
insert into invoice(i_consigneeName, i_consigneeTel, i_consigneeAddr, i_pId, i_pName, i_amount, i_orderDate, i_sId, i_tId)
 values('박철수', '010-5555-6666', '부산시 중구 대청동', 21, '토너', 3, date_format('2019-04-30 09:25','%y-%m-%d %H:%i'), 30003, 50003);
insert into invoice(i_consigneeName, i_consigneeTel, i_consigneeAddr, i_pId, i_pName, i_amount, i_orderDate, i_sId, i_tId)
 values('박철수', '010-5555-6666', '대구시 수성구 지산1동', 7, '프리모 레비의 말', 1, date_format('2019-04-30 16:25','%y-%m-%d %H:%i'), 30003, 50003);
insert into invoice(i_consigneeName, i_consigneeTel, i_consigneeAddr, i_pId, i_pName, i_amount, i_orderDate, i_sId, i_tId)
 values('홍영희', '010-6666-7777', '울산시 울주군 삼남면', 32, '마사지기구', 2, date_format('2019-05-01 12:25','%y-%m-%d %H:%i'), 30003, 50003);
insert into invoice(i_consigneeName, i_consigneeTel, i_consigneeAddr, i_pId, i_pName, i_amount, i_orderDate, i_sId, i_tId)
 values('홍지수', '010-7777-8888', '목포시 삼학동', 35, '정수기', 1, date_format('2019-05-02 08:25','%y-%m-%d %H:%i'), 30003, 50004);
insert into invoice(i_consigneeName, i_consigneeTel, i_consigneeAddr, i_pId, i_pName, i_amount, i_orderDate, i_sId, i_tId)
 values('김지영', '010-8888-9999', '여수시 삼산면', 19, '마스크', 10, date_format('2019-05-02 08:25','%y-%m-%d %H:%i'), 30003, 50004);
insert into invoice(i_consigneeName, i_consigneeTel, i_consigneeAddr, i_pId, i_pName, i_amount, i_orderDate, i_sId, i_tId)
 values('김수현', '010-9999-1111', '순천시 매곡동', 18, '로션', 2, date_format('2019-05-02 09:34','%y-%m-%d %H:%i'), 30003, 50004);
insert into invoice(i_consigneeName, i_consigneeTel, i_consigneeAddr, i_pId, i_pName, i_amount, i_orderDate, i_sId, i_tId)
 values('김수현', '010-9999-1111', '순천시 황전면', 21, '토너', 2, date_format('2019-05-02 08:34','%y-%m-%d %H:%i'), 30003, 50004);
insert into invoice(i_consigneeName, i_consigneeTel, i_consigneeAddr, i_pId, i_pName, i_amount, i_orderDate, i_sId, i_tId)
 values('김수현', '010-9999-1111', '대전시 동구', 21, '토너', 1, date_format('2019-05-02 09:39','%y-%m-%d %H:%i'), 30003, 50002);
insert into invoice(i_consigneeName, i_consigneeTel, i_consigneeAddr, i_pId, i_pName, i_amount, i_orderDate, i_sId, i_tId)
 values('박수현', '010-1212-1212', '대전시 유성구 궁동', 19, '마스크', 3, date_format('2019-05-02 11:39','%y-%m-%d %H:%i'), 30003, 50002);
insert into invoice(i_consigneeName, i_consigneeTel, i_consigneeAddr, i_pId, i_pName, i_amount, i_orderDate, i_sId, i_tId)
 values('이수현', '010-1313-1313', '대전시 유성구 어은동', 19, '마스크', 5, date_format('2019-05-03 09:12','%y-%m-%d %H:%i'), 30003, 50002);
 

 
desc invoice;

select * from invoice;
select * from trans_company;
select * from calculate_cost;
desc calculate_cost;
select * from trans_company;

/*
insert into calculate_cost values(100001, '010-1111-2222', date_format('2019-04-28 13:00','%y-%m-%d %H:%i'), 30001, 50001);
insert into calculate_cost values(100002, '010-1111-2222', date_format('2019-04-28 13:00','%y-%m-%d %H:%i'), 30001, 50001);
*/
/*
SELECT SUBSTR(i_consigneeAddr, 1, 3) from invoice where i_id=100001;

select (
	case
		when substr(i_consigneeAddr, 1, 3)
		
) as 
*/
select * from product;
select * from invoice;
select * from calculate_cost;


/* 월단위 판매내역(쇼핑몰) 출력 시 사용하는 쿼리문 */
select C.c_iId, I.i_consigneeName, C.c_iTel, C.c_iDate, I.i_sId, C.c_sCost from calculate_cost as C
 inner join invoice as I
 on I.i_id=C.c_iId;



/* invoice */
/* 날짜 확인해서 만족하면 && 재고 물량이 10개 이상이라면 ->
  invoice check 를 Y로 상태 바꾸기 &  product의 amount를 갱신하기 */
update invoice as I inner join product as P on P.p_id=I.i_pId
 set I.i_check='Y', P.p_amount=P.p_amount-I.i_amount
 where P.p_amount - I.i_amount > 9
 and I.i_id = 100004
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

desc calculate_cost;
select * from calculate_cost;
select * from invoice;
select * from shopping_mall;


/* 단순히 물품 가격만을 출력 */
select I.i_id, P.p_name, I.i_consigneeTel, I.i_orderDate, P.p_price*I.i_amount from product as P
 inner join invoice as I on I.i_pId=P.p_id
 order by I.i_id;
 
create table test(
 tempUK int(10) unique key auto_increment,
 tel varchar(13),
 ordertime datetime,
 shoppingcost int(10),
 ordercost int(10),
 transcost int(10) default 10000,
 primary key(tel, ordertime)
) auto_increment=1, default charset=utf8;

drop table test;

/* update 한 이후에 Y인 부분을 cost 테이블에 추가하도록 하기 */
/*
쇼핑몰 : 대금 청구액은 (물품 가격*1.1 + 송장 1건당 10000원)
구매처 : 지급해야 할 금액은 (물품 가격)
운송사 : 지급해야 할 금액은 송장 1건당 (10000원) - default값이 10000원
*/
insert into test(tel, ordertime, shoppingcost, ordercost)
 select I.i_consigneeTel, I.i_orderDate, sum(P.p_price*I.i_amount), (sum(P.p_price*I.i_amount)*1.1 + 10000) from invoice as I
 inner join product as P on I.i_pId=P.p_id and I.i_check='Y'
 group by I.i_consigneeTel, I.i_orderDate order by I.i_id
 where not exists (
  select i_consigneeTel, i_orderDate from invoice
   inner join test on test.tel=invoice.i_consigneeTel and test.ordertime=invoice.i_orderDate
   group by invoice.i_consigneeTel, invoice.i_orderDate
 );


select * from test order by tempUK;
 
insert into calculate_cost() values 
select I.i_consigneeTel, I.i_orderDate, sum(P.p_price*I.i_amount) as shoppCost from invoice as I
 inner join product as P on I.i_pId=P.p_id and I.i_check='Y'
 group by I.i_consigneeTel, I.i_orderDate order by I.i_id;


select I.i_consigneeTel, I.i_orderDate, sum(P.p_price*I.i_amount) as shoppCost from invoice as I
 inner join product as P on I.i_pId=P.p_id
 group by I.i_consigneeTel, I.i_orderDate order by I.i_id;
 

select count(*) from invoice group by i_consigneeTel, i_orderDate order by i_id;

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

select substr(t_str from 1 for 13) from test; /* 전화번호 */
select substr(t_str from 15) from test; /* 날짜 */

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



select c_iId, c_iTel, c_iDate, c_sId from calculate_cost;




select * from invoice;
select * from product;
select * from calculate_cost;
select hour(now());

select (c_iId, c_iTel, c_iDate, c_sId) from calculate_cost where c_iId=100001;
 
/*
쇼핑몰 : 대금 청구액은 (물품 가격*1.1 + 송장 1건당 10000원)
구매처 : 지급해야 할 금액은 (물품 가격)
운송사 : 지급해야 할 금액은 송장 1건당 (10000원)
*/
select ssss from calculate_cost as C
 inner join invoice as I
 inner join product as P



/* calculate_cost */
/* 비용 계산 테이블 값 추가하는 쿼리문 */
/* csv 파일에서 그냥 직접 운송회사 아이디 입력하는 걸로 하기. 사용 안하는 쿼리문.
insert into calculate_cost(c_iId, c_iTel, c_iDate, c_sId, c_tId)
 select i_id, i_consigneeTel, i_orderDate, i_sId, 50001 from invoice
 where i_id=100001 and i_check='Y'
 and (substr(i_consigneeAddr, 1, 3)='수원시' or substr(i_consigneeAddr, 1, 3)='성남시' or substr(i_consigneeAddr, 1, 3)='평택시');
*/

