CREATE DATABASE  IF NOT EXISTS `finaleprojectdb` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `finaleprojectdb`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: finaleprojectdb
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `assessment`
--

DROP TABLE IF EXISTS `assessment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assessment` (
  `assessment_id` int NOT NULL,
  `module_code` varchar(10) NOT NULL,
  `assignment_1` int DEFAULT NULL,
  `assignment_2` int DEFAULT NULL,
  `exam` int DEFAULT NULL,
  `result` int DEFAULT NULL,
  PRIMARY KEY (`assessment_id`),
  KEY `fk_assessment_module1_idx` (`module_code`),
  CONSTRAINT `fk_assessment_module1` FOREIGN KEY (`module_code`) REFERENCES `module` (`module_code`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assessment`
--

LOCK TABLES `assessment` WRITE;
/*!40000 ALTER TABLE `assessment` DISABLE KEYS */;
INSERT INTO `assessment` VALUES (1,'5N0541',10,20,30,20),(2,'5N0580',10,50,30,NULL),(3,'5N0690',88,76,100,88),(4,'5N0783',NULL,NULL,NULL,NULL),(5,'5N1356',21,22,78,40),(6,'5N1367',NULL,NULL,NULL,NULL),(7,'5N18396',90,90,90,90),(8,'5N2772',NULL,NULL,NULL,NULL),(9,'5N2927 ',NULL,NULL,NULL,NULL),(10,'5N0540 ',78,55,77,70),(11,'5N0627',NULL,NULL,NULL,NULL),(12,'5N06901',NULL,NULL,NULL,NULL),(13,'5N1292 ',NULL,NULL,NULL,NULL),(14,'5N13561',NULL,NULL,NULL,NULL),(15,'5N1590 ',NULL,NULL,NULL,NULL),(16,'5N1897 ',NULL,NULL,NULL,NULL),(17,'5N2148 ',NULL,NULL,NULL,NULL),(18,'5N06902',NULL,NULL,NULL,NULL),(19,'5N0784',NULL,NULL,NULL,NULL),(20,'5N13562',NULL,NULL,NULL,NULL),(21,'5N1558',NULL,NULL,NULL,NULL),(22,'5N1570',NULL,NULL,NULL,NULL),(23,'5N1604',NULL,NULL,NULL,NULL),(24,'5N1794',NULL,NULL,NULL,NULL),(25,'5N1999',NULL,NULL,NULL,NULL),(26,'5N4975',NULL,NULL,NULL,NULL),(27,'5N06903',NULL,NULL,NULL,NULL),(28,'5N1301',74,45,88,0),(29,'5N13563',45,47,77,56),(30,'5N1374',44,77,88,69),(31,'5N1458',88,45,87,73),(32,'5N1640',89,55,77,73),(33,'5N1849',54,79,88,73),(34,'5N1900',78,65,88,77),(35,'5N06904',NULL,NULL,NULL,NULL),(36,'5N13564',NULL,NULL,NULL,NULL),(37,'5N1379',NULL,NULL,NULL,NULL),(38,'5N1564',NULL,NULL,NULL,NULL),(39,'5N1605',NULL,NULL,NULL,NULL),(40,'5N16401',NULL,NULL,NULL,NULL),(41,'5N19001',NULL,NULL,NULL,NULL),(42,'5N21481',NULL,NULL,NULL,NULL),(43,'5N06909',NULL,NULL,NULL,NULL),(44,'5N0750 ',NULL,NULL,NULL,NULL),(45,'5N0752 ',NULL,NULL,NULL,NULL),(46,'5N0753 ',NULL,NULL,NULL,NULL),(47,'5N13569',NULL,NULL,NULL,NULL),(48,'5N13581',NULL,NULL,NULL,NULL),(49,'5N1363 ',NULL,NULL,NULL,NULL),(50,'5N17942',NULL,NULL,NULL,NULL),(51,'5N06905',NULL,NULL,NULL,NULL),(52,'5N13565',NULL,NULL,NULL,NULL),(53,'5N1358',NULL,NULL,NULL,NULL),(54,'5N1394',NULL,NULL,NULL,NULL),(55,'5N17941',NULL,NULL,NULL,NULL),(56,'5N2091',NULL,NULL,NULL,NULL),(57,'5N2107',NULL,NULL,NULL,NULL),(58,'5N3787',NULL,NULL,NULL,NULL),(59,'5N06907',NULL,NULL,NULL,NULL),(60,'5N0755',NULL,NULL,NULL,NULL),(61,'5N1271',NULL,NULL,NULL,NULL),(62,'5N13567',NULL,NULL,NULL,NULL),(63,'5N13791',NULL,NULL,NULL,NULL),(64,'5N1438',NULL,NULL,NULL,NULL),(65,'6N5450',NULL,NULL,NULL,NULL),(66,'N51590',NULL,NULL,NULL,NULL),(67,'5N05413',NULL,NULL,NULL,NULL),(68,'5N06906',NULL,NULL,NULL,NULL),(69,'5N12921',NULL,NULL,NULL,NULL),(70,'5N1299',NULL,NULL,NULL,NULL),(71,'5N13566',NULL,NULL,NULL,NULL),(72,'5N16051',NULL,NULL,NULL,NULL),(73,'5N1651',NULL,NULL,NULL,NULL),(74,'5N21482',NULL,NULL,NULL,NULL),(75,'5N5029',NULL,NULL,NULL,NULL),(76,'4N3206',NULL,NULL,NULL,NULL),(77,'5N06908',NULL,NULL,NULL,NULL),(78,'5N13568',NULL,NULL,NULL,NULL),(79,'5N2006',NULL,NULL,NULL,NULL),(80,'5N2667',NULL,NULL,NULL,NULL),(81,'5N2668',NULL,NULL,NULL,NULL),(82,'5N4648',NULL,NULL,NULL,NULL),(83,'5N4887',NULL,NULL,NULL,NULL),(84,'5N5665',NULL,NULL,NULL,NULL),(85,'6N0734 ',50,60,70,60),(86,'6N0736 ',NULL,NULL,NULL,NULL),(87,'6N1449',NULL,NULL,NULL,NULL),(88,'6N1946 ',NULL,NULL,NULL,NULL),(89,'6N2108 ',NULL,NULL,NULL,NULL),(90,'6N2191 ',NULL,NULL,NULL,NULL),(91,'6N3395 ',NULL,NULL,NULL,NULL),(92,'6N4090 ',NULL,NULL,NULL,NULL),(93,'6N4785 ',NULL,NULL,NULL,NULL),(94,'6N1949',NULL,NULL,NULL,NULL),(95,'6N19501',NULL,NULL,NULL,NULL),(96,'6N3750',NULL,NULL,NULL,NULL),(97,'6N3926',NULL,NULL,NULL,NULL),(98,'6N4045',NULL,NULL,NULL,NULL),(99,'6N4165',NULL,NULL,NULL,NULL),(100,'6N4310',NULL,NULL,NULL,NULL),(101,'6N4485',NULL,NULL,NULL,NULL),(102,'6N19461',45,72,80,65),(103,'6N1950 ',NULL,NULL,NULL,NULL),(104,'6N5565 ',NULL,NULL,NULL,NULL),(105,'6N5568 ',NULL,NULL,NULL,NULL),(106,'6N5569 ',NULL,NULL,NULL,NULL),(107,'6N5585 ',NULL,NULL,NULL,NULL),(108,'6N6226 ',NULL,NULL,NULL,NULL),(109,'6N6228 ',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `assessment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_group`
--

DROP TABLE IF EXISTS `class_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class_group` (
  `class_group_code` varchar(6) NOT NULL,
  `course_code` varchar(8) NOT NULL,
  `course_name` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`class_group_code`),
  KEY `fk_class_group_course1_idx` (`course_code`),
  CONSTRAINT `fk_class_group_course1` FOREIGN KEY (`course_code`) REFERENCES `course` (`course_code`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_group`
--

LOCK TABLES `class_group` WRITE;
/*!40000 ALTER TABLE `class_group` DISABLE KEYS */;
INSERT INTO `class_group` VALUES ('AAS','6M5153','Advanced Certificate in Animal Science'),('AC1','5M2768','Animal Care: Introduction to Dog Grooming'),('AC2','5M2768','Animal Care: Introduction to Dog Grooming'),('AML','6M4985','Advanced Certificate in Management, Law and HR'),('ASD','6M0691','Advanced Certificate in Software Development'),('CAD1','5M1940','Computer Aided Design and Architectural Technology'),('CAD2','5M1940','Computer Aided Design and Architectural Technology'),('ES1','5M5146','Elite Soccer - Performance and Coaching'),('ES2','5M5146','Elite Soccer - Performance and Coaching'),('FT1','5M18519','Film and TV'),('FT2','5M18519','Film and TV'),('GDD1','5M50481','Games Development and Design (Creative Media)'),('GDD2','5M50481','Games Development and Design (Creative Media)'),('GMJ1','5M5048','Global Media and Online Journalism'),('GMJ2','5M5048','Global Media and Online Journalism'),('LSP1','5M2149','Studio and Live Sound Production'),('LSP2','5M2149','Studio and Live Sound Production'),('MPP1','5M2011','Music Performance and Production'),('MPP2','5M2011','Music Performance and Production'),('PL1','5M3789','Pre-University Law'),('PL2','5M3789','Pre-University Law'),('PSD1','5M0529','Programming and Software Development with Cyber Security'),('PSD2','5M0529','Programming and Software Development with Cyber Security');
/*!40000 ALTER TABLE `class_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `course_code` varchar(8) NOT NULL,
  `course_name` varchar(99) DEFAULT NULL,
  `course_level` varchar(45) DEFAULT NULL,
  `start_date` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`course_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES ('5M0529','Programming and Software Development with Cyber Security','level 5','01 september'),('5M18519','Film and TV','level 5','01 september'),('5M1940','Computer Aided Design and Architectural Technology','level 5','01 september'),('5M2011','Music Performance and Production','level 5','01 september'),('5M2149','Studio and Live Sound Production','level 5','01 september'),('5M2768','Animal Care: Introduction to Dog Grooming','level 5','01 september'),('5M3789','Pre-University Law','level 5','01 september'),('5M5048','Global Media and Online Journalism','level 5','01 september'),('5M50481','Games Development and Design (Creative Media)','level 5','01 september'),('5M5146','Elite Soccer - Performance and Coaching','level 5','01 september'),('6M0691','Advanced Certificate in Software Development','level 6','01 september'),('6M4985','Advanced Certificate in Management, Law and HR','level 6','01 september'),('6M5153','Advanced Certificate in Animal Science','level 6','01 september');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `module`
--

DROP TABLE IF EXISTS `module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `module` (
  `module_code` varchar(10) NOT NULL,
  `course_code` varchar(8) NOT NULL,
  `staff_id` int NOT NULL,
  `module_name` varchar(45) DEFAULT NULL,
  `credits` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`module_code`),
  KEY `fk_module_course1_idx` (`course_code`),
  KEY `fk_module_staff1_idx` (`staff_id`),
  CONSTRAINT `fk_module_course1` FOREIGN KEY (`course_code`) REFERENCES `course` (`course_code`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_module_staff1` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`staff_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `module`
--

LOCK TABLES `module` WRITE;
/*!40000 ALTER TABLE `module` DISABLE KEYS */;
INSERT INTO `module` VALUES ('4N3206','5M5146',18,'Soccer',NULL),('5N0540 ','5M18519',7,'Television and Film Editing',NULL),('5N0541 ','5M0529',1,'Fundamentals of OOP',NULL),('5N05413','5M50481',1,'Object Oriented Programming',NULL),('5N0580','5M0529',2,'Mobile Technologies',NULL),('5N0627','5M18519',8,'Film Production',NULL),('5N0690','5M0529',2,'Communications',NULL),('5N06901','5M18519',6,'Communications',NULL),('5N06902','5M1940',6,'Communications',NULL),('5N06903','5M2011',6,'Communications',NULL),('5N06904','5M2149',12,'Communications',NULL),('5N06905','5M3789',12,'Communications',NULL),('5N06906','5M50481',14,'Communications',NULL),('5N06907','5M5048',6,'Communications',NULL),('5N06908','5M5146',14,'Communications',NULL),('5N06909','5M2768',14,'Communications',NULL),('5N0750 ','5M2768',15,'Animal Anatomy and Physiology',NULL),('5N0752 ','5M2768',15,'Animal Grooming',NULL),('5N0753 ','5M2768',15,'Animal Welfare',NULL),('5N0755','5M5048',9,'Appreciation of Art, Craft & Design',NULL),('5N0783','5M0529',1,'Database Methods',NULL),('5N0784','5M1940',9,'Design Skills',NULL),('5N1271','5M5048',7,'Documentary Photography',NULL),('5N1292 ','5M18519',8,'Image Processing',NULL),('5N12921','5M50481',1,'Image Processing',NULL),('5N1299','5M50481',2,'Multimedia Authoring',NULL),('5N1301','5M2011',10,'Music Performance',NULL),('5N1356','5M0529',3,'Work Experience',NULL),('5N13561','5M18519',6,'Work Experience',NULL),('5N13562','5M1940',6,'Work Experience',NULL),('5N13563','5M2011',6,'Work Experience',NULL),('5N13564','5M2149',12,'Work Experience',NULL),('5N13565','5M3789',12,'Work Experience',NULL),('5N13566','5M50481',14,'Work Experience',NULL),('5N13567','5M5048',6,'Work Experience',NULL),('5N13568','5M5146',14,'Work Experience',NULL),('5N13569','5M2768',14,'Work Experience',NULL),('5N1358','5M3789',13,'Word Processing',NULL),('5N13581','5M2768',12,'Word Processing',NULL),('5N1363 ','5M2768',16,'Veterinary Assisting Skills',NULL),('5N1367','5M0529',3,'Team working',NULL),('5N1374','5M2011',11,'Event Production',NULL),('5N1379','5M2149',10,'Radio Programme Production',NULL),('5N13791','5M5048',17,'Radio Programme Production',NULL),('5N1394','5M3789',13,'Legal Practice & Procedures',NULL),('5N1438','5M5048',17,'Digital Editing',NULL),('5N1458','5M2011',10,'Music Industry Studies',NULL),('5N1558','5M1940',9,'Architectural Drawing',NULL),('5N1564','5M2149',10,'Audio Engineering',NULL),('5N1570','5M1940',3,'Building Construction',NULL),('5N1590 ','5M18519',7,'Cinematography Camera Operations',NULL),('5N1604','5M1940',9,'Computer Aided Draughting (CAD)',NULL),('5N1605','5M2149',9,'Digital Movie Processing',NULL),('5N16051','5M50481',2,'Digital Movie Processing',NULL),('5N1640','5M2011',11,'Music Technology',NULL),('5N16401','5M2149',10,'Music Technology',NULL),('5N1651','5M50481',1,'Games Analysis Design',NULL),('5N1794','5M1940',3,'Safety & Health at Work',NULL),('5N17941','5M3789',12,'Safety & Health at Work',NULL),('5N17942','5M2768',16,'Safety & Health at Work',NULL),('5N18396','5M0529',4,'Maths for Information Technology',NULL),('5N1849','5M2011',10,'Music Theory and Practice',NULL),('5N1897 ','5M18519',7,'Script Writing',NULL),('5N1900','5M2011',11,'Sound Engineering and Production',NULL),('5N19001','5M2149',11,'Sound Engineering & Production',NULL),('5N1999','5M1940',9,'Wood Fabrication',NULL),('5N2006','5M5146',18,'Nutrition',NULL),('5N2091','5M3789',13,'Business Law',NULL),('5N2107','5M3789',13,'Criminology ',NULL),('5N2148 ','5M18519',8,'Desktop Multimedia Audio Production',NULL),('5N21481','5M2149',9,'Desktop Multimedia Audio Production',NULL),('5N21482','5M50481',2,'Desktop Multimedia Audio Production',NULL),('5N2667','5M5146',18,'Sport & Recreation',NULL),('5N2668','5M5146',18,'Exercise & Fitness',NULL),('5N2772','5M0529',2,'Software Architecture',NULL),('5N2927 ','5M0529',1,'Programming & Design Principles',NULL),('5N3787','5M3789',13,'Criminal Law',NULL),('5N4648','5M5146',18,'Sports Anatomy & Physiology',NULL),('5N4887','5M5146',18,'Soccer Coaching',NULL),('5N4975','5M1940',3,'Renewable Energy Systems',NULL),('5N5029','5M50481',2,'3D Computer Graphics',NULL),('5N5665','5M5146',18,'Sports Injury Prevention',NULL),('6N0734 ','6M0691',2,'Mobile Technologies',NULL),('6N0736 ','6M0691',1,'Graphical User Interface Programming',NULL),('6N1449','6M0691',2,'Software Architecture',NULL),('6N1946 ','6M0691',3,'Work Experience',NULL),('6N19461','6M5153',12,'Work Experience',NULL),('6N1949','6M4985',19,'Personal & Professional Development',NULL),('6N1950 ','6M5153',12,'Communications',NULL),('6N19501','6M4985',14,'Communications',NULL),('6N2108 ','6M0691',1,'Object Oriented Programming',NULL),('6N2191 ','6M0691',3,'Leadership',NULL),('6N3395 ','6M0691',4,'Mathematics',NULL),('6N3750','6M4985',13,'Human Resource Management',NULL),('6N3926','6M4985',19,'International Marketing',NULL),('6N4045','6M4985',13,'Business Law',NULL),('6N4090 ','6M0691',3,'Project Management',NULL),('6N4165','6M4985',19,'Finance',NULL),('6N4310','6M4985',19,'Business Management',NULL),('6N4485','6M4985',19,'E-business Studies',NULL),('6N4785 ','6M0691',2,'Relational Database',NULL),('6N5450','5M5048',17,'Journalistic Research Skills',NULL),('6N5565 ','6M5153',15,'Animal Science and Health',NULL),('6N5568 ','6M5153',15,'Animal Behaviour',NULL),('6N5569 ','6M5153',15,'Humans, Animals and Society',NULL),('6N5585 ','6M5153',16,'Kennel and Cattery Management',NULL),('6N6226 ','6M5153',16,'Animal Grooming',NULL),('6N6228 ','6M5153',16,'Canine Obedience and Training',NULL),('N51590','5M5048',7,'Cinematography Camera Operations',NULL);
/*!40000 ALTER TABLE `module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff` (
  `staff_id` int NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `surname` varchar(45) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `ppsn` varchar(45) DEFAULT NULL,
  `date_of_birth` varchar(45) DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `address_line_1` varchar(45) DEFAULT NULL,
  `address_line_2` varchar(45) DEFAULT NULL,
  `county` varchar(45) DEFAULT NULL,
  `eircode` varchar(45) DEFAULT NULL,
  `specializations` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (1,'Emily','O\'Connor','Female','emily.murphy@example.com','1234567A','1994-05-25','+353 01 234 5678','123 Main Street','Dublin','Dublin','D01 ABCD','IT and software'),(2,'Liam','Keen','Male','liam.oconnor@example.com','2345678B','1985-09-20','+353 021 987 6543','456 Elm Avenue','Cork','Cork','T12 XYZW','IT and software'),(3,'Sophia','Kelly','Female','sophiae.kelly@example.com','3456789C','1993-11-10','+353 091 345 6789',' 789 Oak Road','Galway','Galway',' H91 DEFG','Communication and managment'),(4,'Cian','Byrne','Male','cian.byrne@example.com','4567890D',' 1988-03-25','+353 061 876 5432','101 Maple Lane','Limerick','Limerick','V94 HIJK','Maths'),(5,'Olivia','Ryan','Female','tt@gmail.com','5678901E','1996-07-18','+353 051 234 5678','222 Pine Street','Waterford','Waterford',' X91 LMNO','Maths'),(6,'Sean','Walsh','Male','sean.walsh@example.com','6789012F',' 1983-12-05',' +353 066 789 0123','333 Cedar Avenue','Kerry','Kerry','V93 PQRS','Communication and managment'),(7,'Ava','Nolan','Female','Ava.nolan@example.com','7890123G','1991-04-30','+353 098 765 4321','444 Birch Road','Mayo','Mayo','F12 UVWX','Filming and production'),(8,'William','Doyle','Male','William.doyle@example.com','8901234H','1987-08-14','+353 074 210 9876','555 Willow Drive','Donegal','Donegal','F94 YZAB','Filming and production'),(9,'Isabella','Byrne','Female','Isabella.byrne@example.com','9012345I','1994-01-22','3530565432109','666 Elm Street','Kilkenny','Kilkenny','R95 CDEF','Architecture and interior design'),(10,'James','Gallagher','Male','james.gallagher@example.com','0123456J',' 1989-06-28','+353 062 109 8765','777 Oak Avenue','Tipperary','Tipperary','E91 FGHI','Music Teaching and Performance'),(11,'John','Murphy','Male','john.murphy@example.com','1234567A','1985-07-15','+353 87 123 4567','12 Main Street','Dublin','Dublin','D01 AB12','Musical Performance'),(12,'Sarah','Kelly','Female','sarah.kelly@example.com','2345678B','1990-04-25','+353 86 234 5678','456 Oak Avenue','Cork','Cork','T12 CD34','Communication and managment'),(13,'Michael','O\'Connor','Male',' michael.oconnor@example.com','3456789C','1983-12-10','+353 85 345 6789','789 Elm Street','Galway','Galway','H91 EF56','Law'),(14,'Emma','Byrne','Female','emma.byrne@example.com','4567890D','1995-09-03','+353 83 456 7890','987 Maple Road','Limerick','Limerick','V94 GH78','Communication and managment'),(15,'David','Walsh','Male','david.walsh@example.com','5678901E','1988-02-20','+353 87 567 8901','654 Pine Lane','Waterford','Waterford','X91 KL32','Animal science '),(16,'Aoife','Ryan','Female','aoife.ryan@example.com','6789012F','1992-06-12','+353 86 678 9012','321 Cedar Street','Kerry','Kerry','V93 MN45','Animal science '),(17,'Jack','Fitzgerald','Male','jack.fitzgerald@example.com','7890123G','1987-11-28','+353 85 789 0123','876 Birch Avenue','Donegal','Donegal','F94 OP67','Journalism '),(18,'Conor','Kennedy','Male','conor.kennedy@example.com','9012345I','1986-08-07','+353 86 901 2345','234 Elmwood Lane','Clare','Clare','V95 ST78','Sport'),(19,'John','Doe','Male','john.doe@example.com','1234567A','1985-07-15','+353 87 123 4567','3 Main Street','Apt 1','Dublin','D01 AB12','Business and management');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `student_id` int NOT NULL,
  `class_group_code` varchar(6) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `surname` varchar(45) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `ppsn` varchar(45) DEFAULT NULL,
  `address_line_1` varchar(45) DEFAULT NULL,
  `address_line_2` varchar(45) DEFAULT NULL,
  `county` varchar(45) DEFAULT NULL,
  `eircode` varchar(45) DEFAULT NULL,
  `age` varchar(45) DEFAULT NULL,
  `date_of_birth` varchar(45) DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  KEY `fk_student_class_group_idx` (`class_group_code`),
  CONSTRAINT `fk_student_class_group` FOREIGN KEY (`class_group_code`) REFERENCES `class_group` (`class_group_code`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'PSD1','Mark','Touma','Male','tomas.tods@gmail.com','2230134IA','11 an fiodan','Doughiska','Galway','H91 T622','23','2000-06-02','834301369'),(2,'PSD2','Nicole','Saab','Female','nikola@gmail.com','2211345UA','113 fearann ri','Doughiska','Galway','U11 O888','24','1999-12-08','867914728'),(3,'FT1','Max','Verstapen','Male','mv@gmail.com','23232AR','12 Race street','Monaco','Monaco','RD1 WC3','27','1996-11-03','83444852'),(4,'FT2','Sara','McMurphy','Female','saiw222@gmail.com','4234234T','173 Main street','Galway','Galway','H61 W222','22','2001-11-02','894781198'),(5,'CAD1','Mark','Dous','Male','mm@gmail.com','2237195IE','11Galway','Galway','Galway','H83T284','27','1997-04-05','09877456'),(7,'CAD2','John','Murphy','Male','mmii@gmail.com','1155455W','11 Galway','Galway','Galway','H71N288','23','2001-04-09','054598785'),(9,'MPP1','Adam','Farr','Male','Farr@gmail.com','432323w','22mainstreet','Galway','Galway','J34EQQ','24','1999-06-17','834391487'),(10,'MPP2','Michael ','Johnson','Male','michael.johnson@example.com','1234567TA','42 High Street','Northwood','Dublin','D11 A2C3','25','1999-03-14','+353 83 123 4567'),(11,'LSP1','Sarah ','O’Brien','Female','sarah.obrien@example.com','2345678TB','10 The Green','East Village','Cork','T12 B4D5','33','1990-07-18','+353 85 234 5678'),(12,'LSP2','James','Walsh','Male',' james.walsh@example.com','3456789TC','78 Elm Road','Galway','Galway','H91 C3D4','26','1998-02-11','+353 87 345 6789'),(13,'AC1','Emma ','Byrne','Female','emma.byrne@example.com','4567890TD','25 Oak Lane','Limerick','Limerick','V94 P8K3','24','1999-11-25','+353 86 456 7890'),(14,'AC2','Patrick ','Murphy','Male',' patrick.murphy@example.com','5678901TE','55 Cedar Park','Waterford','Waterford','X91 R2C8','22','2002-04-15','+353 89 567 8901'),(15,'PL1','Laura','Kelly','Female','laura.kelly@example.com','6789012TF','33 Pine Crescent','Sligo','Sligo','F56 W6H3','23','2000-09-09','+353 82 678 9012'),(16,'PL2','Conor ','Ryan','Male','conor.ryan@example.com','7890123TG','98 Birch Avenue','Kildare','Kildare','F23 E8T9','36','1988-01-30','+353 81 789 0123'),(17,'GMJ1','Fiona ','Doyle','Female','fiona.doyle@example.com','8901234TH','120 Maple Drive','Mayo','Mayo','F23 E8T9','27','1996-10-17','+353 88 890 1234'),(18,'GMJ2','David ','O\'Connor','Male','david.oconnor@example.com','9012345TI','15 Willow Way',' Southside','Wicklow','A67 Y8F3','26','1997-05-15','+353 84 901 2345'),(19,'GDD1','Siobhan ','McCarthy','Female','siobhan.mccarthy@example.com','0123456TJ','88 Spruce Street','Clare','Clare','V95 T9X2','21','2003-04-15','+353 83 012 3456'),(20,'GDD2','Nicole ','Fitzgerald','Female','nicole.fitzgerald@example.com','2324557TG','32 Spruce Avenue','Riverside','Meath','A92 D4E3','20','2004-01-21','+353 83 555 1234'),(21,'ES1','Ian ','Dempsey','Male','ian.dempsey@example.com','2345668TH','47 Cherry Lane','Dublin','Dublin','D15 Y6F4','25','1998-08-03','+353 85 666 2345'),(22,'ES2','Louise ','Healy','Female','louise.healy@example.com','3456779TI','10 Maple Road','Green Park','Kerry','V31 X8D5','30','1994-01-05','+353 87 777 3456'),(23,'ASD','Brian ','Clarke','Male','brian.clarke@example.com','4567880TJ','98 Oak Street','Cork','Cork',' T23 P8K4','23','2000-09-14','+353 89 888 4567'),(24,'AML','Rachel ','Murray','Female','rachel.murray@example.com','5678991TK','3 Pine Court','Limerick','Limerick','V94 R7F8','22','2001-12-17','+353 81 999 5678'),(25,'AAS','Sean ','Gallagher','Male','sean.gallagher@example.com','6789112TL','55 Elm Road','Westside','Sligo','F56 Y8H3','25','1999-02-22','+353 83 111 6789');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_has_assessment`
--

DROP TABLE IF EXISTS `student_has_assessment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_has_assessment` (
  `student_id` int NOT NULL,
  `assessment_id` int NOT NULL,
  PRIMARY KEY (`student_id`,`assessment_id`),
  KEY `student_has_assessment_ibfk_2` (`assessment_id`),
  CONSTRAINT `student_has_assessment_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `student_has_assessment_ibfk_2` FOREIGN KEY (`assessment_id`) REFERENCES `assessment` (`assessment_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_has_assessment`
--

LOCK TABLES `student_has_assessment` WRITE;
/*!40000 ALTER TABLE `student_has_assessment` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_has_assessment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-10-03 20:23:21
