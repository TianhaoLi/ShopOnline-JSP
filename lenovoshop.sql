-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: lenovoshop
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `goods`
--

DROP TABLE IF EXISTS `goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `cover` varchar(45) DEFAULT NULL,
  `image1` varchar(45) DEFAULT NULL,
  `image2` varchar(45) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `intro` varchar(300) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_type_id_idx` (`type_id`),
  CONSTRAINT `fk_type_id` FOREIGN KEY (`type_id`) REFERENCES `type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods`
--

LOCK TABLES `goods` WRITE;
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
INSERT INTO `goods` VALUES (1,'拯救者 Y7000 15.6','/picture/1-1.jpg','/picture/1-2.jpg','/picture/1-3.jpg',7499,'高色域版 15.6英寸游戏笔记本 黑色\n高色域版 15.6英寸游戏笔记本 黑色 i5-8300H/Windows 10 家庭中文版/15.6英寸/8G/1T+128G SSD/ GeForce GTX 1060 6G独显/黑色',800,1),(2,'ideapad 330C-15IKB 15.6','/picture/2-1.jpg','/picture/2-2.jpg','/picture/2-3.jpg',4099,'15.6英寸笔记本 黑色\n15.6英寸笔记本 黑色 i5-8250U/Windows 10 家庭中文版/15.6英寸/4G/1T+128G SSD/MX110 2GB独显/黑色',800,1),(3,'小新 潮7000 14','/picture/3-1.jpg','/picture/3-2.jpg','/picture/3-3.jpg',5299,'14.0英寸轻薄笔记本 极光银 i5-8250U/Windows 10 家庭中文版/14.0英寸/4GB+4GB/1T+128G SSD/Radeon 535 2GB独显/极光银',800,1),(4,'小新 潮7000 13.3','/picture/4-1.jpg','/picture/4-2.jpg','/picture/3-3.jpg',5299,'13.3英寸轻薄笔记本 花火银 i5-8250U/Windows 10 家庭中文版/13.3英寸/8GB/256G SSD/MX150 2GB独显/花火银',800,1),(5,'小新 Air 13 13.3','/picture/5-1.jpg','/picture/5-2.jpg','/picture/5-3.jpg',5799,'13.3英寸超轻薄笔记本 轻奢灰 i5-8265U/Windows 10 家庭中文版/13.3英寸/8G/512G SSD/GeForce MX150 2G独显/轻奢灰',800,1),(6,'小新 Air 13 13.3','/picture/6-1.jpg','/picture/6-2.jpg','/picture/6-3.jpg',5499,'13.3英寸超轻薄笔记本 轻奢灰 英特尔八代酷睿i5-8265U/Windows 10 家庭中文版/13.3英寸/8G/256G SSD/GeForce MX150 2G独显/轻奢灰',800,1),(7,'拯救者 Y7000 高色域版','/picture/7-1.jpg','/picture/7-2.jpg','/picture/7-3.jpg',6499,'15.6英寸游戏笔记本 黑色 i5-8300H/Windows 10 家庭中文版/15.6英寸/8G/512G SSD/ GeForce GTX 1050Ti 4G独显/黑色',800,1),(8,'小新 潮7000 14','/picture/8-1.jpg','/picture/8-2.jpg','/picture/8-3.jpg',4599,'14.0英寸轻薄笔记本 极光银 AMD Ryzen 5 2500U//Windows 10 家庭中文版/14.0英寸/4GB+4GB/512G SSD/集成显卡/极光银',800,1),(9,'小新 潮7000 13.3 火花金','/picture/9-1.jpg','/picture/9-2.jpg','/picture/9-3.jpg',5299,'i5-8250U/Windows 10 家庭中文版/13.3英寸/8GB/256G SSD/MX150 2GB独显/火花金',800,1),(10,'拯救者 Y7000 高色域版','/picture/10-1.jpg','/picture/10-2.jpg','/picture/10-3.jpg',6499,'15.6英寸游戏笔记本 黑色 i5-8300H/Windows 10 家庭中文版/15.6英寸/8G/1T+128G SSD/ GeForce GTX 1050Ti 4G独显/黑色',800,1),(11,'拯救者 Y7000P 15.6','/picture/11-1.jpg','/picture/11-2.jpg','/picture/11-3.jpg',6899,'15.6英寸游戏笔记本 黑色 i5-8300H/Windows 10 家庭中文版/15.6英寸/8G/512G SSD/ GeForce GTX 1050Ti 4G独显/黑色',800,1),(12,'小新 Air 13 复古金','/picture/12-1.jpg','/picture/12-2.jpg','/picture/12-3.jpg',5499,'13.3英寸超轻薄笔记本 复古金 i5-8265U/Windows 10 家庭中文版/13.3英寸/8G/256G SSD/GeForce MX150 2G独显/复古金',800,1),(13,'小新 Air 13 轻奢灰','/picture/13-1.jpg','/picture/13-2.jpg','/picture/13-3.jpg',6599,'13.3英寸超轻薄笔记本 轻奢灰 i7-8565U/Windows 10 家庭中文版/13.3英寸/8G/512G SSD/GeForce MX150 2G独显/轻奢灰',800,1),(14,'拯救者 Y7000P 15.6','/picture/14-1.jpg','/picture/14-2.jpg','/picture/14-3.jpg',10499,'15.6英寸游戏笔记本 黑色 i7-8750H/Windows 10 家庭中文版/15.6英寸/16G/2T+512G SSD/ GeForce GTX 1060 6G独显/黑色',800,1),(15,'拯救者 Y7000 高色域版','/picture/15-1.jpg','/picture/15-2.jpg','/picture/15-3.jpg',8299,'15.6英寸游戏笔记本 黑色 i7-8750H/Windows 10 家庭中文版/15.6英寸/8G/512G SSD/ GeForce GTX 1060 6G独显/黑色',800,1),(16,'YOGA 7 Pro-13IKB（YOGA C930）','/picture/16-1.jpg','/picture/16-2.jpg','/picture/16-3.jpg',16888,'3.9英寸触控笔记本 深灰 i7-8550U/Windows 10 家庭中文版/13.9英寸/16G/1T SSD/集成显卡/深灰',800,1),(17,'YOGA Book 2 墨水屏双屏电脑','/picture/17-1.jpg','/picture/17-2.jpg','/picture/17-3.jpg',10599,'Intel® Core™ i5-7Y54处理器/Windows 10 家庭版/4GB/256GB SSD/雅黑',800,1),(18,'YOGA S730-13IWL','/picture/18-1.jpg','/picture/18-2.jpg','/picture/18-3.jpg',8999,'13.3英寸笔记本 深灰 i7-8565U/Windows 10 家庭中文版/13.3英寸/8G/512G SSD/集成显卡/深灰',800,1),(19,'ideapad 330C-14IKB','/picture/19-1.jpg','/picture/19-2.jpg','/picture/19-3.jpg',4199,'14.0英寸笔记本 黑色 14.0英寸笔记本 黑色',800,1),(20,'ideapad 720S-13IKB','/picture/20-1.jpg','/picture/20-2.jpg','/picture/20-3.jpg',6199,'3.3英寸笔记本 黑色 81BV002MCD i5-8250U/Windows 10 家庭中文版/13.3英寸/8G/256G SSD/集成显卡/黑色',800,1),(21,'联想Z5 Pro 6GB+64GB 陶瓷黑','/picture/21-1.jpg','/picture/21-2.jpg','/picture/21-3.jpg',1998,'划时代旗舰 | 95.06%超级屏占比 | 第五代光电屏下指纹 | 2400万AI四摄 | 双螺旋滑轨',800,2),(22,'联想K5s 4GB+32GB 哥特黑','/picture/22-1.jpg','/picture/22-2.jpg','/picture/22-3.jpg',698,'\"魅力四摄，自拍更美 | 前后1300万AI四摄 | 幻彩炫光双面玻璃\"',800,2),(23,'联想K5 Pro 6GB+64GB 格调黑','/picture/23-1.jpg','/picture/23-2.jpg','/picture/23-3.jpg',1048,'千元影霸 | 4050 mAh大电池 | 6英寸FHD+全面屏 | 双声道Dirac 音效',800,2),(24,'联想Z5s 6GB+64GB 星夜灰','/picture/24-1.jpg','/picture/24-2.jpg','/picture/24-3.jpg',1598,'骁龙710AIE处理器 | 后置AI变焦三摄 | 92.6%屏占比水滴屏 | 靓彩渐变玻璃机身',800,2),(25,'联想S5 Pro 6GB+64GB 晶耀黑','/picture/25-1.jpg','/picture/25-2.jpg','/picture/25-3.jpg',1198,'偶像级自拍 | 前后2000万AI四摄 | 深度相机光学变焦 |零光感人脸解锁',800,2),(26,'thinkplus 口红电源','/picture/26-1.jpg','/picture/26-2.jpg','/picture/26-3.jpg',299,'\"65W多功能快充 126g / 0.063小巧体型,宛如口红,即刻满血\"',800,3),(27,'ThinkCentre E75s小型台式机','/picture/27-1.jpg','/picture/27-2.jpg','/picture/27-3.jpg',4299,'i5-7400/Windows 10 家庭中文版/4GB/500GB/集显/小机箱/显示器需另配',800,3),(28,'ThinkPad E580 笔记本电脑','/picture/28-1.jpg','/picture/28-2.jpg','/picture/28-3.jpg',5999,'i5-8250U/Windows 10 家庭版/8GB/256GB SSD/独显/黑色',800,3),(29,'ThinkPad X1 Carbon 2018 笔记本电脑','/picture/29-1.jpg','/picture/29-2.jpg','/picture/29-3.jpg',9999,'i5-8250U/Windows 10 家庭版/8GB/256GB SSD/UHD 620显示芯片/黑色',800,3),(30,'ThinkPad X1 隐士 笔记本电脑','/picture/30-1.jpg','/picture/30-2.jpg','/picture/30-3.jpg',18999,'i7-8750H/Windows10 专业版/16GB/512GB SSD/独显/黑色',800,3),(31,'ThinkPad E480 笔记本电脑','/picture/31-1.jpg','/picture/31-2.jpg','/picture/31-3.jpg',5299,'i5-8250U/Windows 10 家庭版/8GB/1TB/独显/黑色',800,3),(32,'ThinkPad T480 笔记本电脑','/picture/32-1.jpg','/picture/32-2.jpg','/picture/32-3.jpg',8299,'i5-8250U/Windows 10 家庭版/8GB/500GB+128GB SSD/独显',800,3),(33,'ThinkPad New S2 2018 银色','/picture/33-1.jpg','/picture/33-2.jpg','/picture/33-3.jpg',5999,'i5-8250U/Windows 10 家庭版/8GB/256GB SSD/UHD 620显示芯片/FHD/银色',800,3),(34,'ThinkPad X1 Yoga 2018 笔记本电脑','/picture/34-1.jpg','/picture/34-2.jpg','/picture/34-3.jpg',11999,'i5-8250U/Windows 10 家庭版/8GB/256GB SSD/UHD 620显示芯片/黑色',800,3),(35,'MIIX 520 二合一笔记本','/picture/35-1.jpg','/picture/35-2.jpg','/picture/35-3.jpg',4899,'12.2英寸 i3含键盘 星际灰 i3-7100U/Windows 10家庭中文版/4G/128G SSD/星际灰/含键盘',800,4),(36,'联想P8 平板电脑 8英寸 WIFI 深邃蓝','/picture/36-1.jpg','/picture/36-2.jpg','/picture/36-3.jpg',949,'高通骁龙625/Android /3GB/16GB/深邃蓝',800,4),(37,'【新品首发】联想X3无线蓝牙运动耳机 手机磁吸入耳式音乐耳机','/picture/37-1.jpg','/picture/37-2.jpg','/picture/37-3.jpg',149,'颈挂式耳机 重低音 蓝牙传输',800,5),(38,'【限时秒杀】联想 8倍速 GP70N外置光驱 DVD刻录机 移动光驱 黑色','/picture/38-1.jpg','/picture/38-2.jpg','/picture/38-3.jpg',199,'\"出色性价比！即插即用，读取、刻录DVD/CD两不误\"',800,5),(39,'联想小新麦克风K歌宝全民k歌定制版（星空黑）','/picture/39-1.jpg','/picture/39-2.jpg','/picture/39-3.jpg',268,'随时随地想唱就唱',800,5),(40,'【899限时抢购】联想S23d显示器22.5英寸 商用办公电脑显示器','/picture/41-1.jpg','/picture/41-2.jpg','/picture/41-3.jpg',899,'22.5英寸 2mm臻窄边框 TÜV 低蓝光认证 100×100mm标准VESA壁挂孔 16：10黄金屏幕比例',800,5),(41,'联想智能插座','/picture/42-1.jpg','/picture/42-2.jpg','/picture/42-3.jpg',59,'小身材 | 多用处 | 普通家电变智能',800,7),(42,'联想（Lenovo）平衡车儿童 成人独轮电动平衡车 蛋蛋体感车 智能代步车','/picture/43-1.jpg','/picture/43-2.jpg','/picture/43-3.jpg',2199,'有趣 简单 轻便 儿童 成人独轮智能平衡车 蛋蛋体感车 智能代步车',800,7),(43,'联想智能空气净化器','/picture/44-1.jpg','/picture/44-2.jpg','/picture/44-3.jpg',1499,'\"CADR值高达600，净化快丨31.6分贝低噪处理丨PM2.5超标智能自启\"',800,7),(44,'科大讯飞阿尔法蛋 陪伴学习智能教育机器人','/picture/45-1.jpg','/picture/45-2.jpg','/picture/45-3.jpg',2999,'双语同步教材',800,8),(45,'Beats Studio3 Wireless 录音师无线3 红色','/picture/46-1.jpg','/picture/46-2.jpg','/picture/46-3.jpg',2488,'\"Pure ANC (自适应消噪)主动阻隔外界噪音； 实时音频校准，打造至臻聆听体验； 长达 22 小时的电池使用时间，支持全天无线播放； 实现 1 类无线蓝牙® 连接，提升电池能效\"',800,8);
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `total` float DEFAULT NULL,
  `amount` int(6) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `paytype` tinyint(1) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `datetime` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_id_idx` (`user_id`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (23,15996,4,2,2,'管理员测试账户','17806259318','青岛海洋大学','2018-12-27 02:05:49',1);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderitem`
