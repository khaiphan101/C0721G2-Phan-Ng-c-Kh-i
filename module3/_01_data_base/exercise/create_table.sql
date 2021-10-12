drop database if exists `student_management`;
create database `student_management`;
use `student_management`;
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