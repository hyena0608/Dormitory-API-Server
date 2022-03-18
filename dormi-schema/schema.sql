
select "student";

CREATE TABLE student (
  student_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  student_hakbun BIGINT NOT NULL,
  student_sex INT NOT NULL,
  student_name VARCHAR(64) NOT NULL,
  student_age INT NOT NULL,
  student_start_dt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  student_update_dt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  student_delete_dt TIMESTAMP NOT NULL DEFAULT ''
);

select "dormitory";

CREATE TABLE dormitory (
  dormitory_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  dormitory_name VARCHAR(64) NOT NULL,
  dormitory_address VARCHAR(64) NOT NULL,
  dormitory_start_dt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  dormitory_update_dt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  dormitory_delete_dt TIMESTAMP NOT NULL DEFAULT ''
);

select "room";

CREATE TABLE room (
  room_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  room_number BIGINT NOT NULL,
  room_limit_cnt INT NOT NULL,
  room_current_cnt INT NOT NULL DEFAULT 0,
  room_start_dt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  room_update_dt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  room_delete_dt TIMESTAMP NOT NULL DEFAULT '',
  dormitory_id BIGINT NOT NULL
);

select "dormitory_student";

CREATE TABLE dormitory_student (
  dormitory_student_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  dormitory_student_semester INT NOT NULL,
  dormitory_student_start_dt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  dormitory_student_update_dt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  dormitory_student_delete_dt TIMESTAMP NOT NULL DEFAULT '',
  dormitory_id BIGINT NOT NULL,
  room_id BIGINT NOT NULL,
  student_id BIGINT NOT NULL
);
