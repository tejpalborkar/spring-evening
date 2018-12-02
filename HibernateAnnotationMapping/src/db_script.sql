drop database if exists hibernate_annotation;

create database hibernate_annotation;

use hibernate_annotation;

CREATE TABLE `employee` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT,
  `birth_date` date DEFAULT NULL,
  `cell_phone` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) NOT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=latin1;

CREATE TABLE `employee_detail` (
  `employee_id` int(11) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;