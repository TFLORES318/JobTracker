-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema jobdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `jobdb` ;

-- -----------------------------------------------------
-- Schema jobdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `jobdb` DEFAULT CHARACTER SET utf8 ;
USE `jobdb` ;

-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(100) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `first_name` VARCHAR(100) NOT NULL,
  `last_name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `job`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `job` ;

CREATE TABLE IF NOT EXISTS `job` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `company` VARCHAR(100) NOT NULL,
  `title` VARCHAR(1000) NOT NULL,
  `city` VARCHAR(100) NOT NULL,
  `state` VARCHAR(100) NOT NULL,
  `notes` VARCHAR(1000) NULL,
  `date_applied` DATE NOT NULL,
  `status` ENUM('PENDING', 'REJECTED', 'OFFERED') NOT NULL DEFAULT 'PENDING',
  `cover_letter` TINYINT NOT NULL DEFAULT '0',
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_job_user_idx` (`user_id` ASC),
  CONSTRAINT `fk_job_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS jobuser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'jobuser'@'localhost' IDENTIFIED BY 'jobuser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'jobuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `jobdb`;
INSERT INTO `user` (`id`, `username`, `password`, `first_name`, `last_name`) VALUES (1, 'tflores', 'tabbybaby', 'Tabatha', 'Flores');

COMMIT;


-- -----------------------------------------------------
-- Data for table `job`
-- -----------------------------------------------------
START TRANSACTION;
USE `jobdb`;
INSERT INTO `job` (`id`, `company`, `title`, `city`, `state`, `notes`, `date_applied`, `status`, `cover_letter`, `user_id`) VALUES (1, 'Immersive Wisdom', 'Software Engineer', 'Cincinnati', 'OH', NULL, '2020-07-13', 'PENDING', 0, 1);

COMMIT;

