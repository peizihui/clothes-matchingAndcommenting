-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.5.5-10.0.13-MariaDB - mariadb.org binary distribution
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 clothes 的数据库结构
CREATE DATABASE IF NOT EXISTS `clothes` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `clothes`;


-- 导出  表 clothes.picture 结构
CREATE TABLE IF NOT EXISTS `picture` (
  `pic_id` bigint(20) NOT NULL,
  `pic_name` varchar(30) NOT NULL,
  `pic_relative_path` varchar(50) DEFAULT NULL,
  `pic_absolute_path` varchar(50) DEFAULT NULL,
  `user_name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`pic_id`,`pic_name`),
  KEY `user_name` (`user_name`),
  CONSTRAINT `user_name` FOREIGN KEY (`user_name`) REFERENCES `user` (`user_name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。


-- 导出  表 clothes.t_clothing 结构
CREATE TABLE IF NOT EXISTS `t_clothing` (
  `n_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '递增主键',
  `c_cloth_icon` bigint(20) NOT NULL DEFAULT '0' COMMENT '服装图标',
  `c_desc` varchar(50) NOT NULL DEFAULT '0' COMMENT '服装描述',
  `n_createTime` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建时间',
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='服装';

-- 数据导出被取消选择。


-- 导出  表 clothes.t_collect 结构
CREATE TABLE IF NOT EXISTS `t_collect` (
  `n_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键递增',
  `n_collect_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '收藏作品id',
  `n_user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '收藏用户id',
  `n_collect_time` bigint(20) NOT NULL DEFAULT '0' COMMENT '收藏时间',
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收藏表';

-- 数据导出被取消选择。


-- 导出  表 clothes.t_comment 结构
CREATE TABLE IF NOT EXISTS `t_comment` (
  `n_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '递增主键id',
  `n_topic_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '关联服装表主键id',
  `n_topic_type` tinyint(4) DEFAULT '0' COMMENT '评论类型',
  `c_content` varchar(50) DEFAULT '0' COMMENT '评论内容',
  `n_from_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '评论用户id',
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论表';

-- 数据导出被取消选择。


-- 导出  表 clothes.t_like 结构
CREATE TABLE IF NOT EXISTS `t_like` (
  `n_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自动递增主键',
  `n_clothing_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '关联服装主键id',
  `n_like_time` bigint(20) NOT NULL DEFAULT '0' COMMENT '点赞时间',
  `n_user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '点赞用户id',
  `n_status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '点赞状态，1：点赞，2：取消',
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='记录点赞数量表';

-- 数据导出被取消选择。


-- 导出  表 clothes.t_reply 结构
CREATE TABLE IF NOT EXISTS `t_reply` (
  `n_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键递增id',
  `n_comment_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '关联评论表主键id',
  `n_reply_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '回复目标id',
  `n_reply_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '回复类型1:comment 2:reply',
  `c_content` varchar(50) DEFAULT '0' COMMENT '回复内容',
  `n_from_uid` bigint(20) NOT NULL DEFAULT '0' COMMENT '回复用户id',
  `n_to_uid` bigint(20) NOT NULL DEFAULT '0' COMMENT '目标用户id',
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='回复表';

-- 数据导出被取消选择。


-- 导出  表 clothes.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `permission` int(11) NOT NULL,
  `user_name` varchar(30) NOT NULL,
  `password` varchar(30) DEFAULT NULL,
  `icon` varchar(50) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
ALTER TABLE `t_clothing`
	CHANGE COLUMN `c_cloth_icon` `c_cloth_icon` VARCHAR(50) NOT NULL DEFAULT '0' COMMENT '服装图标' AFTER `n_id`;
	
ALTER TABLE `t_comment`
	ADD COLUMN `n_createTime` BIGINT(20) NOT NULL DEFAULT '0' COMMENT '创建时间' AFTER `n_from_id`;

ALTER TABLE `t_reply`
	ADD COLUMN `n_createTime` BIGINT(20) NOT NULL DEFAULT '0' COMMENT '创建时间' AFTER `n_to_uid`;