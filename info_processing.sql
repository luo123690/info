/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : info_processing

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2019-10-30 09:13:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` varchar(255) NOT NULL COMMENT '员工ID',
  `username` varchar(255) DEFAULT NULL COMMENT '管理员账号',
  `password` varchar(255) DEFAULT NULL COMMENT '管理员密码',
  `avatar` text COMMENT '管理员头像',
  `number` varchar(255) DEFAULT NULL COMMENT '管理员编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for admin_token
-- ----------------------------
DROP TABLE IF EXISTS `admin_token`;
CREATE TABLE `admin_token` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `token` varchar(255) DEFAULT NULL,
  `adminid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_token
-- ----------------------------

-- ----------------------------
-- Table structure for application
-- ----------------------------
DROP TABLE IF EXISTS `application`;
CREATE TABLE `application` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `professionF` varchar(255) DEFAULT NULL,
  `professionS` varchar(255) DEFAULT NULL,
  `time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of application
-- ----------------------------

-- ----------------------------
-- Table structure for info
-- ----------------------------
DROP TABLE IF EXISTS `info`;
CREATE TABLE `info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL COMMENT '用户id',
  `typeid` int(11) DEFAULT NULL COMMENT '申请岗位id',
  `name` varchar(255) DEFAULT NULL,
  `profession` varchar(255) DEFAULT NULL COMMENT '职称',
  `education` varchar(255) DEFAULT NULL COMMENT '教育',
  `honor` varchar(255) DEFAULT NULL COMMENT '荣誉',
  `skill` varchar(255) DEFAULT NULL COMMENT '技能',
  `technology` varchar(255) DEFAULT NULL COMMENT '技术',
  `patent` varchar(255) DEFAULT NULL COMMENT '专利',
  `paper` varchar(255) DEFAULT NULL COMMENT '论文',
  `professor` varchar(255) DEFAULT NULL COMMENT '专业',
  `isread` int(11) DEFAULT '0',
  `point` double(11,2) DEFAULT '0.00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of info
-- ----------------------------
INSERT INTO `info` VALUES ('37', '7', '13', '骆炳捷-1', '初级（技师）职称', '研究生（硕士）学历', '国家级技术能手、五一劳动奖章、劳动模范、先进工作者、标兵荣誉奖章', '国家级技能竞赛三等奖', '国家级科技成果一等奖', null, 'CN期刊第一作者/篇', '国际专业认证高级证书', '1', '65.00');
INSERT INTO `info` VALUES ('38', '7', '5', '骆炳捷0', null, null, null, null, null, null, null, null, '1', '0.00');
INSERT INTO `info` VALUES ('39', '7', '9', '骆炳捷1', '初级（技师）职称', '研究生（硕士）学历', '国家级技术能手、五一劳动奖章、劳动模范、先进工作者、标兵荣誉奖章', '国家级技能竞赛三等奖', '国家级科技成果一等奖', '', 'CN期刊第一作者/篇', '国际专业认证高级证书', '1', '68.00');
INSERT INTO `info` VALUES ('40', '7', '8', '骆炳捷2', '初级（技师）职称', '研究生（硕士）学历', '国家级技术能手、五一劳动奖章、劳动模范、先进工作者、标兵荣誉奖章', '国家级技能竞赛三等奖', '国家级科技成果一等奖', '', 'CN期刊第一作者/篇', '国际专业认证高级证书', '1', '60.00');
INSERT INTO `info` VALUES ('41', '5', '6', '骆炳捷3', '高级（技师）职称', '博士学历', null, null, null, null, null, null, '0', '15.00');
INSERT INTO `info` VALUES ('42', '5', '17', '骆炳捷4', null, null, null, null, null, null, null, null, '0', '0.00');
INSERT INTO `info` VALUES ('43', '5', '4', '骆炳捷5', null, null, null, null, null, null, null, null, '0', '0.00');
INSERT INTO `info` VALUES ('44', '5', '5', '骆炳捷6', null, null, null, null, null, null, null, null, '0', '0.00');
INSERT INTO `info` VALUES ('45', '5', '19', '骆炳捷7', null, null, null, null, null, null, null, null, '0', '0.00');
INSERT INTO `info` VALUES ('46', '5', '21', '骆炳捷8', null, null, null, null, null, null, null, null, '0', '0.00');
INSERT INTO `info` VALUES ('47', '5', '5', '骆炳捷9', null, null, null, null, null, null, null, null, '0', '0.00');
INSERT INTO `info` VALUES ('48', '5', '9', '骆炳捷10', null, null, null, null, null, null, null, null, '0', '0.00');
INSERT INTO `info` VALUES ('49', '5', '7', '骆炳捷11', null, null, null, null, null, null, null, null, '0', '0.00');
INSERT INTO `info` VALUES ('50', '5', '7', '骆炳捷12', null, null, null, null, null, null, null, null, '0', '0.00');
INSERT INTO `info` VALUES ('51', '5', '4', '骆炳捷13', null, null, null, null, null, null, null, null, '0', '0.00');
INSERT INTO `info` VALUES ('52', '5', '4', '骆炳捷14', null, null, null, null, null, null, null, null, '0', '0.00');
INSERT INTO `info` VALUES ('53', '5', '30', '骆炳捷15', null, null, null, null, null, null, null, null, '0', '0.00');
INSERT INTO `info` VALUES ('54', '5', '30', '骆炳捷16', null, null, null, null, null, null, null, null, '0', '0.00');
INSERT INTO `info` VALUES ('55', '5', '8', '骆炳捷17', null, null, null, null, null, null, null, null, '0', '0.00');
INSERT INTO `info` VALUES ('56', '5', '25', '骆炳捷18', null, null, null, null, null, null, null, null, '0', '0.00');
INSERT INTO `info` VALUES ('57', '5', '4', '骆炳捷', null, null, null, null, null, null, null, null, '0', '0.00');

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `token` varchar(255) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('1', 'eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI3In0.b0G9eqHiRFK1mIzjpBE1NnMiIJmffZLY617gUgt0Lp0', '7');
INSERT INTO `login` VALUES ('2', 'eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1In0.iL2jjctc7JrtdWanR9dGmB4Jxlu0J2zIxEtwo5ZLqWU', '5');
INSERT INTO `login` VALUES ('3', 'eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4In0.xuxUB27LbK8pp0viPb_Wg3R_b0IN0kbPtIQO8cYF8IU', '8');

