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
member
use world;
desc member;
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
	i_check varchar(1) default 'N',
	primary key(i_id, i_consigneeTel, i_orderDate),
	foreign key (i_pId, i_pName) references product(p_id, p_name),
	foreign key (i_sId) references shopping_mall(s_id)
) auto_increment=100001 default charset=utf8;

create table calculate_cost (
	c_iId int(6),
	c_iTel varchar(13),
	c_iDate datetime,
	c_sId int(5),
	c_tId int(5),
	primary key (c_iId, c_iTel, c_iDate),
	foreign key (c_iId, c_iTel, c_iDate) references invoice(i_id, i_consigneeTel, i_orderDate),
	foreign key (c_sId) references shopping_mall(s_id),
	foreign key (c_tId) references trans_company(t_id)
) default charset utf8;

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


insert into invoice() values();

