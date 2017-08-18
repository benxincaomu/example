/*
Navicat MySQL Data Transfer

Source Server         : aliyun
Source Server Version : 50718
Source Host           : 139.196.54.105:3306
Source Database       : sample

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-08-18 17:04:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` varchar(36) NOT NULL,
  `name` varchar(20) DEFAULT NULL COMMENT '菜单名',
  `path` varchar(20) DEFAULT NULL COMMENT '路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限菜单';

-- ----------------------------
-- Records of permission
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `role_name` varchar(10) NOT NULL COMMENT '角色名',
  `description` varchar(100) DEFAULT NULL COMMENT '角色描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `can_deleted` tinyint(4) DEFAULT '1' COMMENT '是否可以删除(0--不可删除，1--可以删除)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_name_idx` (`role_name`) COMMENT '角色名唯一约束'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('ec79f4182bf911e7885f00163e0283c1', '系统管理员', '系统管理员', '2017-04-28 18:03:27', '0');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` varchar(36) NOT NULL DEFAULT '' COMMENT '主键',
  `role_id` varchar(36) DEFAULT NULL COMMENT '角色id',
  `permisson_id` varchar(36) DEFAULT NULL COMMENT '权限菜单id',
  PRIMARY KEY (`id`),
  KEY `role_idx` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限关联表';

-- ----------------------------
-- Records of role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(36) NOT NULL COMMENT '主键标识\r\n',
  `user_name` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(36) NOT NULL COMMENT '密码',
  `nick_name` varchar(10) DEFAULT NULL COMMENT '昵称',
  `name` varchar(10) DEFAULT NULL COMMENT '名字',
  `role_id` varchar(36) DEFAULT NULL COMMENT '角色id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '最近更新时间',
  `sex` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_un_idx` (`user_name`),
  KEY `user_name_idx` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('18d7335f264211e78dded8cb8af3a713', 'admin', '81dc9bdb52d04dc20036dbd8313ed055', '管理员', '管理员', null, null, null, '1');
