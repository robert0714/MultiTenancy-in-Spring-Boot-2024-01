alter table if exists ordering drop constraint if exists FK__order__customer;
drop table if exists customer cascade;
drop table if exists ordering cascade;
drop sequence if exists customer_seq;
drop sequence if exists ordering_seq;
