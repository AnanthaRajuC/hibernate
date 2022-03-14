
INSERT INTO `student`(`email`,`first_name`,`last_name`) VALUES ('example@domain.com','john','doe');

INSERT INTO `student_images`(`student_id`,`file_name`) VALUES (1,'file01');
INSERT INTO `student_images`(`student_id`,`file_name`) VALUES (1,'file02');

INSERT INTO `education`(`Student_id`,`education`,`education_ORDER`) VALUES (1,'primary school',0);
INSERT INTO `education`(`Student_id`,`education`,`education_ORDER`) VALUES (1,'middle school',1);

INSERT INTO `parents`(`Student_id`,`parent`,`parent_name`) VALUES (1,'FATHER','tom');
INSERT INTO `parents`(`Student_id`,`parent`,`parent_name`) VALUES (1,'MOTHER','stevie');

INSERT INTO `student_subjects`(`Student_id`,`subject_name`) VALUES (1,'subject 3');
INSERT INTO `student_subjects`(`Student_id`,`subject_name`) VALUES (1,'subject 1');
INSERT INTO `student_subjects`(`Student_id`,`subject_name`) VALUES (1,'subject 5');