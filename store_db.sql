# SQL Manager 2007 Lite for MySQL 4.4.2.1
# ---------------------------------------
# Host     : localhost
# Port     : 3306
# Database : store_db


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES latin1 */;

SET FOREIGN_KEY_CHECKS=0;

CREATE DATABASE `store_db`
    CHARACTER SET 'latin1'
    COLLATE 'latin1_swedish_ci';

USE `store_db`;

#
# Structure for the `address` table : 
#

CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL COMMENT '?????',
  `country` varchar(20) DEFAULT NULL,
  `province` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `destination` varchar(20) DEFAULT NULL,
  `postcode` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Structure for the `orderitem` table : 
#

CREATE TABLE `orderitem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderId` int(11) NOT NULL,
  `proId` int(11) NOT NULL,
  `proName` varchar(20) DEFAULT NULL,
  `proCount` int(11) DEFAULT NULL,
  `smallPrice` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Structure for the `user` table : 
#

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `tpassword` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `orderset` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `userName` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Structure for the `orders` table : 
#

CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `totalPrice` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `stateId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  CONSTRAINT `orders_fk` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

#
# Structure for the `product` table : 
#

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `discount` int(11) DEFAULT NULL,
  `description` varchar(20) DEFAULT NULL,
  `img` varchar(50) DEFAULT NULL,
  `typeid` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `hotproduct` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `typeid` (`typeid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

#
# Structure for the `producttype` table : 
#

CREATE TABLE `producttype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Data for the `address` table  (LIMIT 0,500)
#

INSERT INTO `address` (`id`, `userName`, `name`, `country`, `province`, `city`, `destination`, `postcode`, `phone`) VALUES 
  (1,'weixinghua','bigdata','GB','hebei','shijiazhuang','hebeishida','050000','15732160693'),
  (4,'weixinghua','sadf','GB','asdf','wef','111','111','111');
COMMIT;

#
# Data for the `orderitem` table  (LIMIT 0,500)
#

INSERT INTO `orderitem` (`id`, `orderId`, `proId`, `proName`, `proCount`, `smallPrice`) VALUES 
  (1,1,3,'MI TV',2,24),
  (2,1,7,'Apple TV',1,1234);
COMMIT;

#
# Data for the `user` table  (LIMIT 0,500)
#

INSERT INTO `user` (`id`, `userName`, `password`, `tpassword`, `email`, `age`, `phone`, `orderset`) VALUES 
  (1,'zs','123','123','123',12,'13673163257',NULL),
  (2,'sss','123456','123456','123456',23,'15732160692',NULL),
  (3,'weixinghua','weixinghua','weixinghua','844366624@qq.com',100,'13643319513',NULL),
  (4,'lixiaoya','lixiaoya','lixiaoya','lixiaoya',24,'15732168830',NULL);
COMMIT;

#
# Data for the `orders` table  (LIMIT 0,500)
#

INSERT INTO `orders` (`id`, `totalPrice`, `userId`, `name`, `stateId`) VALUES 
  (1,100,3,'MI TV',1),
  (2,100,3,'iPhone',0),
  (5,290,4,'lalal',1),
  (6,100,3,NULL,0),
  (7,100,3,NULL,0),
  (8,38,3,NULL,0),
  (9,83,3,'',0),
  (10,50,3,'',0),
  (11,59,3,'',0),
  (12,2404,3,'',0),
  (13,44,3,'',0),
  (14,70,3,'',0),
  (15,61,3,'',0),
  (16,2391,3,'',0),
  (17,42,3,'',0),
  (18,2376,3,'',0),
  (19,106,3,'',0),
  (20,2373,3,'',0),
  (21,47,3,'',0),
  (22,2372,3,'',0),
  (23,2402,3,'',0);
COMMIT;

#
# Data for the `product` table  (LIMIT 0,500)
#

INSERT INTO `product` (`id`, `name`, `price`, `discount`, `description`, `img`, `typeid`, `date`, `hotproduct`) VALUES 
  (1,'Thinkpad',12,11,'123',NULL,1,'2017-09-11 00:23:29',1),
  (2,'HAWEI mate9',13,12,'456',NULL,4,'2017-09-11 00:23:28',1),
  (3,'MI TV',45,12,'lvelvelve',NULL,3,'2017-09-11 00:23:27',1),
  (4,'pad MAC',14,23,'lululu',NULL,2,'2017-09-11 00:23:26',0),
  (5,'lenovo3',16,11,'hahahha',NULL,1,'2017-09-11 00:23:25',1),
  (6,'OPPO R11s',18,43,'lalalala',NULL,4,'2017-09-11 00:23:24',0),
  (7,'Apple TV',2345,1234,'????',NULL,3,'2017-09-11 00:23:23',0);
COMMIT;

#
# Data for the `producttype` table  (LIMIT 0,500)
#

INSERT INTO `producttype` (`id`, `name`) VALUES 
  (1,'Computer'),
  (2,'pad'),
  (3,'TV'),
  (4,'phone');
COMMIT;



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;