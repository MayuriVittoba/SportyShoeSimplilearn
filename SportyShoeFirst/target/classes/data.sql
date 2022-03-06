create table category (category_id integer not null, category_name varchar(255), primary key (category_id))

create table admin_details (admin_id integer not null, admin_email varchar(255), admin_name varchar(255), admin_pwd varchar(255), primary key (admin_id))

create table product (prod_id integer not null, prod_added_date varchar(255), prod_code varchar(255), prod_desc varchar(255), prod_name varchar(255) not null, prod_price decimal(19,2), prod_review varchar(255), primary key (prod_id))

create table productandcategory (product_id integer not null, category_id integer not null)

create table user_login_details (user_id integer not null, is_logged_in boolean not null, user_email varchar(255), user_name varchar(255), user_pwd varchar(255), primary key (user_id))

alter table productandcategory add constraint FKh44v866jeac6bbj2b151cafou foreign key (category_id) references category

alter table productandcategory add constraint FK1ujnbxgt6kclyrxux9bnmkmvr foreign key (product_id) references product

create table orders (order_id integer not null, order_code varchar(150) not null,order_date varchar(150) not null, user_id integer not null, primary key (order_id))

create table order_details (order_id integer not null, prod_id integer not null)

alter table orders add constraint FKh44v866jeac6bbj2b151cafac foreign key (user_id) references user_login_details

alter table order_details add constraint FKh44v866jeac6bbj2b151cafov foreign key (order_id) references orders

alter table order_details add constraint FK1ujnbxgt6kclyrxux9bnmkmvs foreign key (prod_id) references product

insert into category(category_id,category_name) values(1,'kids')
insert into category(category_id,category_name) values(2,'men')
insert into category(category_id,category_name) values(3,'women')
insert into category(category_id,category_name) values(4,'fashion')
insert into category(category_id,category_name) values(5,'wardrobe')

insert into product(prod_id,prod_name,prod_code,prod_price,prod_desc,prod_review) values(1,'skirt','SKT',100,'long skirt','good')
insert into product(prod_id,prod_name,prod_code,prod_price,prod_desc,prod_review) values(2,'shorts','SHT',200,'upto knee','no review')
insert into product(prod_id,prod_name,prod_code,prod_price,prod_desc,prod_review) values(3,'watch','WTH',300,'black strap','awesome')
insert into product(prod_id,prod_name,prod_code,prod_price,prod_desc,prod_review) values(4,'pants','PNT',400,'brown','not bad')
insert into product(prod_id,prod_name,prod_code,prod_price,prod_desc,prod_review) values(5,'tshirt','TST',500,'brown','great')

insert into admin_details(admin_id,admin_email,admin_name,admin_pwd) values(1,'aaa','aaa','aaa')

insert into user_login_Details(user_id,user_email,user_name,user_pwd,is_logged_in) values(1,'bbb','bbb','bbb',1)
insert into user_login_Details(user_id,user_email,user_name,user_pwd,is_logged_in) values(2,'ccc','ccc','ccc',1)
insert into user_login_Details(user_id,user_email,user_name,user_pwd,is_logged_in) values(3,'ddd','ddd','ddd',0)

insert into productandcategory(product_id,category_id) values(1,1)
insert into productandcategory(product_id,category_id) values(3,1)
insert into productandcategory(product_id,category_id) values(2,2)
insert into productandcategory(product_id,category_id) values(2,3)
insert into productandcategory(product_id,category_id) values(4,4)
insert into productandcategory(product_id,category_id) values(5,5)

insert into orders(order_id,order_code,order_date,user_id) values(1,'ABC','1',1)
insert into orders(order_id,order_code,order_date,user_id) values(2,'XYZ','2',2)
insert into orders(order_id,order_code,order_date,user_id) values(3,'UVW','3',3)

insert into order_details(order_id,prod_id) values(1,1)
insert into order_details(order_id,prod_id) values(1,2)
insert into order_details(order_id,prod_id) values(2,3)
insert into order_details(order_id,prod_id) values(3,3)
insert into order_details(order_id,prod_id) values(3,4)

--[Orders(orderId=1, userId=1, orderDate=1, orderCode=ABC, userName=bbb, prodId=1, prodName=skirt), 
--Orders(orderId=1, userId=1, orderDate=1, orderCode=ABC, userName=bbb, prodId=1, prodName=skirt), 
--Orders(orderId=1, userId=1, orderDate=1, orderCode=ABC, userName=bbb, prodId=1, prodName=skirt), 
--Orders(orderId=2, userId=2, orderDate=2, orderCode=XYZ, userName=ccc, prodId=3, prodName=watch), 
--Orders(orderId=3, userId=3, orderDate=3, orderCode=UVW, userName=ddd, prodId=3, prodName=watch), 
--Orders(orderId=3, userId=3, orderDate=3, orderCode=UVW, userName=ddd, prodId=3, prodName=watch)]