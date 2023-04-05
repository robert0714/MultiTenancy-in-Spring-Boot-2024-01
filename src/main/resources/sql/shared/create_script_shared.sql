create sequence product_seq start with 1 increment by 50;
create table product (id bigint not null, created_at timestamp(6), modified_at timestamp(6), code varchar(255), name varchar(255), primary key (id));
alter table if exists product add constraint UQ__product__code unique (code);
