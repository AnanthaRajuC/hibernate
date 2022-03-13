--
-- Table structure for `student`
--

CREATE TABLE `student`(
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for `student_images`
--

CREATE TABLE `student_images`(
  `student_id` bigint NOT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  KEY `FK_student_id` (`student_id`),
  CONSTRAINT `FK_student_id` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;