--

DROP TABLE IF EXISTS `orderitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderitem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `price` float DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_goods_id_idx` (`goods_id`),
  KEY `fk_order_id_idx` (`order_id`),
  CONSTRAINT `fk_order_id` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`),
  CONSTRAINT `fk_orderitem_goods_id` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderitem`
--

LOCK TABLES `orderitem` WRITE;
/*!40000 ALTER TABLE `orderitem` DISABLE KEYS */;
INSERT INTO `orderitem` VALUES (30,6499,1,7,23),(31,4599,2,8,23),(32,299,1,26,23);
/*!40000 ALTER TABLE `orderitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recommend`
--

DROP TABLE IF EXISTS `recommend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recommend` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` tinyint(1) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_goods_id_idx` (`goods_id`),
  CONSTRAINT `fk_goods_id` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recommend`
--

LOCK TABLES `recommend` WRITE;
/*!40000 ALTER TABLE `recommend` DISABLE KEYS */;
INSERT INTO `recommend` VALUES (1,1,34),(2,2,7),(3,2,8),(4,2,16),(5,2,17),(6,2,18),(7,2,21),(8,2,26),(9,2,27),(10,2,29),(11,2,35),(12,3,40),(13,3,37),(14,3,38),(15,3,43),(16,3,45),(17,3,44),(18,3,1),(19,3,3),(20,3,39),(21,3,16),(22,3,42);
/*!40000 ALTER TABLE `recommend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type`
--

DROP TABLE IF EXISTS `type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type`
--

LOCK TABLES `type` WRITE;
/*!40000 ALTER TABLE `type` DISABLE KEYS */;
INSERT INTO `type` VALUES (1,'Lenovo 电脑'),(2,'手机'),(3,'ThinkPad 电脑'),(4,'平板电脑'),(5,'选件'),(6,'服务/配件'),(7,'智能'),(8,'智选');
/*!40000 ALTER TABLE `type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `isadmin` bit(1) DEFAULT NULL,
  `isvalidate` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','admin@sina.com','123','管理员测试账户','17806259318','青岛海洋大学','','\0'),(2,'123','123@11.com','123','你好','你好','你好','\0','\0'),(3,'a','a','a','a','a','a','\0','\0'),(4,'b','b','b','','','','\0','\0'),(7,'e','e','e','e','e','e','\0','\0'),(8,'f','f','f','f','f','f','\0','\0'),(9,'g','g','g','g','g','g','\0','\0'),(10,'h','h','h','h','h','h','\0','\0'),(11,'i','i','i','i','i','i','\0','\0'),(12,'j','j','j','j','j','j','\0','\0'),(13,'k','k','k','k','k','k','\0','\0'),(14,'l','l','l','','','','\0','\0'),(15,'m','m','m','','','','\0','\0'),(16,'n','n','n','n','n','','\0','\0'),(17,'odolgtt','odolgtt@sina.com','123456','123','123','123','\0','\0'),(18,'odolgtt111','111','111','','','','\0','\0'),(19,'odolgttt','123','123','2','2','2','\0','\0');
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

-- Dump completed on 2018-12-27 11:49:38
