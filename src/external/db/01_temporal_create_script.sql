SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `SATP_DB` ;
CREATE SCHEMA IF NOT EXISTS `SATP_DB` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
SHOW WARNINGS;
USE `SATP_DB` ;

-- -----------------------------------------------------
-- Table `SATP_DB`.`AgrupacionPersonas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SATP_DB`.`AgrupacionPersonas` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `SATP_DB`.`AgrupacionPersonas` (
  `idAgrupacionPersonas` INT NOT NULL AUTO_INCREMENT ,
  `Nombre` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idAgrupacionPersonas`) )
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `SATP_DB`.`Entidad`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SATP_DB`.`Entidad` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `SATP_DB`.`Entidad` (
  `idEntidad` INT NOT NULL AUTO_INCREMENT ,
  `Rfc` VARCHAR(45) NULL ,
  PRIMARY KEY (`idEntidad`) )
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `SATP_DB`.`PersonaFisica`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SATP_DB`.`PersonaFisica` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `SATP_DB`.`PersonaFisica` (
  `idPersonaFisica` INT NOT NULL ,
  `Nombre` VARCHAR(45) NULL ,
  `ApellidoPaterno` VARCHAR(45) NULL ,
  `ApellidoMaterno` VARCHAR(45) NULL ,
  `FechaNacimiento` DATE NULL ,
  `idEntidad` INT NOT NULL ,
  PRIMARY KEY (`idPersonaFisica`) ,
  CONSTRAINT `fk_PersonaFisica_Entidad1`
    FOREIGN KEY (`idEntidad` )
    REFERENCES `SATP_DB`.`Entidad` (`idEntidad` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `SATP_DB`.`MiembroFisico`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SATP_DB`.`MiembroFisico` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `SATP_DB`.`MiembroFisico` (
  `idMiembroFisico` INT NOT NULL ,
  `Clave` VARCHAR(45) NULL ,
  `idAgrupacionPersonas` INT NOT NULL ,
  `idPersonaFisica` INT NOT NULL ,
  PRIMARY KEY (`idMiembroFisico`) ,
  CONSTRAINT `fk_MiembroFisico_AgrupacionPersonas1`
    FOREIGN KEY (`idAgrupacionPersonas` )
    REFERENCES `SATP_DB`.`AgrupacionPersonas` (`idAgrupacionPersonas` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_MiembroFisico_PersonaFisica1`
    FOREIGN KEY (`idPersonaFisica` )
    REFERENCES `SATP_DB`.`PersonaFisica` (`idPersonaFisica` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `SATP_DB`.`AdministadorRuta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SATP_DB`.`AdministadorRuta` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `SATP_DB`.`AdministadorRuta` (
  `idAdministadorRuta` INT NOT NULL AUTO_INCREMENT ,
  `idMiembroFisico` INT NOT NULL ,
  PRIMARY KEY (`idAdministadorRuta`) ,
  CONSTRAINT `fk_AdministadorRuta_MiembroFisico1`
    FOREIGN KEY (`idMiembroFisico` )
    REFERENCES `SATP_DB`.`MiembroFisico` (`idMiembroFisico` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `SATP_DB`.`Empresa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SATP_DB`.`Empresa` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `SATP_DB`.`Empresa` (
  `idEmpresa` INT NOT NULL ,
  `idAgrupacionPersonas` INT NOT NULL ,
  PRIMARY KEY (`idEmpresa`) ,
  CONSTRAINT `fk_Empresa_AgrupacionPersonas1`
    FOREIGN KEY (`idAgrupacionPersonas` )
    REFERENCES `SATP_DB`.`AgrupacionPersonas` (`idAgrupacionPersonas` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `SATP_DB`.`EmpresaRuta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SATP_DB`.`EmpresaRuta` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `SATP_DB`.`EmpresaRuta` (
  `idEmpresaRuta` INT NOT NULL ,
  `Nombre` VARCHAR(45) NOT NULL ,
  `idEmpresa` INT NOT NULL ,
  PRIMARY KEY (`idEmpresaRuta`) ,
  CONSTRAINT `fk_AgrupacionRuta_Empresa1`
    FOREIGN KEY (`idEmpresa` )
    REFERENCES `SATP_DB`.`Empresa` (`idEmpresa` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `SATP_DB`.`Concecionario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SATP_DB`.`Concecionario` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `SATP_DB`.`Concecionario` (
  `idConcecionario` INT NOT NULL ,
  `idMiembroFisico` INT NOT NULL ,
  PRIMARY KEY (`idConcecionario`) ,
  CONSTRAINT `fk_Concecionario_MiembroFisico1`
    FOREIGN KEY (`idMiembroFisico` )
    REFERENCES `SATP_DB`.`MiembroFisico` (`idMiembroFisico` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `SATP_DB`.`TipoMime`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SATP_DB`.`TipoMime` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `SATP_DB`.`TipoMime` (
  `idTipoMime` INT NOT NULL ,
  `Nombre` VARCHAR(45) NOT NULL ,
  `Descripcion` VARCHAR(45) NULL ,
  PRIMARY KEY (`idTipoMime`) )
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `SATP_DB`.`TipoArchivo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SATP_DB`.`TipoArchivo` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `SATP_DB`.`TipoArchivo` (
  `idTipoArchivo` INT NOT NULL ,
  `Nombre` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idTipoArchivo`) )
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `SATP_DB`.`Archivo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SATP_DB`.`Archivo` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `SATP_DB`.`Archivo` (
  `idArchivo` INT NOT NULL AUTO_INCREMENT ,
  `Nombre` VARCHAR(45) NOT NULL ,
  `Descripcion` VARCHAR(45) NULL ,
  `Dato` BLOB NOT NULL ,
  `idTipoMime` INT NOT NULL ,
  `idEntidad` INT NOT NULL ,
  `FechaCreacion` DATE NOT NULL ,
  `FechaModificacion` DATE NULL ,
  `idTipoArchivo` INT NOT NULL ,
  PRIMARY KEY (`idArchivo`) ,
  CONSTRAINT `fk_Archivo_TipoMime1`
    FOREIGN KEY (`idTipoMime` )
    REFERENCES `SATP_DB`.`TipoMime` (`idTipoMime` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Archivo_Entidad1`
    FOREIGN KEY (`idEntidad` )
    REFERENCES `SATP_DB`.`Entidad` (`idEntidad` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Archivo_TipoArchivo1`
    FOREIGN KEY (`idTipoArchivo` )
    REFERENCES `SATP_DB`.`TipoArchivo` (`idTipoArchivo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `SATP_DB`.`TipoPlaca`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SATP_DB`.`TipoPlaca` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `SATP_DB`.`TipoPlaca` (
  `idTipoPlaca` INT NOT NULL ,
  `Nombre` VARCHAR(45) NULL ,
  PRIMARY KEY (`idTipoPlaca`) )
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `SATP_DB`.`Placa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SATP_DB`.`Placa` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `SATP_DB`.`Placa` (
  `idPlaca` INT NOT NULL ,
  `NumeroPlaca` VARCHAR(45) NULL ,
  `idTipoPlaca` INT NOT NULL ,
  PRIMARY KEY (`idPlaca`) ,
  CONSTRAINT `fk_Placa_TipoPlaca1`
    FOREIGN KEY (`idTipoPlaca` )
    REFERENCES `SATP_DB`.`TipoPlaca` (`idTipoPlaca` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `SATP_DB`.`Chofer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SATP_DB`.`Chofer` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `SATP_DB`.`Chofer` (
  `idChofer` INT NOT NULL ,
  `idMiembroFisico` INT NOT NULL ,
  PRIMARY KEY (`idChofer`) ,
  CONSTRAINT `fk_Chofer_MiembroFisico1`
    FOREIGN KEY (`idMiembroFisico` )
    REFERENCES `SATP_DB`.`MiembroFisico` (`idMiembroFisico` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `SATP_DB`.`AdministradorMaster`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SATP_DB`.`AdministradorMaster` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `SATP_DB`.`AdministradorMaster` (
  `idAdministradorMaster` INT NOT NULL AUTO_INCREMENT ,
  `idMiembroFisico` INT NOT NULL ,
  PRIMARY KEY (`idAdministradorMaster`) ,
  CONSTRAINT `fk_AdministradorMaster_MiembroFisico1`
    FOREIGN KEY (`idMiembroFisico` )
    REFERENCES `SATP_DB`.`MiembroFisico` (`idMiembroFisico` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `SATP_DB`.`ParametroGlobal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SATP_DB`.`ParametroGlobal` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `SATP_DB`.`ParametroGlobal` (
  `idParametroGlobal` INT NOT NULL ,
  `Nombre` VARCHAR(45) NULL ,
  `Valor` VARCHAR(45) NULL ,
  PRIMARY KEY (`idParametroGlobal`) )
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `SATP_DB`.`TipoDireccion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SATP_DB`.`TipoDireccion` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `SATP_DB`.`TipoDireccion` (
  `idTipoDireccion` INT NOT NULL ,
  `NombreTipo` VARCHAR(45) NULL ,
  PRIMARY KEY (`idTipoDireccion`) )
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `SATP_DB`.`Pais`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SATP_DB`.`Pais` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `SATP_DB`.`Pais` (
  `idPais` INT NOT NULL ,
  `Clave` VARCHAR(45) NULL ,
  `Nombre` VARCHAR(45) NULL ,
  `Abreviatura` VARCHAR(45) NULL ,
  PRIMARY KEY (`idPais`) )
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `SATP_DB`.`Estado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SATP_DB`.`Estado` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `SATP_DB`.`Estado` (
  `idEstado` INT NOT NULL ,
  `Clave` VARCHAR(45) NULL ,
  `Nombre` VARCHAR(45) NULL ,
  `Abreviatura` VARCHAR(45) NULL ,
  `idPais` INT NOT NULL ,
  PRIMARY KEY (`idEstado`) ,
  CONSTRAINT `fk_Estado_Pais`
    FOREIGN KEY (`idPais` )
    REFERENCES `SATP_DB`.`Pais` (`idPais` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `SATP_DB`.`Direccion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SATP_DB`.`Direccion` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `SATP_DB`.`Direccion` (
  `idDireccion` INT NOT NULL ,
  `idTipoDireccion` INT NOT NULL ,
  `Calle` VARCHAR(45) NULL ,
  `NumeroExterior` VARCHAR(45) NULL ,
  `NumeroInterior` VARCHAR(45) NULL ,
  `CodigoPostal` VARCHAR(45) NULL ,
  `CiudadDelegacionMunicipio` VARCHAR(45) NULL ,
  `Colonia` VARCHAR(45) NULL ,
  `Comentario` VARCHAR(45) NULL ,
  `idEntidad` INT NOT NULL ,
  `idEstado` INT NOT NULL ,
  PRIMARY KEY (`idDireccion`) ,
  CONSTRAINT `fk_Direccion_TipoDireccion1`
    FOREIGN KEY (`idTipoDireccion` )
    REFERENCES `SATP_DB`.`TipoDireccion` (`idTipoDireccion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Direccion_Entidad1`
    FOREIGN KEY (`idEntidad` )
    REFERENCES `SATP_DB`.`Entidad` (`idEntidad` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Direccion_Estado1`
    FOREIGN KEY (`idEstado` )
    REFERENCES `SATP_DB`.`Estado` (`idEstado` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `SATP_DB`.`TipoTelefono`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SATP_DB`.`TipoTelefono` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `SATP_DB`.`TipoTelefono` (
  `idTipoTelefono` INT NOT NULL ,
  `Nombre` VARCHAR(45) NULL ,
  PRIMARY KEY (`idTipoTelefono`) )
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `SATP_DB`.`Telefono`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SATP_DB`.`Telefono` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `SATP_DB`.`Telefono` (
  `idTelefono` INT NOT NULL AUTO_INCREMENT ,
  `Numero` VARCHAR(45) NOT NULL ,
  `idTipoTelefono` INT NOT NULL ,
  `idEntidad` INT NOT NULL ,
  `Comentario` VARCHAR(45) NULL ,
  PRIMARY KEY (`idTelefono`) ,
  CONSTRAINT `fk_Telefono_TipoTelefono1`
    FOREIGN KEY (`idTipoTelefono` )
    REFERENCES `SATP_DB`.`TipoTelefono` (`idTipoTelefono` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Telefono_Entidad1`
    FOREIGN KEY (`idEntidad` )
    REFERENCES `SATP_DB`.`Entidad` (`idEntidad` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `SATP_DB`.`Ciudad`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SATP_DB`.`Ciudad` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `SATP_DB`.`Ciudad` (
  `idCiudad` INT NOT NULL ,
  `Clave` VARCHAR(45) NULL ,
  `Nombre` VARCHAR(45) NULL ,
  `idEstado` INT NOT NULL ,
  PRIMARY KEY (`idCiudad`) ,
  CONSTRAINT `fk_Ciudad_Estado1`
    FOREIGN KEY (`idEstado` )
    REFERENCES `SATP_DB`.`Estado` (`idEstado` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `SATP_DB`.`Colonia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SATP_DB`.`Colonia` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `SATP_DB`.`Colonia` (
  `idColonia` INT NOT NULL ,
  `Clave` VARCHAR(45) NULL ,
  `Nombre` VARCHAR(45) NULL ,
  `idCiudad` INT NOT NULL ,
  PRIMARY KEY (`idColonia`) ,
  CONSTRAINT `fk_Colonia_Ciudad1`
    FOREIGN KEY (`idCiudad` )
    REFERENCES `SATP_DB`.`Ciudad` (`idCiudad` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `SATP_DB`.`PersonaMoral`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SATP_DB`.`PersonaMoral` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `SATP_DB`.`PersonaMoral` (
  `idPersonaMoral` INT NOT NULL AUTO_INCREMENT ,
  `RazonSocial` VARCHAR(45) NULL ,
  `idEntidadFiscal` INT NOT NULL ,
  `idAgrupacionPersonas` INT NOT NULL ,
  PRIMARY KEY (`idPersonaMoral`) ,
  CONSTRAINT `fk_PersonaMoral_EntidadFiscal1`
    FOREIGN KEY (`idEntidadFiscal` )
    REFERENCES `SATP_DB`.`Entidad` (`idEntidad` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PersonaMoral_AgrupacionPersonas1`
    FOREIGN KEY (`idAgrupacionPersonas` )
    REFERENCES `SATP_DB`.`AgrupacionPersonas` (`idAgrupacionPersonas` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `SATP_DB`.`TipoLicenciaConducir`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SATP_DB`.`TipoLicenciaConducir` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `SATP_DB`.`TipoLicenciaConducir` (
  `idTipoLicenciaConducir` INT NOT NULL AUTO_INCREMENT ,
  `Nombre` VARCHAR(45) NULL ,
  PRIMARY KEY (`idTipoLicenciaConducir`) )
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `SATP_DB`.`LicenciaConducir`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SATP_DB`.`LicenciaConducir` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `SATP_DB`.`LicenciaConducir` (
  `idLicenciaConducir` INT NOT NULL AUTO_INCREMENT ,
  `clave` VARCHAR(45) NULL ,
  `idChofer` INT NOT NULL ,
  `idTipoLicenciaConducir` INT NOT NULL ,
  PRIMARY KEY (`idLicenciaConducir`) ,
  CONSTRAINT `fk_LicenciaConducir_Chofer1`
    FOREIGN KEY (`idChofer` )
    REFERENCES `SATP_DB`.`Chofer` (`idChofer` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_LicenciaConducir_TipoLicenciaConducir1`
    FOREIGN KEY (`idTipoLicenciaConducir` )
    REFERENCES `SATP_DB`.`TipoLicenciaConducir` (`idTipoLicenciaConducir` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `SATP_DB`.`EstatusLicenciaConducir`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SATP_DB`.`EstatusLicenciaConducir` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `SATP_DB`.`EstatusLicenciaConducir` (
  `idEstatusLicenciaConducir` INT NOT NULL ,
  `Nombre` VARCHAR(45) NULL ,
  PRIMARY KEY (`idEstatusLicenciaConducir`) )
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `SATP_DB`.`RenovacionLicenciaConducir`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SATP_DB`.`RenovacionLicenciaConducir` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `SATP_DB`.`RenovacionLicenciaConducir` (
  `idRenovacionLicenciaConducir` INT NOT NULL AUTO_INCREMENT ,
  `idLicenciaConducir` INT NOT NULL ,
  `FechaInicio` DATE NULL ,
  `FechaFin` DATE NULL ,
  `idEstatusLicenciaConducir` INT NOT NULL ,
  PRIMARY KEY (`idRenovacionLicenciaConducir`) ,
  CONSTRAINT `fk_RenovacionLicenciaConducir_LicenciaConducir1`
    FOREIGN KEY (`idLicenciaConducir` )
    REFERENCES `SATP_DB`.`LicenciaConducir` (`idLicenciaConducir` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_RenovacionLicenciaConducir_EstatusLicenciaConducir1`
    FOREIGN KEY (`idEstatusLicenciaConducir` )
    REFERENCES `SATP_DB`.`EstatusLicenciaConducir` (`idEstatusLicenciaConducir` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
