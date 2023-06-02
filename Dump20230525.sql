-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: aps
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `comanda`
--

DROP TABLE IF EXISTS `comanda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comanda` (
  `cd_comanda` int NOT NULL AUTO_INCREMENT,
  `dt_comanda` timestamp NULL DEFAULT NULL,
  `cd_cultivo` int DEFAULT NULL,
  PRIMARY KEY (`cd_comanda`),
  KEY `FK_Comanda_2` (`cd_cultivo`),
  CONSTRAINT `FK_Comanda_2` FOREIGN KEY (`cd_cultivo`) REFERENCES `cultivo` (`cd_cultivo`) ON DELETE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comanda`
--

LOCK TABLES `comanda` WRITE;
/*!40000 ALTER TABLE `comanda` DISABLE KEYS */;
INSERT INTO `comanda` VALUES (1,'2023-05-22 18:40:20',1),(2,'2023-05-22 18:40:28',2),(3,'2023-05-22 18:40:37',3),(4,'2023-05-22 18:40:44',4);
/*!40000 ALTER TABLE `comanda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cultivo`
--

DROP TABLE IF EXISTS `cultivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cultivo` (
  `cd_cultivo` int NOT NULL AUTO_INCREMENT,
  `dt_inicio` timestamp NULL DEFAULT NULL,
  `dt_colheita` timestamp NULL DEFAULT NULL,
  `andamento` varchar(50) DEFAULT NULL,
  `cd_usuario` int DEFAULT NULL,
  `cd_produto` int DEFAULT NULL,
  `cd_talhao` int DEFAULT NULL,
  PRIMARY KEY (`cd_cultivo`),
  KEY `FK_Cultivo_2` (`cd_usuario`),
  KEY `FK_Cultivo_3` (`cd_produto`),
  KEY `FK_Cultivo_4` (`cd_talhao`),
  CONSTRAINT `FK_Cultivo_2` FOREIGN KEY (`cd_usuario`) REFERENCES `usuario` (`cd_usuario`) ON DELETE CASCADE,
  CONSTRAINT `FK_Cultivo_3` FOREIGN KEY (`cd_produto`) REFERENCES `produto` (`cd_produto`) ON DELETE RESTRICT,
  CONSTRAINT `FK_Cultivo_4` FOREIGN KEY (`cd_talhao`) REFERENCES `talhao` (`cd_talhao`) ON DELETE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cultivo`
--

LOCK TABLES `cultivo` WRITE;
/*!40000 ALTER TABLE `cultivo` DISABLE KEYS */;
INSERT INTO `cultivo` VALUES (1,'2023-05-22 17:16:25','2023-05-22 17:16:25','esperando',4,1,1),(2,'2023-05-22 17:16:35','2023-05-22 17:16:35','esperando',4,2,2),(3,'2023-05-22 17:52:12','2023-05-22 17:52:12','esperando',5,3,2),(4,'2023-05-22 17:55:47','2023-05-22 17:55:47','esperando',6,2,2),(5,'2023-05-22 19:38:48','2023-05-22 19:38:48','esperando',6,2,3),(6,'2023-05-22 19:40:09','2023-05-22 19:40:09','esperando',4,1,3);
/*!40000 ALTER TABLE `cultivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `endereco` (
  `cd_endereco` int NOT NULL AUTO_INCREMENT,
  `cep` varchar(9) DEFAULT NULL,
  `endereco` varchar(100) DEFAULT NULL,
  `bairro` varchar(100) DEFAULT NULL,
  `estado` varchar(30) DEFAULT NULL,
  `numero` int DEFAULT NULL,
  `complemento` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`cd_endereco`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` VALUES (1,'02859080','irinel voce nao sabe','sumiu','sao paulo',122,''),(2,'00000000','sao joao do mar','tragico','sao paulo',100,'condominio');
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entrega`
--

DROP TABLE IF EXISTS `entrega`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entrega` (
  `cd_entrega` int NOT NULL AUTO_INCREMENT,
  `dt_entrega` timestamp NULL DEFAULT NULL,
  `dt_baixa` timestamp NULL DEFAULT NULL,
  `cd_unidade` int DEFAULT NULL,
  `cd_comanda` int DEFAULT NULL,
  PRIMARY KEY (`cd_entrega`),
  KEY `FK_Entrega_2` (`cd_unidade`),
  KEY `FK_Entrega_3` (`cd_comanda`),
  CONSTRAINT `FK_Entrega_2` FOREIGN KEY (`cd_unidade`) REFERENCES `unidade` (`cd_unidade`) ON DELETE RESTRICT,
  CONSTRAINT `FK_Entrega_3` FOREIGN KEY (`cd_comanda`) REFERENCES `comanda` (`cd_comanda`) ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrega`
--

LOCK TABLES `entrega` WRITE;
/*!40000 ALTER TABLE `entrega` DISABLE KEYS */;
/*!40000 ALTER TABLE `entrega` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permissao`
--

DROP TABLE IF EXISTS `permissao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permissao` (
  `cd_permissao` int NOT NULL AUTO_INCREMENT,
  `nm_permissao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cd_permissao`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permissao`
--

LOCK TABLES `permissao` WRITE;
/*!40000 ALTER TABLE `permissao` DISABLE KEYS */;
INSERT INTO `permissao` VALUES (9,'Entregador'),(10,'Produtor'),(11,'Administrador');
/*!40000 ALTER TABLE `permissao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produto` (
  `cd_produto` int NOT NULL AUTO_INCREMENT,
  `nm_produto` varchar(45) DEFAULT NULL,
  `valor` decimal(10,2) DEFAULT NULL,
  `ativo` char(1) DEFAULT NULL,
  `qtde` int DEFAULT NULL,
  PRIMARY KEY (`cd_produto`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (1,'Tomate',2.00,'1',10),(2,'Alface',0.80,'1',4),(3,'Cenora',3.00,'1',13),(4,'Cebola',0.50,'1',2),(5,'Colve',0.70,'1',20),(6,'Beteraba',4.00,'1',7),(7,'Pipino',2.00,'0',6);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `talhao`
--

DROP TABLE IF EXISTS `talhao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `talhao` (
  `cd_talhao` int NOT NULL AUTO_INCREMENT,
  `nm_talhao` varchar(45) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  PRIMARY KEY (`cd_talhao`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `talhao`
--

LOCK TABLES `talhao` WRITE;
/*!40000 ALTER TABLE `talhao` DISABLE KEYS */;
INSERT INTO `talhao` VALUES (1,'Principal','1'),(2,'Secundario','0'),(3,'Auxiliar','0'),(4,'Substituto','1'),(5,'contigencia','1');
/*!40000 ALTER TABLE `talhao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unidade`
--

DROP TABLE IF EXISTS `unidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unidade` (
  `cd_unidade` int NOT NULL AUTO_INCREMENT,
  `ativo` char(1) DEFAULT NULL,
  `nm_unidade` varchar(45) DEFAULT NULL,
  `cd_usuario` int DEFAULT NULL,
  `cd_endereco` int DEFAULT NULL,
  PRIMARY KEY (`cd_unidade`),
  KEY `FK_Unidade_2` (`cd_usuario`),
  KEY `FK_Unidade_3` (`cd_endereco`),
  CONSTRAINT `FK_Unidade_2` FOREIGN KEY (`cd_usuario`) REFERENCES `usuario` (`cd_usuario`) ON DELETE RESTRICT,
  CONSTRAINT `FK_Unidade_3` FOREIGN KEY (`cd_endereco`) REFERENCES `endereco` (`cd_endereco`) ON DELETE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidade`
--

LOCK TABLES `unidade` WRITE;
/*!40000 ALTER TABLE `unidade` DISABLE KEYS */;
INSERT INTO `unidade` VALUES (1,'1','power entrega',3,2),(2,'1','auxilio entrega',2,1);
/*!40000 ALTER TABLE `unidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `cd_usuario` int NOT NULL AUTO_INCREMENT,
  `nome_usuario` varchar(100) DEFAULT NULL,
  `nm_acesso` varchar(45) DEFAULT NULL,
  `senha` varchar(32) DEFAULT NULL,
  `cd_permissao` int DEFAULT NULL,
  PRIMARY KEY (`cd_usuario`),
  KEY `FK_Usuario_2` (`cd_permissao`),
  CONSTRAINT `FK_Usuario_2` FOREIGN KEY (`cd_permissao`) REFERENCES `permissao` (`cd_permissao`) ON DELETE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (2,'andre','admin_andre','12346',11),(3,'entregador_1','entregador','111111',9),(4,'produtor_1','produtor','222222',10),(5,'produtor_2','produtor_2','222222',10),(6,'produtor_3','produtor_3','222222',10);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-25 11:14:50
