-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: melt2
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `items` (
  `itemId` int NOT NULL AUTO_INCREMENT,
  `itemTitle` varchar(40) DEFAULT NULL,
  `itemPrice` double DEFAULT NULL,
  `menuId` int DEFAULT NULL,
  PRIMARY KEY (`itemId`),
  KEY `menuId` (`menuId`),
  CONSTRAINT `items_ibfk_1` FOREIGN KEY (`menuId`) REFERENCES `itemlist` (`menuId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` VALUES (1,'Melt Chicken Burger',18,1),(2,'Classic Burger Double',25,1),(3,'Classic Burger Single',19,1),(4,'Spicy Classic Burger Single',20,1),(5,'Spicy Melt Chicken Burger',19,1),(6,'Classic Chicken Burger',17,1),(7,'Spicy Melt Burger Single',21,1),(8,'Spicy Classic Burger Double',26,1),(9,'Melt Burger Single',20,1),(10,'Melt Burger Double',27,1),(11,'Melt Mushroom Burger',24,1),(12,'Melt Caramelized Onion Burger',22,1),(13,'Spicy Melt Vegan Burger',20,1),(14,'Spicy Classic Chicken Burger',18,1),(15,'Spicy Melt Burger Double',28,1),(16,'Melt Vegan Burger',19,1),(17,'Melt Honey Musterd Sauce',2,2),(18,'Melt Cheese Sause',3,2),(19,'Melt Fire Sauce',1,2),(20,'Melt Ketchup',1,2),(21,'Melt Remolada Souce',1,2),(22,'Melt Home Souce',1,2),(23,'Melt Buffalo Sauce',2,2),(24,'Melt Garlic Sauce',1,2),(25,'Melt Sweet Chilli Sauce',1,2),(26,'Melt Teriyaki Sauce',1,2),(27,'Melt Cappy Orange Dring',4,3),(28,'Melt Fanta Draft',4,3),(29,'Melt Sprite Draft',4,3),(30,'Melt Coca Cola Draft',4,3),(31,'Melt Water',4,3),(32,'Melt Sprite Drink',4,3),(33,'Melt Fanta Drink',4,3),(34,'Melt Diet Coca Cola Drink',4,3),(35,'Melt Coca Cola Drink',4,3),(36,'Melt Diet Sprite Drink',4,3),(37,'Melt Cappy Mango Drink',4,3),(38,'Melt Coca Cola Zero Drink',4,3),(39,'Crinkle Fries',8,4),(40,'Premium Fries',10,4),(41,'Mex Premium and Sweet Potato Fries',11,4),(42,'Sweet Potato Fries',12,4),(43,'Buffalo Chicken Wings',24,5),(44,'Honey Musterd Chicken Wings',24,5),(45,'Popcorn Chicken',16,5),(46,'Danya',0,1);
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-06 19:47:30
