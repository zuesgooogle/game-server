/*
Source Server         : game server
Source Server Version : 1
Source Host           : 127.0.0.1:3306

Target Server Type    : MYSQL
Target Server Version : 1
File Encoding         : UTF-8
Mysql Engine		  : InnoDB


Author: Ren Yuan
Email : zeusgooogle@gmail.com
Date  : 2015-05-24 18:54:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for server_info
-- ----------------------------
DROP TABLE IF EXISTS `server_info`;
CREATE TABLE `server_info` (
  `id` varchar(20) NOT NULL COMMENT '主键',
  `start_time` timestamp NULL DEFAULT NULL COMMENT '开服时间',
  `prefix_id` varchar(20) DEFAULT NULL COMMENT '角色名前缀',
  `hefu_time` timestamp NULL DEFAULT NULL COMMENT '合服时间',
  `log_update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for id_gen
-- ----------------------------
DROP TABLE IF EXISTS `id_gen`;
CREATE TABLE `id_gen` (
  `id` varchar(100) NOT NULL DEFAULT '' COMMENT '主键',
  `module_name` varchar(36) NOT NULL DEFAULT '' COMMENT '模块名称',
  `value` bigint(10) unsigned NOT NULL COMMENT 'id值',
  `prefix` varchar(10) NOT NULL COMMENT '前缀',
  `version` int(10) unsigned NOT NULL COMMENT '版本',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
