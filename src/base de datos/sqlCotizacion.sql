SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema cotizacion
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `cotizacion` ;
CREATE SCHEMA IF NOT EXISTS `cotizacion` ;
USE `cotizacion` ;

-- -----------------------------------------------------
-- Table `cotizacion`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cotizacion`.`usuario` ;

CREATE TABLE IF NOT EXISTS `cotizacion`.`usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user` VARCHAR(45) NULL,
  `nombre` VARCHAR(45) NULL,
  `pass` VARCHAR(45) NULL,
  `meta` INT NULL,
  `activo` TINYINT(1) NULL DEFAULT 1,
  `eliminado` TINYINT(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cotizacion`.`identificador_ingreso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cotizacion`.`identificador_ingreso` ;

CREATE TABLE IF NOT EXISTS `cotizacion`.`identificador_ingreso` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `identificador` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(150) NOT NULL,
  `activo` TINYINT(1) NOT NULL DEFAULT 1,
  `eliminado` TINYINT(1) NOT NULL DEFAULT 0,
  `usuario_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_identificador_ingreso_usuario1_idx` (`usuario_id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cotizacion`.`ingreso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cotizacion`.`ingreso` ;

CREATE TABLE IF NOT EXISTS `cotizacion`.`ingreso` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `identificador` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `valor` INT NOT NULL,
  `descripcion` VARCHAR(150) NULL,
  `fecha_inicio` DATE NULL,
  `fecha_fin` DATE NULL,
  `activo` TINYINT(1) NULL DEFAULT 1,
  `eliminado` TINYINT(1) NULL DEFAULT 0,
  `usuario_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ingreso_identificador_idx` (`identificador` ASC),
  INDEX `fk_ingreso_usuario1_idx` (`usuario_id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cotizacion`.`identificador_egreso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cotizacion`.`identificador_egreso` ;

CREATE TABLE IF NOT EXISTS `cotizacion`.`identificador_egreso` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `identificador` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(150) NOT NULL,
  `activo` TINYINT(1) NOT NULL DEFAULT 1,
  `eliminado` TINYINT(1) NOT NULL DEFAULT 0,
  `usuario_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_identificador_egreso_usuario1_idx` (`usuario_id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cotizacion`.`egreso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cotizacion`.`egreso` ;

CREATE TABLE IF NOT EXISTS `cotizacion`.`egreso` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `identificador` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `valor` INT NOT NULL,
  `descripcion` VARCHAR(150) NULL,
  `fecha_inicio` DATE NULL,
  `fecha_fin` DATE NULL,
  `activo` TINYINT(1) NULL DEFAULT 1,
  `eliminado` TINYINT(1) NULL DEFAULT 0,
  `usuario_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_egreso_identificador_egreso1_idx` (`identificador` ASC),
  INDEX `fk_egreso_usuario1_idx` (`usuario_id` ASC))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
