/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : clothes

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2016-08-10 14:00:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `picture`
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture` (
  `pic_id` bigint(20) NOT NULL,
  `pic_name` varchar(30) NOT NULL,
  `pic_relative_path` varchar(50) DEFAULT NULL,
  `pic_absolute_path` varchar(50) DEFAULT NULL,
  `user_name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`pic_id`,`pic_name`),
  KEY `user_name` (`user_name`),
  CONSTRAINT `user_name` FOREIGN KEY (`user_name`) REFERENCES `user` (`user_name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of picture
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `permission` int(11) NOT NULL,
  `user_name` varchar(30) NOT NULL,
  `password` varchar(30) DEFAULT NULL,
  `icon` varchar(50) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

