/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.57 : Database - sightzgogo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sightzgogo` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `sightzgogo`;

/*Table structure for table `experience` */

DROP TABLE IF EXISTS `experience`;

CREATE TABLE `experience` (
  `id` int(100) NOT NULL,
  `user_no` char(20) NOT NULL,
  `content` varchar(100) NOT NULL,
  `starttime` date DEFAULT NULL,
  `endtime` date DEFAULT NULL,
  PRIMARY KEY (`id`,`user_no`),
  KEY `user_no` (`user_no`),
  CONSTRAINT `experience_ibfk_1` FOREIGN KEY (`user_no`) REFERENCES `user` (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `experience` */

/*Table structure for table `hobby` */

DROP TABLE IF EXISTS `hobby`;

CREATE TABLE `hobby` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `content` varchar(80) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `hobby` */

/*Table structure for table `signup` */

DROP TABLE IF EXISTS `signup`;

CREATE TABLE `signup` (
  `id` char(20) NOT NULL,
  `password` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `signup` */

/*Table structure for table `subject` */

DROP TABLE IF EXISTS `subject`;

CREATE TABLE `subject` (
  `id` int(100) NOT NULL,
  `content` varchar(80) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `subject` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `no` char(20) NOT NULL,
  `name` varchar(80) NOT NULL,
  `subject_id` int(20) NOT NULL,
  `sex` char(4) NOT NULL,
  `telephone` char(20) NOT NULL,
  `email` char(20) NOT NULL,
  `birthday` date DEFAULT NULL,
  `assessment` tinyint(4) DEFAULT NULL,
  `sharetimes` int(100) DEFAULT NULL,
  PRIMARY KEY (`no`),
  KEY `subject_id` (`subject_id`),
  CONSTRAINT `user_ibfk_2` FOREIGN KEY (`no`) REFERENCES `signup` (`id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user` */

/*Table structure for table `user_hobby` */

DROP TABLE IF EXISTS `user_hobby`;

CREATE TABLE `user_hobby` (
  `user_no` char(20) NOT NULL,
  `hobby_id` int(100) NOT NULL,
  PRIMARY KEY (`user_no`,`hobby_id`),
  KEY `hobby_id` (`hobby_id`),
  CONSTRAINT `user_hobby_ibfk_1` FOREIGN KEY (`user_no`) REFERENCES `user` (`no`),
  CONSTRAINT `user_hobby_ibfk_2` FOREIGN KEY (`hobby_id`) REFERENCES `hobby` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user_hobby` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
