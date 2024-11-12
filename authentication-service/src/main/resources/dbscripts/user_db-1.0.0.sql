###########################################################################
#
# Script for updating user_db template to version 1.0.0
#
# Changes:
# - user_db database created
# - db_versions added
# - cars table added
#
###########################################################################

SET @version = '1.0.0'; -- Version number

CREATE DATABASE IF NOT EXISTS `user_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `user_db`;  


CREATE TABLE  IF NOT EXISTS `db_versions` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT ,
  `version` VARCHAR(22) NOT NULL ,
  `runDateTime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `db_versions` ( `version` ) VALUES ( @version );

CREATE TABLE IF NOT EXISTS `users` (
	`id` INT(10) NULL AUTO_INCREMENT ,
	`firstName` VARCHAR(50) NOT NULL ,
	`lastName` VARCHAR(50) NOT NULL ,
	`role` VARCHAR(50) NOT NULL ,
	`login` VARCHAR(20) NOT NULL ,
	`passwordEncoded` VARCHAR(120) NOT NULL ,
	PRIMARY KEY (`id`)
	) ENGINE = InnoDB CHARSET=utf8mb4 COLLATE utf8mb4_general_ci;