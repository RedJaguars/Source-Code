CREATE DATABASE  IF NOT EXISTS `celestra_database` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `celestra_database`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: celestra_database
-- ------------------------------------------------------
-- Server version	5.6.19-log

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
-- Table structure for table `alteration_order`
--

DROP TABLE IF EXISTS `alteration_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alteration_order` (
  `id_order` int(11) NOT NULL,
  `garment_type` varchar(45) NOT NULL,
  `special_instruction` varchar(45) DEFAULT NULL,
  `id_measurement` int(11) NOT NULL,
  PRIMARY KEY (`id_order`),
  CONSTRAINT `alter_measurement` FOREIGN KEY (`id_order`) REFERENCES `measurements` (`id_measurements`) ON UPDATE CASCADE,
  CONSTRAINT `alteration` FOREIGN KEY (`id_order`) REFERENCES `order` (`id_order`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alteration_order`
--

LOCK TABLES `alteration_order` WRITE;
/*!40000 ALTER TABLE `alteration_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `alteration_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clients` (
  `id_client` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(45) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `gender` varchar(45) NOT NULL,
  `contact_no` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_client`),
  UNIQUE KEY `id_client_UNIQUE` (`id_client`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `embroidery_order`
--

DROP TABLE IF EXISTS `embroidery_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `embroidery_order` (
  `id_order` int(11) NOT NULL,
  `logo` blob,
  `size` double NOT NULL,
  `num_of_colors` int(11) NOT NULL,
  `embroidery_type` varchar(45) DEFAULT NULL,
  `id_measurement` int(11) NOT NULL,
  PRIMARY KEY (`id_order`),
  UNIQUE KEY `id_order_UNIQUE` (`id_order`),
  KEY `embroid_measurement_idx` (`id_measurement`),
  CONSTRAINT `embroid_measurement` FOREIGN KEY (`id_measurement`) REFERENCES `measurements` (`id_measurements`) ON UPDATE CASCADE,
  CONSTRAINT `embroidery_order` FOREIGN KEY (`id_order`) REFERENCES `order` (`id_order`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `embroidery_order`
--

LOCK TABLES `embroidery_order` WRITE;
/*!40000 ALTER TABLE `embroidery_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `embroidery_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `garment_order`
--

DROP TABLE IF EXISTS `garment_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `garment_order` (
  `id_order` int(11) NOT NULL,
  `gender` varchar(45) NOT NULL,
  `material` varchar(45) DEFAULT NULL,
  `special_instruction` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_order`),
  UNIQUE KEY `id_order_UNIQUE` (`id_order`),
  CONSTRAINT `garment_order` FOREIGN KEY (`id_order`) REFERENCES `order` (`id_order`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `garment_order`
--

LOCK TABLES `garment_order` WRITE;
/*!40000 ALTER TABLE `garment_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `garment_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `measurements`
--

DROP TABLE IF EXISTS `measurements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `measurements` (
  `id_measurements` int(11) NOT NULL AUTO_INCREMENT,
  `upper_length` double DEFAULT NULL,
  `shoulder` double DEFAULT NULL,
  `chest` double DEFAULT NULL,
  `upper_waist` double DEFAULT NULL,
  `upper_hips` double DEFAULT NULL,
  `arm_length` double DEFAULT NULL,
  `arm_hole` double DEFAULT NULL,
  `back_figure` double DEFAULT NULL,
  `front_figure` double DEFAULT NULL,
  `front_chest` double DEFAULT NULL,
  `back_chest` double DEFAULT NULL,
  `bust_distance` double DEFAULT NULL,
  `bust_point` double DEFAULT NULL,
  `neck_deep` double DEFAULT NULL,
  `bottom_length` double DEFAULT NULL,
  `bottom_waist` double DEFAULT NULL,
  `bottom_hips` double DEFAULT NULL,
  `thigh` double DEFAULT NULL,
  `knee` double DEFAULT NULL,
  `buttom` double DEFAULT NULL,
  `crotch` double DEFAULT NULL,
  PRIMARY KEY (`id_measurements`),
  UNIQUE KEY `id_measurements_UNIQUE` (`id_measurements`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `measurements`
--

LOCK TABLES `measurements` WRITE;
/*!40000 ALTER TABLE `measurements` DISABLE KEYS */;
/*!40000 ALTER TABLE `measurements` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `id_order` int(11) NOT NULL AUTO_INCREMENT,
  `id_client` int(11) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `order_date` date NOT NULL,
  `due_date` date NOT NULL,
  `total_price` double NOT NULL,
  `balance` double NOT NULL,
  `pickup_location` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_order`),
  UNIQUE KEY `id_order_UNIQUE` (`id_order`),
  KEY `order_client_idx` (`id_client`),
  CONSTRAINT `order_client` FOREIGN KEY (`id_client`) REFERENCES `clients` (`id_client`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-03-09  6:37:57
