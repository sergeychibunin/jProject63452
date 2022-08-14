insert into store (name) values ('Store number 1');
insert into store (name) values ('Store number 2');

insert into rssfeed (name, is_published, store_id)
values ('RSS from file 1', true, (select id from store where name = 'Store number 1'));
insert into rssfeed (name, is_published, store_id)
values ('RSS from file 2', true, (select id from store where name = 'Store number 2'));

insert into purchase_order (created_at, store_id)
values ('2022-08-14 18:31:00+07:00', (select id from store where name = 'Store number 1'));
insert into purchase_order (created_at, store_id)
values ('2022-08-14 18:32:00+07:00', (select id from store where name = 'Store number 1'));
insert into purchase_order (created_at, store_id)
values ('2022-08-13 12:32:00+07:00', (select id from store where name = 'Store number 1'));

insert into purchase_order_position (order_id, rssfeed_id)
values (
(select id from purchase_order where created_at = '2022-08-14 18:31:00+07:00'),
(select if from rssfeed where name = 'RSS from file 1')
);
insert into purchase_order_position (order_id, rssfeed_id)
values (
(select id from purchase_order where created_at = '2022-08-14 18:32:00+07:00'),
(select if from rssfeed where name = 'RSS from file 1')
);
insert into purchase_order_position (order_id, rssfeed_id)
values (
(select id from purchase_order where created_at = '2022-08-13 12:32:00+07:00'),
(select if from rssfeed where name = 'RSS from file 1')
);
insert into purchase_order_position (order_id, rssfeed_id)
values (
(select id from purchase_order where created_at = '2022-08-13 12:32:00+07:00'),
(select if from rssfeed where name = 'RSS from file 2')
);
