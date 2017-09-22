-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema studentdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `studentdb` ;

-- -----------------------------------------------------
-- Schema studentdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `studentdb` DEFAULT CHARACTER SET utf8 ;
USE `studentdb` ;

-- -----------------------------------------------------
-- Table `student`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `student` ;

CREATE TABLE IF NOT EXISTS `student` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `grade` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
GRANT USAGE ON *.* TO studentdb@localhost;
 DROP USER studentdb@localhost;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'studentdb'@'localhost' IDENTIFIED BY 'studentdb';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'studentdb'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `student`
-- -----------------------------------------------------
START TRANSACTION;
USE `studentdb`;
INSERT INTO `student` (`id`, `first_name`, `last_name`, `grade`) VALUES (1, 'Bugs', 'Bunny', 8);
INSERT INTO `student` (`id`, `first_name`, `last_name`, `grade`) VALUES (2, 'Daffy', 'Duck', 8);
INSERT INTO `student` (`id`, `first_name`, `last_name`, `grade`) VALUES (3, 'Lola', 'Bunny', 7);
INSERT INTO `student` (`id`, `first_name`, `last_name`, `grade`) VALUES (4, 'Tweety', 'Bird', 6);
INSERT INTO `student` (`id`, `first_name`, `last_name`, `grade`) VALUES (5, 'Elmer', 'Fudd', 7);
INSERT INTO `student` (`id`, `first_name`, `last_name`, `grade`) VALUES (6, 'Tazmanian', 'Devil', 9);
INSERT INTO `student` (`id`, `first_name`, `last_name`, `grade`) VALUES (7, 'Michael', 'Jordan', 12);

COMMIT;

