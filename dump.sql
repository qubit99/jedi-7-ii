-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: jedi
-- ------------------------------------------------------
-- Server version	8.0.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `catalog`
--

DROP TABLE IF EXISTS `catalog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `catalog` (
  `CATALOGID` varchar(10) NOT NULL,
  `CID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CATALOGID`),
  KEY `CID` (`CID`),
  CONSTRAINT `catalog_ibfk_1` FOREIGN KEY (`CID`) REFERENCES `course` (`CID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catalog`
--

LOCK TABLES `catalog` WRITE;
/*!40000 ALTER TABLE `catalog` DISABLE KEYS */;
/*!40000 ALTER TABLE `catalog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `CID` varchar(255) NOT NULL,
  `COURSENAME` varchar(255) NOT NULL,
  `PROFESSORID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CID`),
  KEY `PROFESSORID` (`PROFESSORID`),
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`PROFESSORID`) REFERENCES `professor` (`USERID`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES ('C1','CORE JAVA','P1'),('C2','GENETIC ALGORITHMS','P1'),('C3','QUANTUM OPTICS','P2'),('C4','COSMOLOGY 101','P2'),('C5',' Algorithms',NULL),('C6','Big Data',NULL);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gradecard`
--

DROP TABLE IF EXISTS `gradecard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gradecard` (
  `ROLLNO` varchar(255) NOT NULL,
  `CPI` float(4,0) DEFAULT NULL,
  `SEMESTER` int DEFAULT NULL,
  PRIMARY KEY (`ROLLNO`),
  CONSTRAINT `gradecard_ibfk_1` FOREIGN KEY (`ROLLNO`) REFERENCES `student` (`ROLLNO`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gradecard`
--

LOCK TABLES `gradecard` WRITE;
/*!40000 ALTER TABLE `gradecard` DISABLE KEYS */;
/*!40000 ALTER TABLE `gradecard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notification`
--

DROP TABLE IF EXISTS `notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notification` (
  `NOTIFID` varchar(255) NOT NULL,
  `ROLLNO` varchar(255) DEFAULT NULL,
  `MESSAGE` text,
  PRIMARY KEY (`NOTIFID`),
  KEY `ROLLNO` (`ROLLNO`),
  CONSTRAINT `notification_ibfk_1` FOREIGN KEY (`ROLLNO`) REFERENCES `student` (`ROLLNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification`
--

LOCK TABLES `notification` WRITE;
/*!40000 ALTER TABLE `notification` DISABLE KEYS */;
/*!40000 ALTER TABLE `notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `TRANSID` varchar(255) NOT NULL,
  `PAYMODE` varchar(255) DEFAULT NULL,
  `AMOUNT` mediumtext,
  `PAYSTATUS` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`TRANSID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personaldetails`
--

DROP TABLE IF EXISTS `personaldetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personaldetails` (
  `NAME` varchar(255) NOT NULL,
  `PHONE` varchar(255) DEFAULT NULL,
  `ADDRESS` text,
  `USERID` varchar(255) NOT NULL,
  PRIMARY KEY (`USERID`),
  CONSTRAINT `personaldetails_ibfk_1` FOREIGN KEY (`USERID`) REFERENCES `user` (`USERID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personaldetails`
--

LOCK TABLES `personaldetails` WRITE;
/*!40000 ALTER TABLE `personaldetails` DISABLE KEYS */;
INSERT INTO `personaldetails` VALUES ('MODIJI','101','DILLI','A1'),('Amit Balyan','809','Bangalore','P1'),('HC Verma','211','Kanpur','P2'),('Gaurav Sen','764','Hyderabad','P3'),('Pranay','998','Jaipur','S1');
/*!40000 ALTER TABLE `personaldetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professor`
--

DROP TABLE IF EXISTS `professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `professor` (
  `USERID` varchar(255) NOT NULL,
  `DEPARTMENT` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`USERID`),
  CONSTRAINT `USERID` FOREIGN KEY (`USERID`) REFERENCES `user` (`USERID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professor`
--

LOCK TABLES `professor` WRITE;
/*!40000 ALTER TABLE `professor` DISABLE KEYS */;
INSERT INTO `professor` VALUES ('P1','CSE'),('P2','Physics'),('P3','CSE');
/*!40000 ALTER TABLE `professor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `semesterregistration`
--

DROP TABLE IF EXISTS `semesterregistration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `semesterregistration` (
  `ROLLNO` varchar(255) DEFAULT NULL,
  `CID` varchar(255) DEFAULT NULL,
  `SEMESTER` int DEFAULT NULL,
  `GRADE` varchar(255) DEFAULT NULL,
  KEY `CID` (`CID`),
  CONSTRAINT `semesterregistration_ibfk_1` FOREIGN KEY (`CID`) REFERENCES `course` (`CID`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `semesterregistration`
--

LOCK TABLES `semesterregistration` WRITE;
/*!40000 ALTER TABLE `semesterregistration` DISABLE KEYS */;
/*!40000 ALTER TABLE `semesterregistration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `USERID` varchar(255) NOT NULL,
  `ROLLNO` varchar(255) NOT NULL,
  `DEPARTMENT` varchar(255) NOT NULL,
  `ISAPPROVED` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ROLLNO`),
  UNIQUE KEY `ROLLNO` (`ROLLNO`),
  KEY `USERID` (`USERID`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`USERID`) REFERENCES `user` (`USERID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('S1','19','CSE',0);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `USERID` varchar(255) NOT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  `ROLE` varchar(255) NOT NULL,
  PRIMARY KEY (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('A1','password','Admin'),('P1','profpass','Professor'),('P2','profpass','Professor'),('P3','profpass','Professor'),('S1','stud','Student');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-03 13:30:59
