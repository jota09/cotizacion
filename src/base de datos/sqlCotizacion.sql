/*
SQLyog Ultimate v11.11 (32 bit)
MySQL - 5.7.11 : Database - cotizacion
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`cotizacion` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `cotizacion`;

/*Table structure for table `egreso` */

DROP TABLE IF EXISTS `egreso`;

CREATE TABLE `egreso` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identificador` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `valor` int(11) NOT NULL,
  `descripcion` varchar(150) CHARACTER SET latin1 DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  `activo` tinyint(1) DEFAULT '1',
  `eliminado` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_egreso_identificador_egreso1_idx` (`identificador`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `egreso` */

insert  into `egreso`(`id`,`identificador`,`nombre`,`valor`,`descripcion`,`fecha_inicio`,`fecha_fin`,`activo`,`eliminado`) values (1,1,'Electricidad',16700,'Pago asociado al servicio electrico del apto','2017-01-07',NULL,1,0),(2,1,'Agua',45000,'Pago asociado al servicio de agua en el apto','2017-01-15',NULL,1,0);

/*Table structure for table `identificador_egreso` */

DROP TABLE IF EXISTS `identificador_egreso`;

CREATE TABLE `identificador_egreso` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identificador` varchar(45) CHARACTER SET latin1 NOT NULL,
  `decripcion` varchar(150) CHARACTER SET latin1 NOT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT '1',
  `eliminado` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `identificador_egreso` */

insert  into `identificador_egreso`(`id`,`identificador`,`decripcion`,`activo`,`eliminado`) values (1,'SP','Pago de Servicio Publico',1,0);

/*Table structure for table `identificador_ingreso` */

DROP TABLE IF EXISTS `identificador_ingreso`;

CREATE TABLE `identificador_ingreso` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identificador` varchar(45) CHARACTER SET latin1 NOT NULL,
  `descripcion` varchar(150) CHARACTER SET latin1 NOT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT '1',
  `eliminado` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `identificador_ingreso` */

insert  into `identificador_ingreso`(`id`,`identificador`,`descripcion`,`activo`,`eliminado`) values (1,'S','Pago del Salario HMT',1,0);

/*Table structure for table `ingreso` */

DROP TABLE IF EXISTS `ingreso`;

CREATE TABLE `ingreso` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identificador` varchar(45) CHARACTER SET latin1 NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `valor` int(11) NOT NULL,
  `descripcion` varchar(150) CHARACTER SET latin1 DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  `activo` tinyint(1) DEFAULT '1',
  `eliminado` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_ingreso_identificador_idx` (`identificador`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `ingreso` */

insert  into `ingreso`(`id`,`identificador`,`nombre`,`valor`,`descripcion`,`fecha_inicio`,`fecha_fin`,`activo`,`eliminado`) values (1,'1','Salario',1600000,'Salario recibido por HMT','2017-01-07',NULL,1,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
