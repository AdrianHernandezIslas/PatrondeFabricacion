-- MySQL dump 10.13  Distrib 5.7.29, for Linux (x86_64)
--
-- Host: localhost    Database: tec
-- ------------------------------------------------------
-- Server version	5.7.29-0ubuntu0.18.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumno` (
  `nControl` int(4) NOT NULL,
  `nombre` varchar(80) NOT NULL,
  `sexo` varchar(1) NOT NULL,
  `edad` int(2) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `carrera` varchar(70) NOT NULL,
  `semestre` int(2) NOT NULL,
  `creditos` int(2) NOT NULL,
  `calificacion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`nControl`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES (10,'Adrian Hernandez Islas','M',23,'13 de Septiembre Exmarquezado','Ing. Sistemas',8,70,'100'),(11,'Daniel Lopez','M',25,'Simbolos 313, Centro, Oaxaca','Ing. Mecanica',1,1,'70'),(12,'Mariela Soriano','F',21,'Niños Heroes 10, Volcanes','Ing. Civil',4,5,'97'),(13,'Ivan Toro Rodriguez','M',25,'Centro s/n, Oaxaca de Juarez','Ing. Sistemas',8,30,'91'),(14,'Magnolia Gonzales','F',15,'Conocido sin numero','Ing. Mecanica',1,3,'70'),(15,'Sol perez','F',15,'Concido','Ing. Sistemas',1,1,'89');
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-07 15:43:19
