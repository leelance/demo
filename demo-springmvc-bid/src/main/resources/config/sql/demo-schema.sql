SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `t_borrow`
-- ----------------------------
DROP TABLE IF EXISTS `t_borrow`;
CREATE TABLE `t_borrow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `borrow_name` varchar(50) DEFAULT NULL COMMENT '借款人姓名',
  `borrow_total` decimal(11,2) DEFAULT '0.00' COMMENT '借款金额',
  `borrow_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_borrow
-- ----------------------------
INSERT INTO `t_borrow` VALUES ('1', 'borrow', '20000.00', '1');

-- ----------------------------
-- Table structure for `t_tender`
-- ----------------------------
DROP TABLE IF EXISTS `t_tender`;
CREATE TABLE `t_tender` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tender_user` varchar(50) DEFAULT NULL,
  `tender_total` decimal(11,2) DEFAULT '0.00' COMMENT '投标金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_tender
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(30) DEFAULT NULL,
  `total` decimal(11,2) DEFAULT NULL,
  `balance` decimal(11,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'borrow', '0.00', '0.00');
INSERT INTO `t_user` VALUES ('2', 'tender1', '10000.00', '0.00');
INSERT INTO `t_user` VALUES ('3', 'tender2', '10000.00', '0.00');
INSERT INTO `t_user` VALUES ('4', 'tender3', '10000.00', '0.00');
INSERT INTO `t_user` VALUES ('5', 'tender4', '10000.00', '0.00');
INSERT INTO `t_user` VALUES ('6', 'tender5', '10000.00', '0.00');