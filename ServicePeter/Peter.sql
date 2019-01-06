-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema ServicePeter
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ServicePeter
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ServicePeter` DEFAULT CHARACTER SET utf8 ;
USE `ServicePeter` ;

-- -----------------------------------------------------
-- Table `ServicePeter`.`ugyfel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ServicePeter`.`ugyfel` (
  `ugyfel_id` INT NOT NULL AUTO_INCREMENT,
  `nev` VARCHAR(30) NOT NULL,
  `lakcim` VARCHAR(100) NOT NULL,
  `telefon` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NULL,
  `megjegyzes` VARCHAR(300) NULL,
  PRIMARY KEY (`ugyfel_id`));


-- -----------------------------------------------------
-- Table `ServicePeter`.`eszkoz`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ServicePeter`.`eszkoz` (
  `eszkoz_id` INT NOT NULL AUTO_INCREMENT,
  `eszkoz` VARCHAR(30) NOT NULL,
  `gyarto` VARCHAR(30) NOT NULL,
  `serial_no` VARCHAR(30) NOT NULL,
  `ugyintezo` VARCHAR(45) NOT NULL,
  `jelszo` VARCHAR(300) NULL,
  `bejelentes` DATE NOT NULL,
  `hatarido` DATE NOT NULL,
  `tartozek` VARCHAR(255) NULL,
  `serules` VARCHAR(255) NULL,
  `hiba_leiras` VARCHAR(300) NOT NULL,
  `eszkoz_megjegyzes` VARCHAR(255) NULL,
  `ugyfel_ugyfel_id` INT NOT NULL,
  `valos_hiba` VARCHAR(250) NULL,
  `statusz` VARCHAR(45) NULL,
  PRIMARY KEY (`eszkoz_id`),
  INDEX `fk_eszkoz_ugyfel_idx` (`ugyfel_ugyfel_id` ASC),
  CONSTRAINT `fk_eszkoz_ugyfel`
    FOREIGN KEY (`ugyfel_ugyfel_id`)
    REFERENCES `ServicePeter`.`ugyfel` (`ugyfel_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
