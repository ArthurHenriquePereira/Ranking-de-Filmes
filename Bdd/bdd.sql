-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema rankingdefilmesbdd
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema rankingdefilmesbdd
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `rankingdefilmesbdd`;
USE `rankingdefilmesbdd` ;

-- -----------------------------------------------------
-- Table `rankingdefilmesbdd`.`filme`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rankingdefilmesbdd`.`filme` (
  `idFilme` INT(11) NOT NULL AUTO_INCREMENT,
  `posicaoFilme` INT(11) NOT NULL,
  `nomeFilme` VARCHAR(45) NOT NULL,
  `votosFilme` INT(11) NOT NULL,
  PRIMARY KEY (`idFilme`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
