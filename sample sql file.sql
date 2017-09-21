/*
Navicat MySQL Data Transfer

Source Server         : Kalhara
Source Server Version : 100121
Source Host           : localhost:3306
Source Database       : sample

Target Server Type    : MYSQL
Target Server Version : 100121
File Encoding         : 65001

Date: 2017-09-22 02:27:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sample_contact
-- ----------------------------
DROP TABLE IF EXISTS `sample_contact`;
CREATE TABLE `sample_contact` (
  `contact_id` int(11) NOT NULL AUTO_INCREMENT,
  `contact` varchar(255) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`contact_id`),
  KEY `FKmpxdobw6eyr6tfxudo3un66rj` (`user_id`),
  CONSTRAINT `FKmpxdobw6eyr6tfxudo3un66rj` FOREIGN KEY (`user_id`) REFERENCES `sample_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sample_contact
-- ----------------------------
INSERT INTO `sample_contact` VALUES ('15', '01446040546', '11');
INSERT INTO `sample_contact` VALUES ('16', '5645014065', '11');
INSERT INTO `sample_contact` VALUES ('17', '6178917917', '11');
INSERT INTO `sample_contact` VALUES ('18', '59465415645', '12');
INSERT INTO `sample_contact` VALUES ('19', '9454684656', '12');
INSERT INTO `sample_contact` VALUES ('20', '5465145645', '12');

-- ----------------------------
-- Table structure for sample_user
-- ----------------------------
DROP TABLE IF EXISTS `sample_user`;
CREATE TABLE `sample_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `gender` int(11) NOT NULL,
  `nic` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sample_user
-- ----------------------------
INSERT INTO `sample_user` VALUES ('11', 'User 1', 'user1', '0', '#65454015101');
INSERT INTO `sample_user` VALUES ('12', 'User 2', 'user2', '1', '#6545456400651');
SET FOREIGN_KEY_CHECKS=1;
