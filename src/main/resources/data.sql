insert into usertbl(id, name, mobile, email, size) values (1, 'Aditya', '9991552342', 'aditya@yahoo.com', 10.5);
insert into usertbl(id, name, mobile, email, size) values (2, 'Shreya', '1559293942', 'shreya@gmail.com', 7);
insert into usertbl(id, name, mobile, email, size) values (3, 'Rohan', '9416643282', 'rohan@bing.com', 9.5);
insert into usertbl(id, name, mobile, email, size) values (4, 'Sarika', '8877678768', 'sarika@outlook.com', 8);
-- Applying a fix for generation of primary keys in case of a post request
alter table usertbl alter column id restart with (select max(id) from usertbl) + 1;

insert into shoetbl(id, category, price, color) values (1, 'sneakers', 10000, 'red');
insert into shoetbl(id, category, price, color) values (2, 'tennis', 7000, 'white');
insert into shoetbl(id, category, price, color) values (3, 'cricket', 12000, 'red');
insert into shoetbl(id, category, price, color) values (4, 'running', 7000, 'blue');
insert into shoetbl(id, category, price, color) values (5, 'tennis', 12000, 'yellow');
-- Applying a fix for generation of primary keys in case of a post request
alter table shoetbl alter column id restart with (select max(id) from shoetbl) + 1;

insert into purchasetbl(user_id, shoe_id, date) values (1, 1, '2022-01-16');
insert into purchasetbl(user_id, shoe_id, date) values (4, 1, '2022-01-16');
insert into purchasetbl(user_id, shoe_id, date) values (3, 2, '2022-09-16');
insert into purchasetbl(user_id, shoe_id, date) values (2, 3, '2021-09-08');
insert into purchasetbl(user_id, shoe_id, date) values (4, 3, '2021-07-08');
insert into purchasetbl(user_id, shoe_id, date) values (2, 2, '2018-12-20');
insert into purchasetbl(user_id, shoe_id, date) values (3, 1, '2022-07-16');
insert into purchasetbl(user_id, shoe_id, date) values (3, 2, '2018-12-20');
-- Applying a fix for generation of primary keys in case of a post request
alter table purchasetbl alter column id restart with (select max(id) from purchasetbl) + 1;

insert into admintbl(username, password) values('admin','admin@123');
insert into admintbl(username, password) values('aditya','aditya@456');