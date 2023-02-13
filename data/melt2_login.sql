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
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `loginId` int NOT NULL,
  `loginDate` date DEFAULT NULL,
  `userId` int DEFAULT NULL,
  PRIMARY KEY (`loginId`),
  KEY `login_ibfk_1` (`userId`),
  CONSTRAINT `login_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'2000-02-15',1),(2,'2000-02-15',1),(3,'2000-02-17',1),(4,'2000-02-17',1),(5,'2000-02-17',1),(6,'2000-02-17',1),(7,'2000-02-17',1),(8,'2000-02-17',1),(9,'2000-02-17',1),(10,'2000-02-17',1),(11,'2000-02-17',1),(12,'2000-02-17',1),(13,'2000-02-17',1),(14,'2000-02-17',1),(15,'2000-02-17',1),(16,'2000-02-15',1),(17,'2000-02-15',1),(18,'2000-02-15',1),(19,'2000-02-15',1),(20,'2000-02-15',1),(21,'2000-02-17',1),(22,'2000-02-18',1),(23,'2000-02-18',1),(24,'2000-02-19',1),(25,'2000-02-20',1),(26,'2000-02-20',1),(27,'2000-02-20',1),(28,'2000-02-20',1),(29,'2000-02-20',1),(30,'2000-02-20',1),(31,'2000-02-20',1),(32,'2000-02-20',1),(33,'2000-02-20',1),(34,'2000-02-20',1),(35,'2000-02-20',1),(36,'2000-02-20',1),(37,'2000-02-20',1),(38,'2000-02-20',1),(39,'2000-02-20',1),(40,'2000-02-20',1),(41,'2000-02-20',1),(42,'2000-02-20',1),(43,'2000-02-20',1),(44,'2000-02-20',1),(45,'2000-02-20',1),(46,'2000-02-20',1),(47,'2000-02-20',1),(48,'2000-02-20',1),(49,'2000-02-20',1),(50,'2000-02-20',1),(51,'2000-02-20',2),(52,'2000-02-14',1),(53,'2000-02-14',1),(54,'2000-02-14',1),(55,'2000-02-14',1),(56,'2000-02-14',1),(57,'2000-02-14',1),(58,'2000-02-14',1),(59,'2000-02-14',1),(60,'2000-02-14',1),(61,'2000-02-14',1),(62,'2000-02-15',1),(63,'2000-02-15',1),(64,'2000-02-15',1),(65,'2000-02-15',1),(66,'2000-02-15',1),(67,'2000-02-15',1);
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
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