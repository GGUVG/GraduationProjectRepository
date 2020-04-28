/*
 Navicat Premium Data Transfer

 Source Server         : ccy
 Source Server Type    : MySQL
 Source Server Version : 50140
 Source Host           : localhost:3306
 Source Schema         : finaldesign

 Target Server Type    : MySQL
 Target Server Version : 50140
 File Encoding         : 65001

 Date: 28/04/2020 16:27:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ask_leave
-- ----------------------------
DROP TABLE IF EXISTS `ask_leave`;
CREATE TABLE `ask_leave`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'l流水',
  `staff_id` int(20) NULL DEFAULT NULL,
  `leave_time` timestamp NULL DEFAULT NULL,
  `back_time` timestamp NULL DEFAULT NULL,
  `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img_prove` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` int(5) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ask_leave
-- ----------------------------
INSERT INTO `ask_leave` VALUES (1, 1, '2019-12-30 00:00:00', '2019-12-31 00:00:00', '老婆生孩子了', '20190421140512.jpg', 0);
INSERT INTO `ask_leave` VALUES (2, 1, '2019-12-31 09:00:00', '2020-01-03 00:00:00', '我是真的烦string转timestamp', '20190421140512.jpg', 1);
INSERT INTO `ask_leave` VALUES (10, 1, '2019-12-01 00:00:00', '2019-12-04 00:00:00', '买蛋挞', '微信图片_20191007111210.jpg', 0);

-- ----------------------------
-- Table structure for ask_out_office
-- ----------------------------
DROP TABLE IF EXISTS `ask_out_office`;
CREATE TABLE `ask_out_office`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'l流水',
  `staff_id` int(20) NULL DEFAULT NULL,
  `leave_time` timestamp NULL DEFAULT NULL,
  `back_time` timestamp NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img_prove` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` int(5) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ask_out_office
-- ----------------------------
INSERT INTO `ask_out_office` VALUES (1, 1, '2020-03-01 09:00:00', '2020-03-01 12:00:00', '带客户看房', '00012.jpg', 1);

-- ----------------------------
-- Table structure for client_lease
-- ----------------------------
DROP TABLE IF EXISTS `client_lease`;
CREATE TABLE `client_lease`  (
  `Client_lid` int(10) NOT NULL AUTO_INCREMENT,
  `Client_lname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Client_lsex` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Client_laddress` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Client_lphone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Client_lremark` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `Client_lstaffid` int(20) NULL DEFAULT NULL,
  PRIMARY KEY (`Client_lid`) USING BTREE,
  INDEX `Client_lstaffid`(`Client_lstaffid`) USING BTREE,
  CONSTRAINT `Client_lstaffid` FOREIGN KEY (`Client_lstaffid`) REFERENCES `staff` (`staff_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of client_lease
-- ----------------------------
INSERT INTO `client_lease` VALUES (1, '泷泽萝拉', '女', '广东省东莞市东城区水疗城', '666', '', 1);
INSERT INTO `client_lease` VALUES (2, '明日花绮罗', '女', '广东省广州市花都区', '666', '', 1);
INSERT INTO `client_lease` VALUES (3, 'Angelic', '女', '广东省广州市番禺区', '12345', '白又白', 1);
INSERT INTO `client_lease` VALUES (4, '测试用', '测试用', '测试用', '测试用', '测试用', 1);

-- ----------------------------
-- Table structure for client_sale
-- ----------------------------
DROP TABLE IF EXISTS `client_sale`;
CREATE TABLE `client_sale`  (
  `Client_sid` int(11) NOT NULL AUTO_INCREMENT,
  `Client_sname` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Client_ssex` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Client_saddress` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Client_sphone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Client_sremark` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `Client_sstaffid` int(20) NULL DEFAULT NULL,
  PRIMARY KEY (`Client_sid`) USING BTREE,
  INDEX `Client_sstaffid`(`Client_sstaffid`) USING BTREE,
  CONSTRAINT `Client_sstaffid` FOREIGN KEY (`Client_sstaffid`) REFERENCES `staff` (`staff_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of client_sale
-- ----------------------------
INSERT INTO `client_sale` VALUES (1, '希岛爱理', '女', '广东省广州市海珠区新港西路', '666', '', 1);
INSERT INTO `client_sale` VALUES (2, '樱井步', '女', '广东省广州市海珠区新港西路', '444', '', 1);
INSERT INTO `client_sale` VALUES (3, 'StellaCox', '女', '广东省广州市番禺区', '666', '谢了兄弟，已经', 1);
INSERT INTO `client_sale` VALUES (4, 'test2', '女', '广东省广州市天河区完平大厦', '777', '我好了', 1);
INSERT INTO `client_sale` VALUES (5, '半藏森林', '男', NULL, NULL, NULL, 2);

-- ----------------------------
-- Table structure for client_want_buy
-- ----------------------------
DROP TABLE IF EXISTS `client_want_buy`;
CREATE TABLE `client_want_buy`  (
  `client_wbid` int(20) NOT NULL AUTO_INCREMENT,
  `client_wbname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `client_wbsex` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `client_wbaddress` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `client_wbphone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `client_wbexpect_place` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `client_wbexpect_price` int(20) NULL DEFAULT NULL,
  `client_wbexpect_square` int(20) NULL DEFAULT NULL,
  `client_wb_remark` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `client_wbstaffid` int(20) NULL DEFAULT NULL,
  PRIMARY KEY (`client_wbid`) USING BTREE,
  INDEX `Client_wbstaffid`(`client_wbstaffid`) USING BTREE,
  INDEX `client_wbid`(`client_wbid`) USING BTREE,
  INDEX `client_wbid_2`(`client_wbid`) USING BTREE,
  INDEX `client_wbid_3`(`client_wbid`) USING BTREE,
  INDEX `client_wbid_4`(`client_wbid`) USING BTREE,
  INDEX `client_wbid_5`(`client_wbid`) USING BTREE,
  INDEX `client_wbid_6`(`client_wbid`) USING BTREE,
  INDEX `client_wbid_7`(`client_wbid`) USING BTREE,
  INDEX `client_wbid_8`(`client_wbid`) USING BTREE,
  INDEX `client_wbid_9`(`client_wbid`) USING BTREE,
  INDEX `client_wbid_10`(`client_wbid`) USING BTREE,
  INDEX `client_wbid_11`(`client_wbid`) USING BTREE,
  INDEX `client_wbid_12`(`client_wbid`) USING BTREE,
  CONSTRAINT `Client_wbstaffid` FOREIGN KEY (`Client_wbstaffid`) REFERENCES `staff` (`staff_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of client_want_buy
-- ----------------------------
INSERT INTO `client_want_buy` VALUES (1, '桃谷绘里香', '女', '广东省广州市海珠区新港西路中山大学', '666', '广东省广州市番禺区', 40000, 120, NULL, 1);
INSERT INTO `client_want_buy` VALUES (2, '椎名由奈', '女', '广东省广州市荔湾区', '333', '广东省东莞市南城区', 25000, 90, NULL, 1);
INSERT INTO `client_want_buy` VALUES (3, '冬月枫', '女', '广东省广州市越秀区', '233', '广东省广州市番禺区', 37000, 120, NULL, 2);
INSERT INTO `client_want_buy` VALUES (4, '李丽莎', '女', '广东省广州市番禺区', '233', '广东省广州市番禺区', 40000, 120, '好想要', 1);
INSERT INTO `client_want_buy` VALUES (5, '孤儿', '女', '广东省东莞市南城区', '111', '广东省东莞市南城区', 28000, 90, '白嫖', NULL);
INSERT INTO `client_want_buy` VALUES (6, '音阙诗听', '女', '广东省广州市番禺区', '75641', '广东省广州市番禺区', 32000, 120, '社保', 1);
INSERT INTO `client_want_buy` VALUES (7, '白咲舞', '女', '广东省广州市番禺区', '2366456', NULL, NULL, NULL, '好想要', 1);

-- ----------------------------
-- Table structure for client_want_rent
-- ----------------------------
DROP TABLE IF EXISTS `client_want_rent`;
CREATE TABLE `client_want_rent`  (
  `client_wrid` int(20) NOT NULL AUTO_INCREMENT,
  `client_wrname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `client_wrsex` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `client_wraddress` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `client_wrphone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `client_wrexpect_place` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `client_wrexpect_price` int(20) NULL DEFAULT NULL,
  `client_wrexpect_square` int(20) NULL DEFAULT NULL,
  `client_wr_remark` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `client_wrstaffid` int(20) NULL DEFAULT NULL,
  PRIMARY KEY (`client_wrid`) USING BTREE,
  INDEX `Client_wrstaffid`(`client_wrstaffid`) USING BTREE,
  INDEX `client_wrid`(`client_wrid`) USING BTREE,
  INDEX `client_wrid_2`(`client_wrid`) USING BTREE,
  INDEX `client_wrid_3`(`client_wrid`) USING BTREE,
  INDEX `client_wrid_4`(`client_wrid`) USING BTREE,
  INDEX `client_wrid_5`(`client_wrid`) USING BTREE,
  INDEX `client_wrid_6`(`client_wrid`) USING BTREE,
  INDEX `client_wrid_7`(`client_wrid`) USING BTREE,
  INDEX `client_wrid_8`(`client_wrid`) USING BTREE,
  INDEX `client_wrid_9`(`client_wrid`) USING BTREE,
  INDEX `client_wrid_10`(`client_wrid`) USING BTREE,
  INDEX `client_wrid_11`(`client_wrid`) USING BTREE,
  INDEX `client_wrid_12`(`client_wrid`) USING BTREE,
  INDEX `client_wrid_13`(`client_wrid`) USING BTREE,
  INDEX `client_wrid_14`(`client_wrid`) USING BTREE,
  INDEX `client_wrid_15`(`client_wrid`) USING BTREE,
  INDEX `client_wrid_16`(`client_wrid`) USING BTREE,
  INDEX `client_wrid_17`(`client_wrid`) USING BTREE,
  INDEX `client_wrid_18`(`client_wrid`) USING BTREE,
  INDEX `client_wrid_19`(`client_wrid`) USING BTREE,
  INDEX `client_wrid_20`(`client_wrid`) USING BTREE,
  INDEX `client_wrid_21`(`client_wrid`) USING BTREE,
  INDEX `client_wrid_22`(`client_wrid`) USING BTREE,
  INDEX `client_wrid_23`(`client_wrid`) USING BTREE,
  INDEX `client_wrid_24`(`client_wrid`) USING BTREE,
  INDEX `client_wrid_25`(`client_wrid`) USING BTREE,
  INDEX `client_wrid_26`(`client_wrid`) USING BTREE,
  INDEX `client_wrid_27`(`client_wrid`) USING BTREE,
  INDEX `client_wrid_28`(`client_wrid`) USING BTREE,
  INDEX `client_wrid_29`(`client_wrid`) USING BTREE,
  INDEX `client_wrid_30`(`client_wrid`) USING BTREE,
  INDEX `client_wrid_31`(`client_wrid`) USING BTREE,
  INDEX `client_wrid_32`(`client_wrid`) USING BTREE,
  CONSTRAINT `Client_wrstaffid` FOREIGN KEY (`Client_wrstaffid`) REFERENCES `staff` (`staff_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of client_want_rent
-- ----------------------------
INSERT INTO `client_want_rent` VALUES (1, '希岛爱理', '女', '广东省广州市天河区体育西路', '123456', '广东省东莞市南城区', 2300, 50, NULL, 1);
INSERT INTO `client_want_rent` VALUES (2, '莲美恋', '女', '广东省广州市荔湾区', '233', '广东省广州市番禺区', 6000, 120, NULL, 1);
INSERT INTO `client_want_rent` VALUES (3, '孤儿', '女', '广东省东莞市东城区', '777', '广东省东莞市东城区', 3000, 50, '键盘侠', NULL);

-- ----------------------------
-- Table structure for company_news
-- ----------------------------
DROP TABLE IF EXISTS `company_news`;
CREATE TABLE `company_news`  (
  `Company_news_id` int(20) NOT NULL AUTO_INCREMENT,
  `Company_news_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Company_news_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `Company_news_staffid` int(20) NULL DEFAULT NULL,
  `publish_time` timestamp NULL DEFAULT NULL,
  `Company_news_img` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Company_news_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of company_news
-- ----------------------------
INSERT INTO `company_news` VALUES (1, '澳门首家线上赌场上线啦', '真人美女荷官在线发牌陪您嗨翻天！冲冲冲！真人美女荷官在线发牌陪您嗨翻天！冲冲冲！真人美女荷官在线发牌陪您嗨翻天！冲冲冲！真人美女荷官在线发牌陪您嗨翻天！冲冲冲！真人美女荷官在线发牌陪您嗨翻天！冲冲冲！真人美女荷官在线发牌陪您嗨翻天！冲冲冲！真人美女荷官在线发牌陪您嗨翻天！冲冲冲！真人美女荷官在线发牌陪您嗨翻天！冲冲冲！', 1, '2020-02-24 21:48:41', 'CompanyNews1.jpg');
INSERT INTO `company_news` VALUES (2, '贰', '爬', 1, '2020-02-24 21:49:10', 'MarketsNewsorg.springframework.web.multipart.support.StandardMultipartHttpServletRequest$StandardMultipartFile@44934f1f.jpg');
INSERT INTO `company_news` VALUES (3, '今日广州新增肺炎人数', '截至2月21日24时，广州市累计报告新冠肺炎确诊病例343例，其中白云区74例、海珠区66例、天河区44例、番禺区40例、越秀区35例、花都区21例、荔湾区19例、黄埔区18例、增城区17例、南沙区8例、从化区1例。男性166例、女性177例。年龄介于3个月至90岁之间。现有疑似病例1例。累计核实追踪密切接触者3875人，尚在医学观察616人。', 1, '2020-02-24 21:49:16', 'MarketsNewsorg.springframework.web.multipart.support.StandardMultipartHttpServletRequest$StandardMultipartFile@9dd0a80.jpg');
INSERT INTO `company_news` VALUES (4, '每周联动主推盘成交喜报', '割韭菜真开心', 1, '2020-02-24 21:50:48', 'MarketsNewsorg.springframework.web.multipart.support.StandardMultipartHttpServletRequest$StandardMultipartFile@3fdce732.jpg');
INSERT INTO `company_news` VALUES (5, '关于【祈福黄金海岸】(2020-02-01~2020-04-30)项目认购(开售)操作流程通告', '其实我也不会我瞎编的...', 1, '2020-02-24 21:51:17', '111.jpg');
INSERT INTO `company_news` VALUES (6, '2020新年完平置业职能部门员工拓展活动回顾', '填表抗议有毛用？', 1, '2020-02-24 21:53:48', 'CompanyNews6.gif');
INSERT INTO `company_news` VALUES (7, '关于开设3月业务八部《业务资讯发布会》通知', '接着割韭菜', 1, '2020-02-24 21:55:00', 'CompanyNews7.gif');
INSERT INTO `company_news` VALUES (8, '关于一二手联动在售项目', '割割割', 1, '2020-02-24 21:55:47', 'CompanyNews8.gif');
INSERT INTO `company_news` VALUES (9, '关于青楼名苑(广州户籍不限购，非广州户籍限购)项目的推广公告', 'カッコつけてるつもりで得意になって\r\n大事な事は全部置き去りにしちゃって\r\n自分で自分を苦しめているシュウジン\r\nそんな仆にサヨナラさTransformation!\r\n闇が怖くてどうする\r\nアイツが怖くてどうする\r\n足踏みしてるだけじゃ\r\n进まない\r\n男なら 谁かのために强くなれ\r\n歯を食いしばって 思いっきり守り抜け\r\n転んでもいいよ また立ち上がればいい\r\nただそれだけ できれば 英雄さ\r\n今日もなんだかやる気が起きないなんて\r\n甘え尽くしの自分が本当は嫌いで\r\nとりあえずは外（おもて）で深呼吸 更新\r\nそんじゃ今からしましょうかTransformation!\r\n弱気になってどうする\r\n明日の君はどうする?\r\n黙って下向いてちゃ\r\n闻こえない\r\n男なら 谁かのために强くなれ\r\nぶつかり合って 精一杯やってみろ\r\n泣いてもいいよ また笑えればいい\r\n『流泪也没关系，最後能笑著就好』\r\nただそれだけ できれば 英雄さ\r\n男なら 谁かのために强くなれ\r\n女もそうさ 见てるだけじゃ始まらない\r\nこれが正しいって 言える勇気があればいい\r\nただそれだけ できれば 英雄さ\r\n男なら 谁かのために强くなれ\r\n歯を食いしばって 思いっきり守り抜け\r\n転んでもいいよ また立ち上がればいい\r\nただそれだけ できれば 英雄さ', 1, '2020-02-24 21:57:03', 'CompanyNews9.jpg');
INSERT INTO `company_news` VALUES (10, '关于“上勾拳(铁拳森林)(非包销)”项目补充上述调整', 'I\'m sick and tired of being sick and tired\r\nIt\'s you that i\'m missing\r\nIt\'s like my brain is wired up\r\nAnd there\'s a glitch in my system\r\nYou\'re like a drug that now my blood won\'t stop itching\r\nI\'m in critical condition\r\nSomeone let me out of this prison\r\nIt\'s like my mind is playing tricks on me lately\r\nI could of sworn that you are still my baby\r\nI\'m on a merry-go-round\r\nGoing around, driving me crazy\r\nThat\'s why it feels like\r\nLosing you is like somebody just turned all the lights off\r\nWon\'t somebody, anybody\r\nPlease just turn the lights on\r\nI won\'t take one step\r\nI can\'t see what\'s coming next\r\nLosing you is like somebody just turned all the lights off\r\nCan\'t see at all (at all, at all, at all)\r\nCan\'t see at all (no oh no)\r\nCan\'t see at all (at all)\r\nCause it\'s like somebody just turned all the lights off', 1, '2020-02-24 21:58:11', 'CompanyNews10.gif');
INSERT INTO `company_news` VALUES (11, '关于2019年12月分行电子发票存在的问题分行汇总', 'My heart stops beating when you walk by .\r\nThey get heart breathing when you catch my eyes.\r\nNobody makes me feel the way you do （Only you）\r\nAnd i can ’t help it,I ’m in love with you\r\nFeels like i ’m standing on a top of a cloud looking down and if i ’m dreaming don ’t wake me up\r\nI ’m at the point where i don ’t know what to say when you say how do i love you let me count the ways One,more than anything\r\nTwo,with my everything\r\nThree,with my heart and soul\r\nFour,more than i can show\r\nHow do i love you （x3）\r\nLet me count the ways\r\nIt ’s amazing how i ’m head over heels fadin ’you\r\nNever knew that i would feel like i feel for you\r\nYou ’r beautiful on the inside and the outside\r\nAnd i know that nobody ’s perfect but you ’re the perfect match for me just for me ohh\r\nFeels like i ’m standing on a top of a cloud looking down and if i ’m dreaming don ’t wake me up\r\nI ’m at the point where i don ’t know what to say when you say how do i love you let me count the ways One,more than anything\r\nTwo,with my everything\r\nThree,with my heart and soul\r\nFour,more than i can show\r\nHow do i love you （x3）\r\nLet me count the ways', 1, '2020-02-24 22:04:21', 'CompanyNews11.gif');
INSERT INTO `company_news` VALUES (12, '均衡分部历史最高排名南部23', '开冲', 4, '2020-03-09 00:42:50', 'CompanyNews12.jpg');

-- ----------------------------
-- Table structure for companybranches
-- ----------------------------
DROP TABLE IF EXISTS `companybranches`;
CREATE TABLE `companybranches`  (
  `CB_id` int(20) NOT NULL,
  `CB_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CB_province` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CB_city` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CB_district` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CB_manager_id` int(20) NULL DEFAULT NULL,
  PRIMARY KEY (`CB_id`) USING BTREE,
  INDEX `CB_manager_id`(`CB_manager_id`) USING BTREE,
  CONSTRAINT `CB_manager_id` FOREIGN KEY (`CB_manager_id`) REFERENCES `staff` (`staff_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of companybranches
-- ----------------------------
INSERT INTO `companybranches` VALUES (1, '洛溪新城', '广东省', '广州市', '番禺区', 4);
INSERT INTO `companybranches` VALUES (2, '大石分行', '广东省', '广州市', '番禺区', 5);
INSERT INTO `companybranches` VALUES (3, '南城分行', '广东省', '东莞市', '南城区', 7);
INSERT INTO `companybranches` VALUES (4, '东城分行', '广东省', '东莞市', '东城区', 8);
INSERT INTO `companybranches` VALUES (5, '城区分行', '广东省', '汕尾市', '城区', 10);

-- ----------------------------
-- Table structure for deal_rentpreparation
-- ----------------------------
DROP TABLE IF EXISTS `deal_rentpreparation`;
CREATE TABLE `deal_rentpreparation`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `staff_id` int(20) NULL DEFAULT NULL,
  `house_id` int(20) NULL DEFAULT NULL,
  `deal_price` int(20) NULL DEFAULT NULL,
  `purchaser_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `purchaser_sex` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `purchaser_address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `purchaser_phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `purchaser_remark` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `tenancy` timestamp NULL DEFAULT NULL COMMENT '租期到期时间',
  `agreement_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合同协议',
  `ammeter_record_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电表记录',
  `furniture_record_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家具清单',
  `landlordIDcard_copy_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房东身份证复印件',
  `property_copy_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房产证复印件',
  `purchaserIDcard_copy_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '租客身份证复印件',
  `state` int(5) NULL DEFAULT NULL,
  `permit_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for deal_salepreparation
-- ----------------------------
DROP TABLE IF EXISTS `deal_salepreparation`;
CREATE TABLE `deal_salepreparation`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `staff_id` int(20) NULL DEFAULT NULL,
  `house_id` int(20) NULL DEFAULT NULL,
  `deal_price` int(20) NULL DEFAULT NULL,
  `purchaser_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `purchaser_sex` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `purchaser_address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `purchaser_phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `purchaser_remark` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `property_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `purchaserIDcard_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `agreement_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` int(5) NULL DEFAULT NULL,
  `permit_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of deal_salepreparation
-- ----------------------------
INSERT INTO `deal_salepreparation` VALUES (1, 1, 1, 35000, '白咲舞', '女', '广东省广州市番禺区', '2366456', '好想要', 'property_img1.jpg', 'purchaserIDcard_img1.jpg', 'agreement_img1.jpg', 1, '2019-12-16 17:43:01');
INSERT INTO `deal_salepreparation` VALUES (2, 1, 3, 32000, '音阙诗听', '女', '广东省广州市番禺区', '75641', '社保', 'mmexport1574177331688.jpg', 'mmexport1575040351653.jpg', 'IMG_20190928_173102.jpg', 0, NULL);

-- ----------------------------
-- Table structure for estate
-- ----------------------------
DROP TABLE IF EXISTS `estate`;
CREATE TABLE `estate`  (
  `estate_id` int(20) NOT NULL,
  `estate_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `estate_location_province` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省',
  `estate_location_city` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '市',
  `estate_location_district` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区',
  `estate_location_street` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '街',
  `estate_commission` decimal(5, 3) NULL DEFAULT NULL COMMENT '佣金点',
  `estate_rent_commission` decimal(5, 3) NULL DEFAULT NULL COMMENT '租房佣金点',
  `estate_type` int(10) NULL DEFAULT NULL COMMENT '0一手1二手',
  `estate_img_bg` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '搜索页缩略图封面',
  `estate_img_floor` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详情页户型图',
  `upload_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`estate_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of estate
-- ----------------------------
INSERT INTO `estate` VALUES (1, '南天名苑', '广东省', '广州市', '番禺区', '洛溪', 0.015, 0.500, 1, '南天名苑.jpg', '南天名苑户型图A型.jpg', '2014-06-26 00:00:00');
INSERT INTO `estate` VALUES (2, '中海蓝湾', '广东省', '广州市', '番禺区', '洛溪', 0.015, 0.500, 1, '中海蓝湾.jpg', '中海蓝湾户型图A型.jpg', '2004-01-01 00:00:00');
INSERT INTO `estate` VALUES (3, '洛涛南区', '广东省', '广州市', '番禺区', '洛溪', 0.010, 0.350, 1, '洛涛南区.jpg', '洛涛南区户型图A.jpg', '2001-01-01 00:00:00');
INSERT INTO `estate` VALUES (4, '华荟名苑', '广东省', '广州市', '番禺区', '洛溪', 0.010, 0.350, 1, '华荟名苑.jpg', '华荟名苑户型图A.jpg', '2003-01-01 00:00:00');
INSERT INTO `estate` VALUES (5, '锦绣银湾', '广东省', '广州市', '番禺区', '洛溪', 0.010, 0.350, 1, '锦绣银湾.jpg', '锦绣银湾户型图A型.jpg', '2009-01-01 00:00:00');
INSERT INTO `estate` VALUES (6, '星河湾', '广东省', '广州市', '番禺区', '沙溪', 0.015, 0.500, 1, '星河湾.jpg', '星河湾户型图A.jpg', '2000-01-01 00:00:00');
INSERT INTO `estate` VALUES (7, '奥林匹克花园', '广东省', '广州市', '番禺区', '洛溪', 0.010, 0.350, 1, '奥林匹克花园.jpg', '奥林匹克花园户型图A型.jpg', '2000-01-01 00:00:00');
INSERT INTO `estate` VALUES (8, '天上人间', '广东省', '东莞市', '南城区', '西湖路', 0.010, 0.350, 1, '天上人间.jpg', '天上人间A型.jpg', '2008-01-01 00:00:00');
INSERT INTO `estate` VALUES (9, '帝景中央', '广东省', '汕尾市', '城区', '香洲街道', 0.015, 0.500, 1, '帝景中央.jpg', '帝景中央A型.jpg', '2010-01-01 00:00:00');
INSERT INTO `estate` VALUES (10, '景福花园', '广东省', '东莞市', '南城区', '西平', 0.010, 0.350, 1, '景福花园.jpg', '景福花园户型图A型.jpg', '2007-01-01 00:00:00');
INSERT INTO `estate` VALUES (11, '恒大御景', '广东省', '东莞市', '南城区', '白马中心路', 0.015, 0.350, 1, '恒大御景.jpg', '恒大御景户型图A型.jpg', '2016-01-01 00:00:00');
INSERT INTO `estate` VALUES (12, '汉唐蜜园', '广东省', '东莞市', '南城区', '宏图大道', 0.015, 0.350, 1, '汉唐蜜园.jpg', '汉唐蜜园户型图A型.jpg', '2015-01-01 00:00:00');

-- ----------------------------
-- Table structure for house_lease
-- ----------------------------
DROP TABLE IF EXISTS `house_lease`;
CREATE TABLE `house_lease`  (
  `House_lid` int(20) NOT NULL AUTO_INCREMENT,
  `House_lname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `House_lestate` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `House_llocation` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `House_lprice` int(10) NULL DEFAULT NULL,
  `House_lsquare` int(50) NULL DEFAULT NULL,
  `House_lstate` int(2) NULL DEFAULT NULL,
  `House_lclientid` int(20) NULL DEFAULT NULL,
  `Complete_time` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `deal_time` datetime NULL DEFAULT NULL,
  `House_lpurchaser_id` int(20) NULL DEFAULT NULL,
  PRIMARY KEY (`House_lid`) USING BTREE,
  INDEX `House_lclientid`(`House_lclientid`) USING BTREE,
  INDEX `House_lpurchaser_id`(`House_lpurchaser_id`) USING BTREE,
  CONSTRAINT `House_lclientid` FOREIGN KEY (`House_lclientid`) REFERENCES `client_lease` (`Client_lid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `House_lpurchaser_id` FOREIGN KEY (`House_lpurchaser_id`) REFERENCES `client_want_rent` (`Client_wrid`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of house_lease
-- ----------------------------
INSERT INTO `house_lease` VALUES (1, '2栋301', '南天名苑', '广东省广州市番禺区洛溪', 6000, 90, 1, 1, '2012', '2019-12-18 17:22:46', 2);
INSERT INTO `house_lease` VALUES (2, '1栋101', '天上人间', '广东省东莞市南城区西湖路', 2000, 50, 1, 1, '2010', '2019-09-01 00:00:00', 1);
INSERT INTO `house_lease` VALUES (3, '9栋601', '帝景中央', '广东省汕尾市城区', 8000, 200, 0, 1, '2008', NULL, NULL);
INSERT INTO `house_lease` VALUES (4, '3栋203', '星河湾', '广东省广州市番禺区沙溪', 5800, 120, 0, 2, '2003', NULL, NULL);
INSERT INTO `house_lease` VALUES (5, '4栋101', '奥林匹克花园', '广东省广州市番禺区洛溪', 2800, 60, 0, 3, '2003', NULL, NULL);

-- ----------------------------
-- Table structure for house_sale
-- ----------------------------
DROP TABLE IF EXISTS `house_sale`;
CREATE TABLE `house_sale`  (
  `House_sid` int(11) NOT NULL AUTO_INCREMENT,
  `House_sname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `House_sestate` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `House_slocation` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `House_sprice` int(10) NULL DEFAULT NULL,
  `House_ssquare` int(50) NULL DEFAULT NULL,
  `House_sstate` int(10) NULL DEFAULT NULL,
  `House_sclientid` int(25) NULL DEFAULT NULL,
  `Complete_time` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `deal_time` datetime NULL DEFAULT NULL,
  `House_spurchaser_id` int(20) NULL DEFAULT NULL,
  PRIMARY KEY (`House_sid`) USING BTREE,
  INDEX `House_sclientid`(`House_sclientid`) USING BTREE,
  INDEX `House_spurchaser_id`(`House_spurchaser_id`) USING BTREE,
  CONSTRAINT `House_sclientid` FOREIGN KEY (`House_sclientid`) REFERENCES `client_sale` (`Client_sid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `House_spurchaser_id` FOREIGN KEY (`House_spurchaser_id`) REFERENCES `client_want_buy` (`Client_wbid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of house_sale
-- ----------------------------
INSERT INTO `house_sale` VALUES (1, '1栋101', '南天名苑', '广东省广州市番禺区洛溪', 38000, 120, 1, 1, '2012', '2019-12-16 17:43:01', 7);
INSERT INTO `house_sale` VALUES (2, '6栋102', '中海蓝湾', '广东省广州市番禺区洛溪', 35000, 130, 1, 1, '2006', '2019-12-10 00:00:00', 1);
INSERT INTO `house_sale` VALUES (3, '3栋203', '洛涛南区', '广东省广州市番禺区洛溪', 30000, 120, 1, 5, '2003', '2019-12-25 16:14:37', 3);
INSERT INTO `house_sale` VALUES (4, '2栋301', '天上人间', '广东省东莞市南城区西湖路', 25000, 100, 1, 2, '2010', '2018-11-20 00:00:00', 2);
INSERT INTO `house_sale` VALUES (5, '5栋402', '锦绣银湾', '广东省广州市番禺区沙溪', 30000, 130, 0, 1, '2004', NULL, NULL);
INSERT INTO `house_sale` VALUES (6, '1栋103', '华荟名苑', '广东省广州市番禺区洛溪', 32000, 120, 0, 2, '2006', NULL, NULL);
INSERT INTO `house_sale` VALUES (7, '11栋201', '洛涛南区', '广东省广州市番禺区', 30000, 120, 0, 3, '2003', NULL, NULL);
INSERT INTO `house_sale` VALUES (8, '11栋301', '洛涛南区', '广东省广州市番禺区', 36000, 200, 0, 3, '2003', NULL, NULL);
INSERT INTO `house_sale` VALUES (9, '11栋302', '洛涛南区', '广东省广州市番禺区', 36000, 180, 0, 3, '2003', NULL, NULL);
INSERT INTO `house_sale` VALUES (10, '8栋301', '洛涛南区', '广东省广州市番禺区', 40000, 200, 0, 4, '2003', NULL, NULL);

-- ----------------------------
-- Table structure for markets_news
-- ----------------------------
DROP TABLE IF EXISTS `markets_news`;
CREATE TABLE `markets_news`  (
  `Markets_news_id` int(10) NOT NULL AUTO_INCREMENT,
  `Markets_news_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Markets_news_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `Markets_news_staffid` int(20) NULL DEFAULT NULL,
  `publish_time` timestamp NULL DEFAULT NULL,
  `Markets_news_img` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Markets_news_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of markets_news
-- ----------------------------
INSERT INTO `markets_news` VALUES (1, '关于广州新限购政策通知', '我太难了', 1, '2020-02-26 23:10:54', 'MarketsNews1.jpg');
INSERT INTO `markets_news` VALUES (9, '23234', '23412', 7, '2020-03-09 12:14:32', 'MarketsNews9.jpg');

-- ----------------------------
-- Table structure for rentpreparation
-- ----------------------------
DROP TABLE IF EXISTS `rentpreparation`;
CREATE TABLE `rentpreparation`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `staff_id` int(20) NULL DEFAULT NULL,
  `house_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `house_estate` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `house_location` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `house_price` int(10) NULL DEFAULT NULL,
  `house_square` int(20) NULL DEFAULT NULL,
  `house_complete_time` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `house_client_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `house_client_sex` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `house_client_address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `house_client_phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `house_client_remark` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `state` int(5) NULL DEFAULT NULL,
  `permit_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of rentpreparation
-- ----------------------------
INSERT INTO `rentpreparation` VALUES (1, 1, '4栋101', '奥林匹克花园', '广东省广州市番禺区', 2800, 60, '2003', 'Angelic', '女', '广东省广州市番禺区', '12345', '白又白', 1, '2019-12-11 11:26:00');
INSERT INTO `rentpreparation` VALUES (2, 1, '8栋301', '南天名苑', '广东省广州市番禺区', 6700, 120, '2012', 'Boobs', '女', '广东省广州市天河区完平大厦', '23467', '客户很有钱', 0, '0000-00-00 00:00:00');
INSERT INTO `rentpreparation` VALUES (3, 1, '4栋301', '奥林匹克花园', '广东省广州市番禺区', 6300, 120, '2003', 'Angelic', '女', '广东省广州市番禺区', '12345', '白又白', 0, '0000-00-00 00:00:00');
INSERT INTO `rentpreparation` VALUES (4, 1, '5栋201', '南天名苑', '广东省广州市番禺区洛溪新城', 5300, 90, '2012', '味力果', '女', '广东省广州市番禺区', '665', '你好味力果', 0, NULL);

-- ----------------------------
-- Table structure for salary_job
-- ----------------------------
DROP TABLE IF EXISTS `salary_job`;
CREATE TABLE `salary_job`  (
  `salary_job` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位',
  `salary_base` int(20) NULL DEFAULT NULL COMMENT '底薪',
  `salary_bonus` int(20) NULL DEFAULT NULL COMMENT '奖金',
  `salary_leave` int(20) NULL DEFAULT NULL COMMENT '请假扣钱'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of salary_job
-- ----------------------------
INSERT INTO `salary_job` VALUES ('BOSS', 100, 0, 0);
INSERT INTO `salary_job` VALUES ('分行主管', 8000, 1000, 200);
INSERT INTO `salary_job` VALUES ('置业顾问', 2000, 300, 50);
INSERT INTO `salary_job` VALUES ('销售顾问', 2000, 300, 50);
INSERT INTO `salary_job` VALUES ('高级置业顾问', 4500, 500, 120);
INSERT INTO `salary_job` VALUES ('高级销售顾问', 4500, 500, 120);
INSERT INTO `salary_job` VALUES ('分行行政秘书', 3500, 0, 50);
INSERT INTO `salary_job` VALUES ('总部行政秘书', 5000, 0, 50);
INSERT INTO `salary_job` VALUES ('行政秘书长', 18000, 0, 0);

-- ----------------------------
-- Table structure for salepreparation
-- ----------------------------
DROP TABLE IF EXISTS `salepreparation`;
CREATE TABLE `salepreparation`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `staff_id` int(20) NULL DEFAULT NULL,
  `house_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `house_estate` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `house_location` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `house_price` int(10) NULL DEFAULT NULL,
  `house_square` int(20) NULL DEFAULT NULL,
  `house_complete_time` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `house_client_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `house_client_sex` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `house_client_address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `house_client_phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `house_client_remark` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `state` int(5) NULL DEFAULT NULL,
  `permit_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of salepreparation
-- ----------------------------
INSERT INTO `salepreparation` VALUES (1, 1, '11栋201', '洛涛南区', '广东省广州市番禺区', 30000, 120, '2003', 'StellaCox', '女', '广东省广州市番禺区', '666', '谢了兄弟，已经', 1, '2019-12-05 11:26:12');
INSERT INTO `salepreparation` VALUES (2, 1, '8栋301', '洛涛南区', '广东省广州市番禺区', 40000, 200, '2003', 'test2', '女', '广东省广州市天河区完平大厦', '777', '我好了', 1, '2019-12-10 21:51:10');
INSERT INTO `salepreparation` VALUES (3, 1, '11栋301', '洛涛南区', '广东省广州市番禺区', 36000, 200, '2003', 'StellaCox', '女', '广东省广州市番禺区', '666', '谢了兄弟，已经', 1, '2019-12-05 15:32:26');
INSERT INTO `salepreparation` VALUES (4, 1, '11栋302', '洛涛南区', '广东省广州市番禺区', 36000, 180, '2003', 'StellaCox', '女', '广东省广州市番禺区', '666', '谢了兄弟，已经', 1, '2019-12-05 15:37:39');
INSERT INTO `salepreparation` VALUES (5, 1, '1栋101', '洛涛南区', '广东省广州市番禺区', 38000, 140, '2003', 'ALex', '女', '广东省广州市番禺区', '233', '', 0, '0000-00-00 00:00:00');

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff`  (
  `staff_id` int(20) NOT NULL AUTO_INCREMENT,
  `staff_username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `staff_password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `staff_level` int(5) NULL DEFAULT NULL,
  `staff_branch_id` int(20) NULL DEFAULT NULL,
  `staff_job` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `today_serial_id` int(20) NULL DEFAULT NULL,
  `staff_img` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`staff_id`) USING BTREE,
  INDEX `staff_username`(`staff_username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES (1, '松果儿', '123', 1, 1, '置业顾问', NULL, '1松果儿.jpg');
INSERT INTO `staff` VALUES (2, '黄可', '123', 1, 1, '置业顾问', NULL, '2黄可.jpg');
INSERT INTO `staff` VALUES (3, 'Admin', '123', 3, NULL, 'BOSS', NULL, '3Admin.jpg');
INSERT INTO `staff` VALUES (4, '何奕恋', '123', 2, 1, '分行主管', NULL, '4何奕恋.jpg');
INSERT INTO `staff` VALUES (5, '乔柯涵', '123', 2, 2, '分行主管', NULL, '5乔柯涵.jpg');
INSERT INTO `staff` VALUES (6, '赵梦洁', '123', 1, 2, '销售顾问', NULL, '6赵梦洁.jpg');
INSERT INTO `staff` VALUES (7, '杨姗姗', '123', 2, 3, '分行主管', NULL, '7杨姗姗.jpg');
INSERT INTO `staff` VALUES (8, '艾粟粟', '123', 2, 4, '分行主管', NULL, '8艾粟粟.jpg');
INSERT INTO `staff` VALUES (9, '洪世贤', '123', 2, 3, '置业顾问', NULL, '9洪世贤.jpg');
INSERT INTO `staff` VALUES (10, '阿莎', '123', 2, 5, '分行主管', NULL, '10阿莎.jpg');
INSERT INTO `staff` VALUES (11, '麦苹果', '123', 1, 5, '置业顾问', NULL, '11麦苹果.jpg');
INSERT INTO `staff` VALUES (12, 'Ramita', '123', 1, 1, '高级置业顾问', NULL, '12Ramita.jpg');
INSERT INTO `staff` VALUES (13, '金宥熙', '123', 1, 2, '置业顾问', NULL, '13金宥熙.jpg');
INSERT INTO `staff` VALUES (14, '风鹰侠', '123', 1, 2, '高级置业顾问', NULL, '14风鹰侠.jpg');

-- ----------------------------
-- Table structure for staff_sign
-- ----------------------------
DROP TABLE IF EXISTS `staff_sign`;
CREATE TABLE `staff_sign`  (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `staff_id` int(20) NULL DEFAULT NULL,
  `in_time` timestamp NULL DEFAULT NULL,
  `off_time` timestamp NULL DEFAULT NULL,
  `in_state` int(2) NULL DEFAULT NULL COMMENT '0缺勤1正常',
  `off_state` int(2) NULL DEFAULT NULL COMMENT '0缺勤1正常',
  `special_state` int(2) NULL DEFAULT NULL COMMENT '0无1外勤2请假3休假4病假',
  `final_state` int(2) NULL DEFAULT NULL COMMENT '0缺勤1正常',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 59 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of staff_sign
-- ----------------------------
INSERT INTO `staff_sign` VALUES (1, 1, '2019-12-01 00:00:00', '2019-12-01 00:00:00', 1, 1, 3, 1);
INSERT INTO `staff_sign` VALUES (2, 1, '2019-12-02 09:01:00', '2019-12-02 18:01:00', 0, 1, NULL, 0);
INSERT INTO `staff_sign` VALUES (3, 1, '2019-12-03 09:00:00', '2019-12-03 18:01:00', 1, 1, NULL, 1);
INSERT INTO `staff_sign` VALUES (4, 1, '2019-12-04 09:00:00', '2019-12-04 18:01:00', 1, 1, NULL, 1);
INSERT INTO `staff_sign` VALUES (5, 1, '2019-12-05 09:00:00', '2019-12-05 18:01:00', 1, 1, NULL, 1);
INSERT INTO `staff_sign` VALUES (6, 1, '2019-12-06 09:00:00', '2019-12-06 18:01:00', 1, 1, NULL, 1);
INSERT INTO `staff_sign` VALUES (7, 1, '2019-12-07 00:00:00', '2019-12-07 00:00:00', 1, 1, 3, 1);
INSERT INTO `staff_sign` VALUES (8, 1, '2019-12-08 00:00:00', '2019-12-08 00:00:00', 1, 1, 3, 1);
INSERT INTO `staff_sign` VALUES (9, 1, '2019-12-09 09:00:00', '2019-12-09 18:01:00', 1, 1, NULL, 1);
INSERT INTO `staff_sign` VALUES (10, 1, '2019-12-10 09:00:00', '2019-12-10 18:01:00', 1, 1, NULL, 1);
INSERT INTO `staff_sign` VALUES (11, 1, '2019-12-11 09:00:00', '2019-12-11 18:01:00', 1, 1, NULL, 1);
INSERT INTO `staff_sign` VALUES (12, 1, '2019-12-12 09:00:00', '2019-12-12 18:01:00', 1, 1, NULL, 1);
INSERT INTO `staff_sign` VALUES (13, 1, '2019-12-13 09:00:00', '2019-12-13 18:01:00', 1, 1, NULL, 1);
INSERT INTO `staff_sign` VALUES (14, 1, '2019-12-14 09:00:00', '2019-12-14 00:00:00', 1, 1, 3, 1);
INSERT INTO `staff_sign` VALUES (15, 1, '2019-12-15 09:00:00', '2019-12-15 00:00:00', 1, 1, 3, 1);
INSERT INTO `staff_sign` VALUES (16, 1, '2019-12-16 09:00:00', '2019-12-16 18:01:00', 1, 1, NULL, 1);
INSERT INTO `staff_sign` VALUES (17, 1, '2019-12-17 09:00:00', '2019-12-17 18:01:00', 1, 1, NULL, 1);
INSERT INTO `staff_sign` VALUES (18, 1, '2019-12-18 09:00:00', '2019-12-18 18:01:00', 1, 1, NULL, 1);
INSERT INTO `staff_sign` VALUES (19, 1, '2019-12-19 09:00:00', '2019-12-19 18:01:00', 1, 1, NULL, 1);
INSERT INTO `staff_sign` VALUES (20, 1, '2019-12-20 09:00:00', '2019-12-20 18:01:00', 1, 1, NULL, 1);
INSERT INTO `staff_sign` VALUES (21, 1, '2019-12-21 09:00:00', '2019-12-21 00:00:00', 1, 1, 3, 1);
INSERT INTO `staff_sign` VALUES (22, 1, '2019-12-22 09:00:00', '2019-12-22 00:00:00', 1, 1, 3, 1);
INSERT INTO `staff_sign` VALUES (23, 1, '2019-12-23 09:00:00', '2019-12-23 18:01:00', 1, 1, NULL, 1);
INSERT INTO `staff_sign` VALUES (24, 1, '2019-12-24 09:00:00', '2019-12-24 18:01:00', 1, 1, NULL, 1);
INSERT INTO `staff_sign` VALUES (25, 2, '2019-12-02 08:59:00', '2019-12-02 18:01:00', 1, 1, NULL, 1);
INSERT INTO `staff_sign` VALUES (26, 2, '2019-12-24 00:00:00', '2019-12-24 00:00:00', NULL, NULL, NULL, 0);
INSERT INTO `staff_sign` VALUES (27, 3, '2019-12-24 00:00:00', '2019-12-24 00:00:00', NULL, NULL, NULL, 0);
INSERT INTO `staff_sign` VALUES (28, 4, '2019-12-24 00:00:00', '2019-12-24 00:00:00', NULL, NULL, NULL, 0);
INSERT INTO `staff_sign` VALUES (29, 5, '2019-12-24 00:00:00', '2019-12-24 00:00:00', NULL, NULL, NULL, 0);
INSERT INTO `staff_sign` VALUES (30, 6, '2019-12-24 00:00:00', '2019-12-24 00:00:00', NULL, NULL, NULL, 0);
INSERT INTO `staff_sign` VALUES (31, 7, '2019-12-24 00:00:00', '2019-12-24 00:00:00', NULL, NULL, NULL, 0);
INSERT INTO `staff_sign` VALUES (32, 8, '2019-12-24 00:00:00', '2019-12-24 00:00:00', NULL, NULL, NULL, 0);
INSERT INTO `staff_sign` VALUES (33, 1, '2019-12-25 08:59:28', '2019-12-25 18:01:48', 1, 1, NULL, 1);
INSERT INTO `staff_sign` VALUES (34, 1, '2019-12-27 00:00:00', '2019-12-27 00:00:00', NULL, NULL, NULL, 0);
INSERT INTO `staff_sign` VALUES (35, 2, '2019-12-27 00:00:00', '2019-12-27 00:00:00', NULL, NULL, NULL, 0);
INSERT INTO `staff_sign` VALUES (36, 3, '2019-12-27 00:00:00', '2019-12-27 00:00:00', NULL, NULL, NULL, 0);
INSERT INTO `staff_sign` VALUES (37, 4, '2019-12-27 00:00:00', '2019-12-27 00:00:00', NULL, NULL, NULL, 0);
INSERT INTO `staff_sign` VALUES (38, 5, '2019-12-27 00:00:00', '2019-12-27 00:00:00', NULL, NULL, NULL, 0);
INSERT INTO `staff_sign` VALUES (39, 6, '2019-12-27 00:00:00', '2019-12-27 00:00:00', NULL, NULL, NULL, 0);
INSERT INTO `staff_sign` VALUES (40, 7, '2019-12-27 00:00:00', '2019-12-27 00:00:00', NULL, NULL, NULL, 0);
INSERT INTO `staff_sign` VALUES (41, 8, '2019-12-27 00:00:00', '2019-12-27 00:00:00', NULL, NULL, NULL, 0);
INSERT INTO `staff_sign` VALUES (42, 1, '2019-12-31 09:00:00', NULL, 1, NULL, 2, 0);
INSERT INTO `staff_sign` VALUES (43, 1, '2020-01-01 09:00:00', NULL, 1, NULL, 2, 0);
INSERT INTO `staff_sign` VALUES (44, 1, '2020-01-02 09:00:00', NULL, 1, NULL, 2, 0);
INSERT INTO `staff_sign` VALUES (45, 1, '2020-02-15 00:00:00', '2020-02-15 00:00:00', 1, 1, 3, 1);
INSERT INTO `staff_sign` VALUES (46, 1, '2020-02-28 09:00:00', '2020-02-28 18:30:00', 1, 1, NULL, 0);
INSERT INTO `staff_sign` VALUES (47, 1, '0000-00-00 00:00:00', '2020-03-01 18:00:00', NULL, 1, NULL, NULL);
INSERT INTO `staff_sign` VALUES (48, 1, '0000-00-00 00:00:00', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `staff_sign` VALUES (49, 1, '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL, NULL, NULL, NULL);
INSERT INTO `staff_sign` VALUES (50, 1, '2020-03-01 09:00:00', '2020-03-01 12:00:00', 1, 1, 1, 1);
INSERT INTO `staff_sign` VALUES (51, 10, '2019-12-27 09:00:00', '2020-04-22 18:09:35', 1, 1, NULL, 1);
INSERT INTO `staff_sign` VALUES (52, 9, '2020-04-24 00:00:00', '2020-04-24 00:00:00', NULL, NULL, NULL, 0);
INSERT INTO `staff_sign` VALUES (53, 10, '2020-04-24 00:00:00', '2020-04-24 00:00:00', NULL, NULL, NULL, 0);
INSERT INTO `staff_sign` VALUES (54, 11, '2020-04-24 00:00:00', '2020-04-24 00:00:00', NULL, NULL, NULL, 0);
INSERT INTO `staff_sign` VALUES (55, 12, '2020-04-24 00:00:00', '2020-04-24 00:00:00', NULL, NULL, NULL, 0);
INSERT INTO `staff_sign` VALUES (56, 13, '2020-04-24 00:00:00', '2020-04-24 00:00:00', NULL, NULL, NULL, 0);
INSERT INTO `staff_sign` VALUES (57, 14, '2020-04-24 00:00:00', '2020-04-24 00:00:00', NULL, NULL, NULL, 0);

-- ----------------------------
-- Event structure for insert_not_sign_staff
-- ----------------------------
DROP EVENT IF EXISTS `insert_not_sign_staff`;
delimiter ;;
CREATE DEFINER = `root`@`localhost` EVENT `insert_not_sign_staff`
ON SCHEDULE
EVERY '1' DAY STARTS '2019-12-18 23:30:00'
DO replace into staff_sign(in_time,off_time,final_state,staff_id) 
	select DATE_FORMAT(now(),'%Y-%m-%d'),DATE_FORMAT(now(),'%Y-%m-%d'),0,staff_id from staff where staff_id not IN(select staff_id from staff_sign where DATE_FORMAT(in_time,'%d') =DATE_FORMAT(now(),'%d') and DATE_FORMAT(off_time,'%d') =DATE_FORMAT(now(),'%d'))
;;
delimiter ;

-- ----------------------------
-- Event structure for update_house_lease_stateByTenancy
-- ----------------------------
DROP EVENT IF EXISTS `update_house_lease_stateByTenancy`;
delimiter ;;
CREATE DEFINER = `root`@`localhost` EVENT `update_house_lease_stateByTenancy`
ON SCHEDULE
EVERY '1' DAY STARTS '2019-12-18 00:00:00'
ON COMPLETION PRESERVE
DO update house_lease set House_lstate=0,House_lpurchaser_id=null where House_lid in(select house_id from deal_rentpreparation where tenancy<=NOW())
;;
delimiter ;

-- ----------------------------
-- Event structure for update_staff_sign_setState3_Saturday
-- ----------------------------
DROP EVENT IF EXISTS `update_staff_sign_setState3_Saturday`;
delimiter ;;
CREATE DEFINER = `root`@`localhost` EVENT `update_staff_sign_setState3_Saturday`
ON SCHEDULE
EVERY '1' WEEK STARTS '2019-12-01 21:00:00'
DO update staff_sign set special_state=3 where DATE_FORMAT(in_time,'%w') =6
;;
delimiter ;

-- ----------------------------
-- Event structure for update_staff_sign_setState3_Sunday
-- ----------------------------
DROP EVENT IF EXISTS `update_staff_sign_setState3_Sunday`;
delimiter ;;
CREATE DEFINER = `root`@`localhost` EVENT `update_staff_sign_setState3_Sunday`
ON SCHEDULE
EVERY '1' WEEK STARTS '2019-12-01 21:00:00'
DO update staff_sign set special_state=3 where DATE_FORMAT(in_time,'%w') =0
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
