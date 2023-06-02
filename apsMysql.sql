CREATE DATABASE  IF NOT EXISTS `coopgreen` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `coopgreen`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: coopgreen
-- ------------------------------------------------------
-- Server version	5.7.38-log

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
-- Table structure for table `comanda`
--

DROP TABLE IF EXISTS `comanda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comanda` (
  `cd_comanda` int(11) NOT NULL AUTO_INCREMENT,
  `cd_cultivo` int(11) NOT NULL,
  `dt_comanda` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`cd_comanda`),
  KEY `fk_comanda_cultivo1_idx` (`cd_cultivo`),
  CONSTRAINT `fk_comanda_cultivo1` FOREIGN KEY (`cd_cultivo`) REFERENCES `cultivo` (`cd_cultivo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comanda`
--

LOCK TABLES `comanda` WRITE;
/*!40000 ALTER TABLE `comanda` DISABLE KEYS */;
/*!40000 ALTER TABLE `comanda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cultivo`
--

DROP TABLE IF EXISTS `cultivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cultivo` (
  `cd_cultivo` int(11) NOT NULL AUTO_INCREMENT,
  `cd_talhao` int(11) NOT NULL,
  `cd_produto` int(11) NOT NULL,
  `cd_responsavel` int(11) NOT NULL COMMENT 'Usuario responsável pela administração da produção',
  `dt_inicio` datetime DEFAULT NULL,
  `dt_colheita` datetime DEFAULT NULL,
  `andamento` varchar(50) DEFAULT NULL COMMENT 'Aqui sera controlado o andamento da colheira\nEM PLANTIO\nPRONTO PARA COLETA\nCOLHIDA',
  PRIMARY KEY (`cd_cultivo`),
  KEY `fk_cultivo_talhao_idx` (`cd_talhao`),
  KEY `fk_cultivo_produto1_idx` (`cd_produto`),
  KEY `fk_cultivo_usuario1_idx` (`cd_responsavel`),
  CONSTRAINT `fk_cultivo_produto1` FOREIGN KEY (`cd_produto`) REFERENCES `produto` (`cd_produto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cultivo_talhao` FOREIGN KEY (`cd_talhao`) REFERENCES `talhao` (`cd_talhao`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cultivo_usuario1` FOREIGN KEY (`cd_responsavel`) REFERENCES `usuario` (`cd_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cultivo`
--

LOCK TABLES `cultivo` WRITE;
/*!40000 ALTER TABLE `cultivo` DISABLE KEYS */;
/*!40000 ALTER TABLE `cultivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `endereco` (
  `cd_endereco` int(11) NOT NULL AUTO_INCREMENT,
  `cep` varchar(9) DEFAULT NULL,
  `endereco` varchar(100) DEFAULT NULL,
  `bairo` varchar(100) DEFAULT NULL,
  `estado` varchar(100) DEFAULT NULL,
  `numero` float DEFAULT NULL,
  `complemento` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`cd_endereco`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
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
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entrega` (
  `cd_entrega` int(11) NOT NULL AUTO_INCREMENT,
  `cd_comanda` int(11) NOT NULL,
  `dt_entrega` datetime DEFAULT NULL,
  `dt_baixa` datetime DEFAULT NULL,
  `cd_unidade` int(11) NOT NULL,
  PRIMARY KEY (`cd_entrega`),
  KEY `fk_entrega_comanda1_idx` (`cd_comanda`),
  KEY `fk_entrega_unidade1_idx` (`cd_unidade`),
  CONSTRAINT `fk_entrega_comanda1` FOREIGN KEY (`cd_comanda`) REFERENCES `comanda` (`cd_comanda`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_entrega_unidade1` FOREIGN KEY (`cd_unidade`) REFERENCES `unidade` (`cd_unidade`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permissao` (
  `cd_permissao` int(11) NOT NULL AUTO_INCREMENT,
  `nm_permissao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cd_permissao`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permissao`
--

LOCK TABLES `permissao` WRITE;
/*!40000 ALTER TABLE `permissao` DISABLE KEYS */;
INSERT INTO `permissao` VALUES (9,'Entregador'),(10,'Produtor'),(11,'Administrador'),(12,'Parceiro');
/*!40000 ALTER TABLE `permissao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produto` (
  `cd_produto` int(11) NOT NULL AUTO_INCREMENT,
  `nm_produto` varchar(45) DEFAULT NULL,
  `valor` decimal(8,2) DEFAULT NULL,
  `ativo` char(1) DEFAULT NULL,
  `qtde` int(11) DEFAULT NULL,
  PRIMARY KEY (`cd_produto`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (1,'Tomate',5.00,'1',10),(2,'Maçã',10.00,'0',200);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `talhao`
--

DROP TABLE IF EXISTS `talhao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `talhao` (
  `cd_talhao` int(11) NOT NULL AUTO_INCREMENT,
  `nm_talhao` varchar(45) DEFAULT NULL,
  `status` char(1) DEFAULT NULL COMMENT 'Para verificar se o talhao esta ativo ou não',
  PRIMARY KEY (`cd_talhao`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
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
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `cd_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nome_usuario` varchar(100) DEFAULT NULL COMMENT 'Nome completo do usuário',
  `nm_acesso` varchar(45) DEFAULT NULL COMMENT 'Nome de usuario para acessar o sistema',
  `senha` varchar(32) DEFAULT NULL,
  `score` float DEFAULT NULL,
  `cd_permissao` int(11) NOT NULL,
  PRIMARY KEY (`cd_usuario`),
  KEY `fk_usuario_permissao1_idx` (`cd_permissao`),
  CONSTRAINT `fk_usuario_permissao1` FOREIGN KEY (`cd_permissao`) REFERENCES `permissao` (`cd_permissao`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (2,'andre','admin_andre','12346',NULL,0),(3,'entregador_1','entregador','111111',NULL,0),(4,'produtor_1','produtor','222222',NULL,0),(5,'produtor_2','produtor_2','222222',NULL,0),(6,'Parceiro','parceiro','123',NULL,12),(7,'Gabriel Artemio','gabriel','1212',NULL,11),(8,'Produtor Gabriel','produtor','123',NULL,10),(9,'Entregador Gabriel','entregador','123',NULL,9);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'coopgreen'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-02 16:03:49
