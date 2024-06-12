SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';


CREATE SCHEMA IF NOT EXISTS `SenhorDosAneis` DEFAULT CHARACTER SET utf8 ;
USE `SenhorDosAneis` ;


CREATE TABLE IF NOT EXISTS `SenhorDosAneis`.`Item_Magico` (
  `ID` INT NOT NULL,
  `Nome` VARCHAR(45) NOT NULL,
  `Tipo` VARCHAR(45) NOT NULL,
  `Durabilidade` INT NULL,
  `Material` VARCHAR(45) NULL,
  `Natureza` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `SenhorDosAneis`.`Localizacao` (
  `ID` INT NOT NULL,
  `Cidade` VARCHAR(45) NOT NULL,
  `Reino` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `SenhorDosAneis`.`Habitante` (
  `Nome` VARCHAR(45) NOT NULL,
  `Raça` VARCHAR(45) NOT NULL,
  `Idade` INT NOT NULL,
  `Altura` DOUBLE NOT NULL,
  `ID_Item` INT NULL,
  `ID_Local` INT NULL,
  PRIMARY KEY (`Nome`),
  INDEX `fk_Habitante_Item Mágico1_idx` (`ID_Item` ASC) VISIBLE,
  INDEX `fk_Habitante_Localização1_idx` (`ID_Local` ASC) VISIBLE,
  CONSTRAINT `fk_Habitante_Item Mágico1`
    FOREIGN KEY (`ID_Item`)
    REFERENCES `SenhorDosAneis`.`Item_Magico` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Habitante_Localização1`
    FOREIGN KEY (`ID_Local`)
    REFERENCES `SenhorDosAneis`.`Localizacao` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `SenhorDosAneis`.`Arma` (
  `Nome` VARCHAR(45) NOT NULL,
  `Tipo` VARCHAR(45) NOT NULL,
  `Durabilidade` INT NULL,
  `Material` VARCHAR(45) NULL,
  `Propriedade` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Nome`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `SenhorDosAneis`.`Armadura` (
  `Nome` VARCHAR(45) NOT NULL,
  `Tipo` VARCHAR(45) NOT NULL,
  `Durabilidade` INT NULL,
  `Peso` FLOAT NULL,
  `Material` VARCHAR(45) NULL,
  `Propriedade` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Nome`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `SenhorDosAneis`.`Habitante_has_Arma` (
  `Habitante_Nome` VARCHAR(45) NOT NULL,
  `Arma_Nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Habitante_Nome`, `Arma_Nome`),
  INDEX `fk_Habitante_has_Arma_Arma1_idx` (`Arma_Nome` ASC) VISIBLE,
  INDEX `fk_Habitante_has_Arma_Habitante_idx` (`Habitante_Nome` ASC) VISIBLE,
  CONSTRAINT `fk_Habitante_has_Arma_Habitante`
    FOREIGN KEY (`Habitante_Nome`)
    REFERENCES `SenhorDosAneis`.`Habitante` (`Nome`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Habitante_has_Arma_Arma1`
    FOREIGN KEY (`Arma_Nome`)
    REFERENCES `SenhorDosAneis`.`Arma` (`Nome`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `SenhorDosAneis`.`Habitante_has_Armadura` (
  `Habitante_Nome` VARCHAR(45) NOT NULL,
  `Armadura_Nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Habitante_Nome`, `Armadura_Nome`),
  INDEX `fk_Habitante_has_Armadura_Armadura1_idx` (`Armadura_Nome` ASC) VISIBLE,
  INDEX `fk_Habitante_has_Armadura_Habitante1_idx` (`Habitante_Nome` ASC) VISIBLE,
  CONSTRAINT `fk_Habitante_has_Armadura_Habitante1`
    FOREIGN KEY (`Habitante_Nome`)
    REFERENCES `SenhorDosAneis`.`Habitante` (`Nome`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Habitante_has_Armadura_Armadura1`
    FOREIGN KEY (`Armadura_Nome`)
    REFERENCES `SenhorDosAneis`.`Armadura` (`Nome`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SELECT h.nome,h.raça,h.idade,h.altura,im.nome,l.cidade FROM Habitante h JOIN Item_Magico im ON im.ID =  h.ID_Item JOIN Localizacao l ON l.ID = h.ID_Local;
SELECT * FROM Localizacao;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
