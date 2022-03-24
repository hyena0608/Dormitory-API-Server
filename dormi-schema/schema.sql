
select "student";

CREATE TABLE student (
  student_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  student_hakbun BIGINT NOT NULL,
  student_sex INT NOT NULL,
  student_name VARCHAR(64) NOT NULL,
  student_age INT NOT NULL,
  student_start_dt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  student_update_dt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  student_delete_dt TIMESTAMP NOT NULL
);

select "dormitory";

CREATE TABLE dormitory (
  dormitory_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  dormitory_name VARCHAR(64) NOT NULL,
  dormitory_address VARCHAR(64) NOT NULL,
  dormitory_start_dt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  dormitory_update_dt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  dormitory_delete_dt TIMESTAMP NOT NULL
);

select "room";

CREATE TABLE room (
  room_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  room_number BIGINT NOT NULL,
  room_limit_cnt INT NOT NULL,
  room_current_cnt INT NOT NULL DEFAULT 0,
  room_start_dt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  room_update_dt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  room_delete_dt TIMESTAMP NOT NULL,
  dormitory_id BIGINT NOT NULL
);

select "dormitory_student";

CREATE TABLE dormitory_student (
  dormitory_student_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  dormitory_student_semester INT NOT NULL,
  dormitory_student_start_dt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  dormitory_student_update_dt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  dormitory_student_delete_dt TIMESTAMP NOT NULL,
  dormitory_id BIGINT NOT NULL,
  room_id BIGINT NOT NULL,
  student_id BIGINT NOT NULL
);

select "manager";

CREATE TABLE manager (
  manager_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  manager_name VARCHAR(64) NOT NULL,
  manager_age INT NOT NULL,
  manager_start_dt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  manager_update_dt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  manager_delete_dt TIMESTAMP NOT NULL
);

select "rule";

CREATE TABLE rule (
  rule_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  rule_content VARCHAR(2000) NOT NULL,
  rule_type INT NOT NULL,
  rule_point INT NOT NULL,
  rule_start_dt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  rule_update_dt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  rule_delete_dt TIMESTAMP NOT NULL
);

select "point";

CREATE TABLE point (
  point_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  point_start_dt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  point_update_dt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  point_delete_dt TIMESTAMP NOT NULL,
  dormitory_student_id BIGINT NOT NULL,
  rule_id BIGINT NOT NULL,
  manager_id BIGINT NOT NULL
);
