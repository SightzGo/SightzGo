/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.57 : Database - sightzgo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sightzgo` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `sightzgo`;

/*Table structure for table `hobby` */

DROP TABLE IF EXISTS `hobby`;

CREATE TABLE `hobby` (
  `hobby_id` int(11) NOT NULL AUTO_INCREMENT,
  `content` char(80) NOT NULL,
  PRIMARY KEY (`hobby_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `hobby` */

insert  into `hobby`(`hobby_id`,`content`) values (1,'打排球'),(2,'打篮球'),(3,'唱歌'),(4,'跳舞'),(5,'看书'),(6,'画画'),(7,'睡觉'),(8,'做饭'),(9,'打电动'),(10,'旅游');

/*Table structure for table `signup` */

DROP TABLE IF EXISTS `signup`;

CREATE TABLE `signup` (
  `user_no` char(20) NOT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`user_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `signup` */

insert  into `signup`(`user_no`,`password`) values ('001','3824'),('009','7264'),('012','4483'),('054','7713'),('097','1860');

/*Table structure for table `subject` */

DROP TABLE IF EXISTS `subject`;

CREATE TABLE `subject` (
  `subject_id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`subject_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `subject` */

insert  into `subject`(`subject_id`,`content`) values (1,'计算机科学与技术'),(2,'网络工程'),(3,'软件工程'),(4,'教育信息技术'),(5,'历史文化'),(6,'学前教育'),(7,'英语翻译');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_no` char(20) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(80) COLLATE utf8_unicode_ci NOT NULL,
  `subject_id` int(11) NOT NULL,
  `sex` char(4) COLLATE utf8_unicode_ci NOT NULL,
  `telephone` char(20) COLLATE utf8_unicode_ci NOT NULL,
  `email` char(20) COLLATE utf8_unicode_ci NOT NULL,
  `birthday` date DEFAULT NULL,
  `assessment` tinyint(4) unsigned DEFAULT NULL,
  `sharetimes` mediumint(9) DEFAULT '0',
  PRIMARY KEY (`user_no`),
  KEY `subject_id` (`subject_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `user` */

insert  into `user`(`user_no`,`name`,`subject_id`,`sex`,`telephone`,`email`,`birthday`,`assessment`,`sharetimes`) values ('001','郑珣',1,'女','15625102632','353827338@qq.com','1996-11-01',NULL,0),('009','余泳桐',7,'女','13514055343','515044762@qq.co','1997-04-23',NULL,0),('012','李洁莹',3,'女','15025003147','14426544@qq.com','1997-01-12',NULL,0),('054','苏尔洁',4,'女','15625102439','762893301@qq.com','1996-08-30',NULL,0),('097','林根',6,'男','15625005271','724661299@qq.com','1997-10-09',NULL,0);

/*Table structure for table `user_experience` */

DROP TABLE IF EXISTS `user_experience`;

CREATE TABLE `user_experience` (
  `experience_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_no` char(20) CHARACTER SET utf8 NOT NULL,
  `content` text CHARACTER SET utf8 NOT NULL,
  `start_time` date NOT NULL,
  `end_time` date DEFAULT NULL,
  PRIMARY KEY (`experience_id`,`user_no`),
  KEY `user_no` (`user_no`),
  KEY `start_time` (`start_time`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `user_experience` */

insert  into `user_experience`(`experience_id`,`user_no`,`content`,`start_time`,`end_time`) values (1,'001','荣获学院科技之星\r\n','2016-06-15',NULL),(2,'097','荣获三好学生','2017-11-01',NULL),(3,'012','荣获V公益比赛一等奖','2016-08-12',NULL),(4,'001','荣获华南师范大学学生社团联合会第十六届方案设计大赛优秀奖','2015-11-08',NULL),(5,'001','荣获阳光体育排球赛女子团体五等奖','2017-03-06',NULL),(6,'009','荣获华南师范大学第十一届阳光小姐','2016-12-29',NULL);

/*Table structure for table `user_hobby` */

DROP TABLE IF EXISTS `user_hobby`;

CREATE TABLE `user_hobby` (
  `user_no` char(20) COLLATE utf8_unicode_ci NOT NULL,
  `hobby_id` int(11) NOT NULL,
  PRIMARY KEY (`user_no`,`hobby_id`),
  KEY `hobby_id` (`hobby_id`),
  CONSTRAINT `user_hobby_ibfk_2` FOREIGN KEY (`hobby_id`) REFERENCES `hobby` (`hobby_id`),
  CONSTRAINT `user_hobby_ibfk_1` FOREIGN KEY (`user_no`) REFERENCES `user` (`user_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `user_hobby` */

insert  into `user_hobby`(`user_no`,`hobby_id`) values ('097',1),('001',3),('009',4),('054',5),('001',6),('001',8),('097',9),('009',10),('012',10);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
