CREATE DATABASE jdbcBatchInsert;

USE jdbcBatchInsert;

CREATE TABLE T_User(
	id BIGINT IDENTITY(1, 1),
	name NVARCHAR(64),
	age INT DEFAULT 1
);