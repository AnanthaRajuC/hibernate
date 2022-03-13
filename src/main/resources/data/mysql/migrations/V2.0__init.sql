
INSERT INTO `student`(`email`,`first_name`,`last_name`) VALUES ('example@domain.com','john','doe');

INSERT INTO `student_images`(`student_id`,`file_name`) VALUES (1,'file01');
INSERT INTO `student_images`(`student_id`,`file_name`) VALUES (1,'file02');

INSERT INTO `jhac`.`education`(`Student_id`,`education`,`education_ORDER`)VALUES(1,'primary school',0);
INSERT INTO `jhac`.`education`(`Student_id`,`education`,`education_ORDER`)VALUES(1,'middle school',1);