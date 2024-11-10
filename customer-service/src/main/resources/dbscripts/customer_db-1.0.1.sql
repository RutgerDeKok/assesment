###########################################################################
#
# Script om de template database te upgraden naar versie 1.0.1
#
# Wijzigingen:
# - leaseContracts table added
#
###########################################################################

SET @version = '1.0.1'; -- Version number

USE `customer_db`;  

CREATE TABLE IF NOT EXISTS `lease_contracts` (
	`id` INT(10) NULL AUTO_INCREMENT ,
	`customerId` INT(10) NOT NULL ,
	`carTypeId` INT(10) NOT NULL ,
	`mileagePerYear` INT(10) NOT NULL ,
	`durationMonths` INT(10) NOT NULL ,
	`interestRate` DECIMAL(4, 2) NOT NULL ,
	`startDate` DATE NOT NULL ,
	`priceNett` DECIMAL(10, 2) NOT NULL ,
	PRIMARY KEY (`id`)
	) ENGINE = InnoDB CHARSET=utf8mb4 COLLATE utf8mb4_general_ci;
	
	
INSERT INTO `db_versions` ( `version` ) VALUES ( @version );