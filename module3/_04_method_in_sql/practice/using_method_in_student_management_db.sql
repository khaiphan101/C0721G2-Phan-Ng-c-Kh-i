DROP DATABASE IF EXISTS QuanLySinhVien;
CREATE DATABASE QuanLySinhVien;
USE QuanLySinhVien;
CREATE TABLE Class(
ClassID 	INT AUTO_INCREMENT PRIMARY KEY ,
ClassName	VARCHAR(60) NOT NULL,
StartDate 	DATETIME NOT NULL,
`Status`	BIT
);

CREATE TABLE Student(
StudentID 	INT AUTO_INCREMENT PRIMARY KEY ,
StudentName VARCHAR(30) NOT NULL,
Address 	VARCHAR(50),
Phone		VARCHAR(20),
`Status` 	BIT,
`ClassId` 	INT NOT NULL
);

CREATE TABLE `Subject`(
SubID 		INT AUTO_INCREMENT PRIMARY KEY ,
SubName 	VARCHAR(30) NOT NULL,
Credit 		TINYINT NOT NULL DEFAULT 1 CHECK (Credit >=1),
`Status` 	BIT DEFAULT 1
);

CREATE TABLE Mark(
    MarkId    INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    SubId     INT NOT NULL,
    StudentId INT NOT NULL,
    Mark      FLOAT   DEFAULT 0 CHECK ( Mark BETWEEN 0 AND 100),
    ExamTimes TINYINT DEFAULT 1,
    UNIQUE (SubId, StudentId),
    FOREIGN KEY (SubId) REFERENCES Subject (SubId),
    FOREIGN KEY (StudentId) REFERENCES Student (StudentId)
);
INSERT INTO Class
VALUES (1, 'A1', '2008-12-20', 1);
INSERT INTO Class
VALUES (2, 'A2', '2008-12-22', 1);
INSERT INTO Class
VALUES (3, 'B3', current_date, 0);
INSERT INTO Student (StudentName, Address, Phone, Status, ClassId)
VALUES ('Hung', 'Ha Noi', '0912113113', 1, 1);
INSERT INTO Student (StudentName, Address, Status, ClassId)
VALUES ('Hoa', 'Hai phong', 1, 1);
INSERT INTO Student (StudentName, Address, Phone, Status, ClassId)
VALUES ('Manh', 'HCM', '0123123123', 0, 2);
INSERT INTO `Subject`
VALUES (1, 'CF', 5, 1),
       (2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);
INSERT INTO Mark (SubId, StudentId, Mark, ExamTimes)
VALUES (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1),
       (2, 3, 10, 2);

SELECT *
FROM Student
WHERE StudentName like 'h%';

select *
from class
where month(StartDate) = 12;

select *
from Subject
where credit between 4 and 5;

SET SQL_SAFE_UPDATES = 0;
update Student 
set ClassId = 2
where StudentName = 'Hung';
SET SQL_SAFE_UPDATES = 1;

select  StudentName, SubName, Mark
from Mark
join Student on mark.StudentID = student.StudentID
join subject on mark.subid = subject.SubID
order by Mark desc, studentname desc;

SELECT Address, COUNT(StudentId) AS 'Số lượng học viên'
FROM Student
GROUP BY Address;

SELECT S.StudentId,S.StudentName, AVG(Mark)
FROM Student S join Mark M on S.StudentId = M.StudentId
GROUP BY S.StudentId, S.StudentName
HAVING AVG(Mark) > 15;

SELECT S.StudentId, S.StudentName, AVG(Mark)
FROM Student S join Mark M on S.StudentId = M.StudentId
GROUP BY S.StudentId, S.StudentName
HAVING AVG(Mark) >= ALL (SELECT AVG(Mark) FROM Mark GROUP BY Mark.StudentId);

