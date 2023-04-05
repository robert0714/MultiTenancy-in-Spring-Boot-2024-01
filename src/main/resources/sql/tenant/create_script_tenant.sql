create sequence customer_seq start with 1 increment by 50;
create sequence ordering_seq start with 1 increment by 50;
create table customer (id bigint not null, created_at timestamp(6), modified_at timestamp(6), address varchar(255), customer_code varchar(255), first_name varchar(255), last_name varchar(255), primary key (id));
create table ordering (id bigint not null, created_at timestamp(6), modified_at timestamp(6), order_date_time timestamp(6), product_code varchar(255), customer_id bigint not null, primary key (id));
alter table if exists customer add constraint UQ__customer__customer_code unique (customer_code);
alter table if exists ordering add constraint FK__order__customer foreign key (customer_id) references customer;
