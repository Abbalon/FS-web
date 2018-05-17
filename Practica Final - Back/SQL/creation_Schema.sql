-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema practica_test
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `practica_test` ;

-- -----------------------------------------------------
-- Schema practica_test
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `practica_test` DEFAULT CHARACTER SET utf8 ;
USE `practica_test` ;

-- -----------------------------------------------------
-- Table `practica_test`.`em_empleados`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `practica_test`.`em_empleados` ;

CREATE TABLE IF NOT EXISTS `practica_test`.`em_empleados` (
  `id_Empleado` INT(11) NOT NULL AUTO_INCREMENT,
  `b_Servmilitar` VARCHAR(1) NOT NULL,
  `cx_Edocivil` VARCHAR(1) NOT NULL,
  `f_Alta` DATETIME NOT NULL,
  `f_Baja` DATETIME NULL DEFAULT NULL,
  `f_Nacimiento` DATETIME NOT NULL,
  `n_Telefono1` VARCHAR(12) NOT NULL,
  `n_Telefono2` VARCHAR(12) NOT NULL,
  `tx_Apellido1` VARCHAR(40) NOT NULL,
  `tx_Apellido2` VARCHAR(40) NOT NULL,
  `tx_Email` VARCHAR(40) NOT NULL,
  `tx_Nif` VARCHAR(9) NOT NULL,
  `tx_Nombre` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id_Empleado`))
ENGINE = MyISAM
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `UK_hl79rru3yioy0pfxt7wqaagu0` ON `practica_test`.`em_empleados` (`tx_Email` ASC);

CREATE UNIQUE INDEX `UK_m9qa9hlyn3s8dtqmbrvqmuac4` ON `practica_test`.`em_empleados` (`tx_Nif` ASC);


-- -----------------------------------------------------
-- Table `practica_test`.`pr_empleados_proyecto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `practica_test`.`pr_empleados_proyecto` ;

CREATE TABLE IF NOT EXISTS `practica_test`.`pr_empleados_proyecto` (
  `id_Empleado` INT(11) NOT NULL,
  `id_Proyecto` INT(11) NOT NULL,
  `f_Alta` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id_Empleado`, `id_Proyecto`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `FKmbik6khhmp242h0icitrbsm5y` ON `practica_test`.`pr_empleados_proyecto` (`id_Proyecto` ASC);


-- -----------------------------------------------------
-- Table `practica_test`.`pr_proyectos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `practica_test`.`pr_proyectos` ;

CREATE TABLE IF NOT EXISTS `practica_test`.`pr_proyectos` (
  `id_Proyecto` INT(11) NOT NULL AUTO_INCREMENT,
  `f_Baja` DATETIME NULL DEFAULT NULL,
  `f_Fin` DATETIME NULL DEFAULT NULL,
  `f_Inicio` DATETIME NOT NULL,
  `tx_Descripcion` VARCHAR(125) NOT NULL,
  `tx_Lugar` VARCHAR(30) NULL DEFAULT NULL,
  `tx_Observaciones` VARCHAR(300) NULL DEFAULT NULL,
  PRIMARY KEY (`id_Proyecto`))
ENGINE = MyISAM
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
