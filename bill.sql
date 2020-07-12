/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : bill

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2020-07-12 23:37:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bill
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
  `bid` int(10) NOT NULL AUTO_INCREMENT,
  `bill_code` varchar(25) DEFAULT NULL,
  `bill_name` varchar(25) DEFAULT NULL,
  `bill_com` varchar(25) DEFAULT NULL,
  `bill_num` int(8) DEFAULT NULL,
  `money` double(8,2) DEFAULT NULL,
  `pay` int(2) DEFAULT NULL COMMENT '是否付款 0 未付款， 1已付款',
  `pid` int(10) DEFAULT NULL COMMENT '供应商id',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bill
-- ----------------------------
INSERT INTO `bill` VALUES ('1', 'B_00111', 'ESC包年云服务11', '年11', '39', '400000.00', '1', '1', '2020-01-15 22:32:07');
INSERT INTO `bill` VALUES ('2', 'b_002', 'ESC包月云服务', '月', '20', '26000.00', '1', '3', '2028-11-12 11:58:00');
INSERT INTO `bill` VALUES ('3', 'b_003', 'com域名', '年', '33', '15000.00', '0', '1', '2028-11-12 11:58:00');
INSERT INTO `bill` VALUES ('4', 'b_004', 'cn域名', '小时', '10', '7000.00', '0', '1', '2028-11-12 11:58:00');
INSERT INTO `bill` VALUES ('5', 'b_005', '团购小程序', '月', '3', '60000.00', '1', '4', '2028-11-12 11:58:00');
INSERT INTO `bill` VALUES ('7', '1', '11', '1', '11', '1.00', '1', '3', '2020-01-15 23:12:06');

-- ----------------------------
-- Table structure for provider
-- ----------------------------
DROP TABLE IF EXISTS `provider`;
CREATE TABLE `provider` (
  `pid` int(10) NOT NULL AUTO_INCREMENT,
  `provider_code` varchar(25) DEFAULT NULL,
  `providerName` varchar(25) DEFAULT NULL,
  `people` varchar(25) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `address` varchar(60) DEFAULT NULL,
  `fax` varchar(25) DEFAULT NULL,
  `describe` varchar(100) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of provider
-- ----------------------------
INSERT INTO `provider` VALUES ('1', 'P_111', 'A货云服务供应商11', '小码', '1888888888111', '广州白云区', '020-123456', '专业ESC服务商', '2020-01-11 17:24:43');
INSERT INTO `provider` VALUES ('2', 'P_222', 'B货域名供应商', '小域', '1888886666', '北京朝阳区', '020-112312123', '专业提供域名', '2020-01-02 21:44:12');
INSERT INTO `provider` VALUES ('3', 'P_333', 'B货小程序企鹅', '小企鹅', '1888666666', '深圳南山区', '020-123123', '专业小程序提供', '2028-11-12 11:52:17');
INSERT INTO `provider` VALUES ('4', 'P_444', '其他渠道供应商', '无名11', '18889999991', '北京1', '010-10001', '专业渠道来源', '2020-01-03 22:01:54');
INSERT INTO `provider` VALUES ('6', 'P_555', '梦学谷供应商1', '小张', '18888666981', '深圳软件园', '0911-0123456', '品质Aaa', '2020-01-03 22:01:38');
INSERT INTO `provider` VALUES ('10', null, '修改名字1', null, '123456789', null, null, null, '2020-03-05 15:46:23');
INSERT INTO `provider` VALUES ('11', null, '修改名字14744', null, '123456789', null, null, null, '2020-03-05 13:29:44');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `tid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '小明', '1');
INSERT INTO `student` VALUES ('2', '王阳', '1');
INSERT INTO `student` VALUES ('3', '李哥', '1');
INSERT INTO `student` VALUES ('4', '白菜', '1');
INSERT INTO `student` VALUES ('5', '刘德海', '2');
INSERT INTO `student` VALUES ('6', '东海', '2');
INSERT INTO `student` VALUES ('7', '皮蛋', '3');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '郭老师');
INSERT INTO `teacher` VALUES ('2', '马老师');
INSERT INTO `teacher` VALUES ('3', '赢老师');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) DEFAULT NULL,
  `real_name` varchar(25) DEFAULT NULL,
  `password` varchar(25) DEFAULT NULL,
  `gender` int(1) DEFAULT NULL COMMENT '性别：1 女  2 男',
  `birthday` datetime DEFAULT NULL,
  `user_type` int(1) DEFAULT NULL COMMENT '1管理员  2经理  3普通用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'root', '系统管理员', '11', '1', '2003-11-12 00:00:00', '1');
INSERT INTO `user` VALUES ('2', 'lisi', '李四', '123', '2', '1983-11-12 00:00:00', '2');
INSERT INTO `user` VALUES ('3', 'wangwu', '王五', '123', '2', '1953-11-12 00:00:00', '3');
INSERT INTO `user` VALUES ('4', 'zhangsan', '张三', '123', '1', '1973-11-12 00:00:00', '3');
INSERT INTO `user` VALUES ('6', 'a', 'www', '123', '2', '2018-12-12 00:00:00', '2');
INSERT INTO `user` VALUES ('8', 'b', 'www', '111', null, '2018-12-12 00:00:00', null);
INSERT INTO `user` VALUES ('10', 'c', '4444', '111', '1', '2018-12-12 00:00:00', '2');
INSERT INTO `user` VALUES ('11', 'd', 'd', '111', '1', '2018-12-12 00:00:00', '2');
INSERT INTO `user` VALUES ('12', '2aaaa', 'e', '111', '2', '2018-12-12 00:00:00', '1');
