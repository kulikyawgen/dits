-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: dits2
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `answer` (
  `answer_id` int(11) NOT NULL AUTO_INCREMENT,
  `correct` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `question_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`answer_id`),
  KEY `FKfiomvt17psxodcis3d8nmopx8` (`question_id`),
  CONSTRAINT `FKfiomvt17psxodcis3d8nmopx8` FOREIGN KEY (`question_id`) REFERENCES `question` (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
INSERT INTO `answer` VALUES (1,'\0','String',1),(2,'\0','Static',1),(3,'','Void',1),(4,'\0','String [] args',1),(5,'\0','Методы имеют одинаковое имя, такое же количество параметров, но разные типы возвращаемых значений',2),(6,'\0','Методы имеют одинаковое имя',2),(7,'\0','Методы имеют разные имена, но одинаковое количество аргументов',2),(8,'','Методы имеют одиковое имя, но разное количество аргументов',2),(9,'\0','Java Compiler',3),(10,'\0','Object class',3),(11,'','JVM',3),(12,'\0','System class',3),(13,'','import static',4),(14,'\0','import',4),(15,'\0','package',4),(16,'\0','static import',4),(17,'\0','A a = new A()',5),(18,'\0','B a = new B()',5),(19,'\0','A a = new B()',5),(20,'','B b = new A()',5),(21,'','Абстрактный класс может не содержать абстрактных методов',6),(22,'\0','Астрактный класс не может содержать обычных методов',6),(23,'','Абстрактный класс не может быть инстанциирован',6),(24,'\0','Абстрактный класс не может быть родителем',6),(25,'','Ссылочные',7),(26,'\0','Объектные',7),(27,'','Примитивные',7),(28,'\0','Переменные',7),(29,'\0','да',8),(30,'','нет',8),(31,'\0','только если класс астрактный',8),(32,'\0','только если класс статический',8),(33,'\0','да',9),(34,'\0','нет',9),(35,'\0','только в апплетах',9),(36,'\0','только в сервлетах',9),(37,'\0','только если родитель не наследовался до этого',10),(38,'\0','нет',10),(39,'\0','только при наличии default метода',10),(40,'','да',10),(41,'','Java virtual machine',11),(42,'\0','Jeck venom man',11),(43,'\0','Java virtual mount',11),(44,'\0','Java victory mok',11),(45,'','Java Runtime Environment',12),(46,'\0','Java run entity',12),(47,'\0','Java Real End',12),(48,'\0','Java Ring Entry',12),(49,'\0','Java Deploy Kit',13),(50,'','Java Development Kit',13),(51,'\0','Java Dedlock Keep',13),(52,'\0','Java Dependency Key',13);
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (100),(100),(100),(100),(100),(100),(100),(100),(100);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `link`
--

DROP TABLE IF EXISTS `link`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `link` (
  `link_id` int(11) NOT NULL AUTO_INCREMENT,
  `link` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `literature_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`link_id`),
  KEY `FKodqsh899rbqxs5ovtchdfp2yr` (`literature_id`),
  CONSTRAINT `FKodqsh899rbqxs5ovtchdfp2yr` FOREIGN KEY (`literature_id`) REFERENCES `literature` (`literature_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `link`
--

LOCK TABLES `link` WRITE;
/*!40000 ALTER TABLE `link` DISABLE KEYS */;
INSERT INTO `link` VALUES (1,'#',1),(2,'#',2),(3,'#',3),(4,'#',4),(5,'#',5),(6,'#',6),(7,'#',7),(8,'#',8),(9,'#',9),(10,'#',10),(11,'#',11),(12,'#',12),(13,'#',13);
/*!40000 ALTER TABLE `link` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `literature`
--

DROP TABLE IF EXISTS `literature`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `literature` (
  `literature_id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `question_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`literature_id`),
  KEY `FKhv2uobwq7rm0l1suy22j3cryx` (`question_id`),
  CONSTRAINT `FKhv2uobwq7rm0l1suy22j3cryx` FOREIGN KEY (`question_id`) REFERENCES `question` (`question_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `literature`
--

LOCK TABLES `literature` WRITE;
/*!40000 ALTER TABLE `literature` DISABLE KEYS */;
INSERT INTO `literature` VALUES (1,'Java core',1),(2,'Java core',2),(3,'Java core',3),(4,'Java core',4),(5,'Java core',5),(6,'Java core',6),(7,'Java core',7),(8,'Java core',8),(9,'Java core',9),(10,'Java core',10),(11,'All about JVM',11),(12,'All about JRE',12),(13,'All about JDK',13);
/*!40000 ALTER TABLE `literature` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `question` (
  `question_id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `test_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`question_id`),
  KEY `FKagu99fbcp5fbko4g3qhd3eycq` (`test_id`),
  CONSTRAINT `FKagu99fbcp5fbko4g3qhd3eycq` FOREIGN KEY (`test_id`) REFERENCES `test` (`test_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'Тип возвращаемого значения метода main?',1),(2,'Методы считаются перегруженными если?',1),(3,'Кто производит сбор мусора в JAVA?',1),(4,'Вы можете импортировать статические члены класса используя следующую конструкцию?',1),(5,'Какая запись является недопустимой? class A{...}; class B extend A{...}',1),(6,'Какие утверждения верны для абстрактного класса?',1),(7,'Какие типы данных представлены в java?',1),(8,'Может ли обычный(внешний) класс быть помечен как protected',1),(9,'Можно ли переопределять метод main?',1),(10,'Может ли один интерфейс наследоваться от другого?',1),(11,'What is JVM',2),(12,'What is JRE',2),(13,'What is JDK',2);
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'USER'),(2,'ADMIN'),(3,'TUTOR');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `statistic`
--

DROP TABLE IF EXISTS `statistic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `statistic` (
  `statistic_id` int(11) NOT NULL,
  `correct` bit(1) NOT NULL,
  `date` datetime DEFAULT NULL,
  `question_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`statistic_id`),
  KEY `FK3d3004k5fx44ga3ov34c5c78` (`question_id`),
  KEY `FK3fk4hj4hlc9ut33lb4pt47r4p` (`user_id`),
  CONSTRAINT `FK3d3004k5fx44ga3ov34c5c78` FOREIGN KEY (`question_id`) REFERENCES `question` (`question_id`),
  CONSTRAINT `FK3fk4hj4hlc9ut33lb4pt47r4p` FOREIGN KEY (`user_id`) REFERENCES `usr` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `statistic`
--

LOCK TABLES `statistic` WRITE;
/*!40000 ALTER TABLE `statistic` DISABLE KEYS */;
INSERT INTO `statistic` VALUES (90,'','2020-11-16 17:32:10',1,49),(91,'','2020-11-16 17:32:10',2,49),(92,'','2020-11-16 17:32:10',3,49),(93,'\0','2020-11-16 17:32:10',4,49),(94,'','2020-11-16 17:32:10',5,49),(95,'\0','2020-11-16 17:32:10',6,49),(96,'','2020-11-16 17:32:10',7,49),(97,'','2020-11-16 17:32:10',8,49),(98,'\0','2020-11-16 17:32:10',9,49),(99,'\0','2020-11-16 17:32:10',10,49);
/*!40000 ALTER TABLE `statistic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `test` (
  `test_id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `topic_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`test_id`),
  KEY `FKf91urnl7kmxnig2h69obbcrhu` (`topic_id`),
  CONSTRAINT `FKf91urnl7kmxnig2h69obbcrhu` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`topic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` VALUES (1,'Fundamental knowledges about java core','Basic test',1),(2,'Exspress test about JVM,JDK,JRE','JVM,JDK,JRE',1);
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic`
--

DROP TABLE IF EXISTS `topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `topic` (
  `topic_id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`topic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic`
--

LOCK TABLES `topic` WRITE;
/*!40000 ALTER TABLE `topic` DISABLE KEYS */;
INSERT INTO `topic` VALUES (1,'All about JAVA core','JAVA core');
/*!40000 ALTER TABLE `topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usr`
--

DROP TABLE IF EXISTS `usr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usr` (
  `user_id` int(11) NOT NULL,
  `first_Name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usr`
--

LOCK TABLES `usr` WRITE;
/*!40000 ALTER TABLE `usr` DISABLE KEYS */;
INSERT INTO `usr` VALUES (21,'Andrey','Gorevoi','Dron','1234'),(49,'Andrey','Gorevoy','junior','$2a$10$uusVvG6MyXyILbEiWnxPKOiVVmKstSYgGaP3MC9NkHpFsSKBSXsMe');
/*!40000 ALTER TABLE `usr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usr_role`
--

DROP TABLE IF EXISTS `usr_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usr_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  KEY `FKblbowqs3cnh87cjx9n5yot0rc` (`role_id`),
  KEY `FKjl6gufvtdoy0djihposug5sbv` (`user_id`),
  CONSTRAINT `FKblbowqs3cnh87cjx9n5yot0rc` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  CONSTRAINT `FKjl6gufvtdoy0djihposug5sbv` FOREIGN KEY (`user_id`) REFERENCES `usr` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usr_role`
--

LOCK TABLES `usr_role` WRITE;
/*!40000 ALTER TABLE `usr_role` DISABLE KEYS */;
INSERT INTO `usr_role` VALUES (49,1);
/*!40000 ALTER TABLE `usr_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-16 18:11:53
