/*
Navicat MySQL Data Transfer

Source Server         : 727
Source Server Version : 50728
Source Host           : www.gmself.com:3306
Source Database       : blue

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2019-10-16 18:10:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account_login
-- ----------------------------
DROP TABLE IF EXISTS `account_login`;
CREATE TABLE `account_login` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '登录表id',
  `user_id` int(11) NOT NULL DEFAULT '-1' COMMENT '用户id',
  `passwd` varchar(255) DEFAULT NULL COMMENT '登录密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
