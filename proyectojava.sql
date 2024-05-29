CREATE DATABASE  IF NOT EXISTS `proyectojava` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `proyectojava`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: proyectojava
-- ------------------------------------------------------
-- Server version	8.0.37

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
-- Table structure for table `envio`
--

DROP TABLE IF EXISTS `envio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `envio` (
  `idEnvio` int NOT NULL,
  `idPaquete` int NOT NULL,
  `idTrabajador` int NOT NULL,
  PRIMARY KEY (`idEnvio`),
  KEY `idPaquete_idx` (`idPaquete`),
  KEY `idTrabajador_idx` (`idTrabajador`),
  CONSTRAINT `idPaquete` FOREIGN KEY (`idPaquete`) REFERENCES `paquete` (`idPaquete`),
  CONSTRAINT `idTrabajador` FOREIGN KEY (`idTrabajador`) REFERENCES `trabajadores` (`idTrabajadores`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `envio`
--

LOCK TABLES `envio` WRITE;
/*!40000 ALTER TABLE `envio` DISABLE KEYS */;
INSERT INTO `envio` VALUES (1,2,3),(2,1,3),(3,3,4),(4,4,3);
/*!40000 ALTER TABLE `envio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `envio_historico`
--

DROP TABLE IF EXISTS `envio_historico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `envio_historico` (
  `idEnvio` int NOT NULL,
  `idPaquete` int NOT NULL,
  `idTrabajador` int NOT NULL,
  PRIMARY KEY (`idEnvio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `envio_historico`
--

LOCK TABLES `envio_historico` WRITE;
/*!40000 ALTER TABLE `envio_historico` DISABLE KEYS */;
INSERT INTO `envio_historico` VALUES (1,2,3),(2,1,3),(3,3,4),(4,4,3);
/*!40000 ALTER TABLE `envio_historico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paquete`
--

DROP TABLE IF EXISTS `paquete`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paquete` (
  `idPaquete` int NOT NULL,
  `nombrePaquete` varchar(45) NOT NULL,
  `pesoPaquete` float NOT NULL,
  PRIMARY KEY (`idPaquete`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paquete`
--

LOCK TABLES `paquete` WRITE;
/*!40000 ALTER TABLE `paquete` DISABLE KEYS */;
INSERT INTO `paquete` VALUES (1,'Lampara',2),(2,'Sofa',100),(3,'Cama',30),(4,'Ordenador',10),(5,'Teclado',10),(6,'Sebastian',80);
/*!40000 ALTER TABLE `paquete` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trabajadores`
--

DROP TABLE IF EXISTS `trabajadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trabajadores` (
  `idTrabajadores` int NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `cargo` tinyint DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTrabajadores`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trabajadores`
--

LOCK TABLES `trabajadores` WRITE;
/*!40000 ALTER TABLE `trabajadores` DISABLE KEYS */;
INSERT INTO `trabajadores` VALUES (1,'Daniel','Luru',1,'1234'),(2,'Sebastian','Manrique',1,'1234'),(3,'Tymur','Kulivar',0,'1256'),(4,'Ignacio','Delgado',0,'1256'),(5,'Sergio','Torres',0,'123456'),(12,'Dani','Jorgiño',1,'999'),(45,NULL,NULL,NULL,NULL),(66,NULL,NULL,NULL,NULL),(467,NULL,NULL,NULL,NULL),(536,NULL,NULL,NULL,NULL),(1234,'gasdg','asrghqae',0,'asedfgaw'),(2345,NULL,NULL,NULL,NULL),(3456,NULL,NULL,NULL,NULL),(4672,NULL,NULL,NULL,NULL),(5245,NULL,NULL,NULL,NULL),(21345,'asga','asgqawrg',0,'aseg'),(23456,NULL,NULL,NULL,NULL),(364537,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `trabajadores` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-29  3:26:52
