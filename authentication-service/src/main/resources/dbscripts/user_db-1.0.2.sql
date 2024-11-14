###########################################################################
#
# Script for updating user_db template to version 1.0.0
#
# Changes:
# - add roles table
# - drop role column from users
# - add user_roles join table
#
###########################################################################

SET @version = '1.0.1'; -- Version number


USE `user_db`;  


CREATE TABLE `user_db`.`roles` (`id` INT(10) NOT NULL AUTO_INCREMENT , `name` VARCHAR(50) NOT NULL , `description` VARCHAR(150) NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;

ALTER TABLE `users`  
DROP COLUMN `role`;

CREATE TABLE user_roles (
    userId INT(10),
    roleId INT(10),
    PRIMARY KEY (userId, roleId),
    FOREIGN KEY (userId) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (roleId) REFERENCES roles(id) ON DELETE CASCADE
) ENGINE = InnoDB;
	