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
-- Table structure for user_account
-- ----------------------------
DROP TABLE IF EXISTS `user_account`;
CREATE TABLE `user_account` (
  `id` varchar(48) NOT NULL COMMENT '主键，根据user_role表里面的 user_id和server_id加@号拼接',
  `user_guid` varchar(36) NOT NULL COMMENT '对应user_role表里面的user_id',
  `lingshi` bigint(11) NOT NULL COMMENT '元宝数量',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `server_id` varchar(36) DEFAULT NULL COMMENT '服务器id',
  `recive_yb` int(11) DEFAULT NULL COMMENT '可领取元宝，存储无充值的玩家，所有获得的元宝（此功能已经作废）',
  `is_recharge` int(11) DEFAULT NULL COMMENT '是否充值',
  `log_update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_account_index` (`user_guid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` varchar(36) NOT NULL COMMENT '角色唯一主键',
  `user_id` varchar(36) NOT NULL COMMENT '角色账号id',
  `name` varchar(36) NOT NULL COMMENT '角色名称',
  `job` varchar(36) NOT NULL COMMENT '职业',
  `sex` int(1) NOT NULL COMMENT '性别',
  `exp` bigint(20) DEFAULT NULL COMMENT '经验',
  `level` int(1) DEFAULT '1' COMMENT '等级',
  `face` varchar(36) DEFAULT NULL COMMENT '头像',
  `zhenqi` int(11) DEFAULT '0' COMMENT '真气',
  `shengwang` int(11) DEFAULT '0' COMMENT '声望',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `online_time` bigint(20) DEFAULT NULL COMMENT '上线时间',
  `offline_time` bigint(20) DEFAULT NULL COMMENT '下线时间',
  `is_set_fangchenmi` int(11) NOT NULL DEFAULT '0' COMMENT '是否设置防沉迷',
  `chenmi_add_online` int(20) DEFAULT NULL,
  `chenmi_add_offline` int(20) DEFAULT NULL,
  `server_id` varchar(36) COMMENT '服务器id',
  `platform` varchar(36) DEFAULT NULL,
  `role_type` int(11) DEFAULT '0',
  `upgrade_time` bigint(20) DEFAULT NULL,
  `zhanli` int(11) DEFAULT NULL COMMENT '战斗力',
  `login_count` int(11) DEFAULT NULL COMMENT '登录次数',
  `time` bigint(20) DEFAULT NULL COMMENT '在线时间',
  `log_update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_user_role_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role_account
-- ----------------------------
DROP TABLE IF EXISTS `role_account`;
CREATE TABLE `role_account` (
  `id` varchar(36) NOT NULL,
  `user_role_id` varchar(36) NOT NULL COMMENT '角色唯一id',
  `tongqian` bigint(11) NOT NULL COMMENT '游戏币数量',
  `bind_lingshi` bigint(11) NOT NULL COMMENT '绑定元宝数量',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL,
  `log_update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_role_account_user_role_id` (`user_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role_stage
-- ----------------------------
DROP TABLE IF EXISTS `role_stage`;
CREATE TABLE `role_stage` (
  `user_role_id` varchar(36) NOT NULL,
  `map_id` varchar(255) DEFAULT NULL,
  `map_x` int(11) DEFAULT NULL,
  `map_y` int(11) DEFAULT NULL,
  `hp` int(11) DEFAULT NULL,
  `mp` int(11) DEFAULT NULL,
  `max_hp` int(11) DEFAULT NULL,
  `max_mp` int(11) DEFAULT NULL,
  `buff` text,
  `props` text,
  `state` int(1) DEFAULT NULL,
  `map_node` text,
  `ti_li` int(11) DEFAULT '0',
  `line_no` int(11) DEFAULT '0',
  `pk_info` text,
  `shanbi_val` int(11) DEFAULT '0',
  `meiren_info` text,
  `zuoqi_info` text,
  `free_fly_count` int(11) DEFAULT '0' COMMENT '今日免费飞行次数',
  `fly_count_refresh_time` bigint(20) DEFAULT '0' COMMENT '免费飞行次数刷新时间',
  `copy_info` varchar(255) DEFAULT NULL,
  `log_update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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

-- ----------------------------
-- Table structure for role_bag_slot
-- ----------------------------
DROP TABLE IF EXISTS `role_bag_slot`;
CREATE TABLE `role_bag_slot` (
  `id` varchar(36) NOT NULL,
  `slot_num` int(11) NOT NULL COMMENT '格子编号',
  `user_role_id` varchar(36) NOT NULL,
  `goods_id` varchar(36) NOT NULL COMMENT '物品ID',
  `count` int(36) DEFAULT '0' COMMENT '物品数量',
  `bind` int(11) NOT NULL DEFAULT '0' COMMENT '是否绑定',
  `expire_time` bigint(20) DEFAULT NULL COMMENT '物品过期时间毫秒数',
  `rare_level` int(11) DEFAULT NULL COMMENT '物品的稀有等级',
  `item_level` int(11) DEFAULT NULL COMMENT '物品等级',
  `attributes` text COMMENT '物品附加属性',
  `log_update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_role_bag_slot_user_role_id` (`user_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role_equip_slot
-- ----------------------------
DROP TABLE IF EXISTS `role_equip_slot`;
CREATE TABLE `role_equip_slot` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `slot_num` int(11) NOT NULL COMMENT '对应装备格子',
  `user_role_id` varchar(36) NOT NULL COMMENT '角色主键id',
  `goods_id` varchar(36) NOT NULL COMMENT '装备物品id',
  `count` int(36) DEFAULT '0' COMMENT '数量，始终为1',
  `bind` int(11) NOT NULL DEFAULT '0' COMMENT '是否绑定',
  `expire_time` bigint(20) DEFAULT NULL COMMENT '物品过期时间毫秒数',
  `rare_level` int(11) DEFAULT NULL COMMENT '物品的稀有等级',
  `item_level` int(11) DEFAULT NULL COMMENT '物品等级',
  `attributes` text COMMENT '物品附加属性',
  `log_update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_role_equip_slot_user_role_id` (`user_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for guild
-- ----------------------------
DROP TABLE IF EXISTS `guild`;
CREATE TABLE `guild` (
  `id` varchar(36) NOT NULL COMMENT '主键id',
  `name` varchar(20) NOT NULL COMMENT '帮派名字',
  `user_role_id` varchar(36) NOT NULL COMMENT '帮主的角色id',
  `fighting` bigint(20) DEFAULT '0' COMMENT '总战力',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL,
  `log_update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for guild_member
-- ----------------------------
DROP TABLE IF EXISTS `guild_member`;
CREATE TABLE `guild_member` (
  `id` varchar(36) NOT NULL DEFAULT '' COMMENT '主键',
  `guild_id` varchar(36) NOT NULL COMMENT '对应公会表主键',
  `user_role_id` varchar(36) NOT NULL COMMENT '角色唯一主键',
  `position` int(11) NOT NULL COMMENT '角色在公会里的职位 ',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `log_update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;