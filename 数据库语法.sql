create table UserTable
(
	userNo int Primary key identity(1,1),
	userId char(18) not null,
	userName varchar(20)not null unique,
	userPhone char(11) not null,
	checkInTime int,
	roomId char(4),
);

create table LoginTable
(
	loginId int primary key,
	account varchar(20),
	passwd varchar(20)
);

create table RoomTable
(
	roomId char(4) primary key,
	roomName varchar(20),
	roomPrice int,
	roomState int,
	checkInId int,
);
create table TempTable
(
	temp_roomId char(4),
	temp_userNo int ,
	temp_time varchar(20) default getdate(),
)

-- foreign key (checkInId) references UserTable(userNo)

--查询端口号
exec sys.sp_readerrorlog 0,1,'listening'

alter table UserTable add roomId char(4) not null default 0

alter table TempTable
add constraint fk_UserTable foreign key(temp_roomId) references RoomTable(roomId)


alter table TempTable
add constraint fk2_userno foreign key(temp_userno) references UserTable(userNo)

alter table UserTable 
add constraint ck_UserTable check(userId like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]')

alter table RoomTable
add constraint ck_RoomTable check(roomId like '[0-9][0-9][0-9][0-9]')

alter table UserTable
add constraint ck_roomid check(roomId like '[0-9][0-9][0-9][0-9]')

drop table RoomTable
drop table UserTable

insert into LoginTable
values(0,'u1','123456'),(0,'u2','159357'),(1,'m1','1476950779'),(1,'m2','147258369');

insert into UserTable
values('654452366659874421','ds','15478996532',4,'1002'),('642153266654789964','zw','14758963214',3,'2001'),
('654789555523654478','weq','15698745563',1,'3001'),('698745622212543367','huaz','12546987745',6,'4002')

insert into RoomTable
values('1001','单人间',100,0,null),('1002','单人间',100,1,1),('2001','双人间',200,1,2),('2002','双人间',200,0,null),
	('3001','大床房',300,1,3),('3002','大床房',300,0,null),('4001','总统套间',800,0,null),('4002','总统套间',800,1,4)

insert into TempTable
values('1002',1,getdate()),('2001',2,GETDATE()),('3001',3,getdate()),('4002',4,getdate())

select * from RoomTable where roomState=0

--触发器-实现在删除用户信息时，同时修改房间状态和入住
create trigger t_user on UserTable
for delete
as
begin
	declare @roomid char(4)
	select @roomid = roomId from deleted
	update RoomTable set roomState = 0,checkInId = null
	where roomId = @roomid
	end
	go


delete from UserTable where userId = '698745622212543367'

-- 触发器-在新增用户信息时，修改对应房号的房间状态
create trigger t_user_insert on UserTable
for insert
as
begin
	declare @roomid char(4)
	declare @userno int
	select @roomid = roomId,@userno=userNo from inserted
	update RoomTable set roomState = 1,checkInId = @userno
	where roomId = @roomid
	end
	go

insert into UserTable
values('698745622212543367','huaz','12546987745',6,'4002')

alter table UserTable drop constraint UQ_UserTable_66DCF95C1CEE5594