-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: management
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
-- Table structure for table `admin_details`
--

DROP TABLE IF EXISTS `admin_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin_details` (
  `username` varchar(15) NOT NULL,
  `password` varchar(20) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `contact_no` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_details`
--

LOCK TABLES `admin_details` WRITE;
/*!40000 ALTER TABLE `admin_details` DISABLE KEYS */;
INSERT INTO `admin_details` VALUES ('admin','1234','admin','1234567890'),('saish','saish','saish','1234569870');
/*!40000 ALTER TABLE `admin_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculty_details`
--

DROP TABLE IF EXISTS `faculty_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `faculty_details` (
  `username` varchar(15) NOT NULL,
  `fname` varchar(15) DEFAULT NULL,
  `lname` varchar(15) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `qualification` varchar(20) DEFAULT NULL,
  `designation` varchar(30) DEFAULT NULL,
  `join_date` date DEFAULT NULL,
  `salary` varchar(10) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty_details`
--

LOCK TABLES `faculty_details` WRITE;
/*!40000 ALTER TABLE `faculty_details` DISABLE KEYS */;
INSERT INTO `faculty_details` VALUES ('Dhruv123','Dhruv','Sanghavi','Dhruv@gmail.com','teacher','2003-10-30','M.Tech','Associate Professor','2021-01-01','100000','Kandivali'),('Gaurav','Gaurav','Kukdeja','dhruv@gmail.com','teacher','2004-01-15','M.E','Assistant Professor','2019-01-15','100000','Amravati'),('Kiran','Kiran','Salvi','kiran@gmail.com','teacher','2007-01-17','B.E','Assistant Professor','2019-01-10','10000','Charkop'),('Saish123','Saish','Bavalekar','saish@gmail.com','1234','2003-04-26','B.E','Assistant Professor','2023-01-01','50000','Charkop'),('Sam','Samarth','Shetty','sam@gmail.com','1234','2001-01-11','M.Tech','HOD','2017-01-05','500000','Plot 64/Room 1010 Tulip,MarolNaka,Andheri(E)'),('Viraj@123','Viraj','Sindhwad','viraj@gmail.com','1234','2003-11-10','M.Tech','Assistant Professor','2017-01-08','50000','302/A Some Tower,Yogi Nagar,Borivali(W),Mumbai-4000067');
/*!40000 ALTER TABLE `faculty_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculty_publications`
--

DROP TABLE IF EXISTS `faculty_publications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `faculty_publications` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `publish_date` date DEFAULT NULL,
  `username` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `teacher_id_idx` (`username`),
  CONSTRAINT `teacher_id_fk` FOREIGN KEY (`username`) REFERENCES `faculty_details` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty_publications`
--

LOCK TABLES `faculty_publications` WRITE;
/*!40000 ALTER TABLE `faculty_publications` DISABLE KEYS */;
INSERT INTO `faculty_publications` VALUES (7,'A study on something','2023-01-03','Saish123'),(8,'Study','2023-01-01','Dhruv123'),(9,'Study on something','2023-01-02','Dhruv123'),(14,'xyz','2023-01-01','Gaurav');
/*!40000 ALTER TABLE `faculty_publications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculty_workshop`
--

DROP TABLE IF EXISTS `faculty_workshop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `faculty_workshop` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(45) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `username` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `teacher_id_fk_idx` (`username`),
  CONSTRAINT `teacher_id_fk2` FOREIGN KEY (`username`) REFERENCES `faculty_details` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty_workshop`
--

LOCK TABLES `faculty_workshop` WRITE;
/*!40000 ALTER TABLE `faculty_workshop` DISABLE KEYS */;
INSERT INTO `faculty_workshop` VALUES (9,'AI','2023-02-01','2023-02-06','Saish123'),(10,'Gaming','2023-01-01','2023-01-03','Dhruv123'),(16,'xyz','2023-01-01','2023-01-03','saish123');
/*!40000 ALTER TABLE `faculty_workshop` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-04 17:55:41
