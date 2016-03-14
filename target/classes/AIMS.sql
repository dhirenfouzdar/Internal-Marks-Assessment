DROP DATABASE IF EXISTS AimsDB;
CREATE DATABASE AimsDB;
USE AimsDB;

DROP TABLE IF EXISTS `UserEntity`;
create table `UserEntity`(
`id` int not null AUTO_INCREMENT,
`usn` varchar(15) not null,
`password` varchar(64) not null,
`usertype` varchar(20),
isfirsttimelogin varchar(2) default 0,
createdDate dateTime,
modifiedDate dateTime,
PRIMARY KEY(`usn`),
unique key(`id`)
);

insert into UserEntity(usn,password,usertype,isfirsttimelogin,createdDate,modifiedDate)values('admin','admin','admin',1,now(),now());
alter table userentity add column graduationType varchar(34);
alter table userentity add column yearOfJoining varchar(14);
alter table userentity add column yearOfPassing varchar(14);
alter table userentity add column branch varchar(14);


create table `LectureProfileEntity`(
`id` int(5) auto_increment,
`firstName` varchar(32),
`lastName` varchar(32),
`usn` varchar(12),
`emailId` varchar(32),
`gender` varchar(10),
`mobileNumber` varchar(15),
`alternateNumber` varchar(15),
`designation` varchar(32),
`createdDate` datetime not null,
`modifiedDate` datetime not null,
`address` varchar(64),
`sem
primary key(`id`),
foreign key(`usn`) references UserEntity(usn)
);


create table `StudentProfileEntity`(
`id` int(5) auto_increment,
`firstName` varchar(32),
`lastName` varchar(32),
`usn` varchar(12),
`emailId` varchar(32),
`gender` varchar(10),
`mobileNumber` varchar(15),
`alternateNumber` varchar(15),
`yearofjoining` varchar(32),
`yearofpassing` varchar(32),
`createdDate` datetime not null,
`modifiedDate` datetime not null,
`address` varchar(64),
primary key(`id`),
foreign key(`usn`) references UserEntity(usn)
);
alter table StudentProfileEntity add column `subject` varchar(32);
alter table StudentProfileEntity add column `sem` varchar(16);
alter table StudentProfileEntity add column `totalclass` varchar(32);
alter table StudentProfileEntity add column `attendedclass` varchar(32);
alter table StudentProfileEntity add column `percentage` varchar(32);

create table `LectureSubjectEntity` (
`id` int(5) auto_increment,
`usn` varchar(12),
`sem` varchar(32),
`subject` varchar(256),
`createdDate` datetime not null,
`modifiedDate` datetime not null,
primary key(`id`),
foreign key(`usn`) references UserEntity(usn)
);

create table `IAEntity`(
`id` int(5) auto_increment,
`usn` varchar(32),
`sem` varchar(32),
`test1` varchar(32),
`test2` varchar(12),
`test3` varchar(32),
`subject` varchar(256),
`yearofpassing` varchar(15),
`createdDate` datetime not null,
`modifiedDate` datetime not null,
primary key(`id`),
foreign key(`usn`) references UserEntity(usn)
);
alter table IAEntity add column averageMarks varchar(30);
