-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: haru_shop
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `password` longtext,
  `role_id` bigint DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKd4vb66o896tay3yy52oqxr9w0` (`role_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'$2a$12$2S3wfrX9CRCOpN1q9Egj5.ZZDmZ.ifA2sQJ31JgX4lSLM500PibCG',1,'admin123'),(2,'$2a$12$Ci0TfU.48o12mtlnJLH3gu9ZL9QU1olC3iEzhBSOlqZBuqI6IA7Vy',2,'customer123');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `quantity` int NOT NULL,
  `customer_id` bigint DEFAULT NULL,
  `product_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdebwvad6pp1ekiqy5jtixqbaj` (`customer_id`),
  KEY `FK3d704slv66tw6x5hmbm6p2x3u` (`product_id`)
) ENGINE=MyISAM AUTO_INCREMENT=227 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (226,3,2,11);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `day_of_birth` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `account_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKn9x2k8svpxj3r328iy1rpur83` (`account_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Phú Lộc-Huế','1999-09-12','thanh123@gmail.com',0,'Lê Văn Thành','01235678761',1),(2,'Núi Thành-Đà Nẵng','1996-06-07','pdtri1996@gmail.com',1,'Nguyễn Hải Triều','01225950987',2);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_detail` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `is_delete` bit(1) NOT NULL,
  `price` double NOT NULL,
  `quantity` int NOT NULL,
  `update_date` datetime DEFAULT NULL,
  `orders_id` bigint DEFAULT NULL,
  `product_id` bigint DEFAULT NULL,
  `customer_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkefm6js2d9us8ulug8jsy1jnd` (`customer_id`),
  KEY `FK7xf2gmq3yok90kilflnu8aa7e` (`orders_id`),
  KEY `FKb8bg2bkty0oksa3wiq5mp5qnc` (`product_id`)
) ENGINE=MyISAM AUTO_INCREMENT=148 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
INSERT INTO `order_detail` VALUES (27,NULL,_binary '\0',100000,2,NULL,14,5,2),(28,NULL,_binary '\0',110000,2,NULL,14,6,2),(29,NULL,_binary '\0',100000,1,NULL,15,5,2),(30,NULL,_binary '\0',150000,1,NULL,16,1,2),(31,NULL,_binary '\0',150000,1,NULL,17,1,2),(32,NULL,_binary '\0',150000,1,NULL,18,1,2),(33,NULL,_binary '\0',110000,2,NULL,19,6,2),(34,NULL,_binary '\0',130000,3,NULL,19,3,2),(35,NULL,_binary '\0',130000,2,NULL,20,3,2),(36,NULL,_binary '\0',100000,1,NULL,20,5,2),(37,NULL,_binary '\0',110000,1,NULL,21,6,2),(38,NULL,_binary '\0',100000,1,NULL,21,5,2),(39,NULL,_binary '\0',130000,1,NULL,22,4,2),(40,NULL,_binary '\0',100000,1,NULL,22,5,2),(41,NULL,_binary '\0',150000,4,NULL,22,1,2),(42,NULL,_binary '\0',130000,1,NULL,22,3,2),(43,NULL,_binary '\0',120000,2,NULL,22,2,2),(44,NULL,_binary '\0',120000,1,NULL,23,2,2),(45,NULL,_binary '\0',100000,1,NULL,23,5,2),(46,NULL,_binary '\0',130000,1,NULL,23,4,2),(47,NULL,_binary '\0',150000,1,NULL,24,1,2),(48,NULL,_binary '\0',100000,1,NULL,25,5,2),(49,NULL,_binary '\0',130000,1,NULL,25,4,2),(50,NULL,_binary '\0',110000,1,NULL,26,6,2),(51,NULL,_binary '\0',100000,2,NULL,26,5,2),(52,NULL,_binary '\0',130000,1,NULL,27,4,2),(53,NULL,_binary '\0',150000,2,NULL,27,1,2),(54,NULL,_binary '\0',150000,1,NULL,28,1,2),(55,NULL,_binary '\0',130000,1,NULL,28,4,2),(56,NULL,_binary '\0',100000,1,NULL,29,5,2),(57,NULL,_binary '\0',130000,1,NULL,29,4,2),(58,NULL,_binary '\0',120000,1,NULL,30,2,2),(59,NULL,_binary '\0',150000,1,NULL,30,1,2),(60,NULL,_binary '\0',130000,1,NULL,31,3,2),(61,NULL,_binary '\0',120000,1,NULL,31,2,2),(62,NULL,_binary '\0',150000,1,NULL,31,1,2),(63,NULL,_binary '\0',100000,1,NULL,32,5,2),(64,NULL,_binary '\0',130000,1,NULL,32,4,2),(65,NULL,_binary '\0',100000,1,NULL,33,5,2),(66,NULL,_binary '\0',110000,1,NULL,33,6,2),(67,NULL,_binary '\0',100000,1,NULL,34,5,2),(68,NULL,_binary '\0',130000,1,NULL,34,3,2),(69,NULL,_binary '\0',120000,4,NULL,34,2,2),(70,NULL,_binary '\0',100000,1,NULL,35,5,2),(71,NULL,_binary '\0',120000,8,NULL,35,2,2),(72,NULL,_binary '\0',150000,8,NULL,35,1,2),(73,NULL,_binary '\0',130000,2,NULL,35,4,2),(74,NULL,_binary '\0',120000,1,NULL,35,10,2),(75,NULL,_binary '\0',150000,4,NULL,35,8,2),(76,NULL,_binary '\0',110000,1,NULL,36,6,2),(77,NULL,_binary '\0',100000,2,NULL,36,5,2),(78,NULL,_binary '\0',120000,14,NULL,36,2,2),(79,NULL,_binary '\0',120000,1,NULL,37,2,2),(80,NULL,_binary '\0',130000,2,NULL,37,3,2),(81,NULL,_binary '\0',120000,1,NULL,38,2,2),(82,NULL,_binary '\0',150000,1,NULL,39,1,2),(83,NULL,_binary '\0',100000,1,NULL,40,5,2),(84,NULL,_binary '\0',110000,1,NULL,40,6,2),(85,NULL,_binary '\0',130000,1,NULL,41,4,2),(86,NULL,_binary '\0',120000,1,NULL,41,10,2),(87,NULL,_binary '\0',120000,1,NULL,42,2,2),(88,NULL,_binary '\0',150000,1,NULL,42,1,2),(89,NULL,_binary '\0',100000,1,NULL,43,5,2),(90,NULL,_binary '\0',110000,1,NULL,43,6,2),(91,NULL,_binary '\0',120000,1,NULL,44,2,2),(92,NULL,_binary '\0',150000,1,NULL,44,1,2),(93,NULL,_binary '\0',120000,1,NULL,45,2,2),(94,NULL,_binary '\0',130000,1,NULL,45,3,2),(95,NULL,_binary '\0',130000,1,NULL,46,3,2),(96,NULL,_binary '\0',120000,1,NULL,47,2,2),(97,NULL,_binary '\0',120000,1,NULL,48,2,2),(98,NULL,_binary '\0',150000,1,NULL,49,1,2),(99,NULL,_binary '\0',120000,1,NULL,50,2,2),(100,NULL,_binary '\0',120000,1,NULL,51,2,2),(101,NULL,_binary '\0',130000,1,NULL,52,3,2),(102,NULL,_binary '\0',120000,1,NULL,53,2,2),(103,NULL,_binary '\0',150000,1,NULL,54,1,2),(104,NULL,_binary '\0',150000,1,NULL,55,1,2),(105,NULL,_binary '\0',110000,1,NULL,56,6,2),(106,NULL,_binary '\0',120000,1,NULL,58,2,2),(107,NULL,_binary '\0',130000,1,NULL,58,3,2),(108,NULL,_binary '\0',110000,1,NULL,59,6,2),(109,NULL,_binary '\0',130000,1,NULL,59,3,2),(110,NULL,_binary '\0',130000,1,NULL,61,3,2),(111,NULL,_binary '\0',120000,1,NULL,61,2,2),(112,NULL,_binary '\0',130000,1,NULL,62,3,2),(113,NULL,_binary '\0',120000,1,NULL,62,2,2),(114,NULL,_binary '\0',150000,2,NULL,62,1,2),(115,NULL,_binary '\0',130000,1,NULL,62,4,2),(116,NULL,_binary '\0',120000,4,NULL,63,2,2),(117,NULL,_binary '\0',130000,2,NULL,64,4,2),(118,NULL,_binary '\0',120000,1,NULL,64,2,2),(119,NULL,_binary '\0',120000,3,NULL,65,2,2),(120,NULL,_binary '\0',130000,3,NULL,65,3,2),(121,NULL,_binary '\0',120000,16,NULL,66,10,2),(122,NULL,_binary '\0',120000,1,NULL,67,2,2),(123,NULL,_binary '\0',110000,13,NULL,67,6,2),(124,NULL,_binary '\0',130000,8,NULL,68,3,2),(125,NULL,_binary '\0',150000,5,NULL,69,1,2),(126,NULL,_binary '\0',130000,5,NULL,70,3,2),(127,NULL,_binary '\0',120000,5,NULL,70,2,2),(128,NULL,_binary '\0',10000000,5,NULL,70,5,2),(129,NULL,_binary '\0',10000000,5,NULL,71,5,2),(130,NULL,_binary '\0',110000,5,NULL,72,6,2),(131,NULL,_binary '\0',130000,12,NULL,72,4,2),(132,NULL,_binary '\0',130000,6,NULL,73,3,2),(133,NULL,_binary '\0',150000,5,NULL,73,11,2),(134,NULL,_binary '\0',120000,5,NULL,74,2,2),(135,NULL,_binary '\0',150000,4,NULL,74,11,2),(136,NULL,_binary '\0',130000,5,NULL,75,4,2),(137,NULL,_binary '\0',120000,1,NULL,75,2,2),(138,NULL,_binary '\0',120000,5,NULL,76,2,2),(139,NULL,_binary '\0',150000,7,NULL,77,11,2),(140,NULL,_binary '\0',110000,5,NULL,78,6,2),(141,NULL,_binary '\0',150000,5,NULL,79,11,2),(142,NULL,_binary '\0',100000,5,NULL,79,5,2),(143,NULL,_binary '\0',120000,5,NULL,80,2,2),(144,NULL,_binary '\0',150000,10,NULL,80,11,2),(145,NULL,_binary '\0',150000,1,NULL,81,11,2),(146,NULL,_binary '\0',120000,5,NULL,81,2,2),(147,NULL,_binary '\0',150000,1,NULL,82,11,2);
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `customer_id` bigint DEFAULT NULL,
  `total_payment` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK624gtjin3po807j3vix093tlf` (`customer_id`)
) ENGINE=MyISAM AUTO_INCREMENT=83 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (42,'2023-09-18 11:28:40',2,270000),(43,'2023-09-18 11:30:34',2,210000),(44,'2023-09-18 11:31:20',2,270000),(45,'2023-09-18 11:49:38',2,370000),(46,'2023-09-18 11:50:10',2,130000),(47,'2023-09-18 12:13:27',2,120000),(48,'2023-09-18 13:35:40',2,120000),(49,'2023-09-18 13:40:49',2,150000),(50,'2023-09-18 15:48:47',2,120000),(51,'2023-09-18 16:18:05',2,120000),(52,'2023-09-18 16:22:16',2,130000),(53,'2023-09-18 16:26:57',2,120000),(54,'2023-09-18 16:29:35',2,150000),(55,'2023-09-18 16:31:35',2,150000),(56,'2023-09-19 08:45:41',2,11000000),(57,'2023-09-19 08:46:03',2,11000000),(58,'2023-09-19 08:47:08',2,25000000),(59,'2023-09-19 09:07:25',2,240000),(60,'2023-09-19 09:08:21',2,240000),(61,'2023-09-19 09:12:23',2,250000),(62,'2023-09-19 13:39:27',2,680000),(63,'2023-09-19 13:40:55',2,480000),(64,'2023-09-19 15:02:34',2,3110000),(65,'2023-09-19 15:06:28',2,750000),(66,'2023-09-19 21:47:37',2,2280000),(67,'2023-09-19 22:05:02',2,1550000),(68,'2023-09-20 08:25:05',2,1040000),(69,'2023-09-20 08:27:33',2,750000),(70,'2023-09-20 09:01:39',2,8300327),(71,'2023-09-20 09:05:30',2,7050327),(72,'2023-09-20 09:17:20',2,2110000),(73,'2023-09-21 11:18:23',2,1530000),(74,'2023-09-21 11:19:40',2,1200000),(75,'2023-09-21 11:22:17',2,770000),(76,'2023-09-21 11:27:22',2,600000),(77,'2023-09-21 11:38:35',2,1050000),(78,'2023-09-21 12:13:27',2,550000),(79,'2023-09-21 14:45:16',2,1250000),(80,'2023-09-22 08:35:48',2,2100000),(81,'2023-09-22 16:08:18',2,750000),(82,'2023-09-22 16:09:38',2,150000);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `image` longtext,
  `is_delete` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `quantity` int NOT NULL,
  `start_date` date DEFAULT NULL,
  `product_type_id` bigint DEFAULT NULL,
  `weight` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlabq3c2e90ybbxk58rc48byqo` (`product_type_id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (11,'Với hàm lượng dinh dưỡng cân bằng, Catsrang rất thích hợp trong việc cải thiện da lông và phòng tránh bệnh quáng gà ở mèo.','2023-09-13','https://sieupet.com/sites/default/files/pictures/images/thuc-an-cho-cho-pedigree.jpg',_binary '\0','Thức ăn của chó',150000,3,'2022-06-16',1,5),(2,'Là thức ăn dinh dưỡng dành cho mèo,bổ sung hàm lượng cao protein','2023-02-09','https://kinpetshop.com/wp-content/uploads/thuc-an-hat-cho-meo-kit-cat-kitten-pregnant-cat-1-2kg.jpg',_binary '\0','Catsrang mèo',120000,0,'2022-02-07',2,2),(3,'Là thức ăn dinh dưỡng dành cho chó,bổ sung hàm lượng cao protein','2023-06-06','https://bizweb.dktcdn.net/100/346/633/files/thuc-an-kho-cho-cho-meo-ra-doi-nhu-the-nao.jpg',_binary '\0','Whiskas chó ',130000,5,'2022-08-15',1,5),(4,'Là thức ăn dinh dưỡng dành cho mèo,bổ sung hàm lượng cao protein','2023-10-05','https://www.petmart.vn/wp-content/uploads/2021/06/thuc-an-cho-meo-anh-long-ngan-truong-thanh-royal-canin-british-shorthair-adult2.jpg',_binary '\0','Catsrang mèo',130000,5,'2022-03-15',2,10),(5,'Là thức ăn dinh dưỡng dành cho chó,bổ sung hàm lượng cao protein','2023-08-09','https://1.bp.blogspot.com/-bW66rnRSc78/YbLaNJCOi7I/AAAAAAAAAbQ/btJ-GMX97skkuSwantse6YsiYatcOb_IwCNcBGAsYHQ/s16000/pedigree-adult2.jpg',_binary '\0','Whiskas chó ',100000,10,'2022-07-12',1,5),(6,'Là thức ăn dinh dưỡng dành cho mèo,bổ sung hàm lượng cao protein','2023-02-13','https://www.petmart.vn/wp-content/uploads/2021/06/thuc-an-cho-meo-con-va-meo-me-royal-canin-mother-babycat.jpg',_binary '\0','Catsrang mèo',110000,10,'2022-02-01',2,3),(7,'Dành riêng cho những chiếc hàm ngắn như Pug con. Hạt được thiết kế độc quyền để giúp chó con Pug dễ dàng hơn khi ăn từ đó khuyến khích chúng nhai thức ăn kỹ hơn, hỗ trợ quá trình tiêu hóa.','2023-07-18','https://www.vietpet.net/wp-content/uploads/2019/01/thuc-an-cho-cho-corgi-moshm.jpg',_binary '\0','Whiskas chó ',130000,10,'2022-09-07',1,5),(8,'Thức ăn cho mèo Minino Nutritively Delicious được chế biến theo công thức chuyên biệt. Thành phần từ cá đem lại nhiều protein và omega 3,6. Hỗ trợ được làn da và bộ lông khỏe mạnh, sáng bóng. Chiếc xuất Yucca làm giảm mùi phân. Canxi và các chất vitamin h','2023-06-14','https://cdn-img-v2.webbnc.net/uploadv2/web/12/12107/product/2019/10/17/04/14/1571285687_thuc-an-meo-catsrang-400g-nhap-khau-han-quoc.jpg',_binary '\0','Catsrang mèo',150000,15,'2022-06-14',2,5),(9,' Cung cấp dinh dưỡng thiết yếu phù hợp cho giống chó Chihuahua. Thành phần hoàn toàn không có phẩm màu công nghiệp, không chất tạo mùi, phụ gia thực phẩm.','2023-09-07','https://product.hstatic.net/1000217401/product/40_1__f867d17c5967481e9aa76b93311f841f.png',_binary '\0','Whiskas chó ',200000,15,'2022-03-15',1,10),(10,'Với hàm lượng dinh dưỡng cân bằng, Catsrang rất thích hợp trong việc cải thiện da lông và phòng tránh bệnh quáng gà ở mèo.','2023-09-11','https://www.vietpet.net/wp-content/uploads/2018/09/thuc-an-cho-meo-minino-nutritively-delicious.jpg',_binary '\0','Catsrang mèo',120000,10,'2022-02-24',2,10);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_type`
--

DROP TABLE IF EXISTS `product_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_type` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `image` longtext,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_type`
--

LOCK TABLES `product_type` WRITE;
/*!40000 ALTER TABLE `product_type` DISABLE KEYS */;
INSERT INTO `product_type` VALUES (1,'Thức ăn dành cho chó','https://happypaws.vn/wp-content/uploads/cho-con-112-e1568133488282.jpg'),(2,'Thức ăn dành cho mèo','https://static.chotot.com/storage/chotot-kinhnghiem/c2c/2022/06/b549b3f9-meo-an-gi-5.jpg');
/*!40000 ALTER TABLE `product_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_CUSTOMER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-06 11:51:45