-- ----------------------------
-- Table structure for point
-- ----------------------------
DROP TABLE IF EXISTS `point`;
CREATE TABLE `point` (
  `id` int(11) NOT NULL,
  `honor` varchar(255) DEFAULT NULL,
  `point` varchar(255) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of point
-- ----------------------------
INSERT INTO `point` VALUES ('1', '初级（技师）职称', '30', '0.05', '职称');
INSERT INTO `point` VALUES ('2', '中级（技师）职称', '60', '0.05', '职称');
INSERT INTO `point` VALUES ('3', '高级（技师）职称', '100', '0.05', '职称');
INSERT INTO `point` VALUES ('4', '本科（学士）学历', '50', '0.1', '学历');
INSERT INTO `point` VALUES ('5', '研究生（硕士）学历', '80', '0.1', '学历');
INSERT INTO `point` VALUES ('6', '博士学历', '100', '0.1', '学历');
INSERT INTO `point` VALUES ('7', '地厅省公司级技术能手、五一劳动奖章、劳动模范、先进工作者、标兵荣誉奖章', '30', '0.1', '荣誉奖章');
INSERT INTO `point` VALUES ('8', '省部集团级技术能手、五一劳动奖章、劳动模范、先进工作者、标兵荣誉奖章', '60', '0.1', '荣誉奖章');
INSERT INTO `point` VALUES ('9', '国家级技术能手、五一劳动奖章、劳动模范、先进工作者、标兵荣誉奖章', '100', '0.1', '荣誉奖章');
INSERT INTO `point` VALUES ('10', '地厅省公司级技能竞赛三等奖', '30', '0.2', '技能竞赛');
INSERT INTO `point` VALUES ('11', '地厅省公司级技能竞赛二等奖', '35', '0.2', '技能竞赛');
INSERT INTO `point` VALUES ('12', '地厅省公司级技能竞赛一等奖', '40', '0.2', '技能竞赛');
INSERT INTO `point` VALUES ('13', '省部集团级技能竞赛优秀奖或团体奖', '30', '0.2', '技能竞赛');
INSERT INTO `point` VALUES ('14', '省部集团级技能竞赛三等奖', '40', '0.2', '技能竞赛');
INSERT INTO `point` VALUES ('15', '省部集团级技能竞赛二等奖', '50', '0.2', '技能竞赛');
INSERT INTO `point` VALUES ('16', '省部集团级技能竞赛一等奖', '60', '0.2', '技能竞赛');
INSERT INTO `point` VALUES ('17', '国家级技能竞赛优秀奖或团体奖', '40', '0.2', '技能竞赛');
INSERT INTO `point` VALUES ('18', '国家级技能竞赛三等奖', '60', '0.2', '技能竞赛');
INSERT INTO `point` VALUES ('19', '国家级技能竞赛二等奖', '80', '0.2', '技能竞赛');
INSERT INTO `point` VALUES ('20', '国家级技能竞赛一等奖', '100', '0.2', '技能竞赛');
INSERT INTO `point` VALUES ('21', '地厅省公司级科技成果三等奖', '15', '0.2', '科技进步');
INSERT INTO `point` VALUES ('22', '地厅省公司级科技成果二等奖', '20', '0.2', '科技进步');
INSERT INTO `point` VALUES ('23', '地厅省公司级科技成果一等奖', '30', '0.2', '科技进步');
INSERT INTO `point` VALUES ('24', '省部集团级科技成果三等奖', '45', '0.2', '科技进步');
INSERT INTO `point` VALUES ('25', '省部集团级科技成果二等奖', '50', '0.2', '科技进步');
INSERT INTO `point` VALUES ('26', '省部集团级科技成果一等奖', '60', '0.2', '科技进步');
INSERT INTO `point` VALUES ('27', '国家级科技成果三等奖', '85', '0.2', '科技进步');
INSERT INTO `point` VALUES ('28', '国家级科技成果二等奖', '90', '0.2', '科技进步');
INSERT INTO `point` VALUES ('29', '国家级科技成果一等奖', '100', '0.2', '科技进步');
INSERT INTO `point` VALUES ('30', '实用新型专利/项', '50', '0.05', '专利');
INSERT INTO `point` VALUES ('31', '国家发明专利/项', '100', '0.05', '专利');
INSERT INTO `point` VALUES ('32', '著作副主编或编委/部', '40', '0.2', '论文著作');
INSERT INTO `point` VALUES ('33', '著作第一主编/部', '80', '0.2', '论文著作');
INSERT INTO `point` VALUES ('34', 'CN期刊合著/篇', '30', '0.2', '论文著作');
INSERT INTO `point` VALUES ('35', 'CN期刊第一作者/篇', '50', '0.2', '论文著作');
INSERT INTO `point` VALUES ('36', '核心期刊发表论文或被SCI、EI、ISTP等收录的合著/篇', '80', '0.2', '论文著作');
INSERT INTO `point` VALUES ('37', '核心期刊发表论文或被SCI、EI、ISTP等收录的第一作者/篇', '100', '0.2', '论文著作');
INSERT INTO `point` VALUES ('38', '国内专业认证初级证书', '10', '0.1', '专业认证');
INSERT INTO `point` VALUES ('39', '国内专业认证中级证书', '20', '0.1', '专业认证');
INSERT INTO `point` VALUES ('40', '国内专业认证高级证书', '40', '0.1', '专业认证');
INSERT INTO `point` VALUES ('41', '国际专业认证初级证书', '20', '0.1', '专业认证');
INSERT INTO `point` VALUES ('42', '国际专业认证中级证书', '30', '0.1', '专业认证');
INSERT INTO `point` VALUES ('43', '国际专业认证高级证书', '50', '0.1', '专业认证');

-- ----------------------------
-- Table structure for question_detial
-- ----------------------------
DROP TABLE IF EXISTS `question_detial`;
CREATE TABLE `question_detial` (
  `question_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '问题id',
  `content` text COMMENT '问题内容',
  `user_number` varchar(255) DEFAULT NULL COMMENT '用户手机',
  `supporter_id` int(11) DEFAULT NULL COMMENT '客服id',
  `consult_time` datetime DEFAULT NULL COMMENT '咨询时间',
  `segment` varchar(255) DEFAULT NULL COMMENT '分词内容',
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question_detial
-- ----------------------------

-- ----------------------------
-- Table structure for supporter
-- ----------------------------
DROP TABLE IF EXISTS `supporter`;
CREATE TABLE `supporter` (
  `supporter_id` int(11) NOT NULL AUTO_INCREMENT,
  `number` int(11) DEFAULT NULL COMMENT '员工OA编号',
  `account` varchar(255) DEFAULT NULL COMMENT '员工OA号',
  `password` varchar(255) DEFAULT NULL COMMENT '员工密码',
  `name` varchar(255) DEFAULT NULL COMMENT '员工姓名',
  `sex` varchar(255) DEFAULT NULL COMMENT '员工性别',
  `tel` varchar(255) DEFAULT NULL COMMENT '员工电话',
  `address` varchar(255) DEFAULT NULL COMMENT '员工住址',
  `identify` varchar(255) DEFAULT NULL COMMENT '员工身份证号',
  PRIMARY KEY (`supporter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of supporter
-- ----------------------------

-- ----------------------------
-- Table structure for token
-- ----------------------------
DROP TABLE IF EXISTS `token`;
CREATE TABLE `token` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `token` varchar(255) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of token
-- ----------------------------

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `id` int(11) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `professionF` varchar(255) DEFAULT NULL,
  `professionS` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES ('1', '市场', '市场互联网产品专业', null);
INSERT INTO `type` VALUES ('2', '市场', '市场营销', null);
INSERT INTO `type` VALUES ('3', '市场', '个人及家庭互联网产品专业', null);
INSERT INTO `type` VALUES ('4', '市场', '其他', null);
INSERT INTO `type` VALUES ('5', '技术', 'IT', '规划与架构');
INSERT INTO `type` VALUES ('6', '技术', 'IT', '业务与需求');
INSERT INTO `type` VALUES ('7', '技术', 'IT', '研发与测试');
INSERT INTO `type` VALUES ('8', '技术', 'IT', '生产与运维');
INSERT INTO `type` VALUES ('9', '技术', 'IT', '大数据与云计算');
INSERT INTO `type` VALUES ('10', '技术', 'IT', '其他');
INSERT INTO `type` VALUES ('11', '技术', '运行与维护', '网络监控');
INSERT INTO `type` VALUES ('12', '技术', '运行与维护', '核心网');
INSERT INTO `type` VALUES ('13', '技术', '运行与维护', '移动无线网');
INSERT INTO `type` VALUES ('14', '技术', '运行与维护', 'IT');
INSERT INTO `type` VALUES ('23', '技术', '运行与维护', '应急与安全');
INSERT INTO `type` VALUES ('24', '技术', '运行与维护', '动力配套、局房');
INSERT INTO `type` VALUES ('25', '技术', '运行与维护', '其他');
INSERT INTO `type` VALUES ('29', '技术', '网络建设', '建设管理与创新');
INSERT INTO `type` VALUES ('30', '技术', '网络建设', '网络承载与接入');
INSERT INTO `type` VALUES ('31', '技术', '网络建设', '支撑及其他');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `indentify` varchar(60) DEFAULT NULL,
  `address` varchar(60) DEFAULT NULL,
  `sex` varchar(30) DEFAULT NULL,
  `type` int(50) DEFAULT '99',
  `college` varchar(255) DEFAULT NULL,
  `profession` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `graduate` varchar(255) DEFAULT NULL,
  `intro` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1231234', '1231234', '骆炳捷', null, '17600905236', '6223011111111111', '北京市海淀区', '男', '99', null, null, null, null, null);
INSERT INTO `user` VALUES ('5', '123123', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', '骆炳捷', '26', '17600905236', '62230111111111111', '北京市海淀区', '男', '99', '北京林业大学', '软件工程（专硕）', '人力部', '2019.07', '研究生期间参与过大型项目的设计、开发工作，2019年8入职北京联通，目前在北京联通人力部工作。');
INSERT INTO `user` VALUES ('6', '123456', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', '骆炳捷', null, '17600905236', '62230111111111111', '北京市海淀区', '男', '99', null, null, null, null, null);
INSERT INTO `user` VALUES ('7', '123123123', '932f3c1b56257ce8539ac269d7aab42550dacf8818d075f0bdf1990562aae3ef', '骆炳捷', '26', '17600905236', '62230111111111111', '北京市海淀区', '男', '99', '北京林业大学', '软件工程', '人力部', '2019.07', '参与过大型项目的设计、开发工作');
INSERT INTO `user` VALUES ('8', 'admin', '96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e', '管理员', '30', '17600905236', '62230111111111111', '北京市海淀区', '男', '1', null, null, null, null, null);
