/*
Navicat MySQL Data Transfer

Source Server         : myserver
Source Server Version : 50614
Source Host           : localhost:3306
Source Database       : spring_security

Target Server Type    : MYSQL
Target Server Version : 50614
File Encoding         : 65001

Date: 2017-07-03 13:46:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单唯一标识（自动增长）',
  `menu_name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '菜单名称',
  `menu_parent_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '当前菜单父菜单ID',
  `menu_resc_str` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '菜单对应的路径资源',
  `menu_type` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '菜单类型(0： 菜单  | 1 : 资源 | 2： label标签)',
  `menu_description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '菜单描述',
  `menu_level` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '菜单等级',
  `menu_status` varchar(2) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '菜单状态',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '首页', '0', '/security/home', '0', '系统首页', '100000', null);
INSERT INTO `menu` VALUES ('2', '教程', '0', null, '0', 'importNew 系统教程', '200000', null);
INSERT INTO `menu` VALUES ('3', '架构', '0', null, '0', 'importNew 机构讲解', '300000', null);
INSERT INTO `menu` VALUES ('4', 'java教程', '2', '/course/java', '0', 'java教程', '210000', null);
INSERT INTO `menu` VALUES ('5', 'mysql教程', '2', '/course/mysql', '0', 'mysql教程', '210001', null);
INSERT INTO `menu` VALUES ('6', 'spring-boot教程', '2', '/course/springboot', '0', 'springboot教程', '210002', null);
INSERT INTO `menu` VALUES ('7', '分布式架构', '3', '/architecture/distribute', '0', '分布式架构', '310000', null);
INSERT INTO `menu` VALUES ('8', 'dubbo架构', '3', '/architecture/dubbo', '0', 'dubbo机构', '310001', null);
INSERT INTO `menu` VALUES ('9', 'redis原理', '3', '/architecture/redis', '0', 'redis原理', '310002', null);
INSERT INTO `menu` VALUES ('10', 'spring-security原理', '3', '/architecture/security', '0', 'spring-security原理', '310003', null);
INSERT INTO `menu` VALUES ('11', '菜单列表', null, '/menu/list', '1', '菜单列表', null, null);

-- ----------------------------
-- Table structure for persistent_logins
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins` (
  `username` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `series` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `token` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of persistent_logins
-- ----------------------------
INSERT INTO `persistent_logins` VALUES ('hl', '/MEbTRLtXfsv33qg3b5hKw==', 'ebnvf+lq364TZ3sN0+o39g==', '2017-06-21 20:41:59');
INSERT INTO `persistent_logins` VALUES ('hl', '++DtkQJbNjbKS9F6kxmwfQ==', 'rezUhZ4muYofAq8d+Tkynw==', '2017-06-21 20:44:48');
INSERT INTO `persistent_logins` VALUES ('hl', '0lE1ZnFnE9PX/P8e/riIjw==', '7awXydz1uEgPjF9pbP6m7A==', '2017-06-21 20:26:52');
INSERT INTO `persistent_logins` VALUES ('hl', '5/lc796x34ahnxzmWQveJw==', 'KJl70w6MaBYLuEmiuGCVHg==', '2017-06-21 20:34:38');
INSERT INTO `persistent_logins` VALUES ('hl', '6LEsk4tI531e6tMGoZhGOA==', '4iYXZf3W/7eJ+P9o5Z6wYQ==', '2017-06-30 14:35:40');
INSERT INTO `persistent_logins` VALUES ('hl', '7gyeh5M0QUavnINm0aZ6+g==', 'pt+u69MSRaAyXEAQq6/+iw==', '2017-06-20 13:03:51');
INSERT INTO `persistent_logins` VALUES ('hl', 'CUGSXtpDSiSLqVghMttBlg==', 'KzBL774+j8SLtgdT/+fRfA==', '2017-06-21 15:46:47');
INSERT INTO `persistent_logins` VALUES ('hl', 'dPLpgA8jAK6ZLysqX9R6AQ==', 'eXaX/yzkAX0mkAly1ESmdw==', '2017-06-20 15:30:50');
INSERT INTO `persistent_logins` VALUES ('hl', 'DXgeGjLfvXRaM61sSa9K+w==', 'uHTcibtosv8drc0djFVfJA==', '2017-06-21 15:43:24');
INSERT INTO `persistent_logins` VALUES ('hl', 'dxUcYH6/UjKBCrSezSPoSg==', 'iWWGpPNz6JI/MKNZ/iUxwQ==', '2017-06-21 20:33:00');
INSERT INTO `persistent_logins` VALUES ('hl', 'E7mfDuNRqDspVBNb3hFTXQ==', 'kv7e/HejnrKlVxmfXhjXHg==', '2017-06-21 16:11:53');
INSERT INTO `persistent_logins` VALUES ('hl', 'fLzxHixLXTbdrG0v/r0Vxw==', '0PVvXsUMOi/OlBZleGuS7Q==', '2017-06-21 16:23:26');
INSERT INTO `persistent_logins` VALUES ('hl', 'GRh0vO5KUJCwmyU8475T/A==', 'BAygQfa9YlKBuZscAPZ9qw==', '2017-06-21 15:19:25');
INSERT INTO `persistent_logins` VALUES ('hl', 'H+7m7eAUirfhMjuVkJ2kNg==', 'b/MbYFd735j0/VP4/CcmOQ==', '2017-06-21 15:09:06');
INSERT INTO `persistent_logins` VALUES ('hl', 'h6lJqftwLQ9EPGhWBtCLqQ==', 'nV6zFltmsk3j3gOSzo5lkQ==', '2017-06-21 16:30:55');
INSERT INTO `persistent_logins` VALUES ('hl', 'HYnkXXcWrYzsM4vJ8YroyQ==', 'tex8gQQLLoWVWaKJM3BGWQ==', '2017-06-21 15:48:42');
INSERT INTO `persistent_logins` VALUES ('hl', 'LW4evplSPJDLsBfy+WXuzg==', 'l7UxvB+2dKmQvdNAq39mgg==', '2017-06-21 15:16:12');
INSERT INTO `persistent_logins` VALUES ('hl', 'MPvRbQkmpV990oioGiLZ3w==', 'EWofmiSUQEwreLn8exfHkw==', '2017-06-21 16:08:36');
INSERT INTO `persistent_logins` VALUES ('hl', 'mQXorVO1X/498RQY7hzqCA==', 'RJTcKO8Hm9qcJyFYv5lVoA==', '2017-06-30 14:34:44');
INSERT INTO `persistent_logins` VALUES ('hl', 'Nckr4MfDhSJLjuHSx+b2HA==', '+ldjLlwkpT0fOd9l6LFyNA==', '2017-06-21 20:10:19');
INSERT INTO `persistent_logins` VALUES ('hl', 'NOYAl3x2hp4AwNFetP2buw==', 'Zq5ZIWYBvstrrwCdROPTAQ==', '2017-06-21 15:41:55');
INSERT INTO `persistent_logins` VALUES ('hl', 'O2NSzqmllaaTplfmqNwk9w==', 'Vm8uVI2SwqE8Ju6aRia3Sg==', '2017-06-30 16:05:27');
INSERT INTO `persistent_logins` VALUES ('hl', 'oYRsoOlt4JNWbQpHE428vg==', 'h3kt90yZ+TBvSinKJLpNSw==', '2017-06-21 16:05:41');
INSERT INTO `persistent_logins` VALUES ('hl', 'OziCt71P+d4wkNmdKEpN3g==', 'E1dqjSfDKPBM5deIVzf85w==', '2017-06-21 15:24:45');
INSERT INTO `persistent_logins` VALUES ('hl', 'PCL+0hQlMSvnsAZQhtXG6A==', 'EUVBKF+i+kmxVN68sYnm7w==', '2017-06-30 14:34:50');
INSERT INTO `persistent_logins` VALUES ('hl', 'Rykc1Kbx15Ij/hvOwOkGYg==', 'bCXgXYApt2CbLHDVf4kp5w==', '2017-06-21 21:16:17');
INSERT INTO `persistent_logins` VALUES ('hl', 'rywHgRKOhPgTOw/Fgg6TsA==', '1TYzNYbQhTFEy52YGmdd+A==', '2017-06-21 16:15:34');
INSERT INTO `persistent_logins` VALUES ('hl', 'soB5JtEyxCWETvsT15DaLw==', '/cWHvQ28+PaTeT1fHY3MBA==', '2017-06-21 15:17:23');
INSERT INTO `persistent_logins` VALUES ('hl', 'uQSR6w2zfl432FL1OW6rvw==', 'FSksWQ9uw6+u3y6YQdFgaQ==', '2017-06-21 15:09:27');
INSERT INTO `persistent_logins` VALUES ('hl', 'wtW+Dz+xiYVzobQpm1/nUA==', 'dJht+EDNtGs3oIk3t1ryEA==', '2017-06-21 15:11:06');
INSERT INTO `persistent_logins` VALUES ('hl', 'XLdvgeVlkUBmTjZY9oHiKQ==', 'weaJ4StBT6RcxKGwyLIAIw==', '2017-06-21 15:57:25');
INSERT INTO `persistent_logins` VALUES ('hl', 'zhD0qeIQE0Pmfd59Rp/44A==', 'yFE6ZMsdzbPuIGBYRzgtJg==', '2017-06-21 21:20:45');
INSERT INTO `persistent_logins` VALUES ('hl', 'zV89qK+IALosIC1Ao4T6wg==', '1SzhaNojLm7rcCLrcAJzew==', '2017-06-21 15:51:20');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID  唯一标识  自动增长',
  `role_name` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色名称',
  `role_description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '角色描述',
  `role_status` varchar(2) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '角色状态（0：停用 | 1：启用）',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'ROLE_ADMIN', '管理员', null);
INSERT INTO `role` VALUES ('2', 'ROLE_USER', '普通用户', null);
INSERT INTO `role` VALUES ('3', 'ROLE_ANONYMOUS', '匿名用户', null);

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `role_id` int(11) NOT NULL COMMENT '角色ID 管理角色表',
  `menu_id` int(11) NOT NULL COMMENT '菜单ID 关联菜单表',
  PRIMARY KEY (`menu_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES ('1', '1');
INSERT INTO `role_menu` VALUES ('2', '1');
INSERT INTO `role_menu` VALUES ('1', '2');
INSERT INTO `role_menu` VALUES ('2', '2');
INSERT INTO `role_menu` VALUES ('1', '3');
INSERT INTO `role_menu` VALUES ('2', '3');
INSERT INTO `role_menu` VALUES ('1', '4');
INSERT INTO `role_menu` VALUES ('2', '4');
INSERT INTO `role_menu` VALUES ('1', '5');
INSERT INTO `role_menu` VALUES ('1', '6');
INSERT INTO `role_menu` VALUES ('1', '7');
INSERT INTO `role_menu` VALUES ('2', '7');
INSERT INTO `role_menu` VALUES ('1', '8');
INSERT INTO `role_menu` VALUES ('1', '9');
INSERT INTO `role_menu` VALUES ('2', '9');
INSERT INTO `role_menu` VALUES ('1', '10');
INSERT INTO `role_menu` VALUES ('1', '11');
INSERT INTO `role_menu` VALUES ('2', '11');
INSERT INTO `role_menu` VALUES ('3', '11');

-- ----------------------------
-- Table structure for role_user
-- ----------------------------
DROP TABLE IF EXISTS `role_user`;
CREATE TABLE `role_user` (
  `user_id` int(11) NOT NULL COMMENT '用户ID  （关联到用户表）',
  `role_id` int(11) NOT NULL COMMENT '角色ID （关联到角色表）',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of role_user
-- ----------------------------
INSERT INTO `role_user` VALUES ('1', '1');
INSERT INTO `role_user` VALUES ('2', '2');
INSERT INTO `role_user` VALUES ('3', '2');
INSERT INTO `role_user` VALUES ('4', '2');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID 自动增长',
  `user_name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  `nickname` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户昵称',
  `password` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `id_type` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '证件类型',
  `id_no` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '证件号码',
  `email` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(11) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '移动电话号码',
  `user_status` varchar(2) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户状态（0：停用  | 1 ： 启用）',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '注册时间',
  `invalid_time` timestamp NULL DEFAULT NULL COMMENT '失效日期',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '张三', 'admin', '123456', null, null, null, '18810253032', null, '2017-06-14 15:42:05', null);
INSERT INTO `user` VALUES ('2', '李四', 'user', '123456', null, null, null, '18810253031', null, '2017-06-28 15:43:44', null);
INSERT INTO `user` VALUES ('3', '韩磊', 'hl', '123456', null, null, null, '18810253030', null, '2017-06-26 15:43:47', null);
INSERT INTO `user` VALUES ('4', '王五', '王五', '123456', null, null, null, '18810253029', null, '2017-06-21 16:52:20', null);
