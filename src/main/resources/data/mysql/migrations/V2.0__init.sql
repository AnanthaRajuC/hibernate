
INSERT INTO `student`(`email`,`phone`,`first_name`,`gender`,`last_name`,`city`,`street`,`zipcode`,`billing_city`,`billing_street`,`billing_zipcode`)
VALUES ('student1@domain.com','999999991','john','MALE','doe','city1','jump street', '90210','bc1','bs1','90211');
INSERT INTO `student`(`email`,`phone`,`first_name`,`gender`,`last_name`,`city`,`street`,`zipcode`,`billing_city`,`billing_street`,`billing_zipcode`)
VALUES ('student2@domain.com','999999992','jane','FEMALE','doe','city2','step up street', '90212','bc2','bs2','90213');

INSERT INTO `instructor`(`email`,`phone`,`first_name`,`gender`,`last_name`,`city`,`street`,`zipcode`,`billing_city`,`billing_street`,`billing_zipcode`)
VALUES ('teacher1@domain.com','8888888882','janis','FEMALE','doe','city3','step up 2 street', '90213','bc3','bs3','90214');

INSERT INTO `student_images`(`student_id`,`file_name`) VALUES (1,'file01');
INSERT INTO `student_images`(`student_id`,`file_name`) VALUES (1,'file02');
INSERT INTO `student_images`(`student_id`,`file_name`) VALUES (2,'file21');
INSERT INTO `student_images`(`student_id`,`file_name`) VALUES (2,'file22');

INSERT INTO `education`(`Student_id`,`education`,`education_ORDER`) VALUES (1,'primary school',0);
INSERT INTO `education`(`Student_id`,`education`,`education_ORDER`) VALUES (1,'middle school',1);
INSERT INTO `education`(`Student_id`,`education`,`education_ORDER`) VALUES (2,'primary school',0);
INSERT INTO `education`(`Student_id`,`education`,`education_ORDER`) VALUES (2,'middle school',1);

INSERT INTO `parents`(`Student_id`,`parent`,`parent_name`) VALUES (1,'FATHER','tom');
INSERT INTO `parents`(`Student_id`,`parent`,`parent_name`) VALUES (1,'MOTHER','stevie');
INSERT INTO `parents`(`Student_id`,`parent`,`parent_name`) VALUES (2,'FATHER','ye');
INSERT INTO `parents`(`Student_id`,`parent`,`parent_name`) VALUES (2,'MOTHER','kim');

INSERT INTO `student_subjects`(`Student_id`,`subject_name`) VALUES (1,'subject 3');
INSERT INTO `student_subjects`(`Student_id`,`subject_name`) VALUES (1,'subject 1');
INSERT INTO `student_subjects`(`Student_id`,`subject_name`) VALUES (1,'subject 5');
INSERT INTO `student_subjects`(`Student_id`,`subject_name`) VALUES (2,'subject 7');
INSERT INTO `student_subjects`(`Student_id`,`subject_name`) VALUES (2,'subject 6');
INSERT INTO `student_subjects`(`Student_id`,`subject_name`) VALUES (2,'subject 9');