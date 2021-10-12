drop database if exists `student_management1`;
create database `student_management1`;
use `student_management1`;
create table `class`(
`id` INT NOT NULL,
`name` VARCHAR(45) NULL,
PRIMARY KEY(`id`)
);
create table `teacher`(
`id` INT NOT NULL,
`name` VARCHAR(45) NULL,
`age` INT NULL,
`country` VARCHAR(45) NULL,
PRIMARY KEY(`id`)
);