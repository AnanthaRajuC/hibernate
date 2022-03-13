--
-- Table structure for `student`
--

CREATE TABLE student(
  id BIGINT AUTO_INCREMENT NOT NULL,
   first_name VARCHAR(255),
   last_name VARCHAR(255),
   email VARCHAR(255),
   CONSTRAINT pk_student PRIMARY KEY (id)
);

--
-- Table structure for `student_images`
--

CREATE TABLE student_images(
  student_id int(11) NOT NULL,
  file_name varchar(45) DEFAULT NULL
);