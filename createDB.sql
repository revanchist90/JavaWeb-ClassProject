DROP DATABASE `animals`;

CREATE DATABASE `animals` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `animals`;

CREATE TABLE `animals` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `url` varchar (200) NOT NULL,
  `name` varchar (100) NOT NULL,
  `type` varchar (100) NOT NULL,
  `age` double NOT NULL,
  PRIMARY KEY (`id`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;