###########################################################################
#
# Script om de template database te upgraden naar versie 1.0.0
#
# Wijzigingen:
# - db_versions tabel toegevoegd
# - customers tabel toegevoegd
#
###########################################################################

SET @version = '1.0.0'; -- Version number

CREATE DATABASE IF NOT EXISTS `customer_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `customer_db`;  


CREATE TABLE  IF NOT EXISTS `db_versions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT ,
  `version` varchar(22) NOT NULL ,
  `runDateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `db_versions` ( `version` ) VALUES ( @version );

CREATE TABLE IF NOT EXISTS `customer_db`.`customers` (
	`id` INT(10) NULL AUTO_INCREMENT , 
	`firstName` VARCHAR(50) NULL ,
	`lastName` VARCHAR(50) NULL ,
	`street` VARCHAR(50) NULL ,
	`houseNumber` VARCHAR(20) NULL ,
	`zipCode` VARCHAR(10) NOT NULL ,
	`city` VARCHAR(50) NULL , `email_address` VARCHAR(50) NULL ,
	`phoneNumber` VARCHAR(20) NOT NULL ,
	PRIMARY KEY (`id`)
	) ENGINE = InnoDB CHARSET=utf8mb4 COLLATE utf8mb4_general_ci;