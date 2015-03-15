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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `accountID` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`accountID`),
  UNIQUE KEY `accountID_UNIQUE` (`accountID`),
  UNIQUE KEY `password_UNIQUE` (`password`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alteration_order`
--

DROP TABLE IF EXISTS `alteration_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alteration_order` (
  `orderID` int(11) NOT NULL,
  `garmentType` varchar(45) NOT NULL,
  `specialInstruction` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`orderID`),
  CONSTRAINT `alteration` FOREIGN KEY (`orderID`) REFERENCES `order_item` (`orderID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alteration_order`
--

LOCK TABLES `alteration_order` WRITE;
/*!40000 ALTER TABLE `alteration_order` DISABLE KEYS */;
INSERT INTO `alteration_order` VALUES (32,'SKIRT','I want it shorter than my short shorts');
/*!40000 ALTER TABLE `alteration_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bottom_measure`
--

DROP TABLE IF EXISTS `bottom_measure`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bottom_measure` (
  `measurementID` int(11) NOT NULL,
  `bottomLength` double NOT NULL,
  `waist` double NOT NULL,
  `hips` double NOT NULL,
  `thigh` double NOT NULL,
  `knee` double NOT NULL,
  `buttom` double NOT NULL,
  `crotch` double NOT NULL,
  PRIMARY KEY (`measurementID`),
  UNIQUE KEY `measurementID_UNIQUE` (`measurementID`),
  CONSTRAINT `bottomMeasure` FOREIGN KEY (`measurementID`) REFERENCES `measurements` (`measurementsID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bottom_measure`
--

LOCK TABLES `bottom_measure` WRITE;
/*!40000 ALTER TABLE `bottom_measure` DISABLE KEYS */;
/*!40000 ALTER TABLE `bottom_measure` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clients` (
  `clientID` int(11) NOT NULL AUTO_INCREMENT,
  `lastName` varchar(45) NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `gender` varchar(45) NOT NULL,
  `contactNo` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`clientID`),
  UNIQUE KEY `id_client_UNIQUE` (`clientID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES (1,'Cardano','Marc Daniel','MALE','09983413882','marccardano@gmail.com'),(2,'Lozano','Rafael ','MALE','09431322882','rafaellozano@gmail.com'),(3,'Marasigan','Olivia Mae','FEMALE','09277187822','oliviamae@yahoo.com');
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `embroidery_order`
--

DROP TABLE IF EXISTS `embroidery_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `embroidery_order` (
  `orderID` int(11) NOT NULL,
  `logo` blob,
  `size` double NOT NULL,
  `numOfColors` int(11) NOT NULL,
  `embroideryType` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`orderID`),
  UNIQUE KEY `id_order_UNIQUE` (`orderID`),
  CONSTRAINT `embroidery` FOREIGN KEY (`orderID`) REFERENCES `order_item` (`orderID`) ON DELETE CASCADE ON UPDATE CASCADE
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
  `orderID` int(11) NOT NULL,
  `garmentType` varchar(45) NOT NULL,
  `gender` varchar(45) NOT NULL,
  `material` varchar(45) DEFAULT NULL,
  `special_instruction` varchar(45) DEFAULT NULL,
  `measurementID` int(11) NOT NULL,
  PRIMARY KEY (`orderID`),
  UNIQUE KEY `id_order_UNIQUE` (`orderID`),
  KEY `measurement_idx` (`measurementID`),
  CONSTRAINT `measurement` FOREIGN KEY (`measurementID`) REFERENCES `measurements` (`measurementsID`) ON UPDATE CASCADE,
  CONSTRAINT `garmentOrder` FOREIGN KEY (`orderID`) REFERENCES `order_item` (`orderID`) ON DELETE CASCADE ON UPDATE CASCADE
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
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventory` (
  `inventoryID` int(11) NOT NULL AUTO_INCREMENT,
  `inventoryName` varchar(45) NOT NULL,
  `quantityInStock` double NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  `unit` varchar(45) NOT NULL,
  PRIMARY KEY (`inventoryID`),
  UNIQUE KEY `inventoryID_UNIQUE` (`inventoryID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory`
--

LOCK TABLES `inventory` WRITE;
/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materials_used`
--

DROP TABLE IF EXISTS `materials_used`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `materials_used` (
  `materialID` int(11) NOT NULL AUTO_INCREMENT,
  `quantity` varchar(45) NOT NULL,
  `inventoryID` int(11) NOT NULL,
  `itemID` int(11) NOT NULL,
  PRIMARY KEY (`materialID`),
  UNIQUE KEY `materialID_UNIQUE` (`materialID`),
  KEY `inventory_idx` (`inventoryID`),
  KEY `order_assigned_idx` (`itemID`),
  CONSTRAINT `order_assigned` FOREIGN KEY (`itemID`) REFERENCES `order_item` (`orderID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `inventory` FOREIGN KEY (`inventoryID`) REFERENCES `inventory` (`inventoryID`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materials_used`
--

LOCK TABLES `materials_used` WRITE;
/*!40000 ALTER TABLE `materials_used` DISABLE KEYS */;
/*!40000 ALTER TABLE `materials_used` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `measurements`
--

DROP TABLE IF EXISTS `measurements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `measurements` (
  `measurementsID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`measurementsID`),
  UNIQUE KEY `id_measurements_UNIQUE` (`measurementsID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `measurements`
--

LOCK TABLES `measurements` WRITE;
/*!40000 ALTER TABLE `measurements` DISABLE KEYS */;
INSERT INTO `measurements` VALUES (4);
/*!40000 ALTER TABLE `measurements` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_item`
--

DROP TABLE IF EXISTS `order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_item` (
  `orderID` int(11) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) NOT NULL DEFAULT '1',
  `orderListID` int(11) NOT NULL,
  `itemPrice` double NOT NULL,
  PRIMARY KEY (`orderID`),
  UNIQUE KEY `orderID_UNIQUE` (`orderID`),
  KEY `orderList_idx` (`orderListID`),
  CONSTRAINT `orderList` FOREIGN KEY (`orderListID`) REFERENCES `order_list` (`orderListID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_item`
--

LOCK TABLES `order_item` WRITE;
/*!40000 ALTER TABLE `order_item` DISABLE KEYS */;
INSERT INTO `order_item` VALUES (32,45,35,190);
/*!40000 ALTER TABLE `order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_list`
--

DROP TABLE IF EXISTS `order_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_list` (
  `orderListID` int(11) NOT NULL AUTO_INCREMENT,
  `orderDate` varchar(45) NOT NULL,
  `dueDate` varchar(45) NOT NULL,
  `totalPrice` double NOT NULL,
  `balance` double NOT NULL,
  `pickupLocation` varchar(45) NOT NULL,
  `clientID` int(11) NOT NULL,
  `status` varchar(45) NOT NULL,
  `receiptNo` int(11) NOT NULL,
  PRIMARY KEY (`orderListID`),
  UNIQUE KEY `orderListID_UNIQUE` (`orderListID`),
  KEY `clients_idx` (`clientID`),
  CONSTRAINT `clients` FOREIGN KEY (`clientID`) REFERENCES `clients` (`clientID`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_list`
--

LOCK TABLES `order_list` WRITE;
/*!40000 ALTER TABLE `order_list` DISABLE KEYS */;
INSERT INTO `order_list` VALUES (35,'2015-03-15','2015-03-15',190,0,'The Beacon 3714',2,'PENDING',1001);
/*!40000 ALTER TABLE `order_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `top_measure`
--

DROP TABLE IF EXISTS `top_measure`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `top_measure` (
  `measurementID` int(11) NOT NULL,
  `upperLength` double NOT NULL,
  `shoulder` double NOT NULL,
  `armLength` double NOT NULL,
  `wrist` double NOT NULL,
  `armhole` double NOT NULL,
  `frontChest` double NOT NULL,
  `backChest` double NOT NULL,
  `waist` double NOT NULL,
  `hips` double NOT NULL,
  `neckDeep` double NOT NULL,
  PRIMARY KEY (`measurementID`),
  UNIQUE KEY `measurementID_UNIQUE` (`measurementID`),
  CONSTRAINT `topMeasure` FOREIGN KEY (`measurementID`) REFERENCES `measurements` (`measurementsID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `top_measure`
--

LOCK TABLES `top_measure` WRITE;
/*!40000 ALTER TABLE `top_measure` DISABLE KEYS */;
INSERT INTO `top_measure` VALUES (4,40,20,38,12,12,30,30,45,40,6);
/*!40000 ALTER TABLE `top_measure` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `women_top_measure`
--

DROP TABLE IF EXISTS `women_top_measure`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `women_top_measure` (
  `measurementID` int(11) NOT NULL,
  `frontFigure` double NOT NULL,
  `bustPoint` double NOT NULL,
  `bustDistance` double NOT NULL,
  `backFigure` double NOT NULL,
  PRIMARY KEY (`measurementID`),
  UNIQUE KEY `measurementID_UNIQUE` (`measurementID`),
  CONSTRAINT `womenMeasure` FOREIGN KEY (`measurementID`) REFERENCES `top_measure` (`measurementID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `women_top_measure`
--

LOCK TABLES `women_top_measure` WRITE;
/*!40000 ALTER TABLE `women_top_measure` DISABLE KEYS */;
/*!40000 ALTER TABLE `women_top_measure` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-03-15  9:06:10
