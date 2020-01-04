-- MySQL dump 10.13  Distrib 5.7.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: weather
-- ------------------------------------------------------
-- Server version	5.7.22-log

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
-- Table structure for table `forecasts`
--

DROP TABLE IF EXISTS `forecasts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `forecasts` (
  `city` varchar(45) NOT NULL,
  `date` date NOT NULL,
  `dayweather` varchar(20) NOT NULL,
  `daytemp` int(11) NOT NULL,
  `daywind` varchar(20) NOT NULL,
  `daypower` varchar(20) NOT NULL,
  `nightweather` varchar(20) NOT NULL,
  `nighttemp` int(11) NOT NULL,
  `nightwind` varchar(20) NOT NULL,
  `nightpower` varchar(20) NOT NULL,
  `count` int(11) NOT NULL,
  PRIMARY KEY (`city`,`date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forecasts`
--

LOCK TABLES `forecasts` WRITE;
/*!40000 ALTER TABLE `forecasts` DISABLE KEYS */;
INSERT INTO `forecasts` VALUES ('上海市','2020-01-03','小雨',11,'无风向','≤3','小雨',9,'无风向','≤3',1),('上海市','2020-01-04','小雨',12,'东北','≤3','阴',9,'东北','≤3',2),('上海市','2020-01-05','阴',14,'南','4','多云',10,'南','4',3),('上海市','2020-01-06','多云',20,'西','4','多云',13,'西','4',4),('兰州市','2020-01-03','阴',5,'东','≤3','多云',-3,'东','≤3',1),('兰州市','2020-01-04','多云',6,'无风向','≤3','小雪',-4,'无风向','≤3',2),('兰州市','2020-01-05','阴',3,'北','4','阴',-5,'北','4',3),('兰州市','2020-01-06','阴',1,'北','≤3','阴',-8,'北','≤3',4),('北京市','2020-01-03','晴',7,'无风向','≤3','晴',-5,'无风向','≤3',1),('北京市','2020-01-04','晴',8,'东南','≤3','多云',-5,'东南','≤3',2),('北京市','2020-01-05','阴',2,'北','≤3','小雪',-5,'北','≤3',3),('北京市','2020-01-06','多云',5,'东北','≤3','多云',-3,'东北','≤3',4),('南京市','2020-01-03','小雨',7,'东','≤3','小雨',6,'东','≤3',1),('南京市','2020-01-04','多云',11,'东南','≤3','小雨',6,'东南','≤3',2),('南京市','2020-01-05','小雨',12,'南','≤3','小雨',6,'南','≤3',3),('南京市','2020-01-06','小雨',18,'西北','≤3','多云',9,'西北','≤3',4),('南昌市','2020-01-03','阴',10,'无风向','≤3','阴',9,'无风向','≤3',1),('南昌市','2020-01-04','阴',13,'无风向','≤3','阴',9,'无风向','≤3',2),('南昌市','2020-01-05','多云',18,'南','≤3','多云',10,'南','≤3',3),('南昌市','2020-01-06','多云',24,'南','≤3','多云',11,'南','≤3',4),('台湾省','2020-01-03','晴',22,'东','4','晴',17,'东','4',1),('台湾省','2020-01-04','多云',20,'东','4','多云',17,'东','4',2),('台湾省','2020-01-05','多云',21,'无风向','≤3','多云',18,'无风向','≤3',3),('台湾省','2020-01-06','多云',22,'无风向','≤3','多云',19,'无风向','≤3',4),('合肥市','2020-01-03','阴',8,'东北','≤3','小雨',5,'东北','≤3',1),('合肥市','2020-01-04','多云',10,'东','≤3','小雨',5,'东','≤3',2),('合肥市','2020-01-05','小雨',12,'西南','≤3','小雨',7,'西南','≤3',3),('合肥市','2020-01-06','小雨',15,'西北','4','小雨',7,'西北','4',4),('哈尔滨市','2020-01-03','多云',-13,'西南','≤3','霾',-22,'西南','≤3',1),('哈尔滨市','2020-01-04','晴',-12,'西南','≤3','霾',-22,'西南','≤3',2),('哈尔滨市','2020-01-05','晴',-8,'东南','≤3','霾',-19,'东南','≤3',3),('哈尔滨市','2020-01-06','小雪',-5,'西北','≤3','小雪',-16,'西北','≤3',4),('天津市','2020-01-03','多云',6,'西','≤3','霾',-2,'西','≤3',1),('天津市','2020-01-04','霾',6,'东','≤3','晴',-2,'东','≤3',2),('天津市','2020-01-05','阴',5,'北','≤3','小雪',0,'北','≤3',3),('天津市','2020-01-06','阴',5,'东北','5','阴',-3,'东北','5',4),('太原市','2020-01-03','多云',6,'西','≤3','晴',-8,'西','≤3',1),('太原市','2020-01-04','多云',7,'东南','≤3','小雪',-7,'东南','≤3',2),('太原市','2020-01-05','小雪',1,'东','≤3','阴',-4,'东','≤3',3),('太原市','2020-01-06','多云',2,'东','4','中雪',-5,'东','4',4),('广州市','2020-01-03','多云',25,'无风向','≤3','多云',14,'无风向','≤3',1),('广州市','2020-01-04','多云',25,'无风向','≤3','多云',15,'无风向','≤3',2),('广州市','2020-01-05','多云',24,'无风向','≤3','多云',16,'无风向','≤3',3),('广州市','2020-01-06','多云',25,'无风向','≤3','多云',17,'无风向','≤3',4),('成都市','2020-01-03','多云',15,'无风向','≤3','多云',7,'无风向','≤3',1),('成都市','2020-01-04','阴',11,'无风向','≤3','多云',7,'无风向','≤3',2),('成都市','2020-01-05','多云',11,'无风向','≤3','小雨',7,'无风向','≤3',3),('成都市','2020-01-06','阴',12,'无风向','≤3','多云',5,'无风向','≤3',4),('昆明市','2020-01-03','多云',20,'无风向','≤3','多云',7,'无风向','≤3',1),('昆明市','2020-01-04','阵雨',16,'无风向','≤3','阵雨',7,'无风向','≤3',2),('昆明市','2020-01-05','中雨',15,'西南','4','中雨',6,'西南','4',3),('昆明市','2020-01-06','阵雨',16,'无风向','≤3','晴',2,'无风向','≤3',4),('杭州市','2020-01-03','小雨',9,'无风向','≤3','小雨',8,'无风向','≤3',1),('杭州市','2020-01-04','小雨',11,'西','4','阴',8,'西','4',2),('杭州市','2020-01-05','阴',15,'无风向','≤3','多云',9,'无风向','≤3',3),('杭州市','2020-01-06','多云',22,'无风向','≤3','晴',11,'无风向','≤3',4),('武汉市','2020-01-03','小雨',6,'西北','≤3','多云',5,'西北','≤3',1),('武汉市','2020-01-04','小雨',10,'东南','4','小雨',5,'东南','4',2),('武汉市','2020-01-05','小雨',11,'东北','≤3','小雨',7,'东北','≤3',3),('武汉市','2020-01-06','小雨',12,'北','4','中雨',5,'北','4',4),('沈阳市','2020-01-03','多云',-2,'南','≤3','中度霾',-16,'南','≤3',1),('沈阳市','2020-01-04','中度霾',-2,'东','≤3','中度霾',-15,'东','≤3',2),('沈阳市','2020-01-05','中度霾',1,'南','≤3','多云',-14,'南','≤3',3),('沈阳市','2020-01-06','多云',1,'北','4','多云',-14,'北','4',4),('济南市','2020-01-03','阴',7,'南','≤3','晴',-1,'南','≤3',1),('济南市','2020-01-04','多云',9,'东北','≤3','阴',0,'东北','≤3',2),('济南市','2020-01-05','小雨',4,'东北','4','小雨',1,'东北','4',3),('济南市','2020-01-06','小雨',4,'东北','5','雨夹雪',1,'东北','5',4),('海口市','2020-01-03','多云',25,'无风向','≤3','多云',19,'无风向','≤3',1),('海口市','2020-01-04','多云',24,'无风向','≤3','多云',19,'无风向','≤3',2),('海口市','2020-01-05','多云',24,'无风向','≤3','多云',19,'无风向','≤3',3),('海口市','2020-01-06','多云',27,'无风向','≤3','多云',20,'无风向','≤3',4),('石家庄市','2020-01-03','多云',7,'无风向','≤3','晴',-3,'无风向','≤3',1),('石家庄市','2020-01-04','晴',7,'无风向','≤3','多云',-4,'无风向','≤3',2),('石家庄市','2020-01-05','小雪',1,'北','≤3','小雪',-3,'北','≤3',3),('石家庄市','2020-01-06','阴',3,'北','≤3','小雪',-2,'北','≤3',4),('福州市','2020-01-03','多云',22,'无风向','≤3','多云',13,'无风向','≤3',1),('福州市','2020-01-04','阴',22,'无风向','≤3','阴',13,'无风向','≤3',2),('福州市','2020-01-05','阴',19,'无风向','≤3','阴',15,'无风向','≤3',3),('福州市','2020-01-06','阴',24,'无风向','≤3','阴',15,'无风向','≤3',4),('西宁市','2020-01-03','阴',4,'无风向','≤3','多云',-8,'无风向','≤3',1),('西宁市','2020-01-04','多云',4,'无风向','≤3','小雪',-8,'无风向','≤3',2),('西宁市','2020-01-05','小雪',0,'无风向','≤3','阴',-7,'无风向','≤3',3),('西宁市','2020-01-06','阴',-2,'南','≤3','多云',-13,'南','≤3',4),('西安市','2020-01-03','阴',9,'东北','≤3','多云',-3,'东北','≤3',1),('西安市','2020-01-04','小雨',5,'东北','4','小雨',-2,'东北','4',2),('西安市','2020-01-05','小雨',3,'南','≤3','雨夹雪',0,'南','≤3',3),('西安市','2020-01-06','雨夹雪',5,'西南','4','小雨',0,'西南','4',4),('贵阳市','2020-01-03','阴',8,'东北','≤3','小雨',6,'东北','≤3',1),('贵阳市','2020-01-04','小雨',16,'南','4','小雨',6,'南','4',2),('贵阳市','2020-01-05','阴',17,'南','4','小雨',12,'南','4',3),('贵阳市','2020-01-06','多云',18,'北','≤3','阵雨',6,'北','≤3',4),('郑州市','2020-01-03','阴',10,'西南','≤3','多云',-2,'西南','≤3',1),('郑州市','2020-01-04','多云',10,'东北','4','中雨',-1,'东北','4',2),('郑州市','2020-01-05','小雨',1,'东北','4','中雨',1,'东北','4',3),('郑州市','2020-01-06','中雨',2,'北','5','中雨',0,'北','5',4),('长春市','2020-01-03','多云',-7,'西','≤3','多云',-14,'西','≤3',1),('长春市','2020-01-04','晴',-8,'西','≤3','晴',-15,'西','≤3',2),('长春市','2020-01-05','晴',-2,'西南','4','多云',-10,'西南','4',3),('长春市','2020-01-06','小雪',-1,'西北','≤3','多云',-14,'西北','≤3',4),('长沙市','2020-01-03','小雨',5,'无风向','≤3','小雨',5,'无风向','≤3',1),('长沙市','2020-01-04','阴',10,'南','≤3','多云',5,'南','≤3',2),('长沙市','2020-01-05','多云',19,'南','≤3','多云',7,'南','≤3',3),('长沙市','2020-01-06','阴',17,'北','4','小雨',7,'北','4',4);
/*!40000 ALTER TABLE `forecasts` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-03 23:30:07