-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: pharmacie
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `medicamentprescrit`
--

DROP TABLE IF EXISTS `medicamentprescrit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicamentprescrit` (
  `idmedprescrit` int NOT NULL,
  `idcommande` int DEFAULT NULL,
  `qte` int DEFAULT NULL,
  `dure` date DEFAULT NULL,
  `idachat` int DEFAULT NULL,
  `nom` varchar(45) DEFAULT NULL,
  KEY `medachat_idx` (`idachat`),
  KEY `com` (`idcommande`),
  KEY `medp_idx` (`idmedprescrit`),
  CONSTRAINT `com` FOREIGN KEY (`idcommande`) REFERENCES `commande` (`idcommande`),
  CONSTRAINT `medachat` FOREIGN KEY (`idachat`) REFERENCES `achat` (`idachat`),
  CONSTRAINT `medp` FOREIGN KEY (`idmedprescrit`) REFERENCES `produit` (`idprod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicamentprescrit`
--

LOCK TABLES `medicamentprescrit` WRITE;
/*!40000 ALTER TABLE `medicamentprescrit` DISABLE KEYS */;
INSERT INTO `medicamentprescrit` VALUES (61,NULL,1,'2020-10-15',7,'sarokh'),(62,NULL,3,'2020-11-08',8,'lartan'),(61,NULL,1,'2020-11-08',8,'sarokh'),(65,NULL,10,'2020-10-21',9,'doliprane'),(59,NULL,10,'2020-10-31',10,'bavatte'),(61,3,200,'2020-10-06',NULL,'sarokh'),(59,NULL,12,'2020-10-31',11,'bavatte'),(60,NULL,1000,'2020-10-31',12,'couton'),(61,NULL,10,'2020-09-30',13,'sarokh'),(59,NULL,100,'2020-10-31',13,'bavatte'),(59,NULL,10,'2020-10-31',15,'bavatte'),(64,NULL,1,'2020-10-07',16,'hamra'),(65,NULL,10,'2020-10-07',19,'doliprane'),(64,4,1000,'2020-10-15',NULL,'hamra');
/*!40000 ALTER TABLE `medicamentprescrit` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-31 22:19:40
