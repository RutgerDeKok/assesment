###########################################################################
#
# Script for updating car_db template to version 1.0.0
#
# Changes:
# - car_db database created
# - db_versions added
# - cars table added
#
###########################################################################

SET @version = '1.0.0'; -- Version number

CREATE DATABASE IF NOT EXISTS `car_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `car_db`;  


CREATE TABLE  IF NOT EXISTS `db_versions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT ,
  `version` varchar(22) NOT NULL ,
  `runDateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `db_versions` ( `version` ) VALUES ( @version );


CREATE TABLE IF NOT EXISTS `car_types` (
	`id` INT(10) NULL AUTO_INCREMENT ,
	`make` VARCHAR(50) NOT NULL ,
	`model` VARCHAR(50) NOT NULL ,
	`version` VARCHAR(50) NOT NULL ,
	`numberOfDoors` TINYINT(2) NOT NULL ,
	`co2Emission` INT(10) NULL ,
	`priceGross` DECIMAL(10, 2) NOT NULL ,
	`priceNett` DECIMAL(10, 2) NOT NULL ,
	PRIMARY KEY (`id`)
	) ENGINE = InnoDB CHARSET=utf8mb4 COLLATE utf8mb4_general_ci;