

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema g2g
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `g2g` ;

-- -----------------------------------------------------
-- Schema g2g
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `g2g` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `g2g` ;

-- -----------------------------------------------------
-- Table `g2g`.`item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `g2g`.`item` ;

CREATE TABLE IF NOT EXISTS `g2g`.`item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `available` BIT(1) NOT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `price` DECIMAL(19,2) NULL DEFAULT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
